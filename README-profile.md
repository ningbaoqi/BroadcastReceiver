### Broadcast简介

##### 广播定义

+ 在Android中，Broadcast是一种广泛运用的在`应用程序之间`传输信息的机制，Android中我们要发送的广播内容是一个Intent，这个Intent中可以携带我们要传送的数据；

#####广播的种类

|广播的种类|说明|
|-----|-----|
|`普通广播`|`sendBroadcast()`|
|`有序广播`|`sendOrderedBroadcast()`|
|`本地广播`|`只在App内部传播`|

#####广播的内部实现机制

|广播的内部实现机制|
|------|
|自定义广播接收器BroadcastReceiver，并重写onReceive()方法|
|通过Binder机制向AMS(Activity Manager Service)进行注册|
|广播发送者通过Binder机制向AMS发送广播|
|AMS查找符合相应条件(intent-filter/permission等)的BroadcastReceiver，将广播发送到BroadcastRecveiver(一般情况下是Activity)相应的消息循环队列中|
|消息循环执行拿到此广播，回调BroadcastReceiver中的onReceive()方法|