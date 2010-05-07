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
package org.eclipse.papyrus.diagram.common.layout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.AlignmentRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;



/**
 * This class is used to represent the hierarchy between selected editparts
 * 
 * 
 */
public class EditPartTree extends DefaultMutableTreeNode {

	/**
	 * this UDI can be used to serialize this class
	 */
	private static final long serialVersionUID = 1557787740787257844L;

	/**
	 * Used to precise if this tree is the first selected element in the branch
	 */
	private boolean isFirstSelected = false;

	/**
	 * Used to precise if this tree is the reference of the alignment
	 */
	private boolean isReference = false;

	/**
	 * Indicates if the represented editpart is selected or not
	 */
	private boolean isSelected = false;

	/**
	 * the alignment request for the editpart
	 */
	private AlignmentRequest request;

	/**
	 * The new position for this element
	 */
	private PrecisionRectangle newPosition = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editpart
	 *        the editpart represented by this Tree
	 * @param isSelected
	 *        indicates if the represented editpart is selected or not
	 * 
	 */
	public EditPartTree(Object editpart, boolean isSelected) {
		super(editpart, true);
		this.isSelected = isSelected;

	}

	/**
	 * Gets the alignment request for the editpart.
	 * 
	 * @return the alignment request for the editpart
	 */
	public AlignmentRequest getRequest() {
		return request;
	}

	/**
	 * Sets the alignment request for the editpart.
	 * 
	 * @param request
	 *        the new alignment request for the editpart
	 */
	public void setRequest(AlignmentRequest request) {
		this.request = request;
	}

