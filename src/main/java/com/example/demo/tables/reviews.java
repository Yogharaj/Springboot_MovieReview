package com.example.demo.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reviews")
public class reviews
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name="mname")
	private String mname;
	@Column(name="mreview")
	private String mreview;
	@Column(name="rating")
	private double rating;
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMreview() {
		return mreview;
	}
	public void setMreview(String mreview) {
		this.mreview = mreview;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Review [Movie name=" + mname + ", Movie review=" + mreview + ", rating=" + rating + "]";
	}
	
}
