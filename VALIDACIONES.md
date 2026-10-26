# Validaciones: realizadas y pendientes

## Realizadas en el TV

Android TV 11 en Challenger 32KG84 BT T2. Se usó una app temporal independiente, sin HOME ni permisos; se retiró al cerrar los ensayos. La comparación mide el renderizador, no el launcher integrado. Datos de CPU normalizados a todos los núcleos; medianas de cinco muestras de unos diez segundos en dos rondas por escenario.

| Escenario | CPU total mediana | Resultado |
|---|---:|---|
| Inicio Google observado | 16,39 % | Referencia aparte, no garantía de mejora |
| Imagen estática digital | 1,57 % | Sin cuadros lentos de interfaz observados |
| Corriente suave (~15 fps) | 5,13 % | Sin cuadros lentos de interfaz observados |
| Opción 3, 720p/30 | 7,75 % | Decodificador Realtek; sin cuadros de reproducción perdidos en contadores disponibles |
| Nuevo video descartado para uso principal | 8,08 % | 0/5.107 cuadros de video perdidos; 3/72 cuadros lentos de interfaz |

La opción 1 se descartó por apariencia; la 5 no se probó en el TV. No se atribuye una mejora al video nuevo frente a opción 3. Los contadores de video no equivalen a latencia del mando o a cuadros lentos de interfaz. PSS de la app excluye parte de buffers/servicios nativos del video. Son sesiones cortas, no un ensayo térmico prolongado.

Se verificó el resaltado único en YouTube, Xuper, Prime Video y Netflix navegando a izquierda/derecha. Se preservaron HOME, lista de paquetes deshabilitados y ajustes de voz, accesibilidad y salvapantallas. Los crudos, capturas privadas y APK extraídos no se incluyen en este paquete.

## Candidata integrada en el PC

La candidata se somete a `testReleaseUnitTest`, `lintRelease` y `assembleRelease`. El resumen exacto se genera en `VERIFICACION_COMPILACION.json`. El parser deportivo tiene casos de prueba para zona horaria, fechas inválidas, encuentros pasados y equipos incorrectos. La base upstream conserva sus pruebas.

Resultado local: **263 pruebas en 41 suites, 0 fallos, 0 errores y 0 omitidas**. Lint: **0 errores y 91 advertencias**; no se añadieron supresiones ni se rebajaron umbrales. La compilación release terminó correctamente; el tamaño y SHA256 del APK actualizado constan en `VERIFICACION_COMPILACION.json`. Incluye el video, a diferencia del launcher upstream de fondos estáticos. El informe HTML de lint se conserva en el build local. Esta aprobación del compilador no equivale a validación funcional del TV.

El permiso de Internet se añade solo para la agenda deportiva, con lectura limitada a 1 MB, timeouts de ocho segundos, sin redirecciones automáticas ni sondeo continuo. No es una fuente en tiempo real garantizada; si cambia el formato deja de afirmar una fecha y mantiene el dato guardado como tal.

## Pendientes después de la aprobación

- Instalar y abrir la candidata sin desactivar Google TV; validar HOME real y recuperación.
- Medir nuevamente el launcher integrado, con tarjeta y fondo elegidos.
- Verificar voz/micrófono, emparejamiento, infrarrojos y repetición de volumen con el mando real.
- Abrir las seis apps y reproducir contenido; conservar sus sesiones.
- Conectar Xbox/portátil por HDMI, regresar a Home y probar TV por antena.
- Duplicar pantalla y verificar red, Play Store y actualizaciones.
- Cambiar entre tres fondos, volver desde apps y reiniciar para comprobar persistencia.
- Confirmar pausa del fondo y salvapantallas originales, sin cambiar sus tiempos.
- Completar la prueba de dos días y registrar cualquier incidencia.
