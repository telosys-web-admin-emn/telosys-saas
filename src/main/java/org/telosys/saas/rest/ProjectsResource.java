package org.telosys.saas.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.pac4j.core.context.J2EContext;
import org.pac4j.core.profile.ProfileManager;
import org.pac4j.core.profile.UserProfile;
import org.telosys.saas.dao.StorageDao;
import org.telosys.saas.dao.mock.MockStorageDao;
import org.telosys.saas.domain.Project;

@Path("/projects")
public class ProjectsResource {

	private StorageDao storage = new MockStorageDao();
	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;
	
	private UserProfile getUser() {
		J2EContext context = new J2EContext(request, response);
        ProfileManager manager = new ProfileManager(context);
        HttpSession session = request.getSession();
        UserProfile profile = manager.get(true);
        return profile;
	}
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjects(@PathParam("projectId") String projectId) {
    	UserProfile user = getUser(); 
    	return storage.getProjectsForUser(user);
    }
	
    @Path("{projectId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProject(@PathParam("projectId") String projectId) {
    	UserProfile user = getUser();
    	Project project = storage.getProjectForUser(user, projectId);
    	return project;
    }
}
