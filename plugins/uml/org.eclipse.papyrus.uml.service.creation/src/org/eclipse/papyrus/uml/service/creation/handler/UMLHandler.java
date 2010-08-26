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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.creation.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.utils.BusinessModelResolver;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.ui.PlatformUI;

/**
 * this is an abstract Handler used to create element.
 * It remains only to put the elementType to manage
 * 
 */
public abstract class UMLHandler extends AbstractHandler {

	protected abstract Command getCommand() throws ExecutionException;

	/**
	 * get the selected element
	 * 
	 * @return
	 */
	protected EObject getSelectedElement() {
		EObject eObject = null;
		Object selection = getCurrentSelection();

		if(selection != null) {

			if(selection instanceof IAdaptable) {
				selection = ((IAdaptable)selection).getAdapter(EObject.class);
			}
			

			Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(selection);
			if(businessObject instanceof EObject) {
				eObject = (EObject)businessObject;
			}
		}
		return eObject;
	}


	/**
	 * get the selected element
	 * 
	 * @return
	 */
	protected EReference getSelectedEFeature() {
		EReference eref = null;
		Object selection = getCurrentSelection();

		if(selection != null) {

			if(selection instanceof LinkItem) {
				eref = ((LinkItem)selection).getReference();
			}
		}
		return eref;
	}
	
	
	protected EObject getContainerpOfEFeature() {
		EObject eObject = null;
		Object selection = getCurrentSelection();

		if(selection != null) {

			if(selection instanceof LinkItem) {
				eObject = ((LinkItem)selection).getParent();
			}
		}
		return eObject;
	}
	private Object getCurrentSelection() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return structuredSelection.getFirstElement();
		}

		return null;
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

		EditorUtils.getTransactionalEditingDomain().getCommandStack().execute(getCommand());
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return true is the command can be executed
	 */
	public boolean isEnabled() {
		try {
			if(getCommand().canExecute()) {
				return true;
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 
	 * @return true if the command can be executed
	 */
	public boolean isVisible() {
		try {
			if(getCommand().canExecute()) {
				return true;
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return false;
	}
}
