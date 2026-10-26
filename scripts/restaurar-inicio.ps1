param([Parameter(Mandatory=$true)][string]$TvHost,[string]$Adb='adb')
$ErrorActionPreference='Stop'
$serial="${TvHost}:5555"
& $Adb connect $serial
if($LASTEXITCODE -ne 0){throw 'Sin conexión ADB'}
& $Adb -s $serial shell 'cmd package set-home-activity --user 0 com.google.android.apps.tv.launcherx/.home.HomeActivity'
if($LASTEXITCODE -ne 0){throw 'No se pudo restaurar HOME'}
& $Adb -s $serial shell 'input keyevent KEYCODE_HOME'
$resolvedHome=(& $Adb -s $serial shell 'cmd package resolve-activity --brief -a android.intent.action.MAIN -c android.intent.category.HOME') -join "`n"
if($LASTEXITCODE -ne 0 -or $resolvedHome -notmatch 'com.google.android.apps.tv.launcherx/'){throw 'HOME original no confirmado; conservar ADB para revisar'}
Write-Output 'Inicio original confirmado. No se modificaron paquetes ni datos.'
