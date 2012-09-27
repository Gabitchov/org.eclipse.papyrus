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
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.dialog;

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.papyrus.uml.export.messages.Messages;
import org.eclipse.papyrus.uml.export.util.ProfilesLabelProvider;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.uml2.uml.Profile;



/**
 * The Class ProfilesToExportSelectionDialog.
 */
public class ProfilesToExportSelectionDialog extends FilteredItemsSelectionDialog {

	/** all elements that can be selected by the dialog. */
	Object[] totalInput;

	/** The imported profiles label provider. */
	private ProfilesLabelProvider importedProfilesLabelProvider;

	/** ID for this dialog preferences section. */
	protected static final String DIALOG_SETTINGS = Activator.PLUGIN_ID + "dialogs.exportedprofiles"; //$NON-NLS-1$



	/**
	 * Instantiates a new profiles to export selection dialog.
	 * 
	 * @param shell
	 *        the shell
	 * @param multi
	 *        the multi
	 * @param input
	 *        the input
	 * @param title
	 *        the title
	 */
	public ProfilesToExportSelectionDialog(Shell shell, boolean multi, Object[] input, String title) {
		super(shell, multi);
		importedProfilesLabelProvider = new ProfilesLabelProvider();
		setTitle(title);
		setInitialPattern("**"); //$NON-NLS-1$
		setListLabelProvider(importedProfilesLabelProvider);
		this.totalInput = input;

	}

	/**
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#getElementName(java.lang.Object)
	 * 
	 * @param item
	 * @return
	 */

	@Override
	public String getElementName(Object item) {
		if(!(item instanceof Profile)) {
			return null;
		}
		//System.err.println(((Profile)item).getName());

		return ((Profile)item).getName();
	}



	/**
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createExtendedContentArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		//nothing
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 */
	/**
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 * 
	 * @return
	 */

	protected ItemsFilter createFilter() {
		return new ProfileFilter() {
		};
	}

	/**
	 * Filter for extension points.
	 */
	private class ProfileFilter extends ItemsFilter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isConsistentItem(Object item) {
			if(item instanceof Profile) {
				return true;
			}
			return false;
		}

		/**
		 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#matchItem(java.lang.Object)
		 * 
		 * @param item
		 * @return
		 */

		@Override
		public boolean matchItem(Object item) {
			if((item instanceof Profile)) {
				return true;
			}
			return false;
		}


	}

	/**
	 * {@inheritDoc}
	 */
	protected Comparator<Profile> getItemsComparator() {
		Comparator<Profile> comp = new Comparator<Profile>() {

			public int compare(Profile o1, Profile o2) {
				return ((Profile)o1).getName().compareTo(((Profile)o2).getName());
			}
		};
		return comp;
	}

	/**
	 * {@inheritDoc}
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
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang.Object)
	 * 
	 * @param item
	 * @return
	 */

	@Override
	protected IStatus validateItem(Object item) {
		// TODO Auto-generated method stub
		return new Status(IStatus.OK, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 */
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
		if(progressMonitor != null) {
			progressMonitor.beginTask(Messages.ProfilesToExportSelectionDialog_3, totalInput.length);
		}
		for(int i = 0; i < totalInput.length; i++) {
			contentProvider.add(totalInput[i], itemsFilter);
			progressMonitor.worked(1);
		}
		if(progressMonitor != null)
			progressMonitor.done();

	}


}
