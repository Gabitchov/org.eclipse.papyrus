/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.wizards.CreateNattableFromCatalogWizard;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Handler to display the wizard to display the catalog of existing Nattable configurations.
 */
public class CreateNatTableFromCatalogHandler extends AbstractHandler {



	/**
	 * We open the dialog, request the user for the desired configuration
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.handlers.AbstractCreateNattableEditorHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final EObject context = getSelection().get(0);
		CreateNattableFromCatalogWizard wizard = new CreateNattableFromCatalogWizard(context);
		WizardDialog dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		ServicesRegistry serviceRegistry = null;
		TransactionalEditingDomain domain = null;
		try {
			serviceRegistry = ServiceUtilsForHandlers.getInstance().getServiceRegistry(event);
			domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
		} catch (ServiceException e) {
			Activator.log.error(e);
			return null;
		}

		if(dialog.open() == Window.OK){
			CompoundCommand compoundCommand = new CompoundCommand("Create tables from Catalog"); //$NON-NLS-1$
			
			for(TableConfiguration tableConfiguration : wizard.getSelectedConfig().keySet()) {
				CreateNatTableEditorHandler handler = new CreateNatTableEditorHandler();
				handler.setType(tableConfiguration.getType());

				//See how many tables were required for this type
				Integer tablesQuantity = wizard.getSelectedConfig().get(tableConfiguration);

				//Get the chosen name for the tables under this configuration
				final String tableConfigName = wizard.getTableNames().get(tableConfiguration);
				for(int i = 0; i < tablesQuantity; i++) {
					try {
						Command cmd = handler.getCreateNattableEditorCommandWithNameInitialization(domain, serviceRegistry, event, tableConfigName + "_" + i);//$NON-NLS-1$
						compoundCommand.append(cmd);
					} catch (ServiceException e) {
						Activator.log.error(e);
					}
				}
			}
			if(!compoundCommand.isEmpty()) {
				domain.getCommandStack().execute(compoundCommand);
			}

		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.handlers.CreateNatTableEditorHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	public void setEnabled(Object evaluationContext) {
		setBaseEnabled(getSelection().size()==1);
	}

	/**
	 * 
	 * @return
	 */
	protected List<EObject> getSelection() {
		final List<EObject> selectedElements = new ArrayList<EObject>();
		final IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(ww != null) {
			final ISelection selection = ww.getSelectionService().getSelection();
			if(selection instanceof IStructuredSelection) {

				final IStructuredSelection structuredSelection = (IStructuredSelection)selection;

				final Iterator<?> it = structuredSelection.iterator();
				while(it.hasNext()) {
					final Object object = it.next();
					if(object instanceof IAdaptable) {
						final EObject currentEObject = (EObject)((IAdaptable)object).getAdapter(EObject.class);

						if(currentEObject != null) {
							selectedElements.add(currentEObject);
						}
					}

				}
			}
		}
		return selectedElements;
	}

}
