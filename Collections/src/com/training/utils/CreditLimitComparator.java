package com.training.utils;

import java.util.Comparator;

import com.training.model.CreditCard;

public class CreditLimitComparator implements Comparator<CreditCard> {

	@Override
	public int compare(CreditCard o1, CreditCard o2) {

		if(o1.getCreditLimit() < o2.getCreditLimit()) return -1;
		if(o2.getCreditLimit() > o2.getCreditLimit()) return 1;
		return 0;
	}

	

}
