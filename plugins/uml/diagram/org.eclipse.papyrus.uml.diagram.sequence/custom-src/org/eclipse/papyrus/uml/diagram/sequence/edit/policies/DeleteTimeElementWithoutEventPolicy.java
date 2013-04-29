/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - additional features
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import static org.eclipse.papyrus.uml.diagram.common.Activator.log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * Edit Policy in charge of the removal of time/duration constraint/observation which no longer have associated events.
 * <P>
 * This view checks that the host edit part, a time/duration constraint/observation edit part, has necessary associated events. It listens for model
 * notifications. As soon as it receives a remove event, it checks whether the time element should be also deleted.<BR/>
 * </P>
 */
public class DeleteTimeElementWithoutEventPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener {

	/** The key to install this edit policy */
	public static final String KEY = "DeleteTimeElementWithoutEvent";

	/** list of element to listen */
	protected HashMap<EObject, List<View>> additionalParentToListen = new HashMap<EObject, List<View>>();

	/** stores the host associated semantic element */
	protected EObject hostSemanticElement;

	/**
	 * Adds additional listeners to the diagram event broker.
	 */
	@Override
	public void activate() {
		// retrieve the view and the element associated to the host edit part
		final View hostView = (View)getHost().getModel();
		hostSemanticElement = hostView.getElement();
		// adds listener to the event broker, listening for the view and the semantic element associated to the host edit part
		getDiagramEventBroker().addNotificationListener(hostView, this);
		getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);
		// retrieve the list of linked view to listen parents
		for(View linkedView : getLinkedViews()) {
			getDiagramEventBroker().addNotificationListener(linkedView.eContainer(), this);
		}
		super.activate();
	}

	/**
	 * Removes this edit policy as listener for changes to the specified semanticParent
	 * 
	 * @param semanticParent
	 *        the semantic parent to stop listen
	 * @param childView
	 *        the view that does not requires this additional listener
	 */
	protected void removeAdditionalParentToListen(EObject semanticParent, View childView) {
		// removes the view from the list of views that requires a listener for the semantic parent
		if(additionalParentToListen.containsKey(semanticParent)) {
			List<View> views = additionalParentToListen.get(semanticParent);
			assert (views != null) : "list should not be null";
			views.remove(childView);
			if(views.isEmpty()) {
				additionalParentToListen.remove(semanticParent);
				// check this is not the parent semantic element of the host's semantic element
				if(!semanticParent.equals(((View)getHost().getModel()).getElement())) {
					getDiagramEventBroker().removeNotificationListener(semanticParent, this);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		// retrieve the view and the element associated to the host edit part
		final View hostView = (View)getHost().getModel();
		// removes all notification listeners for the additional parent to listen
		for(EObject parent : additionalParentToListen.keySet()) {
			getDiagramEventBroker().removeNotificationListener(parent, this);
		}
		additionalParentToListen.clear();
		additionalParentToListen = null;
		getDiagramEventBroker().removeNotificationListener(hostView, this);
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
		// removes the reference to the semantic element
		hostSemanticElement = null;
		super.deactivate();
	}

	/**
	 * Deletes the time element.
	 */
	protected final void deleteTimeElement() {
		Command cmd = getDeleteElementCommand(false);
		if(cmd.canExecute()) {
			executeCommand(cmd);
		}
	}

	/**
	 * Deletes a time element view.
	 */
	protected final void deleteTimeView() {
		Command cmd = getDeleteElementCommand(true);
		if(cmd.canExecute()) {
			executeCommand(cmd);
		}
	}

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected void executeCommand(final Command cmd) {
		Map<String, Boolean> options = null;
		EditPart ep = getHost();
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since ConnectionEditPart's
		// parent will not be a diagram edit part
		EditPartViewer viewer = ep.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}
		if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)getHost(), false, false)) {
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
		}
		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)getHost()).getEditingDomain(), StringStatics.BLANK, options) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				((IGraphicalEditPart)getHost()).getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
				return Status.OK_STATUS;
			}

			@Override
			protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				cmd.undo();
				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			log.error(e);
		}
	}

	/**
	 * Check if time element is correctly defined
	 * 
	 * @return true if it has necessary information, false if it is to be deleted
	 */
	protected boolean isTimeElementDefined() {
		if(hostSemanticElement instanceof TimeObservation) {
			return ((TimeObservation)hostSemanticElement).getEvent() != null;
		} else if(hostSemanticElement instanceof DurationObservation) {
			return ((DurationObservation)hostSemanticElement).getEvents().size() >= 2;
		} else if(hostSemanticElement instanceof TimeConstraint) {
			return ((TimeConstraint)hostSemanticElement).getConstrainedElements().size() > 0;
		} 
//		else if(hostSemanticElement instanceof DurationConstraint) {
//			/*
//			 * Note that DurationConstraint may have only one ConstrainedElement.
//			 * But in such a case, we suppose it has not been created as one of the concerned edit parts.
//			 */
//			return ((DurationConstraint)hostSemanticElement).getConstrainedElements().size() >= 2;
//		}
		return true;
	}

	/**
	 * Get the list of other required figures
	 * 
	 * @return list of views
	 */
	protected List<View> getLinkedViews() {
		if(getHost() instanceof TimeObservationEditPart && hostSemanticElement instanceof TimeObservation) {
			LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(getHost());
			NamedElement occ = ((TimeObservation)hostSemanticElement).getEvent();
			if(occ instanceof OccurrenceSpecification) {
				EditPart part = SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occ);
				if(part != null) {
					return Collections.singletonList((View)part.getModel());
				}
			}
			return Collections.emptyList();
		} else if(getHost() instanceof TimeConstraintEditPart && hostSemanticElement instanceof TimeConstraint) {
			LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(getHost());
			List<Element> occs = ((TimeConstraint)hostSemanticElement).getConstrainedElements();
			if(occs.size() > 0 & occs.get(0) instanceof OccurrenceSpecification) {
				EditPart part = SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occs.get(0));
				if(part != null) {
					return Collections.singletonList((View)part.getModel());
				}
			}
			return Collections.emptyList();
		} else if(getHost() instanceof DurationConstraintEditPart && hostSemanticElement instanceof TimeConstraint) {
			LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(getHost());
			List<Element> occs = ((TimeConstraint)hostSemanticElement).getConstrainedElements();
			if(occs.size() >= 2 && occs.get(0) instanceof OccurrenceSpecification && occs.get(1) instanceof OccurrenceSpecification) {
				EditPart part1 = SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occs.get(0));
				EditPart part2 = SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occs.get(1));
				List<View> list = new ArrayList<View>(2);
				if(part1 != null) {
					list.add((View)part1.getModel());
				}
				if(part2 != null) {
					list.add((View)part2.getModel());
				}
				return list;
			}
			return Collections.emptyList();
		}
		// a label on a message always has its parent message
		return Collections.emptyList();
	}

	/**
	 * Check if time element has required other figures
	 * 
	 * @return true if the time element figure miss one of the figure representing its ends.
	 */
	protected boolean timeElementMissAnEventFigure() {
		if(getHost() instanceof TimeObservationEditPart && hostSemanticElement instanceof TimeObservation) {
			LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(getHost());
			NamedElement occ = ((TimeObservation)hostSemanticElement).getEvent();
			if(occ instanceof OccurrenceSpecification) {
				return SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occ) == null;
			}
			return true;
		} else if(getHost() instanceof TimeConstraintEditPart && hostSemanticElement instanceof TimeConstraint) {
			LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(getHost());
			List<Element> occs = ((TimeConstraint)hostSemanticElement).getConstrainedElements();
			if(occs.size() > 0 && occs.get(0) instanceof OccurrenceSpecification) {
				return SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occs.get(0)) == null;
			}
			return true;
		} 
