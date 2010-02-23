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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.edit.parts;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.node.PackageNodePlateFigure;
import org.eclipse.papyrus.diagram.profile.edit.parts.ModelEditPartCN;

/**
 * this a specific editpart used to overload the method createNodePlate
 */
public class CustomModelEditPartCN extends ModelEditPartCN {

	public CustomModelEditPartCN(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected NodeFigure createNodePlate() {

		DefaultSizeNodeFigure result = new PackageNodePlateFigure(200, 100);
		return result;
	}
}
