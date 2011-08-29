package org.eclipse.papyrus.properties.uml.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.papyrus.properties.providers.EMFObjectLabelProvider;
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
			if(Util.isDirty(umlPackage, profile)) {
				name += TAG_PROFILE_CHANGED;
			}
			return name;
		}
		return super.getText(source);
	}
}
