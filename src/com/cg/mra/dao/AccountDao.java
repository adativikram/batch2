package com.cg.mra.dao;

import com.cg.mra.beans.product;

public interface AccountDao {
product getAccountDetails(String mobileNo);
int rechargeAccount(String mobileNo,double rechargeAmount);
}
