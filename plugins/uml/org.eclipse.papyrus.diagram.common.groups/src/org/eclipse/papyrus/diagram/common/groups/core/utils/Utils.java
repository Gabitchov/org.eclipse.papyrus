/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseContainedElementsCreator.ChildSelection;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.diagram.common.groups.utils.GraphicalAndModelElementComparator;
import org.eclipse.papyrus.preferences.Activator;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;


/**
 * This class provides utility methods useful for the group framework.
 * 
 * @author vhemery and adaussy
 */
public class Utils {

	/**
	 * Find the containers which may contain an edit part in the given bounds.
	 * 
	 * @param bounds
	 *        the new or old bounds of the item
	 * @param diagramPart
	 *        the diagram edit part
	 * @return the list of edit parts that are registered through the group framework and that can contain an element within the given bounds
	 */
	public static List<IGraphicalEditPart> findPossibleParents(Rectangle bounds, DiagramEditPart diagramPart) {
		if(diagramPart == null) {
			return Collections.emptyList();
		}
		Set<IGraphicalEditPart> groupParts = new HashSet<IGraphicalEditPart>();
		//For all object in diagram, find edit parts
		for(Object view : diagramPart.getViewer().getEditPartRegistry().keySet()) {
			if(view instanceof View) {
				Object editpart = diagramPart.getViewer().getEditPartRegistry().get(view);
				if(editpart instanceof IGraphicalEditPart) {
					IGraphicalEditPart part = (IGraphicalEditPart)editpart;
					//If this group is handled by the group framework
					if(GroupContainmentRegistry.isContainerConcerned(part)) {
						//recover group descriptor of this part
						AbstractContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(part);
						//Look if I can get the Eclass from the IdoneContainer
						//And I look if its contain the element we want it to be compared with
						if(desc.getContentArea(part).contains(bounds)) {
							groupParts.add(part);
						}
					}
				}
			}
		}
		return new ArrayList<IGraphicalEditPart>(groupParts);
	}

	/**
	 * Find containers which may be chosen as graphical and as model parent of the element which has already been created
	 * 
	 * @param graphicalParentsToComplete
	 *        an empty list that will be filled with edits part of available graphical parents (e.g. new ArrayList())
	 * @param modelParentsToComplete
	 *        an empty list that will be filled with edits part of available graphical parents (e.g. new ArrayList())
	 * @param childPart
	 *        Edit part of the element we want to find out which may be its containers
	 * @return true if succeed
	 */
	@SuppressWarnings("unchecked")
	public static boolean createComputedListsOfParents(List<IGraphicalEditPart> graphicalParentsToComplete, List<IGraphicalEditPart> modelParentsToComplete, IGraphicalEditPart childPart) {
		Collection<View> diagramViews = new ArrayList<View>(childPart.getViewer().getEditPartRegistry().keySet());
		diagramViews.remove(childPart.getModel());
		Rectangle bounds = null;
		EClass childType = null;
		if(childPart != null) {
			bounds = childPart.getFigure().getBounds();
			childType = ((View)childPart.getModel()).eClass();
		}

		return createComputedListsOfParents(graphicalParentsToComplete, modelParentsToComplete, bounds, childType, diagramViews, childPart);
	}

	/**
	 * Find containers which may be chosen as graphical and as model parent of the element to create
	 * 
	 * @param graphicalParentsToComplete
	 *        an empty list that will be filled with edits part of available graphical parents (e.g. new ArrayList())
	 * @param modelParentsToComplete
	 *        an empty list that will be filled with edits part of available graphical parents (e.g. new ArrayList())
	 * @param creationRequest
	 *        request of creation
	 * @param anyPart
	 *        An edit part to get the viewer
	 * @param child
	 *        The EClass of the element to create
	 * @param elementName
	 *        Name of the element to be created (name used to look for default size FIXME)
	 * @return true if succeed
	 */
	@SuppressWarnings("unchecked")
	public static boolean createComputedListsOfParents(List<IGraphicalEditPart> graphicalParentsToComplete, List<IGraphicalEditPart> modelParentsToComplete, CreateViewAndElementRequest creationRequest, IGraphicalEditPart anyPart, EClass child, String ElementTypeName) {
		Collection<View> diagramViews = new ArrayList<View>(anyPart.getViewer().getEditPartRegistry().keySet());
		Dimension size = creationRequest.getSize();
		//FIXME : Add a correct default size
		// If size == null then a default size is used to create the bounds of the new elements
		if(size == null || size.isEmpty()) {
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			String prefWidthName = PreferenceConstantHelper.getElementConstant(ElementTypeName, PreferenceConstantHelper.WIDTH);
			String prefHeightName = PreferenceConstantHelper.getElementConstant(ElementTypeName, PreferenceConstantHelper.HEIGHT);
			int width = store.getInt(prefWidthName);
			int height = store.getInt(prefHeightName);
			size = new Dimension(width, height);
		}
		Rectangle bounds = new Rectangle(creationRequest.getLocation(), size);
		return createComputedListsOfParents(graphicalParentsToComplete, modelParentsToComplete, bounds, child, diagramViews, anyPart);
	}

