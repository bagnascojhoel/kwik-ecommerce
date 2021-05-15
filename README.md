
docker run --name kwik-ecommerce-db -p 5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=kwik-ecommerce-db -d postgres