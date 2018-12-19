package de.allmaennitta.profileservice.skill;

import de.allmaennitta.profileservice.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JpaSkillRepository extends JpaRepository<Skill, String> {
}