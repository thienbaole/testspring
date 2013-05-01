package testspring.jms;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientService {

	@Autowired
	public CheckingAccountService service;
	public void doTest()
	{
		System.out.println("doTest():" + service.cancelAccount(new Long(10)));
		
	}
}
