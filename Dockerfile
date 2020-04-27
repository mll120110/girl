FROM tomcat:9.0.34
MAINTAINER Jack Road
ADD target/gisPlatform.war /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]