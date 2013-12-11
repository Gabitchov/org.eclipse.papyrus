/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui.diagram;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.RulersAndGridGroup;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author vl222926
 * 
 */
public class DiagramRulersAndGridGroup extends RulersAndGridGroup {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param key
	 * @param dialogPage
	 */
	public DiagramRulersAndGridGroup(Composite parent, String key, DialogPage dialogPage) {
		super(parent, key, dialogPage);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.preferences.ui.RulersAndGridGroup#getPreferenceConstant(int)
	 * 
	 * @param preferenceType
	 * @return
	 */
	protected String getPreferenceConstant(int preferenceType) {
		return PreferencesConstantsHelper.getDiagramConstant(getKey(), preferenceType);
	}

}
