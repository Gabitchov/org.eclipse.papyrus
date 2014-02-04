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
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;


/**
 * 
 */
public interface IActionEditHelperAdvice<T extends ActionConfiguration> extends IEditHelperAdvice {
	
	public void init(T configuration);
}
