package com.wolfhack.diploma.repository;
import com.wolfhack.diploma.models.products.Ssd;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SsdRepository extends MongoRepository<Ssd, String> {

}
