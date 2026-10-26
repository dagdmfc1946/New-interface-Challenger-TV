# Validaciones realizadas y pendientes

[Guía](GUIA_REPOSITORIO.md) · [Estado instalado](ESTADO_INSTALACION.md) · [Rendimiento de apps](PERFORMANCE_APPS.md) · [Checklist](CHECKLIST_VALIDACION.md)

## Estado actual y compilación

La interfaz está instalada y el asistente HOME autorizado está activo. No se ha completado el ensayo de dos días ni toda la validación física. El archivo de referencia del APK es [VERIFICACION_COMPILACION.json](../VERIFICACION_COMPILACION.json): **267 pruebas en 42 suites, 0 fallos, 0 errores y 0 omitidas; lint con 0 errores y 91 advertencias**. El hash leído en el TV coincidió con el compilado.

Se ejecutaron `testReleaseUnitTest`, `lintRelease` y `assembleRelease`; no se rebajaron criterios para aprobar. Las primeras versiones tenían 263 pruebas; las cuatro de saludo añadidas reproducen el error nocturno y verifican las transiciones colombianas de 05:00, 12:00 y 18:00. La prueba inicial falló antes de corregir esos límites. Compilar correctamente no certifica reproducción ni periféricos físicos.

El script de accesibilidad tiene cuatro escenarios simulados: preservar otros servicios, activación idempotente, desactivación conservando otros y reversión a lista vacía. Incluye la regresión que exige abrir la interfaz al habilitarlo si Google TV ya estaba visible. Estas pruebas no contactan el TV.

## Evidencia de instalación y uso técnico

| Área | Evidencia | Límite |
|---|---|---|
| UI | Captura real de saludo 22 sp en negrilla, reloj 72 sp, fecha 20 sp, foco azul translúcido, iconos redondeados y tarjeta con escudo | Capturas personalizadas privadas; falta evaluación prolongada desde distancia habitual |
| Orden | Cambio persistió al detener/reabrir; propietario confirmó reordenamiento con mando | Se conserva su orden; repetir persistencia de alternativas en uso diario |
| Temporizador | Botón abrió Tiempo de dormir y Atrás cerró el panel; cinco recorridos temporizador → HOME correctos | No se eligió un tiempo ni se midió apagado real |
| HOME | Doce regresos ADB desde apps, más cinco desde temporizador, mostraron la interfaz nueva | Confirmar mando, HDMI/TDT y uso diario |
| Accesibilidad | Servicio enlazado con capacidades adicionales 0, TYPE_WINDOW_STATE_CHANGED y timeout 100 ms | El permiso es sensible; alcance en [Asistente HOME](ASISTENTE_HOME.md) |
| Reversión | Desactivar el asistente devolvió HOME a Google TV; reactivación comprobada | Ruta gráfica concreta pendiente de repetir con mando |
| Reinicio | Servicio permaneció habilitado y la interfaz apareció sin abrirla desde el PC | No equivale a dos días de suspensión y uso |
| Ajustes originales | Voz, salvapantallas y lista de paquetes deshabilitados consultados sin cambios | Conservar ajustes no demuestra su funcionamiento físico |
| Fondo al salir | El cliente MediaPlayer del launcher desapareció al abrir el temporizador; no estuvo activo durante las seis muestras de apps | No es un ensayo de horas de reproducción |
| Apps | Aperturas y PSS en [Rendimiento](PERFORMANCE_APPS.md) | Primera actividad no equivale a catálogo o reproducción lista |

Solo se añadió el servicio autorizado a accesibilidad y su indicador global; no se concedió a la app ubicación ni escritura de ajustes seguros. No se deshabilitó Google TV ni ningún paquete original.

Netflix llegó a acceso asistido de Google, observado también con el inicio original y asistente apagado. No se introdujeron credenciales. YouTube Music llevó a YouTube. Esos casos no se presentan como reproducción validada.

## Rendimiento del launcher integrado

Primera sesión integrada con opción 3: CPU total 7,26 %, 13,47 % y 7,18 % en tres muestras de unos diez segundos, mediana 7,26 %. PSS 37.102 KiB. Navegación: 27 cuadros UI registrados y ninguno lento; muestra breve. El decodificador Realtek reportó inicialmente 568 cuadros de video sin pérdidas. Los contadores UI y los del video son diferentes.

