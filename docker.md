# Setup the postgresql container:

docker-compose -f docker-compose.yml -d

# add this setup

docker exec -it "container-id-postgresql" bash

vi /var/lib/postgresql/data/pg_hba.conf

# add the line below in file : pg_hba.conf , to be able to open the database in Tableplus.app on macos

host all all 172.20.0.1/32 trust
