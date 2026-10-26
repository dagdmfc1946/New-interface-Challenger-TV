param([Parameter(Mandatory=$true)][string]$SdkRoot,[Parameter(Mandatory=$true)][string]$JdkRoot)
$ErrorActionPreference='Stop'
$root=Split-Path $PSScriptRoot -Parent
$env:JAVA_HOME=(Resolve-Path -LiteralPath $JdkRoot).Path
$sdk=(Resolve-Path -LiteralPath $SdkRoot).Path -replace '\\','/'
"sdk.dir=$sdk" | Set-Content -LiteralPath (Join-Path $root 'launcher/local.properties') -Encoding ascii
& (Join-Path $root 'launcher/gradlew.bat') -p (Join-Path $root 'launcher') testReleaseUnitTest lintRelease assembleRelease --no-daemon --console=plain
if($LASTEXITCODE -ne 0){throw 'La compilación/comprobación no terminó; no instalar.'}
