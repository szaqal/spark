#!/bin/bash

/home/malczyk/Devel/tools/spark/bin/spark-submit \
	--master mesos://192.168.2.11:7077 \
	--deploy-mode cluster \
 	--supervise \
	--executor-memory 512m \
	--total-executor-cores 1 \
	--class example.Hello \
http://192.168.2.11/hello_2.11-0.1.0-SNAPSHOT.jar
