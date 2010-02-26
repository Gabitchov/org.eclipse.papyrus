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
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class ModelValidationHelper
 */
public class ModelValidationHelper {

	/**
	 * Validate connector end.
	 * 
	 * @param connector
	 * @param ctx
	 * @return the status
	 */
	public static IStatus validateConnectorEnd(Connector connector, IValidationContext ctx) {
		if ((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType()))
				&& UMLPackage.eINSTANCE.getConnector_End().equals(ctx.getFeature())) {
			Element owner = connector.getOwner();
			EList<ConnectorEnd> connectorEnds = connector.getEnds();
			if (!connectorEnds.isEmpty() && connectorEnds.size() > 1) {
				ConnectableElement role1 = connectorEnds.get(0).getRole();
				ConnectableElement role2 = connectorEnds.get(1).getRole();
				if (role1 instanceof Property && role2 instanceof Property) {
					PropertyLinkedToClassifier link1 = new PropertyLinkedToClassifier((Classifier) owner,
							(Property) role1);
					if (link1.isLinkedWithMultiLevelPath()) {
						// create a nested connector end
						NestedConnectorEnd end = createNestedConnectorEnd(connectorEnds.get(0));
						if (!link1.getAvailableRoutes().isEmpty()) {
							end.getPropertyPath().addAll(link1.getAvailableRoutes().get(0).getProperties());
						}
					}
					PropertyLinkedToClassifier link2 = new PropertyLinkedToClassifier((Classifier) owner,
							(Property) role2);
					if (link2.isLinkedWithMultiLevelPath()) {
						// create a nested connector end
						NestedConnectorEnd end = createNestedConnectorEnd(connectorEnds.get(1));
						if (!link2.getAvailableRoutes().isEmpty()) {
							end.getPropertyPath().addAll(link2.getAvailableRoutes().get(0).getProperties());
						}
					}
				}
			}
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
		// TODO this validator will manage connectorEnd update when property is moved
		if ((EMFEventType.MOVE.equals(ctx.getEventType())) || (EMFEventType.SET.equals(ctx.getEventType()))) {
			// only update if property is linked to connector end
			for (ConnectorEnd end : property.getEnds()) {
				if (end.getOwner() != null && end.getOwner() instanceof Connector) {
					Element owner = ((Connector) end.getOwner()).getOwner();
					if (owner instanceof Classifier) {
						PropertyLinkedToClassifier link = new PropertyLinkedToClassifier((Classifier) owner, property);
						if (link.isLinkedWithMultiLevelPath()) {
							createNestedConnectorEnd(end);
						} else if (end instanceof NestedConnectorEnd) {
							((NestedConnectorEnd) end).setBase_ConnectorEnd(null);
							ResourceUtil.getResource(end).getEobjects().remove(end);
						}
					}
				}
			}
		}
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
