package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.product;

public class AccountDaoImpl implements AccountDao {

		Map<String,product> accountEntry;
	public AccountDaoImpl() {
		
		accountEntry=new HashMap<>();
		
		accountEntry.put("9010210131",new product("Prepaid","Vaishali",200));
		accountEntry.put("9823920123",new product("Prepaid","Megha",453));
		accountEntry.put("9932012345",new product("Prepaid","Vikas",631));
		accountEntry.put("9010210131",new product("Prepaid","Anju",521));
		accountEntry.put("9010210131",new product("Prepaid","Tushar",632));
			
	}

	product account=null;
	public product getAccountDetails(String mobileNo) {

		int count=0;
		for(Map.Entry<String,product> m : accountEntry.entrySet()) {

			if(mobileNo.equals(m.getKey())) {
				
				account= m.getValue();
				count++;
				break;
			}
		}
	
		if(count==0) 
			return null;
		else
		return account;
	}
				

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
		int count2=0;
		for(Map.Entry<String,product> m : accountEntry.entrySet()) {
			
			if(mobileNo.equals(m.getKey())) {
				
				account= m.getValue();
				account.setAccountBalance(account.getAccountBalance()+rechargeAmount);
				count2++;
				break;
				
			}
		}
	accountEntry.put(mobileNo, new product(account.getAccountType(),account.getCustomerName(),account.getAccountBalance()));
			if(count2!=0) 
			return (int)account.getAccountBalance();
			else
			return 0;
	}

}
