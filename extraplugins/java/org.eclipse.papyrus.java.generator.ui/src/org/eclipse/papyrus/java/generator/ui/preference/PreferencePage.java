/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.ui.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.papyrus.java.generator.ui.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main plug-in class. That way, preferences
 * can be accessed directly via the preference store.
 */

public class PreferencePage
		extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public PreferencePage() {
		super(GRID);
	}

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {

		// implements methods of inherits interfaces and abstract class
		addField(new BooleanFieldEditor(
				PreferenceConstants.P_IMPLEMENT_METHODS_OF_INTERFACES_AND_ABSTRACT_CLASS,
				"Implement methods of inherits interfaces and abstract class",
				getFieldEditorParent()));


		//  generate getters setters		
		addField(new BooleanFieldEditor(
				PreferenceConstants.P_GENERATE_GETTERS,
				"Generate getters",
				getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceConstants.P_GENERATE_SETTERS,
				"Generate setters",
				getFieldEditorParent()));

		// filter of package not to generate
		addField(new PackageListEditor(
				PreferenceConstants.P_FILTER_OF_PACKAGE_NOT_TO_GENERATE,
				"Filter of package to not generate",
				getFieldEditorParent()));

		addField(new GenericClassFieldEditor(
				PreferenceConstants.P_GENERIC_CLASS_FOR_MULTIVALUE,
				"Generic class to use for association * ",
				getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Edit your preferences to generate Java classes with papyrus");
	}



}
