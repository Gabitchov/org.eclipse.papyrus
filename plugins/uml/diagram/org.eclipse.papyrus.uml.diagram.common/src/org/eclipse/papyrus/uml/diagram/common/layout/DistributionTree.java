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

import org.eclipse.gef.EditPart;

/**
 * 
 * A special tree for the distribution actions
 * 
 */
public class DistributionTree extends EditPartTree {

	/**
	 * this UDI can be used to serialize this class
	 */
	private static final long serialVersionUID = 5339900684765896876L;

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
	public DistributionTree(Object editpart, boolean isSelected) {
		super(editpart, isSelected);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editparts
	 *        the editparts used to build the tree
	 */
	public DistributionTree(List<EditPart> editparts) {
		super(editparts);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.layout.EditPartTree#createChildrenTree(java.util.List, java.util.List)
	 * 
	 * @param editparts
	 *        the selected editpart
	 * @param childrenList
	 *        parents of editparts which could be interesting to add to the
	 *        tree
	 * @return a new tree
	 */
	@Override
	protected EditPartTree createChildrenTree(List<EditPart> editparts, List<EditPart> childrenList) {
		EditPartTree childTree = null;
		for(EditPart editpart : childrenList) {

			boolean isSelected = editparts.contains(editpart);
			EditPartTree parentTree = new DistributionTree(editpart, isSelected);
			if(childTree != null) {
				parentTree.add(childTree);
			}
			childTree = parentTree;
		}
		return childTree;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.layout.EditPartTree#postBuildOperations(java.util.List)
	 * 
	 * @param editparts
	 */
	@Override
	protected void postBuildOperations(List<EditPart> editparts) {
		// nothing to do

	}

}
