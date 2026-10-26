# Ensayo de dos días con opción 3

[Guía del repositorio](GUIA_REPOSITORIO.md) · [Checklist completo](CHECKLIST_VALIDACION.md) · [Manual](MANUAL_USUARIO.md) · [Recuperación](RECUPERACION.md)

La instalación, HOME por ADB, reversión y reinicio ya se comprobaron. Este documento organiza la **prueba física y de uso habitual todavía pendiente**. No hace falta mantener el TV encendido 48 horas: prueba durante dos días de uso normal, incluyendo reposo y reactivación. Mantén opción 3 como principal; cambia a estático solo para comparar un fallo y deja constancia.

**Inicio real, hora de Colombia:** por registrar por el propietario. **Cierre:** por registrar después del segundo día. No se asignan fechas ni se marcan resultados por adelantado.

## Cómo registrar

Marca una casilla al observar el resultado y completa el registro al final. Usa `Correcto`, `Falló`, `Bloqueado` o `Pendiente`. Si no tienes una antena, cable o dispositivo, deja esa función pendiente e indica el motivo; no la consideres validada. Los resultados técnicos previos están en [Validaciones](VALIDACIONES.md) y no sustituyen tu prueba.

No anotes correos, nombres de cuentas/perfiles, contraseñas, PIN, IP, SSID, números de serie, títulos de contenido privado ni capturas con sesiones. Un eventual inicio de sesión de Netflix o verificación del perfil se hace personalmente, sin compartir credenciales.

## Preparación — antes de contar los dos días

- [ ] P01. Confirmar que el TV abre la interfaz nueva y que el fondo seleccionado es opción 3. Anotar si se observa un paso breve por Google TV.
- [ ] P02. Con el mando real, abrir una app y pulsar HOME cinco veces en recorridos separados; siempre debe volver a la interfaz nueva. No detener forzosamente TVHome durante este ensayo normal.
- [ ] P03. Abrir Ajustes originales y comprobar que puedes regresar. Si solicita PIN/verificación, resolverlo personalmente; si no puedes, registrar `Bloqueado`.
- [ ] P04. Tener localizados Entradas, temporizador, ajustes del inicio y la [ruta de recuperación](RECUPERACION.md). No ejecutar una restauración como parte de cada día.
- [ ] P05. Conservar el orden de apps elegido; anotar solo si el orden o el nombre personalizado se pierden, sin copiar el nombre al registro público.

## Día 1 — navegación, apps y mando

- [ ] D1-01. Navegar con flechas, OK y Atrás por la fila, biblioteca y cuatro accesos superiores. Resultado esperado: foco único azul translúcido, iconos visibles, sin bloqueo ni foco perdido.
- [ ] D1-02. Revisar saludo, reloj, día y fecha desde la distancia habitual. Deben ser legibles, sin recortes ni solapamiento con la tarjeta. Confirmar fecha/hora correctas; el saludo cambia a noche a las 18:00 de Colombia.
- [ ] D1-03. Reordenar una app mediante mantener OK → Mover → flechas → OK → Atrás. Salir y volver; debe conservarse el orden elegido.
- [ ] D1-04. YouTube: reproducir 20–30 minutos o durante una sesión habitual, pausar y reanudar; entrar a Biblioteca/Playlists. No publicar información de la cuenta.
- [ ] D1-05. Xuper: reproducir 20–30 minutos o durante una sesión habitual. Comprobar audio, regreso y reapertura. Un nuevo arranque al volver no demuestra por sí solo una regresión.
- [ ] D1-06. Netflix: completar personalmente el acceso si aparece el panel observado de Google; reproducir 20–30 minutos. Si no llegas a reproducir, registrar `Bloqueado`, no `Correcto`.
- [ ] D1-07. HBO Max: reproducir 20–30 minutos; comprobar pausa/reanudación y regreso con HOME. Si no cabe en la sesión de hoy, completar en el día 2 sin marcar antes.
- [ ] D1-08. Probar el micrófono desde una app y desde Home, más botones dedicados de streaming si existen. Debe funcionar sin saltos inesperados al inicio.
- [ ] D1-09. Probar Bluetooth: flechas, OK, Atrás, HOME, silencio y volumen mantenido. Comprobar las funciones IR compatibles sin borrar el emparejamiento; si no puedes aislar IR, dejarlo pendiente.
- [ ] D1-10. Dejar el TV sin tocar el mando hasta el tiempo habitual de salvapantallas. Debe aparecer el original, sin que el launcher lo interrumpa. Salir con el mando y verificar recuperación de imagen/sonido.
- [ ] D1-11. Al terminar el resto, abrir el temporizador y elegir un intervalo nativo, por ejemplo 15 minutos. Esperar el apagado sin otra prueba simultánea. Volver a encender y comprobar que la sesión normal se recupera. No confundir el temporizador con suspender manualmente el TV.

## Día 2 — persistencia, entradas y uso prolongado

