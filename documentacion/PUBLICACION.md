# Publicación en GitHub y privacidad

[Guía](GUIA_REPOSITORIO.md) · [Créditos](CREDITOS_Y_LICENCIAS.md) · [Advertencias](ADVERTENCIAS_Y_RESPONSABILIDAD.md)

Rama autorizada: `dev-TV` del repositorio público `dagdmfc1946/New-interface-Challenger-TV`. El propietario aprobó publicar y después instalar. La carpeta candidata se preparó por separado para no mezclarla con los respaldos privados. Los commits usan una dirección noreply de GitHub para no publicar una dirección personal de correo.

## Contenido apropiado

Código de la adaptación y atribución upstream, scripts reproducibles, dibujos procedurales, manual, hardware sin identificadores, decisiones, resultados agregados y estado de las pruebas. Conservar `UPSTREAM-LICENSE`. Las marcas e iconos son propiedad de sus titulares; se obtienen de las apps instaladas en tiempo de ejecución, no se distribuyen APK de terceros.

## Contenido excluido

Respaldos completos (incluso cifrados), getprop/dumpsys completos, IP/SSID/MAC/serial/Android ID/cuentas, claves ADB, claves de firma, `local.properties`, caches, builds, APK de apps del TV y archivos privados del equipo. La copia pública de `respaldo/` contiene únicamente datos técnicos de una lista permitida y se inspecciona también dentro del ZIP. El video seleccionado y su poster se incluyen por solicitud del propietario, sin metadatos personales y sin declararlos MIT. Los clips descartados no se publican.

La historia debe distinguir claramente ensayos temporales, candidata compilada, instalación final y prueba de dos días. No marcar TDT, voz o uso prolongado como validados antes de hacerlo. Antes del push revisar también imágenes, PDFs y metadatos, no solo texto. No usar `git add .` desde la carpeta que contiene los respaldos.

## Estructura documental y revisión

El único Markdown fuera de `documentacion/` es el README principal. Los demás se organizan allí, preservando `documentacion/tasks/` y `documentacion/respaldo/`. Los datos de respaldo siguen en `respaldo/`, los scripts en `scripts/` y el código en `launcher/`; mover manuales no cambia las rutas operativas ni requiere reinstalar.

Antes del push comprobar enlaces relativos, estado de validación, separación entre evidencia técnica y ensayo pendiente y privacidad. Verificar también que `UPSTREAM-LICENSE` y la licencia de la fuente sigan presentes e intactas. No publicar resultados de dos días hasta que el propietario los registre. Mantener la responsabilidad de uso, créditos e indicación de seguir el upstream en el README.

Los permisos de redistribución del video y del escudo no se dan por acreditados por esta auditoría de privacidad; revisar [Recursos de terceros](RECURSOS_TERCEROS.md) y [Advertencias](ADVERTENCIAS_Y_RESPONSABILIDAD.md) antes de una distribución amplia.
