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

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.papyrus.uml.diagram.common.commands.PreserveAnchorsPositionCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class MessageAnchorRepairer {

	public static ICommand createPreserveMessageAnchorsCommand(ShapeNodeEditPart editPart, int heightDelta) {
		if(editPart == null || heightDelta == 0) {
			return null;
		}
		Dimension sizeDelta = new Dimension(0, heightDelta);
		int preserveAxis = PreserveAnchorsPositionCommand.PRESERVE_Y;
		if(editPart instanceof LifelineEditPart) {
			return new CustomLifelineEditPart.PreserveAnchorsPositionCommandEx(editPart, sizeDelta, preserveAxis);
		}
		return new PreserveAnchorsPositionCommand(editPart, sizeDelta, preserveAxis);
	}

	public static ICommand preserveMessageAnchorsCommand(ShapeNodeEditPart editPart, int heightDelta, int direction) {
		if(editPart == null || heightDelta == 0) {
			return null;
		}
		Dimension sizeDelta = new Dimension(0, heightDelta);
		if(editPart instanceof LifelineEditPart) {
			return new CustomLifelineEditPart.PreserveAnchorsPositionCommandEx(editPart, sizeDelta, PreserveAnchorsPositionCommand.PRESERVE_Y, editPart.getFigure(), direction);
		}
		return new PreserveAnchorsPositionCommand(editPart, sizeDelta, PreserveAnchorsPositionCommand.PRESERVE_Y, editPart.getFigure(), direction);
	}

	public static int computeResizeDelta(ShapeNodeEditPart editPart, Rectangle newChildBounds) {
		if(editPart == null || newChildBounds == null) {
			return -1;
		}
		IFigure figure = editPart.getFigure();
		Rectangle rect = figure.getBounds().getCopy();
		if(rect.contains(newChildBounds)) {
			return -1;
		}
		Rectangle result = rect.getUnion(newChildBounds);
		return result.bottom() - rect.bottom();
	}

	/**
	 * Update anchor of linked messages for Lifeline and CombinedFragment.
	 * 
	 * @param newHeight
	 * @param oldHeight
	 */
	public static void repair(NodeEditPart editPart, int oldHeight, int newHeight) {
		if(editPart == null || !(editPart instanceof LifelineEditPart || editPart instanceof CombinedFragmentEditPart)) {
			return;
		}
		Rectangle bounds = ((GraphicalEditPart)editPart).getFigure().getBounds();
		if(oldHeight < 0) {
			oldHeight = bounds.height;
		}
		if(newHeight < 0) {
			newHeight = bounds.height;
		}
		if(oldHeight == newHeight) {
			return;
		}
		EditingDomain editingDomain = ((GraphicalEditPart)editPart).getEditingDomain();
		List sourceConnections = editPart.getSourceConnections();
		for(Object object : sourceConnections) {
			if(!(object instanceof AbstractMessageEditPart)) {
				continue;
			}
			AbstractMessageEditPart conn = (AbstractMessageEditPart)object;
			Edge edge = (Edge)conn.getModel();
			final IdentityAnchor anchor = (IdentityAnchor)edge.getSourceAnchor();
			updateAnchorTerminal(editingDomain, anchor, oldHeight, newHeight);
		}
		List targetConnections = editPart.getTargetConnections();
		for(Object object : targetConnections) {
			if(!(object instanceof AbstractMessageEditPart)) {
				continue;
			}
			AbstractMessageEditPart conn = (AbstractMessageEditPart)object;
			Edge edge = (Edge)conn.getModel();
			final IdentityAnchor anchor = (IdentityAnchor)edge.getTargetAnchor();
			updateAnchorTerminal(editingDomain, anchor, oldHeight, newHeight);
		}
	}

	private static void updateAnchorTerminal(EditingDomain editingDomain, final IdentityAnchor anchor, int oldHeight, int newHeight) {
		final String oldTerminal = anchor.getId();
		PrecisionPoint pp = BaseSlidableAnchor.parseTerminalString(oldTerminal);
		int yPos = (int)Math.round(oldHeight * pp.preciseY());
		pp.setPreciseY((double)yPos / newHeight);
		if(pp.preciseY() > 1.0) {
			pp.setPreciseY(1.0);
		} else if(pp.preciseY() < 0.0) {
			pp.setPreciseY(0.0);
		}
		final String newTerminal = (new BaseSlidableAnchor(null, pp)).getTerminal();
		CommandHelper.executeCommandWithoutHistory(editingDomain, new AbstractCommand("Update Target Anchors") {

			public void redo() {
				execute();
			}

			@Override
			public boolean canUndo() {
				return false;
			}

			public void execute() {
				anchor.setId(newTerminal);
			}

			@Override
			public boolean canExecute() {
				return true;
			}
		}, true);
	}
}
