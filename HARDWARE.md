# Hardware y sistema del TV consultado

Modelo comercial: Challenger LED 32KG84 BT T2. Fabricante/plataforma reportados por el sistema: KTC, `mountbaker`, Realtek `rtd2841a`. Datos consultados el 25 de octubre de 2026. No se publican identificadores del equipo ni datos de red.

| Característica | Resultado | Fuente |
|---|---|---|
| Pantalla | 32 pulgadas, 1366 × 768 a 60 Hz | Manual del fabricante |
| Resolución de interfaz Android | 1280 × 720 | `wm size` y capturas |
| CPU | Cuatro núcleos ARM; máximo reportado 1,4 GHz | `/proc/cpuinfo`, cpufreq |
| SoC | Realtek RTD2841A | Propiedades de Android |
| GPU | ARM Mali-G31; OpenGL ES 3.2 | SurfaceFlinger |
| RAM visible para Android | 1.572.864 KiB = 1,5 GiB | `/proc/meminfo` |
| Almacenamiento para datos/apps | Partición de unos 4 GiB; unos 2 GiB libres al consultar | `df -h /data` |
| Capacidad física total de almacenamiento | No confirmada; lectura de dispositivo bloqueada | No se infiere de `/data` |
| Apps admitidas por el sistema | ABI `armeabi-v7a`, 32 bits | Propiedades de Android |
| Sistema | Google TV sobre Android TV 11, SDK 30 | Propiedades de Android |
| Seguridad del firmware | Parche reportado 2024-09-01; arranque verificado activo | Propiedades de Android |
| Conectividad | Wi-Fi, Wi-Fi Direct, Ethernet, Bluetooth y BLE | Funciones declaradas por Android |
| Entradas | Dos HDMI registrados, AV y sintonizador digital | `dumpsys tv_input` |
| TV abierta | DVB-T2/TDT | Modelo/manual y sintonizador existente |
| Audio | 2 × 8 W según el manual | Manual del fabricante |

No se confirmó la versión exacta de Bluetooth ni la RAM física instalada antes de reservas del sistema. La frecuencia de CPU es su máximo declarado, no una frecuencia constante. La resolución del compositor no debe confundirse con la matriz del panel.

Manual oficial: https://challengerco.vteximg.com.br/arquivos/manual_usuario_32KG84.pdf
