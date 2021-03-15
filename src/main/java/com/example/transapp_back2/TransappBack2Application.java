package com.example.transapp_back2;

import com.example.transapp_back2.dao.SearchDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransappBack2Application {

	public static void main(String[] args) {
		SpringApplication.run(TransappBack2Application.class, args);
		SearchDAO searchDAO = new SearchDAO();
		System.out.println(searchDAO.getTrainsOfSearch());
	}

}
