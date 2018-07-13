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
	private long ID;

	private Map<String, Account> accounts = new HashMap<String, Account>();
	
	public Account addAccount(Account account){
		ID++;
		account.setId(ID);
		accounts.put(String.valueOf(account.getId()), account);
		return account;
	}
	
	public String deleteAccountById(long id) {
		accounts.remove(String.valueOf(id));
		return "account deleted";
		
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
		
		Account account = getAccountById(id);
		account.setFirstName(newFirstName);
		
		accounts.put(String.valueOf(id), account);
		return account;
	}
	
	public Account updateLastName(long id, String newLastName) {
		Account account = getAccountById(id);
		account.setLastName(newLastName);
		
		accounts.put(String.valueOf(id), account);
		return account;
	}
	
	public Account updateAccountNumber(long id, String newAccountNumber) {
		Account account = getAccountById(id);
		account.setAccountNumber(newAccountNumber);
		
		accounts.put(String.valueOf(id), account);
		return account;
	}
		
	public int getAccountCountByFirstName(String firstName) {
		return (int) accounts.values().stream().filter(v -> v.getFirstName().equals(firstName)).count();
	} 
}
