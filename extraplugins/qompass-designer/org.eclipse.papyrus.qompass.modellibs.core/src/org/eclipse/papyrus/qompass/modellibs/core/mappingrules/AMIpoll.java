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

import java.util.Iterator;

import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.util.IMappingRule;
import org.eclipse.papyrus.FCM.util.MapUtil;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;


/**
 * Implement a CORBA AMI style polling interface
 * This is defined in the CORBA 3 standard in section 22.6.2
 * A difference is that we do not return the poller object, but the client uses the original port.
 * This has the consequence that it is not possible to make multiple asynchronous requests.
 * 
 * A second difference is that we do not keep the normal methods in the same interface and prefix the
 * new ones. (which would probably be a good idea).
 * 
 * @author ansgar
 * 
 */
public class AMIpoll implements IMappingRule {


	public Interface getProvided(Port p, boolean update) {
		return null;
	}

	public Interface getRequired(Port p, boolean update) {
		Type type = p.getBase_Port().getType();
		if(!(type instanceof Interface))
			return null;

		Interface typingInterface = (Interface)type;
		Interface derivedInterface = MapUtil.getOrCreateDerivedInterface(p, "_", type, update); //$NON-NLS-1$
		if (!update) {
			return derivedInterface;
		}
		
		for(Operation operation : typingInterface.getOwnedOperations()) {
			String name = operation.getName();

			// check whether operation already exists. Create, if not
			Operation derivedOperation = derivedInterface.getOperation(name, null, null);
			if(derivedOperation == null) {
				derivedOperation = derivedInterface.createOwnedOperation(name, null, null);
			}

			if(hasOutParameters(operation)) {
				String pollName = name + "Poll"; //$NON-NLS-1$
				Operation derivedPollOperation = derivedInterface.getOperation(pollName, null, null);
				if(derivedPollOperation == null) {
					derivedPollOperation = derivedInterface.createOwnedOperation(pollName, null, null);
				}

				// each non-in parameter is in the poll operation. 
				derivedPollOperation.createOwnedParameter("timeout", null); //$NON-NLS-1$

				for(Parameter parameter : operation.getOwnedParameters()) {
					if(parameter.getDirection() != ParameterDirectionKind.IN_LITERAL) {

						String paramName = parameter.getName();
						Type paramType = parameter.getType();
						if(derivedPollOperation.getOwnedParameter(paramName, paramType) == null) {
							Parameter newParameter =
								derivedPollOperation.createOwnedParameter(parameter.getName(), parameter.getType());
							newParameter.setDirection(parameter.getDirection());
							newParameter.setLower(parameter.getLower());
							newParameter.setUpper(parameter.getUpper());
						}
					}
				}
			}
			// each in and inout parameter is in the request operation. 
			for(Parameter parameter : operation.getOwnedParameters()) {
				if((parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) ||
					(parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL)) {

					String paramName = parameter.getName();
					Type paramType = parameter.getType();
					if(derivedOperation.getOwnedParameter(paramName, paramType) == null) {
						Parameter newParameter =
							derivedOperation.createOwnedParameter(parameter.getName(), parameter.getType());
						newParameter.setDirection(parameter.getDirection());
						newParameter.setLower(parameter.getLower());
						newParameter.setUpper(parameter.getUpper());
					}
				}
			}
			// remove those parameters that exist in derived, but not original interface.
			Iterator<Parameter> derivedParameters = derivedOperation.getOwnedParameters().iterator();
			while(derivedParameters.hasNext()) {
				Parameter parameter = derivedParameters.next();
				String paramName = parameter.getName();
				Type paramType = parameter.getType();
				if((!paramName.equals("timeout")) && //$NON-NLS-1$
					(operation.getOwnedParameter(paramName, paramType) == null)) {
					// not on in original interface, remove from derived as well
					derivedParameters.remove();
				}
			}
		}

		// check whether operations in derived interface exist in original interface
		// (remove, if not)
		Iterator<Operation> derivedOperations = derivedInterface.getOwnedOperations().iterator();
		while(derivedOperations.hasNext()) {
			Operation derivedOperation = derivedOperations.next();
			String name = derivedOperation.getName();
			if(name == null) {
				continue;
			}
			if(name.endsWith("Poll")) { //$NON-NLS-1$
				// remove Poll postfix
				name = name.substring(0, name.length() - 4);
			}
			if(typingInterface.getOperation(name, null, null) == null) {
				// not in typing interface, remove
				derivedOperations.remove();
			}
		}

		return derivedInterface;
	}

	public static boolean hasOutParameters(Operation operation) {
		for(Parameter parameter : operation.getOwnedParameters()) {
			if(parameter.getDirection() != ParameterDirectionKind.IN_LITERAL) {
				return true;
			}
		}
		return false;
	}
	
	public boolean needsUpdate(Port p) {
		// TODO: insufficient condition
		return (getRequired(p, false) == null);
	}
}
