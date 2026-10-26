# Diferencias respecto al estado original

## Estado real antes de activar la candidata

Se habilitó depuración por decisión del usuario. Se obtuvo autorización ADB y se consultó el TV. Se respaldaron listas de paquetes/estados, propiedades, ajustes y capturas. Se instalaron y retiraron apps temporales de medición; el inicio original y los ajustes protegidos se comprobaron sin cambios al cerrarlas. No se flasheó firmware, obtuvo root, desbloqueó bootloader, desinstaló ninguna app original ni realizó debloat.

| Área | Original | Candidata propuesta |
|---|---|---|
| HOME | Inicio Google TV | Launcher personal; activación pendiente |
| Fondo | Gestionado por Google TV | Video 3 local, corriente suave o imagen estática |
| Aplicaciones principales | Distribución original | Seis apps seleccionadas, iconos originales |
| Foco | Comportamiento original | Un único resaltado azul, transparente al perder foco |
| Ajustes | Configuración del fabricante/Google | Misma configuración, acceso directo conservado |
| Millonarios | Sin tarjeta propia | Agenda con caché bajo los botones |
| Entradas y TDT | Apps y servicios Realtek | Se reutilizan; no se desactivan |
| Voz y mando | Servicios del fabricante y Google | Se mantienen; sin interceptores añadidos |
| Salvapantallas | Configuración original | Se conserva; reloj propio del launcher desactivado |
| Actualizaciones y Play Store | Activos | Se conservan |

## Qué es nuevo respecto a cleanyourtv

La base upstream ofrece fondos estáticos y su propio sistema de módulos. Esta adaptación añade `ChallengerBackdrop` (video local y pulsos), selector persistente de tres modos, tarjeta `MillosPanel`, parser de agenda con conversión de zona horaria, permisos de Internet para esa consulta, y personalización de iconos, foco y distribución. Se usa una identidad de aplicación independiente: `local.challenger.home`. El código base y su licencia están atribuidos.

La consulta deportiva es la única red añadida por esta personalización. El renderizador de fondos no necesita Internet. No se incluyen cuentas, tokens o analítica propia.

## Qué todavía no se puede dar por validado

El launcher definitivo no ha sustituido HOME. Las pruebas de rendimiento previas no incluyen la candidata integrada y su tarjeta. Faltan las comprobaciones reales del mando, voz, HDMI/TDT, persistencia del modo, pausa del fondo, salvapantallas, recuperación y uso durante dos días. Cada resultado se documentará sin convertir una intención en una prueba realizada.

## Ajuste posterior: HOME, orden y escudo

El propietario autorizó preparar la integración necesaria tras comprobar que HOME continuaba abriendo Google TV. Se configura `HomeKeyService` para observar exclusivamente cambios de ventana de Google TV y redirigir solo sus actividades HOME. Se desactiva el filtrado de teclas y la recuperación automática del servicio. El permiso de accesibilidad es un cambio explícito respecto al estado original; voz, salvapantallas y demás servicios deben conservarse.

Se habilita el menú de las apps para acceder a «Mover» y guardar su orden. Se añade una imagen local estática del escudo a la derecha de la agenda; la tarjeta se amplía hacia la izquierda, conservando su anclaje superior derecho. No se cambia la posición del reloj ni de los botones.

El botón de temporizador es un acceso nuevo al panel original del firmware, no un temporizador implementado por el launcher. Se ubica entre red y Ajustes. El saludo en español ahora usa el horario colombiano y cambia a noche a las 18:00, incluso si el TV usa es-ES. Se mantienen la hora, el idioma y los temporizadores globales del sistema.
