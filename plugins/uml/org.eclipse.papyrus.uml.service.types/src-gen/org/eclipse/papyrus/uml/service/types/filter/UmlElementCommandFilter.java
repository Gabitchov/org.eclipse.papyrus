/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

public class UmlElementCommandFilter implements ICommandFilter {

	/**
	 * Singleton instance
	 */
	public static final UmlElementCommandFilter INSTANCE = new UmlElementCommandFilter();

	private List<IElementType> visibleCommands;

	private UmlElementCommandFilter() {
		//to prevent instantiation
	}

	public List<IElementType> getVisibleCommands() {
		if(visibleCommands == null) {
			List<IElementType> localVisibleCommands = new ArrayList<IElementType>();

			// localVisibleCommands.add(UMLElementTypes.ABSTRACTION);
			localVisibleCommands.add(UMLElementTypes.ACCEPT_CALL_ACTION);
			localVisibleCommands.add(UMLElementTypes.ACCEPT_EVENT_ACTION);
			localVisibleCommands.add(UMLElementTypes.ACTION_EXECUTION_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.ACTION_INPUT_PIN);
			localVisibleCommands.add(UMLElementTypes.ACTIVITY);
			localVisibleCommands.add(UMLElementTypes.ACTIVITY_FINAL_NODE);
			localVisibleCommands.add(UMLElementTypes.ACTIVITY_PARAMETER_NODE);
			localVisibleCommands.add(UMLElementTypes.ACTIVITY_PARTITION);
			localVisibleCommands.add(UMLElementTypes.ACTOR);
			localVisibleCommands.add(UMLElementTypes.ADD_STRUCTURAL_FEATURE_VALUE_ACTION);
			localVisibleCommands.add(UMLElementTypes.ADD_VARIABLE_VALUE_ACTION);
			localVisibleCommands.add(UMLElementTypes.ANY_RECEIVE_EVENT);
			localVisibleCommands.add(UMLElementTypes.ARTIFACT);
			// localVisibleCommands.add(UMLElementTypes.ASSOCIATION_BASE);
			// localVisibleCommands.add(UMLElementTypes.ASSOCIATION_CLASS);
			localVisibleCommands.add(UMLElementTypes.BEHAVIOR_EXECUTION_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.BROADCAST_SIGNAL_ACTION);
			localVisibleCommands.add(UMLElementTypes.CALL_BEHAVIOR_ACTION);
			localVisibleCommands.add(UMLElementTypes.CALL_EVENT);
			localVisibleCommands.add(UMLElementTypes.CALL_OPERATION_ACTION);
			localVisibleCommands.add(UMLElementTypes.CENTRAL_BUFFER_NODE);
			localVisibleCommands.add(UMLElementTypes.CHANGE_EVENT);
			localVisibleCommands.add(UMLElementTypes.CLASS);
			localVisibleCommands.add(UMLElementTypes.CLASSIFIER_TEMPLATE_PARAMETER);
			localVisibleCommands.add(UMLElementTypes.CLAUSE);
			localVisibleCommands.add(UMLElementTypes.CLEAR_ASSOCIATION_ACTION);
			localVisibleCommands.add(UMLElementTypes.CLEAR_STRUCTURAL_FEATURE_ACTION);
			localVisibleCommands.add(UMLElementTypes.CLEAR_VARIABLE_ACTION);
			localVisibleCommands.add(UMLElementTypes.COLLABORATION);
			localVisibleCommands.add(UMLElementTypes.COLLABORATION_USE);
			localVisibleCommands.add(UMLElementTypes.COMBINED_FRAGMENT);
			localVisibleCommands.add(UMLElementTypes.COMMENT);
			// localVisibleCommands.add(UMLElementTypes.COMMUNICATION_PATH);
			localVisibleCommands.add(UMLElementTypes.COMPONENT);
			// localVisibleCommands.add(UMLElementTypes.COMPONENT_REALIZATION);
			localVisibleCommands.add(UMLElementTypes.CONDITIONAL_NODE);
			localVisibleCommands.add(UMLElementTypes.CONNECTABLE_ELEMENT_TEMPLATE_PARAMETER);
			// localVisibleCommands.add(UMLElementTypes.CONNECTION_POINT_REFERENCE);
			// localVisibleCommands.add(UMLElementTypes.CONNECTOR);
			// localVisibleCommands.add(UMLElementTypes.CONNECTOR_END);
			localVisibleCommands.add(UMLElementTypes.CONSIDER_IGNORE_FRAGMENT);
			localVisibleCommands.add(UMLElementTypes.CONSTRAINT);
			localVisibleCommands.add(UMLElementTypes.CONTINUATION);
			localVisibleCommands.add(UMLElementTypes.CONTROL_FLOW);
			localVisibleCommands.add(UMLElementTypes.CREATE_LINK_ACTION);
			localVisibleCommands.add(UMLElementTypes.CREATE_LINK_OBJECT_ACTION);
			localVisibleCommands.add(UMLElementTypes.CREATE_OBJECT_ACTION);
			localVisibleCommands.add(UMLElementTypes.DATA_STORE_NODE);
			localVisibleCommands.add(UMLElementTypes.DATA_TYPE);
			localVisibleCommands.add(UMLElementTypes.DECISION_NODE);
			// localVisibleCommands.add(UMLElementTypes.DEPENDENCY);
			// localVisibleCommands.add(UMLElementTypes.DEPLOYMENT);
			localVisibleCommands.add(UMLElementTypes.DEPLOYMENT_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.DESTROY_LINK_ACTION);
			localVisibleCommands.add(UMLElementTypes.DESTROY_OBJECT_ACTION);
			// localVisibleCommands.add(UMLElementTypes.DESTRUCTION_OCCURRENCE_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.DEVICE);
			localVisibleCommands.add(UMLElementTypes.DURATION);
			localVisibleCommands.add(UMLElementTypes.DURATION_CONSTRAINT);
			localVisibleCommands.add(UMLElementTypes.DURATION_INTERVAL);
			localVisibleCommands.add(UMLElementTypes.DURATION_OBSERVATION);
			localVisibleCommands.add(UMLElementTypes.ELEMENT_IMPORT);
			localVisibleCommands.add(UMLElementTypes.ENUMERATION);
			localVisibleCommands.add(UMLElementTypes.ENUMERATION_LITERAL);
			localVisibleCommands.add(UMLElementTypes.EXCEPTION_HANDLER);
			localVisibleCommands.add(UMLElementTypes.EXECUTION_ENVIRONMENT);
			localVisibleCommands.add(UMLElementTypes.EXECUTION_OCCURRENCE_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.EXPANSION_NODE);
			localVisibleCommands.add(UMLElementTypes.EXPANSION_REGION);
			localVisibleCommands.add(UMLElementTypes.EXPRESSION);
			// localVisibleCommands.add(UMLElementTypes.EXTEND);
			// localVisibleCommands.add(UMLElementTypes.EXTENSION);
			// localVisibleCommands.add(UMLElementTypes.EXTENSION_END);
			localVisibleCommands.add(UMLElementTypes.EXTENSION_POINT);
			localVisibleCommands.add(UMLElementTypes.FINAL_STATE);
			localVisibleCommands.add(UMLElementTypes.FLOW_FINAL_NODE);
			localVisibleCommands.add(UMLElementTypes.FORK_NODE);
			localVisibleCommands.add(UMLElementTypes.FUNCTION_BEHAVIOR);
			localVisibleCommands.add(UMLElementTypes.GATE);
			localVisibleCommands.add(UMLElementTypes.GENERAL_ORDERING);
			// localVisibleCommands.add(UMLElementTypes.GENERALIZATION);
			// localVisibleCommands.add(UMLElementTypes.GENERALIZATION_SET);
			localVisibleCommands.add(UMLElementTypes.IMAGE);
			// localVisibleCommands.add(UMLElementTypes.INCLUDE);
			// localVisibleCommands.add(UMLElementTypes.INFORMATION_FLOW);
			localVisibleCommands.add(UMLElementTypes.INFORMATION_ITEM);
			localVisibleCommands.add(UMLElementTypes.INITIAL_NODE);
			localVisibleCommands.add(UMLElementTypes.INPUT_PIN);
			localVisibleCommands.add(UMLElementTypes.INSTANCE_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.INSTANCE_VALUE);
			localVisibleCommands.add(UMLElementTypes.INTERACTION);
			localVisibleCommands.add(UMLElementTypes.INTERACTION_CONSTRAINT);
			localVisibleCommands.add(UMLElementTypes.INTERACTION_OPERAND);
			localVisibleCommands.add(UMLElementTypes.INTERACTION_USE);
			localVisibleCommands.add(UMLElementTypes.INTERFACE);
			// localVisibleCommands.add(UMLElementTypes.INTERFACE_REALIZATION);
			localVisibleCommands.add(UMLElementTypes.INTERRUPTIBLE_ACTIVITY_REGION);
			localVisibleCommands.add(UMLElementTypes.INTERVAL);
			localVisibleCommands.add(UMLElementTypes.INTERVAL_CONSTRAINT);
			localVisibleCommands.add(UMLElementTypes.JOIN_NODE);
			localVisibleCommands.add(UMLElementTypes.LIFELINE);
			localVisibleCommands.add(UMLElementTypes.LINK_END_CREATION_DATA);
			localVisibleCommands.add(UMLElementTypes.LINK_END_DATA);
			localVisibleCommands.add(UMLElementTypes.LINK_END_DESTRUCTION_DATA);
			localVisibleCommands.add(UMLElementTypes.LITERAL_BOOLEAN);
			localVisibleCommands.add(UMLElementTypes.LITERAL_INTEGER);
			localVisibleCommands.add(UMLElementTypes.LITERAL_NULL);
			localVisibleCommands.add(UMLElementTypes.LITERAL_REAL);
			localVisibleCommands.add(UMLElementTypes.LITERAL_STRING);
			localVisibleCommands.add(UMLElementTypes.LITERAL_UNLIMITED_NATURAL);
			localVisibleCommands.add(UMLElementTypes.LOOP_NODE);
			// localVisibleCommands.add(UMLElementTypes.MANIFESTATION);
			localVisibleCommands.add(UMLElementTypes.MERGE_NODE);
			// localVisibleCommands.add(UMLElementTypes.MESSAGE);
			// localVisibleCommands.add(UMLElementTypes.MESSAGE_OCCURRENCE_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.MODEL);
			localVisibleCommands.add(UMLElementTypes.NODE);
			localVisibleCommands.add(UMLElementTypes.OBJECT_FLOW);
			localVisibleCommands.add(UMLElementTypes.OCCURRENCE_SPECIFICATION);
			localVisibleCommands.add(UMLElementTypes.OPAQUE_ACTION);
			localVisibleCommands.add(UMLElementTypes.OPAQUE_BEHAVIOR);
			localVisibleCommands.add(UMLElementTypes.OPAQUE_EXPRESSION);
			localVisibleCommands.add(UMLElementTypes.OPERATION);
			localVisibleCommands.add(UMLElementTypes.OPERATION_TEMPLATE_PARAMETER);
			localVisibleCommands.add(UMLElementTypes.OUTPUT_PIN);
			localVisibleCommands.add(UMLElementTypes.PACKAGE);
			localVisibleCommands.add(UMLElementTypes.PACKAGE_IMPORT);
			// localVisibleCommands.add(UMLElementTypes.PACKAGE_MERGE);
			localVisibleCommands.add(UMLElementTypes.PARAMETER);
			localVisibleCommands.add(UMLElementTypes.PARAMETER_SET);
			localVisibleCommands.add(UMLElementTypes.PART_DECOMPOSITION);
			localVisibleCommands.add(UMLElementTypes.PIN);
			localVisibleCommands.add(UMLElementTypes.PORT);
			localVisibleCommands.add(UMLElementTypes.PRIMITIVE_TYPE);
			localVisibleCommands.add(UMLElementTypes.PROFILE);
			// localVisibleCommands.add(UMLElementTypes.PROFILE_APPLICATION);
			localVisibleCommands.add(UMLElementTypes.PROPERTY);
			// localVisibleCommands.add(UMLElementTypes.PROTOCOL_CONFORMANCE);
			localVisibleCommands.add(UMLElementTypes.PROTOCOL_STATE_MACHINE);
			localVisibleCommands.add(UMLElementTypes.PROTOCOL_TRANSITION);
			// localVisibleCommands.add(UMLElementTypes.PSEUDOSTATE);
			localVisibleCommands.add(UMLElementTypes.QUALIFIER_VALUE);
			localVisibleCommands.add(UMLElementTypes.RAISE_EXCEPTION_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_EXTENT_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_IS_CLASSIFIED_OBJECT_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_LINK_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_LINK_OBJECT_END_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_LINK_OBJECT_END_QUALIFIER_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_SELF_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_STRUCTURAL_FEATURE_ACTION);
			localVisibleCommands.add(UMLElementTypes.READ_VARIABLE_ACTION);
			// localVisibleCommands.add(UMLElementTypes.REALIZATION);
			localVisibleCommands.add(UMLElementTypes.RECEPTION);
			localVisibleCommands.add(UMLElementTypes.RECLASSIFY_OBJECT_ACTION);
			localVisibleCommands.add(UMLElementTypes.REDEFINABLE_TEMPLATE_SIGNATURE);
			localVisibleCommands.add(UMLElementTypes.REDUCE_ACTION);
			localVisibleCommands.add(UMLElementTypes.REGION);
			localVisibleCommands.add(UMLElementTypes.REMOVE_STRUCTURAL_FEATURE_VALUE_ACTION);
			localVisibleCommands.add(UMLElementTypes.REMOVE_VARIABLE_VALUE_ACTION);
			localVisibleCommands.add(UMLElementTypes.REPLY_ACTION);
			localVisibleCommands.add(UMLElementTypes.SEND_OBJECT_ACTION);
			localVisibleCommands.add(UMLElementTypes.SEND_SIGNAL_ACTION);
			localVisibleCommands.add(UMLElementTypes.SEQUENCE_NODE);
			localVisibleCommands.add(UMLElementTypes.SIGNAL);
			localVisibleCommands.add(UMLElementTypes.SIGNAL_EVENT);
			localVisibleCommands.add(UMLElementTypes.SLOT);
			localVisibleCommands.add(UMLElementTypes.START_CLASSIFIER_BEHAVIOR_ACTION);
			localVisibleCommands.add(UMLElementTypes.START_OBJECT_BEHAVIOR_ACTION);
			localVisibleCommands.add(UMLElementTypes.STATE);
			localVisibleCommands.add(UMLElementTypes.STATE_INVARIANT);
			localVisibleCommands.add(UMLElementTypes.STATE_MACHINE);
			localVisibleCommands.add(UMLElementTypes.STEREOTYPE);
			localVisibleCommands.add(UMLElementTypes.STRING_EXPRESSION);
			localVisibleCommands.add(UMLElementTypes.STRUCTURED_ACTIVITY_NODE);
			// localVisibleCommands.add(UMLElementTypes.SUBSTITUTION);
			localVisibleCommands.add(UMLElementTypes.TEMPLATE_BINDING);
			localVisibleCommands.add(UMLElementTypes.TEMPLATE_PARAMETER);
			localVisibleCommands.add(UMLElementTypes.TEMPLATE_PARAMETER_SUBSTITUTION);
			localVisibleCommands.add(UMLElementTypes.TEMPLATE_SIGNATURE);
			localVisibleCommands.add(UMLElementTypes.TEST_IDENTITY_ACTION);
			localVisibleCommands.add(UMLElementTypes.TIME_CONSTRAINT);
			localVisibleCommands.add(UMLElementTypes.TIME_EVENT);
			localVisibleCommands.add(UMLElementTypes.TIME_EXPRESSION);
			localVisibleCommands.add(UMLElementTypes.TIME_INTERVAL);
			localVisibleCommands.add(UMLElementTypes.TIME_OBSERVATION);
			// localVisibleCommands.add(UMLElementTypes.TRANSITION);
			localVisibleCommands.add(UMLElementTypes.TRIGGER);
			localVisibleCommands.add(UMLElementTypes.UNMARSHALL_ACTION);
			// localVisibleCommands.add(UMLElementTypes.USAGE);
			localVisibleCommands.add(UMLElementTypes.USE_CASE);
			localVisibleCommands.add(UMLElementTypes.VALUE_PIN);
			localVisibleCommands.add(UMLElementTypes.VALUE_SPECIFICATION_ACTION);
			localVisibleCommands.add(UMLElementTypes.VARIABLE);
			// localVisibleCommands.add(UMLElementTypes.ASSOCIATION);
			// localVisibleCommands.add(UMLElementTypes.TRACE);
			// localVisibleCommands.add(UMLElementTypes.REFINE);
			this.visibleCommands = Collections.unmodifiableList(localVisibleCommands);
		}

		return visibleCommands;
	}
}
