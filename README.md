🧪 Procesamiento de Transacciones Bancarias con RabbitMQ y Java
📖 Descripción del Proyecto

Este proyecto implementa un sistema distribuido para el procesamiento de transacciones bancarias utilizando Java, Maven y RabbitMQ, aplicando el patrón Producer–Consumer.

El sistema consume un lote de transacciones desde una API externa, distribuye cada transacción en colas según el banco destino y posteriormente un consumidor procesa los mensajes enviándolos a otra API para su almacenamiento.

El objetivo es demostrar el uso de arquitecturas desacopladas basadas en colas de mensajería.

🔄 Flujo del Sistema

El Producer consume el endpoint GET de transacciones.

Se parsea el JSON recibido.

Cada transacción se envía a una cola según el valor de bancoDestino.

RabbitMQ almacena los mensajes en las colas correspondientes.

El Consumer escucha las colas de los bancos.

Cada mensaje se envía al endpoint POST para ser almacenado.

Si el POST responde exitosamente, se confirma el mensaje (ACK).

🛡 Manejo de Errores

El sistema implementa:

ACK manual

Reintentos de envío

Manejo de excepciones

Logs informativos

Si el POST falla:

El mensaje NO se elimina de la cola

Se reintenta el envío

Si continúa fallando, el mensaje permanece en RabbitMQ

📊 Resultado Esperado

Colas creadas automáticamente por banco

Mensajes distribuidos correctamente

Transacciones almacenadas en la base de datos

👨‍💻 Autor

Nombre: Josue David Paniagua Olivares
Carnet: 0905-24-6495
Correo: jpaniaguao@miumg.edu.gt

🎓 Proyecto Académico

Curso: Arquitectura de Software / Sistemas Distribuidos
Universidad: Universidad Mariano Gálvez de Guatemala
