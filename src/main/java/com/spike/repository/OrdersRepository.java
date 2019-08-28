package com.spike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spike.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {

	public Orders findByUsernameAndCourseNo(String username, String courseNo);

}
