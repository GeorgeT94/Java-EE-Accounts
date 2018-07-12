package accountapp;

import java.util.List;

public interface IService {

	public Account addAccount(Account account);
	
	public Account getAccountById(int id);
	
	public List<Account> getAccounts();
	
}
