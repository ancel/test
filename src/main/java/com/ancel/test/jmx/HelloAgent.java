package com.ancel.test.jmx;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class HelloAgent {
    public static void main(String[] args) throws Exception {
        //create mbean server
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        //create object name
        ObjectName objectName = new ObjectName("jmxBean:name=hello");

        //create mbean and register mbean
        Hello h = new Hello();
        h.addNotificationListener(new HelloListener(), null, h);
        server.registerMBean(h, objectName);


        /**
         * JMXConnectorServer service 
         */
        //这句话非常重要，不能缺少！注册一个端口，绑定url后，客户端就可以使用rmi通过url方式来连接JMXConnectorServer 
        LocateRegistry.createRegistry(1099);

        /**
                      构造JMXServiceURL
                      完整为：service:jmx:rmi://localhost:0/jndi/rmi://localhost:1099/jmxrmi
         service:jmx:  -  固定开头
         rmi: - 这个是jmx connector server的传输协议，在这个url中是使用rmi来进行传输的
         localhost:0  - 这个是jmx connector server的IP和端口，也就是真正提供服务的host和端口，可以忽略，那么会在运行期间随意绑定一个端口提供服务
         jndi/rmi://localhost:1099/jmxrmi - 这个是jmx connector server的路径，具体含义取决于前面的传输协议。比如该URL中这串字符串就代表着该jmx connector server的stub是使用 jndi api 绑定在 rmi://localhost:1099/jmxrmi 这个地址
         */
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        //创建JMXConnectorServer
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, server);
        //启动
        cs.start();
    }
}