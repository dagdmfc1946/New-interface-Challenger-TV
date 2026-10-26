# Plan de implementación — registro del trabajo

[Guía del repositorio](../GUIA_REPOSITORIO.md)

Este documento conserva las fases del plan original. La apariencia y el permiso de accesibilidad ya fueron aprobados y la interfaz está instalada. Para el estado actual consulta [Seguimiento](todo.md), [Estado instalado](../ESTADO_INSTALACION.md) y [Prueba de dos días](../PRUEBA_DOS_DIAS.md).

La preparación previa se hizo en el PC antes de la aprobación; los pasos siguientes no son una nueva autorización para reinstalar o ejecutar comandos.

1. Verificar hardware con consultas ADB y manual del fabricante; separar resolución física de la interfaz y almacenamiento utilizable de capacidad total.
2. Crear una adaptación independiente de cleanyourtv (revisión 5ee685b02014fa502ea0951ee1f49abd7ee2e8c1), conservando MIT y atribución. El upstream original queda intacto.
3. Integrar video 3 como fondo inicial y alternativas corriente suave e imagen estática; guardar elección y detener todo al salir de Home. No imponer pantalla encendida ni cambiar salvapantallas.
4. Configurar seis apps, iconos originales y resaltado único. Mantener Entradas, Wi-Fi y Ajustes reales. Ajustes abre el sistema original; el menú del launcher permite cambiar fondos.
5. Preparar tarjeta Millonarios bajo botones, sin refresco continuo, indicando falta de confirmación cuando no se dispone de datos fiables.
6. Compilar y verificar la candidata localmente. Preparar vista previa para aprobación; marcar las pruebas funcionales finales aún pendientes.
7. Documentar hardware, diferencias, usuario, resultados, reversión y prueba de dos días. Preparar carpeta publicable sin respaldos, cuentas, red privada, claves ni APK de terceros.

Fase posterior a la aprobación (instalación y HOME ya comprobados; validación física aún pendiente): instalar sin desactivar el inicio original, comprobar regreso con HOME y revertir si falla; probar mando real, micrófono, TDT, HDMI, apps, duplicación, ajustes y salvapantallas. Medir candidata integrada antes del ensayo de dos días. No hacer debloat indiscriminado.
