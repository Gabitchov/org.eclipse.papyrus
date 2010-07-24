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
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.helper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editparts.PapyrusStereotypeListener;
import org.eclipse.papyrus.diagram.common.helper.NotificationHelper;
import org.eclipse.papyrus.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.BlockDefinitionDiagramElementTypes;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


public class BlockPropertyHelper extends NotificationHelper {

	/** The UI adapter that listens model update to detect when compartment switch must be performed */
	private UIAdapter adapter;

	public BlockPropertyHelper(Node node) {
		adapter = new UIAdapter(node);
		this.setModelListener(adapter);
	}

	private class UIAdapter extends UIAdapterImpl {

		private EList<View> compartments;

		private View referenceCompartment = null;

		private View partCompartment = null;

		private View valueCompartment = null;

		private View propertyCompartment = null;

		private View constraintCompartment = null;

		@SuppressWarnings("unchecked")
		public UIAdapter(Node blockNode) {

			// retrieve the different compartments
			compartments = blockNode.getChildren();

			for(View compartment : compartments) {
				if(compartment.getType().equals(BlockDefinitionDiagramElementTypes.BLOCK_REFERENCE_COMPARTMENT_HINT)) {
					referenceCompartment = compartment;
				} else if(compartment.getType().equals(BlockDefinitionDiagramElementTypes.BLOCK_PART_COMPARTMENT_HINT)) {
					partCompartment = compartment;
				} else if(compartment.getType().equals(BlockDefinitionDiagramElementTypes.BLOCK_VALUE_COMPARTMENT_HINT)) {
					valueCompartment = compartment;
				} else if(compartment.getType().equals(BlockDefinitionDiagramElementTypes.BLOCK_PROPERTY_COMPARTMENT_HINT)) {
					propertyCompartment = compartment;
				} else if(compartment.getType().equals(BlockDefinitionDiagramElementTypes.BLOCK_CONSTRAINT_COMPARTMENT_HINT)) {
					constraintCompartment = compartment;
				}
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void safeNotifyChanged(Notification msg) {
			View oldCompartment = null;
			View newCompartment = null;
			View propertyView = null;

			Property property = (Property)msg.getNotifier();

			// only SET notifications
			if(msg.getEventType() == Notification.SET) {
				newCompartment = getCompartmentFromNotification(msg);
			} else if(msg.getEventType() == PapyrusStereotypeListener.APPLIED_STEREOTYPE || msg.getEventType() == PapyrusStereotypeListener.UNAPPLIED_STEREOTYPE) {
				if(property.getAppliedStereotype(SysmlResource.CONSTRAINT_PROPERTY_ID) != null) {
					newCompartment = constraintCompartment;
				}
			}

			if(newCompartment != null) {
				for(View compartment : compartments) {
					EList<View> compartmentChildren = compartment.getChildren();
					for(View compartmentChild : compartmentChildren) {
						if(compartmentChild.getElement().equals(msg.getNotifier())) {
							oldCompartment = compartment;
							propertyView = compartmentChild;
						}
					}
				}

				if(oldCompartment != null && !oldCompartment.equals(newCompartment)) {
					oldCompartment.removeChild(propertyView);
					newCompartment.insertChild(propertyView);
				}
			}
		}

		private View getCompartmentFromNotification(Notification msg) {
			// TODO check getFeatureID usage

			// monitor change of type
			if(msg.getFeatureID(Property.class) == UMLPackage.PROPERTY__TYPE) {
				Object newValue = msg.getNewValue();
				if(newValue instanceof Class && ((Class)newValue).getAppliedStereotype(SysmlResource.BLOCK_ID) != null) {
					if(((Property)msg.getNotifier()).getAggregation().equals(AggregationKind.COMPOSITE_LITERAL)) {
						return partCompartment;
					} else {
						return referenceCompartment;
					}
				} else if(newValue instanceof DataType) {
					return valueCompartment;
				} else {
					return propertyCompartment;
				}
				// monitor change of aggregation kind
			} else if(msg.getFeatureID(Property.class) == UMLPackage.PROPERTY__AGGREGATION) {
				Type type = ((Property)msg.getNotifier()).getType();
				if(type instanceof Class && ((Class)type).getAppliedStereotype(SysmlResource.BLOCK_ID) != null) {
					if(((AggregationKind)msg.getNewValue()).equals(AggregationKind.COMPOSITE_LITERAL)) {
						return partCompartment;
					} else {
						return referenceCompartment;
					}
				}
			}
			return null;
		}
	}
}
