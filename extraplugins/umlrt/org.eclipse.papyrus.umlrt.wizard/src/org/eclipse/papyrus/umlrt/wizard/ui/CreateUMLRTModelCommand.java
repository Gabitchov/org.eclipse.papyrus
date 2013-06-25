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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlrt.wizard.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

//Unused yet. The Papyrus wizard is not really useful when the language/profile doesn't provide specific diagrams
public class CreateUMLRTModelCommand extends ModelCreationCommandBase {

	public static final String COMMAND_ID = "org.eclipse.papyrus.umlrt.wizard.createmodel.command";

	public static final String UMLRT_PROFILE_URI = "pathmap://UMLRT_PROFILES/umlProfile/uml-rt.profile.uml";

	/**
	 * @see org.eclipse.papyrus.infra.core.extension.commands.ModelCreationCommandBase#createRootElement()
	 * 
	 * @return
	 */

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.extension.commands.ModelCreationCommandBase#initializeModel(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param owner
	 */

	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		((org.eclipse.uml2.uml.Package)owner).setName(getModelName());

		// Retrieve UML RT profile and apply
		Profile umlrt = (Profile)PackageUtil.loadPackage(URI.createURI(UMLRT_PROFILE_URI), owner.eResource().getResourceSet());
		if(umlrt != null) {
			PackageUtil.applyProfile(((org.eclipse.uml2.uml.Package)owner), umlrt, true);
		}
	}

	/**
	 * Gets the model name.
	 * 
	 * @return the model name
	 */
	protected String getModelName() {
		return "RT Model";
	}
}
