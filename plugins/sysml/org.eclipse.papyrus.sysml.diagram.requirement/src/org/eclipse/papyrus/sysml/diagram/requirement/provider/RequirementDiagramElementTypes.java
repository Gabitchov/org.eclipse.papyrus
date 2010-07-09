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


/**
 * Defines the SysML Requirement Diagram elements that are inherited from Class Diagram
 * 
 */
public class RequirementDiagramElementTypes extends AbstractElementTypeEnumerator {

	/** Requirement Diagram specific elements */

	public static final IHintedType REQUIREMENT_DIAGRAM = (IHintedType)getElementType("RequirementDiagram"); //$NON-NLS-1$

	/** Requirement Diagram - Class Diagram related elements */

	/**
	 * Package_2007 element
	 */
	public static final IHintedType PACKAGE_2007 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	/**
	 * Class_2008 element
	 */
	public static final IHintedType CLASS_2008 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_2008"); //$NON-NLS-1$

	/**
	 * Class_3010 element
	 */
	public static final IHintedType CLASS_3010_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3010"); //$NON-NLS-1$

	/**
	 * Abstraction_4006 element
	 */
	public static final IHintedType Abstraction_4006 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Abstraction_4006"); //$NON-NLS-1$

	/**
	 * Port_3032 element (for Containment-Circle)
	 */
	public static final IHintedType Port_3032 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Port_3032"); //$NON-NLS-1$

	/**
	 * NamedElement_2097 element (for any Name Element that can be used in the diagram)
	 */
	public static final IHintedType NamedElement_2097 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.NamedElement_2097"); //$NON-NLS-1$

	/**
	 * Link_4023 element (for Containment-Link)
	 */
	public static final IHintedType Link_4023 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Link_4023"); //$NON-NLS-1$

}
