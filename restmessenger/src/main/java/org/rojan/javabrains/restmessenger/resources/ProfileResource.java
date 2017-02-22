package org.rojan.javabrains.restmessenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rojan.javabrains.restmessenger.model.Profile;
import org.rojan.javabrains.restmessenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService profileService = new ProfileService();

	@GET
	public List<Profile> getProfile() {
		return profileService.getAllProfiles();
	}

	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}

	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
	/*@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") long profileId){
		return profileService.getProfileById(profileId);
	}*/
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(Profile profile, @PathParam("profileName") String profileName){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
		
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName){
		profileService.removeProfile(profileName);
	}
}
