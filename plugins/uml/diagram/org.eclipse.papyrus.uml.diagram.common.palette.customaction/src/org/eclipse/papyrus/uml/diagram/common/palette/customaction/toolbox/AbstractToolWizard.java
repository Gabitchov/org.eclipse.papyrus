/*****************************************************************************
 * Copyright (c) 2011 AtoS.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (AtoS) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.toolbox;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.uml.diagram.common.palette.customaction.providers.ITool;
import org.eclipse.swt.widgets.Display;

/**
 * A Wizard util if clients want to create a wizard for tool actions
 * 
 * @author tfaure
 * 
 */
public abstract class AbstractToolWizard extends Wizard implements ITool {

	private EditPart currentEditPart;

	private RecordingCommand command;

	private TransactionalEditingDomain domain;

	public AbstractToolWizard(EditPart part) {
		currentEditPart = part;
	}

	public EObject getEObject() {
		Object model = currentEditPart.getModel();
		if(model instanceof View) {
			View view = (View)model;
			return view.getElement();
		}
		return null;
	}

	@Override
	public final boolean performFinish() {
		command = new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				doRun();
			}
		};
		return true;
	}

	public void setTransactionalEditingDomain(TransactionalEditingDomain dom) {
		domain = dom;
	}

	public RecordingCommand getCommand() {
		return command;
	}

	public EditPart getCurrentEditPart() {
		return currentEditPart;
	}

	/**
	 * Behavior of the wizard when finish button is pressed
	 */
	public abstract void doRun();

	public void run(EditPart editPart) {
		try {
			final TransactionalEditingDomain editingDomain = ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(editPart);
			setTransactionalEditingDomain(editingDomain);
			WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), this);
			if(dialog.open() == WizardDialog.OK) {
				final RecordingCommand iCmd = getCommand();
				if(iCmd.canExecute()) {
					// execute the command
					editingDomain.runExclusive(new Runnable() {

						public void run() {
							Display.getCurrent().asyncExec(new Runnable() {

								public void run() {
									editingDomain.getCommandStack().execute(iCmd);
								}
							});
						}
					});

				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
