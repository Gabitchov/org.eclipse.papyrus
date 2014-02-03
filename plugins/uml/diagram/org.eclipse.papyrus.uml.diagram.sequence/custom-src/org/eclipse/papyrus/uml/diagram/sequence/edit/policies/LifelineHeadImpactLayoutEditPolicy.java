/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart.CustomLifelineFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineHeadUtil;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineHeadImpactLayoutEditPolicy extends AbstractHeadImpactLayoutEditPolicy {

	@Override
	protected int getHeadHeight() {
		CustomLifelineFigure primaryShape = ((CustomLifelineEditPart)getHost()).getPrimaryShape();
		RectangleFigure figure = primaryShape.getFigureLifelineNameContainerFigure();
		Rectangle r = getBoundsRect();
		Dimension preferredSize = figure.getPreferredSize(r.width, -1);
		return preferredSize.height;
	}

	@Override
	protected void doImpactLayout(int resizeDelta) {
		LifelineHeadUtil.updateHead((LifelineEditPart)getHost(), resizeDelta);
	}

}
