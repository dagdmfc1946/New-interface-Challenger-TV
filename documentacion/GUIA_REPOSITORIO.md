# Cómo leer y navegar este repositorio

[Volver al README principal](../README.md)

La rama de trabajo publicada es `dev-TV`. Si GitHub muestra `main`, cambia a `dev-TV` en el selector de ramas antes de buscar estos archivos. La documentación corresponde a una adaptación instalada en un TV concreto, no a una certificación universal de otros modelos.

Antes de replicar o redistribuir, leer [Advertencias y responsabilidad](ADVERTENCIAS_Y_RESPONSABILIDAD.md) y [Créditos y licencias](CREDITOS_Y_LICENCIAS.md), y seguir las instrucciones enlazadas del proyecto original.

## Ruta de lectura

| Quiero… | Leer primero | Continuar con |
|---|---|---|
| Usar el TV | [Manual de usuario](MANUAL_USUARIO.md) | [Prueba de dos días](PRUEBA_DOS_DIAS.md) |
| Saber qué está comprobado | [Estado instalado](ESTADO_INSTALACION.md) | [Validaciones](VALIDACIONES.md) y [checklist](CHECKLIST_VALIDACION.md) |
| Evaluar consumo y aperturas | [Rendimiento de apps](PERFORMANCE_APPS.md) | [Hardware](HARDWARE.md) y límites del ensayo |
| Entender qué cambió | [Cambios respecto al original](CAMBIOS_RESPECTO_AL_ORIGINAL.md) | [Asistente HOME](ASISTENTE_HOME.md) |
| Volver a Google TV | [Recuperación](RECUPERACION.md) | [Alcance del respaldo](respaldo/README.md) |
| Publicar o contribuir | [Publicación y privacidad](PUBLICACION.md) | [Créditos](CREDITOS_Y_LICENCIAS.md), [advertencias](ADVERTENCIAS_Y_RESPONSABILIDAD.md) y [recursos de terceros](RECURSOS_TERCEROS.md) |
| Consultar cómo se organizó el trabajo | [Plan de implementación](tasks/plan.md) | [Seguimiento](tasks/todo.md) |

## Mapa de carpetas y archivos

```text
README.md                         Entrada principal y enlaces
 documentacion/                   Todos los demás Markdown
   GUIA_REPOSITORIO.md             Este índice y mapa
   PRUEBA_DOS_DIAS.md              Protocolo y registro del ensayo
   CHECKLIST_VALIDACION.md         Evidencia y pendientes completos
   tasks/                         Plan y seguimiento
   respaldo/README.md             Explicación de la copia anonimizada
 launcher/                        Proyecto Android y recursos de la interfaz
 scripts/                         Compilación, instalación, HOME y medición
 tests/                           Pruebas del asistente con ADB simulado
 respaldo/                        ZIP técnico anonimizado y metadata.json
 VERIFICACION_COMPILACION.json     Pruebas, lint, tamaño y SHA256 del APK
 AUDITORIA_PUBLICACION.json        Resultado agregado de privacidad
 UPSTREAM-LICENSE                 Licencia de la base
```

Las rutas dentro de comandos y bloques de código son relativas a la raíz del repositorio. Los enlaces de los documentos sí resuelven desde su propia carpeta. Para ejecutar comandos en PowerShell, abre primero la carpeta del repositorio; leer un manual no requiere ejecutar scripts.

## Código: dónde encontrar cada función

Ruta base: [launcher/app/src/main/](../launcher/app/src/main/).

| Función | Archivo o carpeta |
|---|---|
| Inicio, navegación y accesos | [MainActivity.java](../launcher/app/src/main/java/com/gathin/tvhome/MainActivity.java) |
| Video, corriente y estático | [ChallengerBackdrop.java](../launcher/app/src/main/java/com/gathin/tvhome/ChallengerBackdrop.java) |
| Agenda y escudo | [MillosPanel.java](../launcher/app/src/main/java/com/gathin/tvhome/MillosPanel.java) y [parser](../launcher/app/src/main/java/com/gathin/tvhome/MillosFixtureParser.java) |
| Redirección de HOME | [HomeKeyService.java](../launcher/app/src/main/java/com/gathin/tvhome/HomeKeyService.java) y [configuración de accesibilidad](../launcher/app/src/main/res/xml/home_key_service.xml) |
| Iconos y selección | [AppAdapter.java](../launcher/app/src/main/java/com/gathin/tvhome/AppAdapter.java) y [GlassView.java](../launcher/app/src/main/java/com/gathin/tvhome/GlassView.java) |
| Saludo colombiano | [ColombiaGreeting.java](../launcher/app/src/main/java/com/gathin/tvhome/ColombiaGreeting.java) |
| Pantalla y valores iniciales | [activity_main.xml](../launcher/app/src/main/res/layout/activity_main.xml) y [config.xml](../launcher/app/src/main/res/values/config.xml) |
| Ajustes locales de la interfaz | [LauncherSettingsActivity.java](../launcher/app/src/main/java/com/gathin/tvhome/LauncherSettingsActivity.java) |

## Scripts: leer su propósito antes de ejecutarlos

| Script | Alcance |
|---|---|
| [compilar.ps1](../scripts/compilar.ps1) | Compila el proyecto local; no instala en el TV |
| [preparar-media.ps1](../scripts/preparar-media.ps1) | Prepara el video local y su fotograma |
| [instalar-candidata.ps1](../scripts/instalar-candidata.ps1) | Instala y abre la app; `-Activar` también habilita el asistente |
| [asistente-home.ps1](../scripts/asistente-home.ps1) | Habilita la redirección; `-Desactivar` la retira conservando otros servicios |
| [restaurar-inicio.ps1](../scripts/restaurar-inicio.ps1) | Desactiva el asistente y restablece Google TV |
| [medir-apps.py](../scripts/medir-apps.py) | Abre las seis apps y toma métricas; guarda crudos en `private/` |
| [descifrar_respaldo.py](../scripts/descifrar_respaldo.py) | Utilidad para el respaldo cifrado privado; no contiene claves ni el respaldo completo |
| [Test-AsistenteHome.ps1](../tests/Test-AsistenteHome.ps1) | Verifica el script con un ADB simulado, sin TV |

## Cómo interpretar el estado

Una casilla marcada indica evidencia descrita, que puede ser prueba automatizada, ADB o confirmación del propietario. No implica que la reproducción, el mando o un cable físico hayan sido probados si el texto no lo indica. [Validaciones](VALIDACIONES.md) separa ensayos temporales del launcher integrado. [Prueba de dos días](PRUEBA_DOS_DIAS.md) sigue pendiente hasta registrar uso real.

El hash del APK instalado se consulta en el [resumen de compilación](../VERIFICACION_COMPILACION.json). La reorganización de documentación no requiere reinstalar el TV. Para comparar versiones o consultar decisiones anteriores, usa el historial de commits de `dev-TV`; no uses instrucciones históricas como estado actual.

## Qué no encontrarás aquí

No hay APKs de streaming, credenciales, nombre personalizado, claves, datos privados de red, respaldos completos ni capturas con cuentas. La [copia pública](respaldo/README.md) es una selección técnica anonimizada. No basta para restaurar firmware, cuentas o sesiones.
