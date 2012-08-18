package com.hibernate.chapter1;


import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {
	public static void main(String args[]){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true,true);
		Employee alex = new Employee();
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		//alex.setEmpId(100);
		alex.setEmpName("alex");
		alex.setEmpPassword("123");
		alex.setEmpEmailAddress("alex@alex.com");
		alex.setPermanent(true);
		alex.setEmpJoinDate(new GregorianCalendar(2009,05,26));
		alex.setEmpLoginTime(Date.valueOf("2010-06-05"));
		
		session.save(alex);
		session.getTransaction().commit();
	}
}
