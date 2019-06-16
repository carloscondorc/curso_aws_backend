FROM mysql:latest
LABEL maintainer="carlos.condor@outlook.com"

ENV MYSQL_ROOT_PASSWORD=toor
ENV MYSQL_DATABASE=encuestabd
ENV MYSQL_ROOT_HOST=%

COPY ./scripts-mysql2/ /docker-entrypoint-initdb.d/
CMD ["--default-authentication-plugin=mysql_native_password"]