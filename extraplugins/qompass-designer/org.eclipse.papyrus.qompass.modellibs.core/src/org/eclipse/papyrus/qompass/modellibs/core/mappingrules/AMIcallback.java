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


public class AMIcallback implements IMappingRule {

	public Interface getProvided(Port p, boolean update) {
		Type type = p.getBase_Port().getType();
		if(!(type instanceof Interface))
			return null;

		Interface typingInterface = (Interface)type;
		Interface derivedInterface = MapUtil.getOrCreateDerivedInterface(p, "_reply_", type, update);
		if (!update) {
			return derivedInterface;
		}

		for(Operation operation : typingInterface.getOwnedOperations()) {
			String name = operation.getName();

			if(AMIpoll.hasOutParameters(operation)) {

				// check whether operation already exists. Create, if not
				Operation derivedOperation = derivedInterface.getOperation(name, null, null);
				if(derivedOperation == null) {
					derivedOperation = derivedInterface.createOwnedOperation(name, null, null);
				}

				// each non-in parameter is in the poll operation. 
				for(Parameter parameter : operation.getOwnedParameters()) {
					if(parameter.getDirection() != ParameterDirectionKind.IN_LITERAL) {

						String paramName = parameter.getName();
						Type paramType = parameter.getType();
						if(derivedOperation.getOwnedParameter(paramName, paramType) == null) {
							Parameter newParameter =
								derivedOperation.createOwnedParameter(parameter.getName(), parameter.getType());
							newParameter.setDirection(ParameterDirectionKind.IN_LITERAL);
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
					if(operation.getOwnedParameter(paramName, paramType) == null) {
						// not on in original interface, remove from derived as well
						derivedParameters.remove();
					}
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
			if(typingInterface.getOperation(name, null, null) == null) {
				// not in typing interface, remove
				derivedOperations.remove();
			}
		}
		return derivedInterface;
	}

	public Interface getRequired(Port p, boolean update) {
		Type type = p.getBase_Port().getType();
		if(!(type instanceof Interface))
			return null;

		Interface typingInterface = (Interface)type;
		Interface derivedInterface = MapUtil.getOrCreateDerivedInterface(p, "_req_", type, update); //$NON-NLS-1$
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

			// request operation contains only in and inout parameters 
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
				if(operation.getOwnedParameter(paramName, paramType) == null) {
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
			if(typingInterface.getOperation(name, null, null) == null) {
				// not in typing interface, remove
				derivedOperations.remove();
			}
		}

		return derivedInterface;
	}
	
	public boolean needsUpdate(Port p) {
		// TODO: insufficient condition
		return (getRequired(p, false) == null) ||
				(getProvided(p, false) == null);
	}
}
