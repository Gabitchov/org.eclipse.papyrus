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
package org.eclipse.papyrus.robotml.diagram.interfacedef.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class InterfaceDefElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** Interface Definition Diagram specific elements **************** */
	/** ********************************************************* */

	/** Interface Definition Diagram :: Diagram */
	public static final IHintedType INTERFACE_DEF_DIAGRAM = (IHintedType)getElementType("InterfaceDef"); //$NON-NLS-1$




	/** ********************************************************* */
	/** Interface Definition Diagram - ClassDiagram related elements */
	/** ********************************************************* */


	/** ClassDiagram :: PACKAGE */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final String PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7016";

	public static final String PACKAGE_LABEL_NAME_HINT = "5026";

	/** ClassDiagram :: COMMENT */
	public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Comment_2012"); //$NON-NLS-1$

	public static final String COMMENT_LABEL_BODY_HINT = "5038";

	/** ClassDiagram :: CONSTRAINT */
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Constraint_2011"); //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_NAME_HINT = "5037";

	public static final String CONSTRAINT_LABEL_BODY_HINT = "5159";

	/** ClassDiagram :: PACKAGE_CN */
	public static final IHintedType PACKAGE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_3009"); //$NON-NLS-1$

	public static final String PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7010";

	public static final String PACKAGE_CN_LABEL_NAME_HINT = "5017";

	/** ClassDiagram :: INTERFACE_CN */
	public static final IHintedType INTERFACE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Interface_3023"); //$NON-NLS-1$

	public static final String INTERFACE_CN_COMPARTMENT_ATTRIBUTE_HINT = "7027";

	public static final String INTERFACE_CN_COMPARTMENT_OPERATION_HINT = "7028";

	public static final String INTERFACE_CN_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7029";

	public static final String INTERFACE_CN_LABEL_NAME_HINT = "5049";

	/** ClassDiagram :: INTERFACE */
	public static final IHintedType INTERFACE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Interface_2004"); //$NON-NLS-1$

	public static final String INTERFACE_COMPARTMENT_ATTRIBUTE_HINT = "7006";

	public static final String INTERFACE_COMPARTMENT_OPERATION_HINT = "7007";

	public static final String INTERFACE_COMPARTMENT_NESTED_CLASSIFIER_HINT = "7008";

	public static final String INTERFACE_LABEL_NAME_HINT = "5011";

	/** ClassDiagram :: SHORT_CUT_DIAGRAM */
	public static final IHintedType SHORT_CUT_DIAGRAM = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Diagram_2016"); //$NON-NLS-1$

	public static final String SHORT_CUT_DIAGRAM_LABEL_DIAGRAM_NAME_HINT = "0";


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

	/** ClassDiagram :: GENERALIZATION */
	public static final IHintedType GENERALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Generalization_4002"); //$NON-NLS-1$

	public static final String GENERALIZATION_LABEL_APPLIED_STEREOTYPER_HINT = "6007";

	/** ClassDiagram :: INTERFACE_REALIZATION */
	public static final IHintedType INTERFACE_REALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.InterfaceRealization_4003"); //$NON-NLS-1$

	public static final String INTERFACE_REALIZATION_LABEL_APPLIED_STEREOTYPE_HINT = "6008";

	public static final String INTERFACE_REALIZATION_LABEL_NAME2_HINT = "6009";

	/** ClassDiagram :: ChildLabelNodes */
	public static final IHintedType INTERFACE_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Property_3006"); //$NON-NLS-1$

	public static final IHintedType INTERFACE_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Operation_3007"); //$NON-NLS-1$

	public static final IHintedType INTERFACE_CLASS_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Class_3008"); //$NON-NLS-1$

}
