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
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
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
import org.eclipse.papyrus.uml.diagram.statemachine.custom.commands.CustomVertexCreateElementCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.uml.State;

public class CustomStateCreationEditPolicy extends CreationEditPolicy {
	IFigure sizeOnDropFeedback = null;
	String dropLocation = Zone.NONE;

	// @Override
	// public void eraseTargetFeedback(Request request) {
	// if(sizeOnDropFeedback != null) {
	// LayerManager.Helper.find(getHost()).getLayer(LayerConstants.FEEDBACK_LAYER).remove(sizeOnDropFeedback);
	// sizeOnDropFeedback = null;
	// }
	// }
	@Override
	public Command getCommand(Request request) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);
		if (understandsRequest(request)) {
			if (request instanceof CreateUnspecifiedTypeRequest) {
				CreateUnspecifiedTypeRequest unspecReq = (CreateUnspecifiedTypeRequest) request;
				for (Iterator<?> iter = unspecReq.getElementTypes().iterator(); iter.hasNext();) {
					IElementType elementType = (IElementType) iter.next();
					if (((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Region_3000).getSemanticHint())) {
						// starting point is the state node on
						// which mouse was moving
						View stateView = (View) getHost().getModel();
						View stateCompartmentView = (View) stateView.getChildren().get(1);
						// get and adaptable for it, to pass on to commands
						IAdaptable adaptableForStateCompartmentView = (IAdaptable) new SemanticAdapter(null, stateCompartmentView);
						if (!stateCompartmentView.getChildren().isEmpty()) {
							// CHECK THIS
							// ENamedElement namedElement = PackageUtil.getElement("notation.View.visible");
							// if(ViewUtil.getStructuralFeatureValue(stateCompartmentView, (EStructuralFeature)namedElement).equals(new Boolean(false))){
							// SetPropertyCommand showCompartment = new SetPropertyCommand(editingDomain, adaptableForStateCompartmentView, "notation.View.visible", "Visibility", true);
							// showCompartment.setOptions(Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
							//
							// try {
							// showCompartment.execute(null, null);
							// } catch (ExecutionException e) {
							// }
							// }
							return null;
						}
						// do the whole job
						CustomFirstRegionInCompositeStateCreateElementCommand createNewRegion = new CustomFirstRegionInCompositeStateCreateElementCommand(adaptableForStateCompartmentView, null, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint(),
								editingDomain, DiagramUIMessages.CreateCommand_Label, dropLocation);
						SetPropertyCommand showCompartment = new SetPropertyCommand(editingDomain, adaptableForStateCompartmentView, "notation.View.visible", "Visibility", true);
						cc.compose(showCompartment);
						cc.compose(createNewRegion);
						return new ICommandProxy(cc.reduce());
					} else if (((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_8000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_9000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_10000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_11000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_12000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_13000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_14000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_15000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_16000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.Pseudostate_17000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.State_6000).getSemanticHint())
							|| ((IHintedType) elementType).getSemanticHint().equals(((IHintedType) UMLElementTypes.FinalState_5000).getSemanticHint())) {
						// starting point is the state node on
						// which mouse was moving
						View stateView = (View) getHost().getModel();
						/*
						 * TO Check from last version
						 * 
						 * View stateCompartmentView = (View)stateView.getChildren().get(1);
						 */
						View stateCompartmentView = ViewUtil.getChildBySemanticHint(stateView, String.valueOf(StateCompartmentEditPart.VISUAL_ID));
						// transfer the request to the super method to deal with regular Entry/ExitPoint creation
						if (!stateCompartmentView.getChildren().isEmpty() || !((State) stateView.getElement()).getRegions().isEmpty())
							return super.getCommand(request);
						// get and adaptable for it, to pass on to commands
						IAdaptable adaptableForStateCompartmentView = (IAdaptable) new SemanticAdapter(null, stateCompartmentView);
						// do the whole job
						CustomFirstRegionInCompositeStateCreateElementCommand createNewRegion = new CustomFirstRegionInCompositeStateCreateElementCommand(adaptableForStateCompartmentView, null, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint(),
								editingDomain, DiagramUIMessages.CreateCommand_Label, dropLocation);
						SetPropertyCommand showCompartment = new SetPropertyCommand(editingDomain, adaptableForStateCompartmentView, "notation.View.visible", "Visibility", true);
						CustomVertexCreateElementCommand createVertex = new CustomVertexCreateElementCommand((IAdaptable) createNewRegion.getCommandResult().getReturnValue(), (IHintedType) elementType,
								((IGraphicalEditPart) getHost()).getDiagramPreferencesHint(), editingDomain, DiagramUIMessages.CreateCommand_Label);
						cc.compose(showCompartment);
						cc.compose(createNewRegion);
						cc.compose(createVertex);
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
