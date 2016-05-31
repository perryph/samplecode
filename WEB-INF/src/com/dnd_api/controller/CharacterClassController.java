package com.dnd_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnd_api.persistence.model.CharacterClass;
import com.dnd_api.persistence.service.CharacterClassService;

@RestController
@RequestMapping("/classes")
public class CharacterClassController {
	
	@RequestMapping("/GET")
	public List<CharacterClass> getCharacterClasses() {
		return new CharacterClassService().getAll();
	}
}
