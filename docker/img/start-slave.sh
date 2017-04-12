#!/bin/bash

sbin/start-slave.sh -c 1 -m ${MEMORY} -p ${SLAVE_PORT} spark://spark-master:7077 && tail -f /spark/logs/*
