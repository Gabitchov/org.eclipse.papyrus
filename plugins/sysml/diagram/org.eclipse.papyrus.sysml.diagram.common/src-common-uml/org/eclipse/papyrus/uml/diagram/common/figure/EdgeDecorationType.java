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
package org.eclipse.papyrus.uml.diagram.common.figure;

import org.eclipse.gmf.runtime.notation.ArrowType;

/**
 * <pre>
 * The class provides a list of predefined ids to create edge decorations.
 * 
 * Also see : org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementLinkEditPart#getArrowDecoration().
 * </pre>
 */
public final class EdgeDecorationType {

	public static final int NONE = ArrowType.NONE; //0

	public static final int OPEN_ARROW = ArrowType.OPEN_ARROW; // 1

	public static final int SOLID_ARROW_FILLED = ArrowType.SOLID_ARROW; // 2

	public static final int SOLID_ARROW_EMPTY = 3;

	public static final int SOLID_DIAMOND_FILLED = 4;

	public static final int SOLID_DIAMOND_EMPTY = 5;

}
