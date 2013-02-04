/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineTimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.swt.widgets.Display;

public class ViewUtils {

	public static View findFullLifelineCompartmentView(final View lifelineView) {
		final List<View> timelineCompartmentViews = findSubViewsWithId(lifelineView, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		if(timelineCompartmentViews.size() < 1) {
			throw new IllegalStateException("No timeline compartment found in the lifeline View"); //$NON-NLS-1$
		}
		return timelineCompartmentViews.get(0);
	}

	public static View findCompactTimelineCompartmentView(final View lifelineView) {
		final List<View> timelineCompartmentViews = findSubViewsWithId(lifelineView, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
		if(timelineCompartmentViews.size() < 1) {
			throw new IllegalStateException("No timeline compartment found in the lifeline View"); //$NON-NLS-1$
		}
		return timelineCompartmentViews.get(0);
	}

	public static View findChildTimelineCompartmentView(final View view) {
		List<View> timelineCompartmentViews = findSubViewsWithId(view, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		if(!timelineCompartmentViews.isEmpty()) {
			return timelineCompartmentViews.get(0);
		}
		timelineCompartmentViews = findSubViewsWithId(view, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
		if(!timelineCompartmentViews.isEmpty()) {
			return timelineCompartmentViews.get(0);
		}
		throw new IllegalStateException("No timeline compartment found in the given View"); //$NON-NLS-1$
	}

	public static View findTimeRulerCompartmentView(final View view) {
		List<View> timeRulerCompartmentViews = findSubViewsWithId(view, TimeRulerCompartmentEditPartCN.VISUAL_ID);
		if(!timeRulerCompartmentViews.isEmpty()) {
			return timeRulerCompartmentViews.get(0);
		}
		timeRulerCompartmentViews = findSubViewsWithId(view, FullLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID);
		if(!timeRulerCompartmentViews.isEmpty()) {
			return timeRulerCompartmentViews.get(0);
		}
		timeRulerCompartmentViews = findSubViewsWithId(view, CompactLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID);
		if(!timeRulerCompartmentViews.isEmpty()) {
			return timeRulerCompartmentViews.get(0);
		}
		throw new IllegalStateException("No timeruler compartment found in the View"); //$NON-NLS-1$
	}

	public static View findInteractionCompartmentView(final View interactionView) {
		final List<View> timelineCompartmentViews = findSubViewsWithId(interactionView, InteractionCompartmentEditPartTN.VISUAL_ID);
		if(timelineCompartmentViews.isEmpty()) {
			throw new IllegalStateException("No interaction compartment found in the interaction View"); //$NON-NLS-1$
		}
		return timelineCompartmentViews.get(0);
	}

	public static View findStateDefinitionCompartmentView(final View lifelineView) {
		final List<View> timelineCompartmentViews = findSubViewsWithId(lifelineView, FullLifelineStateDefinitionCompartmentEditPartCN.VISUAL_ID);
		if(timelineCompartmentViews.isEmpty()) {
			throw new IllegalStateException("No state definition compartment found in the lifeline View"); //$NON-NLS-1$
		}
		return timelineCompartmentViews.get(0);
	}

	public static View findFirstChildViewWithId(final View view, final int visualId) {
		final List<View> result = findSubViewsWithId(view, visualId);
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public static List<View> findSubViewsWithId(final View view, final int visualId) {
		final List<View> views = new ArrayList<View>();
		internalFindSubViewsWithId(view, visualId, views);
		return views;
	}

	private static List<View> internalFindSubViewsWithId(final View view, final int visualId, final List<View> result) {
		// the javadoc says it's a list of Views
		@SuppressWarnings("unchecked")
		final EList<View> children = view.getChildren();
		for(final View child : children) {
			if(UMLVisualIDRegistry.getVisualID(child) == visualId) {
				result.add(child);
			}
			internalFindSubViewsWithId(child, visualId, result);
		}
		return null;
	}

	public static View findSuperViewWithId(final View view, final int visualId) {
		EObject parent = view;
		while(parent != null) {
			if(parent instanceof View) {
				final View parentView = (View)parent;
				if(UMLVisualIDRegistry.getVisualID(parentView) == visualId) {
					return parentView;
				}
			}
			parent = parent.eContainer();
		}
		return null;
	}

	public static String getContainingDiagramType(final View view) {
		if(view instanceof Diagram) {
			final Diagram diagram = (Diagram)view;
			return diagram.getType();
		}
		final EObject eContainer = view.eContainer();
		if(eContainer instanceof View) {
			final View parentView = (View)eContainer;
			return getContainingDiagramType(parentView);
		}
		return null;
	}

	public static ICommand getMoveViewCommand(final View parentView, final View viewToMove, final int targetIndex) {
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(parentView);
		return new AbstractTransactionalCommand(editingDomain, Messages.ViewUtils_MoveView, null, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				int newIndex = targetIndex;
				final EList<?> children = parentView.getChildren();
				final int size = children.size();
				final int index = children.indexOf(viewToMove);
				if(index < targetIndex) {
					// account for the removed child
					newIndex--;
				}
				if(newIndex < 0) {
					newIndex = 0;
				}
				if(newIndex > size - 1) {
					newIndex = size - 1;
				}
				ViewUtil.repositionChildAt(parentView, viewToMove, newIndex);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	public static boolean isContained(final View child, final View parent) {
		View view = child;
		while(view != null) {
			if(view == parent) {
				return true;
			}
			final EObject eContainer = view.eContainer();
			if(eContainer instanceof View) {
				view = (View)eContainer;
			} else {
				break;
			}
		}
		return false;
	}

	public static boolean isViewFor(final View view, final EClass... eClasses) {
		final EObject element = view.getElement();
		for(final EClass eClass : eClasses) {
			if(eClass.isInstance(element)) {
				return true;
			}
		}
		return false;
	}

	/** Returns whether the given View contains a child View for the given {@link EObject} */
	public static boolean containsViewFor(final View parentView, final EObject eObject) {
		if(parentView.getElement() == eObject) {
			return true;
		}
		@SuppressWarnings("unchecked")
		final EList<View> children = parentView.getChildren();
		for(final View child : children) {
			if(containsViewFor(child, eObject)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns whether the diagram that contains the given referenceView contains a {@link Connector} for the given
	 * EObject.
	 */
	public static boolean containsConnectorFor(final View referenceView, final EObject eObject) {
		final View parentDiagramView1 = ViewUtils.findSuperViewWithId(referenceView, TimingDiagramEditPart.VISUAL_ID);
		final Set<View> existingViews = CrossReferencerUtil.getCrossReferencingViews(eObject, TimingDiagramEditPart.MODEL_ID);
		for(final View existingView : existingViews) {
			if(existingView instanceof Connector) {
				final View parentDiagramView2 = ViewUtils.findSuperViewWithId(existingView, TimingDiagramEditPart.VISUAL_ID);
				if(parentDiagramView1 == parentDiagramView2) {
					return true;
				}
			}
		}
		return false;
	}

	public static void selectInViewer(final View view, final EditPartViewer viewer) {
		final EditPart editPart = (EditPart)viewer.getEditPartRegistry().get(view);
		if(editPart != null) {
			viewer.setSelection(new StructuredSelection(editPart));
		}
	}

	public static void performEditRequest(final View view, final EditPartViewer viewer) {
		final EditPart editPart = (EditPart)viewer.getEditPartRegistry().get(view);
		if(editPart != null) {
			// viewer.setSelection(new StructuredSelection(editPart));
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					if(editPart.isActive()) {
						editPart.performRequest(new Request(RequestConstants.REQ_DIRECT_EDIT));
						EditPartUtils.revealEditPart(editPart);
					}
				}
			});
		}
	}
}
