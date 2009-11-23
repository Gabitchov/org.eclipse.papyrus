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

import org.eclipse.papyrus.preferences.ui.BackgroundColor;
import org.eclipse.papyrus.preferences.ui.NodeColorGroup;
import org.eclipse.swt.widgets.Composite;

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
		NodeColorGroup colorGroupForNodeComposite = new NodeColorGroup(parent, getTitle(), this);
		addAbstractGroup(colorGroupForNodeComposite);
		BackgroundColor backgroundColorGroup = new BackgroundColor(parent, getTitle(), this);
		addAbstractGroup(backgroundColorGroup);
	}

}
