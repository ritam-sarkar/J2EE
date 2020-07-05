#!/bin/bash

if [[ ! -f ./application.json ]]; then
  echo "Unable to locate local application.json file. Are you in the right directory?"
  exit 1
fi

if [[ -z $BATCH_SDK_DIR ]]; then
  echo "APPS_SDK_DIR environment variable needs to be set."
  exit 1
fi

if [[ -z $BATCH_STORAGE_KEY ]]; then
  echo "BATCH_STORAGE_KEY environment variable needs to be set."
  exit 1
fi

if [[ -z $BATCH_NAME ]]; then
  echo "BATCH_NAME environment variable needs to be set."
  exit 1
fi
if [[ -z $BATCH_STORAGE ]]; then
  echo "BATCH_STORAGE environment variable needs to be set."
  exit 1
fi

if [[ -z $RESOURCE_GROUP ]]; then
  echo "RESOURCE_GROUP environment variable needs to be set."
  exit 1
fi

required_min_az_version="2.1.0"
current_az_version=$(az --version | grep azure-cli | tr -s ' ' | cut -d' ' -f 2)
if [[ "$?" == "1" ]]; then
    echo "Warning: az cli not found. Run 'sudo apt install azure-cli'"
    exit 1
fi
if [ "$required_min_az_version" = "`echo -e "$required_min_az_version\n$current_az_version" | sort -r -V | head -n1`" ]; then
    echo "Current version of az cli not compatible. Must be at least $required_min_az_version"
    exit 1
fi

SOURCE_DIR=${BATCH_SDK_DIR}/deployment

APP_ID=$(cat application.json | jq -r  .id)

OLD_SUBSCRIPTION=$(az account show | jq -r .id)
az account set --subscription "$SUBSCRIPTION"

# Publish batch
if [[ -d ./batch ]]; then
    echo "Publishing batch application"
    pushd batch
    . ${SOURCE_DIR}/publish-batch-application.sh $APP_ID
    popd 
fi

az account set --subscription "$OLD_SUBSCRIPTION"
