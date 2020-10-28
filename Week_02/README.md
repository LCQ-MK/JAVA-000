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
    2.GC次数是随着内存增大而减少的，但GC总耗时没有随内存增加而减少。
    可能跟电脑配置有关？？换台电脑尝试下
    
    
