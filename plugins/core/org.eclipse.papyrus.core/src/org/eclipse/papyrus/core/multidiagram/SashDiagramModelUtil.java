/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.multidiagram;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.di.CoreSemanticModelBridge;
import org.eclipse.papyrus.di.DiFactory;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.di.DiagramElement;
import org.eclipse.swt.SWT;

/**
 * Utility static methods to manage Diagram Model.
 * 
 * @author dumoulin
 * 
 */
public class SashDiagramModelUtil {

	/** Represents a root node 
	 * Really used ?
	 */
	public static String ROOT_WINDOW = "root.window";

	/** Represents a tab folder */
	public static String TAB_FOLDER_WINDOW = "tabfolder.window";

	/** Represent an editor (or a tabfolder item) */
	public static String TABITEM_WINDOW = "tab.window";

	/** represents a vertical sash */
	public static String SASHV_WINDOW = "sashv.window";

	/** Represents an horizontal sash */
	public static String SASHH_WINDOW = "sashh.window";

	/** @deprecated 
	 * TODO Remove next one
	 * */
	public static String SASH_WINDOW = "sash.window";

	/**
	 * Return true if the specified object represent a SashDiagram node. For DI2 implementation, return true if the object is of type Diagram, and if the type is one of the SashDiagram type.
	 */
	public static boolean isSashDiagramNode(Object node) {
		if (!(node instanceof Diagram)) {
			return false;
		}
		return isSashDiagramNode((Diagram) node);
	}

	/**
	 * Return true if the specified object represent a SashDiagram node. For DI2 implementation, return true if the object is of type Diagram, and if the type is one of the SashDiagram type.
	 */
	public static boolean isSashDiagramNode(Diagram diagram) {
		String type = diagram.getType();
		if (type == null)
			return false;
		else if (SASH_WINDOW.equals(type))
			return true;
		else if (SASHH_WINDOW.equals(type))
			return true;
		else if (SASHV_WINDOW.equals(type))
			return true;
		else if (TAB_FOLDER_WINDOW.equals(type))
			return true;
		else if (TABITEM_WINDOW.equals(type))
			return true;

		return false;
	}

	/**
	 * Return true if the specified object represent a SashDiagram root node. For DI2 implementation, return true if the object is of type Diagram, and if the type is one of the SashDiagram type.
	 */
	public static boolean isSashDiagramRootNode(Object node) {
		if (!(node instanceof Diagram)) {
			return false;
		}
		return isSashDiagramRootNode((Diagram) node);
	}

	/**
	 * Return true if the specified object represent a SashDiagram root node. For DI2 implementation, return true if the object is of type Diagram, and if the type is one of the SashDiagram root type.
	 */
	protected static boolean isSashDiagramRootNode(Diagram diagram) {
		String type = diagram.getType();
		if (type == null)
			return false;
		else if (ROOT_WINDOW.equals(type))
			return true;
		else if (SASH_WINDOW.equals(type))
			return true;
		else if (SASHH_WINDOW.equals(type))
			return true;
		else if (SASHV_WINDOW.equals(type))
			return true;
		else if (TAB_FOLDER_WINDOW.equals(type))
			return true;

		return false;
	}

	/**
	 * Return true if the specified diagram node represent a Folder Diagram node. For DI2 implementation, return true if the object is of type Diagram, and if the type is folder.
	 */
	protected static boolean isFolderNode(Diagram diagram) {
		String type = diagram.getType();
		if (TAB_FOLDER_WINDOW.equals(type))
			return true;

		return false;
	}

	/**
	 * Return the root of the Diagram model from the specified diagramResource.
	 * 
	 * @param diagramResource
	 *            The resource checked
	 * @return The model root or null if not found.
	 */
	protected static Diagram getModelRoot(Resource diagramResource) {

		for (Object cur : diagramResource.getContents()) {
			if (isSashDiagramRootNode(cur))
				return (Diagram) cur;
		}

		return null;
	}

