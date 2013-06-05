/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.edit.policies;

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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.CommentEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ConstraintInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DefaultNamedElementEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShapeNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ShortCutDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseAsRectangleEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UseCaseDiagramCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	private Set<EStructuralFeature> myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected void refreshOnActivate() {
		// Need to activate editpart children before invoking the canonical refresh for EditParts to add event listeners
		List<?> c = getHost().getChildren();
		for(int i = 0; i < c.size(); i++) {
			((EditPart)c.get(i)).activate();
		}
		super.refreshOnActivate();
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("rawtypes")
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		LinkedList<EObject> result = new LinkedList<EObject>();
		List<UMLNodeDescriptor> childDescriptors = UMLDiagramUpdater.getPackage_1000SemanticChildren(viewObject);
		for(UMLNodeDescriptor d : childDescriptors) {
			result.add(d.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection<EObject> semanticChildren, final View view) {
		return isMyDiagramElement(view) && !semanticChildren.contains(view.getElement());
	}

	/**
	 * @generated
	 */
	private boolean isMyDiagramElement(View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch(visualID) {
		case ActorEditPartTN.VISUAL_ID:
		case ActorAsRectangleEditPartTN.VISUAL_ID:
		case UseCaseEditPartTN.VISUAL_ID:
		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
		case SubjectClassifierEditPartTN.VISUAL_ID:
		case PackageEditPartTN.VISUAL_ID:
		case ConstraintEditPartTN.VISUAL_ID:
		case CommentEditPartTN.VISUAL_ID:
		case DefaultNamedElementEditPartTN.VISUAL_ID:
		case ShapeNamedElementEditPart.VISUAL_ID:
		case ShortCutDiagramEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if(myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet<EStructuralFeature>();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		if(resolveSemanticElement() == null) {
			return;
		}
		LinkedList<IAdaptable> createdViews = new LinkedList<IAdaptable>();
		List<UMLNodeDescriptor> childDescriptors = UMLDiagramUpdater.getPackage_1000SemanticChildren((View)getHost().getModel());
		LinkedList<View> orphaned = new LinkedList<View>();
		// we care to check only views we recognize as ours
		LinkedList<View> knownViewChildren = new LinkedList<View>();
		for(View v : getViewChildren()) {
			if(isMyDiagramElement(v)) {
				knownViewChildren.add(v);
			}
		}
		// alternative to #cleanCanonicalSemanticChildren(getViewChildren(), semanticChildren)
		HashMap<UMLNodeDescriptor, LinkedList<View>> potentialViews = new HashMap<UMLNodeDescriptor, LinkedList<View>>();
		//
		// iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
		// iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
		// to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
		for(Iterator<UMLNodeDescriptor> descriptorsIterator = childDescriptors.iterator(); descriptorsIterator.hasNext();) {
			UMLNodeDescriptor next = descriptorsIterator.next();
			String hint = UMLVisualIDRegistry.getType(next.getVisualID());
			LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of NodeDescriptor
			LinkedList<View> potentialMatch = new LinkedList<View>(); // semanticElement matches, hint does not
			for(View childView : getViewChildren()) {
				EObject semanticElement = childView.getElement();
				if(next.getModelElement().equals(semanticElement)) {
					if(hint.equals(childView.getType())) {
						perfectMatch.add(childView);
						// actually, can stop iteration over view children here, but
						// may want to use not the first view but last one as a 'real' match (the way original CEP does
						// with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
					} else {
						potentialMatch.add(childView);
					}
				}
			}
			if(perfectMatch.size() > 0) {
				descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
				// use only one view (first or last?), keep rest as orphaned for further consideration
				knownViewChildren.remove(perfectMatch.getFirst());
			} else if(potentialMatch.size() > 0) {
				potentialViews.put(next, potentialMatch);
			}
		}
		// those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
		// or those we have potential matches to, and thus need to be recreated, preserving size/location information.
		orphaned.addAll(knownViewChildren);
		//
		CompositeTransactionalCommand boundsCommand = new CompositeTransactionalCommand(host().getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize);
		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(childDescriptors.size());
		for(UMLNodeDescriptor next : childDescriptors) {
			String hint = UMLVisualIDRegistry.getType(next.getVisualID());
			IAdaptable elementAdapter = new CanonicalElementAdapter(next.getModelElement(), hint);
			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(elementAdapter, Node.class, hint, ViewUtil.APPEND, false, host().getDiagramPreferencesHint());
			viewDescriptors.add(descriptor);
			LinkedList<View> possibleMatches = potentialViews.get(next);
			if(possibleMatches != null) {
				// from potential matches, leave those that were not eventually used for some other NodeDescriptor (i.e. those left as orphaned)
				possibleMatches.retainAll(knownViewChildren);
			}
			if(possibleMatches != null && !possibleMatches.isEmpty()) {
				View originalView = possibleMatches.getFirst();
				knownViewChildren.remove(originalView); // remove not to copy properties of the same view again and again
				// add command to copy properties
				if(originalView instanceof Node) {
					if(((Node)originalView).getLayoutConstraint() instanceof Bounds) {
						Bounds b = (Bounds)((Node)originalView).getLayoutConstraint();
						boundsCommand.add(new SetBoundsCommand(boundsCommand.getEditingDomain(), boundsCommand.getLabel(), descriptor, new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight())));
					} else if(((Node)originalView).getLayoutConstraint() instanceof Location) {
						Location l = (Location)((Node)originalView).getLayoutConstraint();
						boundsCommand.add(new SetBoundsCommand(boundsCommand.getEditingDomain(), boundsCommand.getLabel(), descriptor, new Point(l.getX(), l.getY())));
					} else if(((Node)originalView).getLayoutConstraint() instanceof Size) {
						Size s = (Size)((Node)originalView).getLayoutConstraint();
						boundsCommand.add(new SetBoundsCommand(boundsCommand.getEditingDomain(), boundsCommand.getLabel(), descriptor, new Dimension(s.getWidth(), s.getHeight())));
					}
				}
			}
		}
		boolean changed = deleteViews(orphaned.iterator());
		//
		CreateViewRequest request = getCreateViewRequest(viewDescriptors);
		Command cmd = getCreateViewCommand(request);
		if(cmd != null && cmd.canExecute()) {
			SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
			executeCommand(cmd);
			if(boundsCommand.canExecute()) {
				executeCommand(new ICommandProxy(boundsCommand.reduce()));
			}
			@SuppressWarnings("unchecked")
			List<IAdaptable> nl = (List<IAdaptable>)request.getNewObject();
			createdViews.addAll(nl);
		}
		if(changed || createdViews.size() > 0) {
			postProcessRefreshSemantic(createdViews);
		}
		Collection<IAdaptable> createdConnectionViews = refreshConnections();
		if(createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}
		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}

	/**
	 * @generated
	 */
	private Diagram getDiagram() {
		return ((View)getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private EditPart getSourceEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getSource(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private EditPart getTargetEditPart(UpdaterLinkDescriptor descriptor, Domain2Notation domain2NotationMap) {
		return getEditPart(descriptor.getDestination(), domain2NotationMap);
	}

	/**
	 * @generated
	 */
	protected final EditPart getHintedEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap, int hintVisualId) {
		View view = (View)domain2NotationMap.getHinted(domainModelElement, UMLVisualIDRegistry.getType(hintVisualId));
		if(view != null) {
			return (EditPart)getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("serial")
	protected static class Domain2Notation extends HashMap<EObject, View> {

		/**
		 * @generated
		 */
		public boolean containsDomainElement(EObject domainElement) {
			return this.containsKey(domainElement);
		}

		/**
		 * @generated
		 */
		public View getHinted(EObject domainEObject, String hint) {
			return this.get(domainEObject);
		}

		/**
		 * @generated
		 */
		public void putView(EObject domainElement, View view) {
			if(!containsKey(view.getElement())) {
				this.put(domainElement, view);
			}
		}
	}

	/**
	 * @generated
	 */
	private Collection<IAdaptable> refreshConnections() {
		Domain2Notation domain2NotationMap = new Domain2Notation();
		Collection<UMLLinkDescriptor> linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for(Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge)linksIterator.next();
			int diagramLinkVisualID = UMLVisualIDRegistry.getVisualID(nextDiagramLink);
			if(diagramLinkVisualID == -1) {
				if(nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for(Iterator<UMLLinkDescriptor> linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
				UMLLinkDescriptor nextLinkDescriptor = linkDescriptorsIterator.next();
				if(diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination() && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					linksIterator.remove();
					linkDescriptorsIterator.remove();
					break;
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	}

	/**
	 * @generated
	 */
	private Collection<UMLLinkDescriptor> collectAllLinks(View view, Domain2Notation domain2NotationMap) {
		if(!UseCaseDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view))) {
			return Collections.emptyList();
		}
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case UseCaseDiagramEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_1000ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ActorEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActor_2011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ActorAsRectangleEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActor_2012ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case UseCaseEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getUseCase_2013ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getUseCase_2014ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case SubjectClassifierEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getClassifier_2015ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_2016ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ConstraintEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_2017ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case CommentEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComment_2018ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DefaultNamedElementEditPartTN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNamedElement_2022ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ShapeNamedElementEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNamedElement_2023ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ShortCutDiagramEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDiagram_2019ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case UseCaseInComponentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getUseCase_3009ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ComponentInComponentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComponent_3016ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case CommentEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComment_3015ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ConstraintInComponentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_3017ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ActorInComponentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActor_3018ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ConstraintInPackageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_3010ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ActorInPackageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getActor_3011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case UseCaseInPackageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getUseCase_3012ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ComponentInPackageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComponent_3013ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_3014ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case IncludeEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInclude_4008ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ExtendEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExtend_4009ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case GeneralizationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getGeneralization_4010ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case AssociationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAssociation_4011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DependencyEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDependency_4013ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case AbstractionEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAbstraction_4015ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case UsageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getUsage_4016ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case RealizationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getRealization_4017ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageMergeEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackageMerge_4018ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageImportEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackageImport_4019ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		}
		for(Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View)children.next(), domain2NotationMap));
		}
		for(Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View)edges.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<IAdaptable> createConnections(Collection<UMLLinkDescriptor> linkDescriptors, Domain2Notation domain2NotationMap) {
		LinkedList<IAdaptable> adapters = new LinkedList<IAdaptable>();
		for(UMLLinkDescriptor nextLinkDescriptor : linkDescriptors) {
			EditPart sourceEditPart = getSourceEditPart(nextLinkDescriptor, domain2NotationMap);
			EditPart targetEditPart = getTargetEditPart(nextLinkDescriptor, domain2NotationMap);
			if(sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), UMLVisualIDRegistry.getType(nextLinkDescriptor.getVisualID()), ViewUtil.APPEND, false, ((IGraphicalEditPart)getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if(cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable)ccr.getNewObject();
				if(viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}

	/**
	 * @generated
	 */
	private EditPart getEditPart(EObject domainModelElement, Domain2Notation domain2NotationMap) {
		View view = (View)domain2NotationMap.get(domainModelElement);
		if(view != null) {
			return (EditPart)getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}
}
