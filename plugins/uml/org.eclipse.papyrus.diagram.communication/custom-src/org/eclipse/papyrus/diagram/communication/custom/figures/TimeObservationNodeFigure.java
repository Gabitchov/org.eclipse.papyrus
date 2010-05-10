/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Adapted from class diagram
 *****************************************************************************/

package org.eclipse.papyrus.diagram.communication.custom.figures;

import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Figure for TimeObservation
 */
public class TimeObservationNodeFigure extends AbstractObservationNodeFigure {


	private static final String IMAGE_OBSERVATION = "TimeObservation.gif"; //$NON-NLS-1$

	@Override
	public void setAppliedStereotypeIcon(Image image) {
		if(image == null) {
			setIcon(Activator.getPluginIconImage(ID, PATH + IMAGE_OBSERVATION));
		} else {
			setIcon(image);
		}

	}

}
