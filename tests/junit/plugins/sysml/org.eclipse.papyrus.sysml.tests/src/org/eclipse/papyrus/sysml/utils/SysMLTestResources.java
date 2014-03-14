/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.utils;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLUtil;

public class SysMLTestResources {

	protected static final ResourceSet RESOURCE_SET = new ResourceSetImpl();

	/**
	 * Creates a model with SysML profile applied for JUnit test
	 *
	 * @return the created model
	 */
	public static Model createSysMLModel() {

		SysMLTestResources.registerResourceFactories();

		Model model = null;
		model = UMLFactory.eINSTANCE.createModel();
		model.setName("TestSysML");

		Resource resource = RESOURCE_SET.createResource(URI.createURI("temp.uml"));
		resource.getContents().add(model);

		// Apply UML Standard profile
		// Retrieve standard profile
		Profile umlStdProfile = (Profile)PackageUtil.loadPackage(URI.createURI(UMLResource.STANDARD_PROFILE_URI), RESOURCE_SET);
		// Apply to new model
		model.applyProfile(umlStdProfile);

		// Retrieve SysML profile and apply with subprofile
		Profile sysml = (Profile)PackageUtil.loadPackage(URI.createURI(SysmlResource.SYSML_PROFILE_URI), RESOURCE_SET);
		if(sysml != null) {
			PackageUtil.applyProfile(model, sysml, true);
		}

		return model;
	}

	protected static void registerPathmaps(URI uri) {
		URIConverter.URI_MAP.put(URI.createURI(UMLResource.LIBRARIES_PATHMAP), uri.appendSegment("libraries").appendSegment(""));

		URIConverter.URI_MAP.put(URI.createURI(UMLResource.METAMODELS_PATHMAP), uri.appendSegment("metamodels").appendSegment(""));

		URIConverter.URI_MAP.put(URI.createURI(UMLResource.PROFILES_PATHMAP), uri.appendSegment("profiles").appendSegment(""));
	}

	protected static void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
	}

	protected static void save(org.eclipse.uml2.uml.Package package_, URI uri) {
		Resource resource = RESOURCE_SET.createResource(uri);
		EList<EObject> contents = resource.getContents();

		contents.add(package_);

		for(Iterator<?> allContents = UMLUtil.getAllContents(package_, true, false); allContents.hasNext();) {

			EObject eObject = (EObject)allContents.next();

			if(eObject instanceof Element) {
				contents.addAll(((Element)eObject).getStereotypeApplications());
			}
		}

		try {
			resource.save(null);
		} catch (IOException ioe) {
			// err
		}
	}
}
