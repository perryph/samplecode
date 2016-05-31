package com.dnd_api.persistence.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dnd_api.persistence.model.CharacterClass;
import com.dnd_api.persistence.util.HibernateUtil;

public class CharacterClassDAO {
	private Session session;
	private Transaction transaction;
	
	public CharacterClassDAO() {
		
	}
	
	private void getSession(boolean useTransaction) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		if (useTransaction) {
			setupTransaction();
		}
	}
	
	private void closeSession(boolean useTransaction) {
		if (useTransaction) {
			closeTransaction();
		}
		HibernateUtil.closeSession(session);
	}
	
	private void setupTransaction() {
		transaction = HibernateUtil.setupTransaction(session);
		transaction.begin();
	}
	
	private void closeTransaction() {
		HibernateUtil.closeTransaction(transaction);
	}
	
	public void save(CharacterClass thisClass) {
		getSession(true);
		session.save(thisClass);
		closeSession(true);
	}
	
	public void update(CharacterClass thisClass) {
		getSession(true);
		session.update(thisClass);
		closeSession(true);
	}
	
	public CharacterClass getById(int id) {
		getSession(true);
		CharacterClass thisClass = session.get(CharacterClass.class, id); 
		closeSession(true);
		return thisClass;
	}
	
	@SuppressWarnings("unchecked")
	public List<CharacterClass> getAll() {
		getSession(true);
		List<CharacterClass> allClasses = session.createQuery("from CharacterClass").list();
		closeSession(true);
		return allClasses;
	}
	
	public void delete(CharacterClass thisClass) {
		getSession(true);
		session.delete(thisClass);
		closeSession(true);
	}
	
}
