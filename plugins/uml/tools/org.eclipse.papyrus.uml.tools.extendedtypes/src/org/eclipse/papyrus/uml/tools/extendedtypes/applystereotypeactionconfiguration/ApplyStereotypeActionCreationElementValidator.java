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
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.IActionCreationElementValidator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * @author RS211865
 */
public class ApplyStereotypeActionCreationElementValidator implements IActionCreationElementValidator<ApplyStereotypeActionConfiguration> {

	protected ApplyStereotypeActionConfiguration configuration;

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreate(CreateElementRequest request) {
		if(configuration == null) {
			return false;
		}
		if(!(request.getContainer() instanceof Element)) {
			return false;
		}
		Element container = (Element)request.getContainer();
		Package nearestPackage = container.getNearestPackage();
		if(nearestPackage == null) {
			return false;
		}
		List<Profile> appliedProfiles = nearestPackage.getAllAppliedProfiles();
		if(appliedProfiles==null) {
			// no profiles applied, no stereotype can be applied
			return false;
		}
		List<String> appliedProfileNames = new ArrayList<String>();
		for(Profile profile : appliedProfiles) {
			appliedProfileNames.add(profile.getQualifiedName());
		}
		for(StereotypeToApply stereotypeToApply : configuration.getStereotypesToApply()) {
			List<String> requiredProfiles = stereotypeToApply.getRequiredProfiles();
			if(requiredProfiles != null) {
				for(String requiredProfile : requiredProfiles) {
					if(!appliedProfileNames.contains(requiredProfile)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(ApplyStereotypeActionConfiguration configuration) {
		this.configuration = configuration;
	}
}
