# Cambios respecto al estado original

[Guía del repositorio](GUIA_REPOSITORIO.md) · [Estado instalado](ESTADO_INSTALACION.md) · [Validaciones](VALIDACIONES.md)

## Alcance real

Se habilitó depuración por decisión del propietario, se autorizó ADB y se obtuvo un inventario de paquetes, propiedades y ajustes. Hubo apps temporales de medición, retiradas después. Se instaló una adaptación independiente, `local.challenger.home`, y se activó su servicio de accesibilidad tras autorización explícita.

No se flasheó firmware, obtuvo root, desbloqueó el arranque, desinstaló ninguna app original ni realizó debloat. El respaldo completo es privado y no es una imagen restaurable del firmware. Ver [Advertencias](ADVERTENCIAS_Y_RESPONSABILIDAD.md).

## Comparación con el TV original

| Área | Estado original | Estado actual de esta adaptación |
|---|---|---|
| HOME | Pantalla de Google TV | Google TV sigue siendo HOME de sistema; HomeKeyService redirige su pantalla a la nueva interfaz |
| Fondo | Gestionado por Google TV | Opción 3 local por defecto; corriente suave y estático disponibles |
| Aplicaciones | Distribución original | Seis accesos configurados, resto accesible desde fila/biblioteca; orden editable y guardado |
| Iconos y foco | Apariencia original | Iconos originales ampliados y redondeados; un único marco azul con relleno de 15–20 % de opacidad |
| Cabecera | Inicio original | Saludo 22 sp en negrilla, reloj 72 sp, día/fecha 20 sp; nombre solo en preferencias locales |
| Saludo | No personalizado por esta app | Franja colombiana: mañana desde 05:00, tarde desde 12:00, noche desde 18:00 |
| Ajustes | Paneles de Google/fabricante | Mismos paneles; acceso desde la nueva interfaz |
| Temporizador | Panel nativo del sistema | Acceso nuevo al mismo panel Realtek entre red y Ajustes; no crea un servicio de apagado propio |
| Millonarios | Sin tarjeta propia | Agenda pública con caché y escudo local; tarjeta 330 × 86 dp, escudo 68 dp y línea secundaria menor |
| Accesibilidad | Estado anterior preservado en copia privada | Se añadió solo HomeKeyService y se habilitó el indicador global; sin filtrado de teclas ni lectura de contenido |
| TDT, HDMI, AV y duplicación | Servicios originales | No se desactivaron; validación física pendiente |
| Voz y mando | Servicios del fabricante/Google | Se conservan; no se añadió filtrado de sus teclas; pruebas físicas pendientes |
| Salvapantallas y suspensión | Ajustes originales | Ajustes sin cambios, reloj de reposo del launcher desactivado; activación real pendiente de prueba |
| Actualizaciones y Play Store | Disponibles en el sistema | No se desactivaron ni reemplazaron |

La conservación de un servicio o ajuste no equivale por sí sola a haber comprobado físicamente cada función. El detalle está en el [checklist](CHECKLIST_VALIDACION.md).

## Respecto a Clean Your TV

La base upstream aporta el launcher y su estructura de navegación, ajustes, orden y servicios. Esta adaptación añade video local/pulsos mediante ChallengerBackdrop, selector de tres modos, MillosPanel y parser de agenda con hora de Colombia, saludo colombiano, nombre local editable, acceso al temporizador del firmware, scripts de operación y esta documentación. La licencia y procedencia están en [Créditos](CREDITOS_Y_LICENCIAS.md).

La única consulta de red añadida por esta personalización es la agenda deportiva; los fondos y el escudo son locales. No se añadió acceso a cuentas de Google, playlists privadas, contraseñas, tokens ni analítica propia. Se accede a playlists desde YouTube normal. No se distribuyen los iconos o APK de las apps instaladas.

## Comprobado y pendiente

Instalación, hash, navegación técnica, orden guardado, tarjeta, temporizador, doce regresos HOME desde apps, cinco desde temporizador, reversión y un reinicio normal se comprobaron. La documentación de [rendimiento](PERFORMANCE_APPS.md) separa actividad inicial de reproducción.

Quedan pendientes mando físico completo, micrófono, infrarrojos, reproducción sostenida, HDMI/TDT, duplicación, salvapantallas, persistencia de alternativas y el [ensayo de dos días](PRUEBA_DOS_DIAS.md). Netflix mostró acceso asistido de Google también con el inicio original; no se completó ninguna cuenta. YouTube Music abre YouTube en este TV.
