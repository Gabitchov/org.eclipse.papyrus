/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.locator.SelfMessageLabelLocator;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class SelfMessageHelper {

	private static Location getLocation(LabelEditPart label) {
		if(label == null) {
			return null;
		}
		Object model = label.getModel();
		if(model instanceof Node) {
			LayoutConstraint layoutConstraint = ((Node)model).getLayoutConstraint();
			if(layoutConstraint instanceof Location) {
				return (Location)layoutConstraint;
			}
		}
		return null;
	}

	/**
	 * This method only available for initialized location(x=1, y=-13).
	 */
	public static void updateLabelLocation(LabelEditPart label) {
		if(label == null || !(label.getParent() instanceof AbstractMessageEditPart)) {
			return;
		}
		AbstractMessageEditPart message = (AbstractMessageEditPart)label.getParent();
		if(!isSelfLink(message)) {
			return;
		}
		final Location location = getLocation(label);
		if(location == null) {
			return;
		}
		final Point pt = new Point(location.getX(), location.getY());
		//Initialize value.
		if(pt.x == 1 && pt.y == -13) {
			message.setLayoutConstraint(label, label.getFigure(), new SelfMessageLabelLocator(message.getConnectionFigure(), label.getKeyPoint()));
		}
	}

	public static boolean isSelfLink(AbstractMessageEditPart message) {
		if(message == null) {
			return false;
		}
		LifelineEditPart sourceLifeline = getLifeline(message.getSource());
		LifelineEditPart targetLifeline = getLifeline(message.getTarget());
		return sourceLifeline == null ? targetLifeline == null : sourceLifeline == targetLifeline;
	}

	private static LifelineEditPart getLifeline(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		if(editPart instanceof LifelineEditPart) {
			return (LifelineEditPart)editPart;
		}
		return getLifeline(editPart.getParent());
	}

}
