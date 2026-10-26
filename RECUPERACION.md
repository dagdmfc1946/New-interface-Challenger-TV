# Recuperación y reversión

El respaldo inicial es un inventario y una copia de ajustes consultables mediante ADB. **No es una imagen del firmware**, no contiene datos privados de apps ni garantiza rescatar un TV que no arranque. Se guarda fuera del repositorio publicable.

La propuesta no desinstala ni desactiva el launcher original. Su componente observado es `com.google.android.apps.tv.launcherx/.home.HomeActivity`. La candidata usa `local.challenger.home/com.gathin.tvhome.MainActivity`.

## Sin cambiar el inicio todavía

Google TV sigue siendo el HOME efectivo del sistema. El asistente opcional redirige su pantalla de inicio a la candidata. Si el asistente no está activo, HOME abre Google TV.

## Tras activar la candidata

1. Si puedes abrir la configuración original, busca la selección de aplicación de inicio cuando el firmware la ofrezca y selecciona Google TV.
2. Si no existe ese panel, conecta el PC y el TV a la misma red, autoriza ADB y ejecuta:

```powershell
./scripts/restaurar-inicio.ps1 -TvHost '<ip-del-tv>' -Adb 'adb'
```

El script desactiva únicamente el asistente HOME de esta app, conserva otros servicios de accesibilidad, selecciona Google TV y comprueba la respuesta; no aplica el inventario completo de ajustes ni habilita paquetes indiscriminadamente. Si ADB no responde, verifica la IP y la autorización en pantalla. No uses root, flasheo, menús de fábrica ni un restablecimiento de fábrica como primera respuesta.

La app candidata puede quedar instalada para abrirla manualmente. No se toca la sesión de las apps ni los canales guardados. Conserva la clave de firma propia en privado si deseas actualizarla sin perder preferencias.

## Activar o desactivar la redirección

`scripts/asistente-home.ps1` añade solo el servicio de esta app a la lista existente. Con `-Desactivar` lo retira y conserva los demás servicios. Si no queda ningún servicio, apaga el indicador global de accesibilidad. No concede permisos de ubicación ni de escritura de ajustes seguros a la app. No borra datos ni desinstala paquetes.

Si el asistente deja de funcionar por una detención forzada, HOME vuelve a Google TV y puedes seguir utilizando el TV. Abre TVHome desde las aplicaciones y reactiva el asistente desde el PC si fuera necesario. No se activa una reparación automática de servicios que ignore una desactivación del usuario.
