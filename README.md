# Challenger Home — candidato para 32KG84 BT T2

Adaptación personal de [cleanyourtv](https://github.com/Gathin23/cleanyourtv), base `5ee685b02014fa502ea0951ee1f49abd7ee2e8c1`, para un Challenger Google TV con plataforma KTC/Realtek. No es firmware ni un producto oficial de Challenger.

**Estado:** apariencia aprobada por el propietario; publicación e instalación autorizadas en `dev-TV`. Los ensayos iniciales son del renderizador temporal, no una certificación del launcher integrado. El estado de instalación y la prueba de dos días se actualizan en `ESTADO_INSTALACION.md`.

## Diseño elegido

- Principal: opción 3, video local de placa electrónica, 720p/30 fps, silencioso.
- Alternativas: Digital y microchips con corriente suave (~15 fps), y la misma imagen estática.
- Seis apps: YouTube, Netflix, Xuper, HBO Max, YouTube Music y Prime Video. Se usan sus iconos de Android, no copias incluidas en el repositorio.
- Solo la app enfocada tiene resaltado azul. Saludo/reloj/fecha a la izquierda; Entradas/red/temporizador/Ajustes a la derecha.
- Ajustes conserva el panel original del TV. El menú propio permite cambiar fondos; mantener OK sobre una app permite moverla.
- Tarjeta de Millonarios FC debajo de los botones: agenda del club, hora de Colombia, caché, sin sondeo continuo.
- Se conservan TDT, HDMI, voz, Bluetooth/infrarrojos, duplicación, Play Store, actualizaciones y salvapantallas existentes.

## Documentación

- [Manual de usuario](MANUAL_USUARIO.md).
- [Checklist obligatorio de validación](CHECKLIST_VALIDACION.md).
- [Recursos de terceros](RECURSOS_TERCEROS.md).
- [Diferencias respecto al original](CAMBIOS_RESPECTO_AL_ORIGINAL.md).
- [Hardware verificado](HARDWARE.md).
- [Validaciones y límites](VALIDACIONES.md).
- [Recuperación](RECUPERACION.md).
- [Publicación y privacidad](PUBLICACION.md).
- [Prueba de dos días](PRUEBA_DOS_DIAS.md).

## Construcción

Requisitos: JDK 17, Android SDK platform 34, build-tools 34.0.0, ADB y un video local de uso autorizado. La base utiliza Gradle 8.9, Android Gradle Plugin 8.5.2 y AndroidX.

```powershell
./scripts/preparar-media.ps1 -Video 'ruta/al/video-opcion-3.mp4' -Ffmpeg 'ruta/a/ffmpeg.exe'
./scripts/compilar.ps1 -SdkRoot 'ruta/al/Android/Sdk' -JdkRoot 'ruta/al/jdk-17'
```

Se incluye la copia optimizada de la opción 3 aportada por el propietario y su fotograma, sin metadatos personales. No se declara ese video bajo MIT ni se establece una licencia general de redistribución sobre él. El dibujo procedural y sus pistas acompañan al código. Las marcas e iconos pertenecen a sus titulares y se consultan en las apps instaladas. Se conserva la licencia MIT original en `UPSTREAM-LICENSE`.

El script de instalación no desactiva el inicio original ni paquetes del sistema. La carpeta `respaldo/` contiene solo una copia técnica anonimizada; el respaldo completo, cuentas, identificadores y claves permanecen fuera de GitHub.

### Prueba aislada del script de accesibilidad

Ejecuta `./tests/Test-AsistenteHome.ps1` para probar su manejo de listas con un ADB simulado. Esta prueba no contacta el TV ni habilita servicios. La activación real es una operación separada y requiere autorización del propietario.
