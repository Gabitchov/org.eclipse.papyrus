/*****************************************************************************
 * Copyright (c) CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.element;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/** Convenient utility class listing IElementType declared in plugin.xml */
public class SysMLElementTypes extends AbstractElementTypeEnumerator {

	/** Constant for SysML nature */
	public static final String SYSML_NATURE = "SysML_Nature";

	/** IElementType for SysML ActorPartProperty */
	public static final IHintedType ACTOR_PART_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ActorPartProperty"); //$NON-NLS-1$

	/** IElementType for SysML Allocate */
	public static final IHintedType ALLOCATE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Allocate"); //$NON-NLS-1$

	/** IElementType for SysML Association (Association with SysML nature) */
	public static final IHintedType ASSOCIATION = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Association"); //$NON-NLS-1$

	/** IElementType for SysML Association with "aggregation = composite" (for creation purpose only) */
	public static final IHintedType ASSOCIATION_COMPOSITE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.AssociationComposite"); //$NON-NLS-1$

	/** IElementType for SysML Association with "aggregation = composite" and navigable in one-way (for creation purpose only) */
	public static final IHintedType ASSOCIATION_COMPOSITE_DIRECTED = (IHintedType)getElementType("org.eclipse.papyrus.sysml.AssociationCompositeDirected"); //$NON-NLS-1$

	/** IElementType for SysML Association with "aggregation = none" (for creation purpose only) */
	public static final IHintedType ASSOCIATION_NONE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.AssociationNone"); //$NON-NLS-1$

	/** IElementType for SysML Association with "aggregation = none" and navigable in one-way (for creation purpose only) */
	public static final IHintedType ASSOCIATION_NONE_DIRECTED = (IHintedType)getElementType("org.eclipse.papyrus.sysml.AssociationNoneDirected"); //$NON-NLS-1$

	/** IElementType for SysML Association with "aggregation = shared" (for creation purpose only) */
	public static final IHintedType ASSOCIATION_SHARED = (IHintedType)getElementType("org.eclipse.papyrus.sysml.AssociationShared"); //$NON-NLS-1$

	/** IElementType for SysML Association with "aggregation = shared" and navigable in one-way (for creation purpose only) */
	public static final IHintedType ASSOCIATION_SHARED_DIRECTED = (IHintedType)getElementType("org.eclipse.papyrus.sysml.AssociationSharedDirected"); //$NON-NLS-1$
	
	/** IElementType for SysML Block */
	public static final IHintedType BLOCK = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Block"); //$NON-NLS-1$
	
	/** IElementType for SysML Conform */
	public static final IHintedType CONFORM = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Conform"); //$NON-NLS-1$
	
	/** IElementType for SysML ConstraintBlock */
	public static final IHintedType CONSTRAINT_BLOCK = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ConstraintBlock"); //$NON-NLS-1$
	
	/** IElementType for SysML ConstraintProperty */
	public static final IHintedType CONSTRAINT_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ConstraintProperty"); //$NON-NLS-1$
	
	/** IElementType for SysML Copy */
	public static final IHintedType COPY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Copy"); //$NON-NLS-1$
	
	/** IElementType for SysML DeriveReqt */
	public static final IHintedType DERIVE_REQT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.DeriveReqt"); //$NON-NLS-1$
	
	/** IElementType for SysML Dimension */
	public static final IHintedType DIMENSION = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Dimension"); //$NON-NLS-1$
	
	/** IElementType for SysML FlowPort */
	public static final IHintedType FLOW_PORT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort"); //$NON-NLS-1$
	
	/** IElementType for SysML FlowPort_InOut */
	public static final IHintedType FLOW_PORT_IN_OUT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort_InOut"); //$NON-NLS-1$
	
	/** IElementType for SysML FlowPort_In */
	public static final IHintedType FLOW_PORT_IN = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort_In"); //$NON-NLS-1$
	
	/** IElementType for SysML FlowPort_Out */
	public static final IHintedType FLOW_PORT_OUT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort_Out"); //$NON-NLS-1$

	/** IElementType for SysML FlowPort_NA */
	public static final IHintedType FLOW_PORT_NA = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowPort_NA"); //$NON-NLS-1$
	
	/** IElementType for SysML FlowProperty */
	public static final IHintedType FLOW_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowProperty"); //$NON-NLS-1$
	
	/** IElementType for SysML FlowSpecification */
	public static final IHintedType FLOW_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowSpecification"); //$NON-NLS-1$
	
	/** IElementType for SysML ItemFlow */
	public static final IHintedType ITEM_FLOW = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ItemFlow"); //$NON-NLS-1$
	
	/** IElementType for SysML Part (Property) */
	public static final IHintedType PART_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.PartProperty"); //$NON-NLS-1$
	
	/** IElementType for SysML Problem */
	public static final IHintedType PROBLEM = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Problem"); //$NON-NLS-1$
	
	/** IElementType for SysML Rationale */
	public static final IHintedType RATIONALE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Rationale"); //$NON-NLS-1$
	
	/** IElementType for SysML Reference (Property) */
	public static final IHintedType REFERENCE_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ReferenceProperty"); //$NON-NLS-1$
	
	/** IElementType for SysML Requirement */
	public static final IHintedType REQUIREMENT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Requirement"); //$NON-NLS-1$
	
	/** IElementType for SysML Satisfy */
	public static final IHintedType SATISFY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Satisfy"); //$NON-NLS-1$
	
	/** IElementType for SysML Unit */
	public static final IHintedType UNIT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Unit"); //$NON-NLS-1$
	
	/** IElementType for SysML Value (Property) */
	public static final IHintedType VALUE_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ValueProperty"); //$NON-NLS-1$
	
	/** IElementType for SysML ValueType */
	public static final IHintedType VALUE_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ValueType"); //$NON-NLS-1$
	
	/** IElementType for SysML ValueType_Enumeration */
	public static final IHintedType VALUE_TYPE_ENUMERATION = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ValueType_Enumeration"); //$NON-NLS-1$
	
	/** IElementType for SysML ValueType_PrimitiveType */
	public static final IHintedType VALUE_TYPE_PRIMITIVE_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ValueType_PrimitiveType"); //$NON-NLS-1$
	
	/** IElementType for SysML Verify */
	public static final IHintedType VERIFY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Verify"); //$NON-NLS-1$
	
	/** IElementType for SysML View */
	public static final IHintedType VIEW = (IHintedType)getElementType("org.eclipse.papyrus.sysml.View"); //$NON-NLS-1$
	
	/** IElementType for SysML ViewPoint */
	public static final IHintedType VIEW_POINT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ViewPoint"); //$NON-NLS-1$
	
}
