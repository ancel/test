package com.ancel.test.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIDemo {
	public static Context getInitialContext() throws NamingException {

	    Hashtable<String, String> env = new Hashtable<String, String>();
	    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.ancel.test.jndi.TestInitialContextFactory");
	    Context context = new InitialContext(env);

	    return context;

	}
	
	class Bank{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		Context initialContext;
		try {
			//Obtain the initial context
			initialContext = getInitialContext();
			//Create a Bank object.
			JNDIDemo jd = new JNDIDemo();
			Bank myBank = jd.new Bank();
			myBank.setName("招商银行");

			//Bind the object into the JNDI tree.

			initialContext.rebind("theBank",myBank);
			myBank = (Bank) initialContext.lookup("theBank");
			System.out.println(myBank.getName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
