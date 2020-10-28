### 串行GC
#1.限制512M内存
  java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails com.jike.java.jvm.week02.GCLogAnalysis


2.限制1024M内存
  java -XX:+UseSerialGC -Xms1024m -Xmx1024m -XX:+PrintGCDetails com.jike.java.jvm.week02.GCLogAnalysis
