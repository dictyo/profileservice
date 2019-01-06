
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "id",
    "categories"
})
public class Domain {
  @Id
  @NotNull
  @JsonProperty("id")
  private String id;

  @NotNull
  @JsonProperty("name")
  private String name;

  @OneToMany(mappedBy="domain", cascade = CascadeType.ALL)
  @JsonProperty("categories")
  @JsonPropertyDescription("Category: The finest categorisation of skills.")
  private List<Category> categories = new ArrayList<Category>();
}
