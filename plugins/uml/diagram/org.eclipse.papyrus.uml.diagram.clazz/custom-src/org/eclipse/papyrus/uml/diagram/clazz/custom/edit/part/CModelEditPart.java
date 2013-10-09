/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageNodePlateFigure;

/**
 * this a specific editpart used to overload the method createNodePlate
 */
public class CModelEditPart extends ModelEditPartTN {

	protected static final String ICONS_PATH = "icons/Triangle.gif"; //$NON-NLS-1$

	public CModelEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new PackageNodePlateFigure(200, 100);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	protected IFigure createNodeShape() {
		primaryShape = new PackageFigure();
		((PackageFigure)primaryShape).setTagIcon(Activator.getPluginIconImage(Activator.ID, ICONS_PATH));
		return primaryShape;
	}
}
