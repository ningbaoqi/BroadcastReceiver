### 本地广播使用简介
+ `LocalBroadcastReceiver`高效的原因主要是`它内部是通过Handler实现的`，它的`sendBroadcast()`方法含义并非和我们平时所用的一样，它的`sendBroadcast()`方法实际上是`通过Handler发送一个Message实现的`，既然是它内部是通过Handler来实现广播的发送的，那么相比于系统广播通过`Binder`实现那肯定是更高效的，别的应用内发送的广播也不会离开我们的应用：`LocalBroadcastReceiver`内部协作主要靠这两个`Map`集合，`mReceivers`和`mActions`当然还有一个`List`集合`mPendingBroadcasts`，这个主要是`存放待接收的广播对象`；
### 本地广播使用
[本地广播使用](https://github.com/ningbaoqi/BroadcastReceiver/commit/70c04ff4fdd7327589a44c1e2fd9effe92b00360)
