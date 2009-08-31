/*
 * Copyright (c) 2007 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright (c) of modifications Conselleria de Infraestructuras y
 * Transporte, Generalitat de la Comunitat Valenciana. All rights reserved.
 * Modifications are made available under the terms of the Eclipse Public
 * License v1.0.
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.PinEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ActivitySubverticesCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * Modified to prevent the elements inside an <ActivityPartition> from being shown in the <Activity>.
	 * 
	 * @generated NOT
	 */
	@Override
	protected List getSemanticChildrenList() {
		List children = getCanonicalSemanticChildrenList();
		return filterSemanticChildrenList(children);
	}

	protected List getCanonicalSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;

		for (Iterator values = ((Activity) modelObject).getNodes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			/**
			 * If it's an ActivityNode and is inside an ActivityPartition, it must not be shown here
			 */
			if (nextValue instanceof ActivityNode) {
				if (((ActivityNode) nextValue).getInPartitions().size() > 0) {
					continue;
				}
			}

			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			switch (nodeVID) {
			case SendObjectActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case SendSignalActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case AcceptEventActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case ActivityFinalNodeEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case DecisionNodeEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case MergeNodeEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case InitialNodeEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case DataStoreNodeEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case OpaqueActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case FlowFinalNodeEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case ForkNodeEditPart.VISUAL_ID: {
				if (MultiDiagramUtil.findEObjectReferencedInEAnnotation(getHost(), nextValue)) {
					result.add(nextValue);
				}
				break;
			}
			case JoinNodeEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case PinEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case CreateObjectActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case CallBehaviorActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			case CallOperationActionEditPart.VISUAL_ID: {
				result.add(nextValue);
				break;
			}
			}
		}
		for (Iterator values = ((Activity) modelObject).getGroups().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();
			nodeVID = UMLVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
			if (ActivityPartitionEditPart.VISUAL_ID == nodeVID) {
				result.add(nextValue);
			}
		}
		// end added code

		return result;
	}

	protected List filterSemanticChildrenList(List children) {
		List toRemove = new ArrayList();
		EObject eObject = null;
		for (Object object : children) {
			eObject = (EObject) Platform.getAdapterManager().getAdapter(object, EObject.class);
			if (!MultiDiagramUtil.findEObjectReferencedInEAnnotation(getHost(), eObject)) {
				toRemove.add(eObject);
			}
		}
		children.removeAll(toRemove);
		return children;
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
			int suggestedID = UMLVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), view.getElement());
			switch (actualID) {
			case SendObjectActionEditPart.VISUAL_ID:
			case SendSignalActionEditPart.VISUAL_ID:
			case AcceptEventActionEditPart.VISUAL_ID:
			case ActivityFinalNodeEditPart.VISUAL_ID:
			case DecisionNodeEditPart.VISUAL_ID:
			case MergeNodeEditPart.VISUAL_ID:
			case InitialNodeEditPart.VISUAL_ID:
			case DataStoreNodeEditPart.VISUAL_ID:
			case OpaqueActionEditPart.VISUAL_ID:
			case FlowFinalNodeEditPart.VISUAL_ID:
			case ForkNodeEditPart.VISUAL_ID:
			case JoinNodeEditPart.VISUAL_ID:
			case PinEditPart.VISUAL_ID:
			case CreateObjectActionEditPart.VISUAL_ID:
			case CallBehaviorActionEditPart.VISUAL_ID:
			case CallOperationActionEditPart.VISUAL_ID:
			case ActivityPartitionEditPart.VISUAL_ID:
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
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getActivity_Node());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getActivity_Group());
		}
		return myFeaturesToSynchronize;
	}

	/**
	 * @generated
	 */
	@Override
	protected void refreshSemantic() {
		super.refreshSemantic();
		// this will take care of the filtering of views
		Diagram diagram = MDTUtil.getHostDiagram(this);
		if (diagram != null) {
			MDTUtil.filterDiagramViews(diagram);
		}
	}

	/**
	 * To make the DeleteFromDiagram action work while preserving the CanonicalEditPolicy for the EditPart.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public boolean canCreate(EObject object) {
		return false;
	}

}
