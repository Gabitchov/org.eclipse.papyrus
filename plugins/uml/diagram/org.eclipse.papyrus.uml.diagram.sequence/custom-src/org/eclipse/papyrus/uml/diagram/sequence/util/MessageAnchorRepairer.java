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

import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class MessageAnchorRepairer {

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
