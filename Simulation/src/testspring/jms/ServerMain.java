package testspring.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerMain {

   public static void main(String[] args) throws Exception {
      new ClassPathXmlApplicationContext("server.xml");
   }
}