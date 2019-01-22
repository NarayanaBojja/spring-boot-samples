package com.emp.modal;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the hostel_owner database table.
 * 
 */
@Entity
@Table(name = "hostel_owner")
@NamedQuery(name = "HostelOwner.findAll", query = "SELECT h FROM HostelOwner h")
public class HostelOwner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private BigInteger mobile;

	private String name;

	// bi-directional many-to-one association to HostelDetail
	@OneToMany(mappedBy = "hostelOwner")
	private List<HostelDetail> hostelDetails;

	public HostelOwner() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getMobile() {
		return this.mobile;
	}

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HostelDetail> getHostelDetails() {
		return this.hostelDetails;
	}

	public void setHostelDetails(List<HostelDetail> hostelDetails) {
		this.hostelDetails = hostelDetails;
	}

	public HostelDetail addHostelDetail(HostelDetail hostelDetail) {
		getHostelDetails().add(hostelDetail);
		hostelDetail.setHostelOwner(this);

		return hostelDetail;
	}

	public HostelDetail removeHostelDetail(HostelDetail hostelDetail) {
		getHostelDetails().remove(hostelDetail);
		hostelDetail.setHostelOwner(null);

		return hostelDetail;
	}

}