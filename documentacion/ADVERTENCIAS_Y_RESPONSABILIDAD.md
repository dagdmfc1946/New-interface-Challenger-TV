# Advertencias y responsabilidad de uso

[Guía del repositorio](GUIA_REPOSITORIO.md) · [Créditos y licencias](CREDITOS_Y_LICENCIAS.md) · [Recuperación](RECUPERACION.md)

## Uso bajo responsabilidad de cada usuario

Este repositorio comparte una adaptación no oficial y resultados de un televisor concreto. **Quien decida replicarla lo hace bajo su responsabilidad**, debe verificar compatibilidad, entender los comandos y permisos, conservar respaldos y respetar licencias y condiciones de los servicios. No se ofrece garantía de funcionamiento, disponibilidad, recuperación completa ni compatibilidad universal. Tampoco se ofrece soporte oficial de Challenger, Google, Gathin o los demás titulares mencionados.

Esta advertencia no elimina obligaciones legales que pudieran corresponder ni concede derechos sobre contenido de terceros. No sustituye las condiciones del fabricante, de las plataformas ni las licencias conservadas en el repositorio. El texto de la licencia MIT de la base permanece en [UPSTREAM-LICENSE](../UPSTREAM-LICENSE).

## Antes de replicar

1. Leer y seguir el [README e instrucciones de Clean Your TV](https://github.com/Gathin23/cleanyourtv#readme), verificando su documentación por modelo y los [créditos de esta base](CREDITOS_Y_LICENCIAS.md).
2. Revisar [Hardware](HARDWARE.md) y [Cambios](CAMBIOS_RESPECTO_AL_ORIGINAL.md). No ejecutar listas de desactivación o comandos de otro modelo por similitud de marca.
3. Entender la [recuperación](RECUPERACION.md) y que el respaldo disponible es técnico: **no es una imagen de firmware ni copia de cuentas/sesiones**.
4. Revisar el [permiso de accesibilidad de HOME](ASISTENTE_HOME.md), concederlo de forma consciente y verificar voz, entradas, reproducción y reposo mediante el [checklist](CHECKLIST_VALIDACION.md).
5. Mantener claves, copias privadas y datos del TV fuera de GitHub. No confundir que algo sea público en una web con que tenga licencia de redistribución.

## Consecuencias posibles en el TV

Se instaló una app por ADB y se activó accesibilidad; no se hizo root, desbloqueo del arranque ni flasheo. El inicio original se conserva. Esta menor intervención no es una garantía de riesgo cero: puede haber cierres, redirecciones inesperadas, cambios tras una actualización del sistema, consumo de recursos o diferencias en teclas/entradas y reposo.

El fondo animado usa recursos mientras el inicio está visible; las mediciones son breves y no prueban estabilidad térmica o reproducción durante días. La configuración mantiene los salvapantallas originales; hay que comprobar que realmente se activen y no dejar elementos fijos durante sesiones prolongadas. Ver [Prueba de dos días](PRUEBA_DOS_DIAS.md).

Accesibilidad es un permiso sensible. Esta versión limita eventos y capacidades, pero no debes conceder el mismo nivel de confianza a un APK distinto o a una modificación no revisada. ADB permite operar el dispositivo autorizado: no lo expongas a Internet mediante redirección de puertos ni autorices ordenadores desconocidos. Al terminar las pruebas puedes valorar desactivar depuración; el launcher y su asistente no dependen de una conexión ADB permanente, pero los scripts de recuperación sí necesitan poder volver a conectarse.

### Garantía y soporte del fabricante

El [manual oficial del 32KG84 BT T2](https://challengerco.vteximg.com.br/arquivos/manual_usuario_32KG84.pdf#page=4) incluye exclusiones relacionadas con apps fuera de Google Play y root. Este launcher se instaló por ADB, fuera de esa tienda: **puede afectar soporte o garantía**. No se afirma pérdida automática de toda cobertura ni ausencia de impacto. Consulta el caso concreto con Challenger; desinstalar la app no garantiza una decisión favorable sobre garantía.

## Consecuencias de publicar en GitHub

- Un repositorio público permite que otros vean, descarguen o creen forks. Hacerlo privado después no elimina copias previas: [documentación de GitHub](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository).
- Hay que mantener copyright, avisos y licencias de la base y de las fuentes. La MIT del código de origen no licencia automáticamente videos, escudos, marcas o contenido de streaming.
- La procedencia del video aportado y del escudo está documentada, pero **no se ha acreditado una licencia de redistribución general de esos recursos**. Su publicación puede generar una reclamación o petición de retirada. Antes de promover o distribuir ampliamente el repositorio, verificar permisos, reemplazarlos por recursos propios/autorizados o adaptar el proyecto para aportarlos localmente.
- Añadir créditos o una cláusula de responsabilidad no corrige una falta de permiso sobre un recurso. La autoría y el soporte de esta adaptación no deben atribuirse al proyecto original ni al fabricante.
- Publicar el código no otorga por sí solo acceso remoto al TV. El riesgo de exponerlo depende también de la red, ADB, claves y datos compartidos. Los respaldos completos y credenciales no forman parte de este repositorio; una auditoría negativa de patrones no garantiza que cualquier futura contribución sea privada.
- No se distribuyen APK de apps del TV ni películas, música, enlaces de suscripción o credenciales. Un acceso a una app no concede derechos sobre su contenido ni evita cumplir sus condiciones.

## Si detectas una regresión

Detener el ensayo que falla, registrar únicamente datos técnicos sin identidad, comparar con estático si se trata de lentitud del inicio y usar la [reversión](RECUPERACION.md) si la redirección interrumpe funciones. No ocultar el problema deshabilitando servicios esenciales ni aplicar un restablecimiento de fábrica como primer paso de esta adaptación.

Consulta técnica y documental realizada el 25 de octubre de 2026. Las condiciones de sitios, servicios y fabricantes pueden cambiar; antes de replicar deben consultarse sus versiones vigentes.
