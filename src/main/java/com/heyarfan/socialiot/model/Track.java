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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "track")
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String name;

	@Column(name = "created_at")
	public Date createdAt;

	public boolean isPublic;

	@ManyToOne
	@JoinTable(name = "action_track", joinColumns = @JoinColumn(name = "action_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "track_id", referencedColumnName = "id"))
	private Action action;

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

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Track(String name, boolean isPublic, Action action) {
		super();
		this.name = name;
		this.isPublic = isPublic;
		this.action = action;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", isPublic=" + isPublic
				+ ", action=" + action + "]";
	}

}