	/**
	 * Find containers which may be chosen as graphical and as model parent of the element to create
	 * 
	 * @param graphicalParentsToComplete
	 *        an empty list that will be filled with edits part of available graphical parents (e.g. new ArrayList())
	 * @param modelParentsToComplete
	 *        an empty list that will be filled with edits part of available model parents e.g. new ArrayList())
	 * @param request
	 *        createElementRequest of the current request
	 * @param anyPart
	 *        an edit part of the diagram to get the viewer
	 * @return true if successful
	 */
	private static boolean createComputedListsOfParents(List<IGraphicalEditPart> graphicalParentsToComplete, List<IGraphicalEditPart> modelParentsToComplete, Rectangle bounds, EClass child, Collection<View> views, IGraphicalEditPart anyPart) {
		if(views.isEmpty()) {
			return false;
		}
		for(Object view : views) {
			if(view instanceof View) {
				Object editpart = anyPart.getViewer().getEditPartRegistry().get(view);
				if(editpart instanceof IGraphicalEditPart) {
					IGraphicalEditPart part = (IGraphicalEditPart)editpart;
					if(GroupContainmentRegistry.isContainerConcerned(part)) {
						AbstractContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(part);
						//Check if the current part contains the element
						if(desc.getContentArea(part).contains(bounds)) {
							if(child instanceof EClass) {
								if(desc.canIBeModelParentOf(child)) {
									// If an edit part can be a model parent then is also a possible graphical parent
									graphicalParentsToComplete.add(part);
									modelParentsToComplete.add(part);
								} else {
									if(desc.canIBeGraphicalParentOf(child)) {
										graphicalParentsToComplete.add(part);
									}
								}
							}
						}
					}
				}
			}
		}
		//Try to reduce the number of available parents by removing
		if(graphicalParentsToComplete.size() > 1)
			withdrawUselessElements(graphicalParentsToComplete, GraphicalAndModelElementComparator.graphicalAndModel);
		if(modelParentsToComplete.size() > 1)
			withdrawUselessElements(modelParentsToComplete, GraphicalAndModelElementComparator.model);
		//FIXME Sort the two list in order to have the most relevant parent first (lowest surface )
		return true;
	}

	private static boolean withdrawUselessElements(List<IGraphicalEditPart> listToModify, int mode) {
		GraphicalAndModelElementComparator comparator = new GraphicalAndModelElementComparator();
		//Select the comparator mode
		if(mode == GraphicalAndModelElementComparator.model || mode == GraphicalAndModelElementComparator.graphicalAndModel) {
			comparator.setMode(mode);
		} else {
			return false;
		}
		/**
		 * Keep in the list only elements which which have no smaller element ( with this comparator)
		 * 
		 */
		for(int element = 0; element < listToModify.size(); element++) {
			for(int elementToCompare = element + 1; elementToCompare < listToModify.size(); elementToCompare++) {
				int compare = comparator.compare((IGraphicalEditPart)listToModify.get(element), (IGraphicalEditPart)listToModify.get(elementToCompare));
				if(compare < 0) {
					listToModify.remove(element);
					element--;
					elementToCompare = listToModify.size();

				} else if(compare > 0) {
					listToModify.remove(elementToCompare);
					elementToCompare--;
				}
			}
		}
		return true;

	}

