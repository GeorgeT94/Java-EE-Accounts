package accountapp;

import java.util.List;

public interface IService {

	public Account addAccount(Account account);
	
	public Account getAccountById(long id);
	
	public List<Account> getAccounts();
	
	public Account updateFirstName(long id, String newFirstName);
	
	public Account updateLastName(long id, String newLastName);
	 
	public Account updateAccountNumber(long id, String accountNumber);
	
	public String deleteAccountById(long id);
	
}
