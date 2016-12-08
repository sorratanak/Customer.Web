package com.imake.dao;

import java.util.List;
import java.util.Map;

import com.imake.model.CustomerModel;

public interface CustomerDao {

	List<Map<String, Object>> loadCustomer();

	Map<String, Object> insertCustomer(CustomerModel model);

	Map<String, Object> removeCustomer(Integer id);

	Map<String, Object> updateCustomer(CustomerModel model);

}
