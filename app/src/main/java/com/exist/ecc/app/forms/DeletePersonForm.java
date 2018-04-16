package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.service.PersonService;

public class DeletePersonForm {
	public static void show() {
		int targetPersonId = ConsoleInputUtil.getAnyInteger("\tEnter person id: ");
		ConsoleInputUtil.getAll("Press Enter to Continue.......");
		delete(targetPersonId);
	}


	public static void delete(int id) {
		try {
			new PersonService().deletePerson(id);
		} catch(Exception e) {
			System.out.println("Record does not exist");
			return;
		}

		System.out.println("Person has been deleted from the database");
	}
}
