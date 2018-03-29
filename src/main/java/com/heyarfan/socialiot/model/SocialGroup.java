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
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "social_group")
public class SocialGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String name;

	@Column(name = "created_at")
	public Date createdAt;

	@Column(nullable = false)
	public long parentId;

	@Column(nullable = true)
	@ManyToMany
	@JoinTable(name = "things_tags", joinColumns = @JoinColumn(name = "thing_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private List<Thing> things;

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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public List<Thing> getThings() {
		return things;
	}

	public void setThings(List<Thing> things) {
		this.things = things;
	}

	public SocialGroup(String name, long parentId, List<Thing> things) {
		super();
		this.name = name;
		this.parentId = parentId;
		this.things = things;
	}

	@Override
	public String toString() {
		return "SocialGroup [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", parentId=" + parentId
				+ ", things=" + things + "]";
	}

}
