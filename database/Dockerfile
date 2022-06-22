FROM mysql
COPY ./telecomm_table_script.sql ./docker-entrypoint-initdb.d/telecomm_table_script.sql
RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/