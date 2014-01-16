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

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;
import org.eclipse.papyrus.infra.gmfdiag.preferences.messages.Messages;
import org.eclipse.papyrus.infra.tools.preferences.ui.dialog.AbstractApplyValueOnPreferenceKeyDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * The Class ApplyValueOnPreferenceKeyDialog display all the preference key and give all selected keys
 */
public class ApplyValueOnPreferenceKeyDialog extends AbstractApplyValueOnPreferenceKeyDialog {

	public ApplyValueOnPreferenceKeyDialog(String[] keys) {
		super(keys);
	}

	/**
	 *
	 */
	@Override
	protected IBaseLabelProvider createLabelProvider() {
		return new KeyLabelProvider();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.tools.preferences.ui.dialog.AbstractPreferenceKeyDialog#createContentProvider()
	 * 
	 * @return
	 */
	@Override
	protected IContentProvider createContentProvider() {
		return new KeyContentProvider();
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
			//nothing to do
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableColorProvider#getBackground(java.lang.Object, int)
		 */
		public Color getBackground(Object element, int columnIndex) {
			//nothing to do
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
					return Activator.getPluginIconImage(Activator.PLUGIN_ID, "/icons/pref.gif"); //$NON-NLS-1$
				}
				if(element.toString().startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					return Activator.getPluginIconImage(Activator.PLUGIN_ID, "/icons/diag.gif"); //$NON-NLS-1$
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
				out = out.substring(out.indexOf(".") + 1, out.length()).toUpperCase(); //$NON-NLS-1$
			}
			if(columnIndex == 1) {
				if(element.toString().startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
					return Messages.ApplyValueOnPreferenceKeyDialog_ELEMENT;
				}
				if(element.toString().startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					return Messages.ApplyValueOnPreferenceKeyDialog_DIAGRAM;
				}
			}
			if(columnIndex == 2) {
				if(initialKey.startsWith(PreferencesConstantsHelper.DIAGRAM_ELEMENT)) {
					out = initialKey.toString().replaceAll(PreferencesConstantsHelper.DIAGRAM_ELEMENT, ""); //$NON-NLS-1$
					// Reorganize display
					if(out.indexOf(".") > 0) { //$NON-NLS-1$
						String beforePoint = out.substring(0, out.indexOf(".")); //$NON-NLS-1$
						if(beforePoint.lastIndexOf("_") > 0) { //$NON-NLS-1$
							out = out.substring(beforePoint.lastIndexOf("_") + 1, out.indexOf(".")) + " (" + beforePoint.substring(0, beforePoint.lastIndexOf("_")) + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
						}
					}
				}
				if(initialKey.startsWith(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX)) {
					out = initialKey.toString().replaceAll(PreferencesConstantsHelper.DIAGRAM_PREFERENCE_PREFIX, ""); //$NON-NLS-1$
					out = out.substring(0, out.indexOf(".")); //$NON-NLS-1$
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
