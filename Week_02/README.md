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
    
#### GC结果观察：
    1.生成对象次数没有随内存增大而增多，512M内存生成对象次数最多，内存增多或减少效果都会减弱。
    2.GC次数和GC总耗时是着内存增大而减少。
    这有点奇怪

## 并行GC

#### 限制512M内存
```
java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails com.jike.java.jvm.week02.GCLogAnalysis
```
运行结果：
    执行结束!共生成对象次数:8607
    
### 限制1024M内存
```
java -XX:+UseParallelGC -Xms1024m -Xmx1024m -XX:+PrintGCDetails com.jike.java.jvm.week02.GCLogAnalysis
```
运行结果：
    执行结束!共生成对象次数:11221
    
#### GC结果观察：
    1.YoungGC时，Old区使用内存增大，直至FullGC，同时清理Young与Old区
    2.GC次数和GC总耗时是着内存增大而减少。
    3.GC耗时较串行GC少
    
    
未完.... 明早待续.....
    
    
