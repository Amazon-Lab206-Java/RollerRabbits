package com.cadence.dojoninjas.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name="dojos")
public class Dojo {

		@Id
		@GeneratedValue
		private Long id;
		private String name;
		
		@Column(updatable=false)
		private Date createdAt;
		private Date updatedAt;
		
		@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
		private List<Ninja> ninjas;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public List<Ninja> getNinjas() {
			return ninjas;
		}

		public void setNinjas(List<Ninja> ninjas) {
			this.ninjas = ninjas;
		}
		
		@PrePersist
		void createdAt() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		void updatedAt() {
			this.updatedAt = new Date();
		}	
}