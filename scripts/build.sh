cd src/tsgen
mvn clean compile assembly:single
cd ../../
cp ./src/tsgen/target/tsgen-1.0-SNAPSHOT-jar-with-dependencies.jar ./tsgen-0.6.jar
