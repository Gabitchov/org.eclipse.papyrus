/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.ObjectFlow;


/**
 * Utility class for {@link ObjectFlow}
 */
public class ControlFlowUtil {
	
	/**
	 * Check condition on control flows
	 * @param container container of the object flow
	 * @param linkInstance object flow itself
	 * @param source 
	 * @param target
	 * @return
	 */
	public static boolean canExistControlFlow(Activity container, ControlFlow linkInstance, ActivityNode source, ActivityNode target) {
		try {
			if(target instanceof InitialNode) {
				return false;
			}
			return true;
		} catch (Exception e) {
			Activator.log.error(e);
			return false;
		}
	}

}
