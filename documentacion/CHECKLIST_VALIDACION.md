# Checklist obligatorio de entrega y ensayo

[Guía del repositorio](GUIA_REPOSITORIO.md)

Fecha de preparación: 25 de octubre de 2026 (Colombia). Responsable técnico: adaptación Challenger Home. Marca cada casilla solo después de observar el resultado. «Pendiente» no equivale a aprobado. Nunca anotes cuentas, correos, contraseñas, PIN, IP, SSID, identificadores ni capturas de perfiles en esta copia pública.

## Cómo usar este checklist

Este es el registro maestro: las casillas marcadas describen evidencia ya obtenida, no sustituyen tu prueba física. Para el recorrido y registro de cada jornada sigue [Prueba de dos días](PRUEBA_DOS_DIAS.md). Las funciones sin antena, cable o acceso quedan pendientes; no se dan por aprobadas. El ensayo todavía no tiene inicio/cierre real registrado.

## 1. Privacidad, recuperación y publicación

- [x] Respaldo inicial privado conservado; se aclaró que es inventario/ajustes, no una imagen restaurable de firmware ni copia de sesiones.
- [x] Repositorio público limitado a código, manuales, recursos seleccionados y respaldo técnico anonimizado; excluye respaldo completo, claves y volcados privados.
- [x] Advertencias y responsabilidad, créditos MIT/OFL e indicación de seguir el upstream documentados; no se da por verificado el permiso de redistribución del video/escudo.
- [x] Inicio original y servicios del sistema siguen instalados y habilitados; no se ha rooteado, flasheado ni deshabilitado Google TV.
- [x] Auditoría de archivos versionados y entradas del ZIP técnico repetida antes de publicar; sin valores privados buscados.
- [x] Desactivar el asistente devolvió HOME a Google TV sin borrar datos; reactivación comprobada y arranque inicial corregido.
- [x] Hash del APK instalado coincide con el compilado; publicación verificada en `dev-TV`.

## 2. Interfaz y navegación con el mando

- [x] Doce regresos ADB desde las seis apps mostraron la nueva interfaz.
- [ ] Confirmar HOME con mando real, HDMI, TDT y Ajustes; la prueba ADB no sustituye esas comprobaciones.
- [x] Bloque izquierdo ampliado por solicitud, sin recortes observados; botones y tarjeta mantienen anclajes, fila con seis iconos originales.
- [x] Iconos ampliados y redondeados observados en el TV; nombre del saludo guardado solo localmente y conservado al reabrir.
- [x] Resaltado único azul translúcido comprobado en captura; logotipos visibles y conservados.
- [ ] Flechas, OK y Atrás no dejan focos invisibles ni impiden llegar a Entradas, red, Ajustes y biblioteca.
- [ ] Mantener OK sobre una app abre su menú; «Mover» permite desplazarla, soltar con OK y guardar con Atrás.
- [x] Reordenar dos apps, cerrar/abrir el launcher y comprobar persistencia mediante ADB. El propietario también confirmó que pudo reorganizar. Conservar su orden guardado.
- [ ] Repetir persistencia del orden y fondo después de reiniciar completamente el TV.
- [x] Saludo nocturno observado a la hora local; límites de 05:00, 12:00 y 18:00 de Colombia verificados mediante pruebas automatizadas.
- [x] Escudo ampliado a la derecha y más próximo al texto; competencia/fuente más pequeñas. Vista real comprobada sin recortes del encuentro actual.

## 3. Funciones originales: comprobación física obligatoria

- [ ] Abrir Ajustes del TV desde la interfaz y comprobar imagen, sonido, red, Bluetooth y canales. Si el perfil exige verificación, realizarla personalmente; no compartir ni registrar el PIN.
- [ ] YouTube: abrir, reproducir video, pausar y entrar a playlists desde su biblioteca habitual.
- [ ] Netflix: resolver personalmente el panel de acceso si aparece y reproducir. Registrar Bloqueado si no se puede completar, sin anotar datos de cuenta.
- [ ] Xuper: abrir y reproducir; conservar sesión.
- [ ] HBO Max: abrir y reproducir; conservar perfil y sesión.
- [ ] YouTube Music: probar su acceso, que en este TV abre YouTube, y reproducir música; conservar cuenta.
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
- [x] Botón temporizador entre Wi-Fi y Ajustes abre Tiempo de dormir; Atrás lo cierra sin programar apagado.
- [ ] En una sesión supervisada, elegir un intervalo del temporizador y comprobar apagado real; encender y verificar funciones habituales. No programarlo durante otras pruebas.

## 4. Asistente de HOME: alcance y reversión

- [x] Activado solo HomeKeyService con autorización explícita; otros servicios preservados.
- [x] XML y servicio enlazado comprobados: solo cambios de ventana de Google TV, capacidades adicionales 0; sin lectura de contenido ni filtrado de teclas.
- [x] La activación no concedió ubicación ni escritura de ajustes seguros a la app.
- [x] No interrumpió el panel nativo del temporizador ni el panel de acceso de Google observado en Netflix.
- [ ] Confirmar con uso físico voz, salvapantallas, reproducción, HDMI, TDT y otros ajustes.
- [x] Desactivación devolvió HOME a Google TV; reactivación dejó la nueva interfaz visible.
- [x] Reinicio completo: asistente siguió habilitado y la nueva interfaz apareció sin abrirla desde el PC.
- [ ] Si se fuerza la detención o falla el servicio, Google TV sigue siendo utilizable; la recuperación manual está documentada.

## 5. Fondos, consumo y reposo

- [ ] Opción 3 ocupa la pantalla, reproduce en bucle sin sonido y no muestra saltos molestos en su unión.
- [ ] Corriente suave y estático se pueden seleccionar desde Ajustes del inicio; elección conservada al reabrir.
- [ ] Al abrir otra app o Ajustes se libera el reproductor del fondo; al regresar se reanuda.
- [x] CPU y memoria medidas con asistente apagado/encendido en el mismo APK; seis apps, liberación de video y retornos HOME documentados en PERFORMANCE_APPS.md. Los pocos cuadros UI no certifican fluidez sostenida.
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

Anotar únicamente: fecha/hora aproximada, ID/sección de prueba, modo de fondo, acción, resultado y síntoma. Las evidencias crudas y capturas con datos personales permanecen fuera de GitHub. Resumir resultados técnicos en [Validaciones](VALIDACIONES.md) y el ensayo prolongado en [Prueba dos dias](PRUEBA_DOS_DIAS.md).

Se puede iniciar el ensayo supervisado cuando navegación básica, HOME, reversión y acceso a funciones originales estén comprobados. La entrega completa requiere todas las funciones usadas por el propietario y los dos días de uso. Si falla voz, mando, reproducción, HDMI, TDT, reposo o recuperación, registrar el fallo y corregirlo; no deshabilitar la función para marcar la prueba como aprobada. No prometer ausencia de fallos basándose en una sesión corta.

## Cierre del ensayo

- [ ] Registrar fecha/hora de inicio y cierre y resultados de ambos días en [Prueba de dos días](PRUEBA_DOS_DIAS.md).
- [ ] Revisar incidentes y funciones bloqueadas o sin dispositivo disponible; no convertirlas en aprobadas por haber transcurrido dos días.
- [ ] Confirmar recuperación accesible y decidir fondo final con las observaciones; si se vuelve a Google TV, registrar el motivo.
- [ ] Revisar privacidad del registro antes de publicarlo; conservar evidencias personales solo de forma privada.
