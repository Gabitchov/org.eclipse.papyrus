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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

public class CommandFilter {

	private static List<IElementType> visibleCommands;

	public static List<IElementType> getVisibleCommands() {
		if(visibleCommands == null) {
			visibleCommands = new ArrayList<IElementType>();

			visibleCommands.add(UMLElementTypes.COMMENT);
			visibleCommands.add(UMLElementTypes.PACKAGE);
			//			visibleCommands.add(UMLElementTypes.DEPENDENCY);
			visibleCommands.add(UMLElementTypes.ELEMENT_IMPORT);
			visibleCommands.add(UMLElementTypes.PACKAGE_IMPORT);
			visibleCommands.add(UMLElementTypes.CONSTRAINT);
			//			visibleCommands.add(UMLElementTypes.ASSOCIATION);
			visibleCommands.add(UMLElementTypes.TEMPLATE_BINDING);
			visibleCommands.add(UMLElementTypes.TEMPLATE_SIGNATURE);
			visibleCommands.add(UMLElementTypes.TEMPLATE_PARAMETER);
			visibleCommands.add(UMLElementTypes.TEMPLATE_PARAMETER_SUBSTITUTION);
			//			visibleCommands.add(UMLElementTypes.GENERALIZATION);
			//			visibleCommands.add(UMLElementTypes.GENERALIZATION_SET);
			//			visibleCommands.add(UMLElementTypes.SUBSTITUTION);
			//			visibleCommands.add(UMLElementTypes.REALIZATION);
			//			visibleCommands.add(UMLElementTypes.ABSTRACTION);
			visibleCommands.add(UMLElementTypes.OPAQUE_EXPRESSION);
			visibleCommands.add(UMLElementTypes.PARAMETER);
			visibleCommands.add(UMLElementTypes.CONNECTABLE_ELEMENT_TEMPLATE_PARAMETER);
			visibleCommands.add(UMLElementTypes.PROPERTY);
			//			visibleCommands.add(UMLElementTypes.DEPLOYMENT);
			visibleCommands.add(UMLElementTypes.DEPLOYMENT_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.ARTIFACT);
			//			visibleCommands.add(UMLElementTypes.MANIFESTATION);
			visibleCommands.add(UMLElementTypes.OPERATION);
			//			visibleCommands.add(UMLElementTypes.INTERFACE_REALIZATION);
			visibleCommands.add(UMLElementTypes.INTERFACE);
			visibleCommands.add(UMLElementTypes.RECEPTION);
			visibleCommands.add(UMLElementTypes.SIGNAL);
			visibleCommands.add(UMLElementTypes.PROTOCOL_STATE_MACHINE);
			visibleCommands.add(UMLElementTypes.STATE_MACHINE);
			visibleCommands.add(UMLElementTypes.REGION);
			//			visibleCommands.add(UMLElementTypes.TRANSITION);
			visibleCommands.add(UMLElementTypes.TRIGGER);
			visibleCommands.add(UMLElementTypes.PORT);
			visibleCommands.add(UMLElementTypes.STATE);
			//			visibleCommands.add(UMLElementTypes.CONNECTION_POINT_REFERENCE);
			//			visibleCommands.add(UMLElementTypes.PSEUDOSTATE);
			//			visibleCommands.add(UMLElementTypes.PROTOCOL_CONFORMANCE);
			//			visibleCommands.add(UMLElementTypes.CONNECTOR);
			//			visibleCommands.add(UMLElementTypes.CONNECTOR_END);
			//			visibleCommands.add(UMLElementTypes.EXTENSION);
			//			visibleCommands.add(UMLElementTypes.EXTENSION_END);
			visibleCommands.add(UMLElementTypes.STEREOTYPE);
			visibleCommands.add(UMLElementTypes.IMAGE);
			visibleCommands.add(UMLElementTypes.PROFILE);
			visibleCommands.add(UMLElementTypes.MODEL);
			visibleCommands.add(UMLElementTypes.PARAMETER_SET);
			visibleCommands.add(UMLElementTypes.DATA_TYPE);
			visibleCommands.add(UMLElementTypes.OPERATION_TEMPLATE_PARAMETER);
			visibleCommands.add(UMLElementTypes.COLLABORATION_USE);
			visibleCommands.add(UMLElementTypes.COLLABORATION);
			visibleCommands.add(UMLElementTypes.USE_CASE);
			//			visibleCommands.add(UMLElementTypes.INCLUDE);
			//			visibleCommands.add(UMLElementTypes.EXTEND);
			visibleCommands.add(UMLElementTypes.EXTENSION_POINT);
			visibleCommands.add(UMLElementTypes.REDEFINABLE_TEMPLATE_SIGNATURE);
			visibleCommands.add(UMLElementTypes.CLASSIFIER_TEMPLATE_PARAMETER);
			visibleCommands.add(UMLElementTypes.STRING_EXPRESSION);
			visibleCommands.add(UMLElementTypes.EXPRESSION);
			//			visibleCommands.add(UMLElementTypes.USAGE);
			//			visibleCommands.add(UMLElementTypes.PACKAGE_MERGE);
			//			visibleCommands.add(UMLElementTypes.PROFILE_APPLICATION);
			visibleCommands.add(UMLElementTypes.ENUMERATION);
			visibleCommands.add(UMLElementTypes.ENUMERATION_LITERAL);
			visibleCommands.add(UMLElementTypes.INSTANCE_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.SLOT);
			visibleCommands.add(UMLElementTypes.PRIMITIVE_TYPE);
			visibleCommands.add(UMLElementTypes.LITERAL_INTEGER);
			visibleCommands.add(UMLElementTypes.LITERAL_BOOLEAN);
			visibleCommands.add(UMLElementTypes.LITERAL_STRING);
			visibleCommands.add(UMLElementTypes.LITERAL_NULL);
			visibleCommands.add(UMLElementTypes.INSTANCE_VALUE);
			visibleCommands.add(UMLElementTypes.LITERAL_UNLIMITED_NATURAL);
			visibleCommands.add(UMLElementTypes.OPAQUE_BEHAVIOR);
			visibleCommands.add(UMLElementTypes.FUNCTION_BEHAVIOR);
			visibleCommands.add(UMLElementTypes.OPAQUE_ACTION);
			visibleCommands.add(UMLElementTypes.STRUCTURED_ACTIVITY_NODE);
			visibleCommands.add(UMLElementTypes.ACTIVITY);
			visibleCommands.add(UMLElementTypes.VARIABLE);
			visibleCommands.add(UMLElementTypes.ACTIVITY_PARTITION);
			visibleCommands.add(UMLElementTypes.INTERRUPTIBLE_ACTIVITY_REGION);
			visibleCommands.add(UMLElementTypes.EXCEPTION_HANDLER);
			visibleCommands.add(UMLElementTypes.OUTPUT_PIN);
			visibleCommands.add(UMLElementTypes.PIN);
			visibleCommands.add(UMLElementTypes.INPUT_PIN);
			visibleCommands.add(UMLElementTypes.SEND_SIGNAL_ACTION);
			visibleCommands.add(UMLElementTypes.CALL_OPERATION_ACTION);
			visibleCommands.add(UMLElementTypes.CALL_BEHAVIOR_ACTION);
			visibleCommands.add(UMLElementTypes.SEQUENCE_NODE);
			visibleCommands.add(UMLElementTypes.CONTROL_FLOW);
			visibleCommands.add(UMLElementTypes.INITIAL_NODE);
			visibleCommands.add(UMLElementTypes.ACTIVITY_PARAMETER_NODE);
			visibleCommands.add(UMLElementTypes.VALUE_PIN);
			//			visibleCommands.add(UMLElementTypes.MESSAGE);
			visibleCommands.add(UMLElementTypes.INTERACTION);
			visibleCommands.add(UMLElementTypes.LIFELINE);
			visibleCommands.add(UMLElementTypes.PART_DECOMPOSITION);
			visibleCommands.add(UMLElementTypes.INTERACTION_USE);
			visibleCommands.add(UMLElementTypes.GATE);
			visibleCommands.add(UMLElementTypes.GENERAL_ORDERING);
			visibleCommands.add(UMLElementTypes.OCCURRENCE_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.INTERACTION_OPERAND);
			visibleCommands.add(UMLElementTypes.INTERACTION_CONSTRAINT);
			visibleCommands.add(UMLElementTypes.STATE_INVARIANT);
			visibleCommands.add(UMLElementTypes.ACTION_EXECUTION_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.EXECUTION_EVENT);
			visibleCommands.add(UMLElementTypes.CREATION_EVENT);
			visibleCommands.add(UMLElementTypes.DESTRUCTION_EVENT);
			visibleCommands.add(UMLElementTypes.SEND_OPERATION_EVENT);
			visibleCommands.add(UMLElementTypes.SEND_SIGNAL_EVENT);
			visibleCommands.add(UMLElementTypes.MESSAGE_OCCURRENCE_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.EXECUTION_OCCURRENCE_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.RECEIVE_OPERATION_EVENT);
			visibleCommands.add(UMLElementTypes.RECEIVE_SIGNAL_EVENT);
			visibleCommands.add(UMLElementTypes.ACTOR);
			visibleCommands.add(UMLElementTypes.CALL_EVENT);
			visibleCommands.add(UMLElementTypes.CHANGE_EVENT);
			visibleCommands.add(UMLElementTypes.SIGNAL_EVENT);
			visibleCommands.add(UMLElementTypes.ANY_RECEIVE_EVENT);
			visibleCommands.add(UMLElementTypes.FORK_NODE);
			visibleCommands.add(UMLElementTypes.FLOW_FINAL_NODE);
			visibleCommands.add(UMLElementTypes.CENTRAL_BUFFER_NODE);
			visibleCommands.add(UMLElementTypes.MERGE_NODE);
			visibleCommands.add(UMLElementTypes.DECISION_NODE);
			visibleCommands.add(UMLElementTypes.ACTIVITY_FINAL_NODE);
			//			visibleCommands.add(UMLElementTypes.COMPONENT_REALIZATION);
			visibleCommands.add(UMLElementTypes.COMPONENT);
			visibleCommands.add(UMLElementTypes.NODE);
			visibleCommands.add(UMLElementTypes.DEVICE);
			visibleCommands.add(UMLElementTypes.EXECUTION_ENVIRONMENT);
			//			visibleCommands.add(UMLElementTypes.COMMUNICATION_PATH);
			visibleCommands.add(UMLElementTypes.COMBINED_FRAGMENT);
			visibleCommands.add(UMLElementTypes.CONTINUATION);
			visibleCommands.add(UMLElementTypes.CONSIDER_IGNORE_FRAGMENT);
			visibleCommands.add(UMLElementTypes.CREATE_OBJECT_ACTION);
			visibleCommands.add(UMLElementTypes.DESTROY_OBJECT_ACTION);
			visibleCommands.add(UMLElementTypes.TEST_IDENTITY_ACTION);
			visibleCommands.add(UMLElementTypes.READ_SELF_ACTION);
			visibleCommands.add(UMLElementTypes.READ_STRUCTURAL_FEATURE_ACTION);
			visibleCommands.add(UMLElementTypes.CLEAR_STRUCTURAL_FEATURE_ACTION);
			visibleCommands.add(UMLElementTypes.REMOVE_STRUCTURAL_FEATURE_VALUE_ACTION);
			visibleCommands.add(UMLElementTypes.ADD_STRUCTURAL_FEATURE_VALUE_ACTION);
			visibleCommands.add(UMLElementTypes.LINK_END_DATA);
			visibleCommands.add(UMLElementTypes.QUALIFIER_VALUE);
			visibleCommands.add(UMLElementTypes.READ_LINK_ACTION);
			visibleCommands.add(UMLElementTypes.LINK_END_CREATION_DATA);
			visibleCommands.add(UMLElementTypes.CREATE_LINK_ACTION);
			visibleCommands.add(UMLElementTypes.DESTROY_LINK_ACTION);
			visibleCommands.add(UMLElementTypes.LINK_END_DESTRUCTION_DATA);
			visibleCommands.add(UMLElementTypes.CLEAR_ASSOCIATION_ACTION);
			visibleCommands.add(UMLElementTypes.BROADCAST_SIGNAL_ACTION);
			visibleCommands.add(UMLElementTypes.SEND_OBJECT_ACTION);
			visibleCommands.add(UMLElementTypes.VALUE_SPECIFICATION);
			visibleCommands.add(UMLElementTypes.TIME_EXPRESSION);
			visibleCommands.add(UMLElementTypes.DURATION);
			visibleCommands.add(UMLElementTypes.DURATION_INTERVAL);
			visibleCommands.add(UMLElementTypes.INTERVAL);
			visibleCommands.add(UMLElementTypes.TIME_CONSTRAINT);
			visibleCommands.add(UMLElementTypes.INTERVAL_CONSTRAINT);
			visibleCommands.add(UMLElementTypes.TIME_INTERVAL);
			visibleCommands.add(UMLElementTypes.DURATION_CONSTRAINT);
			visibleCommands.add(UMLElementTypes.TIME_OBSERVATION);
			visibleCommands.add(UMLElementTypes.DURATION_OBSERVATION);
			visibleCommands.add(UMLElementTypes.FINAL_STATE);
			visibleCommands.add(UMLElementTypes.TIME_EVENT);
			visibleCommands.add(UMLElementTypes.READ_VARIABLE_ACTION);
			visibleCommands.add(UMLElementTypes.CLEAR_VARIABLE_ACTION);
			visibleCommands.add(UMLElementTypes.ADD_VARIABLE_VALUE_ACTION);
			visibleCommands.add(UMLElementTypes.REMOVE_VARIABLE_VALUE_ACTION);
			visibleCommands.add(UMLElementTypes.RAISE_EXCEPTION_ACTION);
			visibleCommands.add(UMLElementTypes.ACTION_INPUT_PIN);
			visibleCommands.add(UMLElementTypes.INFORMATION_ITEM);
			//			visibleCommands.add(UMLElementTypes.INFORMATION_FLOW);
			visibleCommands.add(UMLElementTypes.READ_EXTENT_ACTION);
			visibleCommands.add(UMLElementTypes.RECLASSIFY_OBJECT_ACTION);
			visibleCommands.add(UMLElementTypes.READ_IS_CLASSIFIED_OBJECT_ACTION);
			visibleCommands.add(UMLElementTypes.START_CLASSIFIER_BEHAVIOR_ACTION);
			visibleCommands.add(UMLElementTypes.READ_LINK_OBJECT_END_ACTION);
			visibleCommands.add(UMLElementTypes.READ_LINK_OBJECT_END_QUALIFIER_ACTION);
			visibleCommands.add(UMLElementTypes.CREATE_LINK_OBJECT_ACTION);
			visibleCommands.add(UMLElementTypes.ACCEPT_EVENT_ACTION);
			visibleCommands.add(UMLElementTypes.ACCEPT_CALL_ACTION);
			visibleCommands.add(UMLElementTypes.REPLY_ACTION);
			visibleCommands.add(UMLElementTypes.UNMARSHALL_ACTION);
			visibleCommands.add(UMLElementTypes.REDUCE_ACTION);
			visibleCommands.add(UMLElementTypes.JOIN_NODE);
			visibleCommands.add(UMLElementTypes.DATA_STORE_NODE);
			visibleCommands.add(UMLElementTypes.OBJECT_FLOW);
			visibleCommands.add(UMLElementTypes.CONDITIONAL_NODE);
			visibleCommands.add(UMLElementTypes.CLAUSE);
			visibleCommands.add(UMLElementTypes.LOOP_NODE);
			visibleCommands.add(UMLElementTypes.EXPANSION_NODE);
			visibleCommands.add(UMLElementTypes.EXPANSION_REGION);
			visibleCommands.add(UMLElementTypes.PROTOCOL_TRANSITION);
			visibleCommands.add(UMLElementTypes.ASSOCIATION_CLASS);

		}

		return visibleCommands;
	}
}
