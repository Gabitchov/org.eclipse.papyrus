/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.sysml.util;

import org.eclipse.papyrus.sysml.SysmlPackage;


public class SysmlResource {

	public static final String LIBRARIES_PATHMAP = "pathmap://SysML_LIBRARIES/"; //$NON-NLS-1$

	public static final String SYSML_PRIMITIVE_TYPES_LIBRARY_URI = LIBRARIES_PATHMAP + "SysMLPrimitiveTypes.uml"; //$NON-NLS-1$

	public static final String PROFILES_PATHMAP = "pathmap://SysML_PROFILES/"; //$NON-NLS-1$

	public static final String SYSML_PROFILE_NS_URI = SysmlPackage.eNS_URI; //$NON-NLS-1$

	public static final String SYSML_PROFILE_URI = PROFILES_PATHMAP + "SysML.profile.uml"; //$NON-NLS-1$

	// Stereotypes ids
	public static String CONFORM_ID = "SysML::ModelElements::Conform";

	public static String VIEW_ID = "SysML::ModelElements::View";

	public static String VIEWPOINT_ID = "SysML::ModelElements::ViewPoint";

	public static String RATIONALE_ID = "SysML::ModelElements::Rationale";

	public static String PROBLEM_ID = "SysML::ModelElements::Problem";

	public static String BLOCK_ID = "SysML::Blocks::Block";

	public static String DISTRIBUTED_PROPERTY_ID = "SysML::Blocks::DistributedProperty";

	public static String DIMENSION_ID = "SysML::Blocks::Dimension";

	public static String UNIT_ID = "SysML::Blocks::Unit";

	public static String VALUE_TYPE_ID = "SysML::Blocks::ValueType";

	public static String NESTED_CONNECTOREND_ID = "SysML::Blocks::NestedConnectorEnd";

	public static String PARTICIPANT_PROPERTY_ID = "SysML::Blocks::ParticipantProperty";

	public static String CONNECTOR_PROPERTY_ID = "SysML::Blocks::ConnectorProperty";

	public static String BINDING_CONNECTOR_ID = "SysML::Blocks::BindingConnector";

	public static String PROPERTY_SPECIFIC_TYPE_ID = "SysML::Blocks::PropertySpecificType";

	public static String FLOW_PORT_ID = "SysML::PortAndFlows::FlowPort";

	public static String FLOW_PROPERTY_ID = "SysML::PortAndFlows::FlowProperty";

	public static String FLOW_SPECIFICATION_ID = "SysML::PortAndFlows::FlowSpecification";

	public static String ITEM_FLOW_ID = "SysML::PortAndFlows::ItemFlow";

	public static String CONSTRAINT_BLOCK_ID = "SysML::Constraints::ConstraintBlock";

	public static String CONSTRAINT_PROPERTY_ID = "SysML::Constraints::ConstraintProperty";

	public static String OPTIONAL_ID = "SysML::Activities::Optional";

	public static String RATE_ID = "SysML::Activities::Rate";

	public static String PROBABILITY_ID = "SysML::Activities::Probability";

	public static String CONTINUOUS_ID = "SysML::Activities::Continuous";

	public static String DISCRETE_ID = "SysML::Activities::Discrete";

	public static String CONTROL_OPERATOR_ID = "SysML::Activities::ControlOperator";

	public static String NO_BUFFER_ID = "SysML::Activities::NoBuffer";

	public static String OVERWRITE_ID = "SysML::Activities::Overwrite";

	public static String ALLOCATE_ID = "SysML::Allocations::Allocate";

	public static String ALLOCATED_ID = "SysML::Allocations::Allocated";

	public static String ALLOCATE_ACTIVITY_PARTITION_ID = "SysML::Allocations::AllocateActivityPartition";

	public static String DERIVE_REQT_ID = "SysML::Requirements::DeriveReqt";

	public static String VERIFY_ID = "SysML::Requirements::Verify";

	public static String COPY_ID = "SysML::Requirements::Copy";

	public static String SATISFY_ID = "SysML::Requirements::Satisfy";

	public static String TEST_CASE_ID = "SysML::Requirements::TestCase";

	public static String REQUIREMENT_ID = "SysML::Requirements::Requirement";

	public static String REQUIREMENT_RELATED_ID = "SysML::Requirements::RequirementRelated";


	// SubProfiles ids
	public static String SYSML_ID = "SysML";

	public static String MODEL_ELEMENTS_ID = "SysML::ModelElements";

	public static String BLOCKS_ID = "SysML::Blocks";

	public static String PORT_AND_FLOWS_ID = "SysML::PortAndFlows";

	public static String CONSTRAINTS_ID = "SysML::Constraints";

	public static String ACTIVITIES_ID = "SysML::Activities";

	public static String ALLOCATIONS_ID = "SysML::Allocations";

	public static String REQUIREMENTS_ID = "SysML::Requirements";
}
