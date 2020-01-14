FROM websphere-liberty:webProfile7
RUN mkdir -p /opt/ibm/wlp/usr/shared/config/lib/global
COPY mysqllib/mysql-connector-java-8.0.17.jar /opt/ibm/wlp/usr/shared/config/lib/global/mysqllib/mysql-connector-java-8.0.17.jar
ENV MYSQL_LIB /opt/ibm/wlp/usr/shared/config/lib/global/mysqllib
ADD target/cargotracker-1.0.war /config/dropins/
EXPOSE 9080
ENV LICENSE accept
