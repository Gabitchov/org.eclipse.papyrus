/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Utils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This EditPolicy adds a notification listener on the UML element of its EditPart in order to refresh the notation
 * model in response to changes in the semantic model.
 */
public class FirstEventRefreshEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static final String VIEW_REFRESH_ROLE = "ViewRefreshRole"; //$NON-NLS-1$

	private Element umlElement;

	public FirstEventRefreshEditPolicy() {
		super();
	}

	@Override
	public void activate() {
		this.umlElement = getUMLElement();
		if(this.umlElement == null) {
			return;
		}
		// adds a listener on the UML element
		getDiagramEventBroker().addNotificationListener(this.umlElement, this);
		// initial refresh
		refreshView();
	}

	@Override
	public void deactivate() {
		// retrieve the UML element managed by the edit part
		if(this.umlElement == null) {
			return;
		}
		// remove the listener from the UML element
		getDiagramEventBroker().removeNotificationListener(this.umlElement, this);
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		final TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(editingDomain != null) {
			return DiagramEventBroker.getInstance(editingDomain);
		}
		return null;
	}

	/**
	 * Returns the uml element controlled by the host edit part
	 * 
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		final View view = getView();
		if(view != null) {
			return (Element)view.getElement();
		}
		return null;
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	public void notifyChanged(final Notification notification) {
		if(notification.getEventType() == Notification.SET) {
			final Object feature = notification.getFeature();
			if(feature == UMLPackage.eINSTANCE.getTimeObservation_FirstEvent() || feature == UMLPackage.eINSTANCE.getTimeObservation_Event() || feature == UMLPackage.eINSTANCE.getTimeConstraint_FirstEvent() || feature == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				refreshView();
			}
		}
	}

	/** Refreshes the View for the element controlled by the edit part with this edit policy */
	public void refreshView() {
		final EditPart compartmentEditPart = EditPartUtils.findParentTimelineCompartment(getHost());
		final Command command = compartmentEditPart.getCommand(AbstractTimelineLayoutPolicy.UPDATE_LAYOUT_REQUEST);
		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getView());
		Utils.executeLaterUnprotected(command, domain);
	}
}
