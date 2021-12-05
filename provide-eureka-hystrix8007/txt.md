服务降级条件 1. 程序运行异常，2. 超时，3.服务熔断触发，4.线程池、信号量打满

服务降级一般在客户端实现

好的，现在来说Feign的超时时长设置：

1 Feign的默认配置，是不启用hystrix，并且Feign的底层是调用ribbon来实现负载均衡的，所以为了不和ribbon的重试机制冲突因此也不会启用重试机制

因此配置Feign是必须要做的就是

feign.hystrix.enabled=true //开启Feign的hystrix，这样配置文件中的hystrix的配置才会生效，否则依然是默认的规则
之后设置hystrix的相关配置才可以在Feign中生效，因为Feign也调用了hystrix

2 ribbon和hystrix的配置

因为hystrix的超时时长，默认为1秒，太短了！因此我们一般一定会设置hystrix的超时时长

在上面启用了Feign的hystrix开关后，配置hystrix超时时长

execution.isolation.thread.timeoutInMilliseconds=10000 //这里设置了10秒
然后看ribbon的超时设置：

ribbon的超时设置无非2个：处理超时和连接超时，默认为1秒和1秒

但是，ribbon是有默认重试的，也是2个：统一实例的重试次数和负载均衡的不同实例的重试次数，默认为1次和0次

也就是说，在同一个实例上建立连接如果失败可以重试1次，处理请求如果失败可以重试1次，但是不包括首次调用，即：实际ribbon的超时时间是 1秒×2+1秒×2，即4秒

之后是，但是上面设置了hystrix超时为10秒，因此ribbon超时优先生效

最后是1个是否对所有操作重试的开关，默认为false,这里解释下什么是所有操作：

即：为false是，GET请求不论是连接失败还是处理失败都会重试，而对于非GET请求只对连接失败进行重试

因此得出结论，在使用了Feign的情况下需先开启断路器支持，之后配置hystrix的timeoutInMillisecond大于ribbon的 ( ConnectTimeout + ReadTimeout ) × 2即可

也就是说以后以后的配置中常用的配置项就是

1 开启Feign的hystrix开关

2 hystrix超时时长

3 配置ribbon的ConnectTimeout时长

4 配置ribbon的ReadTimeout 时长