/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class InheritedElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** Block Definition Diagram - Class Diagram related elements */
	/**
	 * Top level nodes:
	 * 
	 * AssociationClass_2013
	 * Class_2008
	 * Comment_2012
	 * Constraint_2011
	 * DataType_2010
	 * Enumeration_2006
	 * Interface_2004
	 * InstanceSpecification_2001
	 * Model_2005
	 * Package_2007
	 * PrimitiveType_2009
	 * 
	 */


	/** ClassDiagram :: ASSOCIATION_CLASS */
	public static final IHintedType ASSOCIATION_CLASS = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.AssociationClass_2013"); //$NON-NLS-1$

	public static final String ASSOCIATION_CLASS_COMPARTMENT_ATTRIBUTE_HINT = "7034";

	public static final String ASSOCIATION_CLASS_COMPARTMENT_OPERATIONATION_HINT = "7036";

	public static final String ASSOCIATION_CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7037";

	public static final String ASSOCIATION_CLASS_LABEL_NAME2_HINT = "5066";

	/** ClassDiagram :: COMMENT */
	public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Comment_2012"); //$NON-NLS-1$

	public static final String COMMENT_LABEL_BODY_HINT = "5038";

	/** ClassDiagram :: CONSTRAINT */
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Constraint_2011"); //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_NAME_HINT = "5037";

	public static final String CONSTRAINT_LABEL_BODY_HINT = "5159";

	/** ClassDiagram :: ENUMERATION_CN */
	public static final IHintedType ENUMERATION_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Enumeration_3025"); //$NON-NLS-1$

	public static final String ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT = "7031";

	public static final String ENUMERATION_CN_LABEL_NAME_HINT = "5055";

	/** ClassDiagram :: DATA_TYPE */
	public static final IHintedType DATA_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.DataType_2010"); //$NON-NLS-1$

	public static final String DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT = "7020";

	public static final String DATA_TYPE_COMPARTMENT_OPERATIONATION_HINT = "7021";

	public static final String DATA_TYPE_LABEL_NAME_HINT = "5035";

	/** ClassDiagram :: INTERFACE */
	public static final IHintedType INTERFACE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Interface_2004"); //$NON-NLS-1$

	public static final String INTERFACE_COMPARTMENT_ATTRIBUTE_HINT = "7006";

	public static final String INTERFACE_COMPARTMENT_OPERATIONATION_HINT = "7007";

	public static final String INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7008";

	public static final String INTERFACE_LABEL_NAME_HINT = "5011";

	/** ClassDiagram :: INSTANCE_SPECIFICATION */
	public static final IHintedType INSTANCE_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.InstanceSpecification_2001"); //$NON-NLS-1$

	public static final String INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT = "7001";

	public static final String INSTANCE_SPECIFICATION_LABEL_NAME_HINT = "5002";

	/** ClassDiagram :: MODEL */
	public static final IHintedType MODEL = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Model_2005"); //$NON-NLS-1$

	public static final String MODEL_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7009";

	public static final String MODEL_LABEL_NAME_TN_HINT = "5020";

	/** ClassDiagram :: PACKAGE */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final String PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7016";

	public static final String PACKAGE_LABEL_NAME_HINT = "5026";

	/** ClassDiagram :: PRIMITIVE_TYPE */
	public static final IHintedType PRIMITIVE_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.PrimitiveType_2009"); //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_LABEL_NAME_HINT = "5032";

	/** ClassDiagram :: CLASS */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_2008"); //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_ATTRIBUTE_HINT = "7017";

	public static final String CLASS_COMPARTMENT_OPERATION_HINT = "7018";

	public static final String CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7019";

	public static final String CLASS_LABEL_NAME_HINT = "5029";


	/** ClassDiagram :: DEPENDENCY */
	public static final IHintedType DEPENDENCY = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_4008"); //$NON-NLS-1$

	public static final String DEPENDENCY_LABEL_NAME_HINT = "6026";

	public static final String DEPENDENCY_LABEL_APPLIED_STEREOTYPE_HINT = "6027";

	/** ClassDiagram :: ChildLabelNodes */
	public static final IHintedType ASSOCIATION_CLASS_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Property_3002"); //$NON-NLS-1$

	public static final IHintedType COMPONENT_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3003"); //$NON-NLS-1$

	public static final IHintedType COMPONENT_CLASS_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3004"); //$NON-NLS-1$

	public static final IHintedType ENUMERATION_ENUMERATION_LITERAL_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.EnumerationLiteral_3017"); //$NON-NLS-1$

	public static final IHintedType DATA_TYPE_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Property_3018"); //$NON-NLS-1$

	public static final IHintedType DATA_TYPE_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3019"); //$NON-NLS-1$

	public static final IHintedType INTERFACE_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Property_3006"); //$NON-NLS-1$

	public static final IHintedType INTERFACE_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3007"); //$NON-NLS-1$

	public static final IHintedType INTERFACE_CLASS_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3008"); //$NON-NLS-1$

	public static final IHintedType INSTANCE_SPECIFICATION_SLOT_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Slot_3030"); //$NON-NLS-1$

	public static final IHintedType CLASS_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Property_3012"); //$NON-NLS-1$

	public static final IHintedType CLASS_RECEPTION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Reception_3011"); //$NON-NLS-1$

	public static final IHintedType CLASS_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3013"); //$NON-NLS-1$

	public static final IHintedType CLASS_CLASS_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3014"); //$NON-NLS-1$


	/**
	 * "2007, 3009" = Package
	 * "2005, 3024" = Model
	 * "2008, 3010" = Class
	 * "2004, 3023" = Interface
	 * "2009, 3026" = PrimitiveType
	 * "2010, 3027" = DataType
	 * "2006, 3025" = Enumeration
	 * "2001, 3020" = InstanceSpecification
	 * "2013" = AssociationClass
	 * "2012, 3028" = Comment
	 * "2011, 3029" = Constraint
	 * "3032" = ContainmentCircle
	 * "3018, 3012, 3006, 3002" = Property CLN
	 * "3019, 3013, 3007, 3003" = Operation CLN
	 * "3011" = Reception CLN
	 * "3014, 3008, 3004" = Class CLN
	 * "3017" = EnumerationLiteral CLN
	 * "3030" = Slot CLN
	 * 
	 * 
	 */

	/** ClassDiagram :: PACKAGE_CN */
	public static final IHintedType PACKAGE_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_3009"); //$NON-NLS-1$

	public static final String PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7010";

	public static final String PACKAGE_CN_LABEL_NAME_HINT = "5017";


	/** ClassDiagram :: MODEL_CN */
	public static final IHintedType MODEL_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Model_3024"); //$NON-NLS-1$

	public static final String MODEL_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7030";

	public static final String MODEL_CN_LABEL_NAME_HINT = "5052";

	/** ClassDiagram :: CLASS_CN */
	public static final IHintedType CLASS_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3010"); //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_ATTRIBUTE_HINT = "7011";

	public static final String CLASS_CN_COMPARTMENT_OPERATIONATION_HINT = "7012";

	public static final String CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7013";

	public static final String CLASS_CN_LABEL_NAME_HINT = "5014";

	/** ClassDiagram :: INTERFACE_CN */
	public static final IHintedType INTERFACE_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Interface_3023"); //$NON-NLS-1$

	public static final String INTERFACE_CN_COMPARTMENT_ATTRIBUTE_HINT = "7027";

	public static final String INTERFACE_CN_COMPARTMENT_OPERATION_HINT = "7028";

	public static final String INTERFACE_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7029";
	
	public static final String INTERFACE_CN_LABEL_NAME_HINT = "5049";
	
	
	
	
	/** Class Diagram :: DataType ChildNode */
	public static final IHintedType DATATYPE_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.DataType_3027"); //$NON-NLS-1$

	public static final String DATATYPE_CN_LABEL_NAME_HINT = "5061";

	public static final String DATATYPE_CN_COMPARTMENT_ATTRIBUTE_HINT = "7032";

	public static final String DATATYPE_CN_COMPARTMENT_OPERATION_HINT = "7033";


	public static final IHintedType DATATYPE_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Property_3018"); //$NON-NLS-1$

	public static final IHintedType DATATYPE_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3019"); //$NON-NLS-1$


	/** Class Diagram :: Enumeration TopLevelNode */
	public static final IHintedType ENUMERATION = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Enumeration_2006"); //$NON-NLS-1$

	public static final String ENUMERATION_LABEL_NAME_HINT = "5023";

	public static final String ENUMERATION_COMPARTMENT_LITERAL_HINT = "7015";





	/** Class Diagram :: PrimitiveType ChildNode */
	public static final IHintedType PRIMITIVETYPE_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.PrimitiveType_3026"); //$NON-NLS-1$

	public static final String PRIMITIVETYPE_CN_LABEL_NAME_HINT = "5058";


	/** Class Diagram :: InstanceSpecification ChildNode */
	public static final IHintedType INSTANCE_SPEC_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.InstanceSpecification_3020"); //$NON-NLS-1$

	public static final String INSTANCE_SPEC_CN_LABEL_NAME_HINT = "5040";

	public static final String INSTANCE_SPEC_CN_COMPARTMENT_SLOT_HINT = "7035";

	/** Class Diagram :: Comment ChildNode */
	public static final IHintedType COMMENT_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Comment_3028"); //$NON-NLS-1$

	public static final String COMMENT_CN_BODY_LABEL_HINT = "5063";


	/** Class Diagram :: Constraint ChildNode */
	public static final IHintedType CONSTRAINT_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Constraint_3029"); //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_NAME_HINT = "5064";

	public static final String CONSTRAINT_CN_SPEC_LABEL_HINT = "5160";




	/** Class Diagram :: Usage */
	public static final IHintedType USAGE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Usage_4007"); //$NON-NLS-1$

	public static final String USAGE_LABEL_NAME_HINT = "6016";

	public static final String USAGE_STEREOTYPE_LABEL_HINT = "6017";

	/** Class Diagram :: InterfaceRealization */
	public static final IHintedType INTERFACE_REALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.InterfaceRealization_4003"); //$NON-NLS-1$

	public static final String INTERFACE_REALIZATION_LABEL_NAME_HINT = "6009";

	public static final String INTERFACE_REALIZATION_STEREOTYPE_LABEL_HINT = "6008";

	/** Class Diagram :: Generalization */
	public static final IHintedType GENERALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Generalization_4002"); //$NON-NLS-1$

	public static final String GENERALIZATION_STEREOTYPE_LABEL_HINT = "6007";

	/** Class Diagram :: GeneralizationSet */
	public static final IHintedType GENERALIZATION_SET = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.GeneralizationSet_4020"); //$NON-NLS-1$

	public static final String GENERALIZATION_SET_LABEL_HINT = "5067";

	/** Class Diagram :: Association */
	public static final IHintedType ASSOCIATION = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Association_4001"); //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_NAME_HINT = "6002";

	public static final String ASSOCIATION_STEREOTYPE_LABEL_HINT = "6001";

	public static final String ASSOCIATION_ROLE_SOURCE_LABEL_HINT = "6003";

	public static final String ASSOCIATION_ROLE_TARGET_LABEL_HINT = "6005";

	public static final String ASSOCIATION_MULT_SOURCE_LABEL_HINT = "6033";

	public static final String ASSOCIATION_MULT_TARGET_LABEL_HINT = "6034";

	/** Class Diagram :: AssociationClass */
	public static final IHintedType ASSOCIATION_CLASS_EDGE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.AssociationClass_4017"); //$NON-NLS-1$

	public static final String ASSOCIATION_CLASS_EDGE_ROLE_SOURCE_LABEL_HINT = "6031";

	public static final String ASSOCIATION_CLASS_EDGE_ROLE_TARGET_LABEL_HINT = "6032";

	public static final IHintedType ASSOCIATION_CLASS_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Link_4016"); //$NON-NLS-1$

	/** Class Diagram :: CommentLink */
	/** The semantic hint 4013 is used by Connector and CommentLink */
	public static final IHintedType COMMENT_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.CommentAnnotatedElement_4013"); //$NON-NLS-1$

	/** Class Diagram :: ConstraintLink */
	public static final IHintedType CONSTRAINT_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.ConstraintConstrainedElement_4014"); //$NON-NLS-1$

	/** Class Diagram :: ConstraintLink */
	public static final IHintedType CONTAINMENT_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.ContainmentLink_4023"); //$NON-NLS-1$

	public static final IHintedType CONTAINMENT_ADDED_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.AddedLink_4022"); //$NON-NLS-1$

	public static final IHintedType CONTAINMENT_CIRCLE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.ContainmentCircle_3032"); //$NON-NLS-1$

	/** *********************************************************************** */
	/** Block Definition Diagram - Composite Structure Diagram related elements */
	/** *********************************************************************** */

	/** Composite Structure Diagram :: Port */
	public static final IHintedType PORT_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.composite.Port_3069"); //$NON-NLS-1$

	public static final String PORT_CN_LABEL_NAME_HINT = "5125";

	public static final String PORT_CN_STEREOTYPE_LABEL_HINT = "6029";





}
