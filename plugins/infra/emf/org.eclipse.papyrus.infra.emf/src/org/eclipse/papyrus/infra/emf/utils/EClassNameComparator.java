/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import java.text.Collator;
import java.util.Comparator;

import org.eclipse.emf.ecore.EClass;

/**
 * A class for comparing EClasses by name
 * 
 * @author Camille Letavernier
 * 
 */
public class EClassNameComparator implements Comparator<EClass> {

	public int compare(EClass class1, EClass class2) {
		if(class1 == null) {
			return class2 == null ? 0 : -1;
		}

		return Collator.getInstance().compare(class1.getName(), class2.getName());
	}

}
