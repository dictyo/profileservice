
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "correction"
})
public class Datapoint {
  @NotNull
  @JsonProperty("value")
  private Datapoint.Value value;

  @JsonProperty("correction")
  @JsonPropertyDescription("Correction due to visual presentation in plotly.")
  private Integer correction;


  @JsonProperty("value")
  public Datapoint.Value getValue() {
    return value;
  }

  @JsonProperty("value")
  public Datapoint setValue(Datapoint.Value value) {
    this.value = value;
    return this;
  }

  @JsonProperty("correction")
  public Integer getCorrection() {
    return correction;
  }

  @JsonProperty("correction")
  public Datapoint setCorrection(Integer correction) {
    this.correction = correction;
    this.value = value;
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("value", value).append("correction", correction).toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(correction).append(value).toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof Datapoint) == false) {
      return false;
    }
    Datapoint rhs = ((Datapoint) other);
    return new EqualsBuilder().append(correction, rhs.correction).append(value, rhs.value).isEquals();
  }

  public enum Value {

    _1(1),
    _2(2),
    _3(3);
    private final Integer value;
    private final static Map<Integer, Datapoint.Value> CONSTANTS = new HashMap<Integer, Datapoint.Value>();

    static {
      for (Datapoint.Value c : values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    private Value(Integer value) {
      this.value = value;
    }

    @JsonValue
    public Integer value() {
      return this.value;
    }

    @JsonCreator
    public static Datapoint.Value fromValue(Integer value) {
      Datapoint.Value constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException((value + ""));
      } else {
        return constant;
      }
    }

  }

}
