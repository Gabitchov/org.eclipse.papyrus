/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.controlmode.commands;

import org.eclipse.emf.ecore.EObject;

/**
 * The Interface IControlCondition to enable/disable contol action if needed
 */
public interface IControlCondition {
	
	/**
	 * This method returns true if the control action is allowed
	 * 
	 * @param selection the element where the control action is performed
	 * @return true to enable the control action, false otherwise
	 */
	boolean enableControl(EObject selection);

}
