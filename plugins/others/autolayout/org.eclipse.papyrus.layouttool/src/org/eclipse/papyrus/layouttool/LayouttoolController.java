/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - LayouttoolController Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.zest.layouts.InvalidLayoutConfiguration;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.exampleStructures.SimpleNode;
import org.eclipse.zest.layouts.exampleStructures.SimpleRelationship;

/**
 * The class LayouttoolController.
 */
public class LayouttoolController {

	/** The sub editor. */
	private LayouttoolInterface subEditor;

	/** The list edit part selected. */
	private List<EditPart> listEditPartSelected;

	/** The current layout algorithm. */
	private LayoutAlgorithm currentLayoutAlgorithm;

	/** The list nodes. */
	private List<SimpleNode> listNodes = new ArrayList<SimpleNode>();

	/** The list nodes edit part. */
	private List<EditPart> listNodesEditPart = new ArrayList<EditPart>();

	/** The list relationships. */
	private List<SimpleRelationship> listRelationships = new ArrayList<SimpleRelationship>();

	/**
	 * The Constructor.
	 * 
	 * @param list
	 *            of EditPart selected
	 * @param currentAlgorithm
	 *            algorithm to apply
	 */
	public LayouttoolController(List<EditPart> list, AbstractLayoutAlgorithm currentAlgorithm) {
		listEditPartSelected = list;
		this.currentLayoutAlgorithm = currentAlgorithm;
	}

	/**
	 * Transform nodes into SimpleNodes and relationships into SimpleRelationship Calculate bounds
	 * of the layout Apply layout.
	 */
	public void execute() {
		subEditor = LayoutToolExtensionPointManager.getInstance().getSubEditor();
		if (subEditor == null) {
			Activator.getDefault().log("Editor not found");
			return;
		}
		if (listEditPartSelected == null || listEditPartSelected.size() <= 1) {
			Activator.getDefault().log("Select at least two elements");
			return;
		}
		// create all nodes
		createNodes();
		if (listNodes == null || listNodes.size() <= 1) {
			Activator.getDefault().log("Any node selected");
			return;
		}
		// find relationships of all nodes selected
		createRelationships();
		// Create array of EditParts selected
		EditPart[] arrayEditPart = new EditPart[listEditPartSelected.size()];
		listEditPartSelected.toArray(arrayEditPart);
		// Get layout area where algorithms must be apply
		Rectangle layoutArea = subEditor.getLayoutArea(arrayEditPart);
		// Create array of simpleNodes
		SimpleNode[] listSimpleNode = new SimpleNode[listNodes.size()];
		listNodes.toArray(listSimpleNode);
		// Create array of simpleRelationships
		SimpleRelationship[] listSimpleRelationship = new SimpleRelationship[listRelationships.size()];
		listRelationships.toArray(listSimpleRelationship);
		try {
			currentLayoutAlgorithm
					.applyLayout(listSimpleNode, listSimpleRelationship, layoutArea.preciseX(), layoutArea.preciseY(),
							layoutArea.preciseWidth() - 40, layoutArea.preciseHeight() - 5, false, false);
		} catch (InvalidLayoutConfiguration e) {
			Activator.getDefault().log(e.getMessage() + " : Layout cannot be applied", e);
		}
		Map<EditPart, Rectangle> map = matchEditPartCoordinates();
		subEditor.execute(map);
	}

	/**
	 * For all nodes, find source relationships and target relationships and create
	 * SimpleRelationships.
	 */
	private void createRelationships() {
		for (int i = 0; i < listNodes.size(); i++) {
			List<EditPart> sources = getSourceRelationships((EditPart) listNodes.get(i).getRealObject());
			for (EditPart source : sources) {
				EditPart node = subEditor.getTarget(source);
				SimpleRelationship relationship = getSimpleRelationship(subEditor.getSource(source), subEditor
						.getTarget(source));
				if (!listRelationships.contains(relationship) && listNodesEditPart.contains(node)) {
					listRelationships.add(relationship);
				}
				listNodes.get(i).addRelationship(relationship);
			}
			List<EditPart> targets = getTargetRelationships((EditPart) listNodes.get(i).getRealObject());
			for (EditPart target : targets) {
				EditPart node = subEditor.getSource(target);
				SimpleRelationship relationship = getSimpleRelationship(subEditor.getSource(target), subEditor
						.getTarget(target));
				if (!listRelationships.contains(relationship) && listNodesEditPart.contains(node)) {
					listRelationships.add(relationship);
				}
				listNodes.get(i).addRelationship(relationship);
			}
		}
	}

