package com.example.servingwebcontent;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<UserModel, Integer> {
    UserModel findByusername(String username);
}
