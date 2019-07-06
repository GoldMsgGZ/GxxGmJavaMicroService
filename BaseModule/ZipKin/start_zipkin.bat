@ECHO OFF
set RABBIT_ADDRESSES=127.0.0.1:5672
set RABBIT_USER=guest
set RABBIT_PASSWORD=guest
set STORAGE_TYPE=mysql
set MYSQL_HOST=127.0.0.1
set MYSQL_TCP_PORT=3306
set MYSQL_USER=root
set MYSQL_PASS=video
set MYSQL_DB=zipkin
set MYSQL_USE_SSL=false
::windows 10 64bit版本，默认参数启动zipkin server 会报错，Native memory allocation (malloc) failed to allocate 360816 bytes for Chunk::new
::需要增加ReservedCodeCacheSize大小
::linux shell暂未尝试
set JAVA_OPTS="-XX:ReservedCodeCacheSize=64m" 
java -jar zipkin-server-2.12.9-exec.jar
