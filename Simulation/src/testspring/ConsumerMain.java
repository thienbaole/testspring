package testspring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerMain {

	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		System.out.println("From consumer...");	
		//RuntimeRecordHandler handler =(RuntimeRecordHandler) context.getBean("runtimeRecordHandler");
		RuntimeRecordJDBCTemplate runtimeJDBCTemplate = 
			      (RuntimeRecordJDBCTemplate)context.getBean("JDBCTemplate");
		List<RuntimeRecord> records = runtimeJDBCTemplate.listRuntimeRecordsByStartDate("2013/04/06");
//		List<RuntimeRecord> records = runtimeJDBCTemplate.listRuntimeRecordsByEndDate("2013/04/06");
//		List<RuntimeRecord> records = runtimeJDBCTemplate.listRuntimeRecordsByMethodName("method1");
//		List<RuntimeRecord> records = runtimeJDBCTemplate.listRuntimeRecordsByClassName("testspring.Simulation");
		for (RuntimeRecord record : records)
			System.out.println(record);
	}
}
