package br.com.examplemvc.Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.examplemvc.Application.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
	
}