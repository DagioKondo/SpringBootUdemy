package com.example.jissyuUdemy.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDaoService {

	private static List<Customer> customers = new ArrayList();

	static {
		customers.add(new Customer("001", "SUZUKI", "M", 28));
		customers.add(new Customer("002", "SATO", "M", 35));
		customers.add(new Customer("003", "TANAKA", "W", 26));
	}

	public List<Customer> findAll() {
		return customers;
	}

	public Customer save(Customer customer) {
		customers.add(customer);
		return customer;
	}

	public Customer findOne(String id) {
		for(Customer customer:customers) {
			if(customer.getCustomedId().equals(id)) {
				return customer;
			}
		}
		return null;
	}

	public Customer deleteById(String id) {
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			if (customer.getCustomedId().equals(id)) {
				iterator.remove();
				return customer;
			}
		}

		return null;
	}

}
