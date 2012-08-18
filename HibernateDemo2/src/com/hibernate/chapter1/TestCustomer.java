package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true,true);
		Customer alex = new Customer();
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		alex.setCustomerName("alex");
		alex.setCustomerAddress("101 washington st, DC");
		alex.setCreditScore(100);
		alex.setRewardPoints(199);
		
		session.save(alex);
		session.getTransaction().commit();
	}

}