	/**
	 * Find the children edit parts which may be contained by the group in the given bounds.
	 * 
	 * @param contentArea
	 *        the new or old content area the group
	 * @param groupEditPart
	 *        the group edit part
	 * @param diagramPart
	 *        the diagram edit part
	 * @return the list of edit parts that are within the given bounds and which element can be children according to the group framework
	 */
	public static List<IGraphicalEditPart> findPossibleChildren(Rectangle contentArea, IGraphicalEditPart groupEditPart, DiagramEditPart diagramPart) {
		AbstractContainerNodeDescriptor descriptor = GroupContainmentRegistry.getContainerDescriptor(groupEditPart);
		if(diagramPart == null || descriptor == null) {
			return Collections.emptyList();
		}
		Set<IGraphicalEditPart> groupParts = new HashSet<IGraphicalEditPart>();
		for(Object view : diagramPart.getViewer().getEditPartRegistry().keySet()) {
			if(view instanceof View) {
				Object editpart = diagramPart.getViewer().getEditPartRegistry().get(view);
				if(editpart instanceof IGraphicalEditPart && editpart instanceof IPrimaryEditPart && !groupEditPart.equals(editpart)) {
					IGraphicalEditPart part = (IGraphicalEditPart)editpart;
					// check bounds
					boolean boundsOK = false;
					if(groupEditPart.getChildren().contains(editpart)) {
						// graphically contained part will follow the move.
						boundsOK = true;
					} else {
						Rectangle figBounds = part.getFigure().getBounds().getCopy();
						part.getFigure().translateToAbsolute(figBounds);
						if(contentArea.contains(figBounds)) {
							boundsOK = true;
						}
					}
					if(boundsOK) {
						// check group can contain
						EObject child = part.resolveSemanticElement();
						for(EReference refToChildren : descriptor.getChildrenReferences()) {
							if(refToChildren.getEReferenceType().isInstance(child)) {
								groupParts.add(part);
								break;
							}
						}
					}
				}
			}
		}
		return new ArrayList<IGraphicalEditPart>(groupParts);
	}

	// Debug purpose
	public static void drawRect(IGraphicalEditPart editPart, Rectangle refContentArea) {
		RoundedRectangle rectFeedback = new RoundedRectangle();
		rectFeedback.setBounds(refContentArea);
		rectFeedback.setCornerDimensions(new Dimension(0, 0));
		rectFeedback.setLineWidth(2);
		rectFeedback.setLineStyle(Graphics.LINE_DASH);
		rectFeedback.setForegroundColor(editPart.getFigure().getForegroundColor());
		rectFeedback.setOpaque(true);
		rectFeedback.setFill(false);

		IFigure layer = LayerManager.Helper.find(editPart).getLayer(LayerConstants.FEEDBACK_LAYER);
		layer.add(rectFeedback);
	}

	/**
	 * Get the command to change the graphical parent of an element
	 * 
	 * @param childPart
	 *        the child edit part to change parent
	 * @param newParent
	 *        the new graphical parent
	 * @return the command or null if no effect
	 */
	public static Command getUpdateGraphicalParentCmd(IGraphicalEditPart childPart, IGraphicalEditPart newParent) {
		if(childPart.getParent().equals(newParent)) {
			return null;
		}
		ChangeBoundsRequest request = new ChangeBoundsRequest();
		request.setMoveDelta(new Point(0, 0));
		request.setSizeDelta(new Dimension(0, 0));
		request.setEditParts(childPart);
		Point loc = childPart.getFigure().getBounds().getLocation().getCopy();
		childPart.getFigure().translateToAbsolute(loc);
		request.setLocation(loc);
		request.setType(RequestConstants.REQ_DROP);
		org.eclipse.gef.commands.Command cmd = newParent.getCommand(request);
		if(cmd != null && cmd.canExecute()) {
			return new GEFtoEMFCommandWrapper(cmd);
		} else {
			return null;
		}
	}

	/**
	 * Get the command to add a reference from a parent group edit part to its new child
	 * 
	 * @param newParentpart
	 *        the new parent edit part which contains children by reference
	 * @param newChildPart
	 *        the child edit part
	 * @return the command or null
	 */
	public static Command getAddReferenceToChildCmd(IGraphicalEditPart newParentpart, IGraphicalEditPart newChildPart) {
		AbstractContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(newParentpart);
		EObject parent = newParentpart.resolveSemanticElement();
		EObject child = newChildPart.resolveSemanticElement();
		// get the better child reference to use
		EReference usedReference = getBestReferenceAmongList(desc.getChildrenReferences(), child);
		if(usedReference != null) {
			return new AddCommand(newParentpart.getEditingDomain(), parent, usedReference, child);
		} else {
			// no possible child reference
			return null;
		}
	}

