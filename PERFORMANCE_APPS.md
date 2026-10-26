# Rendimiento observado de las apps

Ensayo breve del 25 de octubre de 2026, con opción 3 y asistente HOME activo. Hardware: Android TV 11, cuatro núcleos ARM y 1,5 GiB de RAM visible al sistema. No es una certificación de reproducción sostenida.

## Método

Se abrió cada una de las seis apps principales una vez desde proceso detenido (`am start -W -S`) y otra después de regresar a HOME. No se borraron datos ni se introdujeron credenciales. Tras diez segundos se tomaron dos muestras de CPU de cinco segundos. La memoria es PSS, no reserva permanente de RAM. La CPU es del equipo completo, no únicamente de la app.

El tiempo es el comunicado por Android hasta la actividad inicial, no hasta que el catálogo termine de cargar ni hasta que empiece una película. `UNKNOWN (0)` o cero no significan apertura instantánea; pueden indicar una redirección o una tarea reutilizada. Una sola apertura por caso no determina un intervalo estadístico ni una mejora respecto al inicio de fábrica. Los crudos permanecen privados.

## Resultados

| App | Apertura desde proceso detenido | Regreso/reapertura | CPU total del equipo, mediana | PSS observado |
|---|---:|---:|---:|---:|
| YouTube | 0,90 s | Tarea reutilizada; sin tiempo útil | 24,1 % | 133,2 MiB |
| Netflix | 1,18 s hasta actividad inicial | 1,10 s hasta actividad inicial | No atribuible al catálogo: verificación de acceso | No representa reproducción |
| Xuper | 1,59 s | 1,69 s; Android informó nuevo arranque | 14,8 % | 124,4 MiB |
| HBO Max | 1,63 s | 0,31 s | 25,0 % | 232,9 MiB |
| YouTube Music | Redirige a YouTube | Usa YouTube | No medir como app separada | No medir como app separada |
| Prime Video | 1,56 s | 0,16 s | 22,8 % | 142,0 MiB |

Netflix abrió `AtvAssistedSignInActivity`, un panel de acceso de Google; no se completó ni se capturó información de cuenta. El mismo panel apareció al desactivar el asistente y usar Google TV. Su tiempo no demuestra que el catálogo o la reproducción estén disponibles. YouTube Music llevó a la actividad de YouTube, comportamiento observado de la app instalada.

Durante las seis muestras no había un cliente de video del launcher activo mientras la otra app estaba visible y su CPU en segundo plano fue 0,0 % con la resolución de este contador. Esto significa consumo no detectable en estas ventanas, no consumo matemáticamente nulo. Los doce regresos mediante HOME mostraron la interfaz nueva. Los tiempos de regreso ADB incluyen transporte y sondeo y no son una medida de latencia física del mando.

## Interpretación

La opción 3 no mantuvo su video reproduciéndose encima de las apps probadas. Hay evidencia para comenzar un ensayo supervisado de uso. Todavía deben comprobarse reproducción real, calidad/DRM, voz, HDMI, antena, suspensión y salvapantallas. Netflix necesita resolver su panel de acceso personalmente. La RAM limitada puede hacer que algunas apps se reinicien al volver; el segundo arranque de Xuper se observó, pero no se ha demostrado su causa.

No se puede afirmar que la opción elegida «sirve por completo» solo con estas aperturas. Completar CHECKLIST_VALIDACION.md y PRUEBA_DOS_DIAS.md. Si aparece lentitud al navegar por Home, comparar con el fondo estático manteniendo lo demás igual.

## Reproducir la medición

`python scripts/medir-apps.py --serial '<ip-del-tv>:5555' --adb 'adb'`

La salida cruda queda por defecto en `private/`, excluida de Git. El script detiene y abre únicamente las seis apps indicadas; no borra sus datos, selecciona contenido ni inicia sesiones. Requiere HOME ya comprobado. No usar el mando durante el ensayo para evitar contaminar la medición. El resumen público debe revisarse por privacidad antes de copiarlo al repositorio.

## Comparación breve del asistente en el mismo APK

Con opción 3 y sin asistente: CPU total 7,19 % y 14,80 % en dos muestras de unos diez segundos, PSS del launcher 37,1 MiB. Con asistente: 6,74 % y 9,39 %, PSS 35,1 MiB. La variación del sistema y el tamaño de muestra impiden atribuir la diferencia al asistente o afirmar una mejora; no se observó un incremento evidente en esta sesión. La referencia sin asistente no obtuvo cuadros UI válidos, por lo que su «0 %» de cuadros lentos no se interpreta como prueba de fluidez. La sesión activa registró 12 cuadros UI y ninguno lento, muestra demasiado pequeña para certificar navegación sostenida.
