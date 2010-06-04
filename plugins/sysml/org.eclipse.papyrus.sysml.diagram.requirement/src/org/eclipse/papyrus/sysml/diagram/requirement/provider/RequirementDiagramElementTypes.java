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
	 * Package_1000 element
	 */
	public static final IHintedType Package_1000 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_1000"); //$NON-NLS-1$

	/**
	 * Package_2007 element
	 */
	public static final IHintedType Package_2007 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	/**
	 * Package_3009 element
	 */
	public static final IHintedType Package_3009 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_3009"); //$NON-NLS-1$

	/**
	 * Class_2008 element
	 */
	public static final IHintedType Class_2008 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_2008"); //$NON-NLS-1$

	/**
	 * Class_3004 element
	 */
	public static final IHintedType Class_3004 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3004"); //$NON-NLS-1$

	/**
	 * Class_3008 element
	 */
	public static final IHintedType Class_3008 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3008"); //$NON-NLS-1$

	/**
	 * Class_3010 element
	 */
	public static final IHintedType Class_3010 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3010"); //$NON-NLS-1$

	/**
	 * Class_3014 element
	 */
	public static final IHintedType Class_3014 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3014"); //$NON-NLS-1$

	/**
	 * Abstraction_4006 element
	 */
	public static final IHintedType Abstraction_4006 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Abstraction_4006"); //$NON-NLS-1$

	/**
	 * Component_2002 element
	 */
	public static final IHintedType Component_2002 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Component_2002"); //$NON-NLS-1$

	/**
	 * Component_3021 element
	 */
	public static final IHintedType Component_3021 = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Component_3021"); //$NON-NLS-1$

}
