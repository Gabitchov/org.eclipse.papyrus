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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.profile.externalresource.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility class for stereotype application management in external resources
 */
public class ExternalResourceProfileUtils {

	/**
	 * @param profileApplication
	 */
	public static IStatus updateStereotypeApplicationsLocation(ProfileApplication profileApplication, IStereotypeApplicationLocationStrategy oldStrategy, IStereotypeApplicationLocationStrategy newStrategy) {
		// 1. retrieve all stereotype applications concerned by the given profile application
		// 2. move the stereotype application in their new containment list
		Resource modelResource = profileApplication.eResource();
		if(modelResource == null) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Impossible to find model resource");
		}
		ModelSet modelSet = null;
		if(!(modelResource.getResourceSet() instanceof ModelSet)) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Trying to modify the stereotype application outside a Papyrus Model Set");
		} else {
			modelSet = (ModelSet)modelResource.getResourceSet();
		}
		Map<EClass, List<EObject>> allStereotypeApplications = new HashMap<EClass, List<EObject>>();
		// For all resources, retrieve the containment list that should hold the stereotype application for the given profile, for all UML elements at the root of the resource (should test for all elements, but would be really slow)
		// for all elements in the containment list that corresponds to the profile application, store in a new list
		List<EClassifier> classifiers = profileApplication.getAppliedDefinition().getEClassifiers();
		for(final EClassifier classifier : classifiers) {
			if(classifier instanceof EClass) {
				final EClass definition = (EClass)classifier;
				List<EObject> stereotypeApplications = new ArrayList<EObject>();
				for(Resource resource : modelSet.getResources()) {
					// if resource = read only (model import, etc.), nothing should be done
					if(!modelSet.getTransactionalEditingDomain().isReadOnly(resource)) {
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
		
		// update Eannotation that stores the new strategy
		PapyrusStereotypeApplicationHelper.setCurrentLocationStrategy(profileApplication, newStrategy);
		
		return Status.OK_STATUS;
	}
	
	public static ICommand createUpdateStereotypeApplicationsLocationCommand( ProfileApplication profileApplication, IStereotypeApplicationLocationStrategy oldStrategy, IStereotypeApplicationLocationStrategy newStrategy) {
		if(profileApplication ==null) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		// create a command based on #updateStereotypeApplicationsLocation() 
		return new UpdateStereotypeApplicationsLocationCommand(profileApplication, oldStrategy, newStrategy);
	}
	
	
	public static ICommand createUpdateStereotypeApplicationsLocationCommand( Element element,  IStereotypeApplicationLocationStrategy oldStrategy,  IStereotypeApplicationLocationStrategy newStrategy) {
		if(element ==null) {
			return null;
		}
		// retrieve all stereotype applications from the element (should be for each root => subpackages and over), all stereotype applications
		EObject root = EcoreUtil.getRootContainer(element, true);
		if(root instanceof Package) {
			List<ProfileApplication> profileApplications = new ArrayList<ProfileApplication>();
			computeAllProfileApplications((Package)root, true, profileApplications);
			return createUpdateStereotypeApplicationsLocationCommand(profileApplications, oldStrategy, newStrategy);
		} 
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}
	
	/**
	 * @param element
	 * @param recursive <code>true</code> if profile applications should be searched in nested packages 
	 * @return
	 */
	protected static void computeAllProfileApplications(Package package_, boolean recursive, List<ProfileApplication> profileApplications) {
		List<ProfileApplication> thisPackageProfileApplications = package_.getProfileApplications();
		if(thisPackageProfileApplications != null && thisPackageProfileApplications.size() > 0) {
			profileApplications.addAll(thisPackageProfileApplications);
		}
		
		if(recursive) {
			for(Package ownedPackage : package_.getNestedPackages()) {
				computeAllProfileApplications(ownedPackage, recursive, profileApplications);
			}
		}
	}

	public static ICommand createUpdateStereotypeApplicationsLocationCommand(List<ProfileApplication> profileApplications, IStereotypeApplicationLocationStrategy oldStrategy, IStereotypeApplicationLocationStrategy newStrategy) {
		if(profileApplications == null || profileApplications.size() < 1) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		ICommand resultCommand = null;
		for(ProfileApplication profileApplication : profileApplications) {
			resultCommand = new UpdateStereotypeApplicationsLocationCommand(profileApplication, oldStrategy, newStrategy).compose(resultCommand);
		}
		return resultCommand;
	}
	
}