	/**
	 * Return true if the specified resource contains an appropriate model for sash windows system.
	 * @param diagramResource
	 * @return
	 */
	public static boolean isAppropriateModelForSashEditor(Resource diagramResource)
	{
		return getModelRoot(diagramResource) != null;
	}
	/**
	 * Convert a Papyrus I Di Model to a Papyrus II Di Model.
	 * Papyrus II Di Model must contain Sash window model
	 * Conversion create such model and initialize it with a TabFolder referencing the PI Diagrams.
	 * 
	 * @param diagramResource
	 * @return
	 */
	protected static Diagram convertPapyrusIDiModelToPapyrusIIDiModel(Resource diagramResource) 
	{
//		Diagram root = createRootWindowDiagram();
		Diagram tabFolder = createTabFolderNode();
		
		// Add each diagram.
		for (Object cur : diagramResource.getContents()) {
			if (cur instanceof Diagram )
			{
				// Get the diagram
 			  openDiagram(tabFolder, (Diagram)cur);
			}
		}
		// Add tile model to resource
		diagramResource.getContents().add(tabFolder);
		
		return tabFolder;
	}
	/**
	 * Check if the resource contains a SashWindow root node.
	 * 
	 * @return
	 */
	protected static boolean isRootNodeExist(Resource diagramResource) {
		return getModelRoot(diagramResource) != null;
	}

	/**
	 * Create the root node hosting the other Sash Window nodes.
	 */
	protected static Diagram createRootWindowDiagram() {
		return createTypedNode(ROOT_WINDOW);

	}

	/**
	 * Create the root node hosting the other Sash Window nodes.
	 */
	public static Diagram createTabFolderNode() {
		return createTypedNode(TAB_FOLDER_WINDOW);

	}

	/**
	 * Create a node representing the specified type.
	 */
	protected static Diagram createTypedNode(String type) {
		Diagram node = DiFactory.eINSTANCE.createDiagram();
		node.setType(type);
		node.setName(type);
		return node;
	}

	/**
	 * Create a TabItem node referencing a real diagram.
	 * 
	 * @param diagramReference
	 *            The real diagram.
	 */
	protected static Diagram createTabItemNode(EObject diagramReference) {
		Diagram node = createTypedNode(TABITEM_WINDOW);
		// Create bridge
		CoreSemanticModelBridge bridge = DiFactory.eINSTANCE.createCoreSemanticModelBridge();
		bridge.setElement(diagramReference);
		node.setSemanticModel(bridge);
		return node;
	}

	/**
	 * Insert specified node at the right or left side of the specified relativeNode.
	 * 
	 * @param insertedNode
	 *            Node to be inserted
	 * @param relativeNode
	 *            Inserted node will be on one side of this node.
	 * @param side
	 *            Side where node should be inserted : SWT.LEFT, SWT.RIGHT, SWT.TOP, SWT.DOWN.
	 * @return
	 */
	public static Diagram insertNode(Diagram insertedNode, Diagram relativeNode, int side) {
		String sashType;
		// horizontal or vertical ?
		if (side == SWT.LEFT || side == SWT.RIGHT)
			sashType = SASHH_WINDOW;
		else
			sashType = SASHV_WINDOW;

		// Get the parent
		Diagram parentNode = (Diagram) relativeNode.getContainer();
		Diagram node = createTypedNode(sashType);
		// Attach to parent.
		// Parent can be null if we are at the top of hierarchy
		if (parentNode != null) {
			// Insert the new sash in the parent, at the right place
			List<DiagramElement> contained = parentNode.getContained();
			int positionInParent = contained.indexOf(relativeNode);
			contained.set(positionInParent, node);
		} else { // Attach to resource, at the same place than the old node.
			List<EObject> contents = relativeNode.eResource().getContents();
			int positionInParent = contents.indexOf(relativeNode);
			contents.set(positionInParent, node);
		}

		// insert left or right ?
		if (side == SWT.LEFT || side == SWT.TOP)
			populateSashNode(node, insertedNode, relativeNode);
		else
			// insert right
			populateSashNode(node, relativeNode, insertedNode);

		return node;
	}

