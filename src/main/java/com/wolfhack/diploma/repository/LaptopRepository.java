package com.wolfhack.diploma.repository;

import com.wolfhack.diploma.models.products.Laptop;

import java.util.List;

public interface LaptopRepository extends ProductRepo<Laptop> {

    List<Laptop> findLaptopsByCostLessThanEqual(double cost);

}
