# Manual de usuario — Challenger Home

La interfaz está instalada. Este firmware mantiene Google TV como HOME efectivo; por ahora abre la nueva interfaz desde TVHome en las aplicaciones. La integración definitiva del botón HOME sigue pendiente. No sustituye el manual del televisor.

## Pantalla de inicio

Arriba a la izquierda aparecen saludo, hora y fecha. Arriba a la derecha están **Entradas**, **red** y **Ajustes**. Debajo aparece la tarjeta de Millonarios FC. La fila principal contiene, en orden: YouTube, Netflix, Xuper, HBO Max, YouTube Music y Prime Video.

Usa las flechas del mando para moverte. **Solo el elemento seleccionado tiene el resaltado azul**. Pulsa OK para abrirlo. Atrás vuelve a la pantalla anterior; por ahora HOME regresa al inicio original de Google TV. Los fondos propios de los logotipos, como el azul de Prime Video, forman parte del icono original.

Desplázate a la derecha en la fila para encontrar las demás aplicaciones y la biblioteca; ocultar un icono no desinstala la aplicación. Los menús de fábrica no deben utilizarse.

## Configuración del TV: sigue disponible

Pulsa **Ajustes** normalmente para abrir la configuración original de Android/Google TV. Desde allí se siguen gestionando imagen, sonido, red, cuentas, canales, mando, Bluetooth, aplicaciones, actualizaciones y salvapantallas. El nuevo inicio no reemplaza esos paneles.

Para configurar la interfaz, mantén OK sobre Ajustes y entra en la opción de configuración del inicio/launcher. El texto exacto depende del idioma del sistema. No confundas este menú con Ajustes del TV.

## Cambiar de fondo

En la configuración del inicio abre **Fondo** y selecciona:

1. **Opción 3 · placa electrónica:** modo principal para el ensayo de dos días. Video local, sin audio.
2. **Digital y microchips · corriente suave:** pequeños pulsos sobre las pistas, aproximadamente 15 fps.
3. **Digital y microchips · imagen estática:** menor consumo de las tres opciones.

La elección se guarda al salir y debe persistir al reiniciar. Es una comprobación pendiente de la instalación final. No se requiere recompilar para cambiar entre estos tres modos.

El video o los pulsos se detienen al abandonar el inicio. No deben continuar consumiendo recursos durante Netflix, YouTube, una entrada HDMI ni el salvapantallas. Si el video falla, se conserva una imagen de respaldo.

## Xbox, portátil y TV por antena

Pulsa **Entradas** para elegir HDMI 1 o HDMI 2. Conecta la Xbox o el portátil al HDMI correspondiente. **TV digital** abre la aplicación del sintonizador existente. La antena se conecta al puerto RF habitual; la búsqueda de canales se hace en los ajustes originales del TV.

El launcher no borra canales ni cambia las señales admitidas por el hardware. Antes de la entrega se verificará selección de HDMI, imagen/sonido, regreso con HOME y TDT mediante el mando real.

## Mando y comandos de voz

Se mantienen los servicios originales de Bluetooth, infrarrojos y emparejamiento. Los botones compatibles funcionan por infrarrojos; el micrófono del mando requiere Bluetooth y conexión a Internet según el manual del fabricante. No se habilitan filtros de teclas ni servicios nuevos de accesibilidad.

Si la voz deja de responder, comprueba en los ajustes originales que el mando está emparejado y usa el botón del micrófono. No restablezcas el TV ni borres datos como primer paso. Comunica el fallo antes de aplicar cambios adicionales.

## YouTube y tus playlists

El icono abre YouTube normal. Selecciona tu cuenta y entra en Biblioteca/Playlists dentro de YouTube. No se copian contraseñas ni se consultan listas privadas desde el launcher. Las sesiones de tus aplicaciones se conservan.

## Navegación por Internet

La consulta estándar de enlaces web no confirmó un navegador completo instalado. La biblioteca y Play Store permanecen disponibles para elegir e instalar uno compatible por separado. El launcher no bloquea la navegación ni instala un navegador automáticamente.

## Millonarios FC

La tarjeta muestra el próximo partido disponible, rival, competencia y hora de Colombia. Consulta la agenda pública enlazada por la página oficial del club, sin acceder a tu cuenta. Como máximo intenta actualizar cada seis horas mientras el inicio está visible; si falla, espera al menos treinta minutos antes de otro intento.

Si una consulta falla muestra el dato guardado con una indicación de falta de actualización. No detecta inmediatamente cada pérdida de conexión mientras la caché sigue vigente. Sin una fecha futura fiable muestra **Programación por confirmar**. No es un marcador en vivo ni garantiza cambios de última hora; confirma la programación oficial antes de organizarte. La tarjeta integrada mostró un próximo partido en el TV; la programación depende de la fuente pública.

## Salvapantallas

Se conservan los salvapantallas y tiempos actuales del sistema. El launcher no activa su reloj de reposo propio, no modifica `screensaver_*` ni mantiene permanentemente la pantalla despierta. Su activación real se comprobará tras instalar.

## Si notas lentitud

Selecciona primero la imagen estática y compara la navegación. Anota si ocurre solo en Home, en una app, por HDMI o después de volver del salvapantallas. No cambies límites de procesos ni desactives componentes del sistema. Sigue la hoja `PRUEBA_DOS_DIAS.md`.

## Volver al inicio original

El inicio de Google TV se deja instalado y habilitado. Puede seleccionarse desde el panel de aplicaciones predeterminadas cuando el firmware lo ofrezca. Si ese panel no está disponible, el script `scripts/restaurar-inicio.ps1` restablece únicamente el componente HOME original mediante ADB; consulta `RECUPERACION.md`. No es necesario restablecer de fábrica.
