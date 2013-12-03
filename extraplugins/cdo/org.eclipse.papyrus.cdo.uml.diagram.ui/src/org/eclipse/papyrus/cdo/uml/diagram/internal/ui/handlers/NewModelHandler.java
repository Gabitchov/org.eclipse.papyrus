/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.uml.diagram.internal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.net4j.util.ui.UIUtil;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.uml.diagram.wizards.InitModelWizard;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This is the NewModelHandler type. Enjoy.
 */
public class NewModelHandler extends AbstractHandler {

	public NewModelHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		setEnabled(event.getApplicationContext());

		if(isEnabled()) {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			if(selection instanceof IStructuredSelection) {
				InitModelWizard wizard = new InitModelWizard();

				wizard.init(HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench(), (IStructuredSelection)selection);

				WizardDialog dlg = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
				dlg.open();
			}
		}

		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		Object variable = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		ISelection selection = variable instanceof ISelection ? (ISelection)variable : StructuredSelection.EMPTY;
		CDOObject cdoObject = CDOUtils.adapt(UIUtil.getElement(selection), CDOObject.class);

		setBaseEnabled((cdoObject == null) || !CDOUtils.isReadOnly(cdoObject));
	}
}
