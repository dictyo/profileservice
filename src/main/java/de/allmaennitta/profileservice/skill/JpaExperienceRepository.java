package de.allmaennitta.profileservice.skill;

import de.allmaennitta.profileservice.model.Experience;
import de.allmaennitta.profileservice.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExperienceRepository extends JpaRepository<Experience, Long> {
}
