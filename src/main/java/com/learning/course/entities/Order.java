package com.learning.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.learning.course.entities.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Instant instant;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private User clientUser;
	
	public Order() {
	}
	
	public Order(Integer id, Instant instant, User clientUser) {
		
		this.id = id;
		this.instant = instant;
		this.clientUser = clientUser;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public User getClientUser() {
		return clientUser;
	}

	public void setClientUser(User clientUser) {
		this.clientUser = clientUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", instant=" + instant + ", clientUser=" + clientUser + "]";
	}
	
	
	
}
