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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.util.CommandUtil;

/**
 * Restore related links to selected element
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
// Inspired from EcoreTools source code
public class RestoreRelatedLinksCommand extends AbstractTransactionalCommand {

	protected List<?> adapters;

	protected Diagram diagram;

	protected DiagramEditPart host;

	public RestoreRelatedLinksCommand(DiagramEditPart diagramEditPart, List<?> selection) {
		super(diagramEditPart.getEditingDomain(), "Restore related links", null);
		this.host = diagramEditPart;
		this.diagram = host.getDiagramView();
		this.adapters = selection;
	}

	private void cleanAdd(Collection<UMLLinkDescriptor> result, View view, List<?> descriptors) {
		for (Object object : descriptors) {
			if (false == object instanceof UMLLinkDescriptor) {
				continue;
			}
			UMLLinkDescriptor descriptor = (UMLLinkDescriptor) object;
			if (cleanContains(result, descriptor)) {
				continue;
			}
			// check owner
			if (!isOwner(view, descriptor)) {
				continue;
			}
			result.add(descriptor);
		}
	}

	/**
	 * Detect if similar descriptor already exist in given collection.
	 * 
	 * @param collection
	 *            the collection of unique ingoing and outgoing links descriptors
	 * @param umlLinkDescriptor
	 *            the descriptor to search
	 * @return true if already exist
	 */
	private boolean cleanContains(Collection<? extends UMLLinkDescriptor> collection, UMLLinkDescriptor umlLinkDescriptor) {
		for (Object object : collection) {
			if (object instanceof UMLLinkDescriptor) {
				UMLLinkDescriptor descriptor = (UMLLinkDescriptor) object;
				if (descriptor.getModelElement() == umlLinkDescriptor.getModelElement() && descriptor.getSource() == umlLinkDescriptor.getSource() && descriptor.getDestination() == umlLinkDescriptor.getDestination()
						&& descriptor.getVisualID() == umlLinkDescriptor.getVisualID()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Collects all related links for view
	 * 
	 * @param view
	 * @param domain2NotationMap
	 * 
	 * @return linkdescriptors
	 */
	protected Collection<? extends UMLLinkDescriptor> collectPartRelatedLinks(View view, Map<EObject, View> domain2NotationMap) {
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		if (!domain2NotationMap.containsKey(view.getElement())) {
			// We must prevent duplicate descriptors
			List<?> outgoingDescriptors = UMLDiagramUpdater.getOutgoingLinks(view);
			cleanAdd(result, view, outgoingDescriptors);
			List<?> incomingDescriptors = UMLDiagramUpdater.getIncomingLinks(view);
			cleanAdd(result, view, incomingDescriptors);
		}
		if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
			domain2NotationMap.put(view.getElement(), view);
		}
		return result;
	}

	/**
	 * Create related links corresponding to linkDescriptions
	 * 
	 * @param linkDescriptors
	 * @param domain2NotationMap
	 */
	protected void createRelatedLinks(Collection<? extends UMLLinkDescriptor> linkDescriptors, Map<EObject, View> domain2NotationMap) {
		// map diagram
		mapModel(diagram, domain2NotationMap);
		for (UMLLinkDescriptor nextLinkDescriptor : linkDescriptors) {
			EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
			EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
			// If the parts are still null...
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND, false, host.getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				CommandUtil.executeCommand(cmd, host);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// To register all EditPart in the global visualIDRegistry
		host().refresh();
		for (Object object : adapters) {
			if (object instanceof IAdaptable) {
				IAdaptable ad = (IAdaptable) object;
				View view = (View) ad.getAdapter(View.class);
				if (view != null) {
					refreshRelatedLinks(view);
				}
			} else if (object instanceof View) {
				refreshRelatedLinks((View) object);
			}
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Retrieves editpart corresponding to domainModelElement
	 * 
	 * @param domainModelElement
	 * @param domain2NotationMap
	 */
	protected EditPart getEditPart(EObject domainModelElement, Map<? extends EObject, ? extends View> domain2NotationMap) {
		View view = domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) host.getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * Get linkdescriptors of the related links for graphicalEditPart
	 * 
	 * @param graphicalEditPart
	 * @param domain2NotationMap
	 * 
	 * @return linkDescritors
	 */
	protected Collection<? extends UMLLinkDescriptor> getLinkDescriptorToProcess(View notationView, Map<EObject, View> domain2NotationMap) {
		// Collect all related link from semantic model
		Collection<? extends UMLLinkDescriptor> linkDescriptors = collectPartRelatedLinks(notationView, domain2NotationMap);
		// Collect all related link from graphical model
		Collection<Edge> existingLinks = new LinkedList<Edge>();
		for (Object edge : notationView.getTargetEdges()) {
			if (edge instanceof Edge && false == existingLinks.contains(edge)) {
				existingLinks.add((Edge) edge);
			}
		}
		for (Object edge : notationView.getSourceEdges()) {
			if (edge instanceof Edge && false == existingLinks.contains(edge)) {
				existingLinks.add((Edge) edge);
			}
		}
		// Set all existing related link visible
		setViewVisible(existingLinks);
		// Remove already existing links
		for (Iterator<Edge> linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = linksIterator.next();
			int diagramLinkVisualID = UMLVisualIDRegistry.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for (Iterator<? extends UMLLinkDescriptor> LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator.hasNext();) {
				UMLLinkDescriptor nextLinkDescriptor = LinkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination() && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					linksIterator.remove();
					LinkDescriptorsIterator.remove();
				}
			}
		}
		return linkDescriptors;
	}

	/**
	 * @return <code>(IGraphicalEditPart)host()</code>.
	 */
	protected final IGraphicalEditPart host() {
		return host;
	}

	private boolean isOwner(View view, UMLLinkDescriptor descriptor) {
		EObject source = descriptor.getSource();
		EObject dest = descriptor.getDestination();
		if (source != null && source.equals(view.getElement())) {
			return true;
		}
		if (dest != null && dest.equals(view.getElement())) {
			return true;
		}
		return false;
	}

	/**
	 * Maps view
	 * 
	 * @param view
	 * @param domain2NotationMap
	 */
	protected void mapModel(View view, Map<EObject, View> domain2NotationMap) {
		if (!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view))) {
			return;
		}
		// register the view if its type allows incoming or outgoing links
		if (!UMLDiagramUpdater.getOutgoingLinks(view).isEmpty() || !UMLDiagramUpdater.getIncomingLinks(view).isEmpty()) {
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) {
				domain2NotationMap.put(view.getElement(), view);
			}
		}
		@SuppressWarnings("unchecked")
		EList<View> children = view.getChildren();
		for (View child : children) {
			mapModel(child, domain2NotationMap);
		}
		@SuppressWarnings("unchecked")
		EList<View> sourceEdges = view.getSourceEdges();
		for (View edge : sourceEdges) {
			mapModel(edge, domain2NotationMap);
		}
	}

	/**
	 * Refresh related links for graphicalEditPart
	 * 
	 * @param graphicalEditPart
	 */
	protected void refreshRelatedLinks(View notationView) {
		Map<EObject, View> domain2NotationMap = new HashMap<EObject, View>();
		// Create related links
		Collection<? extends UMLLinkDescriptor> linkDescriptors = getLinkDescriptorToProcess(notationView, domain2NotationMap);
		createRelatedLinks(linkDescriptors, domain2NotationMap);
	}

	/**
	 * Set view visible
	 * 
	 * @param part
	 * @param views
	 */
	protected void setViewVisible(Collection<? extends View> views) {
		for (View view : views) {
			if (view.isVisible()) {
				continue;
			}
			SetPropertyCommand cmd = new SetPropertyCommand(host.getEditingDomain(), "Restore related linksCommand show view", new EObjectAdapter(view), PackageUtil.getID(NotationPackage.eINSTANCE.getView_Visible()), Boolean.TRUE);
			if (cmd != null && cmd.canExecute()) {
				CommandUtil.executeCommand(new ICommandProxy(cmd), host);
			}
		}
	}
}