//		else if(getHost() instanceof DurationConstraintEditPart && hostSemanticElement instanceof DurationConstraint) {
//			LifelineEditPart lifeline = SequenceUtil.getParentLifelinePart(getHost());
//			List<Element> occs = ((DurationConstraint)hostSemanticElement).getConstrainedElements();
//			if(occs.size() >= 2 && occs.get(0) instanceof OccurrenceSpecification && occs.get(1) instanceof OccurrenceSpecification) {
//				return SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occs.get(0)) == null || SequenceUtil.getLinkedEditPart(lifeline, (OccurrenceSpecification)occs.get(1)) == null;
//			}
//			return true;
//		}
		// a label on a message always has its parent message
		return false;
	}

	/**
	 * Returns a {@link Command} to delete the host element
	 * 
	 * @param graphOnly
	 *        true if the view only must be removed
	 * @return the command that destroys the host element
	 */
	protected Command getDeleteElementCommand(boolean graphOnly) {
		if(graphOnly) {
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
			return new ICommandProxy(new DeleteCommand(editingDomain, (View)getHost().getModel()));
		} else {
			DestroyElementRequest req = new DestroyElementRequest(hostSemanticElement, false);
			return getDestroyElementCommand(req);
		}
	}

	/**
	 * Copied from a generated method from a semantic edit policy which supports the edit element service
	 * 
	 * @param req
	 *        the DestroyElementRequest
	 * @return the destroy command
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		EObject selectedEObject = req.getElementToDestroy();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(selectedEObject);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand deleteCommand = provider.getEditCommand(req);
			if(deleteCommand != null) {
				return new ICommandProxy(deleteCommand);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		Object notifier = notification.getNotifier();
		if(notifier.equals(hostSemanticElement)) {
			if(Notification.REMOVE == notification.getEventType() || Notification.SET == notification.getEventType()) {
				deleteTimeElementIfNeeded();
			}
		} else if(notifier instanceof View) {
			// a view has been modified
			if(Notification.REMOVE == notification.getEventType()) {
				deleteTimeElementIfNeeded();
			}
		}
	}

	/**
	 * Removes a listener for the specified view, if it exists.
	 * 
	 * @param oldView
	 *        the old view to check
	 */
	protected void removeListenerForView(View oldView) {
		// create a temp list of elements to delete (iterator concurrent modification..)
		Map<EObject, List<View>> parentsToDelete = new HashMap<EObject, List<View>>();
		for(EObject parent : additionalParentToListen.keySet()) {
			List<View> parentViews = additionalParentToListen.get(parent);
			if(parentViews.contains(oldView)) {
				List<View> views = parentsToDelete.get(parent);
				if(views == null) {
					views = new ArrayList<View>();
				}
				views.add(oldView);
				parentsToDelete.put(parent, views);
			}
		}
	}

	/**
	 * Updates the listeners for the specified semantic parent
	 */
	protected void removeListeners(List<View> impactedViews) {
		// create a temp list of elements to delete (iterator concurrent modification..)
		Map<EObject, List<View>> parentsToDelete = new HashMap<EObject, List<View>>();
		// collect the elements to delete
		for(View view : impactedViews) {
			for(EObject parent : additionalParentToListen.keySet()) {
				List<View> parentViews = additionalParentToListen.get(parent);
				if(parentViews.contains(view)) {
					List<View> views = parentsToDelete.get(parent);
					if(views == null) {
						views = new ArrayList<View>();
					}
					views.add(view);
					parentsToDelete.put(parent, views);
				}
			}
		}
		// do the job
		for(EObject object : parentsToDelete.keySet()) {
			List<View> views = parentsToDelete.get(object);
			for(View view : views) {
				removeAdditionalParentToListen(object, view);
			}
		}
	}

	/**
	 * Check if the time element should be deleted and delete it if necessary.
	 */
	protected void deleteTimeElementIfNeeded() {
		if(!isTimeElementDefined()) {
			// delete the time element
			deleteTimeElement();
		}
		if(timeElementMissAnEventFigure()) {
			// delete the view
			deleteTimeView();
		}
	}

	/**
	 * launch a weak synchronization. It could be useful in order to clean a diagram by an external tool.
	 */
	public void forceRefresh() {
		deleteTimeElementIfNeeded();
	}
}
