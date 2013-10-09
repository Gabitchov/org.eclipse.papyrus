/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.service.types.command.SetNestedPathCommand;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <pre>
 * This HelperAdvice completes {@link Connector} edit commands with SysML specific actions:
 * - Re-orient with structure encapsulation respect.
 * </pre>
 */
public class ConnectorEditHelperAdvice extends AbstractEditHelperAdvice {

	private ConnectorUtils utils = new ConnectorUtils();

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeReorientRelationshipCommand(final ReorientRelationshipRequest request) {
		final CompositeCommand compositeCommand = new CompositeCommand("Destroy Connector View Command");

		//the UML Connector Edit Helper Advice destroys connector views when roles changes
		//Here, we destroys connectors views, when the path changes
		final EObject editedElement = request.getRelationship();
		if(editedElement instanceof Connector) {

			if(applySysMLRules(((Connector)editedElement).getOwner())) {
				final Connector connector = (Connector)editedElement;
				//verify the path now
				int reorientDirection = request.getDirection();
				Edge reorientedEdgeView = RequestParameterUtils.getReconnectedEdge(request);
				View newEndView = RequestParameterUtils.getReconnectedEndView(request);
				View oppositeEndView = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? reorientedEdgeView.getTarget() : reorientedEdgeView.getSource();
				List<Property> newNestedPath = null;
				if(reorientedEdgeView != null && newEndView != null) {
					//we are working with a 'graphical' reconnect request
					newNestedPath = utils.getNestedPropertyPath(newEndView, oppositeEndView);
				} else {
					newNestedPath = (List<Property>)request.getParameter(ConnectorUtils.NESTED_CONNECTOR_END_PATH);
				}

				final Set<View> viewsToDestroy = utils.getViewsRepresentingConnector(connector);
				final Iterator<View> iter = viewsToDestroy.iterator();

				while(iter.hasNext()) {
					final Edge current = (Edge)iter.next();
					if(current != reorientedEdgeView) {
						View oldEndView = null;
						if(reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_SOURCE) {
							oldEndView = current.getSource();
						} else if(reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_TARGET) {
							oldEndView = current.getTarget();
						}
						final List<Property> oldNestedPath = utils.getNestedPropertyPath(oldEndView, oppositeEndView);
						if(!newNestedPath.equals(oldNestedPath)) {
							final DestroyElementRequest destroyRequest = new DestroyElementRequest(request.getEditingDomain(), current, false);
							final IElementEditService commandProvider = ElementEditServiceUtils.getCommandProvider(current);
							compositeCommand.add(commandProvider.getEditCommand(destroyRequest));
						}
					}
				}
				if(!compositeCommand.isEmpty()) {
					return compositeCommand;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param connectorOwner
	 *        the owner of the connector
	 * @return
	 */
	protected boolean applySysMLRules(final Element connectorOwner) {
		return connectorOwner.getApplicableStereotype("SysML::Blocks::Block") != null;
	}

	@Override
	protected ICommand getAfterReorientRelationshipCommand(final ReorientRelationshipRequest request) {
		//we set the new value for the nested path
		ICommand defaultCommand = super.getAfterReorientRelationshipCommand(request);

		int reorientDirection = request.getDirection();


		// Restrict this advice action to the end of Connector creation gesture (before clicking on target)
		// in order to add SysML specific constraint
		Connector connector = (Connector)request.getRelationship();
		//get the direction

		// Restrict action to SysML Connector (meaning owned by Block)
		if(((ISpecializationType)SysMLElementTypes.BLOCK).getMatcher().matches(connector.eContainer())) {
			List<Property> tmpNestedPath = null;
			Edge reorientedEdgeView = RequestParameterUtils.getReconnectedEdge(request);
			View newEndView = RequestParameterUtils.getReconnectedEndView(request);
			View oppositeEndView = null;

			//graphical case : verify encapsulation and get the new path
			StructuredClassifier newOwner;
			if(reorientedEdgeView != null) {

				oppositeEndView = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? reorientedEdgeView.getTarget() : reorientedEdgeView.getSource();
				Assert.isNotNull(oppositeEndView);
				Assert.isNotNull(newEndView);
				if(newEndView != null && oppositeEndView != null) {
					// If the source or target view is enclosed in a structure encapsulated view, forbid creation.
					if(utils.isCrossingEncapsulation(newEndView, oppositeEndView) || utils.isCrossingEncapsulation(oppositeEndView, newEndView)) {
						return UnexecutableCommand.INSTANCE;
					}
					//					newOwner = utils.deduceContainer(newEndView, oppositeEndView);
					tmpNestedPath = utils.getNestedPropertyPath(newEndView, oppositeEndView);
				}
			} else {
				//we are in the semantic case
				tmpNestedPath = ((List<Property>)request.getParameter(ConnectorUtils.NESTED_CONNECTOR_END_PATH));

				//we need to verify encapsulation
				if(ConnectorUtils.isCrossingEncapuslation(tmpNestedPath)) {
					return UnexecutableCommand.INSTANCE;
				}
			}

			final List<ConnectableElement> oppositeFullNestedPath = new ArrayList<ConnectableElement>();
			final List<ConnectableElement> newFullNestedPath = new ArrayList<ConnectableElement>(tmpNestedPath);
			ConnectableElement newRole = (Property)request.getNewRelationshipEnd();
			final ConnectorEnd oppositeEnd;
			if(reorientDirection == ReorientRequest.REORIENT_SOURCE) {
				oppositeEnd = ((Connector)request.getRelationship()).getEnds().get(1);
			} else {
				oppositeEnd = ((Connector)request.getRelationship()).getEnds().get(0);
			}
			final NestedConnectorEnd nestedConnectorEnd = UMLUtil.getStereotypeApplication(oppositeEnd, NestedConnectorEnd.class);
			if(nestedConnectorEnd != null) {
				oppositeFullNestedPath.addAll(nestedConnectorEnd.getPropertyPath());
			}
			oppositeFullNestedPath.add(oppositeEnd.getRole());
			newFullNestedPath.add(newRole);

			//TODO : we should recalculate a new owner according to the new nested path, then update these nested path according to the new owner
			//we don't do it now, because we have some troubles with connector
			//final EncapsulatedClassifier newOwner = deduceNewConnectorOwner(oppositeFullNestedPath, newFullNestedPath);
			
			int tmpNestedPathDirection = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? SetNestedPathCommand.NESTED_SOURCE : SetNestedPathCommand.NESTED_TARGET;
			defaultCommand = CompositeCommand.compose(defaultCommand, new SetNestedPathCommand("Set connector nested source path", request.getRelationship(), request, tmpNestedPath, tmpNestedPathDirection)); //$NON-NLS-0$
		}

		return defaultCommand;
	}



	//	/**
	//	 * @param fullNestedPathWithrole1
	//	 * @param fullNestedPathWithRole2
	//	 * @return
	//	 *         the new owner for the connector
	//	 */
	//doesnt work currently
	//	public static final EncapsulatedClassifier deduceNewConnectorOwner(final List<ConnectableElement> fullNestedPathWithrole1, final List<ConnectableElement> fullNestedPathWithRole2) {
	//		final ConnectableElement firstElementPath = fullNestedPathWithrole1.get(0);
	//		//case of encapsulation of the part
	//		if(fullNestedPathWithRole2.get(0) == firstElementPath) {
	//			if(fullNestedPathWithRole2.size() > 1) {
	//				fullNestedPathWithrole1.remove(0);
	//				fullNestedPathWithRole2.remove(0);
	//				return deduceNewConnectorOwner(fullNestedPathWithrole1, fullNestedPathWithRole2);
	//			} else {
	//				return (EncapsulatedClassifier)firstElementPath.getOwner();
	//			}
	//		} else {
	//			final ConnectableElement firstElementPath2 = fullNestedPathWithRole2.get(0);
	//			if(firstElementPath.getOwner() == firstElementPath2.getOwner()) {
	//				return (EncapsulatedClassifier)firstElementPath.getOwner();
	//			} else {
	//				final List<ConnectableElement> biggestList;
	//				final List<ConnectableElement> smallestList;
	//				if(fullNestedPathWithrole1.size() > fullNestedPathWithRole2.size()) {
	//					biggestList = fullNestedPathWithrole1;
	//					smallestList = fullNestedPathWithRole2;
	//				} else {
	//					biggestList = fullNestedPathWithRole2;
	//					smallestList = fullNestedPathWithrole1;
	//				}
	//				for(int i = 0; i < biggestList.size(); i++) {
	//					final ConnectableElement current = biggestList.get(i);
	//					if(smallestList.contains(current) && i > 0) {
	//						return (EncapsulatedClassifier)biggestList.get(i - 1).getOwner();
	//					}
	//				}
	//			}
	//		}
	//		return null;
	//		//		throw new RuntimeException("error");
	//
	//
	//
	//
	//
	//	}

}
