/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.service.palette;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.jface.dialogs.MessageDialog;


/**
 * Command that pops up a dialog to ask which values you want.
 */
public class SetDynamicValueCommand extends EditElementCommand implements IUndoableOperation {

	/** request that configures this command */
	protected DynamicConfigureRequest request;

	/** list of properties to edit */
	protected List<String> propertiesToEdit;

	/**
	 * Constructor.
	 * 
	 * @param label
	 * @param elementToEdit
	 * @param request
	 */
	protected SetDynamicValueCommand(DynamicConfigureRequest request) {
		super(request.getLabel(), request.getElementToEdit(), request);
		this.propertiesToEdit = request.getPropertiesToDefine();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EObject elementToEdit = getElementToEdit();

		// open a message dialog to ask for values
		MessageDialog.openInformation(DisplayUtils.getDefaultShell(), "This should be the editor", "editing : " + getElementToEdit() + " : " + propertiesToEdit);

		//		boolean many = FeatureMapUtil.isMany(elementToEdit, feature);
		//		if(many) {
		//			Collection collection = ((Collection)elementToEdit.eGet(feature));
		//			if(value instanceof List) {
		//				List values = (List)value;
		//				collection.clear();
		//				collection.addAll(values);
		//			} else {
		//				collection.add(value);
		//			}
		//		} else {
		//			getElementToEdit().eSet(feature, value);
		//		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Checks that the feature is a modifiable feature of the element whose
	 * value will be set by this command. Also checks that the new value is of
	 * the correct type for the feature.
	 */
	public boolean canExecute() {
		EObject elementToEdit = getElementToEdit();
		if(elementToEdit == null || !super.canExecute()) {
			return false;
		}
		return true;
		//		boolean many = FeatureMapUtil.isMany(elementToEdit, feature);
		//		if(value == null && many) {
		//			return false;
		//		}
		//		List allFeatures = getElementToEdit().eClass().getEAllStructuralFeatures();
		//		if(allFeatures.contains(feature) && feature.isChangeable()) {
		//			if(!many && (value == null || feature.getEType().isInstance(value)))
		//				return true;
		//			else {
		//				return verifyMany();
		//			}
		//		}
		// return false;
	}

	//	private boolean verifyMany() {
	//		if(value instanceof List) {
	//			List values = (List)value;
	//			for(Iterator iter = values.iterator(); iter.hasNext();) {
	//				Object element = iter.next();
	//				if(!feature.getEType().isInstance(element))
	//					return false;
	//			}
	//			return true;
	//		}
	//		return feature.getEType().isInstance(value);
	//	}

}
