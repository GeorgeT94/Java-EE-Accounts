package Business;

import javax.inject.Inject;

import Util.Util;
import accountapp.Account;
import accountapp.IService;
import constants.Messages;

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
		if(valid.isValidAccountNumber(account)) {
			service.addAccount(account);
			return Messages.ACCOUNT_CREATED_SUCCESSFUL;
		}
		return Messages.ACCOUNT_CREATED_UNSUCCESSFUL;
	}
	
	public String updateFirstName(Account account) {
		service.updateFirstName(account.getId(), account.firstName);
		return Messages.ACCOUNT_UPDATED_SUCCESSFUL;
	}
	
	public String updateLastName(Account account) {
		service.updateLastName(account.getId(), account.lastName);
		return Messages.ACCOUNT_UPDATED_SUCCESSFUL;
	}
	
	public String updateAccountNumber(Account account) {
		if(valid.isValidAccountNumber(account)) {
			service.updateAccountNumber(account.getId(), account.accountNumber);
			return Messages.ACCOUNT_UPDATED_SUCCESSFUL;
		}
		return Messages.ACCOUNT_UPDATED_UNSUCCESSFUL;

	}
	
	public String deleteAccountById(long id) {
		return service.deleteAccountById(id);
	}
	
	
}