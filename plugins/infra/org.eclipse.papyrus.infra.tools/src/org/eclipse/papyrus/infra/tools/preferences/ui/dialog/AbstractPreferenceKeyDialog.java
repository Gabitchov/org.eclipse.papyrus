/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.preferences.ui.dialog;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.infra.tools.Activator;
import org.eclipse.papyrus.infra.tools.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * The Class AbstractPreferenceKeyDialog display all preference key that are given in parameters
 */
public abstract class AbstractPreferenceKeyDialog extends org.eclipse.jface.dialogs.StatusDialog {

	/** The key table. */
	protected Table keyTable;

	/** The table viewer. */
	protected TableViewer tableViewer;

	/** The keys. */
	protected String[] keys;

	/**
	 * Instantiates a new abstract preference key dialog.
	 * 
	 * @param keys
	 *        the array of preferences to display
	 */
	public AbstractPreferenceKeyDialog(String[] keys) {
		super(new Shell());
		this.keys = keys;
		setStatusLineAboveButtons(true);
		updateStatus(new Status(IStatus.INFO, Activator.PLUGIN_ID, Messages.AbstractPreferenceKeyDialog_WouldYouLikeOverloadPreferences));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		keyTable = new Table(composite, SWT.CHECK | SWT.BORDER);
		tableViewer = new TableViewer(keyTable);
		tableViewer.setLabelProvider(createLabelProvider());
		tableViewer.setContentProvider(createContentProvider());

		TableColumn column = new TableColumn(keyTable, SWT.NONE);
		column.setWidth(150);
		column.setText(Messages.AbstractPreferenceKeyDialog_Pref_Kind);

		column = new TableColumn(keyTable, SWT.NONE);
		column.setWidth(90);
		column.setText(Messages.AbstractPreferenceKeyDialog_Level);

		column = new TableColumn(keyTable, SWT.NONE);
		column.setWidth(200);
		column.setText(Messages.AbstractPreferenceKeyDialog_Localization);
		tableViewer.setInput(keys);
		keyTable.setHeaderVisible(true);


		return composite;

	}

	/**
	 * 
	 * @return
	 *         the label provider for the table viewer
	 */
	protected abstract IBaseLabelProvider createLabelProvider();

	/**
	 * 
	 * @return
	 *         the content provider for the table viewer
	 */
	protected abstract IContentProvider createContentProvider();

}
