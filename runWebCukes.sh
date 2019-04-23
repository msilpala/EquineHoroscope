#!/usr/bin/env bash
echo EquineHoroscope webserver and moco Merchant Bank servers should already be running
mvn -Dtest=RunCukesTest -Dtags=@Web -DEquineHoroscope.testDepth=web -Dwebdriver.gecko.driver=lib/drivers/geckodriver -Dwebdriver.chrome.driver=lib/drivers/chromedriver -Dbrowser.name=chrome test
