/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.uml2.uml.Element;

/**
 * Edit policy for specific Label
 */
public abstract class AbstractCustomLabelEditPolicy extends GraphicalEditPolicy implements IPapyrusListener, NotificationListener {

	/** constant for this edit policy role */
	public final static String SPECIFIC_NAME_LABEL_POLICY = "SpecificNameLabelEditPolicy"; //$NON-NLS-1$

	/**
	 * Creates a new Specific Name display edit policy
	 */
	public AbstractCustomLabelEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		Element element = getUMLElement();
		if(getUMLElement() != null) {
			// adds a listener on the view and the element controlled by the editpart
			getDiagramEventBroker().addNotificationListener(view, this);
			getDiagramEventBroker().addNotificationListener(element, this);

			addAdditionalListeners();

			refreshDisplay();
		}
	}

	/**
	 * Adds more listeners upon activation
	 */
	protected void addAdditionalListeners() {
		// default implementation does nothing
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		Element element = (Element)getUMLElement();

		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);

		if(element == null) {
			return;
		}
		getDiagramEventBroker().removeNotificationListener(element, this);

		removeAdditionalListeners();

	}

	/**
	 * Remove the others listeners
	 * 
	 */
	protected void removeAdditionalListeners() {
		// default implementation does nothing
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
	 * Returns the uml element controlled by the host edit part
	 * 
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		return (Element)getView().getElement();
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	/**
	 * Refreshes the display for the element controlled by the edit part with this edit policies
	 */
	public abstract void refreshDisplay();

}
