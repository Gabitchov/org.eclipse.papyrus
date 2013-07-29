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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import static org.eclipse.papyrus.uml.diagram.common.Activator.log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;

/**
 * Edit Policy in charge of the removal of views that are not linked to semantic
 * elements, when they should be linked to semantic elements.
 * <P>
 * Sometimes, {@link View}s are not linked to semantic elements, like the comment link. This link represents the annotated element feature for a
 * {@link Comment}, but they are not themselves connected to a semantic element. <BR/>
 * Thus, when this policy is created, it reads a table of integer that corresponds to the set of visual IDs, ids linked to views that are never linked
 * to a semantic element.
 * </P>
 * <P>
 * This view checks that the host edit part, usually a container edit part, has child views that are not orphaned. It listens for model notifications.
 * As soon as it receives a add or remove event, it checks that the child views are still valid, ie they are connected to a semantic element if they
 * should.<BR/>
 * There is then an invariant: The edit part, by the intermediate of his orphan edit policy, must always know the list of semantic parents of the
 * semantic elements displayed by views children of the view associated to this edit part. So it knows when a child element of this parent is deleted,
 * and then can react to this destruction.<BR/>
 * To respect this condition, the policy keeps a list of parent elements, which is updated as soon as the list receives notification about this parent
 * semantic elements.
 * </P>
 */
public class OrphanViewPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener {

	/**
	 * array list of visual id that correspond to views that are not linked to
	 * semantic elements. For example, comment links
	 */
	private ArrayList<Integer> notOrphanList = new ArrayList<Integer>();

	/** the pattern that checks visual ids are valid integers */
	private static Pattern digit = Pattern.compile("\\d+");

	/** list of element to listen */
	protected HashMap<EObject, List<View>> additionalParentToListen = new HashMap<EObject, List<View>>();

	/** stores the host associated semantic element */
	protected EObject hostSemanticElement;

	/**
	 * Adds additional listeners to the diagram event broker.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void activate() {

		// retrieve the view and the element associated to the host edit part
		final View hostView = (View)getHost().getModel();
		hostSemanticElement = hostView.getElement();

		// adds listener to the event broker, listening for the view and the
		// semantic element associated to the host edit part
		getDiagramEventBroker().addNotificationListener(hostView, this);
		getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);

		// retrieve the list of parent semantic element to listen in case of
		// modification
		// for each child views, checks which parent has the semantic element
		// associated to the view
		// if dif
		Iterator<View> it = hostView.getChildren().listIterator();
		while(it.hasNext()) {
			View childView = it.next();
			addListenerForView(childView);
		}

		// debug purpose
		if(log.isDebugEnabled()) {
			log.debug("Activate: " + prettyPrint(additionalParentToListen));
		}

		super.activate();
	}

	/**
	 * Adds this edit policy as listener for changes to the specified
	 * semanticParent
	 * 
	 * @param semanticParent
	 *        the semantic parent to listen
	 * @param childView
	 *        the view that requires this additional listener
	 */
	protected void addAdditionalParentToListen(EObject semanticParent, View childView) {
		// check if the list already contains the semantic Parent
		// if it already contains the parent, adds the view to the list of views
		// responsible of this parent
		// if not, it creates a new entry in the map
		if(additionalParentToListen.containsKey(semanticParent)) {
			List<View> views = additionalParentToListen.get(semanticParent);
			assert (views != null) : "list should not be null";
			views.add(childView);
			// no need to add listener, it should already be done
		} else {
			// creates the list of views associated to this parent and adds it
			// to the additional parent to listen, with the key
			// "semantic parent"
			ArrayList<View> views = new ArrayList<View>();
			views.add(childView);
			additionalParentToListen.put(semanticParent, views);
			getDiagramEventBroker().addNotificationListener(semanticParent, this);
		}
	}

