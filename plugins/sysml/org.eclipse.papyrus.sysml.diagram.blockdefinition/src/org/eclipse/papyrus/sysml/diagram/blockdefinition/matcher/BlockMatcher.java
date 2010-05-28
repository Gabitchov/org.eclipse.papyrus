/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Class;

/**
 * Test if current Class is a Block
 */
public class BlockMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isBlock = false;
		if(eObject instanceof Class) {

			Class clazz = (Class)eObject;
			if(clazz.getAppliedStereotype(SysmlResource.BLOCK_ID) != null) {
				isBlock = true;
			}
		}
		return isBlock;
	}

}
