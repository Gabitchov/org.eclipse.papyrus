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
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui.dialog;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * The Class AbstractPreferenceKeyDialog display all preference key that are given in parameters
 */
@Deprecated
public class AbstractPreferenceKeyDialog extends org.eclipse.jface.dialogs.StatusDialog {

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
	 *        the array of preference jy to display
	 */
	public AbstractPreferenceKeyDialog(String[] keys) {
		super(new Shell());
		this.keys = keys;
		setStatusLineAboveButtons(true);
		updateStatus(new Status(IStatus.INFO, Activator.PLUGIN_ID, "Would you like to overload those preferences?"));
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
		tableViewer.setLabelProvider(new KeyLabelProvider());
		tableViewer.setContentProvider(new KeyContentProvider());

		TableColumn column = new TableColumn(keyTable, SWT.NONE);
		column.setWidth(150);
		column.setText("Pref. kind ");

		column = new TableColumn(keyTable, SWT.NONE);
		column.setWidth(90);
		column.setText("Level");

		column = new TableColumn(keyTable, SWT.NONE);
		column.setWidth(200);
		column.setText("Localization");
		tableViewer.setInput(keys);
		keyTable.setHeaderVisible(true);


		return composite;

	}

	/**
	 * The Class KeyLabelProvider.
	 */
	protected class KeyLabelProvider extends LabelProvider implements ITableLabelProvider, ITableColorProvider {


		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableColorProvider#getForeground(java.lang.Object, int)
		 */
		public Color getForeground(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableColorProvider#getBackground(java.lang.Object, int)
		 */
		public Color getBackground(Object element, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			if(columnIndex == 0) {
				if(element.toString().startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
					return Activator.getPluginIconImage(Activator.PLUGIN_ID, "/icons/pref.gif");
				}
				if(element.toString().startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					return Activator.getPluginIconImage(Activator.PLUGIN_ID, "/icons/diag.gif");
				}
			}
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		public String getColumnText(Object element, int columnIndex) {
			String initialKey = element.toString();
			String out = initialKey.toString();
			if(columnIndex == 0) {
				out = out.substring(out.indexOf(".") + 1, out.length()).toUpperCase();
			}
			if(columnIndex == 1) {
				if(element.toString().startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
					return "ELEMENT";
				}
				if(element.toString().startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					return "DIAGRAM";
				}
			}
			if(columnIndex == 2) {
				if(initialKey.startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
					out = initialKey.toString().replaceAll(PreferencesConstantsHelper.DIAGRAM_ELEMENT, "");
					// Reorganize display
					if(out.indexOf(".") > 0) {
						String beforePoint = out.substring(0, out.indexOf("."));
						if(beforePoint.lastIndexOf("_") > 0) {
							out = out.substring(beforePoint.lastIndexOf("_") + 1, out.indexOf(".")) + " (" + beforePoint.substring(0, beforePoint.lastIndexOf("_")) + ")";
						}
					}
				}
				if(initialKey.startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					out = initialKey.toString().replaceAll(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX, "");
					out = out.substring(0, out.indexOf("."));
				}
			}
			return out;
		}
	}


	/**
	 * The Class KeyContentProvider.
	 */
	protected class KeyContentProvider implements IStructuredContentProvider {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			ArrayList<String> result = new ArrayList<String>();
			for(int i = 0; i < keys.length; i++) {
				if(keys[i].startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					result.add(keys[i]);
				}
				if(keys[i].startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
					result.add(keys[i]);
				}
			}
			return result.toArray();
		}

	}

}
