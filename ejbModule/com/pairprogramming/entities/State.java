package com.pairprogramming.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state database table.
 * 
 */
@Entity
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="state_id")
	private String stateId;

	@Column(name="state_name")
	private String stateName;

	//bi-directional many-to-one association to Lga
	@OneToMany(mappedBy="state")
	private List<Lga> lgas;

	public State() {
	}

	public String getStateId() {
		return this.stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<Lga> getLgas() {
		return this.lgas;
	}

	public void setLgas(List<Lga> lgas) {
		this.lgas = lgas;
	}

	public Lga addLga(Lga lga) {
		getLgas().add(lga);
		lga.setState(this);

		return lga;
	}

	public Lga removeLga(Lga lga) {
		getLgas().remove(lga);
		lga.setState(null);

		return lga;
	}

}