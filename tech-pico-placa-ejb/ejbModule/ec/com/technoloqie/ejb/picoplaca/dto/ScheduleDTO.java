package ec.com.technoloqie.ejb.picoplaca.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="HORARIO")
public class ScheduleDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name="ID_HORARIO",nullable=false, unique=true)
	private Integer id;
	
	@Column(name="DESCRIPCION")
	private String description;
	
	@Column(name="HORA_INICIO")
	private Date startHour;
	
	@Column(name="HORA_FIN")
	private Date endHour;
	
	@Transient
	private Date restrictionDate;
	
	@Transient
	private Date restrictionHour;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public Date getEndHour() {
		return endHour;
	}

	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}

	public Date getRestrictionDate() {
		return restrictionDate;
	}

	public void setRestrictionDate(Date restrictionDate) {
		this.restrictionDate = restrictionDate;
	}

	public Date getRestrictionHour() {
		return restrictionHour;
	}

	public void setRestrictionHour(Date restrictionHour) {
		this.restrictionHour = restrictionHour;
	}
	
	
}
