
package de.allmaennitta.model.generated;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "correction"
})
public class Experience {

    @JsonProperty("value")
    private Experience.Value value;
    /**
     * Correction due to visual presentation in plotly.
     * 
     */
    @JsonProperty("correction")
    @JsonPropertyDescription("Correction due to visual presentation in plotly.")
    private Integer correction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("value")
    public Experience.Value getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Experience.Value value) {
        this.value = value;
    }

    /**
     * Correction due to visual presentation in plotly.
     * 
     */
    @JsonProperty("correction")
    public Integer getCorrection() {
        return correction;
    }

    /**
     * Correction due to visual presentation in plotly.
     * 
     */
    @JsonProperty("correction")
    public void setCorrection(Integer correction) {
        this.correction = correction;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("value", value).append("correction", correction).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(correction).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Experience) == false) {
            return false;
        }
        Experience rhs = ((Experience) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(correction, rhs.correction).append(value, rhs.value).isEquals();
    }

    public enum Value {

        _1(1),
        _2(2),
        _3(3);
        private final Integer value;
        private final static Map<Integer, Experience.Value> CONSTANTS = new HashMap<Integer, Experience.Value>();

        static {
            for (Experience.Value c: values()) {
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
        public static Experience.Value fromValue(Integer value) {
            Experience.Value constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException((value +""));
            } else {
                return constant;
            }
        }

    }

}
