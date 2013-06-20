/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.modelexplorer.util;

import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

public class ProfileUtil {

	public static Profile getAppliedProfile(org.eclipse.uml2.uml.Package package_, String qualifiedName) {

		for(ProfileApplication profileApplication : package_.getAllProfileApplications()) {

			Profile appliedProfile = profileApplication.getAppliedProfile();

			if(appliedProfile != null && UML2Util.safeEquals(appliedProfile.getQualifiedName(), qualifiedName)) {

				return appliedProfile;
			}
		}

		return null;
	}
}