	/**
	 * Populate sashnode with provided subnodes.
	 * 
	 * @param node
	 * @param insertedNode
	 * @param relativeNode
	 */
	private static void populateSashNode(Diagram sashNode, Diagram leftNode, Diagram rightNode) {
		List<DiagramElement> list = sashNode.getContained();
		if (list.size() == 0) {
			list.add(leftNode);
			list.add(rightNode);
		} else if (list.size() == 2) {
			list.set(0, leftNode);
			list.set(1, rightNode);
		} else { // size == 1
			list.set(0, leftNode);
			list.add(rightNode);
		}

	}

	/**
	 * Remove the folder node from the tree. Also remove the parents that are not needed anymore.
	 * 
	 * @param node
	 */
	public static void removeTabFolderNode(Diagram node) {
		// Check if it is ok
		if (!isFolderNode(node))
			return;

		removeNodeFromParent(node);
		
//		// Get the parent
//		Diagram parentNode = (Diagram) node.getContainer();
//		// Check if parent exist.
//		// If there is no parent, the folder can't be removed
//		if (parentNode == null) {
//			return;
//		}
//
//		// Get the other needed node
//		// neighbour: the neighbour of the node to be remove
//		// grandParent: the parent of the parent
//		List<DiagramElement> contained = parentNode.getContained();
//		int positionInParent = contained.indexOf(node);
//		Diagram neighbour = (Diagram) contained.get((positionInParent == 0 ? 1 : 0));
//		Diagram grandParent = (Diagram) parentNode.getContainer();
//
//		// Now, adjust node
//		if (grandParent == null) {
//			// the neighbour become the root of the diagram nodes
//			// set the resource as its container, and remove old parent from resource
//			neighbour.setContainer(null);
//			EList<EObject> resourceContents = parentNode.eResource().getContents();
//			resourceContents.add(neighbour);
//			// Clear the removed parent
//			parentNode.getContained().clear();
//			EcoreUtil.remove(parentNode);
//		} else {
//			// The neighbour is shifted one level
//			// Parent position in grandParent
//			List<DiagramElement> grandParentChilds = grandParent.getContained();
//			int parentPosition = grandParentChilds.indexOf(parentNode);
//			// Replace the old sash node by the neighbour
//			grandParentChilds.set(parentPosition, neighbour);
//			// Clean up the removed parent sash node
//			parentNode.getContained().clear();
//			EcoreUtil.remove(parentNode);
//		}
//
//		// Clean up the folder
//		node.getContained().clear();
//		EcoreUtil.remove(node);
//
	}

	/**
	 * Remove the specified node from its parent. Also remove the parents that are not needed anymore.
	 * Check the node's type and call the appropriate method.
	 * @param node
	 */
	public static void removeNodeFromParent(Diagram diagram)
	{
		// Get the parent
		Diagram parent = (Diagram)diagram.getContainer();
		
		if(parent== null)
		{ 
			// We are the root node. This should not happen.
			// do nothing as we can't be removed.
			return;
		}
		else if(isFolderNode(parent))
		  removeNodeFromTabFolder(parent, diagram);
		else if( isSashDiagramNode(parent))
			removeNodeFromSashDiagramNode(parent, diagram);
		else if(isSashDiagramRootNode(diagram))
		{
			removeNodeFromRootNode(parent, diagram);
		}
	}
	
	/**
	 * Remove the child node from its parent which should be of type RootNode.
	 * This should not happen has it lead to an empty window.
	 * If this method is called, there is certainly an error in the algorithm. 
	 * 
	 * @param parent
	 * @param diagram
	 */
	private static void removeNodeFromRootNode(Diagram parent, Diagram childNode) {
		System.err.println("Forbiden action: Try to remove childNode from the RootNode. Skip it.");
	}

