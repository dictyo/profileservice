
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "name_plotly",
    "id"
})
@Data
public class Category {
  @Id
  @NotNull
  @JsonProperty("id")
  private String id;

  @NotNull
  @JsonProperty("name")
  private String name;

  @JsonProperty("name_plotly")
  @JsonPropertyDescription("name as used by plotly")
  private String namePlotly;

  @Transient
  @JsonProperty("skills")
  private List<Skill> skills;

  @ManyToOne
  @JoinColumn(name="DOMAIN_ID")
  private Domain domain;
}
