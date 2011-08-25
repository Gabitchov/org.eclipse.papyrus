package org.eclipse.papyrus.properties.uml.providers;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.providers.EMFObjectLabelProvider;
import org.eclipse.papyrus.umlutils.PackageUtil;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


public class ProfileLabelProvider extends EMFObjectLabelProvider implements ILabelProvider {

	private Package umlPackage;

	public final static String TAG_PROFILE_CHANGED = " (has changed, consider re-applying profile)";

	public ProfileLabelProvider(Package umlPackage) {
		this.umlPackage = umlPackage;
	}

	@Override
	public String getText(Object source) {
		if(source instanceof Profile) {
			Profile profile = (Profile)source;
			String name = profile.getQualifiedName();
			if(isDirty(umlPackage, profile)) {
				name += TAG_PROFILE_CHANGED;
			}
			return name;
		}
		return super.getText(source);
	}

	/**
	 * Checks if the profile applied has been changed since last application (definition does not match.
	 * 
	 * @param _package
	 *        on which the profile is applied
	 * @param _profile
	 *        the applied profile
	 * @return true if the profile has changed
	 */
	//Code from org.eclipse.papyrus.profile.ui.compositesformodel.AppliedProfileCompositeOnModel#isDirty(Package, Profile)
	private boolean isDirty(Package _package, Profile _profile) {
		boolean isDirty = false;

		// Retrieve model resourceSet
		ResourceSet pkge_resourceSet = _package.eResource().getResourceSet();

		// Retrieve profile resource
		URI prof_URI = _profile.eResource().getURI();
		Resource modelResource = pkge_resourceSet.getResource(prof_URI, true);

		if(modelResource.getContents().get(0) instanceof Profile) {

			// ckeck applied profile application definition vs profile definition referenced in file
			Profile profileInFile = (Profile)(modelResource.getContents().get(0));

			if(_package.getProfileApplication(_profile) != null) {
				EPackage appliedProfileDefinition = _package.getProfileApplication(_profile).getAppliedDefinition();
				EPackage fileProfileDefinition = null;

				// Check profiles qualified names to ensure the correct profiles are compared
				String appliedProfileName = _profile.getQualifiedName();
				String fileProfileName = profileInFile.getQualifiedName();
				if(!appliedProfileName.equals(fileProfileName)) {

					// The profile must be a subprofile
					Iterator<Profile> it = PackageUtil.getSubProfiles(profileInFile).iterator();
					while(it.hasNext()) {
						Profile current = it.next();
						fileProfileName = current.getQualifiedName();
						if(fileProfileName.equals(appliedProfileName)) {
							profileInFile = current;
						}
					}
				}

				fileProfileDefinition = profileInFile.getDefinition();

				if(appliedProfileDefinition != fileProfileDefinition) {
					isDirty = true;
				}
			}

		}

		return isDirty;
	}
}
