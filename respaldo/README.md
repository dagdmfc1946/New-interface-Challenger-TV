# Copia técnica anonimizada del respaldo

Por instrucción del propietario no se publica ningún respaldo completo, ni siquiera cifrado. El original, su copia cifrada y la clave se conservan exclusivamente en su PC. Esta carpeta contiene una **selección técnica anonimizada**, derivada del respaldo inicial: estados de paquetes, componente HOME original, hardware no identificador y una lista permitida de ajustes técnicos recuperables.

Se excluyen cuentas, contraseñas, claves Wi-Fi, IP, SSID, MAC, números de serie, Android ID, identificadores Bluetooth, rutas privadas, registros y volcados completos. `metadata.json` identifica únicamente el archivo anonimizado y su hash.

## Alcance

La copia pública sirve como referencia de configuración técnica. No reemplaza el original privado y no permite recuperar cuentas o sesiones. El script `scripts/descifrar_respaldo.py` se conserva como utilidad para las copias cifradas que el propietario guarda localmente; no se incluye la clave ni el archivo cifrado en GitHub.

Ninguna de estas copias es una imagen de firmware ni garantiza rescatar un TV que no arranque. No restaures todos los ajustes a ciegas: usa los registros para revertir los cambios efectivamente realizados.
