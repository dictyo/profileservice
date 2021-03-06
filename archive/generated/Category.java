
package de.allmaennitta.model.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * Category: The finest categorisation of skills.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "name_plotly",
    "skills"
})
public class Category {

    @JsonProperty("name")
    private String name;
    @JsonProperty("name_plotly")
    private String namePlotly;
    @JsonProperty("skills")
    private List<Skill> skills = new ArrayList<Skill>();
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

    @JsonProperty("skills")
    public List<Skill> getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
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
        return new ToStringBuilder(this).append("name", name).append("namePlotly", namePlotly).append("skills", skills).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(skills).append(namePlotly).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category) == false) {
            return false;
        }
        Category rhs = ((Category) other);
        return new EqualsBuilder().append(name, rhs.name).append(skills, rhs.skills).append(namePlotly, rhs.namePlotly).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
