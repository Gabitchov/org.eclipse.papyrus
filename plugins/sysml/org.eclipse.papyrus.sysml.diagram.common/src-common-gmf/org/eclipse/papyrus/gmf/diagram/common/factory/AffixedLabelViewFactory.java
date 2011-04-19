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
package org.eclipse.papyrus.gmf.diagram.common.factory;

import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationFactory;

/**
 * Default view Factory for Papyrus custom affixed labels.
 */
public class AffixedLabelViewFactory extends AbstractLabelViewFactory {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected LayoutConstraint createLayoutConstraint() {
		Location location = NotationFactory.eINSTANCE.createLocation();
		location.setX(0);
		location.setY(40);
		return location;
	}
}
