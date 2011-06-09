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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/


package org.eclipse.papyrus.diagram.profile.custom.helper;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.uml2.uml.Profile;

/**
 * Helper for the diagram
 */
public class DiagramHelper extends ElementHelper {

	/**
	 * This method returns the root profile from a view
	 * 
	 * @param view
	 * @return the root profile
	 */
	static public Profile getTopProfile(View view) {
		Profile prof = null;
		Diagram diagram = view.getDiagram();
		prof = (Profile)diagram.getElement();
		return prof;
	}
}
