package com.example.jissyuUdemy.customer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Customer {

	@NotEmpty
	private String customedId;

	@Size(min=5, max=20, message="{0}の値は、{min}文字から{max}文字までの値で入力してください。")
	private String customerName;

	private String customerGender;

	@Range(min=1, max=50, message="{0}の値は、{min}から{max}までの値で入力してください。")
	private int customerAge;

	protected Customer(){

	}

	public Customer(String customedId,String customerName,String customerGender,int customerAge){
		super();
		this.customedId = customedId;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerAge = customerAge;
	}

	public String getCustomedId() {
		return customedId;
	}
	public void setCustomedId(String customedId) {
		this.customedId = customedId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer [customedId=%s, customerName=%s, customerGender=%s, customerAge=%d]"
				, customedId, customerName, customerGender, customerAge
				);
	}

}
