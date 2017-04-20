#!/bin/bash

source commons.sh

$SPARK_HOME/bin/spark-submit \
	--master spark://192.168.2.11:7077 \
	--class example.JdbcDemo \
/VMS/repos/spark/spark-demo/target/scala-2.11/hello_2.11-0.1.0-SNAPSHOT.jar

