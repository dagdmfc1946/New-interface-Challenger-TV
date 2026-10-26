# Asistente de HOME: alcance, seguridad y operación

El firmware mantiene Google TV como HOME efectivo, aun al seleccionar otra app mediante los mecanismos estándar de Android. Esta adaptación conserva Google TV habilitado y utiliza un asistente de accesibilidad para redirigir su actividad HOME. La activación fue autorizada explícitamente por el propietario después de explicar alcance y limitaciones.

## Qué hace esta versión

`HomeKeyService` recibe únicamente `TYPE_WINDOW_STATE_CHANGED` del paquete de Google TV. Si el nombre de clase corresponde a una actividad HOME registrada por ese paquete, abre la nueva interfaz. No se instala un firmware ni se desactiva un paquete del sistema. Puede verse un breve paso por Google TV.

La configuración declara `canRetrieveWindowContent=false` y `canRequestFilterKeyEvents=false`; no activa gestos, capturas ni filtrado de teclas. El código no consulta nodos, texto o contraseñas de esas ventanas ni transmite los eventos a Internet. El servicio inicial enlazado en el TV mostró `capabilities=0` y solo cambios de ventana. El permiso `BIND_ACCESSIBILITY_SERVICE` del manifiesto restringe su enlace al sistema.

Android distingue las capacidades para consultar la jerarquía de pantalla y los tipos de evento recibidos: [documentación oficial](https://developer.android.com/guide/topics/ui/accessibility/service). Una configuración limitada no convierte accesibilidad en un permiso inocuo: el servicio permanece en segundo plano y puede abrir la interfaz. Deben mantenerse controladas las versiones que se instalan; no se afirma que una app de terceros con ese permiso tenga el mismo alcance.

## Implicaciones de funcionamiento

- El objetivo es cambiar el destino práctico de HOME; el HOME de sistema sigue siendo Google TV.
- Se conservan apps, cuentas, TDT, HDMI, voz, mando y salvapantallas. Su comprobación física está en CHECKLIST_VALIDACION.md.
- Un error podría producir retornos no deseados al inicio o dejar de redirigir. Ante una regresión, desactivar el asistente y conservar Google TV como ruta de recuperación.
- Se espera una carga pequeña por los eventos limitados, pero se documentan mediciones reales y no una garantía de consumo nulo.
- El fondo del launcher se libera al abandonar su actividad; el servicio de HOME permanece a la espera de eventos.
- Una detención forzada del launcher puede deshabilitar su servicio hasta reactivarlo. No se concedió a la app permiso para reactivarse alterando ajustes seguros ni se habilitó reparación automática.
- El arranque, la suspensión, el mando real y los dos días de uso son verificaciones adicionales a las pruebas ADB.

## Desactivación y reversión

Usar los ajustes de accesibilidad del TV para desactivar «Botón Inicio», o ejecutar `scripts/asistente-home.ps1 -TvHost '<ip-del-tv>' -Desactivar`. `scripts/restaurar-inicio.ps1` también desactiva ese asistente y selecciona el inicio original. Los scripts conservan otros servicios de accesibilidad y no borran datos.

No se publica el listado privado de ajustes del dispositivo, sus cuentas ni las capturas personalizadas. La documentación de rendimiento contiene solo resultados agregados.

## Activación cuando Google TV ya está visible

Con el filtrado de teclas desactivado, el servicio necesita un cambio de ventana. Si se habilita estando ya en la pantalla HOME de Google TV, repetir HOME puede no producir ese evento. Por eso el script abre primero la nueva interfaz tras habilitar el servicio. Desde ella, la próxima pulsación HOME cambia a Google TV y se redirige. No se habilita el filtrado de teclas para resolver ese caso. La detención forzada sigue siendo una condición de recuperación documentada.
