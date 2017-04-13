#!/bin/bash

/home/malczyk/Devel/tools/spark/bin/spark-submit \
	--master spark://192.168.2.11:7077 \
	--class example.JdbcDemo \
	--driver-class-path /VMS/repos/spark/mysql-connector-java-5.1.41.jar \
	--jars /VMS/repos/spark/mysql-connector-java-5.1.41.jar \
/VMS/repos/spark/spark-demo/target/scala-2.11/hello_2.11-0.1.0-SNAPSHOT.jar

