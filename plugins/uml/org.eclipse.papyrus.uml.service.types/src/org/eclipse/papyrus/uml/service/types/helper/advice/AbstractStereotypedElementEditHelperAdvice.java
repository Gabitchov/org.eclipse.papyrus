/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This abstract EditHelperAdvice is used for UML Element creation with
 * stereotype applied. In particular it overrides the approveRequest method to
 * ensure any required profile is applied. If any required profile is not
 * applied, the request should be refused (and no executable command returned).
 */
public abstract class AbstractStereotypedElementEditHelperAdvice extends AbstractEditHelperAdvice {

	/** List of profiles supposedly applied before element creation */
	protected List<EPackage> requiredProfiles = new ArrayList<EPackage>();

	/**
	 * Check required profile application before approving the request.
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request
	 * @return true if the request is approved
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		boolean isApproved = super.approveRequest(request);

		if((request != null) && (request instanceof GetEditContextRequest)) {

			// Retrieve the edit context from request
			GetEditContextRequest editContextRequest = (GetEditContextRequest)request;
			Package profileApplicationContext = null;

			// Retrieve the context nearest package (or itself)
			if(editContextRequest.getEditContext() instanceof Package) {
				profileApplicationContext = (Package)editContextRequest.getEditContext();
			} else if(editContextRequest.getEditContext() instanceof Element) {
				profileApplicationContext = ((Element)editContextRequest.getEditContext()).getNearestPackage();
			}

			// Ensure all necessary profiles are effectively applied
			if(profileApplicationContext != null) {
				for(EPackage requiredProfile : requiredProfiles) {
					if(! profileApplicationContext.getAllAppliedProfiles().contains(UMLUtil.getProfile(requiredProfile, profileApplicationContext))) {					
						isApproved = false;
						break;
					}
				}
			}
		}

		return isApproved;
	}
}
