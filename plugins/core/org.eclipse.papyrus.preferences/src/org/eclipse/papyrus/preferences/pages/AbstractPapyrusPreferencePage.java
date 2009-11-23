/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.pages;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.papyrus.preferences.ui.AbstractGroupComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

/**
 * An abstract implementation of a Preference page.
 * 
 * This preference page allows clients to define preference page in the preference of Eclipse, and
 * in the properties of a project in the workspace.
 * <p>
 * Clients must implement :
 * <ul>
 * <li><code>getBundleId()</code> method in order to define the preference scope (Project or
 * Instance) of the preference page.</li>
 * <li><code>createPageContents()</code> method to populate the preference page with the different
 * field editor. </br>Each field added has to be declared through the
 * <code>addEditorFields(FieldEditor fe)</code> method</li>
 * </ul>
 * </p>
 */
public abstract class AbstractPapyrusPreferencePage extends PreferencePage implements IWorkbenchPreferencePage,
		IWorkbenchPropertyPage {

	private IProject project;

	private Set<AbstractGroupComposite> fieldsEditor;

	/**
	 * @see org.eclipse.ui.IWorkbenchPropertyPage#getElement()
	 */
	public IAdaptable getElement() {
		return project;
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPropertyPage#setElement(org.eclipse.core.runtime.IAdaptable)
	 */
	public void setElement(IAdaptable element) {
		project = (IProject) element.getAdapter(IResource.class);
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#doGetPreferenceStore()
	 */
	protected IPreferenceStore doGetPreferenceStore() {
		IPreferenceStore store;
		if (project != null) {
			store = new ScopedPreferenceStore(new ProjectScope(project), getBundleId());
		} else {
			store = new ScopedPreferenceStore(new InstanceScope(), getBundleId());
		}
		return store;
	}

	/**
	 * Initializes this preference page for the given workbench.
	 * 
	 * @param workbench
	 *            the workbench
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 * 
	 */
	public void init(IWorkbench workbench) {
		// Do nothing
	}

	/**
	 * Create the Papyrus preference page and inits the different fields editor contained in the
	 * page.
	 * <p>
	 * This method shouldn't be overriden by sub-classes
	 * </p> {@inheritDoc}
	 */
	@Override
	protected Control createContents(Composite parent) {
		// Create the container composite
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout containerLayout = new GridLayout();
		container.setLayout(containerLayout);

		createPageContents(container);

		initFieldsEditor();

		return container;
	}

	/**
	 * Populate the preference page with the different field editor.
	 * <p>
	 * Each field added has to be declared through the <code>addEditorFields(FieldEditor fe)</code>
	 * method
	 * </p>
	 * 
	 * @param parent
	 *            the parent composite
	 */
	protected abstract void createPageContents(Composite parent);

	/**
	 * Add the given field editor to the page.
	 */
	protected void addAbstractGroupComposite(AbstractGroupComposite fe) {
		if (fieldsEditor == null) {
			fieldsEditor = new HashSet<AbstractGroupComposite>();
		}
		fieldsEditor.add(fe);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.IPreferencePage#performOk()
	 */
	@Override
	public boolean performOk() {
		storePreferences();
		return super.performOk();
	}

	/**
	 * Stores the values of the fields contained in this page into the preference store.
	 */
	private void storePreferences() {
		if (fieldsEditor != null) {
			for (AbstractGroupComposite fe : fieldsEditor) {
				fe.storePreferences();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 */
	protected void performDefaults() {
		loadDefaultPreferences();
		super.performDefaults();
	}

	/**
	 * Load the default preferences of the fields contained in this page
	 */
	private void loadDefaultPreferences() {
		if (fieldsEditor != null) {
			for (AbstractGroupComposite fe : fieldsEditor) {
				fe.loadDefault();
			}
		}

	}

	/**
	 * Init the fields contained in this page.
	 */
	private void initFieldsEditor() {
		if (fieldsEditor != null) {
			for (AbstractGroupComposite fe : fieldsEditor) {
				fe.setPreferenceStore(getPreferenceStore());
				fe.load();
			}
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		if (fieldsEditor != null) {
			for (AbstractGroupComposite fe : fieldsEditor) {
				fe.dispose();
			}
		}

	}

	/**
	 * The bundle ID used to defined the preference store
	 * 
	 * @return String
	 */
	protected abstract String getBundleId();

}
