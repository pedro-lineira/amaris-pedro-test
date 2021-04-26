# amaris-pedro-test
Prueba técnica

# Arranque
./mvn install && ./mvn spring-boot:run -pl priceSearch

#consulta
#getPriceByDate/{brand_id}/{product_id}/{date}
curl -X GET localhost:8080/amarispedrotest/getPriceByDate/1/35455/2020-06-14-21.00.00

