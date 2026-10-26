package com.rays.user;

import java.util.List;

import com.rays.dto.UserDTO;

public class TestUserModel {

	public static void main(String[] args) {

//		testAdd();
//		testUpdate();
		testDelete();
//		testFindByPk();
//		testFindByLogin();
//		testAuthenticate();
//		testSearch();

	}

	public static void testAdd() {

		UserModel model = new UserModel();

		UserDTO dto = new UserDTO();

		dto.setFirstName("Shikha");
		dto.setLastName("Sharma");
		dto.setLogin("shikha");
		dto.setPassword("124");

		int id = model.add(dto);

		System.out.println("Add ID = " + id);
	}

	public static void testUpdate() {

		UserModel model = new UserModel();

		UserDTO dto = model.findByPk(5);

		dto.setFirstName("Meet");
		dto.setLogin("Meet");

		model.update(dto);

		System.out.println("User Updated");
	}

	public static void testDelete() {

		UserModel model = new UserModel();

		model.delete(6);

		System.out.println("User Deleted");
	}

	public static void testFindByPk() {

		UserModel model = new UserModel();

		UserDTO dto = model.findByPk(2);

		System.out.println("ID = " + dto.getId());
		System.out.println("First Name = " + dto.getFirstName());
		System.out.println("Last Name = " + dto.getLastName());
	}

	public static void testFindByLogin() {

		UserModel model = new UserModel();

		UserDTO dto = model.findByLogin("meet");

		System.out.println("ID = " + dto.getId());
		System.out.println("Login = " + dto.getLogin());
		System.out.println("First Name = " + dto.getFirstName());
	}

	public static void testAuthenticate() {

		UserModel model = new UserModel();

		UserDTO dto = model.authenticate("meet", "123");

		if (dto != null) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Invalid Login");
		}
	}

	public static void testSearch() {

		UserModel model = new UserModel();

		UserDTO dto = new UserDTO();

		dto.setFirstName("Shikha");

		List<UserDTO> list = model.search(dto, 1, 10);

		for (UserDTO user : list) {
			System.out.println(user.getId() + " " + user.getFirstName());
		}
	}

}