package de.allmaennitta.mindware.learner;

import org.springframework.data.repository.CrudRepository;

import java.lang.Long;

interface LearnerRepository extends CrudRepository<Learner, Long> {
}