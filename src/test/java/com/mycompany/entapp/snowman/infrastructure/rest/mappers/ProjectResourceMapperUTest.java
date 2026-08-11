/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import com.mycompany.entapp.snowman.domain.model.Project;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectResourceMapperUTest {

    @Test
    public void testMapToProject() throws Exception {
        Date dateStarted = new DateTime(2018,1,1,0,0,0).toDate();
        Date dateEnded = new DateTime(2018,5,1,0,0,0).toDate();

        ProjectResource projectResource = new ProjectResource();
        projectResource.setProjectId(1);
        projectResource.setTitle("Project Title");
        projectResource.setDateStarted(dateStarted);
        projectResource.setDateEnded(dateEnded);

        Project mappedProject = ProjectResourceMapper.mapToProject(projectResource);

        assertEquals(1, mappedProject.getId());
        assertEquals("Project Title", mappedProject.getProjectTitle());
        assertEquals(dateStarted, mappedProject.getDateStarted());
        assertEquals(dateEnded, mappedProject.getDateEnded());
    }

    @Test
    public void testMapToProjectResource() throws Exception {
        int projectId = 1;
        String projectTitle = "Project Title";
        Date dateStarted = new DateTime(2018,1,1,0,0,0).toDate();
        Date dateEnded = new DateTime(2018,5,1,0,0,0).toDate();

        Project project = new Project();
        project.setId(projectId);
        project.setProjectTitle(projectTitle);
        project.setDateStarted(dateStarted);
        project.setDateEnded(dateEnded);

        ProjectResource projectResource = ProjectResourceMapper.mapToProjectResource(project);

        assertEquals(projectId, projectResource.getProjectId());
        assertEquals(projectTitle, projectResource.getTitle());
        assertEquals(dateStarted, projectResource.getDateStarted());
        assertEquals(dateEnded, projectResource.getDateEnded());
    }
    @Test
public void testMapToProjects() throws Exception {
    ProjectResource projectResource1 = new ProjectResource();
    projectResource1.setProjectId(1);
    projectResource1.setTitle("Project 1");

    ProjectResource projectResource2 = new ProjectResource();
    projectResource2.setProjectId(2);
    projectResource2.setTitle("Project 2");

    List<ProjectResource> resources =
            Arrays.asList(projectResource1, projectResource2);

    Set<Project> projects =
            ProjectResourceMapper.mapToProjects(resources);

    assertEquals(2, projects.size());

    assertTrue(projects.stream().anyMatch(
            p -> p.getId() == 1 &&
                 "Project 1".equals(p.getProjectTitle())
    ));

    assertTrue(projects.stream().anyMatch(
            p -> p.getId() == 2 &&
                 "Project 2".equals(p.getProjectTitle())
    ));
}
}