- [ ] D2-01. Tras el encendido habitual comprobar HOME, opción 3, orden, nombre local, red y sesiones. El reinicio completo ya tuvo una prueba técnica; repetirlo desde la opción normal del TV solo si quieres comprobar persistencia adicional, sin desconectarlo de la corriente a la fuerza.
- [ ] D2-02. Prime Video: reproducir al menos 10–15 minutos o una sesión habitual; comprobar audio, regreso y reapertura.
- [ ] D2-03. YouTube Music: abrir el acceso, que en este TV lleva a YouTube, y probar reproducción musical. Evaluar el acceso, no asumir que hay una app independiente distinta.
- [ ] D2-04. Repetir YouTube y Xuper o las apps más utilizadas después de alternar entre varias. Buscar lentitud progresiva, cierres, audio cortado o pantalla negra; registrar cuándo aparece.
- [ ] D2-05. Conectar Xbox o portátil y probar HDMI 1 y HDMI 2: imagen, audio, selección desde Entradas y retorno con HOME. Probar CEC si lo usas. Si solo se prueba un puerto, el otro queda pendiente.
- [ ] D2-06. Con antena disponible, abrir TV digital/TDT, cambiar canales y verificar sonido/imagen y regreso. No borrar canales ni resintonizar para una prueba básica.
- [ ] D2-07. Duplicar/enviar contenido desde el dispositivo habitual. Debe poder reproducirse sin que el asistente abra el inicio por su cuenta.
- [ ] D2-08. Abrir Play Store y comprobar que los ajustes de actualizaciones sigan disponibles; no es necesario instalar actualizaciones para validar el acceso. Si ya tienes navegador, probarlo; si no, registrar que no está instalado.
- [ ] D2-09. Revisar la tarjeta de Millonarios: escudo visible, rival, fecha, hora de Colombia y línea secundaria legibles. Contrastar la programación si vas a depender de ella; no es un marcador en vivo.
- [ ] D2-10. Opcionalmente, desde el mando y teniendo localizada la reconexión, desactivar Wi-Fi brevemente: el inicio y escudo deben seguir visibles. Reconectar al terminar. ADB sobre Wi-Fi se desconectará durante esa prueba; no es un fallo del launcher.
- [ ] D2-11. Si la caché deportiva sigue vigente, la tarjeta puede no indicar la caída de red inmediatamente. Si falla una consulta real, revisar el estado de dato guardado; sin fecha futura fiable debe decir Programación por confirmar. No cambiar fecha/hora ni borrar datos para forzar ese caso. Si no ocurre, dejarlo pendiente en el checklist completo.
- [ ] D2-12. Abrir ajustes del inicio y probar brevemente corriente suave y estático. Salir y volver para comprobar guardado; si verificas un reinicio con un modo alternativo, registrar cuál. Terminar regresando a opción 3 si se comporta bien.
- [ ] D2-13. Tras otra sesión de reproducción, probar suspensión/reactivación y salvapantallas otra vez. No debe quedar video de fondo sonando, pantalla siempre encendida ni bucles de redirección.

## Si aparece un problema

1. Registrar el ID de prueba, modo, app/entrada, síntoma y frecuencia. Distinguir carga de red, acceso de cuenta, reproducción y navegación.
2. Si es lentitud en el inicio, cambiar solo a estático y repetir la misma acción. Anotar si mejora; no variar red, calidad y varias opciones simultáneamente.
3. Si se interrumpe voz, HDMI, TDT, reproducción o reposo por redirecciones, usar la [desactivación del asistente](RECUPERACION.md) y comprobar el comportamiento original. Comunicar el resultado antes de otra modificación.
4. No borrar datos, quitar servicios, modificar límites de procesos ni restablecer el TV para ocultar el fallo. No continuar una prueba que deja el TV inutilizable.

## Registro del propietario

| Fecha/hora Colombia | ID | App/entrada y modo | Correcto / Falló / Bloqueado / Pendiente | Síntoma, frecuencia y comparación |
|---|---|---|---|---|
| Por registrar | — | — | Pendiente | — |

Añadir las filas necesarias. Una observación como «inicio de sesión pendiente» es suficiente; no incluir la identidad ni el texto privado del formulario. Publicar solo la versión revisada de este registro.

## Cierre y decisión

- [ ] C01. Todos los recorridos de uso obligatorio tienen resultado; funciones sin dispositivo o sin acceso siguen explícitamente pendientes.
- [ ] C02. No se detectaron regresiones en las funciones habituales respecto al inicio original durante los dos días.
- [ ] C03. HOME, orden, fondo y nombre local siguen disponibles al finalizar; no hay cierres o redirecciones repetidos.
- [ ] C04. Completar los pendientes correspondientes del [checklist maestro](CHECKLIST_VALIDACION.md) sin sobrescribir la evidencia técnica previa.
- [ ] C05. Elegir y registrar: continuar opción 3 / usar corriente / usar estático / volver temporalmente a Google TV. Justificar con las observaciones, no solo con los tiempos breves de apertura.

**Estado actual del ensayo:** pendiente de registro del propietario. Completar dos días no garantiza ausencia de cualquier fallo futuro; permite decidir con evidencia de uso real.
