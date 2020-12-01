package com.hegyi.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.hegyi.pma.dao.ProjectRepository;
import com.hegyi.pma.entities.Project;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup(@Sql(executionPhase=ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql", "classpath:data.sql"}))
public class ProjectRepositoryIntegrationTesting {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Test
	public void ifNewProjectSaved_thenSucces() {
		Project newProject = new Project("New Project", "COMPLETE", "just a new test project");
		projectRepository.save(newProject);
		
		assertEquals(5, projectRepository.findAll().size());
	}
	
	
}
















