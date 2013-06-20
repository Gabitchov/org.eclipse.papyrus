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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.util.IMappingRule;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Type;


public class UseInterface implements IMappingRule
{
	public Interface getProvided(Port p, InstanceSpecification config, boolean update)
	{
		return null;
	}
		
	public Interface getRequired(Port p, InstanceSpecification config, boolean update)
	{
		Type type = p.getBase_Port ().getType ();
		if (type instanceof Interface) {
			return ((Interface) type);
		}
		return null;
	}
}
