package com.leesin;

import com.leesin.discovery.IServiceDiscovery;
import com.leesin.discovery.ServiceDiscoveryWithZk;

import java.lang.reflect.Proxy;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class RpcProxyClient {

    private IServiceDiscovery serviceDiscovery=new ServiceDiscoveryWithZk();



    public <T> T clientProxy(final Class<T> interfaceCls, String version){

        return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(),
                new Class<?>[]{interfaceCls},new RemoteInvocationHandler(serviceDiscovery,version));
    }
}
