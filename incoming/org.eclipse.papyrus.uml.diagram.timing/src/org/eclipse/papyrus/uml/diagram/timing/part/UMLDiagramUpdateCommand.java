/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLDiagramUpdateCommand implements IHandler {

	/**
	 * @generated
	 */
	public void addHandlerListener(final IHandlerListener handlerListener) {
	}

	/**
	 * @generated
	 */
	public void dispose() {
	}

	/**
	 * @generated
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			final IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			if(structuredSelection.size() != 1) {
				return null;
			}
			if(structuredSelection.getFirstElement() instanceof EditPart && ((EditPart)structuredSelection.getFirstElement()).getModel() instanceof View) {
				final EObject modelElement = ((View)((EditPart)structuredSelection.getFirstElement()).getModel()).getElement();
				final List editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(modelElement);
				for(final Iterator it = editPolicies.iterator(); it.hasNext();) {
					final CanonicalEditPolicy nextEditPolicy = (CanonicalEditPolicy)it.next();
					nextEditPolicy.refresh();
				}

			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @generated
	 */
	public boolean isHandled() {
		return true;
	}

	/**
	 * @generated
	 */
	public void removeHandlerListener(final IHandlerListener handlerListener) {
	}

}
