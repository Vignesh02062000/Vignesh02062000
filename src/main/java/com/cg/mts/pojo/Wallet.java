package com.cg.mts.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Wallet {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long walletId;
	
	private double balance;

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wallet(long walletId, double balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}

	public long getWalletId() {
		return walletId;
	}

	public void setWalletId(long walletId) {
		this.walletId = walletId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
