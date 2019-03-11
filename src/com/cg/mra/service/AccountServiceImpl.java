package com.cg.mra.service;

import com.cg.mra.beans.product;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;

public class AccountServiceImpl implements AccountService {
AccountDao accDao=new AccountDaoImpl();
	@Override
	public product getAccountDetails(String mobileNo) {
		// TODO Auto-generated method stub
		
		
		
		return accDao.getAccountDetails(mobileNo);
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
		int balance=accDao.rechargeAccount(mobileNo, rechargeAmount);
		return balance;
	}

}