	/**
	 * Get the best reference (nearest to child's type) to a child among the list
	 * 
	 * @param childrenReferences
	 *        the possible children references
	 * @param child
	 *        the child eobject to choose a referencefor
	 * @return the most precise child reference or null
	 */
	public static EReference getBestReferenceAmongList(List<EReference> childrenReferences, EObject child) {
		EReference usedReference = null;
		for(EReference ref : childrenReferences) {
			if(ref.getEReferenceType().isInstance(child)) {
				if(usedReference == null || ref.getEReferenceType().getEAllSuperTypes().contains(usedReference.getEReferenceType())) {
					// the ref feature is more precise than the previously selected one. Use it instead.
					usedReference = ref;
				}
			}
		}
		return usedReference;
	}

	/**
	 * Get the command to remove a reference from a parent group edit part to its old child
	 * 
	 * @param oldParentpart
	 *        the old parent edit part which contains children by reference
	 * @param oldChildPart
	 *        the child edit part
	 * @return the command or null
	 */
	public static Command getRemoveReferenceToChildCmd(IGraphicalEditPart oldParentpart, IGraphicalEditPart oldChildPart) {
		AbstractContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(oldParentpart);
		EObject parent = oldParentpart.resolveSemanticElement();
		EObject child = oldChildPart.resolveSemanticElement();
		CompoundCommand globalCmd = new CompoundCommand();
		// get the better child reference to use
		EReference usedReference = null;
		for(EReference ref : desc.getChildrenReferences()) {
			if(parent.eGet(ref) instanceof List<?>) {
				if(((List<?>)parent.eGet(ref)).contains(child)) {
					// remove the reference to the child
					Command cmd = new RemoveCommand(oldParentpart.getEditingDomain(), parent, usedReference, child);
					if(cmd.canExecute()) {
						globalCmd.append(cmd);
					}
				}
			}
		}
		if(!globalCmd.isEmpty()) {
			return globalCmd;
		} else {
			return null;
		}
	}

	/**
	 * Construct a map ready to use for ChooseContainedElementsCreator, which indicate children selection state for a group
	 * 
	 * @param group
	 *        the parent group
	 * @param children
	 *        the group children
	 * @return the selection map of children
	 */
	public static Map<IGraphicalEditPart, ChildSelection> contructSelectionMapForGroupChildren(IGraphicalEditPart group, List<IGraphicalEditPart> children) {
		Map<IGraphicalEditPart, ChildSelection> map = new HashMap<IGraphicalEditPart, ChildSelection>(children.size());
		for(IGraphicalEditPart child : children) {
			IGraphicalEditPart oldGraphicalContainer = (IGraphicalEditPart)child.getParent();
			if(!GroupContainmentRegistry.isContainerConcerned(oldGraphicalContainer)) {
				/*
				 * The child is not handled by any group yet :
				 * the group becomes the new parent if it is a model container,
				 * otherwise, the user can decide
				 */
				if(GroupContainmentRegistry.isContainerModel(group)) {
					map.put(child, ChildSelection.ALWAYS_SELECTED);
				} else {
					map.put(child, ChildSelection.SELECTED);
				}
			} else if(group.equals(oldGraphicalContainer)) {
				// Child is already in the group, keep it
				map.put(child, ChildSelection.ALWAYS_SELECTED);
			} else {
				// Child is in another group, let the user decide to take it
				map.put(child, ChildSelection.NOT_SELECTED);
			}
		}
		return map;
	}

	/**
	 * Get the bounds of an edit part
	 * 
	 * @param part
	 *        edit part to find bounds
	 * @return part's bounds in absolute coordinates
	 */
	public static Rectangle getAbsoluteBounds(IGraphicalEditPart part) {
		// take bounds from figure
		Rectangle bounds = part.getFigure().getBounds().getCopy();

		if(part.getNotationView() instanceof Node) {
			// rather update with up to date model bounds
			Node node = (Node)part.getNotationView();
			LayoutConstraint cst = node.getLayoutConstraint();
			if(cst instanceof Bounds) {
				Bounds b = (Bounds)cst;
				Point parentLoc = part.getFigure().getParent().getBounds().getLocation();
				if(b.getX() > 0) {
					bounds.x = b.getX() + parentLoc.x;
				}
				if(b.getY() > 0) {
					bounds.y = b.getY() + parentLoc.y;
				}
				if(b.getHeight() != -1) {
					bounds.height = b.getHeight();
				}
				if(b.getWidth() != -1) {
					bounds.width = b.getWidth();
				}
			}
		}

		part.getFigure().getParent().translateToAbsolute(bounds);
		return bounds;
	}
}
