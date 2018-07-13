package accountapp;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@ApplicationScoped
@Default
@Transactional(TxType.SUPPORTS)
public class AccountServiceDBImpl implements IService {
	
    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    public Account getAccountById(long id) {
        return em.find(Account.class, id);
    }
    
    @Transactional(TxType.REQUIRED)
    public List<Account> getAccounts(){
    	return em.createNamedQuery("Account.getAll", Account.class).getResultList();
    	
    }
    


    @Transactional(TxType.REQUIRED)
    public Account addAccount(Account account) {
        em.persist(account);
        return account;
    }
    
    @Transactional
    public Account updateFirstName(long id, String newFirstName) {
    	Account account = getAccountById(id);
    	account.setFirstName(newFirstName);
    	return account;
    }
    
    @Transactional(TxType.REQUIRED)
    public Account update(Account account, String firstName, String lastName, String accountNumber ) {
    	  em.getTransaction().begin();
    	  account.setFirstName(firstName);
    	  account.setLastName(lastName);
    	  account.setAccountNumber(accountNumber);
    	  em.refresh(account);
    	  em.getTransaction().commit();

    	  return account;
    }
    
    @Transactional(TxType.REQUIRED)
    public void delete(Account account) {
    	  em.getTransaction().begin();
    	  em.remove(account);
    	  em.getTransaction().commit();
    	  
    }
}