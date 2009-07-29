/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A basic implementation of {@link ViewInfo}. This class is used to parse the
 * 'es.cv.gvcase.mdt.common.viewInfo' extension point. It can handle the additions of child nodes
 * that have parents that have not yet been added; these nodes are stores in a temporary storage.
 * Upon a later addition of a node, nodes in the temporary storage are revisited to put them in
 * their correct place.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @NOT-generated
 */
public class BaseViewInfo implements ViewInfo {

	// // attributes

	/** The parent ViewInfo in the hierarchy. */
	private ViewInfo parentViewInfo = null;

	/** The visual id in String form. */
	public String visualID = "-1";

	/** The type in String form. */
	public String type;

	/** The type in integer form. */
	private int typeViewInfo = ViewInfo.None;

	/** The label that will be shown. */
	public String label = null;

	/** The children of this ViewInfo in the hierarchy. */
	private Collection<ViewInfo> children = null;

	/** Temporary storage of ViewInfo elements to be added. */
	private static Map<Integer, Collection<ViewInfo>> toAdd = null;

	/** Identifier of the IElementType this ViewInfo represents. */
	public String elementType;

	/** VisualID in String form of this ViewInfo's parent. */
	public String parent;

	/** Pointer to the RootInfo which this ViewInfo belong to. */
	public RootViewInfo rootViewInfo;

	/** Flag that indicates if this ViewInfo can be selected to be filtered. */
	public Boolean selectable = true;

	// // constructors

	/**
	 * Instantiates a new base view info.
	 */
	public BaseViewInfo() {
		// empty constructor
	}

	/**
	 * Instantiates a new base view info.
	 * 
	 * @param visualID
	 *            the visual id
	 * @param type
	 *            the type
	 * @param label
	 *            the label
	 */
	public BaseViewInfo(int visualID, int type, String label) {
		this(visualID, type, label, null, null);
	}

	/**
	 * Instantiates a new base view info.
	 * 
	 * @param visualID
	 *            the visual id
	 * @param type
	 *            the type
	 * @param label
	 *            the label
	 * @param children
	 *            the children
	 * @param parent
	 *            the parent
	 */
	public BaseViewInfo(int visualID, int type, String label, Collection<ViewInfo> children, ViewInfo parent) {
		this.visualID = String.valueOf(visualID);
		this.typeViewInfo = type;
		this.label = label;
		this.children = children;
		this.parentViewInfo = parent;
	}

