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
package org.eclipse.papyrus.uml.diagram.common.service;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * 
 * Provide the decorator for the Inheritance
 * 
 * @deprecated Replaced with the generic org.eclipse.papyrus.infra.gmfdiag.common.decoration.ExternalReferenceMarker
 */
@Deprecated
public class InheritedDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	/** The key used for the mood decoration */
	public static final String GENERALIZATION = "Generalization"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider#createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget)
	 * 
	 * @param decoratorTarget
	 */
	@Override
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		Node node = InheritedDecorator.getDecoratorTargetNode(decoratorTarget);
		if(node != null) {
			decoratorTarget.installDecorator(GENERALIZATION, new InheritedDecorator(decoratorTarget));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.common.core.internal.service.IProvider#provides
	 * (org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	@Override
	public boolean provides(IOperation operation) {
		Assert.isNotNull(operation);

		if(!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}

		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation)operation).getDecoratorTarget();
		return InheritedDecorator.getDecoratorTargetNode(decoratorTarget) != null;
	}

}
