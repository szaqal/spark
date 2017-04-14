#!/bin/bash

source commons.sh

$SPARK_HOME/bin/spark-submit \
	--master mesos://$MESOS_MASTER:7077 \
	--deploy-mode cluster \
 	--supervise \
	--executor-memory 512m \
	--total-executor-cores 1 \
	--class example.Hello \
http://$MESOS_MASTER/hello_2.11-0.1.0-SNAPSHOT.jar
