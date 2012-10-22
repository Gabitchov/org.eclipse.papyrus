/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.popupmenu.execution;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.moka.environment.MokaEnvironment;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A handler for running the selected behavior.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public final class RunBehaviorAction extends AbstractHandler {

	public RunBehaviorAction() {
	}

	/**
	 * Return the behavior associated with the selection object or null whether
	 * no behavior could have been found
	 * 
	 * @param selected
	 * @return Behavior
	 */
	private Behavior getBehaviorFromSelection(ISelection selected) {
		if(selected.isEmpty()) {
			return null;
		} else {
			// Every object retrieved from the model explorer is an IAdaptable
			IAdaptable adaptableObj = (IAdaptable)((IStructuredSelection)selected).getFirstElement();
			// Get the model object behind the adaptable object
			EObject modelObj = (EObject)adaptableObj.getAdapter(org.eclipse.emf.ecore.EObject.class);
			NamedElement nElem = (NamedElement)modelObj;
			return nElem instanceof Behavior ? (Behavior)nElem : null;
		}
	}

	/**
	 * Call the Execution engine with the right behavior as a parameter
	 * 
	 * @param behavior
	 *        Activity that we want to run
	 */
	private void start(Behavior behavior) {
		MokaEnvironment.executeBehavior(behavior);
	}

	/**
	 * Method invoked as the behavior of the "Run Behavior" command
	 * 
	 * @param event
	 * @return Object
	 */
	public Object execute(ExecutionEvent event) {
		Behavior behavior = null;
		behavior = this.getBehaviorFromSelection(HandlerUtil.getCurrentSelection(event));
		if(behavior != null) {
			if(MokaEnvironment.log.isDebugEnabled()) {
				MokaEnvironment.log.debug("Behavior retrieved from selection: " + behavior.getQualifiedName()); //$NON-NLS-1$
			}
			this.start(behavior);
		} else {
			// TODO show a dialog box instead
			if(MokaEnvironment.log.isDebugEnabled()) {
				MokaEnvironment.log.debug("The selected element is not a behavior"); //$NON-NLS-1$
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		final IStructuredSelection selection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		if(selection.size() == 1) {
			Object current = selection.getFirstElement();
			if(current instanceof IAdaptable) {
				final EObject eobject = (EObject)((IAdaptable)current).getAdapter(EObject.class);
				return eobject instanceof Behavior;
			}
		}
		return false;
	}
}
