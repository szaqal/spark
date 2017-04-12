#!/bin/bash

sbin/start-slave.sh -c 1 -m 512m -p ${SLAVE_PORT} spark://spark-master:7077 && tail -f /spark/logs/*
