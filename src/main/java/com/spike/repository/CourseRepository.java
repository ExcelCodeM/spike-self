package com.spike.repository;

import com.spike.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    public List<Course> findAll();
    
    @Modifying
    @Query("update Course c set stockQuantity = stockQuantity - 1 where courseNo = :courseNo and stockQuantity > 0")
	public int reduceStockByCourseNo(String courseNo);

}
