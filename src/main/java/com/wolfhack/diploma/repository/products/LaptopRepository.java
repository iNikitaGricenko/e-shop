package com.wolfhack.diploma.repository.products;

import com.wolfhack.diploma.models.products.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopRepository extends ProductRepo<Laptop> {

    List<Laptop> findLaptopsByCostLessThanEqual(double cost);

}
