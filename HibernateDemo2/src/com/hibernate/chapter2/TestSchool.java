package com.hibernate.chapter2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chapter1.Customer;

public class TestSchool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(School.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true,true);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		SchoolDetail detail = new SchoolDetail();
		detail.setPublicSchool(false);
		detail.setSchoolAddress("101 Whashington");
		detail.setStudentCount(300);
		School bk = new School();
		bk.setSchoolName("University of Technology");
		bk.setSchoolDetail(detail);
		session.save(bk);
		session.getTransaction().commit();

	}

}
