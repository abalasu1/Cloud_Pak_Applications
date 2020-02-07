
cd booking
mvn package
docker push arunimi/booking:1.0.0
cd ..

cd tracking
mvn package
docker push arunimi/tracking:1.0.0
cd ..

cd handling
mvn package
docker push arunimi/handling:1.0.0
cd ..

cd routing
mvn package
docker push arunimi/routing:1.0.0
cd ..
