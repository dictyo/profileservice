
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@DiscriminatorValue("F")
public class Focus extends Datapoint{
  @OneToOne
  private Skill skill;

  public Skill getSkill() {
    return skill;
  }

  public void setSkill(Skill skill) {
    this.skill = skill;
  }

  //  public static Focus of(@NotNull @Min(1) @Max(3) Integer value, Double correction){
//    return new Focus(value, correction);
//  }
//
//  public static Focus of(@NotNull @Min(1) @Max(3) Integer value){
//    return new Focus(value);
//  }
//
//  public Focus(@NotNull @Min(1) @Max(3) Integer value, Double correction) {
//    super(value, correction);
//  }
//  public Focus(@NotNull @Min(1) @Max(3) Integer value) {
//    super(value);
//  }
}
