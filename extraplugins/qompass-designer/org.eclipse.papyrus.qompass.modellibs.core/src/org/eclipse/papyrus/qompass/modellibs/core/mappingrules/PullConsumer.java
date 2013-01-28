package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

import FCM.Port;
import FCM.util.IMappingRule;
import FCM.util.MapUtil;

import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.Utils;

/**
 * Will generate a suitable callable interface pulling consumer. The port is typed with a primitive type
 * or data type. The generated interface has a "<Type> pull as well as a "boolean hasData ()" operation).
 * 
 * @author ansgar
 */
public class PullConsumer implements IMappingRule {

	public Interface getProvided(Port p, InstanceSpecification config) {
		return null;
	}

	public int needsTransaction() {
		return IMappingRule.REQUIRED;
	}

	public static PullConsumer getInstance() {
		if(instance == null) {
			instance = new PullConsumer();
		}
		return instance;
	}

	public Interface getRequired(Port p, InstanceSpecification config) {
		org.eclipse.uml2.uml.Port umlPort = p.getBase_Port();
		Element owner = umlPort.getOwner();
		String ownerStr = "";
		if(owner instanceof NamedElement) {
			ownerStr = " of class " + ((NamedElement)owner).getQualifiedName();
		}
		Log.log(Log.INFO_MSG, Log.CALC_PORTKIND,
			p.getKind().getBase_Class().getName() + " => GetRequired on " + umlPort.getName() + ownerStr);
		Type type = umlPort.getType();

		if((type instanceof PrimitiveType) || (type instanceof DataType) || (type instanceof Signal)) {

			Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(p, "PullConsumer_", type);
			if(derivedInterface == null) {
				return null;
			}

			// check whether operation already exists. Create, if not
			Operation derivedOperationPull = derivedInterface.getOperation("pull", null, null);
			if(derivedOperationPull == null) {
				derivedOperationPull = derivedInterface.createOwnedOperation("pull", null, null, type);
			}
			EList<Parameter> parameters = derivedOperationPull.getOwnedParameters();
			if(parameters.size() > 0) {
				Parameter parameter = parameters.get(0);
				if((parameter.getName() == null) || (!parameter.getName().equals("ret"))) {
					parameter.setName("ret");
				}
				if(parameter.getType() != type) {
					parameter.setType(type);
				}
			}
			Package model = Utils.getTop(umlPort);
			Element element = Utils.getQualifiedElement(model, "corba::Boolean");
			Type booleanType = null;
			if(element instanceof Type) {
				booleanType = (Type)element;
			}

			// check whether operation already exists. Create, if not
			Operation derivedOperationHasData = derivedInterface.getOperation("hasData", null, null);
			if(derivedOperationHasData == null) {
				derivedOperationHasData = derivedInterface.createOwnedOperation("hasData", null, null, booleanType);
			}

			parameters = derivedOperationHasData.getOwnedParameters();
			if(parameters.size() > 0) {
				Parameter parameter = parameters.get(0);
				if((parameter.getName() == null) || (!parameter.getName().equals("ret"))) {
					parameter.setName("ret");
				}
				if((booleanType != null) && (parameter.getType() != booleanType)) {
					// added != null check
					parameter.setType(booleanType);
				}
			}

			return derivedInterface;
		} else {
			return null;
		}
	}

	protected static PullConsumer instance;
}
