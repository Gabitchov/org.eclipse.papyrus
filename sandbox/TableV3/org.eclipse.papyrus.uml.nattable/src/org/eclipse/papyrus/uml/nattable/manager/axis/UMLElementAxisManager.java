/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.manager.axis;

import org.eclipse.papyrus.infra.nattable.manager.EObjectManager;
import org.eclipse.uml2.uml.Element;

/**
 *
 * This axis manager restrict the allowed contents to UML Element
 *
 */
public class UMLElementAxisManager extends EObjectManager {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.manager.EObjectManager#isAllowedContents(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		boolean value = super.isAllowedContents(object);
		if(value) {
			return object instanceof Element;
		}
		return value;
	}
}
