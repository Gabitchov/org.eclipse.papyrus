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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure;

/**
 * This edit policy displays only icon of applied stereotypes if its exists *.
 * In order to use it, the edit part has to be {@link IPapyrusEditPart} and the
 * associated figure has to be {@link IPapyrusUMLElementFigure}
 */
public class AppliedStereotypeIconlDisplayEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		if(getHost() instanceof IPapyrusEditPart) {
			IFigure figure = ((IPapyrusEditPart)getHost()).getPrimaryShape();

			if(figure instanceof IPapyrusUMLElementFigure) {
				((IPapyrusUMLElementFigure)figure).setStereotypeDisplay(null, stereotypeIconToDisplay());
			}
		}
	}
}
