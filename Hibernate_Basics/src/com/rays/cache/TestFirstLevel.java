package com.rays.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestFirstLevel {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto1 = (UserDTO) session.get(UserDTO.class, 2);

		System.out.println(dto1.getId());
		System.out.println(dto1.getFirstName());
		System.out.println(dto1.getLastName());
		System.out.println(dto1.getPassword());

//		session.evict(dto1);

		System.out.println("---------------------");

		UserDTO dto2 = (UserDTO) session.get(UserDTO.class, 2);

		System.out.println(dto2.getId());
		System.out.println(dto2.getFirstName());
		System.out.println(dto2.getLastName());
		System.out.println(dto2.getPassword());

		session.close();
	}
}