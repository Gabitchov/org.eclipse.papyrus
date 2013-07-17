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
package org.eclipse.papyrus.infra.nattable.properties.observable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.command.TableCommands;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;

/**
 * Abstract class for the columnHeaderAxisConfiguration
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractColumnHeaderAxisConfigurationObservableValue extends AbstractConfigurationElementObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the managed table
	 * @param managedFeature
	 *        the managed feature
	 */
	public AbstractColumnHeaderAxisConfigurationObservableValue(Table table, EStructuralFeature managedFeature) {
		super(table, managedFeature);
	}

	/**
	 * 
	 * @return
	 *         the header axis configuration to use to get the value
	 */
	@Override
	protected final EObject getEditedEObject() {
		return HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisUsedInTable(getTable());
	}

	/**
	 * 
	 * @param value
	 *        the new value
	 */
	@Override
	protected final void doSetValue(final Object value) {
		final ICommand cmd = TableCommands.getSetColumnHeaderConfigurationValueCommand(getTable(), getManagedFeature(), value);
		final TransactionalEditingDomain domain = TableEditingDomainUtils.getTableEditingDomain(getTable());
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
	}

}
