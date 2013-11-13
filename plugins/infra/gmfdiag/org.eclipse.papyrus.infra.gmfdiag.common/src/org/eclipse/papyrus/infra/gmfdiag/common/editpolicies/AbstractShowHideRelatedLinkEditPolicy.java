/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.commands.requests.ShowHideRelatedLinkRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;


/**
 * 
 * The editPolicy used to show/hide links
 * 
 */
//Inspired from EcoreTools source code
public abstract class AbstractShowHideRelatedLinkEditPolicy extends AbstractEditPolicy implements IDiagramInformationProviderEditPolicy {

	/**
	 * the key for this edit policy
	 */
	public static final String SHOW_HIDE_RELATED_LINK_ROLE = "ShowHideRelatedLinkEditPolicy"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param host
	 *        the host for this edit policy
	 */
	public AbstractShowHideRelatedLinkEditPolicy(final DiagramEditPart host) {
		setHost(host);
	}

	/**
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	public Command getCommand(final Request req) {
		if(understandsRequest(req)) {
			final ShowHideRelatedLinkRequest request = (ShowHideRelatedLinkRequest)req;

			//0. Obtain the required informations
			//--the map between semantic eobjects and existing views
			final Map<EObject, View> domain2NotationMap = new HashMap<EObject, View>();

			//-- the map between selected EditPart and the semantic existing links
			final Map<EditPart, Set<EObject>> availableLinks = new HashMap<EditPart, Set<EObject>>();

			//-- the list of the links which are currently visible on the diagram
			final Set<EObject> visibleLinks = new HashSet<EObject>();

			//-- the link descriptors
			final Set<UpdaterLinkDescriptor> linksDescriptors = new HashSet<UpdaterLinkDescriptor>();


			//1. resolve all to avoid concurrent modification exception during the call of the method collectPartRelatedLinks
			EcoreUtil.resolveAll(getEditingDomain().getResourceSet());

			//1. bis To register all EditPart in the global visualIDRegistry
			getHost().refresh();

			//2. we associate each view to a semantic element
			mapModel((View)getHost().getAdapter(View.class), domain2NotationMap);

			//3.we collect the link descriptors
			for(final EditPart currentEp : request.getSelectedEditParts()) {
				final View view = (View)currentEp.getAdapter(View.class);
				if(view != null) {
					final Collection<? extends UpdaterLinkDescriptor> desc = collectPartRelatedLinks(view, domain2NotationMap);
					linksDescriptors.addAll(desc);
					final Set<EObject> modelLinks = new HashSet<EObject>();
					final Iterator<? extends UpdaterLinkDescriptor> iter = desc.iterator();

					while(iter.hasNext()) {
						final UpdaterLinkDescriptor current = iter.next();
						final EObject link = current.getModelElement();
						final View dest = domain2NotationMap.get(current.getDestination());
						final View source = domain2NotationMap.get(current.getSource());

						//we add only links for which source and target are already on the diagram
						if(dest != null && source != null) {
							modelLinks.add(link);
						}

						//we build the list of the visible links
						View linkView = domain2NotationMap.get(link);
						if(linkView != null && linkView.isVisible()) {
							visibleLinks.add(link);
						}
					}
					availableLinks.put(currentEp, modelLinks);
				}
			}
			switch(request.getMode()) {
			case OPEN_DIALOG:
				return getShowHideRelatedLinkCommandWithDialog(request.getSelectedEditParts(), availableLinks, visibleLinks, domain2NotationMap, linksDescriptors);
			case SHOW_ALL_LINK_BETWEEN_SELECTED_ELEMENT:
				final Collection<EObject> possibleEnds = new HashSet<EObject>();
				for(final EditPart currentIGraphical : request.getSelectedEditParts()) {
					possibleEnds.add((EObject)currentIGraphical.getAdapter(EObject.class));
				}
				final Collection<UpdaterLinkDescriptor> toRemove = new ArrayList<UpdaterLinkDescriptor>();
				for(final UpdaterLinkDescriptor current : linksDescriptors) {
					final EObject source = current.getSource();
					final EObject target = current.getDestination();
					if(!possibleEnds.contains(source) || !possibleEnds.contains(target)) {
						toRemove.add(current);
					}
				}
				linksDescriptors.removeAll(toRemove);
				//not necessary to remove the eobject links from the map availableLinks
			case SHOW_ALL_LINK_IN_DIAGRAM:
				final Set<EObject> allLinks = new HashSet<EObject>();
				for(final Collection<EObject> currentColl : availableLinks.values()) {
					allLinks.addAll(currentColl);
				}
				allLinks.removeAll(visibleLinks);
				return new ICommandProxy(getShowHideRelatedLinkCommand(getEditingDomain(), allLinks, Collections.emptyList(), domain2NotationMap, linksDescriptors));
			default:
				break;
			}
		}
		return null;
	}

	/**
	 * Collects all related links for view
	 * 
	 * @param view
	 * @param domain2NotationMap
	 * 
	 * @return linkdescriptors
	 */
	protected Collection<? extends UpdaterLinkDescriptor> collectPartRelatedLinks(final View view, final Map<EObject, View> domain2NotationMap) {
		Collection<UpdaterLinkDescriptor> result = new LinkedList<UpdaterLinkDescriptor>();
		DiagramUpdater diagramUpdater = getDiagramUpdater();
		// We must prevent duplicate descriptors
		List<?> outgoingDescriptors = diagramUpdater.getOutgoingLinks(view);
		cleanAdd(result, view, outgoingDescriptors, domain2NotationMap);

		List<?> incomingDescriptors = diagramUpdater.getIncomingLinks(view);
		cleanAdd(result, view, incomingDescriptors, domain2NotationMap);

		if(!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
			domain2NotationMap.put(view.getElement(), view);
		}

		return removeInvalidLinkDescriptor(result);
	}

