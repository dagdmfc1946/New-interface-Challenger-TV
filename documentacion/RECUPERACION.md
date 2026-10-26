# Recuperación y reversión a Google TV

[Guía del repositorio](GUIA_REPOSITORIO.md) · [Asistente HOME](ASISTENTE_HOME.md) · [Alcance del respaldo](respaldo/README.md)

El respaldo inicial es inventario y copia de ajustes consultables por ADB. **No es una imagen del firmware, no contiene sesiones privadas de apps y no garantiza rescatar un TV que no arranque.** El original y sus claves están fuera del repositorio.

## Estado que se revierte

Google TV continúa instalado, habilitado y como HOME efectivo. La nueva interfaz aparece mediante HomeKeyService. Por ello **seleccionar Google TV como predeterminado sin desactivar el asistente puede no bastar**: primero hay que retirar la redirección.

Componentes observados:

- Google TV: `com.google.android.apps.tv.launcherx/.home.HomeActivity`.
- Adaptación: `local.challenger.home/com.gathin.tvhome.MainActivity`.
- Servicio: `local.challenger.home/com.gathin.tvhome.HomeKeyService`.

## Desde el mando

1. Abrir Ajustes originales desde el engranaje de la interfaz.
2. Buscar accesibilidad y desactivar el servicio **Botón Inicio** de la app; el nombre puede variar con el idioma.
3. Pulsar HOME y comprobar que se muestra Google TV. Si el firmware ofrece un selector de inicio y fuese necesario, elegir Google TV.

No borres datos, canales ni cuentas. Si el panel requiere verificación del perfil, hazla personalmente sin compartir PIN ni contraseñas.

## Desde el PC autorizado

Ejecutar desde la **raíz del repositorio**, con TV y PC en la misma red y ADB autorizado:

```powershell
./scripts/restaurar-inicio.ps1 -TvHost '<ip-del-tv>' -Adb 'adb'
```

El [script de recuperación](../scripts/restaurar-inicio.ps1) retira solo el asistente de esta app, preserva otros servicios de accesibilidad, selecciona el HOME original y comprueba la respuesta. No aplica todos los ajustes del inventario ni habilita paquetes indiscriminadamente. Si ADB no responde, verifica encendido, IP actual, depuración y autorización de tu PC.

Para desactivar solo el asistente:

```powershell
./scripts/asistente-home.ps1 -TvHost '<ip-del-tv>' -Adb 'adb' -Desactivar
```

Si no quedan servicios de accesibilidad en la lista, el script apaga el indicador global; si quedan otros, los conserva. La recuperación mediante desactivación se comprobó en este TV. La ruta gráfica concreta aún debe repetirse con el mando real.

## Volver a usar la interfaz

Solo si deseas reactivar el permiso de accesibilidad descrito en [Asistente HOME](ASISTENTE_HOME.md):

```powershell
./scripts/asistente-home.ps1 -TvHost '<ip-del-tv>' -Adb 'adb'
```

La activación abre la nueva interfaz para que la siguiente pulsación HOME produzca un cambio de ventana observable. Después comprueba HOME desde una app. El script no concede ubicación ni escritura de ajustes seguros a la app.

Una detención forzada puede deshabilitar el servicio hasta reactivarlo. La app puede seguir instalada para abrirla manualmente desde las aplicaciones; no se activa reparación automática que ignore una desactivación del usuario. Conserva la clave de firma en privado para futuras actualizaciones sin perder preferencias.

Si una actualización del TV cambia este comportamiento, vuelve al inicio original y revisa compatibilidad antes de aplicar más comandos. No recurras a root, flasheo, menús de fábrica ni restablecimiento de fábrica como primera respuesta a una regresión del launcher.
