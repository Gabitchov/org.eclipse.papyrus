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
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

/**
 * Will generate a suitable callable interface pulling consumer. The port is typed with a primitive type
 * or data type. The generated interface has a "<Type> pull as well as a "boolean hasData()" operation).
 */
public class PullConsumer implements IMappingRule {

	public static String PULL_I_PREFIX = "PullConsumer_"; //$NON-NLS-1$

	public static String PULL_OP_NAME = "pull"; //$NON-NLS-1$
	
	public static String HASDATA_OP_NAME = "hasData"; //$NON-NLS-1$
	
	public static String RET_PAR_NAME = "ret"; //$NON-NLS-1$
	
	public static String BOOL_QNAME = "corba::Boolean"; //$NON-NLS-1$

	public Interface getProvided(Port p, boolean update) {
		return null;
	}

	public boolean needsUpdate(Port p) {
		Type type = p.getBase_Port().getType();

		if((type instanceof PrimitiveType) || (type instanceof DataType) || (type instanceof Signal)) {

			Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(p, PULL_I_PREFIX, type, false);
			if (derivedInterface == null) {
				return true;
			}
			Operation derivedOperation = derivedInterface.getOperation(PULL_OP_NAME, null, null);
			if(derivedOperation == null) {
				return true;
			}
			EList<Parameter> parameters = derivedOperation.getOwnedParameters();
			if(parameters.size() != 1) {
				return true;
			} else {
				Parameter parameter = parameters.get(0);
				if(!parameter.getName().equals(RET_PAR_NAME)) {
					return true;
				}
				if(parameter.getType() != type) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static PullConsumer getInstance() {
		if(instance == null) {
			instance = new PullConsumer();
		}
		return instance;
	}

	public Interface getRequired(Port p, boolean update) {
		org.eclipse.uml2.uml.Port umlPort = p.getBase_Port();
		Element owner = umlPort.getOwner();
		String ownerStr = ""; //$NON-NLS-1$
		if(owner instanceof NamedElement) {
			ownerStr = " of class " + ((NamedElement)owner).getQualifiedName(); //$NON-NLS-1$
		}
		Log.log(Status.INFO, Log.CALC_PORTKIND,
			p.getKind().getBase_Class().getName() + " => GetRequired on " + umlPort.getName() + ownerStr);
		Type type = umlPort.getType();

		if((type instanceof PrimitiveType) || (type instanceof DataType) || (type instanceof Signal)) {

			Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(p, PULL_I_PREFIX, type, update);
			if (!update) {
				return derivedInterface;
			}
			if(derivedInterface == null) {
				return null;
			}

			// check whether operation already exists. Create, if not
			Operation derivedOperationPull = derivedInterface.getOperation(PULL_OP_NAME, null, null);
			if(derivedOperationPull == null) {
				derivedOperationPull = derivedInterface.createOwnedOperation(PULL_OP_NAME, null, null, type);
			}
			EList<Parameter> parameters = derivedOperationPull.getOwnedParameters();
			if(parameters.size() > 0) {
				Parameter parameter = parameters.get(0);
				if((parameter.getName() == null) || (!parameter.getName().equals(RET_PAR_NAME))) {
					parameter.setName(RET_PAR_NAME);
				}
				if(parameter.getType() != type) {
					parameter.setType(type);
				}
			}
			Package model = Utils.getTop(umlPort);
			Element element = Utils.getQualifiedElement(model, BOOL_QNAME);
			Type booleanType = null;
			if(element instanceof Type) {
				booleanType = (Type)element;
			}

			// check whether operation already exists. Create, if not
			Operation derivedOperationHasData = derivedInterface.getOperation(HASDATA_OP_NAME, null, null);
			if(derivedOperationHasData == null) {
				derivedOperationHasData = derivedInterface.createOwnedOperation(HASDATA_OP_NAME, null, null, booleanType);
			}

			parameters = derivedOperationHasData.getOwnedParameters();
			if(parameters.size() > 0) {
				Parameter parameter = parameters.get(0);
				if((parameter.getName() == null) || (!parameter.getName().equals(RET_PAR_NAME))) {
					parameter.setName(RET_PAR_NAME);
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
