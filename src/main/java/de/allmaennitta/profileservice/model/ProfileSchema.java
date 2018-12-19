
package de.allmaennitta.profileservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "skills",
    "domains"
})
public class ProfileSchema {

    @JsonProperty("skills")
    @JsonPropertyDescription("Skill: the ability, based on one's knowledge, practice,"
        + "aptitude, etc. to do something well")
    private List<Skill> skills = new ArrayList<Skill>();
    @JsonProperty("domains")
    @JsonPropertyDescription("Domain: The broadest categorisation of skills.")
    private List<Domain> domains = new ArrayList<Domain>();



    @JsonProperty("skills")
    public List<Skill> getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @JsonProperty("domains")
    public List<Domain> getDomains() {
        return domains;
    }

    @JsonProperty("domains")
    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("skills", skills).append("domains", domains).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(skills).append(domains).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProfileSchema) == false) {
            return false;
        }
        ProfileSchema rhs = ((ProfileSchema) other);
        return new EqualsBuilder().append(skills, rhs.skills).append(domains, rhs.domains).isEquals();
    }

}
