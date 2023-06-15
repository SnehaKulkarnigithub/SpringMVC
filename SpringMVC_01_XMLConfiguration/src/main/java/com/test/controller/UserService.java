package com.test.controller;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.test.util.HibernateUtil;

@Service
@Transactional
public class UserService {

	public void addUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			System.out.println("Database connected");
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			System.out.println("data added successfully");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
