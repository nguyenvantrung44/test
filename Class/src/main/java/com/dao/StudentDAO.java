package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.LopHoc;
import com.model.Student;
import com.util.HibernateUtil;

public class StudentDAO {
	public Student getStudent(int id) {
		Transaction transaction = null;
		Student student = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get CreditCard object
			student = session.get(Student.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return student;
	}

	public void saveStudent(Student student, int lopid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			LopHoc lopHoc = session.get(LopHoc.class, lopid);
			lopHoc.addStudent(student);
			session.saveOrUpdate(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

//	public void updateCreditCard(CreditCard tempCard, int personId) {
//		Transaction transaction = null;
//		CreditCard creditCard = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			transaction = session.beginTransaction();
//			Person person = session.get(Person.class, personId);
//			CreditCard theCard = person.getCreditCard(tempCard.getId());
//			setValueCreditCard(theCard, tempCard);
//			session.saveOrUpdate(theCard);
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//	}
//
//	public void deleteCreditCard(int creditCardId) { // delete object with primary key
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			transaction = session.beginTransaction();
//			CreditCard tempCCard = session.get(CreditCard.class, creditCardId);
//			session.delete(tempCCard);
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//	}
//
//	// -----------------------------------Private methods
//	private void setValueCreditCard(CreditCard theCard, CreditCard tempCard) {
//		theCard.setNumber(tempCard.getNumber());
//		theCard.setType(tempCard.getType());
//	}
}
