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
 * Abstract class for the rowHeaderAxisConfiguration
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractRowHeaderAxisConfigurationObservableValue extends AbstractConfigurationElementObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 *        the managed table
	 * @param managedFeature
	 *        the managed feature
	 */
	public AbstractRowHeaderAxisConfigurationObservableValue(Table table, EStructuralFeature managedFeature) {
		super(table, managedFeature);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.observable.AbstractConfigurationElementObservableValue#getEditedEObject()
	 * 
	 * @return
	 */
	@Override
	protected final EObject getEditedEObject() {
		return HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisUsedInTable(getTable());
	}

	/**
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 * 
	 * @param value
	 */
	@Override
	protected final void doSetValue(final Object value) {
		final ICommand cmd = TableCommands.getSetRowHeaderConfigurationValueCommand(getTable(), getManagedFeature(), value);
		final TransactionalEditingDomain domain = TableEditingDomainUtils.getTableEditingDomain(getTable());
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
	}

}
