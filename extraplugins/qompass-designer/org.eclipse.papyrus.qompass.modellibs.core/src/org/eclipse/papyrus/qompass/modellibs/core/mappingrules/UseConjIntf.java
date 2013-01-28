package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import java.util.Iterator;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Type;

import FCM.Port;
import FCM.util.IMappingRule;
import FCM.util.MapUtil;


/**
 * Use a conjugated interface (!= conjugated port), i.e. an interface in which the roles "in" and "out"
 * of each parameter of an operation are inversed. This transformation is useful in the context of transforming
 * a "push" interface into a "pull" interface, i.e. instead of calling and providing values values to the
 * called component via "in", the called components queries us and obtains these values as out parameters.
 * TODO: This rules is currently not used, since data flow operation are currently either based on a datatype
 * or a MARTE FlowPort
 *
 * @author ansgar
 *
 */
public class UseConjIntf implements IMappingRule {
	
	public int needsTransaction () {
		return IMappingRule.REQUIRED;
	}

	public Interface getProvided (Port p, InstanceSpecification config) {
		return null;
	}	
	
	public Interface getRequired (Port p, InstanceSpecification config) {
		Type type = p.getBase_Port ().getType ();
		if (!(type instanceof Interface)) return null;
	
		Interface typingInterface = (Interface) type;
		Interface derivedInterface = MapUtil.getOrCreateDerivedInterface (p, "_", type);
		if (derivedInterface == null) {
			return null;
		}
		for (Operation operation : typingInterface.getOwnedOperations ()) {
			String name = operation.getName ();
			
			// check whether operation already exists. Create, if not
			Operation derivedOperation = derivedInterface.getOperation (name, null, null);
			if (derivedOperation == null) {
				derivedOperation = derivedInterface.createOwnedOperation (name, null, null);
			}
			
			// TODO: move to Copy (factor code, ensure that these values are handled in case of model copies ...)
			derivedOperation.setIsAbstract (operation.isAbstract ());
			derivedOperation.setIsStatic (operation.isStatic ());	// (does not make sense for an interface, if true)
			derivedOperation.setIsUnique (operation.isUnique ());
			derivedOperation.setIsQuery (operation.isQuery ());
			
			for (Parameter parameter : operation.getOwnedParameters ()) {		
				String paramName = parameter.getName ();
				Type paramType = parameter.getType ();
				if (derivedOperation.getOwnedParameter (paramName, paramType) == null) {
					Parameter newParameter =
						derivedOperation.createOwnedParameter(parameter.getName (), parameter.getType ());
					ParameterDirectionKind direction = parameter.getDirection ();
					if (direction == ParameterDirectionKind.IN_LITERAL) {
						newParameter.setDirection (ParameterDirectionKind.OUT_LITERAL);
					}
					else if (direction == ParameterDirectionKind.OUT_LITERAL) {
						newParameter.setDirection (ParameterDirectionKind.IN_LITERAL);
					}
					else {
						newParameter.setDirection (direction);
					}
					newParameter.setLower (parameter.getLower ());
					newParameter.setUpper (parameter.getUpper ());
				}
			}
			// remove those parameters that exist in derived, but not original interface.
			Iterator <Parameter> derivedParameters = derivedOperation.getOwnedParameters ().iterator ();		
			while (derivedParameters.hasNext ()) {
				Parameter parameter = derivedParameters.next ();
				String paramName = parameter.getName ();
				Type paramType = parameter.getType ();
				if (operation.getOwnedParameter (paramName, paramType) == null) {
					// not on in original interface, remove from derived as well
					derivedParameters.remove ();
				}
			}
		}
		
		// check whether operations in derived interface exist in original interface
		// (remove, if not)
		Iterator<Operation> derivedOperations = derivedInterface.getOwnedOperations ().iterator ();
		while (derivedOperations.hasNext ()) {
			Operation derivedOperation = derivedOperations.next ();
			String name = derivedOperation.getName ();
			if (typingInterface.getOperation (name, null, null) == null) {
				// not in typing interface, remove
				if (derivedInterface.getOperations ().remove (derivedOperation)) {
					derivedOperations = derivedInterface.getOwnedOperations ().iterator ();
				}
			}
		}
		
		return derivedInterface;
	}
}