/**********************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 ***********************************************************************************/
package org.eclipse.emf.facet.common.ui.internal.preference.pages;

import org.eclipse.emf.facet.common.ui.internal.Activator;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class is the EmfFacet root preference page that is contributed to the
 * Preferences dialog. By sub-classing {@link FieldEditorPreferencePage}, we can
 * use the field support built into JFace that allows us to create a page that
 * is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences, that are stored in the preference
 * store that belongs to the main plug-in class. That way, preferences can be
 * accessed directly via the preference store.
 */

public class EmfFacetRootPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public static final String P_DEFAULT_EPACKAGE_VIEWER = "emf_facet_default_epackage_viewer"; //$NON-NLS-1$

	public EmfFacetRootPreferencePage() {
		super(FieldEditorPreferencePage.GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		// The page is empty for now
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(final IWorkbench workbench) {
		// Nothing to do
	}

}