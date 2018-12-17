
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import java.util.HashMap;
import java.util.List;
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
    "id"
})
public class Category {

  @NotNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("name_plotly")
  @JsonPropertyDescription("name as used by plotly")
  private String namePlotly;

  @NotNull
  @JsonProperty("id")
  private String id;

  @JsonProperty("skills")
  private List<Skill> skills;

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

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("skills")
  public List<Skill> getSkills() {
    return skills;
  }

  @JsonProperty("skills")
  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).append("name", name).append("namePlotly", namePlotly)
        .append("id", id).append("additionalProperties").toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(name).append(namePlotly).append(id).toHashCode();
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
    return new EqualsBuilder().append(name, rhs.name).append(namePlotly, rhs.namePlotly)
        .append(id, rhs.id).isEquals();
  }
}
