/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.helper;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentCircleViewCreateCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CustomCreateContainmentLinkViewCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CustomDropAppliedStereotypeCommand;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.providers.CustomDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;

public class ContainmentHelper extends ElementHelper {

	public static final String CONTAINMENT_CIRCLE_POSITION = "ContainmentCirclePosition";


	/** The Constant CONNECTION_VIEW. */
	public static final String KEY_CONNECTION_VIEW = "connection_view"; //$NON-NLS-1$

	/**
	 * Instantiates a new containment class helper.
	 * 
	 * @param editDomain
	 *        the edit domain
	 */
	public ContainmentHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	/**
	 * Create a containment link view without semantic.
	 * 
	 * @param createConnectionViewRequest
	 *        the create connection view request
	 * @param command
	 *        the command
	 * 
	 * @return the containment element command
	 */
	public Command getCreateContainmentCommand(CreateConnectionViewRequest createConnectionViewRequest, Command command) {
		CompositeCommand compoundCommand = new CompositeCommand("Create Containment");
		IGraphicalEditPart sourceEditPart = (GraphicalEditPart)createConnectionViewRequest.getSourceEditPart();

		View sourceView = (View)sourceEditPart.getModel();
		EditPartViewer editPartViewer = (EditPartViewer)sourceEditPart.getViewer();
		PreferencesHint preferencesHint = sourceEditPart.getDiagramPreferencesHint();

		String linkHint = ((IHintedType)UMLElementTypes.Dependency_4022).getSemanticHint();
		ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022, ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022).getSemanticHint(), sourceEditPart.getDiagramPreferencesHint());
		View targetView = (View)createConnectionViewRequest.getTargetEditPart().getModel();
		IAdaptable targetViewAdapter = new SemanticAdapter(null, targetView);
		IAdaptable circleAdapter = null;
		ContainmentCircleViewCreateCommand circleCommand = null;

		deleteIncomingContainmentLinksFor(compoundCommand, targetView);

		if(ContainmentCircleEditPart.VISUAL_ID == UMLVisualIDRegistry.getVisualID(sourceEditPart.getNotationView())) {
			circleAdapter = new SemanticAdapter(null, sourceEditPart.getNotationView());
			sourceView = (View)sourceEditPart.getParent().getModel();
		} else {
			circleCommand = new ContainmentCircleViewCreateCommand(createConnectionViewRequest, getEditingDomain(), sourceView, editPartViewer, preferencesHint);
			compoundCommand.add(circleCommand);
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), CONTAINMENT_CIRCLE_POSITION, (IAdaptable)circleCommand.getCommandResult().getReturnValue(), createConnectionViewRequest.getLocation());
			compoundCommand.add(setBoundsCommand);

		}


		ICommand dashedLineCmd = new CustomCreateContainmentLinkViewCommand(getEditingDomain(), linkHint, sourceView, circleAdapter, targetViewAdapter, editPartViewer, preferencesHint, viewDescriptor, circleCommand);
		compoundCommand.add(dashedLineCmd);


		return new ICommandProxy(compoundCommand);
	}

	public void deleteIncomingContainmentLinksFor(CompositeCommand cc, View node) {
		for(Object incomingLink : node.getTargetEdges()) {
			Edge nextConnector = (Edge)incomingLink;
			View nextConnectorSource = nextConnector.getSource();
			if(isContainmentLink(nextConnector)) {
				cc.add(new DeleteCommand(getEditingDomain(), nextConnector));
				/* The containment circle node is deleted only if any other link is connected */
				if(isContainmentCircle(nextConnectorSource) && nextConnectorSource.getSourceEdges().size() == 1) {
					// Delete the containment circle
					cc.add(new DeleteCommand(getEditingDomain(), nextConnectorSource));
				}
			}
		}
	}

	public void deleteOutgoingContainmentLinksFor(CompositeCommand cc, View node) {
		for(Object nextChild : node.getVisibleChildren()) {
			View circle = (View)nextChild;
			if(isContainmentCircle(circle)) {
				for(Object next : circle.getSourceEdges()) {
					Edge outgoingLink = (Edge)next;
					if(ContainmentHelper.isContainmentLink(outgoingLink)) {
						cc.add(new DeleteCommand(getEditingDomain(), outgoingLink));
					}
				}
			}
		}

	}

	private CContainmentCircleEditPart findContainmentCircle(IGraphicalEditPart parent) {
		for(Object next : parent.getChildren()) {
			EditPart editPart = (EditPart)next;
			if(editPart instanceof CContainmentCircleEditPart) {
				return (CContainmentCircleEditPart)editPart;
			}
		}
		return null;
	}

	/**
	 * DragDrop the contained class from the outline to the diagram and from the compartment to the diagram.
	 * 
	 * @param droppedElement
	 *        the semantic class
	 * @param viewer
	 *        the viewer
	 * @param diagramPreferencesHint
	 *        the diagram preferences hint
	 * @param location
	 *        the location
	 * @param containerView
	 *        the container view
	 * 
	 * @return the command
	 */
	public Command outlineDropContainedClass(PackageableElement droppedElement, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView) {
		return dropElementToDiagram(droppedElement, viewer, diagramPreferencesHint, location, containerView);
	}

	/**
	 * Drop element to diagram.
	 * 
	 * @param droppedElement
	 *        the dropped element
	 * @param viewer
	 *        the viewer
	 * @param diagramPreferencesHint
	 *        the diagram preferences hint
	 * @param location
	 *        the location
	 * @param containerView
	 *        the container view
	 * @return the command
	 */
	public Command dropElementToDiagram(PackageableElement droppedElement, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView) {
		EditPart droppedElementEditPart = findEditPartFor(viewer.getEditPartRegistry(), droppedElement);
		Element owner = (Element)droppedElement.getOwner();
		GraphicalEditPart droppedParentEditPart = null;
		if(droppedElementEditPart != null) {
			GraphicalEditPart parentEP = (GraphicalEditPart)droppedElementEditPart.getParent();
			if(parentEP.resolveSemanticElement().equals(owner)) {
				droppedParentEditPart = parentEP;
			}
		}

		// if the owner does not exist the link have not to be created or different of the diagram.
		if(droppedParentEditPart == null || droppedParentEditPart instanceof ModelEditPart) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeCommand cc = new CompositeCommand("drop");
		if(droppedElementEditPart == null) {
			dropElementToDiagram(cc, droppedElement, viewer, diagramPreferencesHint, location, containerView, droppedParentEditPart);
		} else {
			if(canHaveContainmentLink(droppedElementEditPart)) {
				cc.add(new DeleteCommand(getEditingDomain(), (View)droppedElementEditPart.getModel()));
				dropElementToDiagram(cc, droppedElement, viewer, diagramPreferencesHint, location, containerView, droppedParentEditPart);
			}
		}
		return new ICommandProxy(cc);
	}

	private void dropElementToDiagram(CompositeCommand cc, PackageableElement droppedElement, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView, GraphicalEditPart droppedOwnerEditPart) {
		ViewDescriptor droppedElementDescriptor = new ViewDescriptor(new EObjectAdapter(droppedElement), Node.class, null, ViewUtil.APPEND, false, diagramPreferencesHint);

		CreateCommand containedNodeCreationCommand = new CreateCommand(this.editDomain, droppedElementDescriptor, containerView);
		cc.add(containedNodeCreationCommand);
		cc.add(new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100)));

		addStereotypeLabelToDroppedElement(cc, droppedElement, (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue());

		//		createContainmentLink(cc, viewer, diagramPreferencesHint, location, droppedOwnerEditPart, droppedElementDescriptor, containedNodeCreationCommand);
	}

	private void createContainmentLink(CompositeCommand cc, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, GraphicalEditPart droppedOwnerEditPart, ViewDescriptor droppedElementDescriptor, CreateCommand containedNodeCreationCommand) {
		CContainmentCircleEditPart containmentCircleEditPart = findContainmentCircle(droppedOwnerEditPart);
		IAdaptable circleAdapter = null;
		if(containmentCircleEditPart != null) {
			circleAdapter = new SemanticAdapter(null, (View)containmentCircleEditPart.getModel());
		} else {
			/* Creation of the containment circle node without semantic element */
			ContainmentCircleViewCreateCommand circleCommand = new ContainmentCircleViewCreateCommand(null, getEditingDomain(), (View)droppedOwnerEditPart.getModel(), (EditPartViewer)droppedOwnerEditPart.getViewer(), droppedElementDescriptor.getPreferencesHint());
			cc.add(circleCommand);
			cc.add(new SetBoundsCommand(getEditingDomain(), CONTAINMENT_CIRCLE_POSITION, (IAdaptable)circleCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100)));
			circleAdapter = (IAdaptable)circleCommand.getCommandResult().getReturnValue();
		}
		ConnectionViewDescriptor linkViewDescriptor = new ConnectionViewDescriptor(org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022, ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022).getSemanticHint(), droppedOwnerEditPart.getDiagramPreferencesHint());
		cc.add(new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Dependency_4022).getSemanticHint(), circleAdapter, (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), viewer, diagramPreferencesHint, linkViewDescriptor, null));
	}

	private void addStereotypeLabelToDroppedElement(CompositeCommand cc, PackageableElement droppedElement, IAdaptable createdEditPartAdapter) {
		if(droppedElement.getAppliedStereotypes().isEmpty()) {
			return;
		}
		EList<Stereotype> stereotypeAppliedList = droppedElement.getAppliedStereotypes();
		Iterator<Stereotype> stereotypeAppliedIterator = stereotypeAppliedList.iterator();
		while(stereotypeAppliedIterator.hasNext()) {
			Stereotype stereotype = (Stereotype)stereotypeAppliedIterator.next();
			String profileApplied = "\"" + stereotype.getProfile() + "\"::";
			cc.add(new CustomDropAppliedStereotypeCommand(this.editDomain, createdEditPartAdapter, profileApplied, VisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION));
		}
	}

	/**
	 * Checks if is reorient containment link.
	 * 
	 * @param request
	 *        the request
	 * @return true, if is reorient containment link
	 */
	public static boolean isReorientContainmentLink(ReconnectRequest request) {
		int visualId = getVisualID(request);
		return visualId == AddedLinkEditPart.VISUAL_ID;
	}

	/**
	 * Extend reorient target request.
	 * 
	 * @param request
	 *        the request
	 * @return the reconnect request
	 */
	public static ReconnectRequest extendReorientTargetRequest(ReconnectRequest request) {
		Object view = request.getConnectionEditPart().getModel();
		if(view instanceof View) {
			request.getExtendedData().put(ContainmentHelper.KEY_CONNECTION_VIEW, view);
		}
		return request;
	}

	/**
	 * Extend reorient source request.
	 * 
	 * @param request
	 *        the request
	 * @return the reconnect request
	 */
	public static ReconnectRequest extendReorientSourceRequest(ReconnectRequest request) {
		Object view = request.getConnectionEditPart().getModel();
		if(view instanceof View) {
			request.getExtendedData().put(ContainmentHelper.KEY_CONNECTION_VIEW, view);
		}
		return request;
	}

	/**
	 * Gets the visual id.
	 * 
	 * @param request
	 *        the request
	 * @return the visual id
	 */
	private static int getVisualID(ReconnectRequest request) {
		Object id = request.getExtendedData().get(UMLBaseItemSemanticEditPolicy.VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer)id).intValue() : -1;
	}

	/**
	 * Checks if is containment link.
	 * 
	 * @param edge
	 *        the edge
	 * @return true, if is containment link
	 */
	public static boolean isContainmentLink(Edge edge) {
		return UMLVisualIDRegistry.getVisualID(edge) == AddedLinkEditPart.VISUAL_ID;
	}

	public static boolean isContainmentCircle(View view) {
		return UMLVisualIDRegistry.getVisualID(view) == ContainmentCircleEditPart.VISUAL_ID;
	}

	private static boolean circleHasOtherLinks(View containmentCircle) {
		return containmentCircle.getSourceEdges().size() > 1;
	}

	/**
	 * Delete incoming containment link command.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param incomingLink
	 *        the incoming link
	 * @return the i undoable operation
	 */
	public static IUndoableOperation deleteIncomingContainmentLinkCommand(TransactionalEditingDomain editingDomain, Edge incomingLink) {
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(editingDomain, "Delete Incoming Containment Link");
		cmd.add(new DeleteCommand(editingDomain, incomingLink));
		View containmentCircle = incomingLink.getSource();
		if(!circleHasOtherLinks(containmentCircle)) {
			cmd.add(new DeleteCommand(editingDomain, (View)containmentCircle));
		}
		return cmd;
	}

	/**
	 * Adds the delete incoming containment link view commands.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param targetNode
	 *        the target node
	 * @param cmd
	 *        the cmd
	 */
	public static void addDeleteIncomingContainmentLinkViewCommands(TransactionalEditingDomain editingDomain, View targetNode, ICompositeCommand cmd) {
		for(Object next : targetNode.getTargetEdges()) {
			Edge incomingLink = (Edge)next;
			if(ContainmentHelper.isContainmentLink(incomingLink)) {
				cmd.add(new DeleteCommand(editingDomain, incomingLink));
				View containmentCircle = incomingLink.getSource();
				if(!circleHasOtherLinks(containmentCircle)) {
					cmd.add(new DeleteCommand(editingDomain, (View)containmentCircle));
				}
			}
		}
	}

	/**
	 * Checks for incoming containment link.
	 * 
	 * @param targetNode
	 *        the target node
	 * @return true, if successful
	 */
	public static boolean hasIncomingContainmentLink(View targetNode) {
		for(Object next : targetNode.getTargetEdges()) {
			Edge incomingLink = (Edge)next;
			if(ContainmentHelper.isContainmentLink(incomingLink)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks for outgoing containment link.
	 * 
	 * @param targetNode
	 *        the target node
	 * @return true, if successful
	 */
	public static boolean hasOutgoingContainmentLink(View targetNode) {
		for(Object next : targetNode.getVisibleChildren()) {
			View node = (View)next;
			if(isContainmentCircle(node)) {
				for(Object nextLink : node.getSourceEdges()) {
					Edge outgoingLink = (Edge)nextLink;
					if(ContainmentHelper.isContainmentLink(outgoingLink)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Adds the destroy outgoing containment links command.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param sourceNode
	 *        the source node
	 * @param cmd
	 * 
	 *        the cmd
	 */
	public static void addDeleteOutgoingContainmentLinkViewCommands(TransactionalEditingDomain editingDomain, View sourceNode, ICompositeCommand cmd) {
		for(Object child : sourceNode.getVisibleChildren()) {
			if(ContainmentHelper.isContainmentCircle((View)child)) {
				View circle = (View)child;
				cmd.add(new DeleteCommand(editingDomain, circle));
				for(Object next : circle.getSourceEdges()) {
					Edge outgoingLink = (Edge)next;
					if(ContainmentHelper.isContainmentLink(outgoingLink)) {
						cmd.add(new DeleteCommand(editingDomain, outgoingLink));
						//delete target view as it actually contained by the source object and will be deleted 
						cmd.add(new DeleteCommand(editingDomain, outgoingLink.getTarget()));
						addDeleteOutgoingContainmentLinkViewCommands(editingDomain, outgoingLink.getTarget(), cmd);
					}
				}
			}
		}
	}
	/**
	 * look for a editpart from the semantic element
	 * @param editPartRegistry the map of editpart
	 * @param droppedElement the semantic element
	 * @return can return null if nothing is found
	 */
	public EditPart findEditPartFor(Map editPartRegistry, Element droppedElement) {
		for(Object next : editPartRegistry.values()) {
			EditPart currentEditPart = (EditPart)next;
			if(canHaveContainmentLink(currentEditPart)) {
				View currentView = (View)currentEditPart.getModel();
				if(droppedElement.equals(currentView.getElement())) {
					return currentEditPart;
				}
			}
		}
		return null;
	}

	private boolean canHaveContainmentLink(EditPart currentEditPart) {
		return currentEditPart instanceof ClassEditPart || currentEditPart instanceof PackageEditPartCN || currentEditPart instanceof PackageEditPart || currentEditPart instanceof ModelEditPartTN || currentEditPart instanceof Class5EditPart || currentEditPart instanceof ModelEditPartCN;

	}

	/**
	 * Move.
	 * 
	 * @param objectToMove
	 *        the object to move
	 * @param to
	 *        the to
	 * @return true, if successful
	 */
	public boolean move(EObject objectToMove, EObject to) {
		if(objectToMove instanceof org.eclipse.uml2.uml.Package) {
			return movePackage((org.eclipse.uml2.uml.Package)objectToMove, to);
		} else if(objectToMove instanceof org.eclipse.uml2.uml.Class) {
			return moveClass((org.eclipse.uml2.uml.Class)objectToMove, to);
		}
		return false;
	}

	/**
	 * Move package.
	 * 
	 * @param pakkage
	 *        the pakkage
	 * @param to
	 *        the to
	 * @return true, if successful
	 */
	private boolean movePackage(org.eclipse.uml2.uml.Package pakkage, EObject to) {
		Element from = pakkage.getOwner();
		if(to instanceof org.eclipse.uml2.uml.Package && from instanceof org.eclipse.uml2.uml.Package) {
			doMovePackage(pakkage, (org.eclipse.uml2.uml.Package)from, (org.eclipse.uml2.uml.Package)to);
			return true;
		}
		return false;
	}

	/**
	 * Move class.
	 * 
	 * @param clazz
	 *        the clazz
	 * @param to
	 *        the to
	 * @return true, if successful
	 */
	private boolean moveClass(org.eclipse.uml2.uml.Class clazz, EObject to) {
		Element from = clazz.getOwner();
		if(from instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class fromClazz = (org.eclipse.uml2.uml.Class)from;
			if(to instanceof org.eclipse.uml2.uml.Class) {
				doMoveClass(clazz, fromClazz, (org.eclipse.uml2.uml.Class)to);
				return true;
			} else if(to instanceof org.eclipse.uml2.uml.Package) {
				doMoveClass(clazz, fromClazz, (org.eclipse.uml2.uml.Package)to);
				return true;
			}
		}
		if(from instanceof org.eclipse.uml2.uml.Package) {
			org.eclipse.uml2.uml.Package fromPackage = (org.eclipse.uml2.uml.Package)from;
			if(to instanceof org.eclipse.uml2.uml.Class) {
				doMoveClass(clazz, fromPackage, (org.eclipse.uml2.uml.Class)to);
				return true;
			} else if(to instanceof org.eclipse.uml2.uml.Package) {
				doMoveClass(clazz, fromPackage, (org.eclipse.uml2.uml.Package)to);
				return true;
			}
		}

		return false;
	}

	/**
	 * Do move package.
	 * 
	 * @param pakkage
	 *        the pakkage
	 * @param from
	 *        the from
	 * @param to
	 *        the to
	 */
	private void doMovePackage(org.eclipse.uml2.uml.Package pakkage, org.eclipse.uml2.uml.Package from, org.eclipse.uml2.uml.Package to) {
		from.getNestedPackages().remove(pakkage);
		to.getNestedPackages().add(pakkage);
	}

	/**
	 * Do move class.
	 * 
	 * @param clazz
	 *        the clazz
	 * @param from
	 *        the from
	 * @param to
	 *        the to
	 */
	private void doMoveClass(org.eclipse.uml2.uml.Class clazz, org.eclipse.uml2.uml.Package from, org.eclipse.uml2.uml.Package to) {
		from.getPackagedElements().remove(clazz);
		to.getPackagedElements().add(clazz);
	}

	/**
	 * Do move class.
	 * 
	 * @param clazz
	 *        the clazz
	 * @param from
	 *        the from
	 * @param to
	 *        the to
	 */
	private void doMoveClass(org.eclipse.uml2.uml.Class clazz, org.eclipse.uml2.uml.Package from, org.eclipse.uml2.uml.Class to) {
		from.getPackagedElements().remove(clazz);
		to.getNestedClassifiers().add(clazz);
	}

	/**
	 * Do move class.
	 * 
	 * @param clazz
	 *        the clazz
	 * @param from
	 *        the from
	 * @param to
	 *        the to
	 */
	private void doMoveClass(org.eclipse.uml2.uml.Class clazz, org.eclipse.uml2.uml.Class from, org.eclipse.uml2.uml.Package to) {
		from.getNestedClassifiers().remove(clazz);
		to.getPackagedElements().add(clazz);
	}

	/**
	 * Do move class.
	 * 
	 * @param clazz
	 *        the clazz
	 * @param from
	 *        the from
	 * @param to
	 *        the to
	 */
	private void doMoveClass(org.eclipse.uml2.uml.Class clazz, org.eclipse.uml2.uml.Class from, org.eclipse.uml2.uml.Class to) {
		from.getNestedClassifiers().remove(clazz);
		to.getNestedClassifiers().add(clazz);
	}


}
