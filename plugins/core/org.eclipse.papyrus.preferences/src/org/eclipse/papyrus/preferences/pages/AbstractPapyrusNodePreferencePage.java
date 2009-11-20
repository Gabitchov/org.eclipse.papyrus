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
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.papyrus.preferences.jface.preference.GradientFieldEditor;
import org.eclipse.papyrus.preferences.ui.BackgroundColorGroup;
import org.eclipse.papyrus.preferences.ui.ColorGroupForNodeComposite;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;

/**
 * An abstract implementation of a basic node preference page.
 * <p>
 * This Preference page adds the preference for
 * {@link org.eclipse.gmf.runtime.notation.FillStyle#getFillColor() <em>FillColor</em>}
 * </p>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusNodePreferencePage extends AbstractPapyrusElementPreferencePage {


	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		ColorGroupForNodeComposite colorGroupForNodeComposite= new ColorGroupForNodeComposite(parent, getTitle(), this);
		addAbstractGroupComposite(colorGroupForNodeComposite);
		BackgroundColorGroup backgroundColorGroup= new BackgroundColorGroup(parent, getTitle(), this);
		addAbstractGroupComposite(backgroundColorGroup);
	}

}
