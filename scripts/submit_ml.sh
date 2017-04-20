#!/bin/bash

source commons.sh

$SPARK_HOME/bin/spark-submit \
	--master spark://192.168.2.11:7077 \
	--class com.szaqal.NaiveBayesDemo \
/VMS/repos/spark/ml/naivebayes/target/scala-2.11/naivebayes_2.11-0.1.0.jar
