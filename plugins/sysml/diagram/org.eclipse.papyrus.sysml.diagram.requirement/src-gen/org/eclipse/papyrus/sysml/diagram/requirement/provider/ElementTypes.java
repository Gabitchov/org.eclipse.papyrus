/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * CEA LIST- Initial API and implementation
 * Nizar GUEDIDI (CEA LIST)- modification
 *
 ****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class ElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** SysML Requirement Diagram specific elements **************** */
	/** ********************************************************* */

	/** SysML Requirement Diagram :: Diagram */
	public static final String DIAGRAM_ID = "RequirementDiagram"; //$NON-NLS-1$




	/** ********************************************************* */
	/** SysML Requirement Diagram - ClassDiagram related elements */
	/** ********************************************************* */


	/** ClassDiagram :: PACKAGE */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final String PACKAGE_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7016"; //$NON-NLS-1$

	public static final String PACKAGE_LABEL_NAME_HINT = "5026"; //$NON-NLS-1$

	/** ClassDiagram :: PACKAGE_CN */
	public static final IHintedType PACKAGE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Package_3009"); //$NON-NLS-1$

	public static final String PACKAGE_CN_COMPARTMENT_PACKAGEABLE_ELEMENT_HINT = "7010"; //$NON-NLS-1$

	public static final String PACKAGE_CN_LABEL_NAME_HINT = "5017"; //$NON-NLS-1$

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

	/** ClassDiagram :: DEFAULT_NAMED_ELEMENT */
	public static final IHintedType DEFAULT_NAMED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.NamedElement_2097"); //$NON-NLS-1$

	public static final String DEFAULT_NAMED_ELEMENT_LABEL_NAME_HINT = "5157"; //$NON-NLS-1$

	/** ClassDiagram :: CONTAINMENT_CIRCLE_CN */
	public static final IHintedType CONTAINMENT_CIRCLE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.ContainmentCircle_3032"); //$NON-NLS-1$

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


	/** ClassDiagram :: ABSTRACTION */
	public static final IHintedType ABSTRACTION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Abstraction_4006"); //$NON-NLS-1$

	public static final String ABSTRACTION_LABEL_NAME_HINT = "6014"; //$NON-NLS-1$

	public static final String ABSTRACTION_LABEL_APPLIED_STEREOTYPE_HINT = "6015"; //$NON-NLS-1$

	/** ClassDiagram :: CONTAINMENT_LINK */
	public static final IHintedType CONTAINMENT_LINK = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.ContainmentLink_4023"); //$NON-NLS-1$

	/** ClassDiagram :: CONTAINMENT_SUB_LINK */
	public static final IHintedType CONTAINMENT_SUB_LINK = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.AddedLink_4022"); //$NON-NLS-1$

	/** ClassDiagram :: DEPENDENCY */
	public static final IHintedType DEPENDENCY = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Dependency_4008"); //$NON-NLS-1$

	public static final String DEPENDENCY_LABEL_NAME_HINT = "6026"; //$NON-NLS-1$

	public static final String DEPENDENCY_LABEL_APPLIED_STEREOTYPE_HINT = "6027"; //$NON-NLS-1$

	/** ClassDiagram :: COMMENT_ANNOTATED_ELEMENT */
	public static final IHintedType COMMENT_ANNOTATED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.CommentAnnotatedElement_4013"); //$NON-NLS-1$

	/** ClassDiagram :: CONSTRAINT_CONSTRAINED_ELEMENT */
	public static final IHintedType CONSTRAINT_CONSTRAINED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.ConstraintConstrainedElement_4014"); //$NON-NLS-1$

	/** ClassDiagram :: REALIZATION */
	public static final IHintedType REALIZATION = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Realization_4005"); //$NON-NLS-1$

	public static final String REALIZATION_LABEL_APPLIED_STEREOTYPE_HINT = "6012"; //$NON-NLS-1$

	public static final String REALIZATION_LABEL_NAME_HINT = "6013"; //$NON-NLS-1$

	/** ClassDiagram :: PACKAGE_IMPORT */
	public static final IHintedType PACKAGE_IMPORT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PackageImport_4010"); //$NON-NLS-1$

	public static final String PACKAGE_IMPORT_LABEL_APPLIED_STEREOTYPE_HINT = "6022"; //$NON-NLS-1$

	/** ClassDiagram :: ChildLabelNodes */
	public static final IHintedType CLASS_PROPERTY_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Property_3012"); //$NON-NLS-1$

	public static final IHintedType CLASS_RECEPTION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Reception_3011"); //$NON-NLS-1$

	public static final IHintedType CLASS_OPERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Operation_3013"); //$NON-NLS-1$

	public static final IHintedType CLASS_CLASS_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Class_3014"); //$NON-NLS-1$

	public static final IHintedType CLASS_INTERFACE_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Interface_3036"); //$NON-NLS-1$

	public static final IHintedType CLASS_ENUMERATION_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Enumeration_3052"); //$NON-NLS-1$

	public static final IHintedType CLASS_PRIMITIVE_TYPE_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.PrimitiveType_3047"); //$NON-NLS-1$

	public static final IHintedType CLASS_DATA_TYPE_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.DataType_3044"); //$NON-NLS-1$

	public static final IHintedType CLASS_SIGNAL_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.clazz.Signal_3050"); //$NON-NLS-1$

}
