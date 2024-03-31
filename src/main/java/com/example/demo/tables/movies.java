package com.example.demo.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class movies {
	
	@Id
	@Column(name="mname")
	private String mname;
	@Column(name="mdesc")
	public String mdesc;
	@Column(name="rating")
	private double rating;
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Movies [Movie Name=" + mname + ", Movie Description=" + mdesc + ", rating=" + rating + "]";
	}
}
