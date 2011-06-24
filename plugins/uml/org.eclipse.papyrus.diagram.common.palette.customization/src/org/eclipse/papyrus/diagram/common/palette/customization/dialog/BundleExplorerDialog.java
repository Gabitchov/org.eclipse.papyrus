/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.palette.customization.dialog;

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;


/**
 * This dialog allows user to browse the available plugins and select some
 */
public class BundleExplorerDialog extends FilteredItemsSelectionDialog {

	private static final String DIALOG_SETTINGS = "org.eclipse.papyrus.ui.toolbox.BundleExplorerDialog";

	private IPluginModelBase[] fModels;

	/**
	 * Creates a new BundleExplorerDialog.
	 * 
	 * @param shell
	 *        the parent shell for the dialog
	 * @param multi
	 *        <code>true</code> if multi selection is allowed
	 */
	public BundleExplorerDialog(Shell shell, boolean multi, IPluginModelBase[] models) {
		super(shell, multi);
		setTitle("Plug-in Selection");
		setMessage("Select a Plug-in:");
		fModels = models;
		PDEPlugin.getDefault().getLabelProvider().connect(this);
		setListLabelProvider(PDEPlugin.getDefault().getLabelProvider());
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new PluginSearchItemsFilter();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
		for(int i = 0; i < fModels.length; i++) {
			contentProvider.add(fModels[i], itemsFilter);
			progressMonitor.worked(1);
		}
		progressMonitor.done();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);

		if(settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
		}

		return settings;
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public String getElementName(Object item) {
		if(item instanceof IPluginModelBase) {
			IPluginModelBase model = (IPluginModelBase)item;
			return model.getPluginBase().getId();
		}
		return null;
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected Comparator<?> getItemsComparator() {
		return new PluginSearchComparator();
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return new Status(IStatus.OK, Activator.ID, 0, "", null); //$NON-NLS-1$
	}

	private class PluginSearchItemsFilter extends ItemsFilter {

		public boolean isConsistentItem(Object item) {
			return true;
		}

		public boolean matchItem(Object item) {
			String id = null;
			if(item instanceof IPluginModelBase) {
				IPluginModelBase model = (IPluginModelBase)item;
				id = model.getPluginBase().getId();
			}

			return (matches(id));
		}

		protected boolean matches(String text) {
			String pattern = patternMatcher.getPattern();
			if(pattern.indexOf("*") != 0 & pattern.indexOf("?") != 0 & pattern.indexOf(".") != 0) {//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				pattern = "*" + pattern; //$NON-NLS-1$
				patternMatcher.setPattern(pattern);
			}
			return patternMatcher.matches(text);
		}
	}

	private class PluginSearchComparator implements Comparator {

		public int compare(Object o1, Object o2) {
			int id1 = getId(o1);
			int id2 = getId(o2);

			if(id1 != id2)
				return id1 - id2;
			return compareSimilarObjects(o1, o2);
		}

		private int getId(Object element) {
			if(element instanceof IPluginModelBase) {
				return 100;
			}
			return 0;
		}

		private int compareSimilarObjects(Object o1, Object o2) {
			if(o1 instanceof IPluginModelBase && o2 instanceof IPluginModelBase) {
				IPluginModelBase ipmb1 = (IPluginModelBase)o1;
				IPluginModelBase ipmb2 = (IPluginModelBase)o2;
				return comparePlugins(ipmb1.getPluginBase(), ipmb2.getPluginBase());
			}
			return 0;
		}

		private int comparePlugins(IPluginBase ipmb1, IPluginBase ipmb2) {
			return ipmb1.getId().compareTo(ipmb2.getId());
		}

	}

}
