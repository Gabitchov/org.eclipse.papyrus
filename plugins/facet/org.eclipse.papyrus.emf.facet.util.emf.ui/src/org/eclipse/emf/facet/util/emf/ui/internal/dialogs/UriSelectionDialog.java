/**********************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Gabriel Barbier (Mia-Software) - initial API and implementation
 * 		Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 ***********************************************************************************/
package org.eclipse.emf.facet.util.emf.ui.internal.dialogs;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.common.ui.internal.widgets.AnywhereFilterMatcher;
import org.eclipse.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.emf.facet.util.emf.ui.internal.utils.ImageProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * A dialog which displays a list of URIs from the EMF package registry, and
 * allows the user to open one of them.
 * 
 * @author Gabriel Barbier
 */
public class UriSelectionDialog extends ElementListSelectionDialog {

	private static final String DIALOG_SETTINGS = "UriSelectionDialogSettings"; //$NON-NLS-1$
	private String uri = ""; //$NON-NLS-1$

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 */
	public UriSelectionDialog(final Shell parent) {
		super(parent, new LabelProvider());

		setTitle(Messages.DialogUriSelection_title_OpenModelFromEMFRegistry);
		setMessage(Messages.DialogUriSelection_RegisteredEPackages);

		final Set<String> uris = new TreeSet<String>();
		for (final Object name : ((Map<?, ?>) EPackage.Registry.INSTANCE)
				.keySet()) {
			uris.add((name).toString());
		}

		setElements(uris.toArray());
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		this.fFilteredList.setFilterMatcher(new AnywhereFilterMatcher());
		return composite;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#okPressed()
	 */
	@Override
	protected void okPressed() {
		super.okPressed();

		if (getResult().length > 0) {
			this.uri = getResult()[0].toString();
		}
	}

	public String getUriSelected() {
		return this.uri;
	}

	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		shell.setImage(ImageProvider.getInstance().getEmfFacetLogo());
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		IDialogSettings settings = Activator.getPlugin().getDialogSettings();
		IDialogSettings section = settings
				.getSection(UriSelectionDialog.DIALOG_SETTINGS);
		if (section == null) {
			section = settings
					.addNewSection(UriSelectionDialog.DIALOG_SETTINGS);
		}
		return section;
	}
}