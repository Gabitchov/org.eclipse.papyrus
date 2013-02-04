/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.LifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;

/**
 * This EditPolicy adds a notification listener on the time ruler View that listens for its visibility and updates the
 * {@link LifelineFigure#setDisplayTimeRuler(boolean) LifelineFigure's time ruler visibility}
 */
public class TimeRulerVisibilityRefreshEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static final String ROLE = "TimeRulerVisibilityRefreshRole"; //$NON-NLS-1$

	private View timeRulerCompartmentView;

	public TimeRulerVisibilityRefreshEditPolicy() {
		super();
	}

	@Override
	public void activate() {

		this.timeRulerCompartmentView = getListenedView();
		if(this.timeRulerCompartmentView == null) {
			return;
		}
		// adds a listener on the View
		getDiagramEventBroker().addNotificationListener(this.timeRulerCompartmentView, this);
		// initial refresh (so that the figure has the right visibility when the diagram is first opened)
		refreshFigure();
	}

	@Override
	public void deactivate() {
		if(this.timeRulerCompartmentView == null) {
			return;
		}
		// remove the listener from the View
		getDiagramEventBroker().removeNotificationListener(this.timeRulerCompartmentView, this);
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

	protected View getListenedView() {
		final View view = getView();
		if(view != null) {
			return ViewUtils.findTimeRulerCompartmentView(view);
		}
		return null;
	}

	protected View getView() {
		return (View)getHost().getModel();
	}

	public void notifyChanged(final Notification notification) {
		if(notification.getEventType() == Notification.SET) {
			final Object feature = notification.getFeature();
			if(feature == NotationPackage.eINSTANCE.getView_Visible()) {
				refreshFigure();
			}
		}
	}

	/**
	 * Refreshes the "displayTimeRuler" attribute of the LifelineFigure so that it matches the visibility of the
	 * TimeRulerCompartment View.
	 */
	public void refreshFigure() {
		final boolean visible = getListenedView().isVisible();
		final IFigure figure = ((IGraphicalEditPart)getHost()).getFigure();
		final LifelineFigure lifelineFigure = FigureUtils.findChildFigureInstance(figure, LifelineFigure.class);
		lifelineFigure.setDisplayTimeRuler(visible);
	}
}
