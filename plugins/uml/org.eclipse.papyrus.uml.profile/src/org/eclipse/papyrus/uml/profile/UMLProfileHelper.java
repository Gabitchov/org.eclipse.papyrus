/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.viewpoints.policy.IProfileHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;


/**
 * Implementation of the IProfileHelper interface for UML profiles
 * @author Laurent Wouters
 */
public class UMLProfileHelper implements IProfileHelper {

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IProfileHelper#getAppliedProfiles(org.eclipse.emf.ecore.EObject)
	 */
	public Collection<EPackage> getAppliedProfiles(EObject model) {
		ArrayList<EPackage> result = new ArrayList<EPackage>();
		if (!(model instanceof Element))
			return result;
		Element element = (Element)model;
		Package p = element.getNearestPackage();
		if (p == null)
			return result;
		for (Profile profile : p.getAllAppliedProfiles()) {
			if (!result.contains(profile.getDefinition()))
				result.add(profile.getDefinition());
		}
		return result;
	}

	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.policy.IProfileHelper#getAppliedStereotypes(org.eclipse.emf.ecore.EObject)
	 */
	public Collection<EClass> getAppliedStereotypes(EObject object) {
		ArrayList<EClass> result = new ArrayList<EClass>();
		if (!(object instanceof Element))
			return result;
		Element element = (Element)object;
		for (EObject app : element.getStereotypeApplications()) {
			if (!result.contains(app.eClass()))
				result.add(app.eClass());
		}
		return result;
	}
}
