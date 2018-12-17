
package de.allmaennitta.model.generated;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Skill, the ability, coming from one's knowledge, practice,aptitude, etc. to do something well
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "name_plotly",
    "experience",
    "focus"
})
public class Skill {

    @JsonProperty("name")
    private String name;
    @JsonProperty("name_plotly")
    private String namePlotly;
    @JsonProperty("experience")
    private Experience experience;
    @JsonProperty("focus")
    private Experience focus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("name_plotly")
    public String getNamePlotly() {
        return namePlotly;
    }

    @JsonProperty("name_plotly")
    public void setNamePlotly(String namePlotly) {
        this.namePlotly = namePlotly;
    }

    @JsonProperty("experience")
    public Experience getExperience() {
        return experience;
    }

    @JsonProperty("experience")
    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    @JsonProperty("focus")
    public Experience getFocus() {
        return focus;
    }

    @JsonProperty("focus")
    public void setFocus(Experience focus) {
        this.focus = focus;
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
        return new ToStringBuilder(this).append("name", name).append("namePlotly", namePlotly).append("experience", experience).append("focus", focus).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(focus).append(namePlotly).append(additionalProperties).append(experience).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Skill) == false) {
            return false;
        }
        Skill rhs = ((Skill) other);
        return new EqualsBuilder().append(name, rhs.name).append(focus, rhs.focus).append(namePlotly, rhs.namePlotly).append(additionalProperties, rhs.additionalProperties).append(experience, rhs.experience).isEquals();
    }

}