	/**
	 * 
	 * @return
	 *         the current diagram; hosting this edit policy
	 */
	protected Diagram getCurrentDiagram() {
		return (Diagram)getHost().getAdapter(Diagram.class);
	}


	/**
	 * 
	 * @param descriptors
	 *        the link descriptor
	 * @return
	 *         the collection of link descriptors without some invalid descriptor (we get this case when the link doesn't have source AND target, but
	 *         only ends
	 */
	protected Collection<UpdaterLinkDescriptor> removeInvalidLinkDescriptor(final Collection<UpdaterLinkDescriptor> descriptors) {
		final Collection<UpdaterLinkDescriptor> toRemove = new ArrayList<UpdaterLinkDescriptor>();
		final Collection<UpdaterLinkDescriptor> toAdd = new ArrayList<UpdaterLinkDescriptor>();
		for(final UpdaterLinkDescriptor current : descriptors) {
			if(current.getModelElement() == null) {
				final IElementType elementType = (IElementType)current.getSemanticAdapter().getAdapter(IElementType.class);
				final EdgeWithNoSemanticElementRepresentationImpl noSemantic = new EdgeWithNoSemanticElementRepresentationImpl(current.getSource(), current.getDestination(), ((IHintedType)elementType).getSemanticHint());
				final UpdaterLinkDescriptor replacement = new UpdaterLinkDescriptor(current.getSource(), current.getDestination(), noSemantic, elementType, current.getVisualID());
				toRemove.add(current);
				toAdd.add(replacement);
			}
		}

		descriptors.removeAll(toRemove);
		descriptors.addAll(toAdd);
		return descriptors;
	}

	/**
	 * 
	 * @param result
	 *        the result of the call to this method
	 * @param view
	 *        the current view
	 * @param descriptors
	 *        links descriptors for links related to this view
	 * @param domain2NotationMap
	 *        the map between model element and views
	 */
	protected void cleanAdd(Collection<UpdaterLinkDescriptor> result, View view, List<?> descriptors, Map<EObject, View> domain2NotationMap) {
		for(Object object : descriptors) {
			if(false == object instanceof UpdaterLinkDescriptor) {
				continue;
			}
			UpdaterLinkDescriptor descriptor = (UpdaterLinkDescriptor)object;
			if(cleanContains(result, descriptor)) {
				continue;
			}
			// check owner
			if(!isOwner(view, descriptor)) {
				continue;
			}
			result.add(descriptor);
		}
	}

	private boolean isOwner(View view, UpdaterLinkDescriptor descriptor) {
		EObject source = descriptor.getSource();
		EObject dest = descriptor.getDestination();
		if(source != null && source.equals(view.getElement())) {
			return true;
		}
		if(dest != null && dest.equals(view.getElement())) {
			return true;
		}
		return false;
	}