	/**
	 * For all nodes selected, create SimpleNodes.
	 */
	private void createNodes() {
		for (EditPart editPart : listEditPartSelected) {
			if (subEditor.isNode(editPart)) {
				Rectangle coordinates = subEditor.getBounds(editPart);
				if (coordinates != null) {
					listNodes.add(getSimpleNode(editPart, coordinates));
					listNodesEditPart.add(editPart);
				}
			}
		}
	}

	/**
	 * Gets the simple relationship.
	 * 
	 * @param source
	 *            node
	 * @param destination
	 *            node
	 * 
	 * @return SimpleRelationship
	 */
	public SimpleRelationship getSimpleRelationship(EditPart source, EditPart destination) {
		SimpleNode simpleNodeSource = null;
		SimpleNode simpleNodeDestination = null;
		EditPart editPart;
		// for all nodes, search the source SimpleNode and the destination SimpleNode of this
		// relationship
		for (SimpleNode sn : listNodes) {
			editPart = (EditPart) sn.getRealObject();
			if (editPart.equals(source)) {
				simpleNodeSource = sn;
			}
			if (editPart.equals(destination)) {
				simpleNodeDestination = sn;
			}
		}
		SimpleRelationship simpleRelationship = new SimpleRelationship(simpleNodeSource, simpleNodeDestination, true);
		return simpleRelationship;
	}

	/**
	 * Match each editPart with their new coordinates.
	 * 
	 * @return map EditPart with his news coordinates
	 */
	public Map<EditPart, Rectangle> matchEditPartCoordinates() {
		Map<EditPart, Rectangle> map = new HashMap<EditPart, Rectangle>();
		for (SimpleNode node : this.listNodes) {
			Rectangle coordinates = new Rectangle((int) node.getXInLayout(), (int) node.getYInLayout(), (int) node
					.getWidthInLayout(), (int) node.getHeightInLayout());
			map.put((EditPart) node.getRealObject(), coordinates);
		}
		return map;
	}

	/**
	 * Gets the simple node.
	 * 
	 * @param element
	 *            node
	 * @param coordinates
	 *            the coordinates
	 * 
	 * @return SimpleNode
	 */
	public SimpleNode getSimpleNode(EditPart element, Rectangle coordinates) {
		return getSimpleNode(element, coordinates, false);
	}

	/**
	 * Gets the simple node.
	 * 
	 * @param element
	 *            node
	 * @param coordinates
	 *            the coordinates
	 * @param ignoreInLayout
	 *            ignore a node when apply layout
	 * 
	 * @return SimpleNode
	 */
	public SimpleNode getSimpleNode(EditPart element, Rectangle coordinates, boolean ignoreInLayout) {
		SimpleNode node = new SimpleNode(element, coordinates.preciseX(), coordinates.preciseY(), coordinates
				.preciseWidth(), coordinates.preciseHeight());
		node.ignoreInLayout(ignoreInLayout);
		return node;
	}

	/**
	 * Gets the source relationships.
	 * 
	 * @param editPart
	 *            node
	 * 
	 * @return list of EditPart
	 */
	public List<EditPart> getSourceRelationships(EditPart editPart) {
		GraphicalEditPart gep = (GraphicalEditPart) editPart;
		List<EditPart> sourceConnections = gep.getSourceConnections();
		return sourceConnections;
	}

	/**
	 * Gets the target relationships.
	 * 
	 * @param editPart
	 *            node
	 * 
	 * @return list of EditPart
	 */
	public List<EditPart> getTargetRelationships(EditPart editPart) {
		GraphicalEditPart gep = (GraphicalEditPart) editPart;
		List<EditPart> targetConnections = gep.getTargetConnections();
		return targetConnections;
	}
}
