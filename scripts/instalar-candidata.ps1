param([Parameter(Mandatory=$true)][string]$TvHost,[string]$Adb='adb',[switch]$Activar)
$ErrorActionPreference='Stop'
$root=Split-Path $PSScriptRoot -Parent
$apk=Join-Path $root 'launcher/app/build/outputs/apk/release/app-release.apk'
if(-not(Test-Path -LiteralPath $apk)){throw 'Compila y comprueba la candidata antes de instalar'}
$serial="${TvHost}:5555"
& $Adb connect $serial
if($LASTEXITCODE -ne 0){throw 'Sin conexión ADB'}
& $Adb -s $serial install -r $apk
if($LASTEXITCODE -ne 0){throw 'Instalación fallida; HOME original se conserva'}
$start=(& $Adb -s $serial shell 'am start -W -n local.challenger.home/com.gathin.tvhome.MainActivity') -join "`n"
if($LASTEXITCODE -ne 0 -or $start -notmatch 'Status: ok' -or $start -match '(?m)^Error'){throw 'La candidata no abrió; no activar HOME'}
if($Activar){
    # This firmware prioritizes Google TV as HOME. Keep it enabled and use the opt-in helper.
    & (Join-Path $PSScriptRoot 'asistente-home.ps1') -TvHost $TvHost -Adb $Adb
    Start-Sleep -Seconds 2
    & $Adb -s $serial shell 'input keyevent KEYCODE_HOME'
    Start-Sleep -Seconds 2
    $resolvedHome=(& $Adb -s $serial shell 'cmd package resolve-activity --brief -a android.intent.action.MAIN -c android.intent.category.HOME') -join "`n"
    $activity=(& $Adb -s $serial shell 'dumpsys activity activities') -join "`n"
    if($resolvedHome -notmatch '(com.google.android.apps.tv.launcherx|local.challenger.home)/' -or $activity -notmatch '(topResumedActivity|mResumedActivity|mFocusedApp)[^\r\n]*local.challenger.home/'){& (Join-Path $PSScriptRoot 'restaurar-inicio.ps1') -TvHost $TvHost -Adb $Adb;throw 'No se confirmó HOME visible de la candidata; se solicitó restauración'}
}
Write-Output 'Google TV sigue instalado y habilitado. Falta verificar los botones reales, voz, TDT, HDMI y salvapantallas.'
