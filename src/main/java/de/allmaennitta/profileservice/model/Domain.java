
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
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
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "id",
    "categories"
})
public class Domain {

  @NotNull
  @JsonProperty("name")
  private String name;

  @NotNull
  @JsonProperty("id")
  private String id;

  @JsonProperty("categories")
  @JsonPropertyDescription("Category: The finest categorisation of skills.")
  private List<Category> categories = new ArrayList<Category>();



  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("categories")
  public List<Category> getCategories() {
    return categories;
  }

  @JsonProperty("categories")
  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }


  @Override
  public String toString() {
    return new ToStringBuilder(this).append("name", name).append("id", id)
        .append("categories", categories).toString();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(name).append(id).append(categories).toHashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof Domain) == false) {
      return false;
    }
    Domain rhs = ((Domain) other);
    return new EqualsBuilder().append(name, rhs.name).append(id, rhs.id)
        .append(categories, rhs.categories).isEquals();
  }

}
