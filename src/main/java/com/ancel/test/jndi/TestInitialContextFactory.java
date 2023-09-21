package com.ancel.test.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

public class TestInitialContextFactory implements InitialContextFactory{
	private Context initialContext;
	@Override
	public Context getInitialContext(Hashtable<?, ?> environment)
			throws NamingException {
		if(null==initialContext){
			synchronized (TestInitialContextFactory.class) {
				if(null==initialContext){
					initialContext = new TestContext("test");
				}
			}
		}
		return initialContext;
	}
	
}
