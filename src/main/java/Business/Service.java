package Business;

import javax.inject.Inject;

import Util.Util;
import accountapp.Account;
import accountapp.IService;

public class Service {
	
	@Inject
	private IService service;
	
	@Inject
	private Validate valid;
	
	@Inject
	private Util util;
	
	public String getAllAccountsAsJsonString() {
		return util.accountListToJsonString(service.getAccounts());

	}
	
	public String getAccountAsJsonString(long id){
		Account account = service.getAccountById(id);
		return util.accountToJsonString(account);
	}
	
	public String addAccount(Account account) {
		service.addAccount(account);
		return "account added";
	}
	
	public String updateFirstName(Account account) {
		service.updateFirstName(account.getId(), account.firstName);
		return "account updated";
	}
}