/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.helper;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.resource.util.ResourceUtil;
import org.eclipse.papyrus.sysml.blocks.BlocksFactory;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.diagram.parametric.utils.PropertyLinkedToClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class ModelValidationHelper
 */
public class ModelValidationHelper {

	private static final String NESTED_CONNECTOR_END_STEREOTYPE = "SysML::Blocks::NestedConnectorEnd";

	/**
	 * Validate connector end.
	 * 
	 * @param connector
	 * @param ctx
	 * @return the status
	 */
	public static IStatus validateConnector(Connector connector, IValidationContext ctx) {
		if ((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType()))
				&& UMLPackage.eINSTANCE.getConnector_End().equals(ctx.getFeature())) {
			// do nothing
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Validate property.
	 * 
	 * @param property
	 * @param ctx
	 * @return the status
	 */
	public static IStatus validateProperty(Property property, IValidationContext ctx) {
		// TODO this validator will manage connectorEnd update when source/target property is moved into and IBD
		if ((EMFEventType.MOVE.equals(ctx.getEventType())) || (EMFEventType.SET.equals(ctx.getEventType()))) {
			// only update if property is linked to connector end
			for (ConnectorEnd end : property.getEnds()) {
				if (end.getOwner() != null && end.getOwner() instanceof Connector) {
					Element owner = ((Connector) end.getOwner()).getOwner();
					if (owner instanceof Classifier) {
						PropertyLinkedToClassifier link = new PropertyLinkedToClassifier((Classifier) owner, property);
						if (link.isLinkedWithMultiLevelPath()) {
							createNestedConnectorEnd(end);
						} else {
							Stereotype appliedStereotype = end.getAppliedStereotype(NESTED_CONNECTOR_END_STEREOTYPE);
							if (appliedStereotype != null) {
								end.unapplyStereotype(appliedStereotype);
							}
						}
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Validate connector end.
	 * 
	 * @param connectorEnd
	 * @param ctx
	 * @return the status
	 */
	public static IStatus validateConnectorEnd(ConnectorEnd connectorEnd, IValidationContext ctx) {
		if ((EMFEventType.SET.equals(ctx.getEventType()))
				&& UMLPackage.eINSTANCE.getConnectorEnd_Role().equals(ctx.getFeature())) {
			ConnectableElement connectableElement = connectorEnd.getRole();
			Element connector = connectorEnd.getOwner();
			if (connector != null && connector.getOwner() instanceof Classifier) {
				Classifier owner = (Classifier) connector.getOwner();
				PropertyLinkedToClassifier link = new PropertyLinkedToClassifier((Classifier) owner,
						(Property) connectableElement);
				if (link.isLinkedWithMultiLevelPath()) {
					// create a nested connector end
					NestedConnectorEnd end = createNestedConnectorEnd(connectorEnd);
					if (!link.getAvailableRoutes().isEmpty()) {
						end.getPropertyPath().addAll(link.getAvailableRoutes().get(0).getProperties());
					}
				} else {
					Stereotype appliedStereotype = connectorEnd.getAppliedStereotype(NESTED_CONNECTOR_END_STEREOTYPE);
					if (appliedStereotype != null) {
						connectorEnd.unapplyStereotype(appliedStereotype);
					}
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Validate nested connector end.
	 * 
	 * @param connectorEnd
	 * @param ctx
	 * @return the status
	 */
	public static IStatus validateNestedConnectorEnd(NestedConnectorEnd connectorEnd, IValidationContext ctx) {
		// TODO setBase_ConnectorEnd should be set to null when connector is deleted, fix problem
		// with delete from model command
		// there are dangling references after this command
		// if (EMFEventType.SET.equals(ctx.getEventType())) {
		// ResourceUtil.getResource(connectorEnd).getEobjects().remove(connectorEnd);
		// }
		return ctx.createSuccessStatus();
	}

	/**
	 * Creates the nested connector end for a connector end
	 * 
	 * @param connectorEnd
	 *            the connector end
	 * @return the nested connector end
	 */
	private static NestedConnectorEnd createNestedConnectorEnd(ConnectorEnd connectorEnd) {
		NestedConnectorEnd nested = BlocksFactory.eINSTANCE.createNestedConnectorEnd();
		Resource res = ResourceUtil.getResource(connectorEnd);
		if (res != null) {
			res.getEobjects().add(nested);
			nested.setBase_ConnectorEnd(connectorEnd);
		}
		return nested;
	}

}
