package com.mongo.assignment.RestaurantAssignment;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mongo.assignment.RestaurantAssignment.DataLoader.ResturantJson;
import com.mongo.assignment.RestaurantAssignment.Entity.Customer;
import com.mongo.assignment.RestaurantAssignment.Entity.Resturant;
import com.mongo.assignment.RestaurantAssignment.Repository.CustomerRepository;
import com.mongo.assignment.RestaurantAssignment.Repository.ResturantRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class RestaurantAssignmentApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private ResturantRepository resturantRepository;

	@Autowired
	ResourceLoader resourceLoader;


	public static void main(String[] args) {
		SpringApplication.run(RestaurantAssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);




		File file = new File("/Users/i500550/Downloads/RestaurantAssignment/src/main/resources/res.json");

		try (FileInputStream fis = new FileInputStream(file)) {
			JsonFactory jf = new JsonFactory();
			JsonParser jp = jf.createParser(fis);
			jp.setCodec(new ObjectMapper());
			jp.nextToken();
			while (jp.hasCurrentToken()) {
				ResturantJson resturantJson = jp.readValueAs(ResturantJson.class);
				jp.nextToken();
				System.out.println(resturantJson.getResturantID().get("$oid"));
				System.out.println(resturantJson.getName());

				Resturant resturant = new Resturant();
				resturant.setId(resturantJson.getResturantID().get("$oid"));
				resturant.setAddress(resturantJson.getAddress());
				resturant.setName(resturantJson.getName());
				resturant.setRating(resturantJson.getRating());
				resturant.setZipcode(resturantJson.getOutcode() + resturantJson.getPostcode());
				resturant.setAddressLine2(resturantJson.getAddressline2());
				resturant.setTypeOfFood(resturantJson.getType_of_food());

				resturantRepository.save(resturant);

			}
		}

	}

}
