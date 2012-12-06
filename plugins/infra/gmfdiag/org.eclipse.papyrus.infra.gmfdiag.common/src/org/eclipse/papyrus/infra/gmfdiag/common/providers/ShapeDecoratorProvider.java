/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Provides the decorator for the shape, based on the shape service
 */
public class ShapeDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	/** The key used for the mood decoration */
	public static final String SHAPE_DECORATOR = "ShapeDecorator"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		View node = ShapeDecorator.getDecoratorTargetNode(decoratorTarget);
		if(node != null) {
			decoratorTarget.installDecorator(SHAPE_DECORATOR, new ShapeDecorator(decoratorTarget));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		Assert.isNotNull(operation);

		if(!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}

		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation)operation).getDecoratorTarget();
		return ShapeDecorator.getDecoratorTargetNode(decoratorTarget) != null;
	}

}
