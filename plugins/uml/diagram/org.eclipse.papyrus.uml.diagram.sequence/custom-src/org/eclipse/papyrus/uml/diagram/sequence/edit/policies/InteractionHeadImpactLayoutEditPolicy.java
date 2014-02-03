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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.StereotypeInteractionFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class InteractionHeadImpactLayoutEditPolicy extends AbstractHeadImpactLayoutEditPolicy {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AbstractHeadImpactLayoutEditPolicy#getHeadHeight()
	 * 
	 * @return
	 */
	@Override
	protected int getHeadHeight() {
		IFigure primaryShape = getPrimaryShape();
		if(primaryShape instanceof StereotypeInteractionFigure) {
			IFigure headContainer = ((StereotypeInteractionFigure)primaryShape).getHeaderLabel().getParent();
			Rectangle boundsRect = getBoundsRect();
			return headContainer.getPreferredSize(boundsRect.width, -1).height;
		}
		return 0;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AbstractHeadImpactLayoutEditPolicy#doImpactLayout(int)
	 * 
	 * @param resizeDelta
	 */

	@Override
	protected void doImpactLayout(int resizeDelta) {
		CompoundCommand commands = new CompoundCommand();
		//1. move gate
		{
			List children = getHost().getChildren();
			List<GateEditPart> gates = new ArrayList<GateEditPart>();
			for(Object object : children) {
				if(object instanceof GateEditPart) {
					gates.add((GateEditPart)object);
				}
			}
			if(!gates.isEmpty()) {
				Rectangle rect = getBoundsRect();
				for(GateEditPart gateEditPart : gates) {
					Node view = (Node)gateEditPart.getNotationView();
					Location location = (Location)view.getLayoutConstraint();
					Point pt = new Point(location.getX(), location.getY());
					if(pt.x == rect.x - GateEditPart.DEFAULT_SIZE.width / 2 || pt.x == rect.right() - GateEditPart.DEFAULT_SIZE.width / 2) {
						commands.appendIfCanExecute(new GMFtoEMFCommandWrapper(new SetBoundsCommand(getEditingDomain(), "Move gate", gateEditPart, pt.getTranslated(0, resizeDelta))));
					}
				}
			}
		}
		//2. move FoundMessage
		{
			List sourceConnections = ((NodeEditPart)getHost()).getSourceConnections();
			for(Object object : sourceConnections) {
				if(object instanceof Message7EditPart) {
					Edge edge = (Edge)((Message7EditPart)object).getNotationView();
					Anchor sourceAnchor = edge.getSourceAnchor();
					if(sourceAnchor instanceof IdentityAnchor) {
						String terminal = ((IdentityAnchor)sourceAnchor).getId();
						PrecisionPoint pt = SlidableAnchor.parseTerminalString(terminal);
						if(pt.preciseY() > 1) {
							pt.translate(0, resizeDelta);
							commands.appendIfCanExecute(SetCommand.create(getEditingDomain(), sourceAnchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), "(" + pt.preciseX() + "," + pt.preciseY() + ")"));
						}
					}
				}
			}
		}
		//3. Move LostMessage
		{
			List targetConnections = ((NodeEditPart)getHost()).getTargetConnections();
			for(Object object : targetConnections) {
				if(object instanceof Message6EditPart) {
					AbstractMessageEditPart message = (AbstractMessageEditPart)object;
					Edge edge = (Edge)message.getNotationView();
					Anchor targetAnchor = edge.getTargetAnchor();
					if(targetAnchor instanceof IdentityAnchor) {
						String terminal = ((IdentityAnchor)targetAnchor).getId();
						PrecisionPoint pt = SlidableAnchor.parseTerminalString(terminal);
						if(pt.preciseY() > 1) {
							pt.translate(0, resizeDelta);
							commands.appendIfCanExecute(SetCommand.create(getEditingDomain(), targetAnchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), "(" + pt.preciseX() + "," + pt.preciseY() + ")"));
						}
					}
				}
			}
		}
		if(commands.isEmpty() || !commands.canExecute()) {
			return;
		}
		CommandHelper.executeCommandWithoutHistory(getEditingDomain(), commands, true);
	}

}
