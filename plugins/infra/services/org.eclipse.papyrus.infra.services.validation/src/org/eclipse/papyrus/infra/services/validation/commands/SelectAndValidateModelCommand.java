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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.papyrus.infra.services.validation.ValidationTool;
import org.eclipse.ui.dialogs.PreferencesUtil;

/**
 * this command is used to open the list of constraint to compute on the root model
 *
 */
public class SelectAndValidateModelCommand extends AbstractValidateCommand {

	/**
	 * 
	 * Constructor.
	 *
	 * @param selectedElement
	 */
	public SelectAndValidateModelCommand(EObject selectedElement) {
		super("Validate subtree", TransactionUtil.getEditingDomain(selectedElement), getTopOwner(selectedElement));
	}
	
	/**
	 * get the root element
	 * @param selectedElement
	 * @return the root element
	 */
	private static EObject getTopOwner(EObject selectedElement){
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

		String idRootPage = "org.eclipse.emf.validation.ui.rootPage";
		String idConstraints = "org.eclipse.emf.validation.constraintsPrefs";
		String filter[] = {
			idRootPage,
			idConstraints
		};
		PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(null, idConstraints, filter, null);
		int result = dialog.open();

		if(result == IDialogConstants.OK_ID) {
			if( selectedElement!=null){
				ValidationTool vt = new ValidationTool(selectedElement);
				vt.deleteSubMarkers();
				runValidation(selectedElement);
			}
		}
		return null;
	}
}
