package com.cg.mra.service;

import com.cg.mra.beans.product;

public interface AccountService {

	product getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo,double rechargeAmount);
}
