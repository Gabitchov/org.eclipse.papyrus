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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;


/**
 * use to validate the model from a selected element in the model
 * 
 */
public class ValidateModelCommand extends AbstractValidateCommand {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedElement
	 */
	public ValidateModelCommand(EObject selectedElement) {
		super("Validate model", TransactionUtil.getEditingDomain(selectedElement), getTopOwner(selectedElement));
	}


	/**
	 * get the root element
	 * 
	 * @param selectedElement
	 * @return the root element
	 */
	private static EObject getTopOwner(EObject selectedElement) {
		EObject selectedObject = selectedElement;
		while(selectedObject.eContainer() != null) {
			selectedObject = selectedObject.eContainer();
		}
		return selectedObject;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// replace selection by model instead of current selection
		if(selectedElement != null) {
			runValidation(selectedElement);
		}
		return null;
	}
}
