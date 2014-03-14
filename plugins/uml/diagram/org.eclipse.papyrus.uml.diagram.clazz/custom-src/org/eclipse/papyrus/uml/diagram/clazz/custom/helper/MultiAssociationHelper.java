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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.AssociationDiamonViewCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CustomDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.PropertyCommandForAssociation;
import org.eclipse.papyrus.uml.diagram.clazz.custom.providers.GraphicalAssociationBranchViewCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationBranchEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.commands.DeleteLinkDuringCreationCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.helper.AssociationEndSourceLabelHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.AssociationEndTargetLabelHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class MultiAssociationHelper to manage the creation of branches or transformation of binary
 * to n-ary association
 */
public class MultiAssociationHelper extends org.eclipse.papyrus.uml.diagram.common.helper.MultiAssociationHelper {

	/**
	 * get the member end that will be managed by the branch of the association.
	 *
	 * @param associationBranchView
	 *        the association branch view
	 * @param association
	 *        the association
	 *
	 * @return the property concerned by the branch or null if the property is not found
	 */
	public static Property getPropertyToListen(Edge associationBranchView, Association association) {
		Property semanticBranch = getSemanticBranchEnd(associationBranchView);
		if(semanticBranch != null) {
			return semanticBranch;
		}
		Classifier target = (Classifier)(associationBranchView.getTarget().getElement());
		// look for the property that is typed by the classifier
		Property propertyToDisplay = null;
		Iterator<Property> propertiesIterator = association.getMemberEnds().iterator();
		while(propertiesIterator.hasNext()) {
			Property currentProperty = propertiesIterator.next();
			if(currentProperty.getType().equals(target)) {
				propertyToDisplay = currentProperty;
			}
		}
		return propertyToDisplay;
	}

	public static void createSemanticBranchStyles(View view) {
		org.eclipse.gmf.runtime.notation.EObjectValueStyle semanticbranchStyle = NotationFactory.eINSTANCE.createEObjectValueStyle();
		semanticbranchStyle.setName(MultiAssociationHelper.SEMANTIC_BRANCH);
		view.getStyles().add(semanticbranchStyle);
	}

	/**
	 * constructor.
	 *
	 * @param editDomain
	 *        the editDomain , important to create commands can not be null
	 */
	public MultiAssociationHelper(TransactionalEditingDomain editDomain) {
		super();
		this.editDomain = editDomain;
	}

