/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Yury Chernikov (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.editpolicies;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.notation.NotationPackage;

// @unused
public class DynamicResizeDirectionsEditPolicy extends ResizableShapeEditPolicy implements NotificationListener {

	private static final int VERTICAL = -1;

	private static final int SQUARE = 0;

	private static final int HORIZONTAL = 1;

	private int myCurrentState;

	public DynamicResizeDirectionsEditPolicy() {
		myCurrentState = VERTICAL;
		setResizeDirections(PositionConstants.NORTH | PositionConstants.SOUTH);
	}

	@Override
	public void activate() {
		super.activate();
		getDiagramEventBroker().addNotificationListener(getHostImpl().getNotationView(), this);
	}

	@Override
	public void deactivate() {
		getDiagramEventBroker().removeNotificationListener(getHostImpl().getNotationView(), this);
		super.deactivate();
	}

	public void hostSizeChanged() {
		IGraphicalEditPart host = getHostImpl();
		Integer width = (Integer) host.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width());
		Integer height = (Integer) host.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height());
		if (width == null) {
			width = Integer.valueOf(0);
		}
		if (height == null) {
			height = Integer.valueOf(0);
		}
		Dimension size = new Dimension(width, height);
		correctEditPolicy(size);
	}

	public void notifyChanged(Notification notification) {
		Object feature = notification.getFeature();
		if (NotationPackage.eINSTANCE.getSize_Width().equals(feature)
				|| NotationPackage.eINSTANCE.getSize_Height().equals(feature)) {
			hostSizeChanged();
		}
	}

	private void correctEditPolicy(Dimension size) {
		if (isChanged(size)) {
			hideSelection();
			setState(size);
			showSelection();
		}
	}

	private IGraphicalEditPart getHostImpl() {
		return (IGraphicalEditPart) getHost();
	}

	private boolean isChanged(Dimension size) {
		return (size.height - size.width) * myCurrentState > 0;
	}

	private void setState(Dimension size) {
		int delta = size.height - size.width;
		if (delta > 0) {
			myCurrentState = VERTICAL;
			setResizeDirections(PositionConstants.NORTH | PositionConstants.SOUTH);
		} else if (delta < 0) {
			myCurrentState = HORIZONTAL;
			setResizeDirections(PositionConstants.WEST | PositionConstants.EAST);
		} else {
			myCurrentState = SQUARE;
		}
	}

	private DiagramEventBroker getDiagramEventBroker() {
		return DiagramEventBroker.getInstance(getHostImpl().getEditingDomain());
	}

}
