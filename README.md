# Challenger Home — Challenger 32KG84 BT T2

Interfaz personal basada en [cleanyourtv](https://github.com/Gathin23/cleanyourtv), revisión `5ee685b02014fa502ea0951ee1f49abd7ee2e8c1`, para un Google TV Challenger con plataforma KTC/Realtek. No es firmware ni un producto oficial de Challenger.

**Estado:** instalada en el TV; HOME redirige mediante un asistente de accesibilidad autorizado. Google TV sigue instalado y habilitado. Reversión, reinicio y aperturas de apps comprobados; pruebas físicas y ensayo de dos días pendientes. Consulta el [estado actualizado](documentacion/ESTADO_INSTALACION.md).


**Advertencia:** adaptación no oficial, sin garantía de compatibilidad o funcionamiento y bajo responsabilidad de quien la replique. Antes de instalar, lee las [advertencias, incluida la garantía y recursos de terceros](documentacion/ADVERTENCIAS_Y_RESPONSABILIDAD.md), los [créditos y licencias](documentacion/CREDITOS_Y_LICENCIAS.md) y **sigue las [instrucciones de Clean Your TV](https://github.com/Gathin23/cleanyourtv#readme)** para tu modelo junto con las notas de esta adaptación.

## Empieza aquí

1. [Guía e índice del repositorio](documentacion/GUIA_REPOSITORIO.md): qué contiene cada carpeta y qué leer según tu objetivo.
2. [Manual de usuario](documentacion/MANUAL_USUARIO.md): mando, apps, fondos, temporizador y personalización.
3. [Prueba de dos días](documentacion/PRUEBA_DOS_DIAS.md): recorrido diario y registro de resultados.
4. [Checklist completo](documentacion/CHECKLIST_VALIDACION.md): evidencia técnica y verificaciones que faltan.
5. [Recuperación](documentacion/RECUPERACION.md): desactivar la redirección y regresar a Google TV.

Toda la documentación Markdown está en [documentacion/](documentacion/), excepto este README principal.

## Interfaz instalada

- Principal: opción 3, video local de placa electrónica, 720p/30 fps, sin audio. Alternativas: Digital y microchips con corriente suave (~15 fps) y la misma imagen estática.
- Saludo de 22 sp en negrilla, reloj de 72 sp y día/fecha de 20 sp; nombre guardado solo en el TV.
- Iconos originales ampliados y redondeados, orden editable y un único resaltado azul translúcido.
- Entradas, red, temporizador nativo y Ajustes originales en la parte superior derecha.
- Agenda de Millonarios FC con escudo local, hora de Colombia y caché.
- No se deshabilitaron apps ni servicios originales. Voz, TDT, HDMI, duplicación y salvapantallas requieren completar las pruebas físicas documentadas.

## Código y construcción

El proyecto Android está en [launcher/](launcher/) y las utilidades en [scripts/](scripts/). Ejecuta los comandos desde la **raíz del repositorio**, no desde `documentacion/`.

Requisitos: JDK 17, Android SDK platform 34, build-tools 34.0.0 y ADB. Base de compilación: Gradle 8.9, AGP 8.5.2 y AndroidX.

```powershell
./scripts/preparar-media.ps1 -Video 'ruta/al/video-opcion-3.mp4' -Ffmpeg 'ruta/a/ffmpeg.exe'
./scripts/compilar.ps1 -SdkRoot 'ruta/al/Android/Sdk' -JdkRoot 'ruta/al/jdk-17'
./tests/Test-AsistenteHome.ps1
```

La última prueba usa ADB simulado: no contacta el TV ni habilita accesibilidad. La instalación y activación reales se explican en [Recuperación y operación de HOME](documentacion/RECUPERACION.md) y [Alcance del asistente](documentacion/ASISTENTE_HOME.md); no son necesarias para consultar este repositorio.

## Evidencia y privacidad

- [Hardware](documentacion/HARDWARE.md), [validaciones](documentacion/VALIDACIONES.md) y [rendimiento de apps](documentacion/PERFORMANCE_APPS.md).
- [Resumen de compilación y hash del APK](VERIFICACION_COMPILACION.json) y [auditoría de publicación](AUDITORIA_PUBLICACION.json).
- [Respaldo técnico anonimizado](documentacion/respaldo/README.md); sus archivos están en [respaldo/](respaldo/). No es una imagen del firmware.

No se publican cuentas, credenciales, datos de red, nombre personalizado, capturas privadas, respaldos completos ni claves. Consulta [Publicación y privacidad](documentacion/PUBLICACION.md).

El video aportado por el propietario, el escudo y las marcas no se declaran MIT. El código conserva la [licencia upstream](UPSTREAM-LICENSE); las fuentes tienen su licencia en el proyecto. Los iconos se obtienen de las apps instaladas. Consulta [Recursos de terceros](documentacion/RECURSOS_TERCEROS.md).
