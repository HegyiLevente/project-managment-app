package com.hegyi.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hegyi.pma.dto.ChartData;
import com.hegyi.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	@Override
	public List<Project> findAll();
	
}
