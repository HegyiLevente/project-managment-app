package com.hegyi.pma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hegyi.pma.dao.ProjectRepository;
import com.hegyi.pma.entities.Project;

@Service
public class ProjectService {
	
	private ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public List<Project> findAll() {
		return this.projectRepository.findAll();
	}
	
	public void save(Project project) {
		this.projectRepository.save(project);
	}

	public Project findById(Long id) {
		return this.projectRepository.findByProjectId(id);
	}

	public void deleteById(Long id) {
		this.projectRepository.deleteById(id);
	}

}