	/**
	 * Removes this edit policy as listener for changes to the specified
	 * semanticParent
	 * 
	 * @param semanticParent
	 *        the semantic parent to stop listen
	 * @param childView
	 *        the view that does not requires this additional listener
	 */
	protected void removeAdditionalParentToListen(EObject semanticParent, View childView) {
		// removes the view from the list of views that requires a listener for
		// the semantic parent
		if(additionalParentToListen.containsKey(semanticParent)) {
			List<View> views = additionalParentToListen.get(semanticParent);
			assert (views != null) : "list should not be null";
			views.remove(childView);
			if(views.isEmpty()) {
				additionalParentToListen.remove(semanticParent);
				// check this is not the parent semantic element of the host's
				// semantic element
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

		// removes all notification listeners for the additional parent to
		// listen
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
	 * Deletes a list of views. The views will be deleted <tt>iff</tt> their
	 * semantic element has also been deleted.
	 * 
	 * @param views
	 *        an iterator on a list of views.
	 * @return <tt>true</tt> if the host editpart should be refreshed; either
	 *         one one of the supplied views was deleted or has been reparented.
	 */
	protected final boolean deleteViews(Iterator<View> views) {

		final CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
		while(views.hasNext()) {
			View view = (View)views.next();
			cc.add(getDeleteViewCommand(view));
		}

		boolean doDelete = !cc.isEmpty() && cc.canExecute();
		if(doDelete) {
			executeCommand(cc);
		}
		return doDelete;
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
		// do not use the DiagramEditPart.isActivating since
		// ConnectionEditPart's
		// parent will not be a diagram edit part
		EditPartViewer viewer = ep.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}

		if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)getHost(), false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);

		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)getHost()).getEditingDomain(), StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

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
	 * Retrieve the list of orphaned views among the specified list view
	 * 
	 * @param viewChildrenIterator
	 *        the iterator on the list of views to check
	 * @return the list of views that are orphaned
	 */
	protected List<View> findOrphanView(Iterator<? extends EObject> viewChildrenIterator) {
		ArrayList<View> orphanView = new ArrayList<View>();
		while(viewChildrenIterator.hasNext()) {
			EObject view = viewChildrenIterator.next();
			if(view instanceof View) {
				if(isOrphaned((View)view)) {
					orphanView.add((View)view);
				}
			}
		}
		return orphanView;
	}

	/**
	 * Returns a {@link Command} to delete the supplied {@link View}.
	 * 
	 * @param view
	 *        view to delete
	 * @return the command that destroys the specified view
	 */
	protected Command getDeleteViewCommand(View view) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		return new ICommandProxy(new DeleteCommand(editingDomain, view));
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
	 * Inits the list of children that should never be attached to a semantic
	 * element, for example comment links.
	 * 
	 * @param notOrphanVisualID
	 *        the list of visual id of views that should never be attached
	 *        to a semantic element
	 */
	public void init(int[] notOrphanVisualID) {
		for(int i = 0; i < notOrphanVisualID.length; i++) {
			notOrphanList.add(new Integer(notOrphanVisualID[i]));
		}
	}

	/**
	 * Tests if the view is orphaned, i.e. it is still attached to a semantic
	 * element.
	 * <P>
	 * It checks also that it is not a view that is never attached to a semantic element (For example, comment links do not have semantic elements
	 * attached...)
	 * <P/>
	 * 
	 * @param view
	 *        the view to check
	 * @return <code>true</code> if the view is not attached to a semantic
	 *         element. <code>false</code> if it is still attached to a semantic
	 *         element or if it should never be attached to a semantic element
	 */
	protected boolean isOrphaned(View view) {
		String semanticHint = view.getType();
		if(isInteger(semanticHint) && notOrphanList.contains(new Integer(semanticHint))) {
			return false;
		}
		return !view.isSetElement();
	}

	/**
	 * Checks if the string is an integer.
	 * 
	 * @param s
	 *        the specified string
	 * 
	 * @return true, if is integer
	 */
	public static boolean isInteger(String s) {
		boolean result = false;
		Matcher matcher = digit.matcher(s);
		if(matcher != null) {
			result = matcher.matches();
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		// something has change. What ? :)
		// check who is responsible of notification. If this is host edit part
		// related semantic element, act as standard
		Object notifier = notification.getNotifier();
		// View hostView = (View)getHost().getModel();
		if(notifier.equals(hostSemanticElement)) {
			if(Notification.REMOVE == notification.getEventType() || Notification.SET == notification.getEventType()) {
				refreshViews();
			}
		} else {
			// this is perhaps one of the scoped semantic parent
			if(notifier instanceof EObject) {
				if(!(notifier instanceof View)) {
					if(Notification.REMOVE == notification.getEventType()) {

						// 2 cases... remove or simple move ?
						// this can be checked with the view, if it is now
						// orphaned or not
						// if it is orphaned, element has to be destroyed,
						// remove from parent listener, etc.
						// if not, this was just a move => change listener using
						// new parent
						// checks also for whole hierarchy...
						EObject parentNotifier = (EObject)notifier;

						if(additionalParentToListen.containsKey(parentNotifier)) {
							// this should be one of the elements that are
							// inside the
							List<View> views = additionalParentToListen.get(parentNotifier);

							List<View> orphaned = findOrphanView(views.iterator());
							//
							// delete all the remaining views
							deleteViews(orphaned.iterator());

							removeListeners(orphaned);
						}
					}
				} else { // Notifier is a View
					// REMOVE or ADD are interesting events:
					// if remove, remove the list (perhaps) from the views
					// contributing to the delete action
					// if add, checks it does not need to be watched
					if(Notification.REMOVE == notification.getEventType()) {
						if(notification.getNewValue() instanceof View) {
							View oldView = (View)notification.getOldValue();
							removeListenerForView(oldView);
						}

					} else if(Notification.ADD == notification.getEventType()) {
						// check the parent of the associated semantic element
						if(notification.getNewValue() instanceof View) {
							View newView = (View)notification.getNewValue();
							addListenerForView(newView);
						}
					}

				}
			}
		}
	}

	/**
	 * Adds a listener for the specified view, if necessary.
	 * <P>
	 * It has to be added if the parent of the semantic element attached to the view is not the host semantic element.
	 * </P>
	 * 
	 * @param newView
	 *        the new view to check
	 */
	protected void addListenerForView(View newView) {
		// get semantic element attached to the host edit part
		View hostView = (View)getHost().getModel();

		// get the parent of the new view. if it is the same as current parent,
		// does not add additional listeners
		if(newView.getElement() != null) {
			EObject semanticParent = newView.getElement().eContainer();
			if(semanticParent != null) {
				if(!semanticParent.equals(hostSemanticElement)) {
					// add each parent of the semantic parent to the list of
					// additional listeners
					for(EObject parent : getElementHierarchy(semanticParent)) {
						addAdditionalParentToListen(parent, newView);
					}
				}
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
		// create a temp list of elements to delete (iterator concurrent
		// modification..)
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
		// create a temp list of elements to delete (iterator concurrent
		// modification..)
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
	 * Returns the list of parent for the specified element
	 * 
	 * @return the list of parent for the specified element, with the element
	 *         itself
	 */
	public List<EObject> getElementHierarchy(EObject eObject) {
		List<EObject> list = new ArrayList<EObject>();
		EObject currentObject = eObject;
		while(currentObject != null) {
			list.add(currentObject);
			currentObject = currentObject.eContainer();
		}
		return list;
	}

	/**
	 * Refresh the child views of the host edit part
	 * 
	 * @return an empty list?
	 */
	protected List refreshViews() {
		// current connection views
		Iterator<EObject> viewChildrenIterator = ((EObject)getHost().getModel()).eContents().iterator();

		List<View> orphaned = findOrphanView(viewChildrenIterator);
		//
		// delete all the remaining views
		deleteViews(orphaned.iterator());

		// update listeners
		removeListeners(orphaned);

		// create a view for each remaining semantic element.
		// FIXME why returning an empty list ?
		List viewDescriptors = new ArrayList();

		return viewDescriptors;
	}

	/**
	 * launch a weak synchronization. It could be useful in order to clean a
	 * diagram by an external tool.
	 */
	public void forceRefresh() {
		refreshViews();
	}

	/**
	 * Debug method. Displays the additionalParentToListen map correclty
	 * 
	 * @param additionalParentToListen
	 *        the map to display
	 * @return the pretty - print string
	 */
	private String prettyPrint(Map<EObject, List<View>> additionalParentToListen) {
		StringBuffer buffer = new StringBuffer();
		if(additionalParentToListen == null) {
			return "Empty listener for " + getHost();
		}
		buffer.append("addtionnal listeners for ");
		buffer.append(getHost());
		buffer.append("\n");
		for(EObject object : additionalParentToListen.keySet()) {
			buffer.append("\n");
			buffer.append(object);
			buffer.append("(");
			buffer.append(additionalParentToListen.get(object).size());
			buffer.append("):\n");
			for(View view : additionalParentToListen.get(object)) {
				buffer.append("- ");
				buffer.append(view);
				buffer.append("\n");
			}
			buffer.append("\n");
		}

		return buffer.toString();
	}

}
