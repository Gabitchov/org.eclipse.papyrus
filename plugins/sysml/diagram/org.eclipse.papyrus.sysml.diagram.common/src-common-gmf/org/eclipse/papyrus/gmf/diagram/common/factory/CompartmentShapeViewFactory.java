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

import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.BasicCompartmentViewFactory;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Default compartment view Factory for custom shape compartments.
 */
public class CompartmentShapeViewFactory extends BasicCompartmentViewFactory {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected List createStyles(View view) {
		List styles = super.createStyles(view);
		styles.add(NotationFactory.eINSTANCE.createTitleStyle());
		return styles;
	}
}
