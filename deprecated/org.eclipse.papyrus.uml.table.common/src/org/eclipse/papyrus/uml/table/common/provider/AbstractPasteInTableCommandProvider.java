/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.table.common.provider;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.Column;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidget;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.table.common.Activator;



/**
 * 
 * Abstract class for PasteInTableCommandProvider
 * 
 */
public abstract class AbstractPasteInTableCommandProvider implements IPasteInTableCommandProvider {

	//FIXME : we can't get the visible command when a dialog is open during the command creation
	protected List<Column> visibleColumns;

	/**
	 * the error message for the command
	 */
	protected String pasteErrorMessage = null;


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.table.efacet.common.provider.sysml.table.efacet.flowport.provider.internal.provider.IPasteInTableCommandProvider#getPasteErrorMessage()
	 * 
	 * @return
	 */
	public final String getPasteErrorMessage() {
		return this.pasteErrorMessage;
	}

	/**
	 * 
	 * @param papyrusTable
	 *        the papyrus table
	 * @return
	 *         the editing domain to use for the PapyrusTable
	 */
	protected TransactionalEditingDomain getEditingDomain(final PapyrusTableInstance papyrusTable) {
		TransactionalEditingDomain domain = null;
		ServicesRegistry serviceRegistry = null;
		try {
			serviceRegistry = ServiceUtilsForResource.getInstance().getServiceRegistry(papyrusTable.eResource());
		} catch (final ServiceException e) {
			Activator.log.error("ServicesRegistry not found", e); //$NON-NLS-1$
		}
		try {
			domain = ServiceUtils.getInstance().getTransactionalEditingDomain(serviceRegistry);
		} catch (final ServiceException e) {
			Activator.log.error("EdtingDomain not found", e); //$NON-NLS-1$
		}
		return domain;
	}

	/**
	 * 
	 * @param papyrusTable
	 *        the papyrus table
	 * @return
	 *         the containement feature for the created element
	 */
	protected EReference getContainementFeature(final PapyrusTableInstance papyrusTable) {
		return papyrusTable.getPastedElementContainmentFeature();
	}

	/**
	 * 
	 * @param clipboardContents
	 * @see org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractTableEditor#isPasteEnabled(java.lang.String)
	 * 
	 * @return
	 */
	public boolean isPasteEnabled(final PapyrusTableInstance papyrusTable, final String clipboardContents, final INatTableWidget iTableWidget) {
		if((clipboardContents != null) && !"".equals(clipboardContents)) { //$NON-NLS-1$
			final String[] rows = getRows(clipboardContents);
			if(rows != null && rows.length != 0) {
				final String[] cells = getCells(rows[0]);

				/*
				 * we verify that we know :
				 * - the type to create
				 * - the containment feature for the created type
				 * - the correct number of cells according to the number of managed columns for the paste
				 * - we don't do other test, because we need to provide error message to the user when the paste is not possible
				 */
				if((getIElementTypeToCreateElement(papyrusTable) != null) && (getContainementFeature(papyrusTable) != null) && (cells.length == getVisibleColumns(iTableWidget).size())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param table
	 *        a table represented by a String
	 * @return the rows for this table
	 */
	protected String[] getRows(final String table) {
		final String[] rows = table.split(ROW_SEPARATOR);
		return rows;
	}

	/**
	 * 
	 * @param row
	 *        a row represented by a String
	 * @return the cells for this row
	 */
	protected String[] getCells(final String row) {
		return row.split(COLUMN_SEPARATOR);
	}

	/**
	 * 
	 * @param pTable
	 *        the papyrus table
	 * @return
	 *         the type of element to create for a paste action
	 */
	protected IElementType getIElementTypeToCreateElement(final PapyrusTableInstance pTable) {
		final String id = pTable.getPastedElementId();
		return ElementTypeRegistry.getInstance().getType(id);
	}


	/**
	 * 
	 * @param widget
	 *        the table widget
	 * @return
	 *         the visible columns for the widget
	 */
	protected List<Column> getVisibleColumns(final INatTableWidget widget) {
		return ((NatTableWidget)widget).getVisibleColumnsUsingCustomizationEngine((TableInstance2)widget.getTableInstance());
	}

	/**
	 * 
	 * @param iTableWidget
	 *        the table widget
	 * @return
	 *         the list of the managed features
	 */
	/*
	protected List<EStructuralFeature> getManagedFeatures(final INatTableWidget iTableWidget) {
		final List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		//		for(final Column col : getManagedColumns(iTableWidget)) {
		for(final Column col : visibleColumns) {
			features.add((EStructuralFeature)((FeatureColumn)col).getFeature());
		}
		return features;
	}

	protected abstract Collection<Column> getManagedColumns(INatTableWidget iTableWidget);
	*/
}