	// // getters

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#getChildren()
	 */
	public Collection<ViewInfo> getChildren() {
		if (children == null) {
			children = new ArrayList<ViewInfo>();
		}
		return children;
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#getLabel()
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#getType()
	 */
	public int getType() {
		// type by its integer form
		switch (typeViewInfo) {
		case ViewInfo.Head:
		case ViewInfo.Node:
		case ViewInfo.Edge:
		case ViewInfo.Label:
			return typeViewInfo;
		default: {
			// type by its String form
			if (type != null && type.length() > 0) {
				if (ViewInfo.NONE_LITERAL.equals(type)) {
					return ViewInfo.None;
				} else if (ViewInfo.HEAD_LITERAL.equals(type)) {
					return ViewInfo.Head;
				} else if (ViewInfo.NODE_LITERAL.equals(type)) {
					return ViewInfo.Node;
				} else if (ViewInfo.EDGE_LITERAL.equals(type)) {
					return ViewInfo.Edge;
				} else if (ViewInfo.LABEL_LITERAL.equals(type)) {
					return ViewInfo.Label;
				} else {
					return ViewInfo.None;
				}
			} else {
				// unknown
				return -1;
			}
		}
		}
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#getVisualID()
	 */
	public int getVisualID() {
		return Integer.valueOf(visualID);
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#getParent()
	 */
	public ViewInfo getParent() {
		return parentViewInfo;
	}

	/**
	 * Indicates whether this ViewInfo can be selected to be filtered.
	 */
	public boolean isSelectable() {
		return selectable;
	}

	/**
	 * Gets the temporary storage for nodes without parents in the hierarchy.
	 * 
	 * @return the to add
	 */
	protected static Map<Integer, Collection<ViewInfo>> getToAdd() {
		if (toAdd == null) {
			toAdd = new HashMap<Integer, Collection<ViewInfo>>();
		}
		return toAdd;
	}

	// // setters

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#setChildren(java.util.Collection )
	 */
	public void setChildren(Collection<ViewInfo> children) {
		this.children = children;
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#setLabel(java.lang.String)
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#setParent(es.cv.gvcase.mdt.
	 *      common.provider.ViewInfo)
	 */
	public void setParent(ViewInfo parent) {
		this.parentViewInfo = parent;
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#setType(int)
	 */
	public void setType(int type) {
		this.typeViewInfo = type;
	}

	/**
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#setVisualID(int)
	 */
	public void setVisualID(int visualID) {
		this.visualID = String.valueOf(visualID);
	}

	/**
	 * Gets the root info which this ViewInfo belong to.
	 * 
	 * @return the root info
	 */
	protected ViewInfo getRootInfo() {
		ViewInfo parent = null, aux = this;
		while ((parent = aux.getParent()) != null) {
			aux = parent;
		}
		return aux;
	}

	/**
	 * Checks whether ViewInfo is the higher in the hierarchy.
	 * 
	 * @return true, if is root
	 */
	protected boolean isRoot() {
		ViewInfo root = getRootInfo();
		if (root != null && root == this) {
			return true;
		}
		return false;
	}

	// // add a node

	/**
	 * Adds a node in its corresponding place in the hierarchy. The parent node needs not exist yet
	 * in the hierarchy. Orphan nodes are stored in a temporary storage, that is revisited when a
	 * new node is added.
	 * 
	 * @see es.cv.gvcase.mdt.common.provider.ViewInfo#addNode(int,
	 *      es.cv.gvcase.mdt.common.provider.ViewInfo)
	 */
	public boolean addNode(int parentVisualID, ViewInfo info) {
		if (isAlreadyContained(info)) {
			return true;
		}
		if (internalAddNode(parentVisualID, info)) {
			if (isRoot()) {
				revisePendentNodes(info);
			}
			return true;
		} else {
			if (isRoot()) {
				addPendentNode(parentVisualID, info);
			}
			return false;
		}
	}

	/**
	 * Checks if a ViewInfo is already contained in the hierarchy.
	 * 
	 * @param info
	 *            the info
	 * 
	 * @return true, if is already contained
	 */
	protected boolean isAlreadyContained(ViewInfo info) {
		if (info == null) {
			return true;
		}
		return lookInChildren(this, info);
	}

	/**
	 * Look in children for a given ViewInfo.
	 * 
	 * @param info
	 *            the info
	 * @param lookFor
	 *            the look for
	 * 
	 * @return true, if successful
	 */
	protected boolean lookInChildren(ViewInfo info, ViewInfo lookFor) {
		if (info == lookFor) {
			return true;
		}
		for (ViewInfo child : info.getChildren()) {
			if (lookInChildren(child, lookFor)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a node that was in the temporary storage and its parent node has just been added to the
	 * hierarchy.
	 * 
	 * @param parentID
	 *            the parent id
	 * @param info
	 *            the info
	 */
	private void addPendentNode(int parentID, ViewInfo info) {
		Map<Integer, Collection<ViewInfo>> toAdd = getToAdd();
		if (toAdd.containsKey(parentID) == false) {
			toAdd.put(parentID, new ArrayList<ViewInfo>());
		}
		if (toAdd.get(parentID).contains(info) == false) {
			toAdd.get(parentID).add(info);
		}
	}

	/**
	 * Revise pending nodes in the temporary storage. Nodes whose parent has been added will be put
	 * in their corresponding in the hierarchy.
	 * 
	 * @param info
	 *            the info
	 */
	private void revisePendentNodes(ViewInfo info) {
		int parentVisualID = info.getVisualID();
		Map<Integer, Collection<ViewInfo>> toAdd = getToAdd();
		if (toAdd.containsKey(parentVisualID)) {
			for (ViewInfo viewInfo : toAdd.get(parentVisualID)) {
				if (info.getChildren().contains(viewInfo) == false && info != viewInfo
						&& isAlreadyContained(viewInfo) == false) {
					info.getChildren().add(viewInfo);
					if (viewInfo.getParent() == null) {
						viewInfo.setParent(info);
					}
				}
			}
			toAdd.remove(parentVisualID);
		}
	}

	/**
	 * Internal add node.
	 * 
	 * @param parentVisualID
	 *            the parent visual id
	 * @param info
	 *            the info
	 * 
	 * @return true, if successful
	 */
	protected boolean internalAddNode(int parentVisualID, ViewInfo info) {
		if (info == null) {
			return true;
		}
		if (getVisualID() == parentVisualID) {
			if (getChildren().contains(info) == false && this != info) {
				getChildren().add(info);
			}
			if (info.getParent() == null) {
				info.setParent(this);
			}
			return true;
		}
		for (ViewInfo viewInfo : getChildren()) {
			if (viewInfo.addNode(parentVisualID, info)) {
				return true;
			}
		}
		return false;
	}

	// // for debugging purposes
	/**
	 * A Debugging method. Shows some info.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String superString = super.toString();
		String myString = getVisualID() + ", " + getLabel();
		superString = superString != null ? superString + " :: " + myString : myString;
		return superString;
	}

}
