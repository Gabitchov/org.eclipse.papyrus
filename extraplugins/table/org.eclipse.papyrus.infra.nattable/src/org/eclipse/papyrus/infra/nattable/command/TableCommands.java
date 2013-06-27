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
package org.eclipse.papyrus.infra.nattable.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
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
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainuUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * This class provides some useful commands used to edit the table properties
 * 
 * @author vl222926
 * 
 */
public class TableCommands {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	private TableCommands() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param feature
	 *        the edited feature
	 * @param newValue
	 *        the new value for this feature
	 * @return
	 *         the command to change a value in the row configuration header of a table
	 */
	//FIXME : the handler must use me
	public static ICommand getSetRowHeaderConfigurationValueCommand(final Table table, final EStructuralFeature feature, final Object newValue) {
		final TransactionalEditingDomain domain = TableEditingDomainuUtils.getTableEditingDomain(table);
		final CompositeCommand compositeCommand = new CompositeCommand("SetRowHeaderConfigurationCommand"); //$NON-NLS-1$
		EObject elementToEdit = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisUsedInTable(table);
		if(elementToEdit instanceof TableHeaderAxisConfiguration) {
			elementToEdit = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration((TableHeaderAxisConfiguration)elementToEdit);
			SetRequest request = null;
			if(!table.isInvertAxis()) {
				request = new SetRequest(domain, table, NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration(), elementToEdit);
			} else {
				request = new SetRequest(domain, table, NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration(), elementToEdit);
			}
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(table);
			final ICommand cmd = provider.getEditCommand(request);
			compositeCommand.add(cmd);
		}
		final SetRequest request = new SetRequest(domain, elementToEdit, feature, newValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit);
		final ICommand cmd = provider.getEditCommand(request);
		compositeCommand.add(cmd);
		return compositeCommand;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param feature
	 *        the edited feature
	 * @param newValue
	 *        the new value for this feature
	 * @return
	 *         the command to change a value in the column configuration header of a table
	 */
	//FIXME : the handler must use me
	public static ICommand getSetColumnHeaderConfigurationValueCommand(final Table table, final EStructuralFeature feature, final Object newValue) {
		final TransactionalEditingDomain domain = TableEditingDomainuUtils.getTableEditingDomain(table);
		final CompositeCommand compositeCommand = new CompositeCommand("SetColumnHeaderConfigurationCommand"); //$NON-NLS-1$
		EObject elementToEdit = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisUsedInTable(table);
		if(elementToEdit instanceof TableHeaderAxisConfiguration) {
			elementToEdit = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration((TableHeaderAxisConfiguration)elementToEdit);
			SetRequest request = null;
			if(table.isInvertAxis()) {
				request = new SetRequest(domain, table, NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration(), elementToEdit);
			} else {
				request = new SetRequest(domain, table, NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration(), elementToEdit);
			}
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(table);
			final ICommand cmd = provider.getEditCommand(request);
			compositeCommand.add(cmd);
		}
		final SetRequest request = new SetRequest(domain, elementToEdit, feature, newValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit);
		final ICommand cmd = provider.getEditCommand(request);
		compositeCommand.add(cmd);
		return compositeCommand;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param usedLabelConfiguration
	 *        the used label configuration
	 * @param editedFeature
	 *        the edited feature
	 * @param newValue
	 *        the new value for this feature
	 * @return
	 *         the command to modify the feature value in the label configuration of the table. This command adds the localLabelConfiguration when it
	 *         is required
	 */
	//FIXME the handler must use me
	public static final ICommand getSetColumnFeatureLabelConfigurationValueCommand(final Table table, final ILabelProviderConfiguration usedLabelConfiguration, final EStructuralFeature editedFeature, final Object newValue) {
		final CompositeCommand cmd = new CompositeCommand("ChangeColumnLabelConfigurationValueCommand"); //$NON-NLS-1$
		TransactionalEditingDomain domain = TableEditingDomainuUtils.getTableEditingDomain(table);
		ILabelProviderConfiguration editedLabelConf;
		if(usedLabelConfiguration.eContainer() instanceof TableHeaderAxisConfiguration) {
			editedLabelConf = EcoreUtil.copy(usedLabelConfiguration);
			cmd.add(getRegisterLocalColumnLabelConfigurationCommand(table, usedLabelConfiguration, editedLabelConf));
		} else {
			editedLabelConf = usedLabelConfiguration;
		}
		final IEditCommandRequest request = new SetRequest(domain, editedLabelConf, editedFeature, newValue);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(editedLabelConf);
		cmd.add(provider.getEditCommand(request));
		return cmd;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param tableLabelConfiguration
	 *        the table LabelConfiguration
	 * @param localTableLabelConfiguration
	 *        the local table label configuration
	 * @return
	 *         the command to register the local column label configuration to the table
	 */
	private static final ICommand getRegisterLocalColumnLabelConfigurationCommand(final Table table, ILabelProviderConfiguration tableLabelConfiguration, ILabelProviderConfiguration localTableLabelConfiguration) {
		TransactionalEditingDomain domain = TableEditingDomainuUtils.getTableEditingDomain(table);
		final CompositeCommand cmd = new CompositeCommand("ChangeHeaderLabelConfigurationCommand"); //$NON-NLS-1$

		//1. we must get or create the required LocalTableHeaderAxisConfiguration
		AbstractHeaderAxisConfiguration configuration = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisUsedInTable(table);
		LocalTableHeaderAxisConfiguration localConfig = null;
		if(configuration instanceof LocalTableHeaderAxisConfiguration) {
			localConfig = (LocalTableHeaderAxisConfiguration)configuration;
		} else if(configuration instanceof TableHeaderAxisConfiguration) {
			//we can't edit it, because it's comes from the initial configuration
			configuration = HeaderAxisConfigurationManagementUtils.transformToLocalHeaderConfiguration((TableHeaderAxisConfiguration)configuration);
			localConfig = (LocalTableHeaderAxisConfiguration)configuration;
			EStructuralFeature axisConfigurationFeature = NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration();
			if(!table.isInvertAxis()) {
				axisConfigurationFeature = NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration();
			}
			final IEditCommandRequest request = new SetRequest(domain, table, axisConfigurationFeature, configuration);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(table);
			cmd.add(provider.getEditCommand(request));
		}

		//2. this one must store the new label configuration
		final IEditCommandRequest request = new SetRequest(domain, configuration, NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_OwnedLabelConfigurations(), localTableLabelConfiguration);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(configuration);
		cmd.add(provider.getEditCommand(request));

		//3. we must get or create the AxisManagerConfiguration(s)
		final TableHeaderAxisConfiguration headerAxisConfig = (TableHeaderAxisConfiguration)HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTableConfiguration(table);

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
}
