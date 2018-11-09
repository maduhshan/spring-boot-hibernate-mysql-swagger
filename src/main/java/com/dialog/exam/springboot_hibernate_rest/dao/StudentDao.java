package com.dialog.exam.springboot_hibernate_rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dialog.exam.springboot_hibernate_rest.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {
}
