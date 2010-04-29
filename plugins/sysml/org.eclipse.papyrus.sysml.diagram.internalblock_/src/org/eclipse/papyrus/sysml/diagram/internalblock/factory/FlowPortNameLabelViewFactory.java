/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractLabelViewFactory;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.InternalBlockDiagramElementTypes;


public class FlowPortNameLabelViewFactory extends AbstractLabelViewFactory {

	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);

		// Set Semantic Hint
		view.setType(InternalBlockDiagramElementTypes.FLOWPORT_IN_NAME_LABEL_HINT);
	}

	@Override
	protected LayoutConstraint createLayoutConstraint() {
		Location location = NotationFactory.eINSTANCE.createLocation();
		location.setX(25);
		location.setY(3);
		return location;
	}
}
