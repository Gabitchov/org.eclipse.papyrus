/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class ElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** SysML Parametric Diagram specific elements **************** */
	/** ********************************************************* */

	/** SysML Parametric Diagram :: Diagram */
	public static final String DIAGRAM_ID = "Parametric"; //$NON-NLS-1$

	


	/** ********************************************************* */
	/** SysML Parametric Diagram - CompositeDiagram related elements */
	/** ********************************************************* */

	/** CompositeDiagram :: CONSTRAINT */
	public static final IHintedType CONSTRAINT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Constraint_2114"); //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_NAME_HINT = "5197"; //$NON-NLS-1$

	public static final String CONSTRAINT_LABEL_SPECIFICATION_HINT = "6039"; //$NON-NLS-1$

	/** CompositeDiagram :: COMMENT_CN */
	public static final IHintedType COMMENT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Comment_3097"); //$NON-NLS-1$

	public static final String COMMENT_CN_LABEL_BODY_HINT = "5150"; //$NON-NLS-1$

	/** CompositeDiagram :: COMMENT */
	public static final IHintedType COMMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Comment_2109"); //$NON-NLS-1$

	public static final String COMMENT_LABEL_BODY_HINT = "5192"; //$NON-NLS-1$

	/** CompositeDiagram :: CONSTRAINT_CN */
	public static final IHintedType CONSTRAINT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.Constraint_3120"); //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_NAME_HINT = "6048"; //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_SPECIFICATION_HINT = "6049"; //$NON-NLS-1$

	/** CompositeDiagram :: COMMENT_ANNOTATED_ELEMENT */
	public static final IHintedType COMMENT_ANNOTATED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.composite.CommentAnnotatedElement_4002"); //$NON-NLS-1$

	/** CompositeDiagram :: CONTEXT_LINK */
	public static final IHintedType CONTEXT_LINK = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.parametric.ContextLink"); //$NON-NLS-1$

	/** CompositeDiagram :: CONContextLinkAppliedStereotype */
	public static final IHintedType CONTEXT_LINK_APPLIED_STEREOTYPE = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.parametric.ContextLinkAppliedStereotype"); //$NON-NLS-1$

}	
