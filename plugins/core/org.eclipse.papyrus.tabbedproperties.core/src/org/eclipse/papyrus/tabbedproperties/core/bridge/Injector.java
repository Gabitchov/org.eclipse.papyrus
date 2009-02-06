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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.bridge;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.Element;

/**
 * this is an injector used to modify the model thanks to information contained into a string
 * @author Patrick Tessier
 *
 */
public interface Injector {
	/**
	 * used to modify the element thanks to the string
	 * @param newValue the string that will be parsed in order to be transform into model
	 * @param Element the element that will be modified.
	 * @param editong domain to create command to modify 
	 */
	public void inject(String newValue, Element Element,TransactionalEditingDomain editingDomain);

}
