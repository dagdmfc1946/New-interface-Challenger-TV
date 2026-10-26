# Manual de usuario — Challenger Home

La interfaz está instalada. El asistente HOME se activó con autorización explícita; Google TV permanece como HOME de sistema y su pantalla de inicio se redirige a la nueva interfaz. Consulta [Asistente HOME](ASISTENTE_HOME.md) para entender el alcance y la reversión. No sustituye el manual del televisor.

[Guía del repositorio](GUIA_REPOSITORIO.md) · [Prueba de dos días](PRUEBA_DOS_DIAS.md) · [Advertencias](ADVERTENCIAS_Y_RESPONSABILIDAD.md)

Todos los comandos de este manual se ejecutan desde la raíz del repositorio. Leerlo no requiere conectar ADB.

## Pantalla de inicio

Arriba a la izquierda aparecen saludo, hora y fecha. Arriba a la derecha están **Entradas**, **red**, **temporizador** y **Ajustes**. Debajo aparece la tarjeta de Millonarios FC. Los seis accesos iniciales son YouTube, Netflix, Xuper, HBO Max, YouTube Music y Prime Video. El orden personal se puede cambiar y se conserva; este manual no lo impone.

Usa las flechas del mando para moverte. **Solo el elemento seleccionado tiene el resaltado azul**. Pulsa OK para abrirlo. Atrás vuelve a la pantalla anterior; HOME muestra la nueva interfaz mediante el asistente. Al desactivarlo, HOME vuelve a Google TV. Los fondos propios de los logotipos, como el azul de Prime Video, forman parte del icono original.

Desplázate a la derecha en la fila para encontrar las demás aplicaciones y la biblioteca; ocultar un icono no desinstala la aplicación. Los menús de fábrica no deben utilizarse.

## Configuración del TV: sigue disponible

Pulsa **Ajustes** normalmente para abrir la configuración original de Android/Google TV. Desde allí se siguen gestionando imagen, sonido, red, cuentas, canales, mando, Bluetooth, aplicaciones, actualizaciones y salvapantallas. El nuevo inicio no reemplaza esos paneles.

Para configurar la interfaz, mantén OK sobre Ajustes y entra en la opción de configuración del inicio/launcher. El texto exacto depende del idioma del sistema. No confundas este menú con Ajustes del TV.

El saludo en español sigue el horario de Colombia: Buenos días de 05:00 a 11:59, Buenas tardes de 12:00 a 17:59 y Buenas noches de 18:00 a 04:59. No modifica el idioma ni la zona horaria del sistema.

Para personalizar el saludo, mantén OK sobre Ajustes y abre la configuración del inicio. En **Nombre para el saludo**, introduce el nombre deseado y confirma. Se guarda solo en las preferencias privadas del TV; no se incluye en el repositorio ni en el respaldo técnico público. En español se muestra «¡Buenas noches, [nombre]!» según la franja horaria. Deja el campo vacío para mostrar solo el saludo.

Los iconos de la fila conservan su imagen original, con tamaño ampliado y un recorte suave de esquinas. El único fondo azul de selección sigue al foco.

## Temporizador de apagado

El botón con icono de temporizador, entre Wi-Fi y Ajustes, abre el panel original **Tiempo de dormir** del TV. Elige allí el intervalo deseado y confirma con OK. El launcher no crea una alarma ni decide el apagado: lo gestiona el sistema del televisor, igual que antes. Abrir el panel por sí solo no programa ningún tiempo.

Para cancelar o cambiar el temporizador, vuelve al mismo panel y usa su opción de desactivación o el intervalo deseado. En la prueba técnica solo se abrió el panel; el apagado real a la hora elegida queda como prueba supervisada del propietario. Si otro firmware no ofrece esta acción, se oculta el acceso.

## Reordenar aplicaciones

1. Selecciona una app con las flechas y mantén **OK** para abrir su menú. Si el mando tiene botón Menú, también puedes usarlo.
2. Selecciona **Mover**, la primera opción.
3. Usa izquierda/derecha para colocarla en la posición deseada.
4. Pulsa **OK** para soltarla y **Atrás** para terminar y guardar.

También puedes mantener OK sobre Ajustes y elegir **Reordenar**. En ese modo pulsa OK para coger una app, muévela con las flechas, pulsa OK para soltarla y Atrás para terminar. El orden se guarda solo en el TV. Mover el icono no borra ni cambia datos de la aplicación.

## Asistente de HOME y privacidad

Este firmware da prioridad a Google TV como inicio de Android. El asistente opcional de esta adaptación detecta únicamente cambios de ventana del paquete de Google TV y, cuando aparece su actividad de inicio, abre Challenger Home. Google TV permanece instalado, habilitado y como HOME efectivo del sistema.

Se utiliza accesibilidad sin permiso para leer contenido de ventanas, hacer capturas o filtrar teclas. No se solicita ubicación ni escritura de ajustes seguros a la app; la activación inicial se hace desde el PC autorizado. No modifica los botones de voz, volumen, encendido ni las teclas de aplicaciones. Puede haber un breve paso por el inicio original. La verificación con el mando físico sigue siendo necesaria.

Para desactivarlo desde el PC: `scripts/asistente-home.ps1 -TvHost '<ip-del-tv>' -Adb 'adb' -Desactivar`. Para regresar completamente a Google TV usa `scripts/restaurar-inicio.ps1`. También puede deshabilitarse el servicio Botón Inicio de la app en los ajustes de accesibilidad del TV. No se reactiva automáticamente después de una desactivación o detención forzada; abre la app y, si hace falta, usa el script de activación de nuevo. No borres sus datos para intentar repararlo.

