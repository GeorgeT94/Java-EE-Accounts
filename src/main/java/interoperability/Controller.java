package interoperability;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.ws.handler.MessageContext;

import Business.Service;
import accountapp.Account;
import accountapp.IService;
import constants.Routes;

@Path(Routes.ROOT_PATH)
public class Controller {
	
	@Inject
	private Service service;
	
	@GET
	@Path(Routes.GET_ALL_PATH)
	public String getAllAccounts( @Context MessageContext req) {
		String responseData = service.getAllAccountsAsJsonString();
	    return responseData;
	}
	
	
	@GET
	@Path("{id}")
	public String getAccount( @PathParam("id") long id,  @Context MessageContext req) {
		String responseData = service.getAccountAsJsonString(id);
		
	    return responseData;
	}
	
	@POST @Consumes("application/json")
	@Path(Routes.CREATE_ACCOUNT_PATH)
	public String createAccount(final Account input) { 
		return service.addAccount(input);
		
	}
	
	@PUT @Consumes("application/json")
	@Path(Routes.UPDATE_FIRSTNAME_PATH)
	public String updateFirstNme(final Account input) { 
		return service.updateFirstName(input);
	}
	
	@PUT @Consumes("application/json")
	@Path(Routes.UPDATE_LASTNAME_PATH)
	public String updateLastNumber(final Account input) { 
		return service.updateLastName(input);
	}
	
	@PUT @Consumes("application/json")
	@Path(Routes.UPDATE_ACCOUNTNUMBER_PATH)
	public String uupdateAccountnumber(final Account input) { 
		return service.updateAccountNumber(input);
	}

	@DELETE
	@Path("{id}")
	public String deleteAccount( @PathParam("id") long id,  @Context MessageContext req) {
		String responseData = service.deleteAccountById(id);
		
	    return responseData;
	}

}
