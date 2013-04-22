/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation (ansgar.radermacher@cea.fr)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;

/**
 * This class fixes the bounds of an interaction operation within a combined fragment.
 * The bounds have not values, if the model was made with Papyrus 0.8.X, see bug 400460
 */
public class FixInteractionOperandsOnOpening {

	// height of header (e.g. "seg") in combined fragment (TODO: is there a better way to determine this height?)
	public final int TOP_HEIGHT = 20;

	/**
	 * This method fixes the bounds of interaction operands
	 * 
	 * @param diagram
	 *        the diagram
	 */
	public void fix(Diagram diagram) {
		String IAO_ID = "" + InteractionOperandEditPart.VISUAL_ID;
		// Parse diagram content
		Iterator<EObject> it = diagram.eAllContents();
		while(it.hasNext()) {
			EObject current = it.next();
			// Select only shapes
			if(!(current instanceof Shape)) {
				continue;
			}
			String currentType = ((Shape)current).getType();
			if(IAO_ID.equals(currentType)) {
				Shape iaOperandShape = (Shape)current;
				View parentDecoration = ViewUtil.getViewContainer(iaOperandShape);
				if(parentDecoration != null) {
					View parentParentView = ViewUtil.getViewContainer(parentDecoration);
					if(parentParentView instanceof Shape) {
						Shape parentShape = (Shape)parentParentView;
						Bounds iaOperandShapeBounds = (Bounds)iaOperandShape.getLayoutConstraint();
						Bounds parentShapeBounds = (Bounds)parentShape.getLayoutConstraint();
						if((iaOperandShapeBounds.getX() == 0) && (iaOperandShapeBounds.getY() == 0) && (iaOperandShapeBounds.getWidth() == -1)) {
							// distribute operands equally within the combined fragment.
							int size = parentDecoration.getChildren().size();
							int index = parentDecoration.getChildren().indexOf(iaOperandShape);
							int height = (parentShapeBounds.getHeight() - TOP_HEIGHT) / size;
							int y = index * height;
							final Rectangle newBounds = new Rectangle(0, y, parentShapeBounds.getWidth() - 2, height);
							// Fix when current location is not the valid location (only possible if parent size is set)
							TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
							Command fixCommand = new FixLocationCommand(editingDomain, "Fix combined fragment on opening", iaOperandShapeBounds, newBounds);
							editingDomain.getCommandStack().execute(fixCommand);
						}
					}
				}
			}
		}
	}

	/**
	 * This command sets the new bounds
	 */
	public class FixLocationCommand extends RecordingCommand {

		/**
		 * Interaction operand bounds
		 */
		private Bounds iaViewBounds;

		/**
		 * New (corrected) bounds
		 */
		private Rectangle iaViewNewBounds;

		/** Constructor. */
		public FixLocationCommand(TransactionalEditingDomain domain, String label, Bounds iaViewBounds, Rectangle iaViewNewBounds) {
			super(domain, label);
			this.iaViewBounds = iaViewBounds;
			this.iaViewNewBounds = iaViewNewBounds;
		}

		@Override
		protected void doExecute() {
			iaViewBounds.setX(iaViewNewBounds.x());
			iaViewBounds.setY(iaViewNewBounds.y());
			iaViewBounds.setWidth(iaViewNewBounds.width());
			iaViewBounds.setHeight(iaViewNewBounds.height());
		}

		@Override
		public boolean canUndo() {
			return false;
		}
	}
}
