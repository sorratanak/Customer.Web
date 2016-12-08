package com.imake.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imake.BeanUtils;
import com.imake.dao.CustomerDao;
import com.imake.entity.DbCustomer;
import com.imake.model.CustomerModel;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Map<String, Object>> loadCustomer() {
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		DetachedCriteria criteria=DetachedCriteria.forClass(DbCustomer.class,"dbCustomer");
		ProjectionList projectionList = Projections.projectionList();
		
		projectionList.add(Projections.property("dbCustomer.id"), ("id"));
		projectionList.add(Projections.property("dbCustomer.customerCode"), ("customerCode"));
		projectionList.add(Projections.property("dbCustomer.firstName"), ("firstName"));
		projectionList.add(Projections.property("dbCustomer.lastName"), ("lastName"));
		projectionList.add(Projections.property("dbCustomer.phone"), ("phone"));
		projectionList.add(Projections.property("dbCustomer.email"), ("email"));
		projectionList.add(Projections.property("dbCustomer.address"), ("address"));
		projectionList.add(Projections.property("dbCustomer.state"), ("state"));
		projectionList.add(Projections.property("dbCustomer.country"), ("country"));
		projectionList.add(Projections.property("dbCustomer.zipCode"), ("zipCode"));
		projectionList.add(Projections.property("dbCustomer.customerSince"), ("customerSince"));
		projectionList.add(Projections.property("dbCustomer.active"), ("active"));
		
		criteria.setProjection(projectionList);
		criteria.addOrder(Order.asc("dbCustomer.customerCode"));
		criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		Session session = sessionFactory.openSession();
		list = criteria.getExecutableCriteria(session).list();
		session.close();
		
		
		return list;
	}

	@Override
	public Map<String, Object> insertCustomer(CustomerModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Session session = sessionFactory.openSession();
		
		Date date = new Date();
		
		if(model.getCustomerCode().equals("")){
			map.put("success", false);
			map.put("msg", "Customer Code can't be null.");
		}
		else if(model.getFirstName().equals("")){
			map.put("success", false);
			map.put("msg", "FirstName can't be null.");
		}
		else if(model.getLastName().equals("")){
			map.put("success", false);
			map.put("msg", "LastName can't be null.");
		}
		else if(model.getPhone().equals("")){
			map.put("success", false);
			map.put("msg", "Phone Number can't be null.");
		}
		else if(model.getActive().equals("")){
			map.put("success", false);
			map.put("msg", "You have to select status.");
		}
		else{
			try{
				DbCustomer dbCustomer = new DbCustomer();
				session.beginTransaction();
				
				if(BeanUtils.isNotEmpty(model.getCustomerCode())){
					dbCustomer.setCustomerCode(model.getCustomerCode());
				}
				if(BeanUtils.isNotEmpty(model.getFirstName())){
					dbCustomer.setFirstName(model.getFirstName());
				}
				if(BeanUtils.isNotEmpty(model.getLastName())){
					dbCustomer.setLastName(model.getLastName());
				}
				if(BeanUtils.isNotEmpty(model.getPhone())){
					dbCustomer.setPhone(model.getPhone());
				}
				if(BeanUtils.isNotEmpty(model.getEmail())){
					dbCustomer.setEmail(model.getEmail());
				}
				if(BeanUtils.isNotEmpty(model.getAddress())){
					dbCustomer.setAddress(model.getAddress());
				}
				if(BeanUtils.isNotEmpty(model.getState())){
					dbCustomer.setState(model.getState());
				}
				if(BeanUtils.isNotEmpty(model.getCountry())){
					dbCustomer.setCountry(model.getCountry());
				}
				if(BeanUtils.isNotEmpty(model.getZipCode())){
					dbCustomer.setZipCode(model.getZipCode());
				}
				if(BeanUtils.isNotEmpty(date)){
					dbCustomer.setCustomerSince(date);
				}
				if(BeanUtils.isNotEmpty(model.getActive())){
					dbCustomer.setActive(model.getActive());
				}
				
					
				session.save(dbCustomer);
				session.flush();
				session.getTransaction().commit();
				map.put("success", true);
				map.put("msg", "New Customer Added");
				
				
			
			}catch (Exception e){
				map.put("success", false);
				map.put("msg", "Insert fail");
				e.printStackTrace();
			}
			finally {
				session.close();
			}
		}
		
		
		return map;
	}

	@Override
	public Map<String, Object> removeCustomer(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Session session = sessionFactory.openSession();

		try{
			DbCustomer dbCustomer = new DbCustomer();
			session.beginTransaction();
			dbCustomer.setId(id);
			session.delete(dbCustomer);
			session.flush();
			session.getTransaction().commit();
			map.put("success", true);
			map.put("msg", "Customer Removed");
		
		}catch (Exception e){
			map.put("success", false);
			map.put("msg", "Remove fail");
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		
		return map;
	}

	@Override
	public Map<String, Object> updateCustomer(CustomerModel model) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Session session = sessionFactory.openSession();
		
		if(model.getCustomerCode()==null){
			map.put("success", false);
			map.put("msg", "Customer Code can't be null.");
		}
		else if(model.getFirstName()==null){
			map.put("success", false);
			map.put("msg", "FirstName can't be null.");
		}
		else if(model.getLastName()==null){
			map.put("success", false);
			map.put("msg", "LastName can't be null.");
		}
		else if(model.getPhone()==null){
			map.put("success", false);
			map.put("msg", "Phone Number can't be null.");
		}
		else if(model.getActive()==null){
			map.put("success", false);
			map.put("msg", "You have to select status.");
		}
		else{
		
			try{
				DbCustomer dbCustomer = new DbCustomer();
				session.beginTransaction();
				
				Query query = session.createQuery("from DbCustomer where id = :ID");
				query.setParameter("ID", model.getId());
				dbCustomer = (DbCustomer) query.uniqueResult();
				
				if(BeanUtils.isNotEmpty(model.getCustomerCode())){
					dbCustomer.setCustomerCode(model.getCustomerCode());
				}
				if(BeanUtils.isNotEmpty(model.getFirstName())){
					dbCustomer.setFirstName(model.getFirstName());
				}
				if(BeanUtils.isNotEmpty(model.getLastName())){
					dbCustomer.setLastName(model.getLastName());
				}
				if(BeanUtils.isNotEmpty(model.getPhone())){
					dbCustomer.setPhone(model.getPhone());
				}
				if(BeanUtils.isNotEmpty(model.getEmail())){
					dbCustomer.setEmail(model.getEmail());
				}
				if(BeanUtils.isNotEmpty(model.getAddress())){
					dbCustomer.setAddress(model.getAddress());
				}
				if(BeanUtils.isNotEmpty(model.getState())){
					dbCustomer.setState(model.getState());
				}
				if(BeanUtils.isNotEmpty(model.getCountry())){
					dbCustomer.setCountry(model.getCountry());
				}
				if(BeanUtils.isNotEmpty(model.getZipCode())){
					dbCustomer.setZipCode(model.getZipCode());
				}
				if(BeanUtils.isNotEmpty(model.getCustomerSince())){
					dbCustomer.setCustomerSince(model.getCustomerSince());
				}
				if(BeanUtils.isNotEmpty(model.getActive())){
					dbCustomer.setActive(model.getActive());
				}
				
					
				session.update(dbCustomer);
				session.flush();
				session.getTransaction().commit();
				map.put("success", true);
				map.put("msg", "Customer Updated");
				
				
			
			}catch (Exception e){
				map.put("success", false);
				map.put("msg", "Update fail");
				e.printStackTrace();
			}
			finally {
				session.close();
			}
		}
		
		
		return map;
	}

}
