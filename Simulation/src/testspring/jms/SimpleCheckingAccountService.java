package testspring.jms;

public class SimpleCheckingAccountService implements CheckingAccountService{
	public String cancelAccount(Long accountId) {
	      System.out.println("Cancelling account [" + accountId + "]");
	      return accountId.toString();
	   }
}
