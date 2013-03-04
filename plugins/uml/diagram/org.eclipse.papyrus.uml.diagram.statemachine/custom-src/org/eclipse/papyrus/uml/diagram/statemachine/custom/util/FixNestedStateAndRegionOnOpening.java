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
 *          Fix bug 397730 (correct region position) & bug 401059 (remove obsolete compartments from indigo)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.statemachine.custom.util;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;

/**
 * This class fixes two bugs
 * 
 * - bug 401059, i.e. it removes obsolete compartments from states
 * - bug 397730, contents of region is not visible caused by invalid region position
 */
public class FixNestedStateAndRegionOnOpening {

	// two now obsolete compartments that can be found in state-diagrams created with the 0.8.X version of Papyrus
	public static final String COMPARTMENT_6003 = "6003"; //$NON-NLS-1$

	public static final String COMPARTMENT_6004 = "6004"; //$NON-NLS-1$


	/**
	 * This method fixes the bounds of interaction operands
	 * 
	 * @param diagram
	 *        the diagram
	 */
	public void fix(Diagram diagram) {

		final String SEP_ID = "" + StateEditPart.VISUAL_ID; //$NON-NLS-1$

		final String REGION_ID = "" + RegionEditPart.VISUAL_ID; //$NON-NLS-1$

		// Parse diagram content
		Iterator<EObject> it = diagram.eAllContents();
		while(it.hasNext()) {
			EObject current = it.next();

			// Select only nodes
			if(!(current instanceof Node)) {
				continue;
			}

			String currentType = ((View)current).getType();
			if(SEP_ID.equals(currentType)) {

				// for bug 401059
				Shape stateShape = (Shape)current;
				EList<View> removeChilds = new BasicEList<View>();
				for(Object child : stateShape.getChildren()) {
					View childV = (View)child;
					if(childV.getType().equals(COMPARTMENT_6003) || (childV.getType().equals(COMPARTMENT_6004))) {
						removeChilds.add(childV);
					}
				}
				for(View removeChild : removeChilds) {
					// Fix when current location is not the valid location (only possible if parent size is set)
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
					Command fixCommand = new RemoveChildCommand(editingDomain, stateShape, removeChild);

					editingDomain.getCommandStack().execute(fixCommand);
				}
			}
			else if(REGION_ID.equals(currentType)) {

				// for bug 397730
				Node regionNode = (Node)current;
				View parentNode = ViewUtil.getViewContainer(regionNode);
				if(parentNode.getChildren().size() == 1) {
					// don't correct, if multiple regions (in this case, not all coordinates must be 0)

					Bounds regionBounds = (Bounds)regionNode.getLayoutConstraint();
					final Rectangle newBounds = new Rectangle(0, 0, regionBounds.getWidth(), regionBounds.getHeight());

					// stateNode.getChildren();
					// Fix when current location is not the valid location (only possible if parent size is set)
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
					Command fixCommand =
						new FixLocationCommand(editingDomain, "Fix region position on opening", regionBounds, newBounds); //$NON-NLS-1$
					editingDomain.getCommandStack().execute(fixCommand);
				}

			}
		}
	}

	/**
	 * This command removes a child from its parent shape
	 */
	public class RemoveChildCommand extends RecordingCommand {

		/**
		 * Parent
		 */
		private Shape parent;

		/**
		 * Child to remove
		 */
		private View child;

		/** Constructor. */
		public RemoveChildCommand(TransactionalEditingDomain domain, Shape parent, View child) {
			super(domain, "remove obsolete compartments from state"); //$NON-NLS-1$
			this.parent = parent;
			this.child = child;
		}

		@Override
		protected void doExecute() {
			parent.removeChild(child);
		}

		@Override
		public boolean canUndo() {
			return false;
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
