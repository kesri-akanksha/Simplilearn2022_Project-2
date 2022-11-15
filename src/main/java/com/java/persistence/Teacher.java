package com.java.persistence;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private int teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="teacher_subject",
	joinColumns = {@JoinColumn(name = "teacher_id")},
	inverseJoinColumns = {@JoinColumn(name = "subject_id")})
	
	private Set<Subject> subjects = new HashSet<Subject>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
	@JoinTable(name="teacher_class",
	joinColumns = {@JoinColumn(name = "teacher_id")},
	inverseJoinColumns = {@JoinColumn(name = "class_id")})
	
	private Set<SchoolClass> Classes = new HashSet<SchoolClass>();

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	
	public Set<SchoolClass> getClasses() {
		return Classes;
	}

	public void setClasses(Set<SchoolClass> classes) {
		Classes = classes;
	}
	
	

	


}
