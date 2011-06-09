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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.vsl.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

public abstract class Tree<NodeType> {
	
	protected NodeType root ;
	protected NodeType parent ;
	protected List<Tree<NodeType>> children ;
	
	public Tree(NodeType root) {
		this.root = root ;
	}
	
	public NodeType getRoot() {
		return root ;
	}
	
	public NodeType getParent() {
		return parent ;
	}
	
	public void setParent(NodeType parent) {
		this.parent = parent ;
	}
	
	public List<Tree<NodeType>> getChildren() {
		if (children == null)
			children = new ArrayList<Tree<NodeType>>() ;
		return children ;
	}
	
	public boolean isEmpty() {
		return getChildren().isEmpty() ;
	}
	
	public abstract void buildTree() ;
}
