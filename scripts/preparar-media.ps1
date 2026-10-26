param([Parameter(Mandatory=$true)][string]$Video,[string]$Ffmpeg='ffmpeg')
$ErrorActionPreference='Stop'
$root=Split-Path $PSScriptRoot -Parent
$inputVideo=(Resolve-Path -LiteralPath $Video).Path
$assets=Join-Path $root 'launcher/app/src/main/assets'
New-Item -ItemType Directory -Path $assets -Force | Out-Null
& $Ffmpeg -hide_banner -loglevel error -i $inputVideo -map_metadata -1 -map_chapters -1 -an -vf 'scale=1280:720,fps=30,format=yuv420p' -c:v libx264 -preset fast -crf 24 -maxrate 1800k -bufsize 3600k -movflags +faststart -y (Join-Path $assets 'video3.mp4')
if($LASTEXITCODE -ne 0){throw 'No se pudo preparar el video'}
& $Ffmpeg -hide_banner -loglevel error -ss 2 -i (Join-Path $assets 'video3.mp4') -frames:v 1 -y (Join-Path $assets 'video3-poster.jpg')
if($LASTEXITCODE -ne 0){throw 'No se pudo preparar el poster'}
