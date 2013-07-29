/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * The Class CreateUMLModelCommand.
 */
public class CreateUMLModelCommand extends ModelCreationCommandBase {

	public static final String COMMAND_ID = "uml"; 

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
	}

	/**
	 * Gets the model name.
	 * 
	 * @return the model name
	 */
	protected String getModelName() {
		return "model";
	}
}
