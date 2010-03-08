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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
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
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentCircleViewCreateCommand;
import org.eclipse.papyrus.diagram.clazz.custom.command.CustomDropAppliedStereotypeCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.diagram.clazz.custom.command.DefferedAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.providers.CustomDeferredCreateConnectionViewCommand;
public class ContainmentHelper extends ElementHelper {

	public static final String CONTAINMENT_CIRCLE_POSITION = "ContainmentCirclePosition";



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
	public Command getContainmentElementCommand(CreateConnectionViewRequest createConnectionViewRequest, Command command) {

		CompoundCommand mycommand = new CompoundCommand();
		if(command instanceof ICommandProxy) {

			// Edit part of a eventual containment circle existing
			CContainmentCircleEditPart containmentCircleExist = null;

			// 1. *********************************************** Initialization of variable

			GraphicalEditPart sourceEditPart = (GraphicalEditPart)createConnectionViewRequest.getSourceEditPart();
			GraphicalEditPart parent = (GraphicalEditPart)sourceEditPart;

			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022, ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022).getSemanticHint(), sourceEditPart.getDiagramPreferencesHint());
			IAdaptable ContainmentLinkViewAdapter = new SemanticAdapter(null, createConnectionViewRequest.getTargetEditPart().getModel());

			// look of an existing containment circle 

			Iterator<EditPart> childrenIterator = parent.getChildren().iterator();

			while(childrenIterator.hasNext()) {
				EditPart editPart = (EditPart)childrenIterator.next();
				if(editPart instanceof CContainmentCircleEditPart) {
					containmentCircleExist = (CContainmentCircleEditPart)editPart;
				}
			}

			// 2. *********************************************** creation of the target element and the link 
			// if a containment circle exists, only the dashedline will be create 

			if(containmentCircleExist != null) {

				/* recovery of the existing containment circle */
				IGraphicalEditPart circle = parent.getChildBySemanticHint(((IHintedType)UMLElementTypes.Port_3032).getSemanticHint());
				IAdaptable circleAdapter = new SemanticAdapter(null, circle.getModel());

				/* Creation of the dashedline between the existing containment circle node and the target element */
				ICommand dashedLineCmd = new org.eclipse.papyrus.diagram.clazz.custom.command.CustomContainmentLinkViewCommand(getEditingDomain(), ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022).getSemanticHint(), ContainmentLinkViewAdapter, circleAdapter, sourceEditPart.getViewer(), sourceEditPart.getDiagramPreferencesHint(), viewDescriptor, null);
				mycommand.add(new ICommandProxy(dashedLineCmd));
				return mycommand;
			}

			else {

				/* Creation of the containment circle node without semantic element */
				ContainmentCircleViewCreateCommand circleCommand = new ContainmentCircleViewCreateCommand(createConnectionViewRequest, getEditingDomain(), (View)parent.getModel(), (EditPartViewer)sourceEditPart.getViewer(), sourceEditPart.getDiagramPreferencesHint());
				mycommand.add(new ICommandProxy(circleCommand));


				/* Set the position of the containment circle node */

				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), CONTAINMENT_CIRCLE_POSITION, (IAdaptable)circleCommand.getCommandResult().getReturnValue(), createConnectionViewRequest.getLocation());
				mycommand.add(new ICommandProxy(setBoundsCommand));

				/* Creation of the dashedline between the containment circle node and the target element */
				ICommand dashedLineCmd = new org.eclipse.papyrus.diagram.clazz.custom.command.CustomContainmentLinkViewCommand(getEditingDomain(), ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Dependency_4022).getSemanticHint(), ContainmentLinkViewAdapter, null, sourceEditPart.getViewer(), sourceEditPart.getDiagramPreferencesHint(), viewDescriptor, circleCommand);
				mycommand.add(new ICommandProxy(dashedLineCmd));
				return mycommand;
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
		CompoundCommand cc = new CompoundCommand("drop");
		// this the graphical editpart of the dropped element 
		GraphicalEditPart droppedElementEditPart = null;
		// this the graphical editpart of the dropped element owner
		GraphicalEditPart graphicalEditPartDroppedElementOwner = null;

		/* Verify if the view of the dropped element owner exists on the diagram */
		Element owner = (Element)droppedElement.getOwner();



		// 1. *********************************************** Initialization of variable
		Collection<EditPart> editPartSet = viewer.getEditPartRegistry().values();
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		while(editPartIterator.hasNext()) {
			EditPart currentEditPart = editPartIterator.next();
			// look for the dropped element in the diagram
			if((currentEditPart instanceof ClassEditPart || currentEditPart instanceof PackageEditPart || currentEditPart instanceof Class5EditPart || currentEditPart instanceof PackageEditPartCN
				|| currentEditPart instanceof ModelEditPartCN || currentEditPart instanceof ModelEditPartTN)) {
				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(droppedElement)) {
					droppedElementEditPart = ((GraphicalEditPart)currentEditPart);
				}
				// look for the graphical editpart of the dropped element owner
				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(owner)) {
					graphicalEditPartDroppedElementOwner = (GraphicalEditPart)currentEditPart;

				}

			}
		}
		// if the owner does not exist the link have not to be created or different of the diagram.
		if(graphicalEditPartDroppedElementOwner == null || graphicalEditPartDroppedElementOwner instanceof ModelEditPart) {
			return cc;
		}
		// 2. *********************************************** remove the label that is the dropped element 
		if(droppedElementEditPart != null && (droppedElementEditPart instanceof Class5EditPart || droppedElementEditPart instanceof PackageEditPartCN 
			|| droppedElementEditPart instanceof ModelEditPartCN || droppedElementEditPart instanceof PackageEditPart)) {
			cc.add(new ICommandProxy(new DeleteCommand(getEditingDomain(), (View)droppedElementEditPart.getModel())));
			droppedElementEditPart = null;
		}

		// 3. *********************************************** creation of the target element and the link 
		/* if the element view doesn't exist on the diagram */
		if(droppedElementEditPart == null) {

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


		return cc;
	}







}
