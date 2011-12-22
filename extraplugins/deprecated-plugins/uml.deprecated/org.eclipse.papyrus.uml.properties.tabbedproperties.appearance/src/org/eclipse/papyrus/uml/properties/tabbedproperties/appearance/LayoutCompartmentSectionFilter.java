/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CompartmentFigure;

/**
 * Filter for the {@link MaskManagedLabelSection} section
 */
public class LayoutCompartmentSectionFilter implements IFilter {

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object object) {
		if(object instanceof IGraphicalEditPart && (!(object instanceof DiagramEditPart))) {
			if(((IGraphicalEditPart)object).getFigure().getChildren().size() > 0) {
				IFigure fig = (IFigure)(((IGraphicalEditPart)object).getFigure().getChildren().get(0));
				if(fig.getChildren().size() > 0) {
					IFigure primaryfig = (IFigure)(fig.getChildren().get(0));
					if(primaryfig instanceof CompartmentFigure) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
