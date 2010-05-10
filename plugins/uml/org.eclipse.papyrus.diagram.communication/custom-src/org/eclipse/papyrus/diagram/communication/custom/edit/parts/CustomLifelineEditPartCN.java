/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Atos Origin - Initial API and implementation
 * Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.communication.custom.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.diagram.communication.custom.figures.LifelineAnchor;
import org.eclipse.papyrus.diagram.communication.custom.util.NotificationHelper;
import org.eclipse.papyrus.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageEditPart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;

/**
 * 
 * CustomLifelineEditPartCN
 * 
 */
public class CustomLifelineEditPartCN extends LifelineEditPartCN {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomLifelineEditPartCN(View view) {
		super(view);
	}

	/**
	 * Return the inner ConnectableElements of the Lifeline
	 * 
	 * @param lifeline
	 *        The lifeline
	 * @return inner ConnectableElements
	 */
	// TODO Extract in a helper
	public static List<Property> getProperties(Lifeline lifeline) {
		if(lifeline != null) {
			ConnectableElement represents = lifeline.getRepresents();
			if(represents != null) {
				Type type = represents.getType();
				if(type instanceof StructuredClassifier) {
					StructuredClassifier structuredClassifier = (StructuredClassifier)type;

					if(!structuredClassifier.getAllAttributes().isEmpty()) {
						return new ArrayList<Property>(((StructuredClassifier)type).getAllAttributes());
					}
				}
			}
		}

		return null;
	}



	/**
	 * True if the lifeline is in inline mode
	 */
	private boolean inlineMode;



	/**
	 * Notfier for listen and unlistend model element.
	 */
	private final NotificationHelper notifier = new NotificationHelper(new UIAdapterImpl() {

		@Override
		protected void safeNotifyChanged(Notification msg) {
			handleNotificationEvent(msg);
		}
	});

	/**
	 * Desactivate listeners for Lifeline to handle notification in the message
	 * occurence specification
	 */
	@Override
	public void deactivate() {
		notifier.unlistenAll();
		super.deactivate();
	}

	/**
	 * Get available properties
	 * 
	 * @return Only not already used properties
	 */
	@SuppressWarnings("unchecked")
	public List<Property> getAvailableProperties() {
		List<Property> properties = getProperties();
		if(properties != null) {
			for(EditPart editPart : (List<EditPart>)getChildren()) {
				if(editPart instanceof LifelineEditPartCN) {
					Lifeline lifeline = (Lifeline)((LifelineEditPartCN)editPart).resolveSemanticElement();
					ConnectableElement represents = lifeline.getRepresents();
					if(properties.contains(represents)) {
						properties.remove(represents);
					}
				}
			}
		}
		return properties;
	}

	/**
	 * Determine inline capability
	 * 
	 * @return True if inline mode is possible
	 */
	public boolean isInlineCapability() {
		List<Property> properties = getAvailableProperties();
		if(properties != null && !properties.isEmpty()) {
			return inlineMode || getChildren().size() < 2;
		}

		return false;
	}



	/**
	 * This operation returns the InnerConnectableElement EditParts contained in
	 * the Lifeline EditPart
	 * 
	 * @return the list of InnerConnectableElement EditParts
	 */
	public List<LifelineEditPartCN> getInnerConnectableElementList() {
		List<LifelineEditPartCN> propertyList = new ArrayList<LifelineEditPartCN>();
		for(Object obj : getChildren()) {
			if(obj instanceof LifelineEditPartCN) {
				propertyList.add((LifelineEditPartCN)obj);
			}
		}
		return propertyList;
	}

	/**
	 * Return the inner ConnectableElements of the lifeline
	 * 
	 * @return inner ConnectableElements
	 */
	public List<Property> getProperties() {
		Lifeline lifeline = (Lifeline)resolveSemanticElement();
		return getProperties(lifeline);
	}

	/**
	 * Create specific anchor to handle connection on top, on center and on
	 * bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		if(connEditPart instanceof MessageEditPart) {
			// Create message
			return new org.eclipse.papyrus.diagram.communication.custom.figures.LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
		} else {
			return super.getTargetConnectionAnchor(connEditPart);
		}

	}

	/**
	 * Create specific anchor to handle connection on top, on center and on
	 * bottom of the lifeline
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for(Object obj : relationshipTypes) {
				if(org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes.Message_4006.equals(obj)) {
					// Create Message
					return new org.eclipse.papyrus.diagram.communication.custom.figures.LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
				}
			}
		} else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			if(connectionEditPart instanceof MessageEditPart) {
				// Create
				return new LifelineAnchor(getPrimaryShape().getFigureLifelineNameContainerFigure());
			}
		}

		return super.getTargetConnectionAnchor(request);
	}

	/**
	 * Remove listeners for Lifeline to handle notification in the message
	 * occurence specification
	 */
	@Override
	public void removeNotify() {
		notifier.unlistenAll();
		super.removeNotify();
	}

	/**
	 * Overrides because getNodeFigure() doesn't return the getFigure() anymore.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setBackgroundColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	protected void setBackgroundColor(Color c) {
		NodeFigure fig = (NodeFigure)getFigure();
		fig.setBackgroundColor(c);
		fig.setIsUsingGradient(false);
		fig.setGradientData(-1, -1, 0);
	}

	/**
	 * Overrides because getNodeFigure() doesn't return the getFigure() anymore.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setGradient(org.eclipse.gmf.runtime.notation.datatype.GradientData)
	 */
	@Override
	protected void setGradient(GradientData gradient) {
		NodeFigure fig = (NodeFigure)getFigure();
		if(gradient != null) {
			fig.setIsUsingGradient(true);
			fig.setGradientData(gradient.getGradientColor1(), gradient.getGradientColor2(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	/**
	 * Overrides because getNodeFigure() doesn't return the getFigure() anymore.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setTransparency(int)
	 */
	@Override
	protected void setTransparency(int transp) {
		NodeFigure fig = (NodeFigure)getFigure();
		fig.setTransparency(transp);
	}

	/**
	 * Update the rectangle bounds. In case of a creation, the lifeline width
	 * and height will be 0. Get the preferred size In case of a move, when the
	 * lifeline has not be resize, the width or height may be set to -1. Get the
	 * according figure bounds.
	 * 
	 * @param rect
	 *        the rectangle to update
	 */
	@SuppressWarnings("unused")
	private void updateRectangleBounds(Rectangle rect) {

		// When moving the lifeline
		if(rect.width == -1) {
			rect.width = getFigure().getBounds().width;
		}
		if(rect.height == -1) {
			rect.height = getFigure().getBounds().height;
		}
		if(rect.x == -1) {
			rect.x = getFigure().getBounds().x;
		}
		if(rect.y == -1) {
			rect.y = getFigure().getBounds().y;
		}

		// When creating the lifeline
		if(rect.width == 0) {
			rect.width = getFigure().getPreferredSize().width;
		}
		if(rect.height == 0) {
			rect.height = getFigure().getPreferredSize().height;
		}
	}

}
