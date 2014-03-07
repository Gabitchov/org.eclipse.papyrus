/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.commands;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * The Class CreateSysMLModelCommand.
 */
public class CreateSysMLModelCommand extends ModelCreationCommandBase {

	public static final String COMMAND_ID = "sysml";

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

		// Retrieve SysML profile and apply with Sub-profile
		Profile sysml = (Profile)PackageUtil.loadPackage(URI.createURI(SysmlResource.SYSML_PROFILE_URI), owner.eResource().getResourceSet());
		if(sysml != null) {
			PackageUtil.applyProfile(((org.eclipse.uml2.uml.Package)owner), sysml, true);
		}
	}

	/**
	 * Gets the model name.
	 * 
	 * @return the model name
	 */
	protected String getModelName() {
		return "SysMLmodel";
	}
}
