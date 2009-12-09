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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.util.INotationType;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.diagram.common.editpolicies.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.diagram.clazz.custom.command.ContainmentViewCreateCommand;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AddedLinkEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ContainmentCircleEditPart;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.diagram.clazz.custom.command.DefferedAppliedStereotypeToDisplayCommand;

public class ContainmentHelper extends ElementHelper {

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

			GraphicalEditPart sourceEditPart = (GraphicalEditPart)createConnectionViewRequest.getSourceEditPart();
			GraphicalEditPart parent = (GraphicalEditPart)sourceEditPart;
			IAdaptable CircleViewAdapter = new SemanticAdapter(null, parent.getModel());
			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Link_4022, ((INotationType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Link_4022).getSemanticHint(), sourceEditPart.getDiagramPreferencesHint());
			IAdaptable ContainmentLinkViewAdapter = new SemanticAdapter(null, createConnectionViewRequest.getTargetEditPart().getModel());

			/* if a containment circle exists, only the dashedline will be create */
			if(parent.getChildren().toString().contains("ContainmentCircleEditPart")) {

				/* recovery of the existing containment circle */
				IGraphicalEditPart circle = parent.getChildBySemanticHint(((IHintedType)UMLElementTypes.Port_3032).getSemanticHint());
				IAdaptable circleAdapter = new SemanticAdapter(null, circle.getModel());

				/* Creation of the dashedline between the existing containment circle node and the target element */
				ICommand dashedLineCmd = new org.eclipse.papyrus.diagram.clazz.custom.command.CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Link_4022).getSemanticHint(), ContainmentLinkViewAdapter, circleAdapter, sourceEditPart.getViewer(), sourceEditPart.getDiagramPreferencesHint(), viewDescriptor, null);
				mycommand.add(new ICommandProxy(dashedLineCmd));
				return mycommand;
			}

			else {
				/* Creation of the containment circle node without semantic element */
				ContainmentViewCreateCommand circleCommand = new ContainmentViewCreateCommand(createConnectionViewRequest, getEditingDomain(), (View)parent.getModel(), (EditPartViewer)sourceEditPart.getViewer(), sourceEditPart.getDiagramPreferencesHint());
				mycommand.add(new ICommandProxy(circleCommand));

				/* Set the position of the containment circle node */
				mycommand.add(new ICommandProxy(new defferedSetBoundsCommand(getEditingDomain(), createConnectionViewRequest.getLocation(), circleCommand, null)));

				/* Creation of the dashedline between the containment circle node and the target element */
				ICommand dashedLineCmd = new org.eclipse.papyrus.diagram.clazz.custom.command.CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Link_4022).getSemanticHint(), ContainmentLinkViewAdapter, null, sourceEditPart.getViewer(), sourceEditPart.getDiagramPreferencesHint(), viewDescriptor, circleCommand);
				mycommand.add(new ICommandProxy(dashedLineCmd));
				return mycommand;
			}


		}

		return null;
	}

	/**
	 * Position the containment circle according to the target node position
	 */
	public static class defferedSetBoundsCommand extends AbstractTransactionalCommand {

		private TransactionalEditingDomain deffereddomain;

		private Point defferedlocation;

		private IAdaptable defferedadapter;

		private ContainmentViewCreateCommand defferedcircleCommand;

		public defferedSetBoundsCommand(TransactionalEditingDomain domain, Point location, ContainmentViewCreateCommand circleCommand, IAdaptable adapter) {
			super(domain, "defferedSetBoundsCommand", null);
			deffereddomain = domain;
			defferedlocation = location;
			defferedadapter = adapter;
			defferedcircleCommand = circleCommand;
			// TODO Auto-generated constructor stub
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CompoundCommand cc = new CompoundCommand();
			IAdaptable resultat = new SemanticAdapter(null, defferedcircleCommand.getCommandResult().getReturnValue());
			SetBoundsCommand setBoundsCommand1 = new SetBoundsCommand(getEditingDomain(), "ContainmentCirclePosition", (IAdaptable)resultat, new Point(defferedlocation.x, defferedlocation.y - 100));
			cc.add(new ICommandProxy(setBoundsCommand1));
			cc.execute();
			return CommandResult.newOKCommandResult();
		}
	}

	/**
	 * DragDrop the contained class from the outline to the diagram and from the compartment to the diagram.
	 * 
	 * @param semanticClass
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
	public Command outlineDropContainedClass(Classifier semanticClass, EditPartViewer viewer, PreferencesHint diagramPreferencesHint, Point location, View containerView) {
		CompoundCommand cc = new CompoundCommand("drop");

		boolean viewexist = false;

		/* Verify if the owner of the view of the dropped element exists on the diagram */
		Element owner = (Element)semanticClass.getOwner();
		Collection<EditPart> editPartSet = viewer.getEditPartRegistry().values();
		//Element ownerelement = null;
		EditPart ownereditpart = null;
		GraphicalEditPart ownergep = null;
		Iterator<EditPart> editPartIterator = editPartSet.iterator();
		while(editPartIterator.hasNext()) {
			EditPart currentEditPart = editPartIterator.next();
			if(!(currentEditPart instanceof RenderedDiagramRootEditPart)) {
				if((!(currentEditPart instanceof ContainmentCircleEditPart))) {
					if((!(currentEditPart instanceof CompartmentEditPart))) {
						if((!(currentEditPart instanceof AddedLinkEditPart))) {
							if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(semanticClass)) {
								viewexist = true;
							}
							if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(owner)) {
								//ownerelement = (Element) ((GraphicalEditPart) currentEditPart).resolveSemanticElement();
								ownereditpart = (EditPart)currentEditPart;
								ownergep = (GraphicalEditPart)currentEditPart;
							}

						}
					}
				}
			}
		}


		Collection<EditPart> ownereditPartSet = ownergep.getViewer().getEditPartRegistry().values();
		Iterator<EditPart> ownereditPartIterator = ownereditPartSet.iterator();
		while(ownereditPartIterator.hasNext()) {
			EditPart currentEditPart = ownereditPartIterator.next();
			if(currentEditPart instanceof Class5EditPart) {
				if(((GraphicalEditPart)currentEditPart).resolveSemanticElement().equals(semanticClass)) {
					cc.add(new ICommandProxy(new DeleteCommand(getEditingDomain(), (View)((GraphicalEditPart)currentEditPart).getModel())));
				}
			}
		}

		/* if the element view doesn't exist on the diagram */
		if(!viewexist) {

			/* Creation of the contained node without semantic */
			IAdaptable elementAdapter = new EObjectAdapter(semanticClass);
			ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, false, diagramPreferencesHint);
			CreateCommand containedNodeCreationCommand = new CreateCommand(this.editDomain, descriptor, containerView);
			cc.add(new ICommandProxy(containedNodeCreationCommand));

			/* Positioning of the dropped element */
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), new Point(location.x, location.y - 100));
			cc.add(new ICommandProxy(setBoundsCommand));

			/* Recovery of the eventual stereotype and his display */
			if(!(semanticClass.getAppliedStereotypes().isEmpty())){
			cc.add(new ICommandProxy(new customDiferedAppliedStereotypeCommand(this.editDomain, (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), "SysML::", VisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION)));
			}

			ConnectionViewDescriptor viewDescriptor = new ConnectionViewDescriptor(org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Link_4022, ((INotationType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Link_4022).getSemanticHint(), ownergep.getDiagramPreferencesHint());

			/* if a containment circle exists, only the dashedline will be create */
			if(!(ownereditpart instanceof PackageEditPart)) {
				if(ownergep.getChildren().toString().contains("ContainmentCircleEditPart")) {
					IGraphicalEditPart circle = ownergep.getChildBySemanticHint(((IHintedType)UMLElementTypes.Port_3032).getSemanticHint());
					cc.add(new ICommandProxy(new customDefferedContainmentLinkCommand(this.editDomain, (EditPartViewer)ownergep.getViewer(), (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), null, ownergep.getDiagramPreferencesHint(), viewDescriptor, location)));
				} else {

					/* Creation of the containment circle node without semantic element */
					cc.add(new ICommandProxy(new customDefferedContainmentNodeCommand(this.editDomain, (View)ownergep.getModel(), (EditPartViewer)ownergep.getViewer(), descriptor.getPreferencesHint())));

					/* Creation of the dashedline between the containment circle node and the target element */
					cc.add(new ICommandProxy(new customDefferedContainmentLinkCommand(this.editDomain, (EditPartViewer)ownergep.getViewer(), (IAdaptable)containedNodeCreationCommand.getCommandResult().getReturnValue(), null, ownergep.getDiagramPreferencesHint(), viewDescriptor, location)));
				}
			}
		}
		return cc;
	}



	/**
	 * The Class customDiferedAppliedStereotypeCommand use to display the applied stereotype.
	 */
	public static class customDiferedAppliedStereotypeCommand extends AbstractTransactionalCommand {

		private IAdaptable adapterdiffered;

		private String stereotype;

		private String kind;

		private TransactionalEditingDomain editingdomain;

		public customDiferedAppliedStereotypeCommand(TransactionalEditingDomain domain, IAdaptable adapter, String appliedStereotypeListToAdd, String presentationKind) {
			super(domain, "AppliedStereotype", null);
			adapterdiffered = adapter;
			stereotype = appliedStereotypeListToAdd;
			kind = presentationKind;
			editingdomain = domain;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CompositeCommand cas = new CompositeCommand("appliedstereotypedrop");
			RecordingCommand steCommand = getDiferedAppliedStereotypeCommand(editingdomain, adapterdiffered, stereotype, kind);
			cas.compose(new EMFtoGMFCommandWrapper(steCommand));
			cas.execute(monitor, info);
			return CommandResult.newOKCommandResult();
		}
	}

	static ContainmentViewCreateCommand circleCommand = null;


	/**
	 * The Class customDefferedContainmentNodeCommand use to create the containment circle around the sourceEditPart.
	 */
	public static class customDefferedContainmentNodeCommand extends AbstractTransactionalCommand {

		private View adapterdiffered;

		private TransactionalEditingDomain editingdomain;

		private EditPartViewer viewerdeffered;

		private PreferencesHint preferencesHintdeffered;

		public customDefferedContainmentNodeCommand(TransactionalEditingDomain domain, View adapter, EditPartViewer viewer, PreferencesHint preferencesHint) {
			super(domain, "CustomDeferredContainmentNodeCommand", null);
			adapterdiffered = adapter;
			editingdomain = domain;
			viewerdeffered = viewer;
			preferencesHintdeffered = preferencesHint;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CompoundCommand mycommand = new CompoundCommand();
			circleCommand = new ContainmentViewCreateCommand(null, getEditingDomain(), (View)adapterdiffered, (EditPartViewer)viewerdeffered, preferencesHintdeffered);
			circleCommand.setLabel("DragDrogContainmentViewCommand");
			mycommand.add(new ICommandProxy(circleCommand));
			mycommand.execute();
			return CommandResult.newOKCommandResult();
		}
	}


	/**
	 * The Class customDefferedContainmentLinkCommand use to create the link between the circle port and the target EditPart.
	 */
	public static class customDefferedContainmentLinkCommand extends AbstractTransactionalCommand {

		private EditPartViewer viewerdeffered;

		private IAdaptable sourceViewAdapterdeffered;

		private ConnectionViewDescriptor viewDescriptordeffered;

		private PreferencesHint diagramPreferencesHintdeffered;

		private Point locationdeferred;

		public customDefferedContainmentLinkCommand(TransactionalEditingDomain domain, EditPartViewer viewer, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, PreferencesHint diagramPreferencesHint, ConnectionViewDescriptor viewDescriptor, Point location) {
			super(domain, "CustomDeferredContainmentLink", null);
			viewerdeffered = viewer;
			sourceViewAdapterdeffered = sourceViewAdapter;
			viewDescriptordeffered = viewDescriptor;
			diagramPreferencesHintdeffered = diagramPreferencesHint;
			locationdeferred = location;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			CompoundCommand mycommand = new CompoundCommand();

			ICommand dashedLineCmd = new org.eclipse.papyrus.diagram.clazz.custom.command.CustomDeferredCreateConnectionViewCommand(getEditingDomain(), ((IHintedType)org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes.Link_4022).getSemanticHint(), sourceViewAdapterdeffered, null, viewerdeffered, diagramPreferencesHintdeffered, viewDescriptordeffered, circleCommand);
			IAdaptable resultat = new SemanticAdapter(null, circleCommand.getCommandResult().getReturnValue());
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "ContainmentCirclePosition", (IAdaptable)resultat, new Point(locationdeferred.x, locationdeferred.y - 100));
			mycommand.add(new ICommandProxy(setBoundsCommand));
			mycommand.add(new ICommandProxy(dashedLineCmd));
			mycommand.execute();
			return CommandResult.newOKCommandResult();
		}
	}

	/**
	 * Gets the difered applied stereotype command.
	 * 
	 * @param domain
	 *        the domain
	 * @param adapter
	 *        the adapter
	 * @param appliedStereotypeListToAdd
	 *        the applied stereotype list to add
	 * @param presentationKind
	 *        the presentation kind
	 * 
	 * @return the difered applied stereotype command
	 */
	public static RecordingCommand getDiferedAppliedStereotypeCommand(TransactionalEditingDomain domain, IAdaptable adapter, String appliedStereotypeListToAdd, String presentationKind) {
		return new DefferedAppliedStereotypeToDisplayCommand(domain, adapter, appliedStereotypeListToAdd, presentationKind);
	}

}
