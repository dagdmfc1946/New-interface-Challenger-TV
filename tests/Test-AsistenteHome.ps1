$ErrorActionPreference='Stop'
$global:MockServices='org.example.reader/.ReaderService'
$global:MockAccessibility='1'
$global:MockLaunches=0
function Mock-Adb {
 param([string]$s,[Parameter(ValueFromRemainingArguments=$true)][string[]]$Rest)
 $global:LASTEXITCODE=0
 if($s -eq 'connect'){return 'offline test'}
 if($Rest[0] -eq 'shell' -and $Rest[1] -eq 'am'){$global:MockLaunches++;return 'Status: ok'}
 if($Rest[0] -ne 'shell' -or $Rest[1] -ne 'settings'){throw 'Unexpected mock command'}
 $verb=$Rest[4]; $key=$Rest[6]
 if($verb -eq 'get'){if($key -eq 'enabled_accessibility_services'){return $global:MockServices};return $global:MockAccessibility}
 if($verb -eq 'put'){if($key -eq 'enabled_accessibility_services'){$global:MockServices=$Rest[7]}else{$global:MockAccessibility=$Rest[7]};return}
 if($verb -eq 'delete'){$global:MockServices='null';return 'Deleted 1 rows'}
 throw 'Unexpected mock verb'
}
$script=Join-Path (Split-Path $PSScriptRoot -Parent) 'scripts/asistente-home.ps1'
& $script -TvHost 'offline' -Adb 'Mock-Adb' | Out-Null
if($global:MockLaunches -ne 1){throw 'La activación debe abrir el inicio para no esperar un evento de ventana ya visible'}
if($global:MockServices -ne 'org.example.reader/.ReaderService:local.challenger.home/com.gathin.tvhome.HomeKeyService'){throw 'No conserva el servicio previo'}
& $script -TvHost 'offline' -Adb 'Mock-Adb' | Out-Null
if(($global:MockServices.Split(':') | Where-Object {$_ -eq 'local.challenger.home/com.gathin.tvhome.HomeKeyService'}).Count -ne 1){throw 'Duplicación'}
& $script -TvHost 'offline' -Adb 'Mock-Adb' -Desactivar | Out-Null
if($global:MockServices -ne 'org.example.reader/.ReaderService' -or $global:MockAccessibility -ne '1'){throw 'No conserva otros servicios al desactivar'}
$global:MockServices='null';$global:MockAccessibility='0'
& $script -TvHost 'offline' -Adb 'Mock-Adb' | Out-Null
& $script -TvHost 'offline' -Adb 'Mock-Adb' -Desactivar | Out-Null
if($global:MockServices -ne 'null' -or $global:MockAccessibility -ne '0'){throw 'No revierte lista vacía'}
Write-Output '4 escenarios simulados correctos: conservar otros servicios, activación idempotente, desactivar preservando otros y reversión sin otros servicios. Sin conexión al TV.'
