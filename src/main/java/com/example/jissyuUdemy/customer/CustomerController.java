package com.example.jissyuUdemy.customer;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CustomerController {


	@Autowired
	private CustomerDaoService service;


	@GetMapping("/customers")
	public List<Customer>  retrieveAllCustomer() {
		return service.findAll();
	}


	//GET  /users/{id}
	//retrieveUser(int id)

	@GetMapping("/customers/{id}")
	public EntityModel<Customer> retrieveCustomer(@PathVariable String id) {
		Customer user = service.findOne(id);
		if(user==null)
			throw new CustomerNotFoundException("id-"+ id);

		EntityModel<Customer> model = EntityModel.of(user);

		WebMvcLinkBuilder linkToCustomers =
				linkTo(methodOn(this.getClass()).retrieveAllCustomer());

		model.add(linkToCustomers.withRel("all-customers"));

		return model;
	}


	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable String id) {
		Customer customer = service.deleteById(id);

		if(customer==null)
			throw new CustomerNotFoundException("customedId-"+ id);

	}

	// input - details of user
	// output - CREATED & Return the created URI
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
		System.out.println("a");
		Customer savedCustomer = service.save(customer);
		// CREATED
		// /user/{id}   savedUser.getId()
System.out.println("b");
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{customedId}")
				.buildAndExpand(savedCustomer.getCustomedId()).toUri();
System.out.println("c");
		return ResponseEntity.created(location).build();
	}


}
