/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import org.eclipse.draw2d.ConnectionAnchorBase;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;

/**
 * This is an anchor for either a lost or found Message. It floats on a Lifeline, and is not actually attached to
 * anything, because a lost message doesn't have a target, and a found message doesn't have a source. So this anchor
 * gets its relative location from an EAnnotation stored on the Connector.
 */
public class FloatingMessageAnchor extends ConnectionAnchorBase {

	private final ConnectionEditPart connectionEditPart;

	private final Point defaultOffset;

	public FloatingMessageAnchor(final ConnectionEditPart connEditPart, final Point defaultOffset) {
		this.connectionEditPart = connEditPart;
		this.defaultOffset = defaultOffset;
	}

	public Point getReferencePoint() {
		return new Point(0, 0);
	}

	public IFigure getOwner() {
		return null;
	}

	public Point getLocation(final Point reference) {
		final Point point = MessageUtils.getMessageConnectorLocation(this.connectionEditPart);
		if(point != null) {
			return new Point(reference.x + point.x, reference.y + point.y);
		}
		return new Point(reference.x + this.defaultOffset.x, reference.y + this.defaultOffset.y);
	}
}
