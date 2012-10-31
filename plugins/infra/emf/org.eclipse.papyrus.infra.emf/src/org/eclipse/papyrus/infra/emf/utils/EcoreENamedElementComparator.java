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
package org.eclipse.papyrus.infra.emf.utils;

import java.text.Collator;
import java.util.Comparator;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * 
 * A comparator for ENamedElement
 *
 */
public class EcoreENamedElementComparator implements Comparator<ENamedElement> {

	public int compare(final ENamedElement namedElement1, final ENamedElement namedElement2) {
		if(namedElement1 == null) {
			return namedElement2 == null ? 0 : -1;
		}

		return Collator.getInstance().compare(namedElement1.getName(), namedElement2.getName());
	}
}
