package com.management.dao;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.management.model.Student;
import com.management.model.Subjects;

@Repository
public interface ManagementRepository extends CrudRepository<Student, String> {
	
	@Query("select s from Student s where s.name=:n")
	public List<Student> getStudentByName(@Param("n")String name);
	
	
	//SELECT s FROM subjects s ORDER BY s.department=:department
	@Query("SELECT * FROM subjects ORDER BY department")
	public List<Subjects> SearchByDepartment(@Param("department") String department, Subjects subjects);
}
