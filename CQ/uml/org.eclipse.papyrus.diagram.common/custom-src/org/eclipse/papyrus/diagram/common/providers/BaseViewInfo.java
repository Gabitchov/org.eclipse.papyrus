/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseViewInfo.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class BaseViewInfo implements ViewInfo {

	// // attributes

	/** The parent. */
	private ViewInfo parent = null;

	/** The visual id. */
	private int visualID = -1;

	/** The type. */
	private int type = ViewInfo.None;

	/** The label. */
	private String label = null;

	/** The children. */
	private Collection<ViewInfo> children = null;

	/** The to add. */
	private static Map<Integer, Collection<ViewInfo>> toAdd = null;

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
		this.visualID = visualID;
		this.type = type;
		this.label = label;
		this.children = children;
		this.parent = parent;
	}

	// // getters

	/*
	 * (non-Javadoc)
	 * 
	 */
	public Collection<ViewInfo> getChildren() {
		if (children == null) {
			children = new ArrayList<ViewInfo>();
		}
		return children;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public String getLabel() {
		return label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public int getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public int getVisualID() {
		return visualID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public ViewInfo getParent() {
		return parent;
	}

	/**
	 * Gets the to add.
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

	/*
	 * (non-Javadoc)
	 * 
	 */
	public void setChildren(Collection<ViewInfo> children) {
		this.children = children;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public void setParent(ViewInfo parent) {
		this.parent = parent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public void setType(int type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public void setVisualID(int visualID) {
		this.visualID = visualID;
	}

	/**
	 * Gets the root info.
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
	 * Checks if is root.
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

	/*
	 * (non-Javadoc)
	 * 
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
	 * Checks if is already contained.
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
	 * Look in children.
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
	 * Adds the pendent node.
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
	 * Revise pendent nodes.
	 * 
	 * @param info
	 *            the info
	 */
	private void revisePendentNodes(ViewInfo info) {
		int parentVisualID = info.getVisualID();
		Map<Integer, Collection<ViewInfo>> toAdd = getToAdd();
		if (toAdd.containsKey(parentVisualID)) {
			for (ViewInfo viewInfo : toAdd.get(parentVisualID)) {
				if (info.getChildren().contains(viewInfo) == false && info != viewInfo && isAlreadyContained(viewInfo) == false) {
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
	/*
	 * (non-Javadoc)
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
