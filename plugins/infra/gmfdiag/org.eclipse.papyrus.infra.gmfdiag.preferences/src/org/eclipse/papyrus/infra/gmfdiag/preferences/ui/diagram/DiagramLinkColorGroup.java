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
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.LinkColorGroup;
import org.eclipse.swt.widgets.Composite;

/**
 * The Class DiagramLinkColorGroup specialized at the diagram level
 */
public class DiagramLinkColorGroup extends LinkColorGroup {

	/**
	 * Instantiates a new diagram link color group.
	 * 
	 * @param parent
	 *        the parent composite
	 * @param key
	 *        the tkind of the diagram
	 * @param dialogPage
	 *        the dialog page
	 */
	public DiagramLinkColorGroup(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.preferences.ui.AbstractGroup#getPreferenceConstant(int)
	 */
	protected String getPreferenceConstant(int preferenceType) {
		return PreferencesConstantsHelper.getDiagramConstant(getKey(), preferenceType);
	}
}
