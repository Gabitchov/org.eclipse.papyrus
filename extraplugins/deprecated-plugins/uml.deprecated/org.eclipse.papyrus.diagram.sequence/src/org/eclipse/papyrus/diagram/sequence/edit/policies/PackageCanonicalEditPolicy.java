/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.sequence.edit.commands.InitializeInteractionViewCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Interaction2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.sequence.part.UMLLinkDescriptor;
import org.eclipse.papyrus.diagram.sequence.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class PackageCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	@Override
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = UMLDiagramUpdater.getPackage_79SemanticChildren(
				viewObject).iterator(); it.hasNext();) {
			EObject nextValue = ((UMLNodeDescriptor) it.next())
					.getModelElement();
			if (MultiDiagramUtil.findEObjectReferencedInEAnnotation(getHost(),
					nextValue)) {
				result.add(nextValue);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean shouldDeleteView(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		if (view.getType() == ViewType.NOTE || view.getType() == ViewType.TEXT) {
			return false;
		}
		if (view.getElement() != null) {
			int actualID = UMLVisualIDRegistry.getVisualID(view);
			int suggestedID = UMLVisualIDRegistry.getNodeVisualID(
					(View) getHost().getModel(), view.getElement());
			switch (actualID) {
			case InteractionEditPart.VISUAL_ID:
			case CommentEditPart.VISUAL_ID:
				return actualID != suggestedID;
			}
			return false;
		}
		return true;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE
					.getPackage_PackagedElement());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE
					.getElement_OwnedComment());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	@Override
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected boolean shouldIncludeConnection(Edge connector,
			Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());
		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host()
					.getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}
		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
		Diagram diagram = MDTUtil.getHostDiagram(this);

		if (diagram != null) {
			MDTUtil.filterDiagramViews(diagram);
		}
	}

	@Override
	protected Command getCreateViewCommand(CreateRequest request) {
		IGraphicalEditPart host = getHost() instanceof IGraphicalEditPart ? (IGraphicalEditPart) getHost()
				: null;
		CompositeCommand cc = null;
		if (request instanceof CreateViewRequest && host != null
				&& host.getEditingDomain() != null) {
			cc = new CompositeCommand("Initialize Interactions");
			List<Interaction> interactions = extractInteractionsFromRequest((CreateViewRequest) request);
			for (Interaction interaction : interactions) {
				InitializeInteractionViewCommand command = new InitializeInteractionViewCommand(
						host.getEditingDomain(), "Initialize interaction view",
						null);
				command.setInteraction(interaction);
				command.setParentEditPart(host);
				cc.add(command);
			}
		}
		if (cc != null && cc.canExecute()) {
			Command command = super.getCreateViewCommand(request);
			if (command != null && command.canExecute()) {
				return command.chain(new ICommandProxy(cc));
			} else {
				return new ICommandProxy(cc);
			}
		} else {
			return super.getCommand(request);
		}
	}

	protected List<Interaction> extractInteractionsFromRequest(
			CreateViewRequest request) {
		List<Interaction> interactions = new ArrayList<Interaction>();
		List<ViewDescriptor> toRemove = new ArrayList<ViewDescriptor>();
		for (Object object : request.getViewDescriptors()) {
			if (object instanceof ViewDescriptor) {
				ViewDescriptor descriptor = (ViewDescriptor) object;
				Object adapted = descriptor.getElementAdapter().getAdapter(
						Interaction.class);
				if (adapted instanceof Interaction) {
					interactions.add((Interaction) adapted);
					toRemove.add(descriptor);
				}
			}
		}
		for (ViewDescriptor descriptor : toRemove) {
			request.getViewDescriptors().remove(descriptor);
		}
		return interactions;
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private Collection refreshConnections() {
		Domain2Notation domain2NotationMap = new Domain2Notation();
		Collection linkDescriptors = collectAllLinks(getDiagram(),
				domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator
				.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			int diagramLinkVisualID = UMLVisualIDRegistry
					.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null
						&& nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			//don't remove notation-only links 
			if (isNotationOnlyEdge(nextDiagramLink)) {
				linksIterator.remove();
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator
					.hasNext();) {
				UMLLinkDescriptor nextLinkDescriptor = (UMLLinkDescriptor) LinkDescriptorsIterator
						.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement()
						&& diagramLinkSrc == nextLinkDescriptor.getSource()
						&& diagramLinkDst == nextLinkDescriptor
								.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor
								.getVisualID()) {
					linksIterator.remove();
					LinkDescriptorsIterator.remove();
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection collectAllLinks(View view,
			Domain2Notation domain2NotationMap) {
		if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry
				.getModelID(view))) {
			return Collections.EMPTY_LIST;
		}
		List result = new LinkedList();
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getPackage_79ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case InteractionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getInteraction_1001ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CommentEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getComment_2005ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Interaction2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getInteraction_2001ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case LifelineEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getLifeline_2002ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result
						.addAll(UMLDiagramUpdater
								.getBehaviorExecutionSpecification_2003ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case CombinedFragmentEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getCombinedFragment_2004ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case MessageEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getMessage_3001ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Message2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getMessage_3002ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Message3EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getMessage_3003ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Message4EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getMessage_3004ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Message5EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getMessage_3005ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		case Message6EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater
						.getMessage_3006ContainedLinks(view));
			}
			domain2NotationMap.put(view.getElement(), view);
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children
				.hasNext();) {
			View childView = (View) children.next();
			result.addAll(collectAllLinks(childView, domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			View childView = (View) edges.next();
			result.addAll(collectAllLinks(childView, domain2NotationMap));
		}

		if (view instanceof Diagram) {
			result.addAll(getReferencesLinkDescriptors((Diagram) view));
		}
		removeDuplicatedLinks(result);
		purgeCollection(view.getDiagram(), result);
		return result;
	}

	/**
	 * @generated
	 */
	private void removeDuplicatedLinks(List linkDescriptors) {
		List toDelete = new ArrayList();
		for (int i = 0; i < linkDescriptors.size(); i++) {
			java.lang.Object object1 = linkDescriptors.get(i);
			if (object1 instanceof UMLLinkDescriptor) {
				UMLLinkDescriptor linkDescriptor1 = (UMLLinkDescriptor) object1;
				for (int j = i + 1; j < linkDescriptors.size(); j++) {
					java.lang.Object object2 = linkDescriptors.get(j);
					if (object2 instanceof UMLLinkDescriptor) {
						UMLLinkDescriptor linkDescriptor2 = (UMLLinkDescriptor) object2;
						if (checkSameLinkDescriptor(linkDescriptor1,
								linkDescriptor2)) {
							if (toDelete.contains(linkDescriptor2) == false) {
								toDelete.add(linkDescriptor2);
							}
						}
					}
				}
			}
		}
		for (java.lang.Object object : toDelete) {
			linkDescriptors.remove(object);
		}
	}

	/**
	 * @generated
	 */
	private void purgeCollection(Diagram diagram, Collection list) {
		for (Iterator i = list.iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if (obj instanceof Collection) {
				purgeCollection(diagram, (Collection) obj);
			} else {
				if (obj instanceof UMLLinkDescriptor) {
					UMLLinkDescriptor lDes = (UMLLinkDescriptor) obj;
					if (lDes.getModelElement() != null
							&& !MultiDiagramUtil
									.findEObjectReferencedInEAnnotation(
											diagram, lDes.getModelElement())) {
						i.remove();
					}
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private boolean checkSameLinkDescriptor(UMLLinkDescriptor link1,
			UMLLinkDescriptor link2) {
		EObject model1 = link1.getModelElement();
		EObject model2 = link2.getModelElement();
		if (model1 == null && model2 != null) {
			return false;
		}
		if (model1 != null && model2 == null) {
			return false;
		}
		if (model1 != null && model1.equals(model2) == false) {
			return false;
		}

		EObject source1 = link1.getSource();
		EObject source2 = link2.getSource();
		if (source1 == null && source2 != null) {
			return false;
		}
		if (source1 != null && source2 == null) {
			return false;
		}
		if (source1 != null && source1.equals(source2) == false) {
			return false;
		}

		EObject destination1 = link1.getDestination();
		EObject destination2 = link2.getDestination();
		if (destination1 == null && destination2 != null) {
			return false;
		}
		if (destination1 != null && destination2 == null) {
			return false;
		}
		if (destination1 != null && destination1.equals(destination2) == false) {
			return false;
		}

		String type1 = link1.getType();
		String type2 = link2.getType();
		if (type1 == null && type2 != null) {
			return false;
		}
		if (type1 != null && type2 == null) {
			return false;
		}
		if (type1 != null && type1.equals(type2) == false) {
			return false;
		}

		int visualID1 = link1.getVisualID();
		int visualID2 = link2.getVisualID();
		if (visualID1 <= -1 || visualID2 <= -1) {
			return false;
		}
		if (visualID1 != visualID2) {
			return false;
		}

		return true;
	}

	/**
	 * @generated
	 */
	private List getReferencesLinkDescriptors(Diagram diagram) {
		List<EObject> references = MultiDiagramUtil
				.getAllReferencesInEAnnotation(diagram);
		List linkDescriptors = new ArrayList();
		for (EObject eObject : references) {
			if (UMLVisualIDRegistry.getLinkWithClassVisualID(eObject) >= 0) {
				UMLLinkDescriptor linkDescriptor = UMLDiagramUpdater
						.createLinkDescriptorFromModelElement(eObject);
				if (linkDescriptor != null) {
					linkDescriptors.add(linkDescriptor);
				}
			}
		}
		return linkDescriptors;
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors,
			Domain2Notation domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator
				.hasNext();) {
			final UMLLinkDescriptor nextLinkDescriptor = (UMLLinkDescriptor) linkDescriptorsIterator
					.next();
			EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor,
					domain2NotationMap);
			EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor,
					domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
					nextLinkDescriptor.getSemanticAdapter(), null,
					ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost())
							.getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(
					descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement,
			Domain2Notation domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(
					view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private EditPart getSourceEditPart(UMLLinkDescriptor descriptor,
			Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getSource(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private EditPart getTargetEditPart(UMLLinkDescriptor descriptor,
			Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getDestination(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	protected final EditPart getHintedEditPart(EObject domainModelElement,
			Domain2Notation domain2NotationMap, int hintVisualId) {
		View view = (View) domain2NotationMap.getHinted(domainModelElement,
				UMLVisualIDRegistry.getType(hintVisualId));
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(
					view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isNotationOnlyEdge(Edge edge) {
		return false;
	}

	/**
	 * @generated
	 */
	private static class Domain2Notation {
		/**
		 * @generated
		 */
		private final HashMap myMap = new HashMap();

		/**
		 * @generated
		 */
		public boolean containsDomainElement(EObject domainElement) {
			return myMap.containsKey(domainElement);
		}

		/**
		 * @generated
		 */
		public boolean containsKey(EObject domainElement) {
			return containsDomainElement(domainElement);
		}

		/**
		 * @generated
		 */
		public void put(EObject domainElement, View view) {
			Object viewOrList = myMap.get(domainElement);
			if (viewOrList instanceof View) {
				myMap.remove(domainElement);
				List<View> list = new LinkedList<View>();
				list.add((View) viewOrList);
				myMap.put(domainElement, list);
				list.add(view);
			} else if (viewOrList instanceof List) {
				((List) viewOrList).add(view);
			} else {
				myMap.put(domainElement, view);
			}
		}

		/**
		 * @generated
		 */
		public View get(EObject domainEObject) {
			Object viewOrList = myMap.get(domainEObject);
			if (viewOrList instanceof View) {
				return (View) viewOrList;
			}
			if (viewOrList instanceof List) {
				// preferring not-shortcut to shortcut -- important for cases when links arr to/from 
				// the element that is additionally shortcutted to the same diagram
				for (Object next : (List) viewOrList) {
					View nextView = (View) next;
					if (nextView.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
						return nextView;
					}
				}
				return (View) ((List) viewOrList).get(0);
			}
			return null;
		}

		/**
		 * @generated
		 */
		public View getHinted(EObject domainEObject, String hint) {
			if (hint == null) {
				return get(domainEObject);
			}
			Object viewOrList = myMap.get(domainEObject);
			if (viewOrList instanceof View) {
				//no choice, will return what we have
				return (View) viewOrList;
			}
			for (Object next : (List) viewOrList) {
				View nextView = (View) next;
				if (hint.equals(nextView.getType())) {
					return nextView;
				}
			}
			//hint not found -- return what we have
			return (View) ((List) viewOrList).get(0);
		}

	}

	/**
	 * @NOT-generated
	 */
	@Override
	protected boolean shouldHandleNotificationEvent(Notification event) {
		// Created events in a Package don't need to refresh the diagram. This
		// is done to avoid to refresh the diagram
		// before the end of the MessageXCreateCommand. Remember that the Events
		// of a Message are created during
		// the "doDefaultMessageInitialize" operation.
		if (event.getNewValue() instanceof Event) {
			return false;
		}
		return super.shouldHandleNotificationEvent(event);
	}
	
	/**
	 * @NOT-generated
	 * {@inheritDoc}
	 */
	@Override
	public boolean canCreate(EObject object) {
		// The returned value before was true. However, in order to make the Delete 
		// From Diagram action work, it should return false. The elements that shouldn't 
		// have enabled the delete diagram action, are controlled with the
		// SequenceDeleteOnlyViewComponentEditPolicy.
		return false;
	}
}
