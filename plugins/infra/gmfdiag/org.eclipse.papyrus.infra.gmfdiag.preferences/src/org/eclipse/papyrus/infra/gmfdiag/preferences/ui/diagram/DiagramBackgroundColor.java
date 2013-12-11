/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.BackgroundColor;
import org.eclipse.swt.widgets.Composite;

/**
 * this class is a background group specialized for the level diagram
 * 
 */
public class DiagramBackgroundColor extends BackgroundColor {

	/**
	 * constructor
	 * 
	 * @param parent
	 *        the composite patent
	 * @param key
	 *        the preference key the kind of diagram
	 * @param dialogPage
	 */
	public DiagramBackgroundColor(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
	}

	protected String getPreferenceConstant(int preferenceType) {
		return PreferencesConstantsHelper.getDiagramConstant(getKey(), preferenceType);
	}
}
