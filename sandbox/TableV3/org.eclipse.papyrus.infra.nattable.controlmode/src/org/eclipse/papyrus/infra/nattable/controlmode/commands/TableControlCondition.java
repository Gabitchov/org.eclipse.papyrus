/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.controlmode.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.controlmode.commands.IControlCondition;
import org.eclipse.uml2.uml.Element;


public class TableControlCondition implements IControlCondition {

	public boolean enableControl(EObject selection) {
		EObject eObject = EMFHelper.getEObject(selection);

		return eObject instanceof Element;
	}

}
