package com.telusko.toppers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.telusko.toppers.model.Student;

public interface TopStudentRepository extends CrudRepository<Student, String> {
	
	@Query("from Student where age>= :pMinAge and age < :pMaxAge and city = :pLocation  order by Marks desc ")
	
	List<Student> GetTopStudents(@Param ("pMinAge") int pMinAge, @Param ("pMaxAge") int pMaxAge,  @Param ("pLocation") String pLocation);

}
