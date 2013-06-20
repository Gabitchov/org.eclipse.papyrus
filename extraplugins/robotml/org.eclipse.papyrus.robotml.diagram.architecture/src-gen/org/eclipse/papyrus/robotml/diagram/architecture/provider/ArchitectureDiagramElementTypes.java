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
package org.eclipse.papyrus.robotml.diagram.architecture.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class ArchitectureDiagramElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** Proteus Architecture Diagram specific elements **************** */
	/** ********************************************************* */

	/** Proteus Architecture Diagram :: Diagram */
	public static final IHintedType ARCHITECTURE_DIAGRAM = (IHintedType)getElementType("architecture"); //$NON-NLS-1$




	/** ********************************************************* */
	/** Proteus Architecture Diagram - CompositeDiagram related elements */
	/** ********************************************************* */


	/** CompositeDiagram :: CLASS */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Class_2073"); //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_CLASS_COMPOSITE_HINT = "7073";

	public static final String CLASS_LABEL_COMPOSITE_NAME_HINT = "5156";

	/** CompositeDiagram :: CLASS_CN */
	public static final IHintedType CLASS_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Class_3085"); //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_CLASS_COMPOSITE_HINT = "7060";

	public static final String CLASS_CN_LABEL_COMPOSITE_NAME_HINT = "5155";

	/** CompositeDiagram :: PORT_CN */
	public static final IHintedType PORT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Port_3069"); //$NON-NLS-1$

	public static final String PORT_CN_LABEL_NAME_HINT = "5125";

	public static final String PORT_CN_LABEL_APPLIED_STEREOTYPE_HINT = "6029";

	/** CompositeDiagram :: PROPERTY_CN */
	public static final IHintedType PROPERTY_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Property_3070"); //$NON-NLS-1$

	public static final String PROPERTY_CN_COMPARTMENT_PROPERTY_PART_HINT = "7077";

	public static final String PROPERTY_CN_LABEL_PART_NAME_HINT = "5126";

	/** CompositeDiagram :: COMMENT */
	public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Comment_2109"); //$NON-NLS-1$

	public static final String COMMENT_LABEL_BODY_HINT = "5192";

	/** CompositeDiagram :: CONSTRAINT */
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Constraint_2114"); //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_NAME_HINT = "5197";

	public static final String CONSTRAINT_LABEL_SPECIFICATION_HINT = "6039";


	/** CompositeDiagram :: CONNECTOR */
	public static final IHintedType CONNECTOR = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Connector_4013"); //$NON-NLS-1$

	public static final String CONNECTOR_LABEL_APPLIED_STEREOTYPE_HINT = "6025";


	/** CompositeDiagram :: CONSTRAINT_CONSTRAINED_ELEMENT */
	public static final IHintedType CONSTRAINT_CONSTRAINED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.ConstraintConstrainedElement_4003"); //$NON-NLS-1$

	/** CompositeDiagram :: COMMENT_ANNOTATED_ELEMENT */
	public static final IHintedType COMMENT_ANNOTATED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.CommentAnnotatedElement_4002"); //$NON-NLS-1$


}
