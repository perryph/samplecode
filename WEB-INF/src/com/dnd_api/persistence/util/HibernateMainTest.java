package com.dnd_api.persistence.util;

import java.util.List;

import com.dnd_api.persistence.model.CharacterClass;
import com.dnd_api.persistence.service.CharacterClassService;

public class HibernateMainTest {

	public static void main(String[] args) {
		CharacterClassService classService = new CharacterClassService();
		
		// test insert
		CharacterClass newClass = new CharacterClass();
		newClass.setClassName("Ranger");
		newClass.setDescription("a guy in the woods");
		classService.save(newClass);
		System.out.println("saved new class: ranger");
		
		
		// test get all (also get the id of the new ranger class for following tests)
		System.out.println("retrieving all classes:");
		int rangerId = 0;
		List<CharacterClass> classes = classService.getAll();
		for (CharacterClass aClass : classes) {
			System.out.println(aClass.getClassName() + ": " + aClass.getDescription());
			if(aClass.getClassName().equals("Ranger")) {
				rangerId = aClass.getId();
			}
		}
		
		// test get by id
		CharacterClass ranger = classService.getById(rangerId);
		if (ranger != null) {
			System.out.println("retrieved " + ranger.getClassName() + " by id");
		} else {
			System.out.println("failed to retrieve ranger class by id");
		}
		
		// test update
		ranger.setDescription("shoots a bow or something");
		classService.update(ranger);
		System.out.println("ranger class updated");
		
		// test delete
		classService.delete(ranger);
		System.out.println("ranger class deleted");
	}

}
