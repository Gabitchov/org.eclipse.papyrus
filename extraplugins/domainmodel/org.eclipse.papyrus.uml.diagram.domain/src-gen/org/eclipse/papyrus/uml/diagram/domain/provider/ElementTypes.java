/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.domain.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class ElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** UML Domain Diagram specific elements **************** */
	/** ********************************************************* */

	/** UML Domain Diagram :: Diagram */
	public static final String DIAGRAM_ID = "domain"; //$NON-NLS-1$




	/** ********************************************************* */
	/** UML Domain Diagram - ClassDiagram related elements */
	/** ********************************************************* */


	/** ClassDiagram :: PACKAGE */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final String PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7016"; //$NON-NLS-1$

	public static final String PACKAGE_LABEL_NAME_HINT = "5026"; //$NON-NLS-1$

	/** ClassDiagram :: PACKAGE_CN */
	public static final IHintedType PACKAGE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_3009"); //$NON-NLS-1$

	public static final String PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7010"; //$NON-NLS-1$

	public static final String PACKAGE_CN_LABEL_NAME_HINT = "5017"; //$NON-NLS-1$

	/** ClassDiagram :: COMMENT */
	public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Comment_2012"); //$NON-NLS-1$

	public static final String COMMENT_LABEL_BODY_HINT = "5038"; //$NON-NLS-1$

	/** ClassDiagram :: COMMENT_CN */
	public static final IHintedType COMMENT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Comment_3028"); //$NON-NLS-1$

	public static final String COMMENT_CN_LABEL_BODY_HINT = "5063"; //$NON-NLS-1$

	/** ClassDiagram :: CONSTRAINT */
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Constraint_2011"); //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_NAME_HINT = "5037"; //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_BODY_HINT = "5159"; //$NON-NLS-1$

	/** ClassDiagram :: CONSTRAINT_CN */
	public static final IHintedType CONSTRAINT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Constraint_3029"); //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_NAME_HINT = "5064"; //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_BODY_HINT = "5160"; //$NON-NLS-1$

	/** ClassDiagram :: INSTANCE_SPECIFICATION */
	public static final IHintedType INSTANCE_SPECIFICATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.InstanceSpecification_2001"); //$NON-NLS-1$

	public static final String INSTANCE_SPECIFICATION_COMPARTMENT_SLOT_HINT = "7001"; //$NON-NLS-1$

	public static final String INSTANCE_SPECIFICATION_LABEL_NAME_HINT = "5002"; //$NON-NLS-1$

	/** ClassDiagram :: INSTANCE_SPECIFICATION_CN */
	public static final IHintedType INSTANCE_SPECIFICATION_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.InstanceSpecification_3020"); //$NON-NLS-1$

	public static final String INSTANCE_SPECIFICATION_CN_COMPARTMENT_SLOT_HINT = "7035"; //$NON-NLS-1$

	public static final String INSTANCE_SPECIFICATION_CN_LABEL_NAME_HINT = "5040"; //$NON-NLS-1$

	/** ClassDiagram :: CLASS */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Class_2008"); //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_ATTRIBUTE_HINT = "7017"; //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_OPERATION_HINT = "7018"; //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7019"; //$NON-NLS-1$

	public static final String CLASS_LABEL_NAME_HINT = "5029"; //$NON-NLS-1$

	/** ClassDiagram :: CLASS_CN */
	public static final IHintedType CLASS_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Class_3010"); //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_ATTRIBUTE_HINT = "7011"; //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_OPERATION_HINT = "7012"; //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7013"; //$NON-NLS-1$

	public static final String CLASS_CN_LABEL_NAME_HINT = "5014"; //$NON-NLS-1$

	/** ClassDiagram :: DATA_TYPE */
	public static final IHintedType DATA_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.DataType_2010"); //$NON-NLS-1$

	public static final String DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT = "7020"; //$NON-NLS-1$

	public static final String DATA_TYPE_COMPARTMENT_OPERATION_HINT = "7021"; //$NON-NLS-1$

	public static final String DATA_TYPE_LABEL_NAME_HINT = "5035"; //$NON-NLS-1$

	/** ClassDiagram :: DATA_TYPE_CN */
	public static final IHintedType DATA_TYPE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.DataType_3027"); //$NON-NLS-1$

	public static final String DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT = "7032"; //$NON-NLS-1$

	public static final String DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT = "7033"; //$NON-NLS-1$

	public static final String DATA_TYPE_CN_LABEL_NAME_HINT = "5061"; //$NON-NLS-1$

	/** ClassDiagram :: ENUMERATION */
	public static final IHintedType ENUMERATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Enumeration_2006"); //$NON-NLS-1$

	public static final String ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT = "7015"; //$NON-NLS-1$

	public static final String ENUMERATION_LABEL_NAME_HINT = "5023"; //$NON-NLS-1$

	/** ClassDiagram :: ENUMERATION_CN */
	public static final IHintedType ENUMERATION_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Enumeration_3025"); //$NON-NLS-1$

	public static final String ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT = "7031"; //$NON-NLS-1$

	public static final String ENUMERATION_CN_LABEL_NAME_HINT = "5055"; //$NON-NLS-1$

	/** ClassDiagram :: PRIMITIVE_TYPE_CN */
	public static final IHintedType PRIMITIVE_TYPE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PrimitiveType_3026"); //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT = "7041"; //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_CN_COMPARTMENT_OPERATION_HINT = "7042"; //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_CN_LABEL_NAME_HINT = "5058"; //$NON-NLS-1$

	/** ClassDiagram :: PRIMITIVE_TYPE */
	public static final IHintedType PRIMITIVE_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PrimitiveType_2009"); //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_COMPARTMENT_ATTRIBUTE_HINT = "7039"; //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_COMPARTMENT_OPERATION_HINT = "7040"; //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_LABEL_NAME_HINT = "5032"; //$NON-NLS-1$


	/** ClassDiagram :: COMMENT_ANNOTATED_ELEMENT */
	public static final IHintedType COMMENT_ANNOTATED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.CommentAnnotatedElement_4013"); //$NON-NLS-1$

	/** ClassDiagram :: CONSTRAINT_CONSTRAINED_ELEMENT */
	public static final IHintedType CONSTRAINT_CONSTRAINED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.ConstraintConstrainedElement_4014"); //$NON-NLS-1$

	/** ClassDiagram :: GENERALIZATION */
	public static final IHintedType GENERALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Generalization_4002"); //$NON-NLS-1$

	public static final String GENERALIZATION_LABEL_APPLIED_STEREOTYPER_HINT = "6007"; //$NON-NLS-1$

	/** ClassDiagram :: INSTANCE_SPECIFICATION */
	public static final IHintedType INSTANCE_SPECIFICATION_LINK = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.InstanceSpecificationLink_4021"); //$NON-NLS-1$

	public static final String INSTANCE_SPECIFICATION_LABEL_SOURCE_IS_LINK_LABEL_HINT = "6039"; //$NON-NLS-1$

	public static final String INSTANCE_SPECIFICATION_LABEL_TARGET_IS_LINK_LABEL_HINT = "6038"; //$NON-NLS-1$

	/** ClassDiagram :: ASSOCIATION */
	public static final IHintedType ASSOCIATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Association_4001"); //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_APPLIED_STEREOTYPE_HINT = "6001"; //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_NAME_HINT = "6002"; //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_TARGET_NAME_HINT = "6003"; //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_SOURCE_NAME_HINT = "6005"; //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_MULTIPLICITY_SOURCE_HINT = "6033"; //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_MULTIPLICITY_TARGET_HINT = "6034"; //$NON-NLS-1$

	/** ClassDiagram :: ChildLabelNodes */
	public static final IHintedType INSTANCE_SPECIFICATION_SLOT_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Slot_3030"); //$NON-NLS-1$

	public static final IHintedType CLASS_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Property_3012"); //$NON-NLS-1$

	public static final IHintedType CLASS_RECEPTION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Reception_3011"); //$NON-NLS-1$

	public static final IHintedType CLASS_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Operation_3013"); //$NON-NLS-1$

	public static final IHintedType CLASS_CLASS_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Class_3014"); //$NON-NLS-1$

	public static final IHintedType CLASS_INTERFACE_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Interface_3036"); //$NON-NLS-1$

	public static final IHintedType CLASS_ENUMERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Enumeration_3052"); //$NON-NLS-1$

	public static final IHintedType CLASS_PRIMITIVE_TYPE_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PrimitiveType_3047"); //$NON-NLS-1$

	public static final IHintedType CLASS_DATA_TYPE_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.DataType_3044"); //$NON-NLS-1$

	public static final IHintedType CLASS_SIGNAL_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Signal_3050"); //$NON-NLS-1$

	public static final IHintedType DATA_TYPE_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Property_3018"); //$NON-NLS-1$

	public static final IHintedType DATA_TYPE_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Operation_3019"); //$NON-NLS-1$

	public static final IHintedType ENUMERATION_ENUMERATION_LITERAL_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.EnumerationLiteral_3017"); //$NON-NLS-1$

	public static final IHintedType PRIMITIVE_TYPE_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Property_3041"); //$NON-NLS-1$

	public static final IHintedType PRIMITIVE_TYPE_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Operation_3042"); //$NON-NLS-1$

}
