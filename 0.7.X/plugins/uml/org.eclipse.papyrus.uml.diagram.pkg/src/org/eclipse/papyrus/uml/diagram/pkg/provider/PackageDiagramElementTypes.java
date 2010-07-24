/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg.provider;

import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class PackageDiagramElementTypes extends InheritedElementTypes {

	/** Package Diagram specific elements */
	public static final IHintedType PACKAGE_DIAGRAM = (IHintedType)getElementType("Package"); //$NON-NLS-1$

}
