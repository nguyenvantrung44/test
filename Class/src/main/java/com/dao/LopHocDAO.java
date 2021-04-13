package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.LopHoc;
import com.model.Student;
import com.util.HibernateUtil;

public class LopHocDAO {
	public LopHoc getLopHoc(int id) {
		// get the current hibernate session
		Transaction transaction = null;
		LopHoc lop = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an person object
			lop = session.get(LopHoc.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return lop;
	}

	@SuppressWarnings("unchecked")
	public List<LopHoc> getLopHoc() {

		Transaction transaction = null;
		List<LopHoc> lop = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			lop = session.createQuery("from LopHoc").getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return lop;
	}

	public void saveLopHoc(LopHoc lop) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			// save/upate the person ... finally
			session.save(lop);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Student> getStudents(int lopID) {
		LopHoc cl = getLopHoc(lopID);
		List<Student> students = cl.getStudents();
		return students;
	}

	public Student getStudent(int lopID, int studentID) {
		LopHoc lopHoc = getLopHoc(lopID);
		if (lopHoc != null)
			return lopHoc.getStudent(studentID);
		else
			return null;
	}

	public void deleteLopHoc(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			LopHoc tempPerson = session.get(LopHoc.class, id);
			session.delete(tempPerson);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
