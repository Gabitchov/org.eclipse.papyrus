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
	 * Package element: usage of the Package_2007 element from class diagram
	 */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	/**
	 * Requirement is build on the class element: usage of the Class_2008 element from class diagram
	 */
	public static final IHintedType CLASS_TOP_NODE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_2008"); //$NON-NLS-1$

	/**
	 * Requirement is build on the class element: usage of the Class_3010 element from class diagram when the class is a child node (included in a
	 * package for instance)
	 */
	public static final IHintedType CLASS_CHILD_NODE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Class_3010"); //$NON-NLS-1$

	/**
	 * Relations are based on the Abstraction relation: Abstraction_4006 element
	 */
	public static final IHintedType ABSTRACTION = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Abstraction_4006"); //$NON-NLS-1$

	/**
	 * The containment relation is based on two elements: the circle and the relation itself. For the circle, usage of Port_3032 element from class
	 * diagram
	 */
	public static final IHintedType CONTAINMENT_CIRCLE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Port_3032"); //$NON-NLS-1$

	/**
	 * NamedElement_2097 element (for any Name Element that can be used in the diagram)
	 */
	public static final IHintedType NAMED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.NamedElement_2097"); //$NON-NLS-1$

	/**
	 * The containment relation is based on two elements: the circle and the relation itself. For the link, usage of Link_4023 element from class
	 * diagram
	 */
	public static final IHintedType CONTAINMENT_LINK = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Link_4023"); //$NON-NLS-1$

}
