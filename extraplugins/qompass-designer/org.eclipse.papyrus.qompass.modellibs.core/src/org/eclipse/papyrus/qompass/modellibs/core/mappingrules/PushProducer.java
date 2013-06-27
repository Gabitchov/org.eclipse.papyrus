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

import org.eclipse.core.runtime.Status;
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
 * Will generate a suitable callable interface push provider. The port is typed with a primitive type
 * or data type. The generated interface has a "push (data <Type>)" operation
 * 
 * The interface is identical to that of a PushConsumer (and will be shared).
 * 
 * @author ansgar
 */
public class PushProducer implements IMappingRule {

	public Interface getProvided(Port p, InstanceSpecification config, boolean update) {
		return null;
	}

	public static PushProducer getInstance() {
		if(instance == null) {
			instance = new PushProducer();
		}
		return instance;
	}

	public Interface getRequired(Port p, InstanceSpecification config, boolean update) {
		Log.log(Status.INFO, Log.CALC_PORTKIND, p.getKind().getBase_Class().getName() + " => GetRequired on " + p.getBase_Port().getName());
		Type type = p.getBase_Port().getType();

		if((type instanceof PrimitiveType) || (type instanceof DataType) || (type instanceof Signal)) {

			Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(p, "Push_", type, update);
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
				Parameter parameter = parameters.get(0);
				if(!parameter.getName().equals("data")) {
					parameter.setName("data");
				}
				if(parameter.getType() != type) {
					parameter.setType(type);
				}
			}
			return derivedInterface;
		} else {
			return null;
		}
	}

	protected static PushProducer instance;
}
