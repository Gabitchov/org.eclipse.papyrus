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
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.constraints;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;

/**
 * this is the client context to execute constraint of profile in the context of EMF validation
 *
 */

public class ClientSelector implements IClientSelector {

	public boolean selects(Object object) {
		if((object instanceof Element)){
		return true;}
		else{
			return false;}
	}
}
