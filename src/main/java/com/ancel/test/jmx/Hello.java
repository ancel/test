package com.ancel.test.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {
    private String name;
    private long sequenceNumber = 0;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
    	 Notification n = new AttributeChangeNotification(this,
                 sequenceNumber++, System.currentTimeMillis(),
                 "name changed", "name", "String", this.name,
                 name);
         //发送通知
         this.name = name;
         sendNotification(n);
    }

    @Override
    public String printHello() {
        return "Hello " + name;
    }

    @Override
    public String printHello(String whoName) {
        return "Hello  " + whoName;
    }
    
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name,
                description);
        return new MBeanNotificationInfo[] { info };
    }

}
