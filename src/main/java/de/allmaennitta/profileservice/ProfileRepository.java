package de.allmaennitta.profileservice;

import org.springframework.data.repository.CrudRepository;

import java.lang.Long;

interface ProfileRepository extends CrudRepository<Profile, Long> {
}