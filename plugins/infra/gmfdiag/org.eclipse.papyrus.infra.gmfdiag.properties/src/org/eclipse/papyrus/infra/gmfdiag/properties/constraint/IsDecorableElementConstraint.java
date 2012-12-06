/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
//import org.eclipse.papyrus.infra.gmfdiag.common.providers.ShapeDecorator;


/**
 * Constraint that test if selection can be decorated
 */
public class IsDecorableElementConstraint extends AbstractConstraint {

	/**
	 * {@inheritDoc}
	 */
	public boolean match(Object selection) {
		if(selection instanceof IAdaptable) {
			View node  = (View)((IAdaptable)selection).getAdapter(View.class);
			if(node != null && !(node instanceof Diagram)) {
				DescriptionStyle descStyle = (DescriptionStyle)node.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());
				if(descStyle != null) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean equivalent(Constraint constraint) {
		if(constraint == null) {
			return false;
		}

		return constraint instanceof IsDecorableElementConstraint;
	}
}
