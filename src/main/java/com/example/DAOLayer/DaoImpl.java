package com.example.DAOLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Entity.Student;

import jakarta.persistence.EntityManager;

@Repository

public class DaoImpl implements DaoMethods {
	
	public EntityManager em;
	@Autowired
	DaoImpl(EntityManager entityManager) {
		em = entityManager;
	}

	@Override
	@Transactional
	public Student create(Student student) {
		em.persist(student);
		return student;
	}

	@Override
	public Student read(int id) {
		return em.find(Student.class, id);
	}

	@Override
	@Transactional
	public Student update(Student s) {
		em.merge(s);
		return s;
	}

	@Override
	@Transactional
	public Student delete(int id) {
		Student s=em.find(Student.class, id);
		em.remove(s);
		return s;
	}

}
