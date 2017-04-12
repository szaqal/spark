#!/bin/bash

sbin/start-master.sh && tail -f /spark/logs/*
