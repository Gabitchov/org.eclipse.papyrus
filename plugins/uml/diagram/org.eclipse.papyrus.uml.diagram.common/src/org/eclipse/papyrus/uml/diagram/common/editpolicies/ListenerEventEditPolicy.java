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
 *   Arthur Daussy (Atos) arthur.daussy@atos.net - Bug 249786: [General] drag'n'drop does not work for elements stored in nested classifier compartment
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;

import com.google.common.collect.ImmutableSet;

public abstract class ListenerEventEditPolicy extends AbstractEditPolicy implements IStructuralFeatureListener {

	/** Adds <code>String.class</tt> adaptablity to return a factory hint. Copied from {@link CanonicalEditPolicy} */
	protected static final class ElementListenerAdapter extends EObjectAdapter {

		private String _hint;

		/**
		 * constructor
		 * 
		 * @param element
		 * @param hint
		 */
		public ElementListenerAdapter(EObject element, String hint) {
			super(element);
			_hint = hint;
		}

		/** Adds <code>String.class</tt> adaptablity. */
		public Object getAdapter(Class adapter) {
			if(adapter.equals(String.class)) {
				return _hint;
			}
			return super.getAdapter(adapter);
		}
	}

	public ListenerEventEditPolicy() {
		super();
	}

	/**
	 * This method tries to locate the position that the view will be
	 * inserted into it's parent. The position is determined by the position
	 * of the semantic element. If the semantic element is not found the view
	 * will be appended to it's parent.
	 * 
	 * @param semanticChild
	 * @return position where the view should be inserted
	 */
	protected int getViewIndexFor(EObject semanticChild) {
		// The default implementation returns APPEND
		return ViewUtil.APPEND;
	}

	/**
	 * Returns the default factory hint.
	 * 
	 * @return <code>host().getView().getSemanticType()</code>
	 */
	protected String getDefaultFactoryHint() {
		return ((View)host().getModel()).getType();
	}


	/**
	 * Return a view descriptor.
	 * 
	 * @param elementAdapter
	 *        semantic element
	 * @param viewKind
	 *        type of view to create
	 * @param hint
	 *        factory hint
	 * @param index
	 *        index
	 * @return a create <i>non-persisted</i> view descriptor
	 */
	protected CreateViewRequest.ViewDescriptor getViewDescriptor(IAdaptable elementAdapter, Class viewKind, String hint, int index) {
		return new CreateViewRequest.ViewDescriptor(elementAdapter, viewKind, hint, index, false, host().getDiagramPreferencesHint());
	}



	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		throw new IllegalStateException("EditPolicy unable to retrive the DiagramEventBroker");////$NON-NLS-0$
	}

	/**
	 * Return the {@link IGraphicalEditPart} host (never null)
	 * 
	 * @return
	 */
	protected IGraphicalEditPart host() {
		EditPart host = getHost();
		if(host instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)host);
		}
		throw new IllegalStateException("The host of this EditPolicy is not an instance of IGraphicalEditPart");////$NON-NLS-0$
	}

	/**
	 * 
	 * @return {@link EObject} of the host of this edit Policy or null if error
	 */
	protected EObject getSemanticHost() {
		IGraphicalEditPart host = host();
		if(host != null) {
			return host.resolveSemanticElement();
		}
		return null;
	}

	/**
	 * Add the listeners corresponding to to the structural feature
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	@Override
	public void activate() {
		for(EStructuralFeature feature : getEStructuralFeaturesToListen()) {
			getDiagramEventBroker().addNotificationListener(getSemanticHost(), feature, this);
		}
		super.activate();
	}

	/**
	 * Add the listeners corresponding to to the structural feature
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	@Override
	public void deactivate() {
		for(EStructuralFeature feature : getEStructuralFeaturesToListen()) {
			getDiagramEventBroker().removeNotificationListener(getSemanticHost(), feature, this);
		}
		super.deactivate();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationPreCommitListener#transactionAboutToCommit(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 * @return
	 */
	public org.eclipse.emf.common.command.Command transactionAboutToCommit(Notification notification) {
		ICommand result = null;
		if(getEStructuralFeaturesToListen().contains(notification.getFeature()) && handleNotificationType(notification.getEventType())) {
			Object newObject = notification.getNewValue();
			Object oldObject = notification.getOldValue();
			Object feature = notification.getFeature();
			int eventType = notification.getEventType();
			Object notifier = notification.getNotifier();
			if(isInstaceofOrNull(newObject,EObject.class) && isInstaceofOrNull(oldObject,EObject.class)&& feature instanceof EStructuralFeature && isInstaceofOrNull(notifier,EObject.class)) {
				result = getCommand((EObject)newObject, (EObject)oldObject, (EStructuralFeature)feature, eventType, (EObject)notifier);
			} else {
				result = getSpecialCommandCommand(notification);
			}
		}
		return (result != null) ? new GMFtoEMFCommandWrapper(result) : null;
	}
	/**
	 * Similar to instance but return true if the objet is null
	 * @param o
	 * @param clazz
	 * @return
	 */
	private boolean isInstaceofOrNull(Object o, Class clazz){
		return o == null || clazz.isInstance(o);
	}

	/**
	 * This method could be override by extended class to handle specific notification
	 * 
	 * @param notification
	 * @return
	 */
	protected ICommand getSpecialCommandCommand(Notification notification) {
		return null;
	}

	protected abstract ICommand getCommand(EObject newObject, EObject oldObject, EStructuralFeature feature, int eventType, EObject notifier);

	/**
	 * {@inheritDoc IStructuralFeatureListener}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.IStructuralFeatureListener#handleNotificationType(int)
	 * 
	 * @param type
	 * @return
	 */
	public abstract boolean handleNotificationType(int type);

	/**
	 * {@inheritDoc IStructuralFeatureListener}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.IStructuralFeatureListener#getEStructuralFeaturesToListen()
	 * 
	 * @param type
	 * @return
	 */
	public abstract ImmutableSet<EStructuralFeature> getEStructuralFeaturesToListen();
}
