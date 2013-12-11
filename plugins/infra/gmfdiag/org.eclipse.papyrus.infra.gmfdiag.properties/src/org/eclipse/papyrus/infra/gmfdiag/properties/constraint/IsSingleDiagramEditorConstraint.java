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
package org.eclipse.papyrus.infra.gmfdiag.properties.constraint;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.constraints.constraints.JavaQuery;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;

/**
 * 
 * A constraint to know if we are able to get a diagram editor from the selection
 * 
 */
public class IsSingleDiagramEditorConstraint implements JavaQuery {


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.constraints.constraints.JavaQuery#match(java.lang.Object)
	 * 
	 * @param selection
	 * @return
	 */
	public boolean match(Object selection) {
		if(selection instanceof EditPart) {
			return DiagramEditPartsUtil.getDiagramWorkspacePreferenceStore((EditPart)selection) != null;
		}
		return false;
	}

}
