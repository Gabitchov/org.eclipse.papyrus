/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.notation.constraint;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.properties.constraints.EMFInstanceOfConstraint;


public class GMFNotationConstraint extends EMFInstanceOfConstraint {

	@Override
	public boolean match(Object selection) {
		if(selection instanceof EditPart) {
			EditPart part = (EditPart)selection;
			Object model = part.getModel();
			if(model instanceof View) {
				View view = (View)model;
				return super.match(view);
			}
		}

		return false;
	}

}
