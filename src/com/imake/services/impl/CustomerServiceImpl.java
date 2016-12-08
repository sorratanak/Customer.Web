package com.imake.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imake.dao.CustomerDao;
import com.imake.model.CustomerModel;
import com.imake.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Map<String, Object>> loadCustomer() {
		// TODO Auto-generated method stub
		return customerDao.loadCustomer();
	}

	@Override
	public Map<String, Object> insertCustomer(CustomerModel model) {
		// TODO Auto-generated method stub
		return customerDao.insertCustomer(model);
	}

	@Override
	public Map<String, Object> removeCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.removeCustomer(id);
	}

	@Override
	public Map<String, Object> updateCustomer(CustomerModel model) {
		// TODO Auto-generated method stub
		return customerDao.updateCustomer(model);
	}

}
