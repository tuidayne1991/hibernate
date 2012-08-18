package com.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chapter2.School;
import com.hibernate.chapter2.SchoolDetail;

public class AccountTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Accounts.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true,true);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		CompoundKey key1 = new CompoundKey(100, 1000);
		Accounts saving = new Accounts();
		saving.setCompoundKey(key1);
		saving.setAccountBalance(6500);
		
		CompoundKey key2 = new CompoundKey(100, 1001);
		Accounts checking = new Accounts();
		checking.setCompoundKey(key2);
		checking.setAccountBalance(65000);
		
		session.save(saving);
		session.save(checking);
		session.getTransaction().commit();

	}

}
