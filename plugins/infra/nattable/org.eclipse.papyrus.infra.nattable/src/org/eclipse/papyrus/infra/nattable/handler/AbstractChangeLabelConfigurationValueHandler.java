/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.LocalTableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Abstract class used to change label configuration
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractChangeLabelConfigurationValueHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final CompositeCommand cmd = new CompositeCommand("ChangeLabelConfigurationValueCommand"); //$NON-NLS-1$
		TransactionalEditingDomain domain = (TransactionalEditingDomain)getTableEditingDomain();
		ILabelProviderConfiguration labelConf = getLabelProviderConfiguration();
		ILabelProviderConfiguration editedLabelConf;
		if(labelConf.eContainer() instanceof TableHeaderAxisConfiguration) {
			editedLabelConf = EcoreUtil.copy(labelConf);
			cmd.add(getRegisterLocalLabelConfigurationCommand(labelConf, editedLabelConf));
		} else {
			editedLabelConf = labelConf;
		}
		Command command = event.getCommand();
		boolean oldValue = HandlerUtil.toggleCommandState(command);
		final IEditCommandRequest request = new SetRequest(domain, editedLabelConf, getEditedFeature(), !oldValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(editedLabelConf);
		cmd.add(provider.getEditCommand(request));
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		return null;
	}

	/**
	 * 
	 * @return
	 *         the edited label configuration
	 */
	protected abstract ILabelProviderConfiguration getLabelProviderConfiguration();

	/**
	 * 
	 * @return
	 *         the edited feature
	 */
	protected abstract EStructuralFeature getEditedFeature();

	/**
	 * 
	 * @param conf
	 * 
	 */
	protected ICommand getRegisterLocalLabelConfigurationCommand(ILabelProviderConfiguration tableLabelConfiguration, ILabelProviderConfiguration localTableLabelConfiguration) {
		TransactionalEditingDomain domain = (TransactionalEditingDomain)getTableEditingDomain();
		final CompositeCommand cmd = new CompositeCommand("ChangeHeaderLabelConfigurationCommand"); //$NON-NLS-1$
		final Table table = getCurrentNattableModelManager().getTable();

		//1. we must get or create the required LocalTableHeaderAxisConfiguration
		AbstractHeaderAxisConfiguration configuration = getHeaderAxisConfiguration();
		LocalTableHeaderAxisConfiguration localConfig = null;
		if(configuration instanceof LocalTableHeaderAxisConfiguration) {
			localConfig = (LocalTableHeaderAxisConfiguration)configuration;
		} else if(configuration instanceof TableHeaderAxisConfiguration) {
			//we can't edit it, because it's comes from the initial configuration
			configuration = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration((TableHeaderAxisConfiguration)configuration);
			localConfig = (LocalTableHeaderAxisConfiguration)configuration;
			final IEditCommandRequest request = new SetRequest(domain, table, getLocalHeaderAxisConfigurationFeature(), configuration);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(table);
			cmd.add(provider.getEditCommand(request));
		}

		//2. this one must store the new label configuration
		final IEditCommandRequest request = new SetRequest(domain, configuration, NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_OwnedLabelConfigurations(), localTableLabelConfiguration);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(configuration);
		cmd.add(provider.getEditCommand(request));

		//3. we must get or create the AxisManagerConfiguration(s)
		final TableHeaderAxisConfiguration headerAxisConfig = getTableHeaderAxisConfiguration();

		final List<AxisManagerConfiguration> axisManagerConfiguration = new ArrayList<AxisManagerConfiguration>();
		for(final AxisManagerRepresentation current : headerAxisConfig.getAxisManagers()) {
			//we look for defined axis manager which uses the labelconfiguration defined in the table config
			if(current.getHeaderLabelConfiguration() == tableLabelConfiguration) {
				AxisManagerConfiguration currentConf = null;
				//we look for an axis manager configuration mapped in this axis manager representation
				for(final AxisManagerConfiguration axisConf : localConfig.getAxisManagerConfigurations()) {
					if(axisConf.getAxisManager() == current) {
						currentConf = axisConf;
					}
				}
				if(currentConf == null) {
					currentConf = NattableaxisconfigurationFactory.eINSTANCE.createAxisManagerConfiguration();
					currentConf.setAxisManager(current);
					final IEditCommandRequest request2 = new SetRequest(domain, localConfig, NattableaxisconfigurationPackage.eINSTANCE.getLocalTableHeaderAxisConfiguration_AxisManagerConfigurations(), currentConf);
					final IElementEditService provider2 = ElementEditServiceUtils.getCommandProvider(localConfig);
					cmd.add(provider2.getEditCommand(request2));
				}
				axisManagerConfiguration.add(currentConf);
			}
		}

		//4. these one must reference the LabelConfiguration
		for(final AxisManagerConfiguration current : axisManagerConfiguration) {
			final IEditCommandRequest request2 = new SetRequest(domain, current, NattableaxisconfigurationPackage.eINSTANCE.getAxisManagerConfiguration_LocalHeaderLabelConfiguration(), localTableLabelConfiguration);
			final IElementEditService provider2 = ElementEditServiceUtils.getCommandProvider(current);
			cmd.add(provider2.getEditCommand(request2));
		}
		return cmd;
	}

	/**
	 * 
	 * @return
	 *         the feature to use to edit the local header axis configuration
	 */
	protected abstract EStructuralFeature getLocalHeaderAxisConfigurationFeature();

	/**
	 * 
	 * @return
	 *         the edited axis configuration
	 */
	protected abstract AbstractHeaderAxisConfiguration getHeaderAxisConfiguration();

	/**
	 * 
	 * @return
	 *         the table header axis defined in the TableConfiguration and used for edited label axis configuration
	 */
	protected abstract TableHeaderAxisConfiguration getTableHeaderAxisConfiguration();
}
