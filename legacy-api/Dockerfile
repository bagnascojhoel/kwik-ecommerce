FROM maven:3-openjdk-16-slim

LABEL maintainer='Nocpah'

WORKDIR /srv

# Install Dependecies
RUN apt-get update && apt-get -y install tzdata curl

# Timezone Brail UTC -3
RUN cp /usr/share/zoneinfo/Brazil/East /etc/localtime
RUN echo "Brazil/East" >  /etc/timezone

ADD ./ /srv/app

VOLUME /srv/target

ARG APP_PORT
ARG ENV

RUN cd ./app && mvn -U -DskipTests=true --activate-profiles=$ENV package
RUN mv /srv/app/target/*.jar /srv/app.jar

CMD java -jar app.jar

EXPOSE $APP_PORT
