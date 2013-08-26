/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ansgar Radermacher - ansgar.radermacher@cea.fr CEA LIST - initial API and implementation
 *
 *******************************************************************************/

package org.eclipse.papyrus.exteditor.cdt;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * This class adds the C++ profile as well as the ANSI-C library to your model.
 */
public class AddProfileAndModelLibsHandler {

	static final String CPP_PROFILE_URI = "pathmap://CPP_PROFILES/C_Cpp.profile.uml"; //$NON-NLS-1$

	static final String ANSIC_LIBRARY_URI = "pathmap://CPP_LIBRARIES/Ansi_C.library.uml"; //$NON-NLS-1$

	/**
	 * Retrieve a model library from the repository
	 * 
	 * @param uri
	 *        the URI of the repository
	 * 
	 * @return
	 */
	public PackageImport getModelLibraryImportFromURI(URI uri, EditingDomain domain) {
		// Try to reach model
		Element root = getContent(uri, domain);
		if(root instanceof Package) {

			// Import model library
			Package libToImport = (Package)root;
			// create import package
			PackageImport modelLibImport = UMLFactory.eINSTANCE.createPackageImport();
			modelLibImport.setImportedPackage(libToImport);

			return modelLibImport;
		}
		return null;
	}

	public static Element getContent(URI uri, EditingDomain domain) {
		// Resource resource = getTransactionalEditingDomain ().getResourceSet().getResource (uri, true);
		Resource resource = domain.getResourceSet().getResource(uri, true);
		return getContent(resource);
	}

	public static Element getContent(Resource resource) {
		EList<EObject> contentObj = resource.getContents();
		if((contentObj.size() > 0) && (contentObj.get(0) instanceof Element)) {
			return (Element)contentObj.get(0);
		}
		return null;
	}

	/**
	 * Check whether a package import is already done
	 * 
	 * @param selectedPkg
	 * @param pi
	 * @return
	 */
	boolean isAlreadyImported(Package selectedPkg, PackageImport pi) {
		for(PackageImport existingPI : selectedPkg.getPackageImports()) {
			if((existingPI.getImportedPackage() == null) ||
				(pi.getImportedPackage() == null)) {
				// import package are null (should not happen?!)
				continue;
			}
			if((existingPI.getImportedPackage().getName() == null) ||
				(pi.getImportedPackage().getName() == null)) {
				// import package name not set (should not happen?!)
				continue;
			} else if(existingPI.getImportedPackage().getName().equals(pi.getImportedPackage().getName())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	/**
	 * {@inheritDoc}
	 */
	public Object addProfileAndImport(final Package selectedPkg) throws ExecutionException {
		
		final TransactionalEditingDomain domain;
		try {
			ServiceUtilsForActionHandlers serviceUtils = ServiceUtilsForActionHandlers.getInstance();
			domain = serviceUtils.getTransactionalEditingDomain();
		} catch (ServiceException e) {
			return null;
		}
		CommandStack stack = domain.getCommandStack();
		stack.execute(new RecordingCommand(domain, "Add C++ profile & ANSI-C library") { //$NON-NLS-1$
			public void doExecute() {
				// add primitive types			
				// create import package to primitiveType
				PackageImport pi = getModelLibraryImportFromURI (URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI), domain);
				selectedPkg.getPackageImports().add(pi);
				addCppProfile(selectedPkg, domain);
			};
		});
		return null;
	}

	public static void addCppProfile(Package selectedPkg, TransactionalEditingDomain domain) {

		// Retrieve C++ profile
		Profile cppProfile =
			(Profile)getContent(URI.createURI(CPP_PROFILE_URI), domain);
		
		// Apply C++ profile to model
		if(cppProfile instanceof Profile) {
			Profile profile = selectedPkg.getAppliedProfile(cppProfile.getQualifiedName());
			if((profile == null) && (!cppProfile.getOwnedStereotypes().isEmpty())) {
				selectedPkg.applyProfile(cppProfile);
			}
		}
	}
}
