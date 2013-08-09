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
package org.eclipse.papyrus.uml.profile.externalresource.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility class for stereotype application management in external resources
 */
public class ExternalResourceProfileUtils {

	/**
	 * @param profileApplication
	 */
	public void updateStereotypeApplicationsLocation(ProfileApplication profileApplication, IStereotypeApplicationLocationStrategy oldStrategy, IStereotypeApplicationLocationStrategy newStrategy) {
		// 1. retrieve all stereotype applications concerned by the given profile application
		// 2. move the stereotype application in their new containment list
		Resource modelResource = profileApplication.eResource();
		if(modelResource == null) {
			return;
		}
		ModelSet modelSet = null;
		if(modelResource.getResourceSet() instanceof ModelSet) {
			return;
		} else {
			modelSet = (ModelSet)modelResource.getResourceSet();
		}
		Map<EClass, List<EObject>> allStereotypeApplications = new HashMap<EClass, List<EObject>>();
		// For all resources, retrieve the containment list that should hold the stereotype application for the given profile, for all UML elements at the root of the resource (should test for all elements, but would be really slow)
		// for all elements in the containment list that corresponds to the profile application, store in a new list
		for(final EClassifier classifier : profileApplication.getAppliedDefinition().getEClassifiers()) {
			if(classifier instanceof EClass) {
				final EClass definition = (EClass)classifier;
				List<EObject> stereotypeApplications = new ArrayList<EObject>();
				for(Resource resource : modelSet.getResources()) {
					for(EObject object : resource.getContents()) {
						if(object instanceof Element) {
							// retrieve the containment list for this element and all the stereotype applications of the applied profile
							Element element = ((Element)object);
							EList<EObject> fullList = oldStrategy.getContainmentList(element, definition);
							for(EObject possibleStereotypeApplication : fullList) {
								if(definition.equals(possibleStereotypeApplication.eClass())) {
									stereotypeApplications.add(possibleStereotypeApplication);
								}
							}
						}
					}
				}
				allStereotypeApplications.put(definition, stereotypeApplications);
			}
		}
		
		// now have a map of all definitions of stereotypes contained in the profile applied, now they should be moved according to the new strategy
		for(EClass definition : allStereotypeApplications.keySet()) {
			for(EObject stereotypeApplication : allStereotypeApplications.get(definition)) {
				// move the EObject in the new containment list
				Element baseElement = UMLUtil.getBaseElement(stereotypeApplication);
				List<EObject> containmentList =newStrategy.getContainmentList(baseElement, definition); 
				if(!containmentList.contains(stereotypeApplication)) { // move the stereotype application only if it was not already there (to avoid useless moves) 
					containmentList.add(stereotypeApplication); // move stereotype at the right place
				};
			}
		}
	}
}
