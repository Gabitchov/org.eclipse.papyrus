/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Profile;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileUtil.
 */
public class ProfileUtil {

	/**
	 * Gets the applied profiles from ws.
	 * 
	 * @param openedModel
	 *        the opened model
	 * @return the applied profiles from ws
	 */
	public static Object[] getAppliedProfilesFromWS(EObject openedModel) {





		//the list of root profiles, we will export only the root profiles and profiles that are applied from local workspace plugins
		// use of set to not having duplicate elements
		Set<EObject> rootProfiles = new HashSet<EObject>();


		for(Profile p : ((org.eclipse.uml2.uml.Package)openedModel).getAllAppliedProfiles()) {

			rootProfiles.add(getRootLocalProfile(p));

		}



		Object[] profilesToExport = rootProfiles.toArray(new Object[rootProfiles.size()]);
		return profilesToExport;


	}

	/**
	 * Gets the root local profile.
	 * 
	 * @param p
	 *        the p
	 * @return the root local profile
	 */
	public static EObject getRootLocalProfile(EObject p) {
		if(p.eContainer() == null) {
			Resource eResource = p.eResource();
			if(eResource != null) {
				URI eUri = eResource.getURI();
				if(eUri.isPlatformResource()) {
					return p;
				} else
					return null;
			} else
				return null;

		} else
			return getRootLocalProfile(p.eContainer());


	}



}
