# extend the most recent long term support Ubuntu version
FROM ubuntu:14.04

MAINTAINER Hanwool Lee "hwlee@itwise.co.kr"

RUN apt-get update

# install wget
RUN apt-get install -y wget

# get maven 3.2.2
RUN wget --no-verbose -O /tmp/apache-maven-3.2.2.tar.gz http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz

# verify checksum
RUN echo "87e5cc81bc4ab9b83986b3e77e6b3095 /tmp/apache-maven-3.2.2.tar.gz" | md5sum -c

# install maven
RUN tar xzf /tmp/apache-maven-3.2.2.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.2.2 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.2.2.tar.gz
ENV MAVEN_HOME /opt/maven

# install git
RUN apt-get install -y git

# install oracle-jdk-7
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections

RUN apt-get update && \
    apt-get install -y --no-install-recommends software-properties-common && \
    add-apt-repository ppa:webupd8team/java && \
    apt-get update && \
    apt-get install -y --no-install-recommends oracle-java7-installer



# get Jenkins from Nexus
RUN wget --no-verbose -O /tmp/Jenkins.war http://192.168.0.35:8081/content/repositories/thirdparty/jenkins/jenkins-ci/1.580.1/jenkins-ci-1.580.1.war

RUN apt-get -qq install tomcat7
RUN apt-get -qq install curl
RUN apt-get -qq install bash


RUN ln -s /tmp /var/lib/tomcat7/webapps

chown tomcat7:tomcat7 /tmp
service tomcat7 restart