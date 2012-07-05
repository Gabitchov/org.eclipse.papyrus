/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net- Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.commands;

import org.eclipse.emf.ecore.EObject;

/**
 * The Interface IControlCondition to enable/disable contolrol and uncontrol actions if needed
 */
public interface IControlUncontrolCondition extends IControlCondition {

	/**
	 * This method returns true if the uncontrol action is allowed
	 * 
	 * @param selection
	 *        the element where the uncontrol action is performed
	 * @return true to enable the uncontrol action, false otherwise
	 */
	boolean enableUnControl(EObject selection);

}
