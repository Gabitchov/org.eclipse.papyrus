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
package org.eclipse.papyrus.infra.nattable.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.editors.TwoInputDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Abstract handler to save the current axis provider into the table's historic. It asks for a name and a description.
 * 
 */
public abstract class AbstractSaveCurrentAxisProvidersHandler extends AbstractTableHandler {


	/**
	 * Execute the save action according to the values provided by the concrete handlers.
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final AbstractAxisProvider currentAxisProvider = getAxisProvider();
		final EList<AbstractAxisProvider> axisProvidersHistory = getAxisProviderHistory();
		final EReference eReference = getAxisProviderHistoryEReference();
		return saveAxisProviderConfig(this.getCurrentNattableModelManager(), currentAxisProvider, axisProvidersHistory, eReference);
	}

	/**
	 * Given the proper references, it displays the dialog pre-filled with data from the current provider.
	 * 
	 * @param currentNattableModelManager
	 * @param axisProvider
	 * @param axisProvidersHistory
	 * @param axisProvidersHistoryEReference
	 * @return
	 */
	public Object saveAxisProviderConfig(final INattableModelManager currentNattableModelManager, final AbstractAxisProvider axisProvider, EList<AbstractAxisProvider> axisProvidersHistory, EReference axisProvidersHistoryEReference) {
		final AbstractAxisProvider copy = EcoreUtil.copy(axisProvider);
	
		//We ask the user for a name and description
		String name = axisProvider.getName();
		String description = axisProvider.getDescription();
	
		
		final List<String> existingProviderNames = new ArrayList<String>();
		for(AbstractAxisProvider abstractAxisProvider : axisProvidersHistory) {
			existingProviderNames.add(abstractAxisProvider.getName());
		}
		TwoInputDialog dialog = new TwoInputDialog(Display.getCurrent().getActiveShell(), Messages.AbstractSaveCurrentAxisProvidersHandler_0, Messages.AbstractSaveCurrentAxisProvidersHandler_1, Messages.AbstractSaveCurrentAxisProvidersHandler_2, name, description, new IInputValidator() {
			
			@Override
			public String isValid(String newText) {
				if(newText == null || newText.equals("")) { //$NON-NLS-1$
					return Messages.AbstractSaveCurrentAxisProvidersHandler_4;
				} else if(existingProviderNames.contains(newText)) {
					return Messages.AbstractSaveCurrentAxisProvidersHandler_5;
				}
				return null;
			}
		});
		if(dialog.open() == Dialog.OK) {
			//get the name and the description for the table
			name = dialog.getValue();
			description = dialog.getValue_2();
	
			copy.setName(name);
			copy.setDescription(description);
	
			final List<AbstractAxisProvider> historyCopy = new ArrayList<AbstractAxisProvider>(axisProvidersHistory);
			historyCopy.add(copy);
			
			//Create the transactional command
			final CompositeCommand cmd = new CompositeCommand("SaveCurrentAxisProvidersHandler"); //$NON-NLS-1$
			final IEditCommandRequest request = new SetRequest((TransactionalEditingDomain)getTableEditingDomain(), currentNattableModelManager.getTable(), axisProvidersHistoryEReference, historyCopy);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(currentNattableModelManager.getTable());
			cmd.add(provider.getEditCommand(request));
			getTableEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));

	
			return copy;
		}
		return null;
	}

	/**
	 * Obtain the current axis provider.
	 * 
	 * @return
	 */
	public abstract AbstractAxisProvider getAxisProvider();

	/**
	 * Obtain all the axis providers contained in this table's historic.
	 * 
	 * @return
	 */
	public abstract EList<AbstractAxisProvider> getAxisProviderHistory();

	/**
	 * Get the EReference to set a new value for this table's historic of axis providers.
	 * 
	 * @return
	 */
	public abstract EReference getAxisProviderHistoryEReference();

}
