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

## Instalación real de la candidata integrada

La opción 3 se abrió con seis favoritas en una fila inferior y tarjeta de Millonarios con datos. Sesión de tres muestras de aproximadamente diez segundos: CPU total del equipo 7,26 %, 13,47 % y 7,18 % (mediana 7,26 %). PSS del proceso: 37.102 KiB; navegación: 27 cuadros UI registrados y 0 % lentos. La medición de CPU del proceso tuvo resolución insuficiente (0,0 %); no significa consumo nulo. Sesión breve, sin atribuir una mejora garantizada ni certificar reproducción de todas las apps.

El reproductor usó el decodificador Realtek y una captura inicial registró 568 cuadros sin pérdidas. Se conservaron los ajustes protegidos y los paquetes deshabilitados. El firmware sigue resolviendo HOME a Google TV pese a dos mecanismos estándar; no se deshabilitó ningún componente para eludirlo. La sustitución definitiva de HOME queda pendiente de decidir y validar un asistente opcional.

El intento de activación detectó un error de PowerShell por usar `$home`, variable reservada. Se corrigieron instalación y recuperación a `$resolvedHome`; ese fallo no alteró paquetes ni datos. La selección efectiva de HOME se comprobó después directamente.

## Escudo y reordenamiento: actualización posterior

Se habilitó el menú de pulsación larga y se observó «Mover» en el TV. Mediante eventos ADB se intercambiaron YouTube y Netflix; el orden persistió tras detener y volver a abrir la app. Esto demuestra el guardado local del orden; no sustituye la prueba del propietario con su mando. Se prepara «Mover» como primera opción para evitar confundirlo con «Sustituir por otra app».

El escudo se obtuvo del sitio oficial del club y se incluyó como PNG local de 14.503 bytes; su origen y hash están en RECURSOS_TERCEROS.md. La primera disposición fue observada en el TV. El ajuste siguiente aumenta su tamaño, lo acerca al texto y reduce solo la línea de competencia/fuente al 82 % del tamaño principal.

Medición breve con escudo y sin asistente: dos muestras de CPU total del equipo de 9,34 % y 14,09 %; PSS 40.366 KiB; 12 cuadros UI registrados, 0 % lentos. No permite atribuir al escudo una diferencia respecto a otra sesión ni validar el consumo del asistente, aún desactivado.

Los scripts del asistente tienen cuatro escenarios simulados sin conexión al TV: preservar otro servicio, habilitar sin duplicados, desactivar conservando otros y volver a lista vacía. Los tres scripts se analizaron sintácticamente con PowerShell. La activación real fue bloqueada por revisión automática al exigir permiso explícito adicional; no se habilitó mediante otra vía.

## Saludo y temporizador nativo

Se reprodujo el error del saludo de España: a las 20:30 de Colombia la base seguía mostrando tarde. Las pruebas de regresión fallaron antes de corregirlo (3 de 4) y verifican los límites de 05:00, 12:00 y 18:00 en America/Bogota. La integración aplica esta regla al saludo en español sin cambiar ajustes globales del TV.

El firmware expone `android.tv.settings.SLEEP_TIMER_HOT_KEY`, resuelta a `com.android.tv.settings/com.realtek.tv.settings.activity.SleepTimerHotKeyActivity`. Se abrió el panel original Tiempo de dormir con intervalos de 15, 30, 45, 60, 90 y 120 minutos. No se seleccionó ningún tiempo ni se programó apagado. El botón reutiliza esa acción y no añade un servicio, alarma ni permiso; falta comprobar su acceso desde la nueva versión y el apagado real bajo supervisión.

El propietario confirmó que pudo reorganizar las aplicaciones. La actualización debe conservar su orden. No se continuarán intercambios técnicos sobre su orden personal. La activación de accesibilidad permanece pendiente de autorización explícita: la solicitud de explicación adicional no equivale a permiso.

## Resultado de la actualización visual instalada

La versión final de este ajuste pasó **267 pruebas en 42 suites**, sin fallos, errores ni omisiones. Lint: 0 errores y 92 advertencias, incluidas etiquetas nuevas aún sin traducción a otros idiomas de la base. No se añadieron supresiones ni se rebajaron criterios. Hash y tamaño del APK en VERIFICACION_COMPILACION.json; el hash leído en el TV coincide con el compilado.

Se observó el saludo de noche y su nombre configurable, guardado solo en preferencias locales y conservado al detener/reabrir la app. Se comprobaron iconos ampliados con esquinas redondeadas, escudo más grande y cercano al texto, y línea secundaria menor. Las capturas personalizadas permanecen privadas.

El botón de temporizador abrió la actividad nativa desde la interfaz y Atrás la cerró. Durante ese panel desapareció el cliente del reproductor local en `dumpsys media.player`; antes del panel usaba el decodificador Realtek. No se programó apagado. El orden personal de apps se conserva tras la actualización. El propietario confirmó el reordenamiento con su mando.

El asistente HOME sigue desactivado. Preparación, pruebas simuladas y compilación no equivalen a activación ni a validación del servicio real. No se marca HOME, voz, TDT, HDMI, salvapantallas o ensayo de dos días como aprobados por estos cambios visuales.

## HOME autorizado y rendimiento de apps

Tras autorización explícita, se activó HomeKeyService sin conceder a la app ubicación ni escritura de ajustes seguros. El servicio enlazado reportó `capabilities=0`, eventos `TYPE_WINDOW_STATE_CHANGED` y timeout de 100 ms. La primera pulsación ADB de HOME y doce regresos desde las seis apps mostraron la nueva interfaz. No se deshabilitó Google TV.

Los resultados de apertura, CPU y PSS están en PERFORMANCE_APPS.md. Netflix llegó a una actividad de acceso asistido de Google; no se introdujeron credenciales. YouTube Music redirigió a YouTube. No se confunden esos casos con apps listas para reproducir. El video del launcher no permaneció activo durante las muestras de las apps y no se detectó CPU de su proceso en esas ventanas. Se mantienen pendientes reproducción prolongada y pruebas físicas.

Se corrigió también la presencia del temporizador en una variante heredada de layout y se usa negrilla estándar sin atributo dependiente de Android 9; no se cambió el idioma del TV ni la disposición española elegida. Las verificaciones finales y el hash corresponden a VERIFICACION_COMPILACION.json.
