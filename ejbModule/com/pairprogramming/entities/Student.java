package com.pairprogramming.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private String studentId;

	@Column(name="contact_address")
	private String contactAddress;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="contact_telephone")
	private String contactTelephone;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="first_name")
	private String firstName;

	private String hall;

	@Column(name="last_name")
	private String lastName;

	@Column(name="level_of_admission")
	private String levelOfAdmission;

	@Column(name="nok_address")
	private String nokAddress;

	@Column(name="nok_email")
	private String nokEmail;

	@Column(name="nok_name")
	private String nokName;

	@Column(name="nok_telephone")
	private String nokTelephone;

	@Column(name="other_name")
	private String otherName;

	private String room;

	private String session;

	private String sex;

	//bi-directional many-to-one association to CollectionReason
	@OneToMany(mappedBy="student")
	private List<CollectionReason> collectionReasons;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	//bi-directional many-to-one association to Lga
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="lga_id", referencedColumnName="lga_id"),
		@JoinColumn(name="state_id", referencedColumnName="state_id")
		})
	private Lga lga;

	public Student() {
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getContactAddress() {
		return this.contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactTelephone() {
		return this.contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHall() {
		return this.hall;
	}

	public void setHall(String hall) {
		this.hall = hall;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLevelOfAdmission() {
		return this.levelOfAdmission;
	}

	public void setLevelOfAdmission(String levelOfAdmission) {
		this.levelOfAdmission = levelOfAdmission;
	}

	public String getNokAddress() {
		return this.nokAddress;
	}

	public void setNokAddress(String nokAddress) {
		this.nokAddress = nokAddress;
	}

	public String getNokEmail() {
		return this.nokEmail;
	}

	public void setNokEmail(String nokEmail) {
		this.nokEmail = nokEmail;
	}

	public String getNokName() {
		return this.nokName;
	}

	public void setNokName(String nokName) {
		this.nokName = nokName;
	}

	public String getNokTelephone() {
		return this.nokTelephone;
	}

	public void setNokTelephone(String nokTelephone) {
		this.nokTelephone = nokTelephone;
	}

	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSession() {
		return this.session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<CollectionReason> getCollectionReasons() {
		return this.collectionReasons;
	}

	public void setCollectionReasons(List<CollectionReason> collectionReasons) {
		this.collectionReasons = collectionReasons;
	}

	public CollectionReason addCollectionReason(CollectionReason collectionReason) {
		getCollectionReasons().add(collectionReason);
		collectionReason.setStudent(this);

		return collectionReason;
	}

	public CollectionReason removeCollectionReason(CollectionReason collectionReason) {
		getCollectionReasons().remove(collectionReason);
		collectionReason.setStudent(null);

		return collectionReason;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Lga getLga() {
		return this.lga;
	}

	public void setLga(Lga lga) {
		this.lga = lga;
	}

}