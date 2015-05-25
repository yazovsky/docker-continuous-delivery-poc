#
# One makefile to rule them all
#

# build specific commands
help:
	@echo 'make (clean|build|test|run)'
clean:
	sbt clean
build:clean
	sbt assembly
test:build
	sbt test
run:
	java -jar target/scala-2.11/hr-etl-1.0.jar
run-prod:
	java -Dconfig.file=/etc/hr/application.conf -Djavax.net.ssl.trustStore="/etc/hr/truststore.jks" -jar /opt/hr/hr-etl.jar

# delivery specific commands
dbuild:
	docker build -t yazovsky/hr-etl .
drun:
	docker run -it --link mongo:mongo -p 8081:8081 yazovsky/hr-etl /bin/bash
