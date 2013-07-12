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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.dialog.LoadCurrentAxisProvidersDialog;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.swt.widgets.Display;

/**
 * Abstract handler to load axis providers. Contains all execution logic.
 * 
 */
public abstract class AbstractLoadAxisProvidersHandler extends AbstractTableHandler {

	protected LoadCurrentAxisProvidersDialog dialog = null;

	protected EList<AbstractAxisProvider> axisProvidersHistory;

	protected AbstractAxisProvider currentAxisProvider;

	protected EStructuralFeature currentAxisProviderEReference;

	/**
	 * This handler opens the dialog displaying the axis provides, allows to choose one of them and set it as the current axis provider
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		axisProvidersHistory = getAxisProvidersHistory();
		currentAxisProvider = getCurrentAxisProvider();
		dialog = new LoadCurrentAxisProvidersDialog(Display.getDefault().getActiveShell(), axisProvidersHistory, currentAxisProvider, getConfigRegistry());
		currentAxisProviderEReference = getCurrentAxisProviderEFeature();

		//FIXME We need to provide a proper LabelProvider to display the axis' names in the dialog.

		//		final LabelProviderService serv = getConfigRegistry().getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		//		final ILabelProvider labelProvider = serv.getLabelProvider();
		//		dialog.setLabelProvider(labelProvider);

		if(dialog.open() == Window.OK) {
			final AbstractAxisProvider selectedAxisProvider = dialog.getSelectedAxisProvider();
			//Create the transactional command
			final CompositeCommand cmd = new CompositeCommand("SaveCurrentAxisProvidersHandler"); //$NON-NLS-1$
			final TransactionalEditingDomain domain = (TransactionalEditingDomain)getTableEditingDomain();
			final IEditCommandRequest request = new SetRequest(domain, this.getCurrentNattableModelManager().getTable(), currentAxisProviderEReference, selectedAxisProvider);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(this.getCurrentNattableModelManager().getTable());
			cmd.add(provider.getEditCommand(request));
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));

			return selectedAxisProvider;
		}
		return null;
	}

	/**
	 * Obtain the registry of configurations for the opened table
	 * 
	 * @return
	 */
	public IConfigRegistry getConfigRegistry() {
		return ((NatTable)((IAdaptable)this.getCurrentNattableModelManager()).getAdapter(NatTable.class)).getConfigRegistry();
	}

	public abstract EList<AbstractAxisProvider> getAxisProvidersHistory();

	public abstract AbstractAxisProvider getCurrentAxisProvider();

	public abstract EReference getCurrentAxisProviderEFeature();

}
