FROM postgres:15

ENV POSTGRES_DB=room_service
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=root

COPY docker/init.sql /docker-entrypoint-initdb.d/