## Cambiar de fondo

En la configuración del inicio abre **Fondo** y selecciona:

1. **Opción 3 · placa electrónica:** modo principal para el ensayo de dos días. Video local, sin audio.
2. **Digital y microchips · corriente suave:** pequeños pulsos sobre las pistas, aproximadamente 15 fps.
3. **Digital y microchips · imagen estática:** menor consumo de las tres opciones.

La elección se guarda al salir y debe persistir al reiniciar. La persistencia de cada alternativa, en particular después de reiniciar, sigue pendiente en el ensayo de uso. No se requiere recompilar para cambiar entre estos tres modos.

El video o los pulsos se detienen al abandonar el inicio. No deben continuar consumiendo recursos durante Netflix, YouTube, una entrada HDMI ni el salvapantallas. Si el video falla, se conserva una imagen de respaldo.

## Xbox, portátil y TV por antena

Pulsa **Entradas** para elegir HDMI 1 o HDMI 2. Conecta la Xbox o el portátil al HDMI correspondiente. **TV digital** abre la aplicación del sintonizador existente. La antena se conecta al puerto RF habitual; la búsqueda de canales se hace en los ajustes originales del TV.

El launcher no borra canales ni cambia las señales admitidas por el hardware. La selección física de HDMI, imagen/sonido y TDT se comprueban durante el ensayo de dos días; siguen pendientes hasta registrar el resultado.

## Mando y comandos de voz

Se mantienen los servicios originales de Bluetooth, infrarrojos y emparejamiento. Los botones compatibles funcionan por infrarrojos; el micrófono del mando requiere Bluetooth y conexión a Internet según el manual del fabricante. El asistente opcional de HOME se documenta arriba; no filtra teclas ni sustituye los servicios originales del mando.

Si la voz deja de responder, comprueba en los ajustes originales que el mando está emparejado y usa el botón del micrófono. No restablezcas el TV ni borres datos como primer paso. Comunica el fallo antes de aplicar cambios adicionales.

## YouTube y tus playlists

El icono abre YouTube normal. Selecciona tu cuenta y entra en Biblioteca/Playlists dentro de YouTube. No se copian contraseñas ni se consultan listas privadas desde el launcher. La instalación no borra datos de las apps; cada proveedor puede solicitar de nuevo acceso. Netflix mostró un panel de acceso de Google también usando el inicio original; complétalo personalmente si corresponde. En este TV YouTube Music redirige a YouTube.

## Navegación por Internet

La consulta estándar de enlaces web no confirmó un navegador completo instalado. La biblioteca y Play Store permanecen disponibles para elegir e instalar uno compatible por separado. El launcher no bloquea la navegación ni instala un navegador automáticamente.

## Millonarios FC

La tarjeta muestra el próximo partido disponible, rival, competencia y hora de Colombia, con el escudo a la derecha. El escudo está incluido localmente, sin animación ni descargas periódicas. La línea de competencia y fuente usa un tamaño menor que el rival, la fecha y la hora. Consulta la agenda pública enlazada por la página oficial del club, sin acceder a tu cuenta. Como máximo intenta actualizar cada seis horas mientras el inicio está visible; si falla, espera al menos treinta minutos antes de otro intento.

Si una consulta falla muestra el dato guardado con una indicación de falta de actualización. No detecta inmediatamente cada pérdida de conexión mientras la caché sigue vigente. Sin una fecha futura fiable muestra **Programación por confirmar**. No es un marcador en vivo ni garantiza cambios de última hora; confirma la programación oficial antes de organizarte. La tarjeta integrada mostró un próximo partido en el TV; la programación depende de la fuente pública.

## Salvapantallas

Se conservan los salvapantallas y tiempos actuales del sistema. El launcher no activa su reloj de reposo propio, no modifica `screensaver_*` ni mantiene permanentemente la pantalla despierta. La instalación ya terminó; su activación real y salida se comprueban durante el ensayo con el mando.

## Si notas lentitud

Selecciona primero la imagen estática y compara la navegación. Anota si ocurre solo en Home, en una app, por HDMI o después de volver del salvapantallas. No cambies límites de procesos ni desactives componentes del sistema. Sigue la hoja [Prueba dos dias](PRUEBA_DOS_DIAS.md).

## Volver al inicio original

El inicio de Google TV se deja instalado y habilitado. Puede seleccionarse desde el panel de aplicaciones predeterminadas cuando el firmware lo ofrezca. Si ese panel no está disponible, el script `scripts/restaurar-inicio.ps1` desactiva el asistente, selecciona y comprueba HOME original mediante ADB; consulta [Recuperacion](RECUPERACION.md). No es necesario restablecer de fábrica.

## Último ajuste de legibilidad

El bloque superior izquierdo usa saludo de 22 sp en negrilla, reloj de 72 sp y día/fecha de 20 sp. El marco de selección mantiene el azul con relleno de aproximadamente 15–20 % de opacidad y un borde visible; los iconos quedan legibles debajo. La tarjeta de Millonarios conserva 330 × 86 dp, con escudo de 68 dp desplazado hacia el texto. Competencia y fuente usan el 74 % del tamaño principal y un tono azul gris claro.
