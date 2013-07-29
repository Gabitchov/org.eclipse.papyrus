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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;

/**
 * This class is used to represent the hierarchy between selected editparts
 * 
 * 
 */
public abstract class EditPartTree extends DefaultMutableTreeNode {

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
	 * the request for the editpart
	 */
	private Request request;

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
	 * 
	 * Constructor.
	 * 
	 * @param editparts
	 *        the editparts used to build the tree
	 */
	public EditPartTree(List<EditPart> editparts) {
		this(null, false);
		buildTree(editparts);
	}

	/**
	 * Gets the alignment request for the editpart.
	 * 
	 * @return the alignment request for the editpart
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 * Sets the alignment request for the editpart.
	 * 
	 * @param request
	 *        the new alignment request for the editpart
	 */
	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 * Sets the used to precise if this tree is the reference of the alignment.
	 * 
	 * @param isReference
	 *        the new used to precise if this tree is the reference of the
	 *        alignment
	 */
	public void setIsReference(boolean isReference) {
		this.isReference = true;
	}

	/**
	 * Gets {@link #isReference()}
	 * 
	 * @return the {@link #isReference()} value
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
	 * @return the {@link #isSelected} value
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
	 * @return the string representing the tree with its children
	 */

	@Override
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
	 * @return <ul>
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
	 * Gets the level for the first selected element in the full tree. This
	 * level is calculated from the root of this node.
	 * 
	 * @param index
	 *        the index
	 * @return <ul>
	 *         <li>the level for first selected element</li>
	 *         <li> {@code -1}</li> if the first selected element can't be found
	 *         </ul>
	 */
	public int getLevelForFirstSelectedElement() {
		// We search the first level in the tree
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
	 *        the tree node (level one of a tree) where we search the first
	 *        selected element
	 * @return the selected first edit part or {@code null} if not found
	 */
	protected EditPartTree getSelectedFirstEditPart(EditPartTree treeNode) {
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
	 * @return <ul>
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
	 * @return <ul>
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
	 * Returns the first unselected child or {@code null} if all the children
	 * are selected
	 * 
	 * @return the first unselected child or {@code null} if all the children
	 *         are selected
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
	 * Sorts the editparts in the tree In this tree, we have the selected
	 * editparts. Moreover, we add the intermediate packages, even if they
	 * aren't selected. These intermediate packages are used to determine the
	 * final position of their parents, if the reference is inside on of these
	 * packages
	 * 
	 * @param editparts
	 *        the editparts to sort
	 */
	public void buildTree(List<EditPart> editparts) {
		List<EditPart> parentsList;
		if(editparts.size() >= 2) {

			// we build the tree
			for(EditPart currentEP : editparts) {
				parentsList = new ArrayList<EditPart>();
				EditPart parent = currentEP;
				EditPartTree grandFatherTree = this;
				int i = 0;
				while(parent != null) {
					if(this.contains(parent)) {
						grandFatherTree = this.getTree(parent);
						break; // on sort du while
					} else {
						// we add all the parent in this list!
						/*
						 * we don't add the parent if it's a comparment , except
						 * if the parent is the selected element (property,
						 * enumeration literal...), of course, a property or a
						 * enumeration literal can't move in there compartment
						 * (in class diagram) but this choice allows avoid some
						 * NullPointerException. (see bug 317691)
						 */
						if(!(parent instanceof CompartmentEditPart) || (parent instanceof CompartmentEditPart && parent == currentEP)) {
							if(!(parent instanceof RootEditPart)) {
								if(!(parent.getParent() instanceof RootEditPart)) {
									parentsList.add(i, parent);
									i++;
								}
							}
						}
					}
					parent = parent.getParent();
				}

				// We add all the node in the rootTree
				EditPartTree childTree = createChildrenTree(editparts, parentsList);

				// we add the node to the tree
				if(childTree != null) {
					grandFatherTree.add(childTree);
				}

			}

			// we precise which element is the reference (the last selected
			// element)
			this.getTree(editparts.get(editparts.size() - 1)).setIsReference(true);

			/*
			 * we precise for each branch the first selected element it's this
			 * element (and its brothers) which are really align on the
			 * reference
			 */

			Enumeration childrenEnum = this.children();
			while(childrenEnum.hasMoreElements()) {
				EditPartTree currentTree = (EditPartTree)childrenEnum.nextElement();
				for(int i = 0; i < editparts.size(); i++) {
					if(currentTree.contains(editparts.get(i))) {
						currentTree.getTree(editparts.get(i)).setFirstSelectedElement(true);
						break;
					}
				}
			}

			postBuildOperations(editparts);

		}
	}

	/**
	 * This method is used to create an EditPartTree with {@code the List<EditPart> children}
	 * 
	 * @param editparts
	 *        the selected editparts for this action
	 * @param children
	 *        intermediate children which could be interesting to add like
	 *        node in the tree
	 * @return a new EditPartTree
	 */
	protected abstract EditPartTree createChildrenTree(List<EditPart> editparts, List<EditPart> children);

	/**
	 * Action that can be done to conclude the tree construction
	 * 
	 * @param editparts
	 *        an editparts list
	 */
	protected abstract void postBuildOperations(List<EditPart> editparts);

}
