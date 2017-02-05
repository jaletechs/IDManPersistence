package com.pairprogramming.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the collection_reason database table.
 * 
 */
@Entity
@Table(name="collection_reason")
@NamedQuery(name="CollectionReason.findAll", query="SELECT c FROM CollectionReason c")
public class CollectionReason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="auto_id")
	private int autoId;

	@Lob
	private String comments;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;

	public CollectionReason() {
	}

	public int getAutoId() {
		return this.autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}