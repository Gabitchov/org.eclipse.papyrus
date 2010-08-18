/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.provider;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class InheritedElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** Requirement Diagram - Class Diagram related elements */
	/** ********************************************************* */

	/** Class Diagram :: Package ChildNode */
	public static final IHintedType PACKAGE_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_3009"); //$NON-NLS-1$

	public static final String PACKAGE_CN_NAME_LABEL_HINT = "5017"; //$NON-NLS-1$

	public static final String PACKAGE_CN_COMPARTMENT_HINT = "7010"; //$NON-NLS-1$

	/** Class Diagram :: Package TopLevelNode */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final String PACKAGE_NAME_LABEL_HINT = "5026"; //$NON-NLS-1$

	public static final String PACKAGE_COMPARTMENT_HINT = "7016"; //$NON-NLS-1$

	/** Class Diagram :: NamedElement TopLevelNode */
	public static final IHintedType NAMED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.NamedElement_2097"); //$NON-NLS-1$

	public static final String NAMED_ELEMENT_NAME_LABEL_HINT = "5157"; //$NON-NLS-1$

	/** Class Diagram :: Class ChildNode */
	public static final IHintedType CLASS_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3010"); //$NON-NLS-1$

	public static final String CLASS_CN_NAME_LABEL_HINT = "5014"; //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_PROP_HINT = "7011"; //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_OPER_HINT = "7012"; //$NON-NLS-1$

	public static final String CLASS_CN_COMPARTMENT_NEST_HINT = "7013"; //$NON-NLS-1$

	/** Class Diagram :: Class TopLevelNode */
	public static final IHintedType CLASS = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_2008"); //$NON-NLS-1$

	public static final String CLASS_NAME_LABEL_HINT = "5029"; //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_PROP_HINT = "7017"; //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_OPER_HINT = "7018"; //$NON-NLS-1$

	public static final String CLASS_COMPARTMENT_NEST_HINT = "7019"; //$NON-NLS-1$

	public static final IHintedType CLASS_PROP_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Property_3012"); //$NON-NLS-1$

	public static final IHintedType CLASS_OPER_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Operation_3013"); //$NON-NLS-1$

	public static final IHintedType CLASS_RECP_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Reception_3011"); //$NON-NLS-1$

	public static final IHintedType CLASS_NEST_CLN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3014"); //$NON-NLS-1$

	/** Class Diagram :: Abstraction */
	public static final IHintedType ABSTRACTION = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Abstraction_4006"); //$NON-NLS-1$

	public static final String ABSTRACTION_NAME_LABEL_HINT = "6014"; //$NON-NLS-1$

	public static final String ABSTRACTION_STEREOTYPE_LABEL_HINT = "6015"; //$NON-NLS-1$

	/** Class Diagram :: ContainmentLink */
	public static final IHintedType CONTAINMENT_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.ContainmentLink_4023"); //$NON-NLS-1$

	public static final IHintedType CONTAINMENT_ADDED_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.AddedLink_4022"); //$NON-NLS-1$

	public static final IHintedType CONTAINMENT_CIRCLE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.ContainmentCircle_3032"); //$NON-NLS-1$

}