	/**
	 * Gets the new alignment position for the editpart.
	 * 
	 * @return the new alignment position for the editpart
	 */
	public PrecisionRectangle getNewPosition() {
		return newPosition;
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
	 * Sets the used to precise if this tree is the reference of the alignment.
	 * 
	 * @param isReference
	 *        the new used to precise if this tree is the reference of the alignment
	 */
	public void setIsReference(boolean isReference) {
		this.isReference = true;
	}

	/**
	 * Gets {@link #isReference()}
	 * 
	 * @return
	 *         the {@link #isReference()} value
	 */
	public boolean isReference() {
		return isReference;
	}

	/**
	 * Sets the {@link #isSelected} value
	 * 
	 * @param isSelected
	 *        the new value for {@link #isSelected}
	 */
	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	/**
	 * Gets {@link #isSelected}
	 * 
	 * @return
	 *         the {@link #isSelected} value
	 */
	public boolean isSelected() {
		return isSelected;
	}


	/**
	 * Gets the editpart represented by this tree
	 * 
	 * @return the editpart represented by this tree
	 */
	public EditPart getEditPart() {
		return (EditPart)getUserObject();
	}


	/**
	 * @see javax.swing.tree.DefaultMutableTreeNode#toString()
	 * 
	 * @return
	 *         the string representing the tree with its children
	 */

	public String toString() {
		getLevel();
		String str = ""; //$NON-NLS-1$
		for(int i = 0; i < getLevel(); i++) {
			str += "  "; //$NON-NLS-1$
		}

		str += "isSelected =" + isSelected() + " depth =" + getDepth() + " Node =" + userObject + "\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

		if(children != null) {
			for(int i = 0; i < children.size(); i++) {
				str += children.get(i).toString();
			}
		} else {
			for(int i = 0; i < getLevel() + 2; i++) {
				str += "  "; //$NON-NLS-1$
			}
			str += "No child\n"; //$NON-NLS-1$
		}

		return str;
	}

	/**
	 * Gets the subtree containing the editpart.
	 * 
	 * @param editpart
	 *        the editpart that we look for
	 * @return the tree, or {@code null} if not found
	 */
	public EditPartTree getTree(EditPart editpart) {
		if(this.getEditPart() == editpart) {
			return this;
		}
		if(children != null) {
			for(int i = 0; i < children.size(); i++) {
				EditPart ep = ((EditPartTree)children.get(i)).getEditPart();
				if(ep == editpart) {
					return ((EditPartTree)children.get(i));
				} else {
					EditPartTree ept = ((EditPartTree)children.get(i)).getTree(editpart);
					if(ept != null) {
						return ept;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Contains.
	 * 
	 * @param editpart
	 *        the editpart that we look for
	 * @return
	 *         <ul>
	 *         <li> {@code true}</li> if the tree contains the editpart
	 *         <li> {@code false}</li> if not
	 *         </ul>
	 */
	public boolean contains(EditPart editpart) {
		return (getTree(editpart) == null) ? false : true;
	}

	/**
	 * Gets the child level.
	 * 
	 * @param level
	 *        the level
	 * @return the child level
	 */
	public List<EditPartTree> getChildLevel(int level) {
		List<EditPartTree> epList = new ArrayList<EditPartTree>();
		if(level > 0) {
			if((level == 1 && this.children != null) && this.children.size() != 0) {

				epList.addAll(this.children);

			} else if(children != null) {
				for(int iter = 0; iter < this.children.size(); iter++) {
					epList.addAll(((EditPartTree)this.children.get(iter)).getChildLevel(level - 1));
				}
			}
		}
		return epList;
	}

	/**
	 * Sets the first selected element.
	 * 
	 * @param value
	 *        the new first selected element
	 */
	public void setFirstSelectedElement(boolean value) {
		this.isFirstSelected = value;
	}

	/**
	 * Checks if is first selected element in branch.
	 * 
	 * @return true, if is first selected element in branch
	 */
	public boolean isFirstSelected() {
		return this.isFirstSelected;
	}


	/**
	 * Gets the level for the first selected element in the full tree. This level is calculated from the root of this node.
	 * 
	 * @param index
	 *        the index
	 * @return
	 *         <ul>
	 *         <li>the level for first selected element</li>
	 *         <li> {@code -1}</li> if the first selected element can't be found
	 *         </ul>
	 */
	public int getLevelForFirstSelectedElement() {
		//We search the first level in the tree
		TreeNode[] path = this.getPath();
		if(path.length > 1) {
			EditPartTree result = getSelectedFirstEditPart((EditPartTree)path[1]);
			if(result != null) {
				return result.getLevel();
			}
		}
		return -1;
	}

	/**
	 * Gets the selected first edit part.
	 * 
	 * @param treeNode
	 *        the tree node (level one of a tree) where we search the first selected element
	 * @return the selected first edit part or {@code null} if not found
	 */
	private EditPartTree getSelectedFirstEditPart(EditPartTree treeNode) {
		if(treeNode.isFirstSelected) {
			return treeNode;
		} else if((treeNode.children != null) && (!treeNode.children.isEmpty())) {
			for(int iter = 0; iter < treeNode.getChildCount(); iter++) {
				EditPartTree result = getSelectedFirstEditPart((EditPartTree)treeNode.children.get(iter));
				if(result != null) {
					return result;
				}
			}
		}
		return null;
	}

	/**
	 * Test if this node have child that are not selected
	 * 
	 * @return
	 *         <ul>
	 *         <li>{@code true}</li> it exists a child which is not selected
	 *         <li>{@code false}</li> all the children are selected
	 *         </ul>
	 */
	public boolean existsUnselectedChild() {
		return (getDistanceWithTheFirstUnselectedChild() == -1) ? false : true;
	}

	/**
	 * Returns the distance between the tree and the first unselected child
	 * 
	 * @return
	 *         <ul>
	 *         <li>the distance between this tree and the first unselected child</li>
	 *         <li>  {@code -1} when all the children are selected</li>
	 *         </ul>
	 */
	public int getDistanceWithTheFirstUnselectedChild() {
		int depth = this.getDepth();
		for(int i = 0; i < depth; i++) {
			List<EditPartTree> localChildren = getChildLevel(i);
			for(EditPartTree tree : localChildren) {
				if(!tree.isSelected()) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Returns the first unselected child or {@code null} if all the children are selected
	 * 
	 * @return
	 *         the first unselected child or {@code null} if all the children are selected
	 */
	public EditPartTree getFirstUnselectedChild() {
		int depth = this.getDepth();
		for(int i = 0; i < depth; i++) {
			List<EditPartTree> localChildren = getChildLevel(i);
			for(EditPartTree tree : localChildren) {
				if(!tree.isSelected()) {
					return tree;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the new bounds of the container
	 * 
	 * @return
	 *         <ul>
	 *         <li>{@link EditPartTree#diagramRect} if the container is the diagram</li>
	 *         <li>the bounds of the container after the shift</li>
	 *         </ul>
	 */
	public PrecisionRectangle getNewContainerBounds() {
		EditPartTree treeParent = (EditPartTree)this.getParent();
		PrecisionRectangle newContainerBounds;

		if(treeParent.getEditPart() != null) {
			Point oldParentLocation = LayoutUtils.getAbsolutePosition(treeParent.getEditPart()).getLocation();
			Point newParentLocation = treeParent.getNewPosition().getLocation();

			//shift between the two positions
			Point shift = newParentLocation.getTranslated(oldParentLocation.getNegated());

			// we want know the final position for the container
			PrecisionRectangle oldContainerBounds = LayoutUtils.getAbsolutePosition(this.getEditPart().getParent());
			newContainerBounds = new PrecisionRectangle(oldContainerBounds);
			newContainerBounds.translate(shift);
		} else {//treeParent is the root of the tree
			EditPart containerEditPart = this.getEditPart().getParent();
			if(containerEditPart instanceof CompartmentEditPart) {
				newContainerBounds = LayoutUtils.getAbsolutePosition(containerEditPart);
			} else {//we are on the diagram!!!
				newContainerBounds = LayoutUtils.diagramRect;
			}
		}
		return newContainerBounds;
	}




	/**
	 * Returns the absolute position for the editpart in the new container
	 * 
	 * @return
	 *         the absolute position for the editpart in the new container. That's to say the intermediate position, when the container has moved, and
	 *         the editpart hasn't moved
	 */
	public PrecisionRectangle getAbsolutePositionInTheNewContainerPosition() {
		PrecisionRectangle newPosition = new PrecisionRectangle(LayoutUtils.getAbsolutePosition(getEditPart()));
		PrecisionRectangle newContainerPosition = getNewContainerBounds();
		PrecisionRectangle oldContainerPosition = LayoutUtils.getAbsolutePosition(getEditPart().getParent());
		PrecisionRectangle distance = (PrecisionRectangle)newContainerPosition.translate(oldContainerPosition.getLocation().getNegated());
		return (PrecisionRectangle)newPosition.translate(distance.getLocation());
	}
}
