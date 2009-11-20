/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.preferences.ui;

import java.util.Set;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.jface.preference.GradientFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;


public abstract class AbstractGroupComposite extends Composite{
	
	protected String title;
	protected Set<AbstractGroupComposite> manager;
	
	/**
	 * @return the dialogPage
	 */
	protected DialogPage getDialogPage() {
		return dialogPage;
	}
	protected IPreferenceStore preferenceStore;
	protected  DialogPage dialogPage;

	
	/**
	 * @return the preferenceStore
	 */
	public IPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}

	
	/**
	 * @param preferenceStore the preferenceStore to set
	 */
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		this.preferenceStore = preferenceStore;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	protected void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Instantiates a new background color group.
	 * 
	 * @param parent the parent
	 * @param String the title of the page
	 * @param dialogPage  to set the page in field editor
	 */
	public AbstractGroupComposite(Composite parent, String title, DialogPage dialogPage) {
		super(parent, SWT.None);
		this.title=title;
		this.dialogPage= dialogPage;
		this.setLayout(new GridLayout());
	}

	/**
	 * Get the specified preference type associated with this preference page.
	 * 
	 * @param preferenceType an int representing the preference type to retrieve. It must be a value defined in
	 * {@link PreferenceConstantHelper}
	 * 
	 * @return the preference constant used to store the given preference type.
	 */
	protected String getPreferenceConstant(int preferenceType) {
		return PreferenceConstantHelper.getElementConstant(title, preferenceType);
	}
	
	protected Composite getEncapsulatedCompo(Composite parent) {
		Composite compo = new Composite(parent, SWT.NONE);
		compo.setLayout(new GridLayout());
		return compo;
	}
	/**
	 * load preferences
	 */
	public abstract void load();
	
	/**
	 * load preferences
	 */
	public abstract void loadDefault();
	/**
	 * store preferences
	 */
	public abstract void storePreferences();
	
	
}
