# 🧪 Procesamiento de Transacciones Bancarias con RabbitMQ y Java

---

## 📖 Descripción del Proyecto

Este proyecto implementa un sistema distribuido para el procesamiento de transacciones bancarias utilizando **Java, Maven y RabbitMQ**, aplicando el patrón **Producer–Consumer**.

El sistema consume un lote de transacciones desde una API externa, distribuye cada transacción en colas según el banco destino y posteriormente un consumidor procesa los mensajes enviándolos a otra API para su almacenamiento.

El objetivo es demostrar el uso de **arquitecturas desacopladas basadas en colas de mensajería**.

---

## 🔄 Flujo del Sistema

1. El **Producer** consume el endpoint **GET de transacciones**.

2. Se parsea el **JSON recibido**.

3. Cada transacción se envía a una cola según el valor de **bancoDestino**.

4. **RabbitMQ** almacena los mensajes en las colas correspondientes.

5. El **Consumer** escucha las colas de los bancos.

6. Cada mensaje se envía al endpoint **POST** para ser almacenado.

7. Si el **POST responde exitosamente**, se confirma el mensaje (**ACK**).

---

## 🛡 Manejo de Errores

El sistema implementa:

- ✅ **ACK manual**
- 🔁 **Reintentos de envío**
- ⚠️ **Manejo de excepciones**
- 📄 **Logs informativos**

Si el **POST falla**:

- ❌ El mensaje **NO se elimina de la cola**
- 🔁 Se **reintenta el envío**
- 📥 Si continúa fallando, el mensaje **permanece en RabbitMQ**

---

## 📊 Resultado Esperado

- 🏦 **Colas creadas automáticamente por banco**
- 📩 **Mensajes distribuidos correctamente**
- 💾 **Transacciones almacenadas en la base de datos**

---

## 🎥 VIDEO EJECUCION EN ECLIPSE

🔗  
https://drive.google.com/file/d/1HaYegcL_YwBkYGk0-XBfqVd7CRWkybu2/view?usp=sharing

---

## 👨‍💻 Autor

**Nombre:**  
Josue David Paniagua Olivares  

**Carnet:**  
0905-24-6495  

**Correo:**  
jpaniaguao@miumg.edu.gt

---

## 🎓 Proyecto Académico

**Curso:**  
Arquitectura de Software / Sistemas Distribuidos  

**Universidad:**  
Universidad Mariano Gálvez de Guatemala

---
