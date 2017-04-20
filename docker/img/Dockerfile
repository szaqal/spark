FROM ubuntu:16.10

RUN apt-get update && apt-get install -y software-properties-common unzip
RUN add-apt-repository ppa:webupd8team/java

RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections

RUN apt-get update && apt-get install -y oracle-java8-installer

#ADD http://d3kbcqa49mib13.cloudfront.net/spark-2.1.0-bin-hadoop2.7.tgz /
ADD http://192.168.2.11/spark-2.1.0-stock.tgz /

RUN tar -xzvf spark-2.1.0-stock.tgz && ln -s spark-2.1.0-bin-hadoop2.7  /spark
RUN mkdir /ml
COPY ./ml/ /ml/

ADD start-master.sh /spark
ADD start-slave.sh /spark
ADD mysql-connector-java-5.1.41.jar /spark/jars
RUN chmod +x /spark/start-master.sh && chmod +x /spark/start-slave.sh

WORKDIR /spark
