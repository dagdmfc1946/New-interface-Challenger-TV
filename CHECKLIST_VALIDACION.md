# Checklist obligatorio de entrega y ensayo

Fecha de preparación: 25 de octubre de 2026 (Colombia). Responsable técnico: adaptación Challenger Home. Marca cada casilla solo después de observar el resultado. «Pendiente» no equivale a aprobado. Nunca anotes cuentas, correos, contraseñas, PIN, IP, SSID, identificadores ni capturas de perfiles en esta copia pública.

## 1. Privacidad, recuperación y publicación

- [x] Respaldo inicial privado conservado; se aclaró que es inventario/ajustes, no una imagen restaurable de firmware ni copia de sesiones.
- [x] Repositorio público limitado a código, manuales, recursos seleccionados y respaldo técnico anonimizado; excluye respaldo completo, claves y volcados privados.
- [x] Inicio original y servicios del sistema siguen instalados y habilitados; no se ha rooteado, flasheado ni deshabilitado Google TV.
- [ ] Repetir auditoría sobre la versión final y los archivos del ZIP técnico antes del push.
- [ ] Validar que desactivar el asistente y ejecutar recuperación devuelve HOME a Google TV sin borrar datos.
- [ ] Registrar APK instalado y su hash; verificar rama `dev-TV` sincronizada.

## 2. Interfaz y navegación con el mando

- [ ] HOME desde otra app muestra la nueva interfaz; repetir cinco veces y desde Ajustes, HDMI y TDT. Distinguir el ensayo ADB de la prueba con el mando real.
- [ ] Mantener posiciones del reloj/fecha y botones; fila principal con seis apps y sus iconos originales.
- [ ] Solo un elemento enfocado tiene resaltado azul; logotipos de las apps conservan sus colores propios.
- [ ] Flechas, OK y Atrás no dejan focos invisibles ni impiden llegar a Entradas, red, Ajustes y biblioteca.
- [ ] Mantener OK sobre una app abre su menú; «Mover» permite desplazarla, soltar con OK y guardar con Atrás.
- [ ] Reordenar dos apps, cerrar/abrir el launcher y comprobar persistencia; restaurar el orden original al terminar la prueba técnica.
- [ ] Repetir persistencia del orden y fondo después de reiniciar completamente el TV.
- [ ] Verificar que el escudo está a la derecha del texto del partido, legible y sin cortar rival, fecha, hora ni competencia.

## 3. Funciones originales: comprobación física obligatoria

- [ ] Abrir Ajustes del TV desde la interfaz y comprobar imagen, sonido, red, Bluetooth y canales. Si el perfil exige verificación, realizarla personalmente; no compartir ni registrar el PIN.
- [ ] YouTube: abrir, reproducir video, pausar y entrar a playlists desde su biblioteca habitual.
- [ ] Netflix: abrir y reproducir; conservar perfil y sesión.
- [ ] Xuper: abrir y reproducir; conservar sesión.
- [ ] HBO Max: abrir y reproducir; conservar perfil y sesión.
- [ ] YouTube Music: abrir y reproducir; conservar cuenta.
- [ ] Prime Video: abrir y reproducir; conservar perfil y sesión.
- [ ] Botones dedicados YouTube/Netflix/Prime del mando, si existen, siguen abriendo su app.
- [ ] Mando Bluetooth: flechas, OK, Atrás, HOME, encendido y volumen; probar volumen mantenido y silencio.
- [ ] Infrarrojos: comprobar las funciones compatibles sin borrar el emparejamiento Bluetooth; marcar «no comprobado» si no puede aislarse la prueba.
- [ ] Micrófono: búsqueda por voz desde el mando y respuesta audible/visual, sin saltos inesperados al inicio.
- [ ] HDMI 1 y HDMI 2: imagen/sonido con Xbox o portátil, cambio de entrada y regreso; CEC si se usa habitualmente.
- [ ] Antena/TDT: abrir TV digital, cambiar canales y confirmar sonido; no resintonizar ni borrar canales para una prueba básica.
- [ ] Duplicación/Chromecast: enviar contenido desde el dispositivo habitual y comprobar que el inicio no lo interrumpe.
- [ ] Navegador: abrir uno ya instalado si existe; si no existe, registrar que no se ha instalado uno y que Play Store permanece accesible.
- [ ] Play Store, actualizaciones del TV y conexión de red siguen disponibles.

## 4. Asistente de HOME: alcance y reversión

- [ ] Activar solo `HomeKeyService`, preservando otros servicios de accesibilidad.
- [ ] Confirmar eventos limitados a cambios de ventana de Google TV; sin lectura de contenido, captura de pantalla ni filtrado de teclas.
- [ ] Confirmar que no se concedieron ubicación ni escritura de ajustes seguros a la app.
- [ ] Verificar que no redirige verificación de cuenta, ajustes, voz, salvapantallas, reproducción, HDMI ni TDT por estar abiertos.
- [ ] Desactivar el asistente: HOME vuelve a Google TV; reactivarlo solo si el ensayo es correcto.
- [ ] Reinicio completo: asistente permanece habilitado y no deja al TV bloqueado o reiniciándose.
- [ ] Si se fuerza la detención o falla el servicio, Google TV sigue siendo utilizable; la recuperación manual está documentada.

## 5. Fondos, consumo y reposo

- [ ] Opción 3 ocupa la pantalla, reproduce en bucle sin sonido y no muestra saltos molestos en su unión.
- [ ] Corriente suave y estático se pueden seleccionar desde Ajustes del inicio; elección conservada al reabrir.
- [ ] Al abrir otra app o Ajustes se libera el reproductor del fondo; al regresar se reanuda.
- [ ] Medición breve de CPU, memoria, cuadros UI y decodificador con opción 3 y asistente activo; no confundir cuadros UI con cuadros del video.
- [ ] Dejar reposar sin pulsar teclas: aparece el salvapantallas original al tiempo habitual; salir con el mando y volver al inicio.
- [ ] Suspensión y reactivación conservan sonido, red, control y fuente de entrada; sin pantalla siempre encendida forzada.
- [ ] Comprobar sesiones continuas de reproducción y retorno al inicio durante dos días; comparar con estático si aparece lentitud.

## 6. Agenda deportiva y funcionamiento sin red

- [ ] Próximo encuentro con rival, fecha y hora de Colombia; escudo disponible sin Internet porque es local.
- [ ] Sin fecha fiable: «Programación por confirmar»; no inventar rival ni horario.
- [ ] Sin red: interfaz y apps locales accesibles; con dato guardado, indicar el estado cuando falle una consulta real.
- [ ] Confirmar que no se sondea continuamente: caché de seis horas si la consulta funciona y reintento mínimo de treinta minutos si falla.
- [ ] Considerar que la agenda no es un marcador en vivo y que una caché vigente puede no detectar inmediatamente una caída de conexión.

## Registro y criterios de aceptación

Anotar únicamente: fecha/hora aproximada, ID/sección de prueba, modo de fondo, acción, resultado y síntoma. Las evidencias crudas y capturas con datos personales permanecen fuera de GitHub. Resumir resultados técnicos en `VALIDACIONES.md` y el ensayo prolongado en `PRUEBA_DOS_DIAS.md`.

Se puede iniciar el ensayo supervisado cuando navegación básica, HOME, reversión y acceso a funciones originales estén comprobados. La entrega completa requiere todas las funciones usadas por el propietario y los dos días de uso. Si falla voz, mando, reproducción, HDMI, TDT, reposo o recuperación, registrar el fallo y corregirlo; no deshabilitar la función para marcar la prueba como aprobada. No prometer ausencia de fallos basándose en una sesión corta.
