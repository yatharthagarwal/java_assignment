package com.training.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.training.model.*;
import com.training.utils.CardNumberComparator;
import com.training.utils.CreditLimitComparator;
import com.training.ifaces.DataAccess;
import com.training.model.*;

public class CreditCardService implements DataAccess<CreditCard>{

	private List<CreditCard> cardList;

    public CreditCardService() {
		this.cardList = new ArrayList<>();
	}

	@Override
	public boolean add(CreditCard t) {
		return this.cardList.add(t);
	}

	@Override
	public CreditCard findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CreditCard> findAll() {
		// TODO Auto-generated method stub
		return this.cardList;
	}

	@Override
	public List<CreditCard> sortedList(String sortBy) {
		
		switch(sortBy) {
		case "cardHolderName":
			Collections.sort(this.cardList);
			break;
		case "cardNumber":
			Collections.sort(this.cardList,new CardNumberComparator());
			break;
		case "creditLimit":
			Collections.sort(this.cardList, new CreditLimitComparator());
			break;
		}
		
		return this.cardList;
	}

	@Override
	public boolean add(CreditCard ... t) {
		for(CreditCard card : t) {
			this.cardList.add(card);
		}
		return true;
	}
	
	

	
}
