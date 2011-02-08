/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - Initial implementation
 * Modification: Patrick Tessier (CEA LIST)
 ******************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.actions;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.CommandActionHandler;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.uml.modelexplorer.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Action to rename a {@link NamedElement} in the Model Explorer. This action is binded to the "F2"
 * key.
 * 
 */

/**
 * @deprecated
 *             We should provide an Handler for the command org.eclipse.ui.edit.rename
 */
@Deprecated
public class RenameNamedElementAction extends CommandActionHandler {

	/**
	 * Constructor binds this action to the "F2" key.
	 * 
	 * @param editingDomain
	 */
	public RenameNamedElementAction(EditingDomain editingDomain) {
		super(editingDomain, Messages.rename);
		setAccelerator(SWT.F2);
	}

	/**
	 * The selected {@link NamedElement}.
	 */
	private NamedElement selectedNamedElement = null;

	/**
	 * Get the selected {@link NamedElement}.
	 * 
	 * @return
	 */
	protected NamedElement getSelectedNamedElement() {
		return selectedNamedElement;
	}

	/**
	 * Set the selected {@link NamedElement}.
	 * 
	 * @param selectedNamedElement
	 */
	// @notused
	protected void setSelectedNamedElement(NamedElement selectedNamedElement) {
		this.selectedNamedElement = selectedNamedElement;
	}

	/**
	 * Update the selection.
	 * 
	 * @return true if this {@link Action} is still enabled after the new selection.
	 */
	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		ISelection unwrappedselection = NavigatorUtils.unwrapSelection(selection);
		if(unwrappedselection instanceof StructuredSelection) {
			StructuredSelection structuredSelection = (StructuredSelection)unwrappedselection;
			if(structuredSelection.size() == 1) {
				Object selectedObject = NavigatorUtils.resolveSemanticObject(structuredSelection.getFirstElement());
				if(selectedObject instanceof NamedElement) {
					setSelectedNamedElement((NamedElement)selectedObject);
					return super.updateSelection(new StructuredSelection(selection));
				}
			}
		}
		setSelectedNamedElement(null);
		return super.updateSelection(selection);
	}

	/**
	 * Create the {@link Command} to execute when this {@link Action} is run.
	 */
	@Override
	public Command createCommand(Collection<?> selection) {
		TransactionalEditingDomain domain = getTransactionalEditingDomain();
		if(domain == null) {
			return null;
		}
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), Messages.rename_element, Messages.new_name, getSelectedNamedElement().getName(), null);
				if(dialog.open() == Window.OK) {
					final String name = dialog.getValue();
					getSelectedNamedElement().setName(name);
				}
			}
		};
	}

	/**
	 * Get the {@link EditingDomain} as a {@link TransactionalEditingDomain}.
	 * 
	 * @return
	 */
	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		if(getEditingDomain() instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain)getEditingDomain();
		}
		return null;
	}

	/**
	 * Update the active {@link IWorkbenchPart} and the active {@link EditingDomain}.
	 * 
	 * @param workbenchPart
	 */
	public void setActiveWorkbenchPart(IWorkbenchPart workbenchPart) {
		if(workbenchPart instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider)workbenchPart).getEditingDomain();
		}
	}
}
