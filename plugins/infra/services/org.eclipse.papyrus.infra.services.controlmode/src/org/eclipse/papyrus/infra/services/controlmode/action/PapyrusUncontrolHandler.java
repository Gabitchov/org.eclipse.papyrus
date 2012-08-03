/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.action;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.ISources;

/**
 * 
 * @author Camille Letavernier
 * 
 */
//FIXME: Partial implementation to repair the Control/Uncontrol menu. Introduces several issues.
public class PapyrusUncontrolHandler extends AbstractHandler {

	//FIXME: EditingDomain is leaked here. The handler isn't destroyed after the editor is closed.
	PapyrusUncontrolAction action;

	public PapyrusUncontrolHandler() {
		setBaseEnabled(false);
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(action != null) {
			action.run();
		}
		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		if(evaluationContext instanceof IEvaluationContext) {
			IEvaluationContext context = (IEvaluationContext)evaluationContext;
			Object selection = context.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
			if(selection instanceof IStructuredSelection) {
				IStructuredSelection currentSelection = (IStructuredSelection)selection;

				EditingDomain domain = null;

				Iterator<?> iterator = currentSelection.iterator();
				while(iterator.hasNext()) {
					domain = EMFHelper.resolveEditingDomain(iterator.next());
					if(domain != null) {
						break;
					}
				}

				action = new PapyrusUncontrolAction(domain);
				action.updateSelection(currentSelection);
				setBaseEnabled(action.isEnabled());
			}
		} else {
			setBaseEnabled(false);
		}
	}

	@Override
	public void dispose() {
		System.out.println("Dispose");
		super.dispose();
		action = null;
	}

}
