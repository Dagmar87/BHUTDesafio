package com.dagmar87.carsystem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "logs")
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "data_hora", nullable = false, updatable = false)
	@JsonIgnore
	private Date dataHora;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "car_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Car car;

	public Log() {

	}

	public Log(Date dataHora, Car car) {
		super();
		this.dataHora = dataHora;
		this.car = car;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", dataHora=" + dataHora + ", car=" + car + "]";
	}

}
