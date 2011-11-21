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
package org.eclipse.papyrus.uml.diagram.common.groups.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Status;
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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.uml.diagram.common.groups.groupcontainment.AbstractContainerNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.common.groups.utils.GraphicalAndModelElementComparator;
import org.eclipse.papyrus.uml.diagram.common.groups.utils.GraphicalAndModelElementComparator.Mode;


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
	 * @param doTransalte
	 *        if true compute the list of all graphical and model parent after moving and false compute the list before moving
	 * @return true if succeed
	 */
	@SuppressWarnings("unchecked")
	public static boolean createComputedListsOfParents(List<IGraphicalEditPart> graphicalParentsToComplete, List<IGraphicalEditPart> modelParentsToComplete, IGraphicalEditPart childPart, ChangeBoundsRequest request, boolean doTransalte) {
		Collection<View> diagramViews = new ArrayList<View>(childPart.getViewer().getEditPartRegistry().keySet());
		Object _elementView = childPart.getModel();
		if(_elementView instanceof View) {
			diagramViews.remove(_elementView);
			View myGroupView = (View)_elementView;
			withdrawGraphicalSonsOf(diagramViews, myGroupView);
		}
		Rectangle bounds = null;
		EClass childType = null;
		if(childPart != null) {
			bounds = Utils.getAbsoluteBounds(childPart).getCopy();
			childType = childPart.resolveSemanticElement().eClass();
		}
		if(doTransalte) {
			bounds = request.getTransformedRectangle(bounds);
		}
		return createComputedListsOfParents(graphicalParentsToComplete, modelParentsToComplete, bounds, childType, diagramViews, childPart);
	}

	/**
	 * Find containers which may be chosen as graphical and as model parent of the element (after creation)
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
	public static boolean createComputedListsOfParents(List<IGraphicalEditPart> graphicalParentsToComplete, List<IGraphicalEditPart> modelParentsToComplete, CreateViewAndElementRequest creationRequest, IGraphicalEditPart anyPart, EClass child) {
		Collection<View> diagramViews = new ArrayList<View>(anyPart.getViewer().getEditPartRegistry().keySet());
		Dimension size = creationRequest.getSize();
		//FIXME : Add a correct default size
		// If size == null then a default size is used to create the bounds of the new elements
		if(size == null || size.isEmpty()) {
			size = new Dimension(0, 0);
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
	 * @param bounds
	 *        Bounds of the element
	 * @param request
	 *        createElementRequest of the current request
	 * @param views
	 *        Collection of view to iteration on
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
						//FIXME replace this piece of code by isItVisualyContained
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
			withdrawUselessAncestorsElements(graphicalParentsToComplete, Mode.GRAPHICAL_AND_MODEL);
		if(modelParentsToComplete.size() > 1)
			withdrawUselessAncestorsElements(modelParentsToComplete, Mode.MODEL);
		//FIXME Sort the two list in order to have the most relevant parent first (lowest surface )
		return true;
	}

	/**
	 * This method complete the list childsToComplete to add element which are visually contained in the element in creation "parent" and which can
	 * be graphical children of this new elements
	 * 
	 * @param childsToComplete
	 *        Empty list which will contain in the newly created element "parent" and which can be graphical children of this new elements
	 * @param creationRequest
	 *        request of creation
	 * @param anyPart
	 *        An edit part to get the viewer
	 * @param descriptor
	 *        Descriptor of the element in creation
	 * @param ElementTypeName
	 *        Name of the element to be created (name used to look for default size FIXME)
	 * @return true if succeed
	 */
	public static boolean createComputedListsOfVisualYRelatedElements(List<IGraphicalEditPart> childsToComplete, CreateViewAndElementRequest creationRequest, IGraphicalEditPart anyPart, AbstractContainerNodeDescriptor descriptor) {
		Collection<View> diagramViews = new ArrayList<View>(anyPart.getViewer().getEditPartRegistry().keySet());
		Dimension size = creationRequest.getSize();
		//FIXME : Add a correct default size
		// If size == null then a default size is used to create the bounds of the new elements
		if(size == null || size.isEmpty()) {
			size = new Dimension(0, 0);
		}
		Rectangle bounds = new Rectangle(creationRequest.getLocation(), size);
		createComputedListsOfVisualyRelatedElements(childsToComplete, bounds, descriptor, diagramViews, anyPart);
		return true;
	}

	/**
	 * This method complete the list childsToComplete to add element which are visually contained in the element which is moving ("parent") and which
	 * can
	 * be graphical children of this new elements
	 * 
	 * @param childsToComplete
	 *        Empty list which will contain in the newly created element "parent" and which can be graphical children of this new elements
	 * @param request
	 *        {@link ChangeBoundsRequest}
	 * @param parentPart
	 *        {@link IGraphicalEditPart} of the parent
	 * @param descriptor
	 *        {@link AbstractContainerNodeDescriptor} of the parent
	 * @return true is succeed
	 */
	public static boolean createComputedListsOfVisuallyRelatedElements(List<IGraphicalEditPart> childsToComplete, ChangeBoundsRequest request, IGraphicalEditPart parentPart, AbstractContainerNodeDescriptor descriptor, boolean doTransalte) {
		Collection<View> diagramViews = new ArrayList<View>(parentPart.getViewer().getEditPartRegistry().keySet());
		diagramViews.remove(parentPart.getModel());
		Rectangle bounds = null;

		IGraphicalEditPart compartmentEditPart = (IGraphicalEditPart)Utils.getCompartementEditPartFromMainEditPart(parentPart.getViewer().getEditPartRegistry(), parentPart);
		if(compartmentEditPart == null) {
			compartmentEditPart = parentPart;
		}
		if(parentPart != null) {
			bounds = Utils.getAbsoluteBounds(compartmentEditPart).getCopy();
		}
		if(doTransalte) {
			//bounds.translate(request.getMoveDelta());
			bounds = request.getTransformedRectangle(bounds);
		}
		createComputedListsOfVisualyRelatedElements(childsToComplete, bounds, descriptor, diagramViews, parentPart);
		return true;
	}

	/***
	 * Compute a list of all group which include the bounds of my element which has been moved with the following request
	 * 
	 * @param element
	 *        Element which we can know the groups which it intersect
	 * @param request
	 *        {@link ChangeBoundsRequest} of the moving group
	 * @param doTranslate
	 *        if true translate the bound of the element. (used to find the difference between element before and after the command)
	 * @return The list of {@link IGraphicalEditPart} group that which has their compartment edit part which intersect the compartment of my
	 */
	public static List<IGraphicalEditPart> createComputeListsOfAllGroupContainerVisually(IGraphicalEditPart element, ChangeBoundsRequest request, boolean doTranslate, IGraphicalEditPart movingParent) {
		List<IGraphicalEditPart> result = new ArrayList<IGraphicalEditPart>();
		EditPartViewer viewer = element.getViewer();
		Map editPartRegistry = null;
		if(viewer != null) {
			editPartRegistry = viewer.getEditPartRegistry();
		}
		// Test on entrances
		if(editPartRegistry == null || element == null) {
			return null;
		}
		//Get the compartment edit part
		IGraphicalEditPart myCompartmentEditPart = (IGraphicalEditPart)getCompartementEditPartFromMainEditPart(editPartRegistry, element);
		Rectangle myBounds = null;
		/*
		 * Find the bounds of the compartment if none use the figure bounds
		 */
		if(myCompartmentEditPart != null) {
			myBounds = getAbsoluteBounds(myCompartmentEditPart).getCopy();
		} else {
			myBounds = getAbsoluteBounds(element).getCopy();
		}
		/*
		 * If use the translated figure use as bounds for the childs its bounds translated with the delta move
		 */
		if(doTranslate) {
			myBounds = myBounds.translate(request.getMoveDelta());
		}

		Collection<View> diagramViews = new ArrayList<View>(editPartRegistry.keySet());
		Object _elementView = element.getModel();
		diagramViews.remove(_elementView);
		/*
		 * Withdraw from the collection of element all elements which are graphical child in myGroupView
		 */
		if(_elementView instanceof View) {
			View myGroupView = (View)_elementView;
			withdrawGraphicalSonsOf(diagramViews, myGroupView);
		}

		/*
		 * For all graphical edits parts try to know if it visually contained the child
		 */
		for(Object view : diagramViews) {
			if(view instanceof View) {
				Object editpart = editPartRegistry.get(view);
				if(editpart instanceof IGraphicalEditPart) {
					IGraphicalEditPart part = (IGraphicalEditPart)editpart;
					IGraphicalEditPart partCompartment = (IGraphicalEditPart)getCompartementEditPartFromMainEditPart(editPartRegistry, part);
					if(GroupContainmentRegistry.isContainerConcerned(part) && partCompartment != null) {
						Rectangle partBounds = getAbsoluteBounds(partCompartment);
						if((part.getParent().equals(movingParent) || partCompartment.equals(movingParent)) && doTranslate) {
							partBounds = request.getTransformedRectangle(partBounds);
						}
						if(partBounds.contains(myBounds)) {
							result.add(part);
						}
					}
				}
			}
		}


		return result;
	}

	/**
	 * Function which withdraw from a list of view all view which are descendant of the myView parameter
	 * (This function is called recursively
	 * 
	 * @param views
	 *        List of the view
	 * @param myView
	 *        The view we want to remove the descendant
	 */
	private static void withdrawGraphicalSonsOf(Collection<View> views, View myView) {
		for(Object o : myView.getChildren()) {
			if(o instanceof View) {
				View childView = (View)o;
				withdrawGraphicalSonsOf(views, childView);
				views.remove(childView);
			}

		}
	}

	/**
	 * Find containers which may be chosen as graphical and as model parent of the element
	 * 
	 * @param childsToComplete
	 *        Empty list which will contain in the newly created element "parent" and which can be graphical children of this new elements
	 * @param parentsBounds
	 *        Bounds of the element
	 * @param descriptors
	 *        Descriptor of the element in creation
	 * @param views
	 *        Collection of view to iteration on
	 * @param anyPart
	 *        an edit part of the diagram to get the viewer
	 * @return true if succeed
	 */
	private static boolean createComputedListsOfVisualyRelatedElements(List<IGraphicalEditPart> childsToComplete, Rectangle parentsBounds, AbstractContainerNodeDescriptor descriptor, Collection<View> views, IGraphicalEditPart anyPart) {
		/*
		 * 1 - Compute the EClass(s) which the element can be parent of : listEclass
		 * 2 - Iterate on views : v
		 * 2.1 - If v correspond to a main editPart : part
		 * 2.1.1 - If v correspond to a a EClass which belong to listEclass
		 * 2.1.1.1 - If part is visually contained is the parent then add to the list
		 * 3 - Withdraw useless elements
		 */
		//Set<AbstractContainerNodeDescriptor> descriptors = GroupContainmentRegistry.getDescriptorsWithContainerEClass(parentEclass);
		List<EClass> possibleChildrenEClass = new ArrayList<EClass>(descriptor.getPossibleGraphicalChildren());
		if(!possibleChildrenEClass.isEmpty()) {
			for(Object view : views) {
				if(view instanceof View) {
					View childView = (View)view;
					EObject element = childView.getElement();
					if(element != null) {
						EClass childEclass = (element.eClass());
						Object editpart = anyPart.getViewer().getEditPartRegistry().get(childView);
						if(editpart instanceof IGraphicalEditPart) {
							IGraphicalEditPart part = (IGraphicalEditPart)editpart;
							if(isMainEditPart(part)) {
								for(EClass possibleChild : possibleChildrenEClass) {
									if(possibleChild.isSuperTypeOf(childEclass)) {
										if(isItVisualyContained(parentsBounds, part)) {
											childsToComplete.add(part);
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			if(childsToComplete.size() > 1)
				withdrawUselessDescendantElements(childsToComplete, Mode.GRAPHICAL_AND_MODEL);
		}

		return true;
	}

	/**
	 * This methods is used to know if an edit part is contained in a rectangle
	 * 
	 * @param parentBounds
	 *        Rectangle of the parent
	 * @param child
	 *        IGraphicalEditPart of the element we want to test
	 * @return true if the bounds of child are contained in parentsBounds
	 */
	private static boolean isItVisualyContained(Rectangle parentBounds, IGraphicalEditPart child) {

		if(child.getParent() instanceof IGraphicalEditPart) {
			// an edit part is considered the "main" edit part of an element if it is not contained in an edit part of the same element (e.g. not a label nor a compartment)
			//			Rectangle bounds = child.getFigure().getBounds().getCopy();
			//			
			//			((IGraphicalEditPart)child.getParent()).getFigure().translateToAbsolute(bounds);

			Rectangle bounds = Utils.getAbsoluteBounds(child);
			if(bounds != null) {
				if(parentBounds.contains(bounds)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return true if the edit part is the main editPart of a model element (e.g the label is not the main edit part of an activityPartition
	 * 
	 * @param part
	 *        IGraphicalEditPart to test
	 * @return
	 */
	public static boolean isMainEditPart(IGraphicalEditPart part) {
		EObject currentElement = part.resolveSemanticElement();
		EditPart parentEditPart = part.getParent();
		if(parentEditPart instanceof IGraphicalEditPart) {
			return !currentElement.equals(((IGraphicalEditPart)parentEditPart).resolveSemanticElement());
		} else {
			return true;
		}
	}

	/**
	 * This method remove all elements from the list which have a parent in the (graphical model) or model in the list
	 * 
	 * @param listToModify
	 *        List of elements (IGraphicalEditPart
	 * @param mode
	 *        if GraphicalAndModelElementComparator.MODEL then it only take care of model parent if
	 *        GraphicalAndModelElementComparator.GRAPHICAL_AND_MODEL it take care of graphical and logical relationship
	 * @return true if succeed
	 */
	private static void withdrawUselessAncestorsElements(List<IGraphicalEditPart> listToModify, Mode mode) {
		if(!listToModify.isEmpty()) {

			GraphicalAndModelElementComparator comparator = new GraphicalAndModelElementComparator(listToModify.get(0));
			//Select the comparator mode

			comparator.setMode(mode);

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
		}
	}

	/**
	 * This method will withdraw all EObject directly referenced by object which are also referenced by one of its parents (parent by reference and
	 * parent by containment)
	 * 
	 * @param object
	 */
	public static void withDrawRedundantElementReferenced(EObject object) {
		/*
		 * Algo :
		 * 1 - Select all references which are Group Framework concerned and which represent a reference to a parent
		 * 2 - Create a Set directlyReferencedByElement of EObject directly referenced by object
		 * 3 - Iterate thought parents to see if one of them also point at an element of directlyReferencedByElement
		 */
		/*
		 * 1 - Select all references which are Group Framework concerned and which represent a reference to a parent
		 */
		Set<EReference> groupFrameworkReferences = GroupContainmentRegistry.getAllERefencesFromNodeToGroup();
		HashMap<EObject, EReference> referencingGroupsAndTheirRelation = new HashMap<EObject, EReference>();
		Set<EObject> elementToVosit = new HashSet<EObject>();
		for(EReference ref : groupFrameworkReferences) {
			if(object.eClass().getEAllReferences().contains(ref)) {
				// list of groups containing the object
				List<EObject> groups;
				if(ref.isMany()) {
					groups = (List<EObject>)object.eGet(ref);
				} else {
					groups = Collections.singletonList((EObject)object.eGet(ref));
				}
				if(!ref.isContainment()) {
					/*
					 * 2 - Create a Set directlyReferencedByElement of EObject directly referenced by object
					 */
					for(EObject element : groups) {
						if(!referencingGroupsAndTheirRelation.containsKey(element) && !ref.isDerived()) {
							referencingGroupsAndTheirRelation.put(element, ref);
						}
					}
				}
				for(EObject group : groups) {
					if(group != null) {
						elementToVosit.add(group);
					}
				}
			}
		}
		Set<EObject> elementAlreadyVisited = new HashSet<EObject>();
		for(EObject visitingElement : elementToVosit) {
			withDrawRedundantElementReferenced(object, groupFrameworkReferences, referencingGroupsAndTheirRelation, elementAlreadyVisited, visitingElement);
		}
	}

	/**
	 * This method will withdraw all EObject directly referenced by object which are also referenced by one of its parents (parent by reference and
	 * parent by containment). This method is called recursively
	 * 
	 * @param originalEObject
	 *        The EObject on which you want to check the reference
	 * @param groupFrameworkReferences
	 *        All the EReference which are used on the groupFramework and which represent a relation from a element to its parent
	 * @param directlyReferencedByElement
	 *        Set of elements which are directly referenced by the original element
	 * @param elementAlreadyVisited
	 *        Set of element already visited. Used to avoid infinite loop
	 * @param visitingElement
	 *        The current element which is being visited
	 */
	private static void withDrawRedundantElementReferenced(EObject originalEObject, Set<EReference> groupFrameworkReferences, Map<EObject, EReference> directlyReferencedByElement, Set<EObject> elementAlreadyVisited, EObject visitingElement) {
		if(visitingElement != null) {
			elementAlreadyVisited.add(visitingElement);
			for(EReference ref : groupFrameworkReferences) {
				if(visitingElement != null) {
					if(visitingElement.eClass().getEAllReferences().contains(ref)) {
						List<EObject> groups;
						if(ref.isMany()) {
							groups = (List<EObject>)visitingElement.eGet(ref);
						} else {
							groups = Collections.singletonList((EObject)visitingElement.eGet(ref));
						}
						for(EObject currentElementParentGroup : groups) {
							//If it belong to the directly referenced element then
							if(directlyReferencedByElement.containsKey(currentElementParentGroup)) {
								withdrawEObjectFromReference(originalEObject, currentElementParentGroup, directlyReferencedByElement.get(currentElementParentGroup));
								// parents already handled in the first recursion (as direct parent group)
							} else if(elementAlreadyVisited.contains(currentElementParentGroup)) {
								// element already met, avoid infinite loop
								org.eclipse.papyrus.uml.diagram.common.groups.Activator.getDefault().getLog().log(new Status(Status.WARNING, org.eclipse.papyrus.uml.diagram.common.groups.Activator.PLUGIN_ID, "There is a circle element reference"));
							} else {
								//else iterate recursively also on this group's parents
								withDrawRedundantElementReferenced(originalEObject, groupFrameworkReferences, directlyReferencedByElement, elementAlreadyVisited, currentElementParentGroup);
								//elementToVosit.add(currentCompareElement);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * This method is used to with an element of a reference
	 * 
	 * @param source
	 *        EObject from which the reference start
	 * @param destination
	 *        EObject to which the reference start
	 * @param ref
	 *        EReference
	 */
	private static void withdrawEObjectFromReference(EObject source, EObject destination, EReference ref) {
		if(ref != null && source != null && destination != null) {
			if(ref != null && ref.isMany()) {
				Collection<EObject> collection = (Collection<EObject>)source.eGet(ref);
				if(collection.contains(destination)) {
					collection.remove(destination);
				}
			} else if(ref != null && !ref.isMany()) {
				source.eUnset(ref);
			}
		}
	}

	/**
	 * This method remove all elements from the list which have a descendant in the (graphical model) or model in the list
	 * 
	 * @param listToModify
	 *        List of elements (IGraphicalEditPart
	 * @param mode
	 *        if GraphicalAndModelElementComparator.MODEL then it only take care of model parent if
	 *        GraphicalAndModelElementComparator.GRAPHICAL_AND_MODEL it take care of graphical and logical relationship
	 * @return true if succeed
	 */
	private static boolean withdrawUselessDescendantElements(List<IGraphicalEditPart> listToModify, Mode mode) {

		if(!listToModify.isEmpty()) {

			GraphicalAndModelElementComparator comparator = new GraphicalAndModelElementComparator(listToModify.get(0));
			//Select the comparator mode
			comparator.setMode(mode);
			for(int element = 0; element < listToModify.size(); element++) {
				for(int elementToCompare = element + 1; elementToCompare < listToModify.size(); elementToCompare++) {
					int compare = comparator.compare((IGraphicalEditPart)listToModify.get(element), (IGraphicalEditPart)listToModify.get(elementToCompare));
					if(compare > 0) {
						listToModify.remove(element);
						element--;
						elementToCompare = listToModify.size();

					} else if(compare < 0) {
						listToModify.remove(elementToCompare);
						elementToCompare--;
					}
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
	 * Get the bounds of an edit part
	 * 
	 * @param part
	 *        edit part to find bounds
	 * @return part's bounds in absolute coordinates
	 */
	public static Rectangle getAbsoluteBounds(IGraphicalEditPart part) {
		// take bounds from figure
		part.getTopGraphicEditPart().refresh();
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

	/**
	 * This method compute the delta between to IGraphicalEditPart.
	 * 
	 * @param oldParent
	 *        Old IGraphicalEditPart
	 * @param newParent
	 *        New IGraphicalEditPart
	 * @return Return a DDimention between the two bounds (often use to translate point or Rectangle)
	 */
	public static Dimension computeDeltaToChangeParent(IGraphicalEditPart oldParent, IGraphicalEditPart newParent) {
		Rectangle hostBounds = Utils.getAbsoluteBounds(oldParent);
		Rectangle parentBounds = Utils.getAbsoluteBounds(newParent);
		Dimension delta = hostBounds.getLocation().getDifference(parentBounds.getLocation());
		return delta;
	}

	public static Dimension computeDeltaToChangeParent(IGraphicalEditPart oldParent, Rectangle newParent) {
		Rectangle hostBounds = Utils.getAbsoluteBounds(oldParent);
		Dimension delta = hostBounds.getLocation().getDifference(newParent.getLocation());
		return delta;
	}

	/**
	 * Give the reference object which can reference the child for the parent type part
	 * 
	 * @param parentType
	 *        EClass of the parent OBject you want to know the EReference
	 * @param childType
	 *        EClass of the child you want to test
	 * @return null if no reference is found
	 */
	public static EReference getContainmentEReference(EClass parentType, EClass childType) {
		List<EReference> result = new ArrayList<EReference>();
		EReference usedReference = null;
		for(EReference reference : parentType.getEAllContainments()) {
			if(reference.getEReferenceType().isSuperTypeOf(childType) && !reference.isDerived()) {
				result.add(reference);
			}
		}

		//Select the best containment relation
		for(EReference ref : result) {
			if(usedReference == null || ref.getEReferenceType().getEAllSuperTypes().contains(usedReference.getEReferenceType())) {
				// the ref feature is more precise than the previously selected one. Use it instead.
				usedReference = ref;
			}
		}
		return usedReference;
	}

	/**
	 * 
	 * @param editPartRegistry
	 *        Check if the object is contained in the editPartRegistery
	 * @param _child
	 * @return
	 */
	public static boolean isContainedInRegistery(Map editPartRegistry, Object _child) {
		if(_child instanceof IGraphicalEditPart) {
			return editPartRegistry.containsKey(((IGraphicalEditPart)_child).getModel());
		}
		return false;

	}

	/**
	 * Test is the element is a compartment edit part that can be used to create the child
	 * 
	 * @param editPartRegistry
	 * @param _child
	 * @return
	 */
	public static boolean isAGoodCompartementEditPart(Map editPartRegistry, Object _child) {
		return _child instanceof CompartmentEditPart && isContainedInRegistery(editPartRegistry, _child) && ((EditPart)_child) instanceof ShapeCompartmentEditPart;
	}

	/**
	 * Get the compartment editPart from a parent editPart
	 * 
	 * @param editPartRegistry
	 *        EditPartRegistery
	 * @param parentEditPart
	 *        EditPart of the parent
	 * @return the CompartementEditPart and null if not found
	 */
	public static EditPart getCompartementEditPartFromMainEditPart(Map editPartRegistry, EditPart parentEditPart) {
		EditPart resultCompartmentEditPart = null;
		//An edit part has been found
		if(parentEditPart instanceof CompartmentEditPart) {
			resultCompartmentEditPart = parentEditPart;
			return resultCompartmentEditPart;
		} else {
			List<EditPart> potentialCompartementPart = new ArrayList<EditPart>();
			for(Object _child : parentEditPart.getChildren()) {
				if(isAGoodCompartementEditPart(editPartRegistry, _child)) {
					potentialCompartementPart.add((EditPart)_child);
				}
			}
			if(potentialCompartementPart.size() == 1) {
				resultCompartmentEditPart = potentialCompartementPart.get(0);
				return resultCompartmentEditPart;
			} else if(potentialCompartementPart.size() == 1) {
				//FIXME find a correct behavior if several potential CompartementPart  (should normally never be the case)
				resultCompartmentEditPart = potentialCompartementPart.get(0);
				return resultCompartmentEditPart;
			}
		}
		return resultCompartmentEditPart;
	}


	/**
	 * Get the child map needed for {@link ChangeModelParentCommand}
	 * 
	 * @param elementType
	 *        {@link EClass} of the elemnt you want to find the default model parent
	 * @param getHost
	 *        Host of the editPolicy
	 * @param newIgraphicalParent
	 *        {@link IGraphicalEditPart} to complete with the new {@link IGraphicalEditPart} of the defautl model parent
	 * @return
	 */
	public static DefaultModelParent getDefaultModelParent(EClass elementType, IGraphicalEditPart getHost) {
		IGraphicalEditPart hostParent = getHost;

		while(hostParent != null) {
			EObject hostParentElement = hostParent.resolveSemanticElement();
			if(GroupContainmentRegistry.getDescriptorsWithContainerEClass(hostParentElement.eClass()).isEmpty()) {
				for(EReference containmentRelation : hostParentElement.eClass().getEAllContainments()) {
					if(containmentRelation.getEReferenceType().isSuperTypeOf(elementType)) {
						return new DefaultModelParent(hostParent, containmentRelation);
					}
				}
			}
			hostParent = (IGraphicalEditPart)hostParent.getParent();
		}
		return null;
	}

	public static boolean isRequestGroupFrameworkConcerned(ChangeBoundsRequest request) {
		for(Object editPart : request.getEditParts()) {
			if(editPart instanceof IGraphicalEditPart) {
				IGraphicalEditPart iGraphicalEditPart = (IGraphicalEditPart)editPart;
				boolean isNodeConcerned = GroupContainmentRegistry.isNodeConcerned(iGraphicalEditPart);
				boolean isGroupConcerned = GroupContainmentRegistry.isContainerConcerned(iGraphicalEditPart);
				if(isGroupConcerned || isNodeConcerned) {
					return true;
				}
			}
		}
		return false;
	}
}
