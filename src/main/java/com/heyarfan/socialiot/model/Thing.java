package com.heyarfan.socialiot.model;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "thing")
public class Thing implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(columnDefinition="LONGTEXT")
    private String name;
	
	private long parentId;

	 @Column(name = "created_at")
	 public Date createdAt;
	 
	@PrePersist
	  void createdAt() {
	    this.createdAt = new Date();
	  }

	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss.000 ", timezone="UTC")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Thing() {
		super();

	}
	
	public Thing(String name, long parentId) {
		super();
		this.name = name;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Thing [id=" + id + ", name=" + name + ", parentId=" + parentId + ", createdAt=" + createdAt + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
    
}