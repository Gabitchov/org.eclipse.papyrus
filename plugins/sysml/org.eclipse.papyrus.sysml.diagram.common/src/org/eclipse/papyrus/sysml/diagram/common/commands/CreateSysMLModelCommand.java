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
package org.eclipse.papyrus.sysml.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.extension.commands.ModelCreationCommandBase;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * The Class CreateSysMLModelCommand.
 */
public class CreateSysMLModelCommand extends ModelCreationCommandBase {

	/**
	 * @see org.eclipse.papyrus.core.extension.commands.ModelCreationCommandBase#createRootElement()
	 *
	 * @return
	 */
	
	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}
	
	/**
	 * @see org.eclipse.papyrus.core.extension.commands.ModelCreationCommandBase#initializeModel(org.eclipse.emf.ecore.EObject)
	 *
	 * @param owner
	 */
	
	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		((org.eclipse.uml2.uml.Package)owner).setName(getModelName());
		//apply SysML profile here
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

