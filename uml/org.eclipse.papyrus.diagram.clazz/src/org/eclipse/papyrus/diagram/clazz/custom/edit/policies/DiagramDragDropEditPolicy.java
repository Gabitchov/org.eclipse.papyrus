/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ICanonicalShapeCompartmentLayout;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Add Drag and drop support on diagram
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiagramDragDropEditPolicy extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy {

	protected Command createViewsAndRestoreRelatedLinks(DropObjectsRequest dropRequest, List<? extends ViewDescriptor> viewDescriptors) {
		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptors);
		createViewRequest.setLocation(dropRequest.getLocation());
		Command createCommand = getHost().getCommand(createViewRequest);
		// Chain restore related links
		// restoreRelatedLinks(createViewRequest, createCommand);

		return createCommand;
	}

	/**
	 * Forwards the supplied request to its source if the target is <tt>null</tt>; otherwise it is forwarded to the target. Forwards the supplied request to the editpart's <code>host</code>.
	 * 
	 * @param request
	 *            a <code>CreareConnecgtorViewRequest</code>
	 * @return Command to create the views in the request
	 */
	protected Command getCreateViewCommand(CreateRequest request) {
		if (request instanceof CreateConnectionViewRequest) {
			CreateConnectionViewRequest ccr = (CreateConnectionViewRequest) request;
			EditPart ep = ccr.getTargetEditPart() == null ? ccr.getSourceEditPart() : ccr.getTargetEditPart();
			return ep.getCommand(request);
		}

		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		Command cmd = ((DiagramEditPart) getHost()).getCommand(request);
		if (cmd == null) {
			assert request instanceof CreateViewRequest;
			Iterator descriptors = ((CreateViewRequest) request).getViewDescriptors().iterator();
			while (descriptors.hasNext()) {
				ViewDescriptor descriptor = (ViewDescriptor) descriptors.next();
				ICommand createCommand = getCreateViewCommand(descriptor);
				cc.compose(createCommand);
			}
		} else {
			cc.compose(new CommandProxy(cmd));
			Iterator descriptors = ((CreateViewRequest) request).getViewDescriptors().iterator();
			while (descriptors.hasNext()) {
				ViewDescriptor descriptor = (ViewDescriptor) descriptors.next();
				cc.compose(new CommandProxy(SetViewMutabilityCommand.makeMutable(descriptor)));
			}
		}
		return new ICommandProxy(cc.reduce());
	}

	/**
	 * @param descriptor
	 * @return ICommand to create a view given a descriptor
	 */
	protected ICommand getCreateViewCommand(ViewDescriptor descriptor) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CreateCommand createCommand = new CreateCommand(editingDomain, descriptor, (View) getHost().getModel());
		CompositeCommand cmd = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		cmd.compose(createCommand);
		cmd.compose(new CommandProxy(SetViewMutabilityCommand.makeMutable(descriptor)));
		return cmd;
	}

	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		List descriptors = new ArrayList();
		Iterator iter = dropRequest.getObjects().iterator();
		while (iter.hasNext()) {
			EObject element = (EObject) iter.next();
			IAdaptable elementAdapter = new EObjectAdapter(element);
			ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND, false, ((DiagramEditPart) getHost()).getDiagramPreferencesHint());
			descriptors.add(descriptor);
		}
		if (!descriptors.isEmpty()) {
			// create the request
			CreateViewRequest request = new CreateViewRequest(descriptors);
			Point loc = ICanonicalShapeCompartmentLayout.UNDEFINED.getLocation();
			request.setLocation(loc);

			// get the command and execute it.
			Command cmd = getCreateViewCommand(request);
			if (cmd != null && cmd.canExecute()) {
				// SetViewMutabilityCommand.makeMutable(new EObjectAdapter(((DiagramEditPart) getHost()).getNotationView())).execute();
				// CommandUtils.executeCommand(cmd, ((DiagramEditPart) getHost()));
				// return (List) request.getNewObject();
			}
			return cmd;
		}
		return null;
		// List viewDescriptors = new ArrayList();
		// Iterator iter = dropRequest.getObjects().iterator();
		//
		// if (dropRequest.getObjects().size() > 0 && dropRequest.getObjects().get(0) instanceof String) {
		// return getDropFileCommand(dropRequest);
		// }
		//
		// while (iter.hasNext()) {
		// EObject eObject = (EObject) iter.next();
		// System.out.println("-----> " + eObject);
		// viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter(eObject), ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint()));
		// }

		// return createViewsAndArrangeCommand(dropRequest, viewDescriptors);
		// return createViewsAndRestoreRelatedLinks(dropRequest, viewDescriptors);
		// return createViewsAndArrangeCommand(dropRequest, viewDescriptors);
	}

}