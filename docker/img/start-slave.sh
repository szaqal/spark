#!/bin/bash

sbin/start-slave.sh -c 1 -m 1G -p 7078 spark://spark-master:7077 && tail -f /spark/logs/*
