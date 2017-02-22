package org.rojan.javabrains.restmessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rojan.javabrains.restmessenger.database.DatabaseClass;
import org.rojan.javabrains.restmessenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("rojan", new Profile(1, "rojan", "Rojan", "Piya"));
		profiles.put("Subrina", new Profile(2, "Subrina", "Subrina", "Piya"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile getProfileById(long id){
		return profiles.get(id);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public void removeProfile(String profileName) {
		profiles.remove(profileName);
	}
}
