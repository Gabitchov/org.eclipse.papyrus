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

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
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
			if(UMLVisualIDRegistry.getVisualID(nextConnectorSource) == ContainmentCircleEditPart.VISUAL_ID) {
				/* The containment circle node is deleted only if any other link is connected */
				if(nextConnectorSource.getSourceEdges().size() == 1) {
					// Delete the containment circle
					cc.add(new DeleteCommand(getEditingDomain(), nextConnectorSource));
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
		CompoundCommand cc = new CompoundCommand("drop");

		EditPart droppedElementEditPart = findEditPartFor(viewer.getEditPartRegistry(), droppedElement);
		Element owner = (Element)droppedElement.getOwner();
		GraphicalEditPart droppedParentEditPart = null;
		if (droppedElementEditPart != null) {
			if(((GraphicalEditPart)droppedElementEditPart.getParent()).resolveSemanticElement().equals(owner)) {
				droppedParentEditPart = (GraphicalEditPart)droppedElementEditPart.getParent();

			}
		}

		// if the owner does not exist the link have not to be created or different of the diagram.
		if(droppedParentEditPart == null || droppedParentEditPart instanceof ModelEditPart) {
			return cc;
		}
		if(droppedElementEditPart == null) {
			dropElementWithoutEditPartToDiagram(droppedElement, viewer, diagramPreferencesHint, location, containerView, cc, droppedParentEditPart);
		} else {
			if(canHaveContainmentLink(droppedElementEditPart)) {
				cc.add(new ICommandProxy(new DeleteCommand(getEditingDomain(), (View)droppedElementEditPart.getModel())));
				dropElementWithoutEditPartToDiagram(droppedElement, viewer, diagramPreferencesHint, location, containerView, cc, droppedParentEditPart);
			}
		}
		return cc;
	}

	private void dropElementWithoutEditPartToDiagram(PackageableElement droppedElement, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView, CompoundCommand cc, GraphicalEditPart graphicalEditPartDroppedElementOwner) {
		// 3.1 *********************************************** Creation of the dropped element in the diagram */
		IAdaptable elementAdapter = new EObjectAdapter(droppedElement);
		ViewDescriptor droppedElementDescriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, false, diagramPreferencesHint);

		CreateCommand containedNodeCreationCommand = new CreateCommand(this.editDomain, droppedElementDescriptor, containerView);
		cc.add(new ICommandProxy(containedNodeCreationCommand));

		/* Positioning of the dropped element */
		SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100));
		cc.add(new ICommandProxy(setBoundsCommand));

		/* Recovery of the eventual stereotype and his display */
		if(!(droppedElement.getAppliedStereotypes().isEmpty())) {
			EList<Stereotype> stereotypeAppliedList = droppedElement.getAppliedStereotypes();
			Iterator<Stereotype> stereotypeAppliedIterator = stereotypeAppliedList.iterator();
			while(stereotypeAppliedIterator.hasNext()) {
				Stereotype stereotype = (Stereotype)stereotypeAppliedIterator.next();
				String profileApplied = "\"" + stereotype.getProfile() + "\"::";
				cc.add(new ICommandProxy(new CustomDropAppliedStereotypeCommand(this.editDomain, (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), profileApplied, VisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION)));
			}
		}

		// 3.2 *********************************************** Creation of the link */

		ConnectionViewDescriptor linkViewDescriptor = new ConnectionViewDescriptor(org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022, ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022).getSemanticHint(), graphicalEditPartDroppedElementOwner.getDiagramPreferencesHint());

		/* if a containment circle exists, only the dashedline will be create */

		CContainmentCircleEditPart containmentCircleEditPart = null;

		//look for an existed circle editpart
		Iterator<EditPart> childrenIterator = graphicalEditPartDroppedElementOwner.getChildren().iterator();
		while(childrenIterator.hasNext()) {
			EditPart editPart = (EditPart)childrenIterator.next();
			if(editPart instanceof CContainmentCircleEditPart) {
				containmentCircleEditPart = (CContainmentCircleEditPart)editPart;
			}

		}
		if(containmentCircleEditPart != null) {
			cc.add(new ICommandProxy(new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Dependency_4022).getSemanticHint(), new SemanticAdapter(null, (View)containmentCircleEditPart.getModel()), (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), viewer, diagramPreferencesHint, linkViewDescriptor, null)));
		} else {

			/* Creation of the containment circle node without semantic element */
			ContainmentCircleViewCreateCommand circleCommand = new ContainmentCircleViewCreateCommand(null, getEditingDomain(), (View)graphicalEditPartDroppedElementOwner.getModel(), (EditPartViewer)graphicalEditPartDroppedElementOwner.getViewer(), droppedElementDescriptor.getPreferencesHint());
			cc.add(new ICommandProxy(circleCommand));

			//position
			setBoundsCommand = new SetBoundsCommand(getEditingDomain(), CONTAINMENT_CIRCLE_POSITION, (IAdaptable)circleCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100));
			cc.add(new ICommandProxy(setBoundsCommand));

			/* Creation of the dashedline between the containment circle node and the target element */
			CustomDeferredCreateConnectionViewCommand containmentLinkCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Dependency_4022).getSemanticHint(), (IAdaptable)circleCommand.getCommandResult().getReturnValue(), (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), viewer, diagramPreferencesHint, linkViewDescriptor, null);
			cc.add(new ICommandProxy(containmentLinkCommand));
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
		return containmentCircle.getSourceEdges().size() == 1;
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
		if(circleHasOtherLinks(containmentCircle)) {
			cmd.add(new DeleteCommand(editingDomain, (View)containmentCircle));
		}
		return cmd;
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

}
