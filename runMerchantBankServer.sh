#!/usr/bin/env bash
echo Launching moco Merchant Bank server
java -jar lib/moco-runner-0.11.0-SNAPSHOT-uber.jar http -p 12000 -c src/test/resources/com/gdinwiddie/creditcardprocessor/merchantbank/moco_config.json