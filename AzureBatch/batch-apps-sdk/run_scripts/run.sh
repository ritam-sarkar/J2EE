#!/bin/bash

JOB_DEF=${!APP_PACKAGE_LOCATION}/${JOB_DEF_ID}/job_def.json

echo "Running job definition"
cat $JOB_DEF

echo -e "\n*** Environment ***"
env

LOG4J2_PATH=${LOG4J2_PATH:-"./log4j2.xml"}

java -Dlog4j.configurationFile=$LOG4J2_PATH -cp ${!APP_PACKAGE_LOCATION}/${JOB_DEF_ID}/_code/${JAR_NAME}:${!APP_PACKAGE_LOCATION}/${JOB_DEF_ID}/_code/lib/*:${!BATCH_UTIL_PACKAGE_LOCATION}/lib/* $MAIN_CLASS ${PROGRAM_ARGUMENTS}
