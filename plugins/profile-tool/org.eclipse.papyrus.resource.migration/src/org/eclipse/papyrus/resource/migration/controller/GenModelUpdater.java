/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.resource.migration.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.resource.ResourcePackage;
import org.eclipse.papyrus.resource.migration.controller.exceptions.URINotValidException;

/**
 * This class makes comaptible a genmodel with Resource meta model
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class GenModelUpdater {

	/**
	 * The URI for Resource Genmodel
	 */
	private static final URI uriForResourceGenModel = URI
			.createURI("platform:/plugin/org.eclipse.papyrus.resource/model/resource.genmodel");

	/**
	 * The URI for Resource Ecore meta model
	 */
	private static final URI uriForEclassResourceEObject = URI
			.createURI("platform:/plugin/org.eclipse.papyrus.resource/model/resource.ecore#//ResourceEObject");

	/**
	 * instance of resource package used to reference usedGenpackage in the original genmodel
	 */
	private ResourcePackage resourcePackage = ResourcePackage.eINSTANCE;

	/**
	 * Eclass for resource Eobject
	 */
	private EClass resourceEObjectEClass = null;

	/**
	 * current Epackage for the meta model corresponding to the current genmodel
	 */
	private EPackage currentEPackage = null;

	/**
	 * Transform the genmodel sotred at the given URI to link it with Resource Meta model
	 * 
	 * @param uri
	 * @throws URINotValidException
	 * @throws IOException
	 */
	public void transform(URI uri) throws URINotValidException, IOException {
		if (uri == null) {
			throw new URINotValidException("uri is null");
		}
		ResourceSet set = new ResourceSetImpl();
		try {
			Resource resource = set.getResource(uri, true);
			if (resource != null) {
				EObject e = resource.getContents().get(0);
				if (e instanceof GenModel) {
					GenModel genmodel = (GenModel) e;
					Resource toSave = update(genmodel);
					if (toSave != null) {
						resource.save(Collections.EMPTY_MAP);
						toSave.save(Collections.EMPTY_MAP);
					}
				} else {
					throw new URINotValidException("uri " + uri.toString() + "doesn't reference a genmodel");
				}
			}
			// we have to unload the resource to free the memory
			for (Resource r : set.getResources()) {
				if (r.isLoaded()) {
					try {
						r.unload();
					} catch (Exception e) {
						// to prevent unload exception
					}
				}
			}
		} catch (RuntimeException e) {
			throw new URINotValidException("uri " + uri.toString() + "not valid");
		}
	}

	/**
	 * update the genmodel to reference Resource Meta model
	 * 
	 * @param genmodel
	 * @return true if the resource has to be saved
	 */
	private Resource update(GenModel genmodel) {
		// does the genmodel already contain the resource ?
		Resource result = null;
		boolean found = false;
		for (GenPackage p : genmodel.getUsedGenPackages()) {
			found |= resourcePackage.equals(p.getEcorePackage());
		}
		if (!found) {
			// we load the Resource GenModel
			Resource resourceForResourceGenmodel = genmodel.eResource().getResourceSet().getResource(
					uriForResourceGenModel, true);
			if (resourceForResourceGenmodel != null) {
				EObject root = resourceForResourceGenmodel.getContents().get(0);
				if (root instanceof GenModel) {
					GenModel model = (GenModel) root;
					// Resource Genmodel is a used gen package for the current genmodel
					genmodel.getUsedGenPackages().add(model.getGenPackages().get(0));
					// load the eclass resource eobject
					Resource resourceResource = genmodel.eResource().getResourceSet().getResource(
							uriForEclassResourceEObject.trimFragment(), true);
					if (resourceResource != null) {
						// we get the ResourceEObject EClass
						EObject resourceEObjectEobject = resourceResource.getEObject(uriForEclassResourceEObject
								.fragment());
						if (resourceEObjectEobject instanceof EClass) {
							resourceEObjectEClass = (EClass) resourceEObjectEobject;
							result = addResourceEobjectInheritance(genmodel);
						}
					}
				}
			}
		}
		// if not found we have to save
		return result;
	}

	/**
	 * add the inheritance to each EObject
	 * 
	 * @param genmodel
	 */
	private Resource addResourceEobjectInheritance(GenModel genmodel) {
		// we resolve to have access to all the eobjects
		EcoreUtil.resolveAll(genmodel.eResource().getResourceSet());
		Resource result = null;
		List<GenPackage> packages = genmodel.getGenPackages();
		if (packages.size() > 0) {
			GenPackage genPackage = packages.get(0);
			currentEPackage = genPackage.getEcorePackage();
			result = currentEPackage.eResource();
			manageEPackage(currentEPackage);
		}
		return result;
	}

	/**
	 * Recursive method to browse EPackages
	 * 
	 * @param currentEPackage2
	 */
	private void manageEPackage(EPackage currentEPackage2) {
		for (EClassifier eclassifier : currentEPackage2.getEClassifiers()) {
			if (eclassifier instanceof EClass) {
				EClass eClass = (EClass) eclassifier;
				manageEClass(eClass);
			}
		}
		for (EPackage ePackage : currentEPackage2.getESubpackages()) {
			manageEPackage(ePackage);
		}

	}

	/**
	 * Recursive method to manage hierarchy tree
	 * 
	 * @param eClass
	 */
	private void manageEClass(EClass eClass) {
		if (eClass != resourceEObjectEClass) {
			if (eClass.getESuperTypes().size() == 0) {
				if (isACorrectEPackage(eClass.getEPackage())) {
					eClass.getESuperTypes().add(resourceEObjectEClass);
				}
			} else {
				boolean toAdd = true;
				for (EClass eClass2 : eClass.getESuperTypes()) {
					toAdd &= !isACorrectEPackage(eClass2.getEPackage());
					manageEClass(eClass2);
				}
				if (toAdd) {
					eClass.getESuperTypes().add(resourceEObjectEClass);
				}
			}
		}
	}

	/**
	 * determine if the ePackage given in parameter is a children of the current Epackage
	 * 
	 * @param ePackage
	 * @return
	 */
	private boolean isACorrectEPackage(EPackage ePackage) {
		EPackage current = ePackage;
		while (current != null && current != currentEPackage) {
			current = current.getESuperPackage();
		}
		return current == currentEPackage;
	}
}
