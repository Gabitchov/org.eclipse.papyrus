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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainuUtils;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
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


}
