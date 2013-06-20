/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.diagram.datatypedef.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class DatatypeDefElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** Datatype Definition Diagram specific elements **************** */
	/** ********************************************************* */

	/** Datatype Definition Diagram :: Diagram */
	public static final IHintedType DATATYPE_DEF_DIAGRAM = (IHintedType)getElementType("DatatypeDef"); //$NON-NLS-1$




	/** ********************************************************* */
	/** Datatype Definition Diagram - ClassDiagram related elements */
	/** ********************************************************* */


	/** ClassDiagram :: PACKAGE */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final String PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7016";

	public static final String PACKAGE_LABEL_NAME_HINT = "5026";

	/** ClassDiagram :: ENUMERATION */
	public static final IHintedType ENUMERATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Enumeration_2006"); //$NON-NLS-1$

	public static final String ENUMERATION_COMPARTMENT_ENUMERATION_LITERAL_HINT = "7015";

	public static final String ENUMERATION_LABEL_NAME_HINT = "5023";

	/** ClassDiagram :: COMMENT */
	public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Comment_2012"); //$NON-NLS-1$

	public static final String COMMENT_LABEL_BODY_HINT = "5038";

	/** ClassDiagram :: CONSTRAINT */
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Constraint_2011"); //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_NAME_HINT = "5037";

	public static final String CONSTRAINT_LABEL_BODY_HINT = "5159";

	/** ClassDiagram :: DATA_TYPE */
	public static final IHintedType DATA_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.DataType_2010"); //$NON-NLS-1$

	public static final String DATA_TYPE_COMPARTMENT_ATTRIBUTE_HINT = "7020";

	public static final String DATA_TYPE_COMPARTMENT_OPERATION_HINT = "7021";

	public static final String DATA_TYPE_LABEL_NAME_HINT = "5035";

	/** ClassDiagram :: PRIMITIVE_TYPE */
	public static final IHintedType PRIMITIVE_TYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PrimitiveType_2009"); //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_LABEL_NAME_HINT = "5032";

	/** ClassDiagram :: SIGNAL */
	public static final IHintedType SIGNAL = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Signal_2003"); //$NON-NLS-1$

	public static final String SIGNAL_COMPARTMENT_ATTRIBUTE_HINT = "7005";

	public static final String SIGNAL_LABEL_NAME_HINT = "5008";

	/** ClassDiagram :: PACKAGE_CN */
	public static final IHintedType PACKAGE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_3009"); //$NON-NLS-1$

	public static final String PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7010";

	public static final String PACKAGE_CN_LABEL_NAME_HINT = "5017";

	/** ClassDiagram :: DATA_TYPE_CN */
	public static final IHintedType DATA_TYPE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.DataType_3027"); //$NON-NLS-1$

	public static final String DATA_TYPE_CN_COMPARTMENT_ATTRIBUTE_HINT = "7032";

	public static final String DATA_TYPE_CN_COMPARTMENT_OPERATION_HINT = "7033";

	public static final String DATA_TYPE_CN_LABEL_NAME_HINT = "5061";

	/** ClassDiagram :: ENUMERATION_CN */
	public static final IHintedType ENUMERATION_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Enumeration_3025"); //$NON-NLS-1$

	public static final String ENUMERATION_CN_COMPARTMENT_ENUMERATION_LITERAL_HINT = "7031";

	public static final String ENUMERATION_CN_LABEL_NAME_HINT = "5055";

	/** ClassDiagram :: PRIMITIVE_TYPE_CN */
	public static final IHintedType PRIMITIVE_TYPE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PrimitiveType_3026"); //$NON-NLS-1$

	public static final String PRIMITIVE_TYPE_CN_LABEL_NAME_HINT = "5058";



	/** ClassDiagram :: SIGNAL_CN */
	public static final IHintedType SIGNAL_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Signal_3022"); //$NON-NLS-1$

	public static final String SIGNAL_CN_COMPARTMENT_ATTRIBUTE_HINT = "7026";

	public static final String SIGNAL_CN_LABEL_NAME_HINT = "5046";

	/** ClassDiagram :: COMMENT_CN */
	public static final IHintedType COMMENT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Comment_3028"); //$NON-NLS-1$

	public static final String COMMENT_CN_LABEL_BODY2_HINT = "5063";

	/** ClassDiagram :: CONSTRAINT_CN */
	public static final IHintedType CONSTRAINT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Constraint_3029"); //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_NAME2_HINT = "5064";

	public static final String CONSTRAINT_CN_LABEL_BODY_HINT = "5160";

	/** ClassDiagram :: SHORT_CUT_DIAGRAM */
	public static final IHintedType SHORT_CUT_DIAGRAM = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Diagram_2016"); //$NON-NLS-1$

	public static final String SHORT_CUT_DIAGRAM_LABEL_DIAGRAM_NAME_HINT = "0";


	/** ClassDiagram :: DEPENDENCY */
	public static final IHintedType DEPENDENCY = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Dependency_4008"); //$NON-NLS-1$

	public static final String DEPENDENCY_LABEL_NAME_HINT = "6026";

	public static final String DEPENDENCY_LABEL_APPLIED_STEREOTYPE_HINT = "6027";

	/** ClassDiagram :: PACKAGE_IMPORT */
	public static final IHintedType PACKAGE_IMPORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PackageImport_4010"); //$NON-NLS-1$

	public static final String PACKAGE_IMPORT_LABEL_APPLIED_STEREOTYPE_HINT = "6022";

	/** ClassDiagram :: COMMENT_ANNOTATED_ELEMENT */
	public static final IHintedType COMMENT_ANNOTATED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.CommentAnnotatedElement_4013"); //$NON-NLS-1$

	/** ClassDiagram :: CONSTRAINT_CONSTRAINED_ELEMENT */
	public static final IHintedType CONSTRAINT_CONSTRAINED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.ConstraintConstrainedElement_4014"); //$NON-NLS-1$

	/** ClassDiagram :: PACKAGE_MERGE */
	public static final IHintedType PACKAGE_MERGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PackageMerge_4011"); //$NON-NLS-1$

	public static final String PACKAGE_MERGE_LABEL_APPLIED_STEREOTYPE_HINT = "6030";

	/** ClassDiagram :: ELEMENT_IMPORT */
	public static final IHintedType ELEMENT_IMPORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.ElementImport_4009"); //$NON-NLS-1$

	public static final String ELEMENT_IMPORT_LABEL_ALIAS_HINT = "6020";

	public static final String ELEMENT_IMPORT_LABEL_APPLIED_STEREOTYPE_HINT = "6021";

	/** ClassDiagram :: ASSOCIATION */
	public static final IHintedType ASSOCIATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Association_4001"); //$NON-NLS-1$

	public static final String ASSOCIATION_LABEL_APPLIED_STEREOTYPE_HINT = "6001";

	public static final String ASSOCIATION_LABEL_NAME2_HINT = "6002";

	public static final String ASSOCIATION_LABEL_NAME3_HINT = "6003";

	public static final String ASSOCIATION_LABEL_NAME5_HINT = "6005";

	public static final String ASSOCIATION_LABEL_MULTIPLICTY_SOURCE_HINT = "6033";

	public static final String ASSOCIATION_LABEL_MULTIPLICTY_TARGET_HINT = "6034";

	/** ClassDiagram :: GENERALIZATION */
	public static final IHintedType GENERALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Generalization_4002"); //$NON-NLS-1$

	public static final String GENERALIZATION_LABEL_APPLIED_STEREOTYPER_HINT = "6007";

	/** ClassDiagram :: ChildLabelNodes */
	public static final IHintedType ENUMERATION_ENUMERATION_LITERAL_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.EnumerationLiteral_3017"); //$NON-NLS-1$

	public static final IHintedType DATA_TYPE_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Property_3018"); //$NON-NLS-1$

	public static final IHintedType DATA_TYPE_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Operation_3019"); //$NON-NLS-1$

	public static final IHintedType SIGNAL_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Property_3005"); //$NON-NLS-1$

}
