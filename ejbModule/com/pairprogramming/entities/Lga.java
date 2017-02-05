package com.pairprogramming.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lga database table.
 * 
 */
@Entity
@NamedQuery(name="Lga.findAll", query="SELECT l FROM Lga l")
public class Lga implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LgaPK id;

	@Column(name="lga_name")
	private String lgaName;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="state_id")
	private State state;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="lga")
	private List<Student> students;

	public Lga() {
	}

	public LgaPK getId() {
		return this.id;
	}

	public void setId(LgaPK id) {
		this.id = id;
	}

	public String getLgaName() {
		return this.lgaName;
	}

	public void setLgaName(String lgaName) {
		this.lgaName = lgaName;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setLga(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setLga(null);

		return student;
	}

}