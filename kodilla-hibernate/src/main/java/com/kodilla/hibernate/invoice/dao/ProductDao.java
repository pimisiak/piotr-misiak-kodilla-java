package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Product;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
}
