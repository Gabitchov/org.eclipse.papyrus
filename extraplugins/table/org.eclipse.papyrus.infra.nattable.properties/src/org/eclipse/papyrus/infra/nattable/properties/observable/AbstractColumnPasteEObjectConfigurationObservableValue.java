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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;

/**
 * Abstract class for Paste EObject on column configuration
 * 
 * @author VL222926
 * 
 */
public abstract class AbstractColumnPasteEObjectConfigurationObservableValue extends AbstractConfigurationElementObservableValue {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 * @param managedFeature
	 */
	public AbstractColumnPasteEObjectConfigurationObservableValue(final Table table, final EStructuralFeature managedFeature) {
		super(table, managedFeature);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.observable.AbstractColumnPasteEObjectConfigurationObservableValue#getEditedEObject()
	 * 
	 * @return
	 */
	@Override
	protected EObject getEditedEObject() {
		return AxisConfigurationUtils.getIAxisConfigurationUsedInTable(getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), true);
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
		IAxisConfiguration editedEObject = (IAxisConfiguration)getEditedEObject();
		if(editedEObject == null) {
			editedEObject = NattableaxisconfigurationFactory.eINSTANCE.createPasteEObjectConfiguration();
		}
		final ICommand cmd = TableCommands.getSetIAxisConfigurationValueCommand(getTable(), editedEObject, getManagedFeature(), value, true);
		final TransactionalEditingDomain domain = TableEditingDomainUtils.getTableEditingDomain(getTable());
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
	}
}