	/**
	 * Remove the specified node from its parent sashNode. 
	 * As a consequence, the parent sashNode is also removed, because it is not needed anymore.
	 * The parent's of the parent sashNode is modified in order to replace the parent sashNode with the remaining child.
	 * 
	 * @param parent
	 * @param diagram
	 */
	private static void removeNodeFromSashDiagramNode(Diagram sashNode, Diagram childNode) {
		// Get the other child of the sash
		// neighbour: the neighbour of the node to be remove
		List<DiagramElement> contained = sashNode.getContained();
		int positionInParent = contained.indexOf(childNode);
		Diagram neighbour = (Diagram) contained.get((positionInParent == 0 ? 1 : 0));
		Diagram parentNode = (Diagram) sashNode.getContainer();
		
		// Replace the sashNode by the remaining child int the sashNode parent.
		replaceChildNodeInParentNode(parentNode, sashNode, neighbour);
		
	}

	/**
	 * Remove the specified diagram from its parent tabFolder. 
	 * Also remove the parents that are not needed anymore.
	 * 
	 * @param tabFolder The parent tabFolder
	 * @param diagram The node to be removed.
	 */
	private static void removeNodeFromTabFolder(Diagram tabFolder, Diagram diagram) {
		// We are in a TabFolder
		// Remove the child
		EList<DiagramElement> contained = tabFolder.getContained();
		contained.remove(diagram);
		// Check if the TabFolder is empty
		if(contained.size()==0)
		{
			// Empty tabFolder : remove it
			removeNodeFromParent(tabFolder);
		}
		
	}

	/**
	 * Remove the specified diagram from its parent tabFolder. 
	 * Also remove the parents that are not needed anymore.
	 * 
	 * @param tabFolder The parent tabFolder
	 * @param diagram The node to be removed.
	 */
	public static Diagram removeNodeFromTabFolder(Diagram tabFolder, int diagramIndex) {
		// We are in a TabFolder
		// Remove the child
		EList<DiagramElement> contained = tabFolder.getContained();
		Diagram removed = (Diagram)contained.remove(diagramIndex);
		// Check if the TabFolder is empty
		if(contained.size()==0)
		{
			// Empty tabFolder : remove it
			removeNodeFromParent(tabFolder);
		}
		
		return removed;
	}

	/**
	 * Replace the childNode by the newNode in the parentNode.
	 * @param parentNode
	 * @param nodeToBeReplaced
	 * @param newNode
	 */
	private static void replaceChildNodeInParentNode(Diagram parentNode, Diagram nodeToBeReplaced, Diagram newNode) {
		if(parentNode== null)
		{ 
			// We are the root node. 
			replaceChildNodeInResource(nodeToBeReplaced, newNode);
		}
		else if(isFolderNode(parentNode))
			replaceChildNodeInTabFolder(parentNode, nodeToBeReplaced, newNode);
		else if( isSashDiagramNode(parentNode))
			replaceChildNodeInSashDiagramNode(parentNode, nodeToBeReplaced, newNode);
		else if(isSashDiagramRootNode(parentNode))
		{
			replaceChildNodeInRootNode(parentNode, nodeToBeReplaced, newNode);
		}
	}

	private static void replaceChildNodeInResource(Diagram nodeToBeReplaced, Diagram newNode)
	{
		// the neighbour become the root of the diagram nodes
		// set the resource as its container, and remove old parent from resource
		newNode.setContainer(null);
//		Resource resource = nodeToBeReplaced.eResource();
//		resource.eSetDeliver(false);
		
		EList<EObject> resourceContents = nodeToBeReplaced.eResource().getContents();
		resourceContents.add(newNode);
		// Clear the removed parent
		nodeToBeReplaced.getContained().clear();
		EcoreUtil.remove(nodeToBeReplaced);
//		resource.eSetDeliver(true);
	}
	
	/**
	 * Replace the nodeToBeReplaced by the newNode in the parent which should be of type RootNode.
	 * 
	 * @param parentNode
	 * @param nodeToBeReplaced
	 * @param newNode
	 */
	private static void replaceChildNodeInRootNode(Diagram rootNode, Diagram nodeToBeReplaced, Diagram newNode) {
		assert(isSashDiagramRootNode(rootNode));
		
		List<DiagramElement> contained = rootNode.getContained();
		// RootNode contains only one child
		assert(contained.size()==1);
		int nodeToBeReplaceIndex = contained.indexOf(nodeToBeReplaced);	
		contained.set(nodeToBeReplaceIndex, newNode);
	}

