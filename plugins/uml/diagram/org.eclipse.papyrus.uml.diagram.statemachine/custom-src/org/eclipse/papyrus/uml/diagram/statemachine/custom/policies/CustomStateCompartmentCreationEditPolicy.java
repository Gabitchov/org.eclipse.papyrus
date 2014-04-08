/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomFirstRegionInCompositeStateCreateElementCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;

public class CustomStateCompartmentCreationEditPolicy extends CreationEditPolicy {
	IFigure sizeOnDropFeedback = null;
	String dropLocation = Zone.NONE;

	@Override
	public Command getCommand(Request request) {
		// CHECK THIS
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);
		if (understandsRequest(request)) {
			if (request instanceof CreateUnspecifiedTypeRequest) {
				CreateUnspecifiedTypeRequest unspecReq = (CreateUnspecifiedTypeRequest) request;
				for (Iterator<?> iter = unspecReq.getElementTypes().iterator(); iter.hasNext();) {
					IElementType elementType = (IElementType) iter.next();
					if (((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Region_3000).getSemanticHint())) {
						// starting point is the state compartment on
						// which mouse was moving
						View stateCompartmentView = (View) getHost().getModel();
						// get and adaptable for it, to pass on to commands
						IAdaptable adaptableForStateCompartmentView = (IAdaptable) new SemanticAdapter(null, stateCompartmentView);
						// do the whole job
						CustomFirstRegionInCompositeStateCreateElementCommand createNewRegion = new CustomFirstRegionInCompositeStateCreateElementCommand(adaptableForStateCompartmentView, null, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint(),
								editingDomain, DiagramUIMessages.CreateCommand_Label, dropLocation);
						cc.compose(createNewRegion);
						return new ICommandProxy(cc.reduce());
					}
				}
			} else if (request instanceof ChangeBoundsRequest) {
				ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;
				Point mouseLocation = changeBoundsRequest.getLocation();
				DropObjectsRequest dropRequest = new DropObjectsRequest();
				dropRequest.setLocation(mouseLocation);
				List<View> list = new ArrayList<View>();
				Iterator<?> it = changeBoundsRequest.getEditParts().iterator();
				while (it.hasNext()) {
					Object next = it.next();
					if (next instanceof EditPart) {
						EditPart ep = (EditPart) next;
						if (ep instanceof RegionEditPart) {
							View regionToDrag = (View) ep.getModel();
							list.add(regionToDrag);
						}
					}
				}
				dropRequest.setObjects(list);
				return getHost().getCommand(dropRequest);
			}
			return super.getCommand(request);
		}
		return null;
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest createUnspecifiedTypeRequest = (CreateUnspecifiedTypeRequest) request;
			if (understandsRequest(request)) {
				List<?> elementTypes = createUnspecifiedTypeRequest.getElementTypes();
				// Treat the case where only one element type is listed
				// Only take EntryPoint or ExitPoint element type into account
				if ((elementTypes.size() == 1) && (((IElementType) (elementTypes.get(0)) == UMLElementTypes.ConnectionPointReference_18000))) {
					// If the target is a compartment replace by its parent edit part
					if ((getHost() instanceof ShapeCompartmentEditPart)) {
						return getHost().getParent();
					}
				}
			}
		}
		return super.getTargetEditPart(request);
	}
	// @Override
	// public void eraseTargetFeedback(Request request) {
	// if(sizeOnDropFeedback != null) {
	// LayerManager.Helper.find(getHost()).getLayer(LayerConstants.FEEDBACK_LAYER).remove(sizeOnDropFeedback);
	// sizeOnDropFeedback = null;
	// }
	// }
	// protected IFigure getSizeOnDropFeedback() {
	// if(sizeOnDropFeedback == null) {
	// sizeOnDropFeedback = new RectangleFigure();
	// FigureUtilities.makeGhostShape((Shape)sizeOnDropFeedback);
	// ((Shape)sizeOnDropFeedback).setLineStyle(Graphics.LINE_DASHDOT);
	// sizeOnDropFeedback.setForegroundColor(ColorConstants.white);
	// LayerManager.Helper.find(getHost()).getLayer(LayerConstants.FEEDBACK_LAYER).add(sizeOnDropFeedback);
	// }
	// return sizeOnDropFeedback;
	// }
	// @Override
	// public EditPart getTargetEditPart(Request request) {
	//
	// if(request instanceof CreateUnspecifiedTypeRequest) {
	// CreateUnspecifiedTypeRequest createUnspecifiedTypeRequest = (CreateUnspecifiedTypeRequest)request;
	//
	// if(understandsRequest(request)) {
	// List<?> elementTypes = createUnspecifiedTypeRequest.getElementTypes();
	// // Treat the case where only one element type is listed
	// // Only take EntryPoint or ExitPoint element type into account
	// if((elementTypes.size() == 1) && (((IElementType)(elementTypes.get(0)) == UMLElementTypes.Pseudostate_16000) || ((IElementType)(elementTypes.get(0)) == UMLElementTypes.Pseudostate_17000))) {
	// // If the target is a compartment replace by its grand parent edit part
	// if((getHost() instanceof ShapeCompartmentEditPart)) {
	// return getHost().getParent().getParent().getParent();
	// }
	// }
	// }
	// }
	//
	// return super.getTargetEditPart(request);
	// }
	//
	// @Override
	// public void showTargetFeedback(Request request) {
	// if(request instanceof CreateUnspecifiedTypeRequest) {
	// CreateUnspecifiedTypeRequest unspecReq = (CreateUnspecifiedTypeRequest)request;
	// for(Iterator iter = unspecReq.getElementTypes().iterator(); iter.hasNext();) {
	// IElementType elementType = (IElementType)iter.next();
	// if(elementType.equals(UMLElementTypes.Region_3000)) {
	// RegionFigure targetFig = ((RegionEditPart)getHost().getParent()).getPrimaryShape();
	//
	// // make a local copy
	// Rectangle targetFigBounds = targetFig.getBounds().getCopy();
	// // transform the coordinates to absolute
	// targetFig.translateToAbsolute(targetFigBounds);
	// // retrieve mouse location
	// Point mouseLocation = unspecReq.getLocation();
	//
	// // get the drop location, i.e. RIGHT, LEFT, TOP, BOTTOM
	// dropLocation = Zone.getZoneFromLocationInRectangleWithAbsoluteCoordinates(mouseLocation, targetFigBounds);
	//
	// // perform corresponding change (scaling, translation) on
	// // targetFigBounds
	// // and updates the graph node drop location property
	// if(Zone.isTop(dropLocation)) {
	// targetFigBounds.setSize(targetFigBounds.getSize().scale(1.0, 0.5));
	// } else if(Zone.isLeft(dropLocation)) {
	// targetFigBounds.setSize(targetFigBounds.getSize().scale(0.5, 1.0));
	// } else if(Zone.isRight(dropLocation)) {
	// targetFigBounds.setSize(targetFigBounds.getSize().scale(0.5, 1.0));
	// targetFigBounds.translate(targetFigBounds.width, 0);
	// } else if(Zone.isBottom(dropLocation)) {
	// targetFigBounds.setSize(targetFigBounds.getSize().scale(1.0, 0.5));
	// targetFigBounds.translate(0, targetFigBounds.height);
	// }
	//
	// getSizeOnDropFeedback().setBounds(new PrecisionRectangle(targetFigBounds));
	// }
	// }
	// }
	// }
}
