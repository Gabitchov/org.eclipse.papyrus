/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.generation.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.dsml.validation.model.elements.impl.ConstraintManagerImpl;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintProvider;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsCategory;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IValidationRule;
import org.eclipse.papyrus.dsml.validation.model.profilenames.Utils;
import org.eclipse.papyrus.dsml.validation.wizard.CreateEMFValidationProject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Profile;


/**
 * this handler launch the creation of the plugin to validate contraints of the profile
 * 
 */
public class CreateJavaValidationPluginHandler extends AbstractHandler {

	private IConstraintsManager constraintsManager;


	/**
	 * <pre>
	 * Get the selected element, the first selected element if several are selected or null 
	 * if no selection or the selection is not an {@link EObject}. 
	 * 
	 * @return selected {@link EObject} or null
	 * </pre>
	 * 
	 */
	protected EObject getSelectedElement() {
		EObject eObject = null;
		Object selection = null;

		// Get current selection
		selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();

		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			selection = structuredSelection.getFirstElement();
		}

		// Treat non-null selected object (try to adapt and return EObject)
		if(selection != null) {

			eObject = EMFHelper.getEObject(selection);
		}
		return eObject;
	}




	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return null
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject selection = getSelectedElement();

		if(selection instanceof Profile) {
			Profile profileSelection = (Profile)selection;

			constraintsManager = new ConstraintManagerImpl(profileSelection);
			boolean isOCLConstraint = false;
			for(IConstraintProvider constraintProvider : constraintsManager.getConstraintsProviders()) {
				for(IConstraintsCategory constraintCategory : constraintProvider.getConstraintsCategories()) {
					for(IValidationRule constraint : constraintCategory.getConstraints()) {
						//this is an OCL constraint?
						if(Utils.hasSpecificationForOCL(constraint.getConstraint())) {
							isOCLConstraint = true;
						}
					}
				}
			}
			EPackage definition = null;
			if(isOCLConstraint) {
				definition = profileSelection.getDefinition();
				if(definition == null) {
					NotificationBuilder errorDialog = NotificationBuilder.createErrorPopup("The profile must be defined in order to generate OCL Constraints");
					errorDialog.run();
					//finish by displaying a message for the user to informa that it need to define it before to launch it.
					return null;
				}
			}
			CreateEMFValidationProject wizard = new CreateEMFValidationProject(profileSelection, constraintsManager, definition);
			wizard.openDialog();
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		EObject eObject = getSelectedElement();
		if(eObject instanceof Profile) {
			return true;
		}
		return false;
	}

}
