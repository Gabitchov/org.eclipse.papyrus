/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IInvariantCreationElementValidator;
import org.eclipse.papyrus.uml.tools.extendedtypes.invariantstereotypeconfiguration.InvariantStereotypeConfiguration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;



/**
 * @author RS211865
 */
public class InvariantStereotypeCreationElementValidator implements IInvariantCreationElementValidator<InvariantStereotypeConfiguration> {

	private String stereotypeQualifiedName;
	private String requiredProfile;

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreate(CreateElementRequest request) {
		// check basic element type can be created
		
		// check container is a UML element
		EObject container = request.getContainer();
		if(!(container instanceof Element)) {
			return false;
		}
		
		Package nearestPackage = ((Element)container).getNearestPackage();
		if(nearestPackage == null) {
			// impossible to check the applied profiles for the container
			return false;
		}

		Profile appliedProfile = nearestPackage.getAppliedProfile(requiredProfile, true);
		return appliedProfile !=null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(InvariantStereotypeConfiguration configuration) {
		 stereotypeQualifiedName = configuration.getStereotypeQualifiedName();
		 requiredProfile = configuration.getRequiredProfile();
		 
		 if(requiredProfile == null) {
			 // try to find the profile qualified name from the qualified stereotype name
			 requiredProfile = stereotypeQualifiedName.substring(stereotypeQualifiedName.lastIndexOf(NamedElement.SEPARATOR));
		 }
	}
}
