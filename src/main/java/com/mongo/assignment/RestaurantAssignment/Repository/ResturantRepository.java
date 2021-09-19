package com.mongo.assignment.RestaurantAssignment.Repository;

import com.mongo.assignment.RestaurantAssignment.Entity.Resturant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResturantRepository extends MongoRepository<Resturant,String> {


}
