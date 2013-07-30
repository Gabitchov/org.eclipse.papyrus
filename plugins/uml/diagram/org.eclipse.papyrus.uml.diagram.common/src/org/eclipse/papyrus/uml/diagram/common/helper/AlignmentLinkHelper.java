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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.tools.ToolUtilities;
import org.eclipse.papyrus.uml.diagram.common.layout.EditPartRepresentation;
import org.eclipse.papyrus.uml.diagram.common.layout.SameAlignment;

/**
 * This class provides a custom method to do an align action using links and not
 * nodes. This action moves node to set the selected link vertically or
 * horizontally. The anchor connection don't move on the node.
 * 
 */
public class AlignmentLinkHelper {

	/** the alignment */
	private int alignment;

	/** the selected editparts */
	private List<?> linkEditparts;

	/** the families of editparts */
	private List<SameAlignment> families = new ArrayList<SameAlignment>();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editparts
	 *        the selected editpart for the alignment action
	 * @param alignment
	 *        the alignment
	 */
	public AlignmentLinkHelper(List<?> editparts, int alignment) {
		this.linkEditparts = editparts;
		this.alignment = alignment;
	}

	/**
	 * Returns the command for this link representation
	 * 
	 * @return <ul>
	 *         <li>the command for this link representation</li>
	 *         <li> {@linkplain UnexecutableCommand#INSTANCE} if the alignment is {@linkplain PositionConstants#MIDDLE} or
	 *         {@linkplain PositionConstants#CENTER}</li>
	 *         </ul>
	 */
	public Command createCommand() {
		if(this.alignment == PositionConstants.MIDDLE || this.alignment == PositionConstants.CENTER || this.linkEditparts.size() == 0) {
			return UnexecutableCommand.INSTANCE;
		}
		organizeSelection();
		if(isAncestorSelected()) {
			return UnexecutableCommand.INSTANCE;
		}
		return getCommand();
	}

	/**
	 * Tests if a parent and one of these children are selected
	 * 
	 * @return <ul>
	 *         <li>{@code true}</li>if a parent and one of these children are selected
	 *         <li>{@code false}</li>if not
	 *         </ul>
	 * 
	 */
	protected boolean isAncestorSelected() {
		List<EditPart> nodesEditPart = new ArrayList<EditPart>();
		// get all the sources and target for the selected links
		for(Object currentEP : linkEditparts) {
			EditPart source = ((AbstractConnectionEditPart)currentEP).getSource();
			EditPart target = ((AbstractConnectionEditPart)currentEP).getTarget();
			nodesEditPart.add(source);
			nodesEditPart.add(target);
		}
		// test if a selected editpart is included another selected editpart
		for(EditPart ep : nodesEditPart) {
			if(ToolUtilities.isAncestorContainedIn(nodesEditPart, ep)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Builds and returns the command for this link representation
	 * 
	 * @return the command for this link representation
	 */
	protected Command getCommand() {
		CompoundCommand cmd = new CompoundCommand("Command for alignment by links"); //$NON-NLS-1$
		Command tmp;
		for(SameAlignment currentFamily : families) {
			tmp = currentFamily.getCommand();
			if(tmp != null && tmp.canExecute()) {
				cmd.add(tmp);
			}
		}
		return cmd;

	}

	/**
	 * This function organizes the selection following the links : all selected
	 * links which share nodes are owned by the same {@linkplain SameAlignment}.
	 */
	protected void organizeSelection() {
		for(Object currentEP : this.linkEditparts) {
			// get the editPart source and target for the link
			EditPart source = ((AbstractConnectionEditPart)currentEP).getSource();
			EditPart target = ((AbstractConnectionEditPart)currentEP).getTarget();

			SameAlignment familySource = null;
			SameAlignment familyTarget = null;

			EditPartRepresentation sourceRep = null;
			EditPartRepresentation targetRep = null;
			// we look for a representation of these source and target
			for(SameAlignment family : families) {
				if(family.getEditPartRepresentationFor(source) != null) {
					sourceRep = family.getEditPartRepresentationFor(source);
				}
				if(family.getEditPartRepresentationFor(target) != null) {
					targetRep = family.getEditPartRepresentationFor(target);
				}
				if(sourceRep != null) {
					familySource = family;
				}
				if(targetRep != null) {
					familyTarget = family;
				}
			}

			/*
			 * if source and target representation exist, we keep the source
			 * representation, and we add it the element containing by the
			 * target representation
			 */
			if(familySource != null && familyTarget != null) {
				familySource.addFamily(familyTarget);
				families.remove(familyTarget);
			} else if(familySource != null) {// a source representation exists
												// yet, we add it this link
				familySource.addTriplet((EditPart)currentEP, sourceRep, new EditPartRepresentation(target));
			} else if(familyTarget != null) {// a target representation exists
												// yet, we add it this link
				familyTarget.addTriplet((EditPart)currentEP, new EditPartRepresentation(source), targetRep);
			} else {// nothing exists, we create a new link representation
				SameAlignment newFamily = new SameAlignment(this.alignment);
				newFamily.addTriplet((EditPart)currentEP, new EditPartRepresentation(source), new EditPartRepresentation(target));
				families.add(newFamily);
			}
		}
	}

}
