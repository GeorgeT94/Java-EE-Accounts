package accountapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class AccountServiceHashImpl implements IService{
	public static final int BANNED_ACCOUNT = 123456; 

	private Map<String, Account> accounts = new HashMap<String, Account>();
	
	public Account addAccount(Account account){
		accounts.put(String.valueOf(account.getId()), account);
		return account;
	}
	
	public Account getAccountById(long accountNumber) {
		String accountNumberStr = String.valueOf(accountNumber);
		return accounts.get(accountNumberStr);
		
	}
	public Account getAccountByFirstName(String firstName) {
		return accounts.get(firstName);
		
	}
	
	public List<Account> getAccounts() {
		List<Account> accountList = new ArrayList<>();
		for (String key: accounts.keySet()) {
		    accountList.add(accounts.get(key));
		}
		return accountList;
	}
	
	public Account updateFirstName(long id, String newFirstName) {
		return getAccountById(id);
	}
	
	public Account updateLastName(long id, String newFirstName) {
		return getAccountById(id);
	}
	
	public Account updateAccountNumber(long id, String newFirstName) {
		return getAccountById(id);
	}
	

	
	public int getAccountCountByFirstName(String firstName) {
		return (int) accounts.values().stream().filter(v -> v.getFirstName().equals(firstName)).count();
	} 
}
