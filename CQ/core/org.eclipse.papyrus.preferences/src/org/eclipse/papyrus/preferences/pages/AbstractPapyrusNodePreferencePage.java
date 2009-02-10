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
import org.eclipse.papyrus.preferences.jface.preference.ColorFieldEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * An abstract implementation of a basic node preference page.
 * <p>
 * This Preference page adds the preference for {@link org.eclipse.gmf.runtime.notation.FillStyle#getFillColor() <em>FillColor</em>}
 * </p>
 * <p>
 * Sub-classes have to implement :
 * <ul>
 * <li><code>getFillColorPreferenceName()<code> to get the preference name (identifier) to use for the fill color</li>
 * </ul>
 * </p>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusNodePreferencePage extends AbstractPapyrusElementPreferencePage {

	private ColorFieldEditor fillColorEditor = null;

	@Override
	protected void createColorsGroup() {
		super.createColorsGroup();

		GridLayout gdLayout = (GridLayout) getToolbar().getLayout();
		gdLayout.numColumns = 3;
		Composite fillColorEditorCompo = getEncapsulatedCompo(getToolbar());
		fillColorEditor = new ColorFieldEditor(getFillColorPreferenceName(), DiagramUIPropertiesImages.get(DiagramUIPropertiesImages.IMG_FILL_COLOR), fillColorEditorCompo);
		addEditorFields(fillColorEditor);
	}

	/**
	 * Get the preference name (identifier) to use for the fill color
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getFillColorPreferenceName();

}
