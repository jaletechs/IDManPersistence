package com.pairprogramming.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the lga database table.
 * 
 */
@Embeddable
public class LgaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="lga_id")
	private short lgaId;

	@Column(name="state_id", insertable=false, updatable=false)
	private String stateId;

	public LgaPK() {
	}
	public short getLgaId() {
		return this.lgaId;
	}
	public void setLgaId(short lgaId) {
		this.lgaId = lgaId;
	}
	public String getStateId() {
		return this.stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LgaPK)) {
			return false;
		}
		LgaPK castOther = (LgaPK)other;
		return 
			(this.lgaId == castOther.lgaId)
			&& this.stateId.equals(castOther.stateId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.lgaId);
		hash = hash * prime + this.stateId.hashCode();
		
		return hash;
	}
}