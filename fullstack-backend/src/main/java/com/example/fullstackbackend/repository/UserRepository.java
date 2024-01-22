package com.example.fullstackbackend.repository;
import com.example.fullstackbackend.model.Userr;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<Userr,Long>{

}
