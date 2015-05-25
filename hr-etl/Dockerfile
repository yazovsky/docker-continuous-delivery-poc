FROM java:8

RUN apt-get update && apt-get install make

ADD ./Makefile /opt/hr/
ADD ./target/scala-2.11/hr-etl-1.0.jar /opt/hr/hr-etl.jar
ADD ./configs/application.conf /etc/hr/
ADD ./configs/truststore.jks /etc/hr/
VOLUME /etc/hr
EXPOSE 8081

# install consul
ADD project/consul /install/
RUN sh /install/install.sh

CMD java -Dconfig.file=/etc/hr/application.conf -Djavax.net.ssl.trustStore="/etc/hr/truststore.jks" -jar /opt/hr/hr-etl.jar
