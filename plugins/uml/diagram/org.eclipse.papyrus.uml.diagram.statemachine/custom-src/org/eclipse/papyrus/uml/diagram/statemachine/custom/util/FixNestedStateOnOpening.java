/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.statemachine.custom.util;

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;

/**
 * This class fixes bug 401059, i.e. it removes obsolete compartments from states
 */
public class FixNestedStateOnOpening {

	// two now obsolete compartments that can be found in state-diagrams created with the 0.8.X version of Papyrus
	public static final String COMPARTMENT_6003 = "6003";

	public static final String COMPARTMENT_6004 = "6004";


	/**
	 * This method fixes bug 401059
	 * 
	 * @param diagram
	 *        the diagram
	 */
	public void fix(Diagram diagram) {

		final String SEP_ID = "" + StateEditPart.VISUAL_ID;

		// Parse diagram content
		Iterator<EObject> it = diagram.eAllContents();
		while(it.hasNext()) {
			EObject current = it.next();

			// Select only shapes
			if(!(current instanceof Shape)) {
				continue;
			}

			String currentType = ((Shape)current).getType();
			if(SEP_ID.equals(currentType)) {

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
			super(domain, "remove obsolete compartments from state");
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
}
