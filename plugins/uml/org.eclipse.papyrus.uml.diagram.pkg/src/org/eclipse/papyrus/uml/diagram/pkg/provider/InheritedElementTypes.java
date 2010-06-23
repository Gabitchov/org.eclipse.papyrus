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

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class InheritedElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** Package Diagram - Class Diagram related elements */
	/** ********************************************************* */

	/** Class Diagram :: Package ChildNode */
	public static final IHintedType PACKAGE_CN = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_3009"); //$NON-NLS-1$

	public static final String PACKAGE_CN_NAME_LABEL_HINT = "5017";

	public static final String PACKAGE_CN_COMPARTMENT_HINT = "7010";

	/** Class Diagram :: Package TopLevelNode */
	public static final IHintedType PACKAGE = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Package_2007"); //$NON-NLS-1$

	public static final String PACKAGE_NAME_LABEL_HINT = "5026";

	public static final String PACKAGE_COMPARTMENT_HINT = "7016";


	/** Class Diagram :: Dependency */
	public static final IHintedType DEPENDENCY = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.Dependency_4008"); //$NON-NLS-1$

	public static final String DEPENDENCY_NAME_LABEL_HINT = "6026";

	public static final String DEPENDENCY_STEREOTYPE_LABEL_HINT = "6027";

	/** Class Diagram :: PackageImport */
	public static final IHintedType PACKAGE_IMPORT = (IHintedType)getElementType("org.eclipse.papyrus.diagram.clazz.PackageImport_4010"); //$NON-NLS-1$

	public static final String PACKAGE_IMPORT_STEREOTYPE_LABEL_HINT = "6022";
}
