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
package org.eclipse.papyrus.infra.gmfdiag.preferences.pages;

import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.FontGroup;
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
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference.ColorFieldEditor} <em>ColorFieldEditor</em></li>
 * <li>{@link org.eclipse.papyrus.infra.gmfdiag.preferences.jface.preference.FontFieldEditor} <em>FontFieldEditor</em></li>
 * </ul>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusElementPreferencePage extends AbstractPapyrusPreferencePage {

	private Group toolbar;

	protected Layout getToolbarLayout() {
		return new GridLayout(2, false);
	}

	/**
	 * create a local composite
	 * 
	 * @param parent
	 * @return
	 */
	protected Composite getEncapsulatedCompo(Composite parent) {
		Composite compo = new Composite(parent, SWT.NONE);
		compo.setLayout(new GridLayout());
		return compo;
	}

	@Override
	protected void createPageContents(Composite parent) {
		FontGroup fontGroupComposite = new FontGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(fontGroupComposite);

	}

	protected Group getToolbar() {
		return toolbar;
	}

	/**
	 * Get the specified preference type associated with this preference page.
	 * 
	 * @param preferenceType
	 *        an int representing the preference type to retrieve. It must be a value defined in {@link PreferencesConstantsHelper}
	 * @return the preference constant used to store the given prefence type.
	 */
	protected String getPreferenceConstant(int preferenceType) {
		return PreferencesConstantsHelper.getElementConstant(getTitle(), preferenceType);
	}

}