	/**
	 * Detect if similar descriptor already exist in given collection.
	 * 
	 * @param collection
	 *        the collection of unique ingoing and outgoing links descriptors
	 * @param umlLinkDescriptor
	 *        the descriptor to search
	 * @return true if already exist
	 */
	private boolean cleanContains(Collection<? extends UpdaterLinkDescriptor> collection, UpdaterLinkDescriptor umlLinkDescriptor) {
		for(Object object : collection) {
			if(object instanceof UpdaterLinkDescriptor) {
				UpdaterLinkDescriptor descriptor = (UpdaterLinkDescriptor)object;
				if(descriptor.getModelElement() == umlLinkDescriptor.getModelElement() && descriptor.getSource() == umlLinkDescriptor.getSource() && descriptor.getDestination() == umlLinkDescriptor.getDestination() && descriptor.getVisualID() == umlLinkDescriptor.getVisualID()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public boolean understandsRequest(final Request request) {
		return request instanceof ShowHideRelatedLinkRequest;
	}

	/**
	 * 
	 * @param selectedEditParts
	 *        the selected edit parts
	 * @param availableLinks
	 *        a map with the selected edit parts and their available links
	 * @param domain2NotationMap
	 *        a map between existing views and semantic elements
	 * @param linksDescriptors
	 *        the link descriptors
	 * @return
	 *         the command to open a dialog and Show/Hide the related links
	 */
	protected abstract Command getShowHideRelatedLinkCommandWithDialog(final Collection<EditPart> selectedEditParts, final Map<EditPart, Set<EObject>> availableLinks, final Set<EObject> visibleLinks, final Map<EObject, View> domain2NotationMap, Collection<UpdaterLinkDescriptor> linksDescriptors);

	/**
	 * 
	 * @return
	 *         the editing domain to use
	 */
	protected final TransactionalEditingDomain getEditingDomain() {
		try {
			return ServiceUtilsForEditPart.getInstance().getTransactionalEditingDomain(getHost());
		} catch (ServiceException e) {
			Activator.log.error("Editing Domain not found", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain to use
	 * @param previousCommand
	 *        the previous command
	 * @param initialSelection
	 *        the initial selection
	 * @param domain2NotationMap
	 *        the map referencing the eobject to their existing view
	 * @param linkDescriptor
	 *        the link descriptors
	 * @return
	 *         the command to show/hide links according to the previous command result
	 */
	protected ICommand getComputeCommandResultCommand(final TransactionalEditingDomain domain, final ICommand previousCommand, final Set<EObject> initialSelection, final Map<EObject, View> domain2NotationMap, final Collection<UpdaterLinkDescriptor> linkDescriptor) {
		final ICommand computeCommand = new AbstractTransactionalCommand(domain, "Compute Result", null) {//$NON-NLS-1$

			/**
			 * 
			 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
			 *      org.eclipse.core.runtime.IAdaptable)
			 * 
			 * @param monitor
			 * @param info
			 * @return
			 * @throws ExecutionException
			 */
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final Object returnedValue = previousCommand.getCommandResult().getReturnValue();
				if(previousCommand.getCommandResult().getStatus().isOK()) {
					if(returnedValue instanceof Collection<?>) {
						final Collection<?> res = (Collection<?>)returnedValue;
						final Set<?> toAdd = new HashSet<Object>(res);
						toAdd.removeAll(initialSelection);
						final Set<?> toHide = new HashSet<Object>(initialSelection);
						toHide.removeAll(res);
						final ICommand cmd = getShowHideRelatedLinkCommand(domain, toAdd, toHide, domain2NotationMap, linkDescriptor);
						if(cmd.canExecute()) {
							cmd.execute(monitor, info);
						} else {
							Activator.log.error(new UnexpectedException("The command is not executable"));//$NON-NLS-1$
						}
					}
				} else {
					return previousCommand.getCommandResult();
				}
				return CommandResult.newOKCommandResult(returnedValue);
			}
		};
		return computeCommand;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param toShow
	 *        the list of the link to show
	 * @param toHide
	 *        the list of the link to hide
	 * @param domain2NotationMap
	 *        a map linking the eobject to their view
	 * @param linkDescriptors
	 *        the link descriptor
	 * @return
	 *         the command to show/hide the links, according to the args of this method
	 */
	protected final ICommand getShowHideRelatedLinkCommand(final TransactionalEditingDomain domain, final Collection<?> toShow, final Collection<?> toHide, final Map<EObject, View> domain2NotationMap, final Collection<? extends UpdaterLinkDescriptor> linkDescriptors) {
		final CompositeCommand compositeCommand = new CompositeCommand("Show/Hide Related Link");//$NON-NLS-1$
		for(final Object current : toShow) {
			if(current instanceof EObject) {
				final ICommand tmp = getShowLinkCommand(domain, (EObject)current, domain2NotationMap, linkDescriptors);
				if(tmp != null && tmp.canExecute()) {
					compositeCommand.add(tmp);
				}
			}
		}
		for(final Object current : toHide) {
			if(current instanceof EObject) {
				final ICommand tmp = getHideLinkCommand(domain, (EObject)current, domain2NotationMap, linkDescriptors);
				if(tmp != null && tmp.canExecute()) {
					compositeCommand.add(tmp);
				}
			}
		}
		return compositeCommand;
	}


	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param linkToHide
	 *        the link to hide
	 * @param domain2NotationMap
	 *        the map between eobjects and views
	 * @param linkDescriptors
	 *        the link descriptors
	 * @return
	 *         the command to hide the wanted link
	 */
	protected ICommand getHideLinkCommand(final TransactionalEditingDomain domain, final EObject linkToHide, final Map<EObject, View> domain2NotationMap, final Collection<? extends UpdaterLinkDescriptor> linkDescriptors) {
		final UpdaterLinkDescriptor descriptor = getLinkDescriptor(linkToHide, linkDescriptors);
		if(descriptor != null) {
			final View view = domain2NotationMap.get(linkToHide);
			final EditPart editPart = DiagramEditPartsUtil.getEditPartFromView(view, getHost());
			return new CommandProxy(editPart.getCommand(new GroupRequest(RequestConstants.REQ_DELETE)));
		}
		return null;
	}

	/**
	 * 
	 * @param link
	 *        a link
	 * @param descriptors
	 *        the list of the known descriptors
	 * @return
	 *         the link descriptor for this link or <code>null</code> if not found
	 */
	protected final UpdaterLinkDescriptor getLinkDescriptor(final EObject link, final Collection<? extends UpdaterLinkDescriptor> descriptors) {
		final Iterator<? extends UpdaterLinkDescriptor> iter = descriptors.iterator();
		while(iter.hasNext()) {
			final UpdaterLinkDescriptor current = iter.next();
			if(current.getModelElement() == link) {
				return current;
			}
		}
		return null;
	}



	/**
	 * Maps view
	 * 
	 * @param view
	 * @param domain2NotationMap
	 */
	protected void mapModel(View view, Map<EObject, View> domain2NotationMap) {
		if(!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
			if((view instanceof Connector || view instanceof Shape) && !(view instanceof BasicCompartment)) {
				EObject element = view.getElement();
				if(element == null) {
					final EObject source = ((Connector)view).getSource().getElement();
					final EObject target = ((Connector)view).getTarget().getElement();
					element = new EdgeWithNoSemanticElementRepresentationImpl(source, target, view.getType());
				}
				domain2NotationMap.put(element, view);
			}
		}

		@SuppressWarnings("unchecked")//$NON-NLS-1$
		List<View> children = view.getChildren();
		for(View child : children) {
			mapModel(child, domain2NotationMap);
		}
		@SuppressWarnings("unchecked")//$NON-NLS-1$
		List<View> sourceEdges = view.getSourceEdges();
		for(View edge : sourceEdges) {
			mapModel(edge, domain2NotationMap);
		}
	}


	/**
	 * 
	 * @param domain
	 *        the editing domain to use for this command
	 * @param linkToShow
	 *        a link to show
	 * @param domain2NotationMap
	 * @param linkDescriptors
	 * @return
	 *         the command to display the link on the diagram
	 */
	protected ICommand getShowLinkCommand(final TransactionalEditingDomain domain, final EObject linkToShow, final Map<EObject, View> domain2NotationMap, final Collection<? extends UpdaterLinkDescriptor> linkDescriptors) {
		mapModel((View)getHost().getAdapter(View.class), domain2NotationMap);
		final View view = domain2NotationMap.get(linkToShow);
		if(view != null) {
			return new SetPropertyCommand(domain, "Restore related linksCommand show view", new EObjectAdapter(view), Properties.ID_ISVISIBLE, Boolean.TRUE);//$NON-NLS-1$
		} else {//we need to recreate the view

			//we look for the link descriptor
			UpdaterLinkDescriptor descriptor = getLinkDescriptor(linkToShow, linkDescriptors);
			if(linkToShow instanceof EdgeWithNoSemanticElementRepresentationImpl) {
				//we replace the specific link descriptor by a new one, with no model element (if not the view provider refuse to create the view
				final IElementType elementType = (IElementType)descriptor.getSemanticAdapter().getAdapter(IElementType.class);
				descriptor = new UpdaterLinkDescriptor(descriptor.getSource(), descriptor.getDestination(), elementType, descriptor.getVisualID());
			}
			if(descriptor != null) {
				EditPart sourceEditPart = getEditPart(descriptor.getSource(), domain2NotationMap);
				EditPart targetEditPart = getEditPart(descriptor.getDestination(), domain2NotationMap);

				// If the parts are still null...
				if(sourceEditPart == null || targetEditPart == null) {
					return null;
				}
				String semanticHint = getSemanticHint(linkToShow);
				if(semanticHint == null) {
					semanticHint = ((IHintedType)descriptor.getSemanticAdapter().getAdapter(IElementType.class)).getSemanticHint();
				}
				CreateConnectionViewRequest.ConnectionViewDescriptor viewDescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(descriptor.getSemanticAdapter(), semanticHint, ViewUtil.APPEND, false, ((GraphicalEditPart)getHost()).getDiagramPreferencesHint());
				CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(viewDescriptor);
				ccr.setType(RequestConstants.REQ_CONNECTION_START);
				ccr.setSourceEditPart(sourceEditPart);
				sourceEditPart.getCommand(ccr);
				ccr.setTargetEditPart(targetEditPart);
				ccr.setType(RequestConstants.REQ_CONNECTION_END);
				return new CommandProxy(targetEditPart.getCommand(ccr));
			}
		}
		return null;
	}

	/**
	 * 
	 * @param eobject
	 *        an eobject
	 * @return
	 *         the semantic hint to use for this eobject
	 */
	protected String getSemanticHint(final EObject eobject) {
		return null;
	}

	/**
	 * Retrieves editpart corresponding to domainModelElement
	 * 
	 * @param domainModelElement
	 * @param domain2NotationMap
	 */
	protected EditPart getEditPart(final EObject domainModelElement, Map<? extends EObject, ? extends View> domain2NotationMap) {
		View view = domain2NotationMap.get(domainModelElement);
		if(view != null) {
			return (EditPart)getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the label provider to use in the dialog
	 */
	protected abstract ILabelProvider getLabelProvider();

	/**
	 * 
	 * Content provider for the dialog
	 * 
	 */
	public static class LinkContentProvider implements ITreeContentProvider {

		/**
		 * the map between selected graphical elements and their available links
		 */
		private final Map<EditPart, Set<EObject>> availableLinks;


		public LinkContentProvider(final Map<EditPart, Set<EObject>> availableLinks) {
			this.availableLinks = availableLinks;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 * 
		 */
		public void dispose() {
			this.availableLinks.clear();
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 * 
		 * @param viewer
		 * @param oldInput
		 * @param newInput
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
		 * 
		 * @param inputElement
		 * @return
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof Collection<?>) {
				return ((Collection<?>)inputElement).toArray();
			}
			return new Object[0];
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 * 
		 * @param parentElement
		 * @return
		 */
		public Object[] getChildren(Object parentElement) {
			if(this.availableLinks.containsKey(parentElement)) {
				return this.availableLinks.get(parentElement).toArray();
			}
			return new Object[0];
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Object getParent(Object element) {
			final Iterator<Entry<EditPart, Set<EObject>>> iter = this.availableLinks.entrySet().iterator();
			while(iter.hasNext()) {
				final Entry<EditPart, Set<EObject>> current = iter.next();
				if(current.getValue().contains(element)) {
					return current.getKey();
				}
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public boolean hasChildren(Object element) {
			if(this.availableLinks.containsKey(element)) {
				return this.availableLinks.get(element).size() != 0;
			}
			return false;
		}

	}

}
