
package de.allmaennitta.profileservice.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "name_plotly",
    "domain",
    "category",
    "experience",
    "focus"
})
public class Skill {
    @NotNull
    @JsonProperty("name")
    private String name;

    @JsonProperty("name_plotly")
    private String namePlotly;

    @NotNull
    @JsonProperty("domain")
    private String domain;

    @NotNull
    @JsonProperty("category")
    private String category;

    @NotNull
    @JsonProperty("experience")
    private Datapoint experience;

    @NotNull
    @JsonProperty("focus")
    private Datapoint focus;



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

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("experience")
    public Datapoint getExperience() {
        return experience;
    }

    @JsonProperty("experience")
    public void setExperience(Datapoint experience) {
        this.experience = experience;
    }

    @JsonProperty("focus")
    public Datapoint getFocus() {
        return focus;
    }

    @JsonProperty("focus")
    public void setFocus(Datapoint focus) {
        this.focus = focus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("namePlotly", namePlotly).append("domain", domain).append("category", category).append("experience", experience).append("focus", focus).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(namePlotly).append(domain).append(name).append(focus).append(category).append(experience).toHashCode();
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
        return new EqualsBuilder().append(namePlotly, rhs.namePlotly).append(domain, rhs.domain).append(name, rhs.name).append(focus, rhs.focus).append(category, rhs.category).append(experience, rhs.experience).isEquals();
    }

}
