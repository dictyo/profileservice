
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SKILL")

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "name_plotly",
    "domain",
    "category",
    "experience",
    "focus"
})

@Data
public class Skill {

  @Id
  @NotNull
  @Column(name = "id")
  private String name;

  private String name_plotly;

  @NotNull
  private String domain;

  @NotNull
  @Column(name = "the_category")
  private String category;

//  @NotNull
  @OneToOne(mappedBy="skill", cascade=CascadeType.ALL)
  private Experience experience;

//  @NotNull
  @OneToOne(mappedBy="skill",cascade=CascadeType.ALL)
  private Focus focus;

//  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  @JoinColumn(name = "FOCUS_ID")

}
