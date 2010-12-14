package org.eclipse.papyrus.sysml.service.types.element;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/** Convenient utility class listing IElementType declared in plugin.xml */
public class SysMLElementTypes extends AbstractElementTypeEnumerator {

	/** IElementType for SysML Allocate */
	public static final IHintedType ALLOCATE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Allocate"); //$NON-NLS-1$
	
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
	
	/** IElementType for SysML FlowProperty */
	public static final IHintedType FLOW_PROPERTY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowProperty"); //$NON-NLS-1$
	
	/** IElementType for SysML FlowSpecification */
	public static final IHintedType FLOW_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.sysml.FlowSpecification"); //$NON-NLS-1$
	
	/** IElementType for SysML ItemFlow */
	public static final IHintedType ITEM_FLOW = (IHintedType)getElementType("org.eclipse.papyrus.sysml.ItemFlow"); //$NON-NLS-1$
	
	/** IElementType for SysML Problem */
	public static final IHintedType PROBLEM = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Problem"); //$NON-NLS-1$
	
	/** IElementType for SysML Rationale */
	public static final IHintedType RATIONALE = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Rationale"); //$NON-NLS-1$
	
	/** IElementType for SysML Requirement */
	public static final IHintedType REQUIREMENT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Requirement"); //$NON-NLS-1$
	
	/** IElementType for SysML Unit */
	public static final IHintedType UNIT = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Unit"); //$NON-NLS-1$
	
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
	
	/** IElementType for SysML Satisfy */
	public static final IHintedType SATISFY = (IHintedType)getElementType("org.eclipse.papyrus.sysml.Satisfy"); //$NON-NLS-1$
	
}
