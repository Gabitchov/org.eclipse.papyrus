/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.profile.custom.commands.CustomMetaClassCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.custom.commands.CustomSemanticCreateCommand;
import org.eclipse.papyrus.uml.diagram.profile.custom.requests.CustomCreateElementRequestAdapter;
import org.eclipse.papyrus.uml.diagram.profile.custom.requests.CustomCreateViewAndElementRequest;
import org.eclipse.papyrus.uml.diagram.profile.custom.requests.CustomCreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.papyrus.uml.diagram.profile.custom.requests.CustomCreateViewRequest;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.MetaclassEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfilePackageableElementCompartmentEditPartTN;
import org.eclipse.uml2.uml.Profile;

/**
 * This class provides a custom creation for the metaclass element.
 * It's needed because with the class creation view, the UMLViewProvider doesn't find the good superClass to create it.
 * (Class and Metaclass are represented by an uml class both and it's a probleme for GMF)
 * 
 * 
 * 
 */
public class CustomCreationRoleEditPolicy extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy {
	/**
	 * the IDs of the metaclasses
	 */
	private int[] metaclassesEP_ID = { MetaclassEditPart.VISUAL_ID, MetaclassEditPartCN.VISUAL_ID };
	/**
	 * list the metaclasses EditPart
	 */
	private ArrayList<String> metaclassesEP_ID_List = new ArrayList<String>();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CustomCreationRoleEditPolicy() {
		super();
		init(this.metaclassesEP_ID);
	}

	/**
	 * 
	 * @param metaclassesID
	 */
	private void init(int[] metaclassesID) {
		for (int i = 0; i < metaclassesID.length; i++) {
			this.metaclassesEP_ID_List.add(new String(new Integer(metaclassesID[i]).toString()));
		}
	}

