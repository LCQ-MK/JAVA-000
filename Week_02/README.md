## 串行GC

### 限制512M内存
```
java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails com.jike.java.jvm.week02.GCLogAnalysis
```
运行结果：
  执行结束!共生成对象次数:9456

### 限制1024M内存
```
java -XX:+UseSerialGC -Xms1024m -Xmx1024m -XX:+PrintGCDetails com.jike.java.jvm.week02.GCLogAnalysis
```
运行结果：
    执行结束!共生成对象次数:8756
    
GC观察：