	/**
	 * Replace the nodeToBeReplaced by the newNode in the parentNode which should be of type SashNode
	 * @param sashNode
	 * @param nodeToBeReplaced
	 * @param newNode
	 */
	private static void replaceChildNodeInSashDiagramNode(Diagram sashNode, Diagram nodeToBeReplaced, Diagram newNode) {
		assert(isSashDiagramNode(sashNode));
		
		List<DiagramElement> contained = sashNode.getContained();
		// RootNode contains only one child
		assert(contained.size()==2);
		int nodeToBeReplaceIndex = contained.indexOf(nodeToBeReplaced);	
		contained.set(nodeToBeReplaceIndex, newNode);
	}

	/**
	 * Replace the child by the newNode int the parent which should be of type TabFolder.
	 * @param folderNode
	 * @param nodeToBeReplaced
	 * @param newNode
	 */
	private static void replaceChildNodeInTabFolder(Diagram folderNode, Diagram nodeToBeReplaced, Diagram newNode) {
		assert(isFolderNode(folderNode));
		EList<DiagramElement> contained = folderNode.getContained();
		int index = contained.indexOf(nodeToBeReplaced);
		contained.set(index, newNode);
	}

	/**
	 * Create a simple root model with a TabFolder and no tabs. Do no check if such model already exist.
	 */
	public static Diagram createSimpleSashWindowsRootModel() {
		// Diagram rootNode = createRootWindowDiagram();
		Diagram tabFolder = createTabFolderNode();
		// rootNode.getContained().add(tabFolder);
		return tabFolder;
	}

	/**
	 * Create a simple root model with a TabFolder and no tabs. Do no check is such model already exist.
	 */
	public static void createSimpleSashWindowsRootModel(Resource resource) {
		Diagram rootNode = createSimpleSashWindowsRootModel();
		resource.getContents().add(rootNode);
	}

	/**
	 * Add the specified diagram to the first tabfolder
	 * 
	 * @param diagram
	 */
	public static void openDiagram(Resource sashModelResource, EObject diagram) {
		Diagram tabFolder = findDefaultTabFolder(sashModelResource);
		openDiagram(tabFolder, diagram);
	}

	/**
	 * Open the diagram in the current folder. 
	 * TODO Notion of current folder should be specified somewhere.
	 * 
	 * @param diagram
	 */
	public static void openDiagramInCurrentFolder(Resource sashModelResource, EObject diagram) {
		openDiagram(sashModelResource, diagram);
	}

	/**
	 * Add the provided diagram to the list of open diagram in the specified folder. Create the required node referencing the real diagram
	 * 
	 * @param folderNode
	 *            The folder into which the tab is added.
	 * @param diagram
	 *            The real diagram to add.
	 */
	private static void openDiagram(Diagram folderNode, EObject diagram) {
		// Create the Tab node
//		Diagram tabNode = createTabItemNode(diagram);
//		folderNode.getContained().add(tabNode);
		EditorUtils.getISashWindowsContentProvider().addPage(diagram);
	}

	/**
	 * Find the defaultTabFolder. Return the first node of type TAB_FOLDER_WINDOW.
	 * 
	 * @param resource
	 * @return The default tabFolder
	 */
	private static Diagram findDefaultTabFolder(Resource resource) {
		Diagram rootNode = getModelRoot(resource);
		return findFirstTabFolder(rootNode);
	}

	/**
	 * Find the first tab folder that can be reached from the node. S Return the first node of type TAB_FOLDER_WINDOW.
	 * 
	 * @return The default tabFolder
	 */
	private static Diagram findFirstTabFolder(Diagram node) {
		String nodeType = node.getType();
		if (TAB_FOLDER_WINDOW.equals(nodeType))
			return node;
		else if (isSashDiagramNode(node)) {
			return findFirstTabFolder((Diagram) node.getContained().get(0));
		} else if (isSashDiagramRootNode(node)) {
			return findFirstTabFolder((Diagram) node.getContained().get(0));
		}

		return null;
		// throw new SashDiagramModelException("Can't find a TabFolder from " + node);
	}

}
