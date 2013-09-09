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
package org.eclipse.papyrus.infra.nattable.properties.provider;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.paste.PastePostActionRegistry;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;


public abstract class AbstractPostActionIdsProvider implements IStaticContentProvider {

	/**
	 * <code>true</code> if we are editing column
	 */
	private final boolean isEditingColumn;

	/**
	 * the table manager
	 */
	private INattableModelManager tableManager;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param isEditingColumn
	 *        <code>true</code> if we are editing columns
	 */
	public AbstractPostActionIdsProvider(final INattableModelManager tableManager, final boolean isEditingColumn) {
		this.tableManager = tableManager;
		this.isEditingColumn = isEditingColumn;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		this.tableManager = null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		final PasteEObjectConfiguration conf = (PasteEObjectConfiguration)AxisConfigurationUtils.getIAxisConfigurationUsedInTable(this.tableManager.getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), isEditingColumn);
		if(conf != null && conf.getPastedElementId() != null) {
			final EClass eClass = ElementTypeRegistry.getInstance().getType(conf.getPastedElementId()).getEClass();
			return PastePostActionRegistry.INSTANCE.getAvailablePostActionIds(this.tableManager, eClass).toArray();
		}
		return new Object[0];
	}


	/**
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 * 
	 * @return
	 */
	@Override
	public Object[] getElements() {
		return getElements(null);
	}

}