	/**
	 * custom method for the creation of metaclass element
	 * 
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateElementAndViewCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		// we test if it's a command to create a metaclass
		if (!(this.metaclassesEP_ID_List.contains((request).getViewDescriptors().get(0).getSemanticHint()))) {
			return super.getCreateElementAndViewCommand(request);
		}
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor().getCreateElementRequestAdapter();
		/**
		 * We create our own request!
		 */
		CustomCreateElementRequestAdapter customRequestAdapter = new CustomCreateElementRequestAdapter((CreateElementRequest) requestAdapter.getAdapter(CreateElementRequest.class));
		CustomCreateViewAndElementRequest.ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(customRequestAdapter, request.getViewDescriptors().get(0).getViewKind(), request.getViewDescriptors().get(0).getSemanticHint(), request
				.getViewDescriptors().get(0).getPreferencesHint());
		CustomCreateViewAndElementRequest requestNEW = new CustomCreateViewAndElementRequest(viewDescriptor);
		requestNEW.setExtendedData(request.getExtendedData());
		requestNEW.setLocation(request.getLocation());
		// get the semantic request
		CreateElementRequest createElementRequest = (CreateElementRequest) customRequestAdapter.getAdapter(CreateElementRequest.class, 0);
		// createElementRequest = customCreateElementRequest;
		if (createElementRequest.getContainer() == null) {
			// complete the semantic request by filling in the host's semantic
			// element as the context
			View view = (View) getHost().getModel();
			EObject hostElement = ViewUtil.resolveSemanticElement(view);
			if (hostElement == null && view.getElement() == null) {
				hostElement = view;
			}
			// Returns null if host is unresolvable so that trying to create a
			// new element in an unresolved shape will not be allowed.
			if (hostElement == null) {
				return null;
			}
			createElementRequest.setContainer(hostElement);
		}
		// get the create element command based on the elementdescriptor's
		// request
		// Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class), request.getExtendedData()));
		Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateElementRequest) customRequestAdapter.getAdapter(CreateElementRequest.class, 0), request.getExtendedData()));
		if (createElementCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (!createElementCommand.canExecute()) {
			return createElementCommand;
		}
		// create the semantic create wrapper command
		Profile profile = (Profile) createElementRequest.getContainer();
		/**
		 * We use our custom command
		 */
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(profile);
		CustomSemanticCreateCommand semanticCommand = new CustomSemanticCreateCommand(domain, customRequestAdapter, profile);
		Command viewCommand = getCreateCommand(requestNEW);
		// Command refreshConnectionCommand = getHost().getCommand(new RefreshConnectionsRequest(((List)request.getNewObject())));
		// form the compound command and return
		CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);
		cc.compose(new CommandProxy(viewCommand));
		// if(refreshConnectionCommand != null) {
		// cc.compose(new CommandProxy(refreshConnectionCommand));
		// }
		return new ICommandProxy(cc);
	}

	/**
	 * custom method for the CreateViewAndElementRequest (if it's a metaclass)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		if (understandsRequest(request)) {
			if (request instanceof CreateViewAndElementRequest) {
				if (this.metaclassesEP_ID_List.contains(((CreateViewAndElementRequest) request).getViewDescriptors().get(0).getSemanticHint())) {
					// get the correct location for the new metaclass
					Point location = ((CreateViewAndElementRequest) request).getLocation().getCopy();
					((GraphicalEditPart) getHost()).getContentPane().translateToRelative(location);
					((GraphicalEditPart) getHost()).getContentPane().translateFromParent(location);
					location.translate(((GraphicalEditPart) getHost()).getContentPane().getClientArea().getLocation().getNegated());
					((CreateViewAndElementRequest) request).setLocation(location);
					return getCreateElementAndViewCommand((CreateViewAndElementRequest) request);
				}
			}
			return super.getCommand(request);
		}
		return null;
	}

	/**
	 * custom method for the metaclass element
	 * 
	 * Called in response to a <tt>REQ_CREATE</tt> request.
	 * 
	 * Creates a compound command and populated with the following commands for
	 * each element to be created: <BR>
	 * <OL>
	 * <LI>a {@link CreateCommand}for each of the request's view descriptor.
	 * </OL>
	 * 
	 * @param request
	 *            a create request (understands instances of {@link CreateViewRequest}).
	 * @param metaclasses
	 * @return a command to satisfy the request; <tt>null</tt> if the request
	 *         is not understood.
	 */
	private Command getCreateCommand(CustomCreateViewAndElementRequest request) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);
		Iterator<?> descriptors = request.getViewDescriptors().iterator();
		while (descriptors.hasNext()) {
			CustomCreateViewRequest.ViewDescriptor descriptorNEW = (CustomCreateViewRequest.ViewDescriptor) descriptors.next();
			CustomMetaClassCreateCommand createCommand = new CustomMetaClassCreateCommand(editingDomain, descriptorNEW, (View) (getHost().getModel()), request.getLocation());
			cc.compose(createCommand);
		}
		return new ICommandProxy(cc.reduce());
	}

	/** Return a command to reparent both the semantic and view elements. */
	/**
	 * return a command to reparent both the semantic and view elements.
	 * 
	 * @param request
	 *            the request
	 * @return command
	 */
	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator<?> editParts = request.getEditParts().iterator();
		View container = (View) getHost().getAdapter(View.class);
		EObject context = container == null ? null : ViewUtil.resolveSemanticElement(container);
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		while (editParts.hasNext()) {
			EditPart ep = (EditPart) editParts.next();
			if (ep instanceof LabelEditPart) {
				continue;
			}
			if (ep instanceof GroupEditPart) {
				cc.compose(getReparentGroupCommand((GroupEditPart) ep));
			}
			View view = (View) ep.getAdapter(View.class);
			if (view == null) {
				continue;
			}
			EObject semantic = ViewUtil.resolveSemanticElement(view);
			if (semantic == null) {
				cc.compose(getReparentViewCommand((IGraphicalEditPart) ep));
			} else if (context != null && shouldReparent(semantic, context)) {
				cc.compose(getReparentCommand((IGraphicalEditPart) ep));
			}
		}
		return cc.isEmpty() ? null : new ICommandProxy(cc.reduce());
	}

	/**
	 * Return the command to reparent the supplied editpart's semantic and notation
	 * elements.
	 * 
	 * @param gep
	 *            the editpart being reparented
	 * @return A CompositeCommand2 that will reparent both the semantic and notation elements.
	 */
	@Override
	protected ICommand getReparentCommand(IGraphicalEditPart gep) {
		if (!(gep instanceof MetaclassEditPart) && !(gep instanceof MetaclassEditPartCN)) {
			return super.getReparentCommand(gep);
		}
		if (!(getHost() instanceof ProfilePackageableElementCompartmentEditPartTN) && !(getHost() instanceof ProfilePackageableElementCompartmentEditPartCN) && !(getHost() instanceof ProfileDiagramEditPart)) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		cc.compose(getReparentViewCommand(gep));
		return cc;
	}

	/**
	 * Return the command to reparent the supplied editpart's view only.
	 * 
	 * @param gep
	 *            the editpart being reparented
	 * @return A command to reparent the notation element.
	 */
	@Override
	protected ICommand getReparentViewCommand(IGraphicalEditPart gep) {
		if (!(gep instanceof MetaclassEditPart) && !(gep instanceof MetaclassEditPartCN)) {
			return super.getReparentViewCommand(gep);
		}
		CompositeCommand deleteViewCmd = new CompositeCommand("Reparent one metaclass view and delete the others"); //$NON-NLS-1$
		/*
		 * If a metaclass (ElementImport) has dropped many times, we need to reparent the selected view and delete the others!
		 * 
		 * The RemoveOrphanViewEditPolicy can't make it, because it runs too early and short-circuits the AddCommand
		 */
		/**
		 * 1/ get the element
		 * 
		 */
		View metaclassView = (View) gep.getModel();
		EObject element = metaclassView.getElement();
		/**
		 * 2/ get all views for this element view
		 */
		List<?> elementViews = DiagramEditPartsUtil.getEObjectViews(element);
		/**
		 * 3/ delete all the view excepted one
		 */
		for (Object view : elementViews) {
			if (view instanceof View) {
				if (view != metaclassView) {
					deleteViewCmd.add(new DeleteCommand(gep.getEditingDomain(), (View) view));
				}
			}
		}
		View parent = (View) getHost().getModel();
		deleteViewCmd.add(new AddCommand(gep.getEditingDomain(), new EObjectAdapter(parent), new EObjectAdapter(metaclassView)));
		return deleteViewCmd;
	}
}
