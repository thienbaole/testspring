package testspring.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client.xml");
//		CheckingAccountService service = (CheckingAccountService) ctx
//				.getBean("checkingAccountService");
		ClientService clientService  = (ClientService) ctx.getBean("clientService");
		clientService.doTest();
		//service.cancelAccount(new Long(10));
	}
}