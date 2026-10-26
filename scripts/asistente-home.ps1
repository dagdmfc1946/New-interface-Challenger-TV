param([Parameter(Mandatory=$true)][string]$TvHost,[string]$Adb='adb',[switch]$Desactivar)
$ErrorActionPreference='Stop'
$serial="${TvHost}:5555"
$service='local.challenger.home/com.gathin.tvhome.HomeKeyService'
function Invoke-AdbShell([string[]]$ShellArgs) {
    $result=(& $Adb -s $serial shell @ShellArgs) -join "`n"
    if($LASTEXITCODE -ne 0){throw 'Error ADB al configurar el asistente; conservar Google TV'}
    return $result.Trim()
}
& $Adb connect $serial
if($LASTEXITCODE -ne 0){throw 'Sin conexión ADB'}
$previous=Invoke-AdbShell @('settings','--user','0','get','secure','enabled_accessibility_services')
$others=@()
if($previous -and $previous -ne 'null'){
    foreach($entry in $previous.Split(':')){
        if($entry -notmatch '^[A-Za-z0-9_.]+/[A-Za-z0-9_.$]+$'){throw 'Lista de servicios no reconocida; no se modifica'}
        if($entry -ne $service -and $entry -ne 'local.challenger.home/.HomeKeyService'){$others+=$entry}
    }
}
if($Desactivar){
    if($others.Count){Invoke-AdbShell @('settings','--user','0','put','secure','enabled_accessibility_services',($others -join ':')) | Out-Null}
    else{
        Invoke-AdbShell @('settings','--user','0','delete','secure','enabled_accessibility_services') | Out-Null
        Invoke-AdbShell @('settings','--user','0','put','secure','accessibility_enabled','0') | Out-Null
    }
}else{
    $enabled=(@($others)+@($service)) -join ':'
    Invoke-AdbShell @('settings','--user','0','put','secure','enabled_accessibility_services',$enabled) | Out-Null
    Invoke-AdbShell @('settings','--user','0','put','secure','accessibility_enabled','1') | Out-Null
}
$observed=Invoke-AdbShell @('settings','--user','0','get','secure','enabled_accessibility_services')
$present=@($observed.Split(':')) -contains $service
if(($Desactivar -and $present) -or (-not $Desactivar -and -not $present)){throw 'No se confirmó el estado solicitado del asistente'}
if($Desactivar){Write-Output 'Asistente HOME desactivado; otros servicios conservados.'}
else{
    # Google TV may already be visible when the service binds: HOME alone then emits no window change.
    $launch=Invoke-AdbShell @('am','start','-W','-n','local.challenger.home/com.gathin.tvhome.MainActivity')
    if($launch -notmatch 'Status: ok'){throw 'Asistente habilitado, pero no se confirmó apertura; usar restaurar-inicio.ps1'}
    Write-Output 'Asistente HOME habilitado y nueva interfaz abierta. No se concedieron ubicación ni escritura de ajustes seguros a la app.'
}
