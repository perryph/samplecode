package com.dnd_api.persistence.service;

import java.util.List;

import com.dnd_api.persistence.DAO.CharacterClassDAO;
import com.dnd_api.persistence.model.CharacterClass;

public class CharacterClassService {
	private static CharacterClassDAO classesDAO;
	
	public CharacterClassService() {
		classesDAO = new CharacterClassDAO();
	}
	
	public void save(CharacterClass thisClass) {
		classesDAO.save(thisClass);
	}
	
	public void update(CharacterClass thisClass) {
		classesDAO.update(thisClass);
	}
	
	public CharacterClass getById(int id) {
		return classesDAO.getById(id);
	}
	
	public List<CharacterClass> getAll() {
		return classesDAO.getAll();
	}
	
	public void delete(CharacterClass thisClass) {
		classesDAO.delete(thisClass);
	}
}
