# Redis

> Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。 它支持多种类型的数据结构，如 [字符串（string）](http://www.redis.cn/topics/data-types-intro.html#strings)， [散列（hash）](http://www.redis.cn/topics/data-types-intro.html#hashes)， [列表（list）](http://www.redis.cn/topics/data-types-intro.html#lists)， [集合（set）](http://www.redis.cn/topics/data-types-intro.html#sets)， [有序集合（sorted set）](http://www.redis.cn/topics/data-types-intro.html#sorted-sets) 与范围查询， [bitmaps](http://www.redis.cn/topics/data-types-intro.html#bitmaps)， [hyperloglogs](http://www.redis.cn/topics/data-types-intro.html#hyperloglogs) 和 [地理空间（geospatial）](http://www.redis.cn/commands/geoadd.html) 索引半径查询。 Redis 内置了 [复制（replication）](http://www.redis.cn/topics/replication.html)，[LUA脚本（Lua scripting）](http://www.redis.cn/commands/eval.html)， [LRU驱动事件（LRU eviction）](http://www.redis.cn/topics/lru-cache.html)，[事务（transactions）](http://www.redis.cn/topics/transactions.html) 和不同级别的 [磁盘持久化（persistence）](http://www.redis.cn/topics/persistence.html)， 并通过 [Redis哨兵（Sentinel）](http://www.redis.cn/topics/sentinel.html)和自动 [分区（Cluster）](http://www.redis.cn/topics/cluster-tutorial.html)提供高可用性（high availability）。

Redis由于数据存在内存中，读写操作非常快，因此被广泛应用于缓存方向。

## 缓存

缓存分为本地缓存和分布式缓存。

### 本地缓存

Java中，使用自带的`Map`或者`guava`实现的是本地缓存。

本地缓存最主要的特点是轻量及快速，生命周期随着jvm的销毁而结束。

本地缓存的缺点是不具有一致性，在多实例的情况下，每个实例都需要各自保存一份缓存。

### 分布式缓存

使用`redis`或者`memcached`实现的缓存可以称为分布式缓存。

分布式缓存具有一致性，多个实例共享一份缓存数据。

分布式缓存的缺点是需要保持redis或者memcached的高可用状态，整个程序架构比较复杂。

## Redis单线程模型

Redis基于**反应器模式**（Reactor）开发了自己的网络事件处理器，这个处理器被称为**文件事件处理器**（file event handler）。 

文件事件处理器使用**I/O多路复用**（multplexing）程序来监听多个套接字，并根据套接字目前执行的任务来为套接字关联不同的文件事件处理器。当被IO多路复用程序监听的套接字准备好执行连接应答（accept）、读取（read）、写入（write）、关闭（close）等操作时，与操作对应的文件事件随之产生，此时文件事件处理器就会调用之前关联好的事件处理器还处理这些事件。

文件事件处理器的四个组成部分：

![文件事件处理器的四个组成部分](imgs/文件事件处理器的四个组成部分.png)

如上图，IO多路复用程序可能监听多个套接字，因此产生的文件事件可能并发出现。

即使文件事件并发出现，IO多路复用程序还是会将所有事件产生的套接字都接入到一个队列里面，然后通过这个队列，以**有序，同步，每次一个套接字**的方式向文件事件分派器传输套接字。

IO多路复用程序传送套接字：

![IO多路复用程序传送套接字](imgs/IO多路复用程序传送套接字.png)



## Redis的数据结构

### String

String是Redis中最简单的数据类型，key-value键值对结构（与memcached一致）。

常用命令： set、get、decr、incr、mget（获取所有(一个或多个)给定 key 的值）。

常见应用场景： 常用计数（incr、decr），微博数，粉丝数等。

### Hash

hash 是一个 string 类型的 field 和 value 的映射表，hash 特别适合用于存储对象。进行修改操作可以修改指定key下某个指定filed的值。

常用命令： hget、hset、hgetall等

常见应用场景：存储对象信息，如商品信息，用户信息

### List

List是简单的字符串列表，按照插入顺序排序。你可以添加一个元素到列表的头部（左边）或者尾部（右边）

一个列表最多可以包含 `$2^32 -1$` 个元素 (4294967295, 每个列表超过40亿个元素)。

List的实现是一个双向链表，支持反向查找和遍历，方便操作但是带来了额外的内存开销。

常用命令：lpush、rpush、lpop、rpop、lrange（没有rrange）等

可以通过 lrange 命令，就是从某个元素开始读取多少个元素，可以基于 list 实现分页查询，这个很棒的一个功能，基于 redis 实现简单的高性能分页，可以做类似微博那种下拉不断分页的东西（一页一页的往下走），性能高。

常见应用场景：微博的关注列表、粉丝列表、消息列表。



### Set

### Sorted Set

## Redis的内存淘汰机制

## Redis的持久化机制

## 常见问题

## 参考

- [Redis总结](https://github.com/Snailclimb/JavaGuide/blob/master/docs/database/Redis/Redis.md)
- [Redis线程模型](<https://blog.csdn.net/Happy_wu/article/details/73732883>)