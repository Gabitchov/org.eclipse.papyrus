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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Strategy that uses one resource per profile application
 */
public class ResourcePerProfileStrategy implements IStereotypeApplicationLocationStrategy {

	/** default resource name */
	protected static final String DEFAULT_RESOURCE_NAME = "default"; //$NON-NLS-1$

	/** default resource extension */
	protected static final String DEFAULT_RESOURCE_EXTENSION = "profile"; //$NON-NLS-1$

	/** key for the value of the eannotation that is used to store specific URI for stereotype application resource */
	public static final String SPECIFIC_URI_EANNOTATION_KEY = "specificURI"; //$NON-NLS-1$

	/** identifier of this strategy */
	public static final String ID = "ResourcePerProfileStrategy"; //$NON-NLS-1$

	/** singleton instance */
	private static ResourcePerProfileStrategy instance;

	/**
	 * Returns the singleton instance for this strategy
	 * 
	 * @return the singleton instance for this strategy
	 */
	public static ResourcePerProfileStrategy getInstance() {
		if(instance == null) {
			instance = new ResourcePerProfileStrategy();
		}
		return instance;
	}

	/**
	 * Returns the resource where the stereotype application should be added for the given couple element/stereotype
	 * 
	 * @param element
	 *        the stereotyped element
	 * @param definition
	 *        the definition of the stereotype to apply
	 * @return the resource where the stereotype application should be added
	 */
	public Resource getStereotypeApplicationResource(Element element, EClass definition) {
		// in this case, the resource is specific to the profile application.
		// the profile application should give the right path.
		// 1. retrieve profile application
		// 2. ask it for the resource name (by default, it should give the name of the profile)
		// 3. compute the resource name
		// 4. ask to create on demand ?
		// 5. return the content of this resource
		ProfileApplication profileApplication = getProfileApplication(element, definition);
		Resource baseResource = element.eResource();
		if(baseResource==null) {
			return null;
		}
		ResourceSet resourceSet = baseResource.getResourceSet();
		if(resourceSet instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)resourceSet;
			URI  newURI = getProfileApplicationResourceURI(profileApplication, baseResource);
			Resource resource = ModelUtils.getOrCreateResource(modelSet, true, newURI, UMLResource.UML_CONTENT_TYPE_IDENTIFIER);
			return resource;
		}
		// by default, return the resource containing the element
		return element.eResource();
	}

	/**
	 * Returns the specific URI indicated on the profile application
	 * 
	 * @param profileApplication
	 *        the profile application that should have stereotype applications in resource with specific URI
	 * @return the specific URI or <code>null</code>
	 */
	protected URI getSpecificURI(ProfileApplication profileApplication, Resource baseResource) {
		EAnnotation annotation = profileApplication.getEAnnotation(PapyrusStereotypeApplicationHelper.PAPYRUS_EXTERNAL_RESOURCE_EANNOTATION_SOURCE);
		if(annotation != null) {
			String value = annotation.getDetails().get(SPECIFIC_URI_EANNOTATION_KEY);
			URI newURI = baseResource.getURI();
			newURI = newURI.trimSegments(1);
			newURI = newURI.appendSegment(value);
			return newURI;
		}
		return null;
	}

	/**
	 * Checks if the profile application should use a specific URI for the steroetype application resources
	 * 
	 * @param profileApplication
	 *        profile application that should have stereotype applications in resource with specific URI
	 * @return <code>true</code> if a specific URI is specified for the profile application
	 */
	protected boolean hasSpecificURI(ProfileApplication profileApplication) {
		EAnnotation annotation = profileApplication.getEAnnotation(PapyrusStereotypeApplicationHelper.PAPYRUS_EXTERNAL_RESOURCE_EANNOTATION_SOURCE);
		return annotation != null;
	}

	protected String getStereotypeApplicationResourceExtension(ProfileApplication profileApplication, boolean basedOnMainProfile) {
		// 1. check if nested profiles have the same resource or if each nested profile has its own resource  
		// 2. deduce the name from the profile application
		// 3. return the string. This will be the extension of the file
		String resourceExtension = null;
		if(profileApplication != null) {
			Profile profile = profileApplication.getAppliedProfile();
			if(profile != null) {
				// if based on main profile => retrieve the main profile name.
				// otherwise, returns the name of the profile
				if(basedOnMainProfile) {
					Profile parentProfile = profile;
					while(parentProfile.getNestingPackage() instanceof Profile) {
						parentProfile = (Profile)parentProfile.getNestingPackage();
					}
					resourceExtension = parentProfile.getName() + "Profile"; // warning, can not return an extension which is linked to another factory than a UML Factory
				} else {
					resourceExtension = profile.getName() + "Profile";
				}
			}
		}
		if(resourceExtension == null) {
			resourceExtension = DEFAULT_RESOURCE_EXTENSION;
		}
		return resourceExtension;
	}

	protected String getStereotypeApplicationResourceName(ProfileApplication profileApplication, boolean basedOnMainProfile) {
		// 1. check if nested profiles have the same resource or if each nested profile has its own resource  
		// 2. deduce the name from the profile application.  
		// 3. return the string. This will be the extension of the file
		String resourceName = null;
		if(profileApplication != null) {
			Package applyingPackage = profileApplication.getApplyingPackage();
			if(applyingPackage != null) {
				resourceName = applyingPackage.eResource().getURI().trimFileExtension().lastSegment();
			}
		}
		if(resourceName == null) {
			resourceName = DEFAULT_RESOURCE_NAME;
		}
		return resourceName;
	}

	/**
	 * Returns the profile application for the given element on which the stereotype with specified definition is or will be applied
	 * 
	 * @param element
	 *        the UML element on which stereotype is applied
	 * @return the profile application or <code>null</code> if none was found.
	 */
	protected ProfileApplication getProfileApplication(Element element, EClass definition) {
		Package nearestPackage = element.getNearestPackage();
		if(nearestPackage == null) {
			return null;
		}
		List<ProfileApplication> profileApplications = nearestPackage.getAllProfileApplications();
		for(ProfileApplication profileApplication : profileApplications) {
			EPackage appliedDefinition = profileApplication.getAppliedDefinition();
			List<EClassifier> classifiers = appliedDefinition.getEClassifiers();
			if(classifiers != null && !classifiers.isEmpty() && classifiers.contains(definition)) {
				return profileApplication;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EList<EObject> getContainmentList(Element element, EClass definition) {
		Resource stereotypeApplicationResource = getStereotypeApplicationResource(element, definition);
		if(stereotypeApplicationResource != null) {
			return stereotypeApplicationResource.getContents();
		}
		// fallback: adds stereotype at the root of the UML resource.
		Resource elementResource = element.eResource();
		if(elementResource != null) {
			return elementResource.getContents();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<URI> getProfileApplicationResourceURIs(EObject root) {
		Set<URI> uris = new HashSet<URI>();
		// 1. retrieve all profile applications
		// 2. retrieve all URI from all this profile applications
		if(root instanceof Element && root.eResource()!=null) {
			Package nearestPackage = ((Element)root).getNearestPackage();
			if(nearestPackage != null) {
				List<ProfileApplication> profileApplications = nearestPackage.getAllProfileApplications();
				for(ProfileApplication profileApplication : profileApplications) {
					URI newURI = getProfileApplicationResourceURI(profileApplication, root.eResource());
					uris.add(newURI);
				}
			}
		}
		return uris;
	}

	protected URI getProfileApplicationResourceURI(ProfileApplication profileApplication, Resource baseResource) {
		// test if it needs a specific name. Otherwise, it will use a default name
		URI newURI = null;
		if(hasSpecificURI(profileApplication)) {
			newURI = getSpecificURI(profileApplication, baseResource);
		}
		if(newURI == null) {
			URI baseURI = baseResource.getURI();
			newURI = baseURI.trimSegments(1);
			String resourceName = getStereotypeApplicationResourceName(profileApplication, true);
			newURI = newURI.appendSegment(resourceName);
			String extension = getStereotypeApplicationResourceExtension(profileApplication, true);
			newURI = newURI.appendFileExtension(extension);
		}
		return newURI;
	}
}
