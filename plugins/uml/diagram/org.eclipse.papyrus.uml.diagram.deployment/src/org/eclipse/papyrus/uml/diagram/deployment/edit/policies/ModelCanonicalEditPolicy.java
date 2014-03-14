/*
 * 
 */
package org.eclipse.papyrus.uml.diagram.deployment.edit.policies;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartACN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ArtifactEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DefaultNamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.LinkDescriptorEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedArtifactNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedDeviceEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedExecutionEnvironmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NestedNodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.NodeEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLNodeDescriptor;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ModelCanonicalEditPolicy extends CanonicalEditPolicy {

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
		case DependencyNodeEditPart.VISUAL_ID:
		case ModelEditPart.VISUAL_ID:
		case PackageEditPart.VISUAL_ID:
		case ConstraintEditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case ExecutionEnvironmentEditPart.VISUAL_ID:
		case DeviceEditPart.VISUAL_ID:
		case ArtifactEditPart.VISUAL_ID:
		case NodeEditPart.VISUAL_ID:
		case DefaultNamedElementEditPart.VISUAL_ID:
			return true;
		}
		return false;
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
		//
		// iteration happens over list of desired semantic elements, trying to find best matching View, while original CEP
		// iterates views, potentially losing view (size/bounds) information - i.e. if there are few views to reference same EObject, only last one 
		// to answer isOrphaned == true will be used for the domain element representation, see #cleanCanonicalSemanticChildren()
		for(Iterator<UMLNodeDescriptor> descriptorsIterator = childDescriptors.iterator(); descriptorsIterator.hasNext();) {
			UMLNodeDescriptor next = descriptorsIterator.next();
			String hint = UMLVisualIDRegistry.getType(next.getVisualID());
			LinkedList<View> perfectMatch = new LinkedList<View>(); // both semanticElement and hint match that of NodeDescriptor
			for(View childView : getViewChildren()) {
				EObject semanticElement = childView.getElement();
				if(next.getModelElement().equals(semanticElement)) {
					if(hint.equals(childView.getType())) {
						perfectMatch.add(childView);
						// actually, can stop iteration over view children here, but
						// may want to use not the first view but last one as a 'real' match (the way original CEP does
						// with its trick with viewToSemanticMap inside #cleanCanonicalSemanticChildren
					}
				}
			}
			if(perfectMatch.size() > 0) {
				descriptorsIterator.remove(); // precise match found no need to create anything for the NodeDescriptor
				// use only one view (first or last?), keep rest as orphaned for further consideration
				knownViewChildren.remove(perfectMatch.getFirst());
			}
		}
		// those left in knownViewChildren are subject to removal - they are our diagram elements we didn't find match to,
		// or those we have potential matches to, and thus need to be recreated, preserving size/location information.
		orphaned.addAll(knownViewChildren);
		//
		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>(childDescriptors.size());
		for(UMLNodeDescriptor next : childDescriptors) {
			String hint = UMLVisualIDRegistry.getType(next.getVisualID());
			IAdaptable elementAdapter = new CanonicalElementAdapter(next.getModelElement(), hint);
			CreateViewRequest.ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(elementAdapter, Node.class, hint, ViewUtil.APPEND, false, host().getDiagramPreferencesHint());
			viewDescriptors.add(descriptor);
		}
		boolean changed = deleteViews(orphaned.iterator());
		//
		CreateViewRequest request = getCreateViewRequest(viewDescriptors);
		Command cmd = getCreateViewCommand(request);
		if(cmd != null && cmd.canExecute()) {
			SetViewMutabilityCommand.makeMutable(new EObjectAdapter(host().getNotationView())).execute();
			executeCommand(cmd);
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
		if(!DeploymentDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view))) {
			return Collections.emptyList();
		}
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case DeploymentDiagramEditPart.VISUAL_ID:
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
				result.addAll(UMLDiagramUpdater.getDependency_2011ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ModelEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getModel_2010ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_2009ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ConstraintEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_2005ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case CommentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComment_2001ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ExecutionEnvironmentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExecutionEnvironment_2002ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DeviceEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDevice_2003ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ArtifactEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getArtifact_2006ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case NodeEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNode_2008ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DefaultNamedElementEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNamedElement_2012ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ModelEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getModel_49ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case PackageEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getPackage_36ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DeviceEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDevice_16ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case NestedDeviceEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDevice_44ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ExecutionEnvironmentEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExecutionEnvironment_21ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case NestedExecutionEnvironmentEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getExecutionEnvironment_46ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case NodeEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNode_23ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case NestedNodeEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getNode_42ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ArtifactEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getArtifact_25ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ArtifactEditPartACN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getArtifact_28ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case NestedArtifactNodeEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getArtifact_40ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case CommentEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getComment_54ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ConstraintEditPartCN.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getConstraint_56ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DeploymentEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDeployment_4001ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case ManifestationEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getManifestation_4002ContainedLinks(view));
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
		case DependencyEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDependency_4004ContainedLinks(view));
			}
			domain2NotationMap.putView(view.getElement(), view);
			break;
		}
		case DependencyBranchEditPart.VISUAL_ID:
		{
			if(!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(UMLDiagramUpdater.getDependency_4010ContainedLinks(view));
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