	/**
	 * Display all branches command.
	 *
	 * @param associationNodeEditPart
	 *        the association node edit part
	 *
	 * @return the command
	 */
	public Command displayAllBranchesCommand(AssociationNodeEditPart associationNodeEditPart) {
		Command command = new CompoundCommand();
		// 0. Obtain list of property to display
		Association association = (Association)associationNodeEditPart.resolveSemanticElement();
		ArrayList<Property> endToDisplay = new ArrayList(association.getMemberEnds());
		// 1. remove in the list all displayedElement.
		Iterator iter = associationNodeEditPart.getSourceConnections().iterator();
		while(iter.hasNext()) {
			EditPart currentEditPart = (EditPart)iter.next();
			if(currentEditPart instanceof AssociationBranchEditPart) {
				endToDisplay.remove(getPropertyToListen((Edge)((AssociationBranchEditPart)currentEditPart).getModel(), association));
			}
		}
		// 2. for each element create a graphical representation of the type and
		// finally the branch
		Iterator<Property> iteratorProp = endToDisplay.iterator();
		int index = 0;
		while(iteratorProp.hasNext()) {
			index += 1;
			// source editPart
			EditPart sourceEditPart = null;
			// end of the association end
			Property currentEnd = iteratorProp.next();
			// look for if an editpart exist for this element
			Collection<EditPart> editPartSet = associationNodeEditPart.getViewer().getEditPartRegistry().values();
			Iterator<EditPart> editPartIterator = editPartSet.iterator();
			while(editPartIterator.hasNext() && sourceEditPart == null) {
				EditPart currentEditPart = editPartIterator.next();
				if((!(currentEditPart instanceof CompartmentEditPart)) && currentEditPart instanceof GraphicalEditPart && currentEnd.getType().equals(((GraphicalEditPart)currentEditPart).resolveSemanticElement())) {
					sourceEditPart = currentEditPart;
				}
			}
			// descriptor for the branch
			ConnectionViewDescriptor viewBranchDescriptor = new ConnectionViewDescriptor(UMLElementTypes.Association_4019, ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), ((IGraphicalEditPart)associationNodeEditPart).getDiagramPreferencesHint());
			// the editpart exist -> only creation of the branch
			if(sourceEditPart != null) {
				CustomDeferredCreateConnectionViewCommand aBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), new SemanticAdapter(null, associationNodeEditPart.getModel()), new SemanticAdapter(null, sourceEditPart.getModel()), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewBranchDescriptor, null);
				aBranchCommand.setElement(association);
				((CompoundCommand)command).add(new ICommandProxy(aBranchCommand));
			} else {// the editpart does not exist
				// creation of the node
				IAdaptable elementAdapter = new EObjectAdapter(currentEnd.getType());
				ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, true, associationNodeEditPart.getDiagramPreferencesHint());
				// get the command and execute it.
				CreateCommand nodeCreationCommand = new CreateCommand(getEditingDomain(), descriptor, (View)((View)associationNodeEditPart.getModel()).eContainer());
				((CompoundCommand)command).add(new ICommandProxy(nodeCreationCommand));
				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(associationNodeEditPart.getLocation().x + 200, associationNodeEditPart.getLocation().y + index * 100));
				((CompoundCommand)command).add(new ICommandProxy(setBoundsCommand));
				// Creation of the branch
				CustomDeferredCreateConnectionViewCommand aBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), new SemanticAdapter(null, associationNodeEditPart.getModel()), (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), associationNodeEditPart.getViewer(), ((IGraphicalEditPart)associationNodeEditPart).getDiagramPreferencesHint(), viewBranchDescriptor, null);
				aBranchCommand.setElement(association);
				((CompoundCommand)command).add(new ICommandProxy(aBranchCommand));
				// creation of the link
			}
		}
		return command;
	}

	public Command dropMutliAssociation(Association association, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView) {
		Command command = new CompoundCommand();
		// 0. Obtain list of property to display
		ArrayList<Property> endToDisplay = new ArrayList(association.getMemberEnds());
		// 1. creatiuon of the diamon of association
		AssociationDiamonViewCreateCommand nodeCreation = new AssociationDiamonViewCreateCommand(getEditingDomain(), containerView, viewer, diagramPreferencesHint, location, new SemanticAdapter(association, null));
		((CompoundCommand)command).add(new ICommandProxy(nodeCreation));
		// 2. for each element create a graphical representation of the type and
		// finally the branch
		Iterator<Property> iteratorProp = endToDisplay.iterator();
		int index = 0;
		while(iteratorProp.hasNext()) {
			index += 1;
			// source editPart
			EditPart sourceEditPart = null;
			// end of the association end
			Property currentEnd = iteratorProp.next();
			// look for if an editpart exist for this element
			Collection<EditPart> editPartSet = viewer.getEditPartRegistry().values();
			Iterator<EditPart> editPartIterator = editPartSet.iterator();
			while(editPartIterator.hasNext() && sourceEditPart == null) {
				EditPart currentEditPart = editPartIterator.next();
				if((!(currentEditPart instanceof CompartmentEditPart)) && currentEditPart instanceof GraphicalEditPart && currentEnd.getType().equals(((GraphicalEditPart)currentEditPart).resolveSemanticElement())) {
					sourceEditPart = currentEditPart;
				}
			}
			// descriptor for the branch
			ConnectionViewDescriptor viewBranchDescriptor = new ConnectionViewDescriptor(UMLElementTypes.Association_4019, ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), diagramPreferencesHint);
			// the editpart exist -> only creation of the branch
			if(sourceEditPart != null) {
				GraphicalAssociationBranchViewCommand aBranchCommand = new GraphicalAssociationBranchViewCommand(getEditingDomain(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, sourceEditPart.getModel()), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewBranchDescriptor, currentEnd);
				//CustomDeferredCreateConnectionViewCommand aBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, sourceEditPart.getModel()), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewBranchDescriptor, null);
				aBranchCommand.setElement(association);
				((CompoundCommand)command).add(new ICommandProxy(aBranchCommand));
			} else {// the editpart does not exist
				// creation of the node
				IAdaptable elementAdapter = new EObjectAdapter(currentEnd.getType());
				ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, true, diagramPreferencesHint);
				// get the command and execute it.
				CreateCommand nodeCreationCommand = new CreateCommand(getEditingDomain(), descriptor, containerView);
				((CompoundCommand)command).add(new ICommandProxy(nodeCreationCommand));
				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x + 200, location.y + index * 100));
				((CompoundCommand)command).add(new ICommandProxy(setBoundsCommand));
				// Creation of the branch
				GraphicalAssociationBranchViewCommand aBranchCommand = new GraphicalAssociationBranchViewCommand(getEditingDomain(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), viewer, diagramPreferencesHint, viewBranchDescriptor, currentEnd);
				//CustomDeferredCreateConnectionViewCommand aBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), (IAdaptable)nodeCreationCommand.getCommandResult().getReturnValue(), viewer, diagramPreferencesHint, viewBranchDescriptor, null);
				aBranchCommand.setElement(association);
				((CompoundCommand)command).add(new ICommandProxy(aBranchCommand));
				// creation of the link
			}
		}
		return command;
	}

	/**
	 * transform binary association to n-ary association.
	 *
	 * @param createConnectionViewAndElementRequest
	 *        the create connection view and element request
	 * @param command
	 *        the command
	 *
	 * @return the command in charge of this job
	 */
	private Command getAssociationToMultiAssociationCommand(CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest, Command command) {
		// 0. creation of variables
		command = new CompoundCommand();
		Point sourceLocation = null;
		Point targetLocation = null;
		Point nodeLocation = null;
		NamedElement newSemanticElement = null;// element that will be added as
		// client ou supplier of the
		// association
		EStructuralFeature feature = null; // role client or supplier
		EditPart sourceEditPart = createConnectionViewAndElementRequest.getSourceEditPart();
		EditPart targetEditPart = createConnectionViewAndElementRequest.getTargetEditPart();
		View associationView = null;
		Association association = null;
		View parentView = null;
		Property sourceEnd = null;
		Property targetEnd = null;
		// ---------------------------------------------------------
		// help to debug
		//		System.err.println("\n+ 0. creation of variables");
		//		System.err.println("+-> editting domain"+ getEditingDomain());
		//		System.err.println("+-> sourceEditpart:" + sourceEditPart);
		//		System.err.println("+-> targetEditPart:" + targetEditPart);
		// ---------------------------------------------------------
		// 1. initialization
		ICommandProxy startcommand = ((ICommandProxy)createConnectionViewAndElementRequest.getStartCommand());
		if(startcommand == null) {
			return null;
		}
		Iterator<?> ite = ((CompositeCommand)startcommand.getICommand()).iterator();
		while(ite.hasNext()) {
			ICommand currentCommand = (ICommand)ite.next();
			if(currentCommand instanceof SetConnectionBendpointsCommand) {
				sourceLocation = ((SetConnectionBendpointsCommand)currentCommand).getSourceRefPoint();
				targetLocation = ((SetConnectionBendpointsCommand)currentCommand).getTargetRefPoint();
			}
		}
		if(targetEditPart != null) {
			// the source or the target must be a association
			// look for the edit part that represent the editpart
			if(((View)sourceEditPart.getModel()).getElement() != null && ((View)sourceEditPart.getModel()).getElement() instanceof Association) {
				associationView = ((View)sourceEditPart.getModel());
				association = (Association)((View)sourceEditPart.getModel()).getElement();
				nodeLocation = sourceLocation;
				newSemanticElement = (NamedElement)((View)targetEditPart.getModel()).getElement();
				feature = UMLPackage.eINSTANCE.getTypedElement_Type();
				sourceEnd = AssociationEndSourceLabelHelper.getInstance().getUMLElement((org.eclipse.gef.GraphicalEditPart)sourceEditPart.getChildren().get(0));
				targetEnd = AssociationEndTargetLabelHelper.getInstance().getUMLElement((org.eclipse.gef.GraphicalEditPart)sourceEditPart.getChildren().get(1));
			}
			if(((View)targetEditPart.getModel()).getElement() != null && ((View)targetEditPart.getModel()).getElement() instanceof Association) {
				associationView = ((View)targetEditPart.getModel());
				association = (Association)((View)targetEditPart.getModel()).getElement();
				nodeLocation = targetLocation;
				newSemanticElement = (NamedElement)((View)sourceEditPart.getModel()).getElement();
				feature = UMLPackage.eINSTANCE.getTypedElement_Type();
				sourceEnd = AssociationEndSourceLabelHelper.getInstance().getUMLElement((org.eclipse.gef.GraphicalEditPart)targetEditPart.getChildren().get(0));
				targetEnd = AssociationEndTargetLabelHelper.getInstance().getUMLElement((org.eclipse.gef.GraphicalEditPart)targetEditPart.getChildren().get(1));
			}
			if(associationView == null || (targetEditPart.getModel() instanceof Edge)) {
				return null;
			}
			parentView = (View)associationView.eContainer();
			// ---------------------------------------------------------
			// help to debug
			//			System.err.println("+ 1. initialization");
			//			System.err.println("+-> sourceLocation:" + sourceLocation);
			//			System.err.println("+-> targetLocation:" + targetLocation);
			//			System.err.println("+-> AssociationView:" + associationView);
			//			System.err.println("+-> association:" + association);
			//			System.err.println("+-> nodeLocation:" + nodeLocation);
			//			System.err.println("+-> newSemanticElement:" + newSemanticElement);
			//			System.err.println("+-> feature:" + feature);
			//			System.err.println("+-> parentView:" + parentView);
			// ---------------------------------------------------------
			//8 Ensure that all member ends belong to the association
			ArrayList<Property> ownedProperty = new ArrayList<Property>();
			ownedProperty.addAll(association.getMemberEnds());
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(association);
			if(provider != null) {
				SetRequest setRequest = new SetRequest(association, UMLPackage.eINSTANCE.getAssociation_OwnedEnd(), ownedProperty);
				ICommand iCommand = provider.getEditCommand(setRequest);
				((CompoundCommand)command).add(new ICommandProxy(iCommand));
			}
			// 2. Remove the view of the association
			DeleteCommand deleteCommand = new DeleteLinkDuringCreationCommand(getEditingDomain(), (Edge)associationView, sourceEditPart.getViewer());
			deleteCommand.setReuseParentTransaction(true);
			Command removecommand = new ICommandProxy(deleteCommand);
			//to execute
			((CompoundCommand)command).add(removecommand);
			//((CompoundCommand)command).add(removecommand);
			// ---------------------------------------------------------
			// help to debug
			//			System.err.println("+ 2. Remove the view of the association");
			//			System.err.println("+-> command:" + command.canExecute());
			// ---------------------------------------------------------
			// 3. set a new end association in the UML model
			// 3.1 creation of the property
			CreateElementRequest request = new CreateElementRequest(getEditingDomain(), association, UMLElementTypes.Property_3005, UMLPackage.eINSTANCE.getAssociation_OwnedEnd());
			request.setParameter("type", newSemanticElement);
			EditElementCommand propertyCreateCommand = new PropertyCommandForAssociation(request, DiagramUtils.getDiagramFrom(sourceEditPart));
			propertyCreateCommand.setReuseParentTransaction(true);
			((CompoundCommand)command).add(new ICommandProxy(propertyCreateCommand));
			// 3. Node creation at this position
			View associationViewSource = ((Edge)associationView).getSource();
			View associationViewTarget = ((Edge)associationView).getTarget();
			AssociationDiamonViewCreateCommand nodeCreation = new AssociationDiamonViewCreateCommand(getEditingDomain(), parentView, sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), nodeLocation, new SemanticAdapter(association, null));
			nodeCreation.setReuseParentTransaction(true);
			((CompoundCommand)command).add(new ICommandProxy(nodeCreation));
			// 4. reconstruction of the old link by taking in account the old
			// connection
			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(UMLElementTypes.Association_4019, ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint());
			// 5. reconstruction of the first branch between old source to node
			ICommand firstBranchCommand = new GraphicalAssociationBranchViewCommand(getEditingDomain(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, associationViewSource), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, sourceEnd);
			//ICommand firstBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, associationViewSource), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, null);
			((GraphicalAssociationBranchViewCommand)firstBranchCommand).setElement(association);
			((CompoundCommand)command).add(new ICommandProxy(firstBranchCommand));
			// 6. reconstruction of the second branch between node to old target
			ICommand secondBranchCommand = new GraphicalAssociationBranchViewCommand(getEditingDomain(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, associationViewTarget), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, targetEnd);
			//ICommand secondBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, associationViewTarget), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, null);
			((GraphicalAssociationBranchViewCommand)secondBranchCommand).setElement(association);
			((CompoundCommand)command).add(new ICommandProxy(secondBranchCommand));
			// 7. Create of the third branch between node and target our source.
			ICommand thirdBranchCommand = null;
			if(associationView.equals((sourceEditPart.getModel()))) {
				// third branch node and target
				thirdBranchCommand = new GraphicalAssociationBranchViewCommand(getEditingDomain(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, targetEditPart.getModel()), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, request);
				//thirdBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), new SemanticAdapter(null, targetEditPart.getModel()), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, null);
			} else {
				// third branch source and node
				thirdBranchCommand = new GraphicalAssociationBranchViewCommand(getEditingDomain(), new SemanticAdapter(null, sourceEditPart.getModel()), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, request);
				//thirdBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), new SemanticAdapter(null, sourceEditPart.getModel()), (IAdaptable)nodeCreation.getCommandResult().getReturnValue(), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, null);
			}
			((GraphicalAssociationBranchViewCommand)thirdBranchCommand).setElement(association);
			((CompoundCommand)command).add(new ICommandProxy(thirdBranchCommand));
		}
		return command;
	}

	/**
	 * code to create new branch.
	 *
	 * @param createConnectionViewAndElementRequest
	 *        the create connection view and element request
	 * @param command
	 *        that will contain sub commands
	 *
	 * @return the command in charge of the branch creation
	 */
	private Command getBranchAssociationCommand(CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest, Command command) {
		command = new CompoundCommand();
		// init
		EditPart sourceEditPart = createConnectionViewAndElementRequest.getSourceEditPart();
		EditPart targetEditPart = createConnectionViewAndElementRequest.getTargetEditPart();
		if((targetEditPart.getModel() instanceof Edge)) {
			return null;
		}
		if(targetEditPart != null) {
			// the source or the target must be a association
			// look for the edit part that represent the editpart
			EObject association = null;
			NamedElement newSemanticElement = null;
			if(((View)sourceEditPart.getModel()).getElement() != null && ((View)sourceEditPart.getModel()).getElement() instanceof Association) {
				association = ((View)sourceEditPart.getModel()).getElement();
				newSemanticElement = (NamedElement)((View)targetEditPart.getModel()).getElement();
			}
			if(((View)targetEditPart.getModel()).getElement() != null && ((View)targetEditPart.getModel()).getElement() instanceof Association) {
				association = ((View)targetEditPart.getModel()).getElement();
				newSemanticElement = (NamedElement)((View)sourceEditPart.getModel()).getElement();
			}
			//System.err.println("step init, can execute?" + command.canExecute());
			// 0. add semantic
			CreateElementRequest request = new CreateElementRequest(getEditingDomain(), association, UMLElementTypes.Property_3005, UMLPackage.eINSTANCE.getAssociation_OwnedEnd());
			request.setParameter("type", newSemanticElement);
			EditElementCommand propertyCreateCommand = new PropertyCommandForAssociation(request, DiagramUtils.getDiagramFrom(targetEditPart));
			((CompoundCommand)command).add(new ICommandProxy(propertyCreateCommand));
			//System.err.println("0. add semantic, can execute?" + command.canExecute());
			// 1. add the branch graphically
			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(UMLElementTypes.Association_4019, ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint());
			GraphicalAssociationBranchViewCommand aBranchCommand = new GraphicalAssociationBranchViewCommand(getEditingDomain(), new SemanticAdapter(null, sourceEditPart.getModel()), new SemanticAdapter(null, targetEditPart.getModel()), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, request);
			//CustomDeferredCreateConnectionViewCommand aBranchCommand = new CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), new SemanticAdapter(null, sourceEditPart.getModel()), new SemanticAdapter(null, targetEditPart.getModel()), sourceEditPart.getViewer(), ((IGraphicalEditPart)sourceEditPart).getDiagramPreferencesHint(), viewDescriptor, null);
			aBranchCommand.setElement(association);
			((CompoundCommand)command).add(new ICommandProxy(aBranchCommand));
			//System.err.println("1. add the branch graphically, can execute?" + command.canExecute());
			return command;
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * return commands to transform a binary association to n-ary association or allow adding
	 * branches.
	 *
	 * @param createConnectionViewAndElementRequest
	 *        the create connection view and element request
	 * @param command
	 *        that will contains subcommands
	 *
	 * @return the command
	 */
	public Command getCommand(CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest, Command command) {
		// 0. get source and target type
		command = new CompoundCommand();
		EditPart sourceEditPart = createConnectionViewAndElementRequest.getSourceEditPart();
		EditPart targetEditPart = createConnectionViewAndElementRequest.getTargetEditPart();
		// if the the source or the target is a node association the goal is
		// to create only one branch
		if((((View)sourceEditPart.getModel()).getType() == "" + AssociationNodeEditPart.VISUAL_ID)) {
			return getBranchAssociationCommand(createConnectionViewAndElementRequest, command);
		}
		if((((View)targetEditPart.getModel()).getType() == "" + AssociationNodeEditPart.VISUAL_ID)) {
			return UnexecutableCommand.INSTANCE;
		}
		// the source or the target has to be different of a dependency branch
		if(sourceEditPart instanceof AssociationBranchEditPart) {
			GraphicalEditPart associationNodeEditPart = lookForAssociationNodeEditPart((AssociationBranchEditPart)sourceEditPart);
			if(associationNodeEditPart != null) {
				createConnectionViewAndElementRequest.setSourceEditPart(associationNodeEditPart);
				return getBranchAssociationCommand(createConnectionViewAndElementRequest, command);
			} else {
				return UnexecutableCommand.INSTANCE;
			}
		}
		// the source or the target has to be different of a dependency branch
		if(targetEditPart instanceof AssociationBranchEditPart) {
			return UnexecutableCommand.INSTANCE;
		}
		// if not this a transformation of simple dependency to multiDependency
		return getAssociationToMultiAssociationCommand(createConnectionViewAndElementRequest, command);
	}

	/**
	 * look for a dependency node from a dependency branch.
	 *
	 * @param dependencyBranchEditPart
	 * @return may be null
	 */
	protected GraphicalEditPart lookForAssociationNodeEditPart(AssociationBranchEditPart associationBranchEditPart) {
		if(associationBranchEditPart.getSource() instanceof AssociationNodeEditPart) {
			return (GraphicalEditPart)associationBranchEditPart.getSource();
		}
		if(associationBranchEditPart.getTarget() instanceof AssociationNodeEditPart) {
			return (GraphicalEditPart)associationBranchEditPart.getTarget();
		}
		return null;
	}
}
