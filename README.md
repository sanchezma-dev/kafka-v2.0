
# Ejemplo de envío de mensajes kafka (Object y String)

Este es un ejemplo de envío de mensajes desde un productor al consumidor.
El productor tiene dos operativas, una es el envío de mensaje de texto, el cuál será escuchado por el consumidor y guardado en base de datos con usuario genérico.
La segunda operativa es el envío desde el productor de un Objeto Usuario que será capturado por el consumidor y guardado en base de datos.



## Diagrama visual
![image](https://github.com/sanchezma-dev/kafka-v2.0/assets/125487997/45405cc9-6fe7-4656-b88a-d78c3d9b6495)



## Ejecución Kafka

Una vez descarado e instalado zookeeper y kafka, ejecute en el directorio correcto, los siguientes comandos (en orden):

```bash
  zookeeper-server-start.bat ../../config/zookeeper.properties

  kafka-server-start.bat ../../config/server.properties

```
    
