/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;

/**
 * this edit policy has in charge to display the name of node NodeNamedElement
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class NameDisplayEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static final String DISPLAY_NAME = "displayName";

	/** key for this edit policy */
	public final static String NAME_DISPLAY_EDITPOLICY = "NAME_DISPLAY_EDITPOLICY";

	/**
	 * Creates a new QualifiedNameDisplayEditPolicy
	 */
	public NameDisplayEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}

		// adds a listener on the view and the element controlled by the
		// editpart
		getDiagramEventBroker().addNotificationListener(view, this);

		refreshNameDisplay();
	}

	/**
	 * refresh the qualified name
	 */
	protected void refreshNameDisplay() {
		if(getHost() instanceof NamedElementEditPart) {
			NamedElementEditPart namedElementEditPart = (NamedElementEditPart)getHost();

			IFigure primaryShape = namedElementEditPart.getPrimaryShape();
			if(primaryShape instanceof NodeNamedElementFigure) {

				BooleanValueStyle nameStyle = getDisplayNameStyle(namedElementEditPart.getNotationView());
				if(nameStyle != null && nameStyle.isBooleanValue() == false) {

					((NodeNamedElementFigure)primaryShape).removeNameLabel();
				} else {
					((NodeNamedElementFigure)primaryShape).restoreNameLabel();
				}
			}
		}
	}

	/**
	 * 
	 * @param currentView
	 * @return the current Style that repersent the boder
	 */
	protected BooleanValueStyle getDisplayNameStyle(View currentView) {
		return (BooleanValueStyle)currentView.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), DISPLAY_NAME);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}
		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);

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
	 * 
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		refreshNameDisplay();
	}


}
