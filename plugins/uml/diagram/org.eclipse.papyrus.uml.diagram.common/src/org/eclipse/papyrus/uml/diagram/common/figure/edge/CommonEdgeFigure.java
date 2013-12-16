/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.edge;


import org.eclipse.papyrus.infra.gmfdiag.common.figure.edge.PapyrusEdgeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Activator;

/**
 * 
 * This figure allows to use the Papyrus Preference Store to know if connection point must be drawn or not.
 * This class should be located in oep.infra.gmfdiag.common, but there is a dependency problem with oep.infra.gmfdiag.preferences
 * 
 */
public class CommonEdgeFigure extends PapyrusEdgeFigure {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CommonEdgeFigure() {
		super();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.edge.PapyrusEdgeFigure#getDrawBendpointPreferenceValue()
	 * 
	 * @return
	 */
	@Override
	protected boolean getDrawBendpointPreferenceValue() {
		final String value = PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.DRAW_CONNECTION_POINT);
		return Activator.getDefault().getPreferenceStore().getBoolean(value);
	}
}
