#export JAVA_HOME=/home/my/dev/java/jdk1.8.0_31
export JAVA_HOME=/home/my/dev/java/jdk1.8.0_51
#~/dev/java/jdk1.8.0_40/
export PATH=$JAVA_HOME/bin/:$PATH
#echo $JAVA_HOME
now=`date  +%Y%m%d-%H:%M`
java -version && mvn clean install && java -jar target/benchmarks.jar -gc true | tee logs/java8-benchmark-$now.log
