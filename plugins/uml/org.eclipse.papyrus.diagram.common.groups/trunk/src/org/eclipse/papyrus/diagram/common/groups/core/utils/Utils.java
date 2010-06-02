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
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseContainedElementsCreator.ChildSelection;
import org.eclipse.papyrus.diagram.common.groups.groupcontainment.IContainerNodeDescriptor;

/**
 * This class provides utility methods useful for the group framework.
 * 
 * @author vhemery
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
		for(Object view : diagramPart.getViewer().getEditPartRegistry().keySet()) {
			if(view instanceof View) {
				Object editpart = diagramPart.getViewer().getEditPartRegistry().get(view);
				if(editpart instanceof IGraphicalEditPart) {
					IGraphicalEditPart part = (IGraphicalEditPart)editpart;
					if(GroupContainmentRegistry.isContainerConcerned(part)) {
						IContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(part);
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
		if(diagramPart == null) {
			return Collections.emptyList();
		}
		IContainerNodeDescriptor descriptor = GroupContainmentRegistry.getContainerDescriptor(groupEditPart);
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
		request.setType(RequestConstants.REQ_DROP);
		org.eclipse.gef.commands.Command cmd = newParent.getCommand(request);
		return new GEFtoEMFCommandWrapper(cmd);
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
		IContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(newParentpart);
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
	 * @return
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
		IContainerNodeDescriptor desc = GroupContainmentRegistry.getContainerDescriptor(oldParentpart);
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
}
