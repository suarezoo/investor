package club.booksmart.identityaccess.application.internal;

import org.springframework.stereotype.Service;

import club.booksmart.identityaccess.application.TransactionBo;

@Service
public class TransactionBoImpl implements TransactionBo {

	@Override
	public String save() {
		 
		return "Jersey + Spring example3";
 
	}


}
