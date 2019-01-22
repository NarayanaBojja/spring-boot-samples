package com.emp.modal;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the hostel_details database table.
 * 
 */
@Entity
@Table(name="hostel_details")
@NamedQuery(name="HostelDetail.findAll", query="SELECT h FROM HostelDetail h")
public class HostelDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hid;

	@Column(name="hostel_name")
	private String hostelName;

	//bi-directional many-to-one association to HostelOwner
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id")
	private HostelOwner hostelOwner;

	public HostelDetail() {
	}

	public int getHid() {
		return this.hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHostelName() {
		return this.hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}

	public HostelOwner getHostelOwner() {
		return this.hostelOwner;
	}

	public void setHostelOwner(HostelOwner hostelOwner) {
		this.hostelOwner = hostelOwner;
	}

}