Sesión posterior con escudo y sin asistente: CPU total 9,34 % y 14,09 %; PSS 40.366 KiB y 12 cuadros UI sin lentos registrados. No permite atribuir variaciones al escudo.

La comparación apagado/encendido del asistente se hizo en el mismo APK y está detallada en [Rendimiento](PERFORMANCE_APPS.md). Las seis aperturas usaron opción 3 y la misma lógica de HOME antes de la última ampliación tipográfica; no se afirma repetir cada medición para cada APK de estilos. CPU incluye tareas del sistema y una cifra de 0,0 % puede estar por debajo de la resolución del contador.

## Ensayos temporales anteriores — referencia histórica

Se usó una app independiente, sin HOME ni permisos, retirada después. Estos resultados corresponden al renderizador temporal, no al launcher integrado con tarjeta y asistente.

| Escenario | CPU total mediana registrada | Observación |
|---|---:|---|
| Inicio Google | 16,39 % | Referencia aparte; no demuestra una mejora causada por el launcher |
| Estático digital | 1,57 % | Sin cuadros UI lentos observados en la muestra |
| Corriente suave (~15 fps) | 5,13 % | Sin cuadros UI lentos observados en la muestra |
| Opción 3, 720p/30 | 7,75 % | Decodificador Realtek; sin pérdidas en contadores disponibles |
| Video nuevo descartado para principal | 8,08 % | 0/5.107 cuadros de video perdidos; 3/72 cuadros UI lentos |

Opción 1 se descartó por apariencia y opción 5 no se probó en el TV. No se atribuye una mejora al video nuevo frente a opción 3. PSS excluye parte de buffers/servicios nativos; no es toda la memoria del video. No es un ensayo térmico ni una medición de latencia del mando. Los crudos y APK extraídos quedan privados.

## Red deportiva

La personalización añade Internet para la agenda pública: límite de lectura 1 MB, timeouts de ocho segundos, sin redirecciones automáticas, caché de seis horas al funcionar y reintento mínimo de treinta minutos al fallar. La tarjeta mostró un próximo encuentro. Parser probado para zona horaria, fechas inválidas, pasado y equipos incorrectos. Ver [Manual](MANUAL_USUARIO.md) y [Recursos](RECURSOS_TERCEROS.md). Queda pendiente observar la recuperación real de una consulta fallida; una caché vigente puede no indicar una desconexión inmediatamente.

## Incidencias técnicas resueltas y límites de herramientas

- PowerShell: `$home` era una variable reservada; se cambió a `$resolvedHome` en instalación y recuperación.
- Mecanismos estándar de HOME: el firmware seguía priorizando Google TV. Se preparó el asistente; un bloqueo inicial de revisión se resolvió únicamente después de autorización explícita, sin vías alternativas para habilitarlo.
- Activación estando Google TV visible: podía no producir evento; el script ahora abre la nueva interfaz tras habilitar el servicio. No se activó filtrado de teclas para resolverlo.
- Reinicio: el primer intento de conectar ADB agotó un timeout durante el arranque; el reintento comprobó el inicio sin alterar red/ADB del TV.
- UiAutomator: una lectura devolvió raíz nula tras actualizar. Captura local y dumpsys activity/window confirmaron la interfaz; no se cambiaron permisos para eludirlo.
- Una variante heredada de layout recibió el acceso de temporizador faltante; la cabecera usa negrilla estándar, sin cambiar el idioma del sistema.

## Pendiente de uso físico

Completar [Prueba de dos días](PRUEBA_DOS_DIAS.md) y [Checklist](CHECKLIST_VALIDACION.md): reproducción y acceso de Netflix, mando BT/IR y voz, HDMI/CEC, antena/TDT, duplicación, navegador si existe, Play Store/actualizaciones, apagado programado real, salvapantallas, suspensión y persistencia de modos alternativos. Ninguna de estas funciones se marca aprobada solo por no haber desactivado sus servicios.
