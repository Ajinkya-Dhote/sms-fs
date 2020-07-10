package in.ajinkyadhote.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String city;
	
	@Temporal(TemporalType.DATE)
	@JsonProperty("start_date")
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@JsonProperty("end_date")
	@JsonFormat(pattern="MM/dd/yyyy")
	private Date endDate;
	
	private Double price;
	private String color;

}
