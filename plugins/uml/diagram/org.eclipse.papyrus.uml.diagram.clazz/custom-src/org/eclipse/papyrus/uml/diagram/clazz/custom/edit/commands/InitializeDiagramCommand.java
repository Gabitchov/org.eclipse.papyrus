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
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
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
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * Initialize diagram elements from a semantic model.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InitializeDiagramCommand extends AbstractTransactionalCommand {

	// protected List<?> adapters;
	protected Diagram diagram;

	protected DiagramEditPart host;

	public InitializeDiagramCommand(DiagramEditPart diagramEditPart) {
		super(diagramEditPart.getEditingDomain(), "Initialize Diagram From Semantic Model", null);
		this.host = diagramEditPart;
		this.diagram = host.getDiagramView();
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// To load visualIDRegistry
		host().refresh();
		List createdViews = new LinkedList();
		createdViews.addAll(populateSemanticNodes());
		if(createdViews.size() > 0) {
			RestoreRelatedLinksCommand restoreRelatedLinksCommand = new RestoreRelatedLinksCommand(((DiagramEditPart)getHost()), createdViews);
			CommandUtil.executeCommand(new ICommandProxy(restoreRelatedLinksCommand), host());
			// DeferredLayoutCommand layoutCmd = new
			// DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			// CommandUtils.executeCommand(new ICommandProxy(layoutCmd), host());
		}
		// Make views immutable
		List viewAdapters = prepareAdapterList(createdViews);
		final Command immutable = SetViewMutabilityCommand.makeImmutable(viewAdapters);
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			public void run() {
				immutable.execute();
			}
		});
		return null;
	}

	/**
	 * Forwards the supplied request to its source if the target is <tt>null</tt>; otherwise it is
	 * forwarded to the target. Forwards the supplied request to the editpart's <code>host</code>.
	 * 
	 * @param request
	 *        a <code>CreareConnecgtorViewRequest</code>
	 * @return Command to create the views in the request
	 */
	protected Command getCreateViewCommand(CreateRequest request) {
		if(request instanceof CreateConnectionViewRequest) {
			CreateConnectionViewRequest ccr = (CreateConnectionViewRequest)request;
			EditPart ep = ccr.getTargetEditPart() == null ? ccr.getSourceEditPart() : ccr.getTargetEditPart();
			return ep.getCommand(request);
		}
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		Command cmd = host().getCommand(request);
		if(cmd == null) {
			assert request instanceof CreateViewRequest;
			Iterator descriptors = ((CreateViewRequest)request).getViewDescriptors().iterator();
			while(descriptors.hasNext()) {
				ViewDescriptor descriptor = (ViewDescriptor)descriptors.next();
				ICommand createCommand = getCreateViewCommand(descriptor);
				cc.compose(createCommand);
			}
		} else {
			cc.compose(new CommandProxy(cmd));
			Iterator descriptors = ((CreateViewRequest)request).getViewDescriptors().iterator();
			while(descriptors.hasNext()) {
				ViewDescriptor descriptor = (ViewDescriptor)descriptors.next();
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
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		CreateCommand createCommand = new CreateCommand(editingDomain, descriptor, (View)getHost().getModel());
		CompositeCommand cmd = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		cmd.compose(createCommand);
		cmd.compose(new CommandProxy(SetViewMutabilityCommand.makeMutable(descriptor)));
		return cmd;
	}

	/**
	 * Return a create view request. The request's location is set to {@link ICanonicalShapeCompartmentLayout#UNDEFINED}.
	 * 
	 * @param descriptors
	 *        a {@link CreateViewRequest.ViewDescriptor} list.
	 * @return a create request
	 */
	protected CreateViewRequest getCreateViewRequest(List descriptors) {
		CreateViewRequest cvr = new CreateViewRequest(descriptors);
		Point loc = ICanonicalShapeCompartmentLayout.UNDEFINED.getLocation();
		cvr.setLocation(loc);
		return cvr;
	}

	/**
	 * @return the current diagram
	 */
	private Diagram getDiagram() {
		return ((View)getHost().getModel()).getDiagram();
	}

	/**
	 * @return <code>(IGraphicalEditPart)host()</code>.
	 */
	protected final IGraphicalEditPart getHost() {
		return host;
	}

	/**
	 * Convenience method to create a view descriptor. Will call {@link #getViewDescriptor(IAdaptable, Class, String, int)}
	 * 
	 * @param element
	 *        semantic element.
	 * @return view descriptor
	 */
	protected ViewDescriptor getViewDescriptor(EObject element) {
		//
		// create the view descritor
		// String factoryHint = getDefaultFactoryHint();
		IAdaptable elementAdapter = new EObjectAdapter(element);// CanonicalElementAdapter(element,
		// factoryHint);
		ViewDescriptor descriptor = getViewDescriptor(elementAdapter, Node.class, null, ViewUtil.APPEND);
		return descriptor;
	}

	/**
	 * Return a view descriptor.
	 * 
	 * @param elementAdapter
	 *        semantic element
	 * @param viewKind
	 *        type of view to create
	 * @param hint
	 *        factory hint
	 * @param index
	 *        index
	 * @return a create <i>non-persisted</i> view descriptor
	 */
	protected ViewDescriptor getViewDescriptor(IAdaptable elementAdapter, Class viewKind, String hint, int index) {
		return new ViewDescriptor(elementAdapter, viewKind, hint, index, false, host().getDiagramPreferencesHint());
	}

	/**
	 * @return <code>(IGraphicalEditPart)host()</code>.
	 */
	protected final IGraphicalEditPart host() {
		return host;
	}

	protected List<ViewDescriptor> populateSemanticNodes() {
		List<ViewDescriptor> descriptors = new ArrayList<ViewDescriptor>();
		View viewObject = (View)getHost().getModel();
		EObject container = getDiagram().getElement();
		if(container instanceof Package) {
			Package rootPackage = (Package)container;
			Iterator<PackageableElement> it = rootPackage.getPackagedElements().iterator();
			while(it.hasNext()) {
				PackageableElement element = it.next();
				if(!(element instanceof AssociationClass)) {
					int visualID = UMLVisualIDRegistry.getNodeVisualID(viewObject, element);
					if(visualID != -1) {
						ViewDescriptor descriptor = getViewDescriptor(element);
						descriptors.add(descriptor);
					}
				}
			}
		}
		if(!descriptors.isEmpty()) {
			// create the request
			CreateViewRequest request = getCreateViewRequest(descriptors);
			// get the command and execute it.
			Command cmd = getCreateViewCommand(request);
			if(cmd != null && cmd.canExecute()) {
				SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
				CommandUtil.executeCommand(cmd, host());
				return (List)request.getNewObject();
			}
		}
		return Collections.EMPTY_LIST;
	}

	private List prepareAdapterList(List createdViews) {
		List viewAdapters = new ArrayList();
		viewAdapters.add(host());
		ListIterator li = createdViews.listIterator();
		while(li.hasNext()) {
			Object obj = li.next();
			if(obj != null) {
				if(!(obj instanceof IAdaptable) && obj instanceof EObject) {
					viewAdapters.add(new EObjectAdapter((EObject)obj));
				} else {
					viewAdapters.add(obj);
				}
			}
		}
		return viewAdapters;
	}
}
