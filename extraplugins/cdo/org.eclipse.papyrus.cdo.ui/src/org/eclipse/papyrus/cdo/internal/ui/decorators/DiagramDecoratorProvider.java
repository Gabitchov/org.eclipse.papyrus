/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.decorators;

import org.eclipse.emf.cdo.dawn.appearance.DawnElementStylizer;
import org.eclipse.emf.cdo.dawn.ui.stylizer.DawnElementStylizerRegistry;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;

/**
 * This is the DiagramDecoratorProvider type. Enjoy.
 */
public class DiagramDecoratorProvider
		extends AbstractProvider
		implements IDecoratorProvider {

	public DiagramDecoratorProvider() {
		super();
	}

	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation)
			.getDecoratorTarget();
		EditPart editPart = (EditPart) decoratorTarget
			.getAdapter(EditPart.class);
		return editPart instanceof IPapyrusEditPart;
	}

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget
			.getAdapter(EditPart.class);

		DawnElementStylizer stylizer = DawnElementStylizerRegistry.instance
			.getStylizer(editPart);
		if (stylizer != null) {
			decoratorTarget.installDecorator("cdoState", new CDOStateDiagramDecorator( //$NON-NLS-1$
				decoratorTarget, stylizer));
		}
	}

}
