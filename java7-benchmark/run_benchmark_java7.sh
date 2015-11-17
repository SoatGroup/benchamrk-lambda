export JAVA_HOME=/home/my/dev/java/jdk1.7.0_75
#~/dev/java/jdk1.7.0_80/
export PATH=$JAVA_HOME/bin/:$PATH
#echo $JAVA_HOME
now=`date  +%Y%m%d-%H:%M`
java -version && mvn clean install && java -jar target/benchmarks.jar -gc true  | tee logs/java7-benchmark-$now.log
