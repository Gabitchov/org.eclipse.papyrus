/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.Iterator;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * This class encapsulates an <code>org.eclipse.uml2.uml.Operation</code><BR>
 */
public class OperationUtil {

	public static Activity getFirstActivity(Operation uml2Operation) {
		Iterator<Behavior> methodIter = uml2Operation.getMethods().iterator();
		while (methodIter.hasNext()) {
			Behavior currentBehavior = methodIter.next();
			if (currentBehavior instanceof Activity)
				return (Activity) currentBehavior;

		}
		return null;
	}

}
