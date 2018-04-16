package ec.com.technoloqie.ejb.picoplaca.dto;


//@Entity
//@Table(name="CARRO")
public class CarDTO {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) 
	//@Column(name="ID_CARRO",nullable=false, unique=true)
	private Integer id;
	
	//@Column(name="ID_MATRICULA")
	private String enrollmentId;		//matricula del automovil
	
	private String make;
	
	private String model;
	
	private String color;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	
}
