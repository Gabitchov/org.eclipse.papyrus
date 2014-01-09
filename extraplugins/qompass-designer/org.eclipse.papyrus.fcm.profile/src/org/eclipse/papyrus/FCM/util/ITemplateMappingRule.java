/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 * 
 */

package org.eclipse.papyrus.FCM.util;

import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.PortKind;


/**
 * A specific mapping rule for template ports, i.e. ports that facilitate the
 * use of bound ports: i.e. instead of creating explicitly a binding for an extended
 * port, the type of the port is used as actual and the kind points to an extended
 * port
 */
public interface ITemplateMappingRule extends IMappingRule {

	/**
	 * Update the created binding
	 */
	public void updateBinding(Port port);
	
	/**
	 * Return the bound type
	 *
	 * @param port
	 * @return
	 */
	public PortKind getBoundType(Port port);
}
