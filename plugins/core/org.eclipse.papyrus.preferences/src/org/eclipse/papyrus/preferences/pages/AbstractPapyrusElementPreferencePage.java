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

import org.eclipse.gmf.runtime.diagram.ui.properties.internal.l10n.DiagramUIPropertiesImages;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.jface.preference.FontFieldEditor;
import org.eclipse.papyrus.preferences.ui.FontGroupComposite;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;

/**
 * An abstract implementation of a Papyrus Preference Page.
 * <p>
 * This class create the default editorFields used in a Papyrus preference page.
 * </p>
 * <ul>
 * The following editor fields are initialized :
 * <li>{@link org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor}
 * <em>ColorFieldEditor</em></li>
 * <li>{@link org.eclipse.papyrus.preferences.jface.preference.FontFieldEditor}
 * <em>FontFieldEditor</em></li>
 * </ul>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusElementPreferencePage extends AbstractPapyrusPreferencePage {


	private Group toolbar;


	protected Layout getToolbarLayout() {
		return new GridLayout(2, false);
	}

	protected Composite getEncapsulatedCompo(Composite parent) {
		Composite compo = new Composite(parent, SWT.NONE);
		compo.setLayout(new GridLayout());
		return compo;
	}


	@Override
	protected void createPageContents(Composite parent) {
		FontGroupComposite fontGroupComposite= new FontGroupComposite(parent, getTitle(), this);
		addAbstractGroupComposite(fontGroupComposite);
		

	}

	protected Group getToolbar() {
		return toolbar;
	}

	/**
	 * Get the specified preference type associated with this preference page.
	 * 
	 * @param preferenceType
	 *            an int representing the preference type to retrieve. It must be a value defined in
	 *            {@link PreferenceConstantHelper}
	 * @return the preference constant used to store the given prefence type.
	 */
	protected String getPreferenceConstant(int preferenceType) {
		return PreferenceConstantHelper.getElementConstant(getTitle(), preferenceType);
	}

}
