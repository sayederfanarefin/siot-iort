package com.heyarfan.socialiot.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "component")
public class Component {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "LONGTEXT")
	private String name;
	
	@Column(columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "created_at")
	public Date createdAt;
	
	@ManyToMany
	@JoinTable(name = "components_types", joinColumns = @JoinColumn(name = "component_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id"))
	public List<Type> types;
	
	
	@ManyToMany
	@JoinTable(name = "components_models", joinColumns = @JoinColumn(name = "component_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "model_id", referencedColumnName = "id"))
	public List<Model> models;
	
	
	
	@Column(nullable = false)
	@OneToMany
	@JoinTable(name = "component_track", joinColumns = @JoinColumn(name = "component_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "track_id", referencedColumnName = "id"))
	private List<Component> components;
	
	
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.000 ", timezone = "UTC")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
