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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.DurationConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InteractionConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.IntervalConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendObjectActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SendSignalActionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPostcondEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.TimeConstraintAsLocalPrecondEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.papyrus.diagram.activity.part.UMLNodeDescriptor;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ActivityActivityContentCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View)getHost().getModel();
		List result = new LinkedList();
		for(Iterator it = UMLDiagramUpdater.getActivityActivityContentCompartment_7004SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((UMLNodeDescriptor)it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch(visualID) {
		case InitialNodeEditPart.VISUAL_ID:
		case ActivityFinalNodeEditPart.VISUAL_ID:
		case FlowFinalNodeEditPart.VISUAL_ID:
		case OpaqueActionEditPart.VISUAL_ID:
		case CallBehaviorActionEditPart.VISUAL_ID:
		case CallOperationActionEditPart.VISUAL_ID:
		case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
		case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
		case DecisionNodeEditPart.VISUAL_ID:
		case MergeNodeEditPart.VISUAL_ID:
		case ForkNodeEditPart.VISUAL_ID:
		case JoinNodeEditPart.VISUAL_ID:
		case SendObjectActionEditPart.VISUAL_ID:
		case SendSignalActionEditPart.VISUAL_ID:
			if(!semanticChildren.contains(view.getElement())) {
				return true;
			}
			EObject domainModelElement = view.getElement();
			if(visualID != UMLVisualIDRegistry.getNodeVisualID((View)getHost().getModel(), domainModelElement)) {
				List createdViews = createViews(Collections.singletonList(domainModelElement));
				assert createdViews.size() == 1;
				final View createdView = (View)((IAdaptable)createdViews.get(0)).getAdapter(View.class);
				if(createdView != null) {
					try {
						new AbstractEMFOperation(host().getEditingDomain(), StringStatics.BLANK, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE)) {

							protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								populateViewProperties(view, createdView);
								return Status.OK_STATUS;
							}
						}.execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						UMLDiagramEditorPlugin.getInstance().logError("Error while copyign view information to newly created view", e); //$NON-NLS-1$
					}
				}
				deleteViews(Collections.singletonList(view).iterator());
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	private void populateViewProperties(View oldView, View newView) {
		if(oldView instanceof Node && newView instanceof Node) {
			Node oldNode = (Node)oldView;
			Node newNode = (Node)newView;
			if(oldNode.getLayoutConstraint() instanceof Location && newNode.getLayoutConstraint() instanceof Location) {
				((Location)newNode.getLayoutConstraint()).setX(((Location)oldNode.getLayoutConstraint()).getX());
				((Location)newNode.getLayoutConstraint()).setY(((Location)oldNode.getLayoutConstraint()).getY());
			}
			if(oldNode.getLayoutConstraint() instanceof Size && newNode.getLayoutConstraint() instanceof Size) {
				((Size)newNode.getLayoutConstraint()).setWidth(((Size)oldNode.getLayoutConstraint()).getWidth());
				((Size)newNode.getLayoutConstraint()).setHeight(((Size)oldNode.getLayoutConstraint()).getHeight());
			}
			if(oldNode.getLayoutConstraint() instanceof Ratio && newNode.getLayoutConstraint() instanceof Ratio) {
				((Ratio)newNode.getLayoutConstraint()).setValue(((Ratio)oldNode.getLayoutConstraint()).getValue());
			}
			newNode.persist();
		}
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
		if(myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getActivity_Node());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getAction_LocalPrecondition());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getAction_LocalPostcondition());
		}
		return myFeaturesToSynchronize;
	}

}
