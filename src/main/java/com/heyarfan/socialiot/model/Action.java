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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "action")
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false) 
	private String name;

	
	@Column(name = "created_at")
	public Date createdAt;
	
	
	@Column(columnDefinition = "LONGTEXT", nullable = false) 
	private String details;
	
	@Override
	public String toString() {
		return "Action [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", details=" + details + ", tracks="
				+ tracks + "]";
	}

	public Action(String name, String details, List<Track> tracks) {
		super();
		this.name = name;
		this.details = details;
		this.tracks = tracks;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@OneToMany
	@JoinTable(name = "action_track", joinColumns = @JoinColumn(name = "action_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "track_id", referencedColumnName = "id"))
	private List<Track> tracks;
	
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	
	
}
