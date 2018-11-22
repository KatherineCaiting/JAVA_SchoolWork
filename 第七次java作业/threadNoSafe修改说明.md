### threadNoSafe修改说明

------

**ThreadSafeDemo1错误情况：**

![error1.png](https://github.com/KatherineCaiting/JAVA_SchoolWork/blob/master/%E7%AC%AC%E4%B8%83%E6%AC%A1java%E4%BD%9C%E4%B8%9A/images/error1.png?raw=true)



**ThreadSafeDemo1错误分析：**

​         查阅相关资料:`An ConcurrentModificationException is thrown when a Collection is modified and an existing iterator on the Collection is used to modify the Collection as well.`—-大致意思是：`ConcurrentModificationException`抛出的条件是，一个迭代器在迭代集合的时候，集合被修改了，于是我分析在开启两个线程的

时候，它们在调用run()的时候很有可能对list进行了同时性地遍历删除操作，导致程序抛出了异常。

**ThreadSafeDemo1解决方法：**

为了避免对list对象进行同时的删改操作而抛出的异常，把`ArrayList`修改为线程安全的 `CopyOnWriteArrayList`来进行操作。

![update1.png](https://github.com/KatherineCaiting/JAVA_SchoolWork/blob/master/%E7%AC%AC%E4%B8%83%E6%AC%A1java%E4%BD%9C%E4%B8%9A/images/update1.png?raw=true)

`CopyOnWriteArrayList`使用了一种叫**写时复制**的方法，当有新元素添加到`CopyOnWriteArrayList`时，先从原有的数组中拷贝一份出来，然后在新的数组做写操作，写完之后，再将原来的数组引用指向到新数组。这样就避免了remove时，list被结构性修改的次数`modCount`与ArrayList类中`expectedModCount`字段不相等的情况。

**ThreadSafeDemo1运行结果：**

![true1.png](https://github.com/KatherineCaiting/JAVA_SchoolWork/blob/master/%E7%AC%AC%E4%B8%83%E6%AC%A1java%E4%BD%9C%E4%B8%9A/images/true1.png?raw=true)



**ThreadSafeDemo1参考文档：**

[java.util.ConcurrentModificationException异常分析](https://blog.csdn.net/kingzone_2008/article/details/41368989)



------

**第二个演示示例结果：**

![question.png](https://github.com/KatherineCaiting/JAVA_SchoolWork/blob/master/%E7%AC%AC%E4%B8%83%E6%AC%A1java%E4%BD%9C%E4%B8%9A/images/question.png?raw=true)

**结果分析：**

主线程中开启了10个线程，它们之间相互争夺CPU资源。我在程序分析时，将循环的注释了起来，并加上了线程名称，程序的运行过程就一目了然了。

![test2.png](https://github.com/KatherineCaiting/JAVA_SchoolWork/blob/master/%E7%AC%AC%E4%B8%83%E6%AC%A1java%E4%BD%9C%E4%B8%9A/images/test2.png?raw=true)

