package org.eclipse.papyrus.diagram.clazzBis.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.UMLPackage;

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
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPackage_79SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((org.eclipse.papyrus.diagram.clazzBis.part.UMLNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID:
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getPackage_PackagedElement());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
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
		return ((View) getHost().getModel()).getDiagram();
	}

	/**
	 * @generated
	 */
	private Collection refreshConnections() {
		Map domain2NotationMap = new HashMap();
		Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		Collection existingLinks = new LinkedList(getDiagram().getEdges());
		for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			Edge nextDiagramLink = (Edge) linksIterator.next();
			int diagramLinkVisualID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(nextDiagramLink);
			if (diagramLinkVisualID == -1) {
				if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			EObject diagramLinkObject = nextDiagramLink.getElement();
			EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
				org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor nextLinkDescriptor = (org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor) linkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination()
						&& diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
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
	private Collection collectAllLinks(View view, Map domain2NotationMap) {
		if (!org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getModelID(view))) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPackage_79ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getDependency_1001ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getAssociationClass_1002ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getAssociation_1003ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getInstanceSpecification_1004ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getComponent_1005ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getSignal_1006ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getInterface_1007ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getModel_1008ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getEnumeration_1009ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPackage_1010ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getClass_1011ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPrimitiveType_1012ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getDataType_1013ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getConstraint_1014ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getComment_1015ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getSlot_2002ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getRedefinableTemplateSignature_2005ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getInstanceSpecification_2011ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getComponent_2012ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getSignal_2013ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getInterface_2014ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getModel_2015ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getEnumeration_2016ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPackage_2018ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getClass_2019ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPrimitiveType_2024ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getDataType_2025ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getComment_2028ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getConstraint_2029ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getAssociationClass_3002ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getAssociation_3003ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getAssociation_3004ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getGeneralization_3005ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getInterfaceRealization_3006ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getSubstitution_3007ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getRealization_3008ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getAbstraction_3009ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getUsage_3010ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getDependency_3011ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getDependency_3012ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getElementImport_3013ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPackageImport_3014ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getPackageMerge_3015ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getProfileApplication_3016ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID: {
			if (!domain2NotationMap.containsKey(view.getElement())) {
				result.addAll(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramUpdater.getTemplateBinding_3019ContainedLinks(view));
			}
			if (!domain2NotationMap.containsKey(view.getElement()) || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
				domain2NotationMap.put(view.getElement(), view);
			}
			break;
		}
		}
		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
			result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
		}
		for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
			result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors, Map domain2NotationMap) {
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
			final org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor nextLinkDescriptor = (org.eclipse.papyrus.diagram.clazzBis.part.UMLLinkDescriptor) linkDescriptorsIterator.next();
			EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
			EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND,
					false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
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
	private EditPart getEditPart(EObject domainModelElement, Map domain2NotationMap) {
		View view = (View) domain2NotationMap.get(domainModelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}
}
