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

package org.eclipse.papyrus.infra.viewpoints.policy;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * Represents a helper for the Policy Checker that is able to check the application of UML profiles
 * 
 * @author Laurent Wouters
 */
public interface IProfileHelper {

	/**
	 * Gets a collection of the profiles (as EPackage-s) applied on the given model
	 * 
	 * @param model
	 *            The model to inspect
	 * @return A collection of profiles (as EPackage)
	 */
	Collection<EPackage> getAppliedProfiles(EObject model);

	/**
	 * Gets a collection of the stereotypes (as EClass-es) applied to the given object
	 * 
	 * @param object
	 *            The object to inspect
	 * @return A collection of stereotypes (as EClass)
	 */
	Collection<EClass> getAppliedStereotypes(EObject object);
}
