/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;


/**
 * This interface provides specific methods to allows to get a label with its context (object and edited feature)
 * 
 * @author Vincent Lorenzo
 * 
 */
public interface ILabelProviderContextElement {

	/**
	 * 
	 * @return
	 *         the config registry which can provide useful information
	 */
	public IConfigRegistry getConfigRegistry();

	/**
	 * 
	 * @return
	 *         the object for which we want the label
	 */
	public Object getObject();

}
