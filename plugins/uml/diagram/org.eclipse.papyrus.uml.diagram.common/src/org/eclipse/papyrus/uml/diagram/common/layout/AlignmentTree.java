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
package org.eclipse.papyrus.uml.diagram.common.layout;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.tools.ToolUtilities;

/**
 * 
 * A special tree for the alignment action
 * 
 */
public class AlignmentTree extends EditPartTree {

	/**
	 * this UDI can be used to serialize this class
	 */
	private static final long serialVersionUID = 3095221342551975246L;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editpart
	 *        the editpart represented by this tree
	 * @param isSelected
	 *        Indicates if the represented editpart is selected or not
	 * 
	 */
	public AlignmentTree(Object editpart, boolean isSelected) {
		super(editpart, isSelected);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editparts
	 *        the editparts used to build the tree
	 */
	public AlignmentTree(List<EditPart> editparts) {
		super(editparts);
	}

	/**
	 * The new position for this element
	 */
	private PrecisionRectangle newPosition = null;

	/**
	 * Gets the new alignment position for the editpart.
	 * 
	 * @return the new alignment position for the editpart
	 */
	public PrecisionRectangle getNewPosition() {
		return newPosition;
	}

	/**
	 * Returns the new bounds of the container
	 * 
	 * @return <ul>
	 *         <li>{@link EditPartTree#diagramRect} if the container is the diagram</li>
	 *         <li>the bounds of the container after the shift</li>
	 *         </ul>
	 */
	public PrecisionRectangle getNewContainerBounds() {
		AlignmentTree treeParent = (AlignmentTree)this.getParent();
		PrecisionRectangle newContainerBounds;

		if(treeParent.getEditPart() != null) {
			Point oldParentLocation = LayoutUtils.getAbsolutePosition(treeParent.getEditPart()).getLocation();
			Point newParentLocation = treeParent.getNewPosition().getLocation();

			// shift between the two positions
			Point shift = newParentLocation.getTranslated(oldParentLocation.getNegated());

			// we want know the final position for the container
			PrecisionRectangle oldContainerBounds = LayoutUtils.getAbsolutePosition(this.getEditPart().getParent());
			newContainerBounds = new PrecisionRectangle(oldContainerBounds);
			newContainerBounds.translate(shift);
		} else {// treeParent is the root of the tree
			EditPart containerEditPart = this.getEditPart().getParent();
			newContainerBounds = LayoutUtils.getAbsolutePosition(containerEditPart);
		}
		return newContainerBounds;
	}

	/**
	 * Returns the absolute position for the editpart in the new container
	 * 
	 * @return the absolute position for the editpart in the new container.
	 *         That's to say the intermediate position, when the container has
	 *         moved, and the editpart hasn't moved
	 */
	public PrecisionRectangle getAbsolutePositionInTheNewContainerPosition() {
		PrecisionRectangle newPosition = new PrecisionRectangle(LayoutUtils.getAbsolutePosition(getEditPart()));
		PrecisionRectangle newContainerPosition = getNewContainerBounds();
		PrecisionRectangle oldContainerPosition = LayoutUtils.getAbsolutePosition(getEditPart().getParent());
		PrecisionRectangle distance = (PrecisionRectangle)newContainerPosition.translate(oldContainerPosition.getLocation().getNegated());
		return (PrecisionRectangle)newPosition.translate(distance.getLocation());
	}

	/**
	 * Sets the alignment position for the editpart
	 * 
	 * @param newPosition
	 *        the new alignment position for the editpart
	 */
	public void setNewPosition(PrecisionRectangle newPosition) {
		this.newPosition = newPosition;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.layout.EditPartTree#createChildrenTree(java.util.List, java.util.List)
	 * 
	 * @param editparts
	 *        the selected editpart
	 * @param parentsList
	 *        parents of editparts which could be interesting to add to the
	 *        tree
	 * @return
	 */
	@Override
	protected EditPartTree createChildrenTree(List<EditPart> editparts, List<EditPart> parentsList) {
		EditPartTree childTree = null;
		for(EditPart editpart : parentsList) {

			/*
			 * the editparts are interesting only if they are selected or if its
			 * parent is selected!
			 */
			if(editparts.contains(editpart) || ((!editparts.contains(editpart)) && ToolUtilities.isAncestorContainedIn(editparts, editpart))) {
				boolean isSelected = editparts.contains(editpart);
				AlignmentTree parentTree = new AlignmentTree(editpart, isSelected);
				if(!isSelected) {
					// this editpart won't move, so we can precise now its
					// position
					parentTree.setNewPosition(LayoutUtils.getAbsolutePosition(editpart));
				}
				if(childTree != null) {
					parentTree.add(childTree);
				}
				childTree = parentTree;
			}
		}
		return childTree;
	}

	/**
	 * Specifies in the tree which editpart in the selected editpart is used
	 * like reference to do the alignment action
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.layout.EditPartTree#postBuildOperations(java.util.List)
	 * 
	 * @param editparts
	 *        the editparts list
	 */
	@Override
	protected void postBuildOperations(List<EditPart> editparts) {
		// the reference for the alignment is the last selected element
		((AlignmentTree)this.getTree(editparts.get(editparts.size() - 1))).setNewPosition(LayoutUtils.getAbsolutePosition(editparts.get(editparts.size() - 1)));

	}

}
