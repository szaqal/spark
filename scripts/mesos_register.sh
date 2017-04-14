#!/bin/bash

source commons.sh

$SPARK_HOME/sbin/start-mesos-dispatcher.sh \ 
	--master mesos://$MESOS_MASTER:5050 \ 
	--webui-port 8888 -h $MESOS_MASTER 
