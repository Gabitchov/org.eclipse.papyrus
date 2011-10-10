/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.providers;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.papyrus.properties.providers.EMFObjectLabelProvider;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


public class ProfileLabelProvider extends EMFObjectLabelProvider implements ILabelProvider {

	private Package umlPackage;

	public final static String TAG_PROFILE_CHANGED = " (has changed, consider re-applying profile)";

	public final static String UNKNOWN_PROFILE = "<Unknown>";

	public ProfileLabelProvider(Package umlPackage) {
		this.umlPackage = umlPackage;
	}

	@Override
	public String getText(Object source) {
		if(source instanceof Profile) {
			Profile profile = (Profile)source;
			String name = profile.getQualifiedName();
			if(name == null) {
				name = UNKNOWN_PROFILE;
			}
			if(Util.isDirty(umlPackage, profile)) {
				name += TAG_PROFILE_CHANGED;
			}
			return name;
		}
		return super.getText(source);
	}
}
