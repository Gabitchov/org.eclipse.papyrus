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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.LabelConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;

/**
 * The Class AbstractRowObjectLabelProviderConfigurationObservableValue.
 * 
 * @author vl222926
 */
public abstract class AbstractRowObjectLabelProviderConfigurationObservableValue extends AbstractConfigurationElementObservableValue {

	/**
	 * Constructor.
	 * 
	 * @param table
	 *        the table
	 * @param managedFeature
	 *        the managed feature
	 */
	public AbstractRowObjectLabelProviderConfigurationObservableValue(final Table table, final EStructuralFeature managedFeature) {
		super(table, managedFeature);
	}

	/**
	 * Gets the edited e object.
	 * 
	 * @return the edited e object
	 * @see org.eclipse.papyrus.infra.nattable.properties.observable.AbstractConfigurationElementObservableValue#getEditedEObject()
	 */
	@Override
	protected EObject getEditedEObject() {
		return LabelConfigurationManagementUtils.getUsedRowObjectLabelConfiguration(getTable());
	}

	/**
	 * Do set value.
	 * 
	 * @param value
	 *        the value
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doSetValue(java.lang.Object)
	 */
	@Override
	protected void doSetValue(Object value) {
		final ICommand cmd = TableCommands.getSetRowLabelConfigurationValueCommand(getTable(), (ILabelProviderConfiguration)getEditedEObject(), getManagedFeature(), value);
		final TransactionalEditingDomain domain = TableEditingDomainUtils.getTableEditingDomain(getTable());
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
	}
}
