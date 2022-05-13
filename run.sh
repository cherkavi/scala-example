# run application, examples:
# ./run.sh test LabelerJobArgumentsTest
# ./run.sh build
#
if [ $1 == "build" ]
then
	echo "> only build without tests"	
	mvn -DskipTests -Dunit.skipTests -Dintegration.skipTests -Dscoverage.skip -Djacoco.skip install
elif [ $1 == "test" ]
then
	if [ -z "$2" ]
	then
		echo "> full test set execution"
		mvn -Denable-scapegoat-report -Dintegration.skipTests -Dscoverage.skip -Djacoco.skip test
	else
		echo "> single test execution"
		mvn -Dintegration.skipTests -Dscoverage.skip -Djacoco.skip -Dsuites="*$2" test
	fi
else
	echo "> clean, tests, install"
	mvn -Denable-scapegoat-report -DelasticIntegrationTest=1 clean install
fi
#mvn org.antipathy:mvn-scalafmt_2.11:format
