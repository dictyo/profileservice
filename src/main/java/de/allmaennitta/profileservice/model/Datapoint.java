
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Inheritance
@DiscriminatorColumn(name="DATAPOINT_TYPE")
@Table(name="DATAPOINT")

@Data
public class Datapoint {

//  protected Datapoint (@NotNull @Min(1) @Max(3)Integer value, Double correction){
//    this.value = value;
//    this.correction = correction;
//  }

//  protected Datapoint (@NotNull @Min(1) @Max(3)Integer value){
//    this(value, 0d);
//  }

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty
  @EqualsAndHashCode.Exclude
  private long id;

  @NotNull @Min(1) @Max(3)
  @JsonProperty
  private Integer value;

  @JsonProperty
  @JsonPropertyDescription("Correction due to visual presentation in plotly. ")
  private Double correction;

}
