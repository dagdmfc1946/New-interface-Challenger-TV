# Recuperación y reversión

El respaldo inicial es un inventario y una copia de ajustes consultables mediante ADB. **No es una imagen del firmware**, no contiene datos privados de apps ni garantiza rescatar un TV que no arranque. Se guarda fuera del repositorio publicable.

La propuesta no desinstala ni desactiva el launcher original. Su componente observado es `com.google.android.apps.tv.launcherx/.home.HomeActivity`. La candidata usa `local.challenger.home/com.gathin.tvhome.MainActivity`.

## Sin cambiar el inicio todavía

Este es el estado al preparar la candidata. No hace falta restaurar nada: las apps temporales se retiraron y HOME sigue siendo Google TV.

## Tras activar la candidata

1. Si puedes abrir la configuración original, busca la selección de aplicación de inicio cuando el firmware la ofrezca y selecciona Google TV.
2. Si no existe ese panel, conecta el PC y el TV a la misma red, autoriza ADB y ejecuta:

```powershell
./scripts/restaurar-inicio.ps1 -TvHost '<ip-del-tv>' -Adb 'adb'
```

El script solo cambia HOME y comprueba la respuesta; no aplica el inventario completo de ajustes ni habilita paquetes indiscriminadamente. Si ADB no responde, verifica la IP y la autorización en pantalla. No uses root, flasheo, menús de fábrica ni un restablecimiento de fábrica como primera respuesta.

La app candidata puede quedar instalada para abrirla manualmente. No se toca la sesión de las apps ni los canales guardados. Conserva la clave de firma propia en privado si deseas actualizarla sin perder preferencias.
