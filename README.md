# 🤖 Ejercicios con Rux

Aplicación Android integrada en el robot social Rux, diseñada para recibir comandos Bluetooth desde una tablet y ejecutar rutinas de ejercicio físico mediante voz, gestos, expresiones y movimientos coordinados.

---

## 📱 Descripción
Esta app actúa como el intérprete inteligente de los comandos enviados por la tablet. Por cada mensaje recibido, Rux:

- Narra instrucciones con TTS.

- Realiza gestos con sus motores.

- Cambia de expresión facial.

- Coordina su comportamiento con los pasos de la rutina visualizada en la tablet.

Todo ello ofrece una experiencia inmersiva y motivacional durante el entrenamiento.

---
## 🔌 Conectividad

- Utiliza Bluetooth Classic (RFCOMM) como canal de comunicación.

- Espera una conexión entrante en un socket servidor con el UUID estándar del perfil SPP.

- Cada comando recibido se traduce en acciones sincronizadas a través del SDK oficial de Letianpai.

---

## 🧠 Arquitectura

BluetoothServerThread: escucha conexiones entrantes desde la tablet.

- CommandParser: interpreta cada comando recibido.

- SharedServices: Singleton que gestiona servicios de Rux (voz, gestos, luces, expresiones...).

- Letianpai SDK: interfaz para acceder al hardware y comportamiento del robot.

---

## ⚙️ Requisitos

- Robot Rux encendido y con esta app ejecutándose.

- Aplicación compañera "Rutina de entrenamiento" instalada en la tablet.

---

## 🧪 Funcionamiento

1. La tablet envía un comando como "ROTACION_BRAZOS" vía Bluetooth.

2. La app en Rux lo recibe mediante BluetoothServerThread.

3. El comando se interpreta y se lanza la acción correspondiente:

  - Voz: "Ahora mueve los brazos de forma circular."

  - Movimientos representativos + expresión facial de ánimo.

4. Espera el siguiente comando.

---

## 🧩 Licencia
Este proyecto ha sido desarrollado como parte de un Trabajo de Fin de Grado con fines académicos y experimentales.
