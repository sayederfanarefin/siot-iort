package com.heyarfan.socialiot.model;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "thing")
public class Thing implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false) 
	private String name;

	@Column(nullable = false) 
	private long macAddress;
	
	@Column(nullable = false) 
	private String publicKey;

	@Column(nullable = false) 
	@OneToMany
	@JoinTable(name = "things_social_group", joinColumns = @JoinColumn(name = "thing_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "social_group_id", referencedColumnName = "id"))
	private List<SocialGroup> socilGroups;
	
	@Column(name = "created_at")
	public Date createdAt;

	@ManyToMany
	@JoinTable(name = "things_tags", joinColumns = @JoinColumn(name = "thing_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private List<Tag> tags;

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

	public Thing() {
		super();

	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(long macAddress) {
		this.macAddress = macAddress;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public List<SocialGroup> getSocilGroups() {
		return socilGroups;
	}

	public void setSocilGroups(List<SocialGroup> socilGroups) {
		this.socilGroups = socilGroups;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Thing(String name, long macAddress, String publicKey, List<SocialGroup> socilGroups, List<Tag> tags) {
		super();
		this.name = name;
		this.macAddress = macAddress;
		this.publicKey = publicKey;
		this.socilGroups = socilGroups;
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Thing [id=" + id + ", name=" + name + ", macAddress=" + macAddress + ", publicKey=" + publicKey
				+ ", socilGroups=" + socilGroups + ", createdAt=" + createdAt + ", tags=" + tags + "]";
	}

	
}