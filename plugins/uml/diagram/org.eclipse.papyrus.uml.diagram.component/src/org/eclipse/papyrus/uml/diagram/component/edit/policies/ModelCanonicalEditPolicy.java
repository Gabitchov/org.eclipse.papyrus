/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.edit.policies;

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
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.CommentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ConstraintEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.PortEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPartCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.UsageEditPart;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.component.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.component.part.UMLNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelCanonicalEditPolicy.
 * 
 * @generated
 */
public class ModelCanonicalEditPolicy extends CanonicalEditPolicy {

	/** The my features to synchronize. @generated */
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
	 * Gets the features to synchronize.
	 * 
	 * @return the features to synchronize
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if(myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet<EStructuralFeature>();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getNamespace_OwnedRule());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * Gets the semantic children list.
	 * 
	 * @return the semantic children list
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
	 * Checks if is orphaned.
	 * 
	 * @param semanticChildren
	 *        the semantic children
	 * @param view
	 *        the view
	 * @return true, if is orphaned
	 * @generated
	 */
	protected boolean isOrphaned(Collection<EObject> semanticChildren, final View view) {
		return isMyDiagramElement(view) && !semanticChildren.contains(view.getElement());
	}

	/**
	 * Checks if is my diagram element.
	 * 
	 * @param view
	 *        the view
	 * @return true, if is my diagram element
	 * @generated
	 */
	private boolean isMyDiagramElement(View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch(visualID) {
		case DependencyNodeEditPart.VISUAL_ID:
		case ComponentEditPart.VISUAL_ID:
		case ModelEditPart.VISUAL_ID:
		case PackageEditPart.VISUAL_ID:
		case RectangleInterfaceEditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case ConstraintEditPart.VISUAL_ID:
		case DefaultNamedElementEditPart.VISUAL_ID:
		case InterfaceEditPart.VISUAL_ID:
			return true;
		}
		return false;
	}

	/**
	 * Refresh semantic.
	 * 
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
	 * Refresh connections.
	 * 
	 * @return the collection
	 * @generated
	 */
	private Collection<IAdaptable> refreshConnections() {
		Domain2Notation domain2NotationMap = new Domain2Notation();
		Collection<UMLLinkDescriptor> linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for(Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge)linksIterator.next();
			int diagramLinkVisualID = UMLVisualIDRegistry.getVisualID(nextDiagramLink);
			if(diagramLinkVisualID == -1 || diagramLinkVisualID == LinkDescriptorEditPart.VISUAL_ID) {
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
		if(!ComponentDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view))) {
			return Collections.emptyList();
		}
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case ComponentDiagramEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_1000ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DependencyNodeEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDependency_3203ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ComponentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComponent_2002ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ModelEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getModel_3202ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_3200ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case RectangleInterfaceEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInterface_3205ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case CommentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComment_3201ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ConstraintEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_3199ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DefaultNamedElementEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNamedElement_3204ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case InterfaceEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNamedElement_2003ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PortEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPort_3069ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ModelEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getModel_3077ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_3076ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case RectangleInterfaceEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInterface_3078ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ComponentEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComponent_3070ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ComponentEditPartPCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComponent_3071ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case CommentEditPartPCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComment_3074ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ConstraintEditPartPCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_3075ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case InterfaceEditPartPCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInterface_3072ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case UsageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getUsage_4001ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case InterfaceRealizationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getInterfaceRealization_4006ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case GeneralizationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getGeneralization_4003ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case SubstitutionEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getSubstitution_4012ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ManifestationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getManifestation_4014ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ComponentRealizationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComponentRealization_4007ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case AbstractionEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getAbstraction_4013ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DependencyEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDependency_4010ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DependencyBranchEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDependency_4017ContainedLinks(view));
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

	/**
	 * Gets the diagram.
	 * 
	 * @return the diagram
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
}
