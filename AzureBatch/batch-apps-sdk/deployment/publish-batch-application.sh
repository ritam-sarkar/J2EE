#!/usr/bin/env bash

APP_ID=$1

echo "Batch Account $BATCH_NAME"
echo "Batch Storage $BATCH_STORAGE"

NEXT_VERSION="1.0.0"

if [[ ! -d $BATCH_SDK_DIR/run_scripts ]]; then
  echo "ERROR: Unable to locate run_scripts "
  exit 1
fi

ZIP_FILE=$PWD/${APP_ID}.zip 

[[ -f $ZIP_FILE ]] && rm $ZIP_FILE

pushd job_defs

HAS_PYTHON=0

for DIR in $(ls -d -- */)
    do 

        DIR_NAME=${DIR::-1}

        JOB_DEF=${DIR_NAME}/job_def.json

        if [[ ! -f ${JOB_DEF} ]]; then
            continue
        fi

        JOB_ID=$(jq -r .id ${JOB_DEF})
        echo "Processing job def ${JOB_ID}"

        if [[ "${JOB_ID}" =~ [^a-z0-9-] ]]; then
            echo "job def ids can only container lowercase letters, numbers, and dashes (-)"
            exit 1
        fi

        RUNTIME_ENV=$(jq -r .runtime ${JOB_DEF})
        if [[ "$?" != "0" || "$RUNTIME_ENV" == "null" ]]; then
            echo "RUNTIME_ENV not set or not found for job def ${JOB_ID}"
            exit 1
        fi

        # Capture code path
        CODE_PATH=$(jq -r .code_path ${JOB_DEF})
        if [[ "$?" != "0" || "$CODE_PATH" == "null" || ! -d ${JOB_ID}/$CODE_PATH ]]; then
            echo "code_path ($CODE_PATH) not set or not found for job def ${JOB_ID}"
            exit 1
        fi

        # add the job def
        zip $ZIP_FILE ./${JOB_DEF}   



	    if [[ ! -d ./${JOB_ID}/_code ]]; then mkdir ./${JOB_ID}/_code; fi

	    JAR_NAME=$(jq -r .jar_name ${JOB_DEF})
	    LIB_PATH=$(jq -r .lib_path ${JOB_DEF})
	    
	    if [[ ! -d ./${JOB_ID}/${LIB_PATH} ]]; then
		echo -e "\e[93mWARNING: lib_path ($LIB_PATH) not set or not found for job def \"${JOB_ID}\". Skipped including libs.\e[0m"
	    else
	        echo ./${JOB_ID}/${LIB_PATH}
		cp -u -r ./${JOB_ID}/${LIB_PATH} ./${JOB_ID}/_code
	    fi

	    cp -u ./${JOB_ID}/${CODE_PATH}/*.jar ./${JOB_ID}/_code

	    zip -r $ZIP_FILE ./${JOB_ID}/_code
	    pushd $BATCH_SDK_DIR
	    zip -r $ZIP_FILE ./run_scripts
	    popd
	    rm -r ./${JOB_ID}/_code
        

        BASE_DEST="apps/${APP_ID}/${NEXT_VERSION}/${JOB_ID}"
        SRC="./${JOB_ID}/resource_files"

        az storage blob delete-batch -s batch-config --account-name $BATCH_STORAGE --account-key $BATCH_STORAGE_KEY --pattern ${BASE_DEST}/*

        cp -r ${SRC} _resource_files/
        az storage blob upload-batch -d batch-config/${BASE_DEST}/resource_files --account-name $BATCH_STORAGE --account-key $BATCH_STORAGE_KEY -s _resource_files
        rm -r _resource_files/  
        
        az storage blob upload -c batch-config -n ${BASE_DEST}/job_def.json -f ./${JOB_DEF} --account-name $BATCH_STORAGE --account-key $BATCH_STORAGE_KEY
    done
popd

if [[ -f $ZIP_FILE ]]; then
   # az batch application package delete --application-name ${APP_ID} --resource-group $RESOURCE_GROUP --name $BATCH_NAME --version $NEXT_VERSION
    az batch application package create --application-name ${APP_ID} --package-file ${APP_ID}.zip --resource-group $RESOURCE_GROUP --name $BATCH_NAME --version $NEXT_VERSION
    rm $ZIP_FILE
else
    echo "No jobs found to package"
fi
