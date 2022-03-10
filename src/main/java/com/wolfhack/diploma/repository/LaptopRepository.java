package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Laptop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends ProductRepo<Laptop> {

    List<Laptop> findLaptopsByCostLessThanEqual(double cost);

}
