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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.util.IMappingRule;
import org.eclipse.papyrus.FCM.util.MapUtil;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

/**
 * Will generate a suitable called interface push consumer. The port is typed with a primitive type
 * or data type. The generated interface has a "push (data <Type>)" operation ).
 * 
 * The interface is identical to that of a PushProducer (and will be shared).
 * 
 * @author ansgar
 */
public class PushConsumer implements IMappingRule {

	public Interface getProvided(Port p, InstanceSpecification config, boolean update) {
		Log.log(Log.INFO_MSG, Log.CALC_PORTKIND,
			p.getKind().getBase_Class().getName() + " => GetProvided on " + p.getBase_Port().getName());
		Type type = p.getBase_Port().getType();

		if((type instanceof PrimitiveType) || (type instanceof DataType) || (type instanceof Signal)) {

			Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(p, "Push_", type);
			if (!update) {
				return derivedInterface;
			}
			
			if(derivedInterface == null) {
				// may happen, if within template (do not want creation of derived interfaces in template)
				return null;
			}

			// check whether operation already exists. Create, if not
			Operation derivedOperation = derivedInterface.getOperation("push", null, null);
			if(derivedOperation == null) {
				derivedOperation = derivedInterface.createOwnedOperation("push", null, null);
			}
			EList<Parameter> parameters = derivedOperation.getOwnedParameters();
			if(parameters.size() == 0) {
				derivedOperation.createOwnedParameter("data", type);
			} else {
				parameters.get(0).setName("data");
				parameters.get(0).setType(type);
			}
			return derivedInterface;
		} else {
			return null;
		}
	}

	public Interface getRequired(Port p, InstanceSpecification config, boolean update) {
		return null;
	}
}
