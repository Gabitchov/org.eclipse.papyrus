/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.listeners;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.diagram.activity.helper.UMLValidationHelper;
import org.eclipse.papyrus.uml.diagram.common.listeners.AbstractPapyrusModifcationTriggerListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

/**
 * Listen the {@link UMLPackage.Literals#ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION} feature in orfer to prevetn it to violate the constaint
 * "Interrupting edges of a region must have their source node in the region and their target node outside the region in the same activity containing the region."
 * 
 * @author adaussy
 * 
 */
public class InInterruptibleActivityRegionListener extends AbstractPapyrusModifcationTriggerListener {

	private static NotificationFilter FEATURE_FILTER = null;

	public static NotificationFilter getFEATURE_FILTER() {
		if(FEATURE_FILTER == null) {
			FEATURE_FILTER = NotificationFilter.createFeatureFilter(UMLPackage.Literals.ACTIVITY_NODE__IN_INTERRUPTIBLE_REGION);
		}
		return FEATURE_FILTER;
	}

	protected ActivityNode getElement(Notification notif) {
		try {
			return (ActivityNode)notif.getNotifier();
		} catch (ClassCastException e) {
			throw new RuntimeException("InInterruptibleActivityRegionListener should only be notified by ActivityNode");
		}
	}

	/**
	 * Get the list of all starting or ending Interruptible Edge wich are related to this {@link ActivityNode} and its descendant.
	 * Those Iterable can be filled with null elements so test each element for null
	 * 
	 * @param node
	 * @return
	 */
	public Iterator<Iterable<ActivityEdge>> getActivityEdgeImpactedWithThisChange(ActivityNode node) {
		Iterator<Iterable<ActivityEdge>> activityEdges = Iterators.transform(Iterators.concat(Collections.singleton(node).iterator(), node.eAllContents()), new Function<EObject, Iterable<ActivityEdge>>() {

			public Iterable<ActivityEdge> apply(EObject from) {
				if(from instanceof ActivityNode) {
					ActivityNode activityNode = (ActivityNode)from;
					Iterable<ActivityEdge> incomingInterruptibleEdge = Iterables.filter(activityNode.getIncomings(), new Predicate<EObject>() {

						public boolean apply(EObject input) {
							if(input instanceof ActivityEdge) {
								return ((ActivityEdge)input).getInterrupts() != null;
							}
							return false;
						}
					});
					Iterable<ActivityEdge> outcomingEdgeInterruptibleEdge = Iterables.filter(activityNode.getOutgoings(), new Predicate<EObject>() {

						public boolean apply(EObject input) {
							if(input instanceof ActivityEdge) {
								return ((ActivityEdge)input).getInterrupts() != null;
							}
							return false;
						}
					});
					Iterable<ActivityEdge> allInterruptibleEdge = Iterables.concat(outcomingEdgeInterruptibleEdge, incomingInterruptibleEdge);
					if(!Iterables.isEmpty(allInterruptibleEdge)) {
						return allInterruptibleEdge;
					}
				}
				return null;
			}
		});
		return activityEdges;
	}

	@Override
	public NotificationFilter getFilter() {
		return getFEATURE_FILTER();
	}

	@Override
	protected ICommand getModificationCommand(Notification notif) {
		ActivityNode node = getElement(notif);
		//Get the the interruptible Edge Starting or Going from this node or its descendant
		Iterator<Iterable<ActivityEdge>> activityEdges = getActivityEdgeImpactedWithThisChange(node);
		while(activityEdges.hasNext()) {
			Iterable<ActivityEdge> interruptibleEdge = activityEdges.next();
			if(interruptibleEdge != null) {
				for(ActivityEdge interrpEdge : interruptibleEdge) {
					if(!UMLValidationHelper.validateInterruptibleEdge(interrpEdge, interrpEdge.getInterrupts())) {
						NotificationBuilder popup = new NotificationBuilder().setAsynchronous(true).setTemporary(true).setMessage("The Activity Edge " + interrpEdge.getName() + " can not interrupt its referencing region because it violates a constraint").setType(Type.INFO);
						popup.run();
						return new EMFtoGMFCommandWrapper(new SetCommand(getDiagramEditPart().getEditingDomain(), interrpEdge, UMLPackage.Literals.ACTIVITY_EDGE__INTERRUPTS, null));
					}
				}
			}
		}
		return null;
	}

	/**
	 * get the edit part registry
	 * 
	 * @return
	 */
	protected DiagramEditPart getDiagramEditPart() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof IMultiDiagramEditor) {
			IMultiDiagramEditor papyrusEditor = (IMultiDiagramEditor)editor;
			return (DiagramEditPart)papyrusEditor.getAdapter(DiagramEditPart.class);
		}
		return null;
	}
}
