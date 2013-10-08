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
import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.util.IMappingRule;
import org.eclipse.papyrus.FCM.util.MapUtil;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;

/**
 * Will generate a suitable callable interface pulling consumer. The port is typed with a primitive type
 * or data type. The generated interface has a "<Type> pull as well as a "boolean hasData ()" operation).
 * 
 * @author ansgar
 */
public class PushProdPullCons implements IMappingRule {

	public Interface getProvided(Port p, boolean update) {
		return null;
	}

	public Interface getRequired(Port p, boolean update) {
		org.eclipse.uml2.uml.Port umlPort = p.getBase_Port();
		Element owner = umlPort.getOwner();
		String ownerStr = ""; //$NON-NLS-1$
		if(owner instanceof NamedElement) {
			ownerStr = " of class " + ((NamedElement)owner).getQualifiedName();
		}
		Log.log(Status.INFO, Log.CALC_PORTKIND,
			p.getKind().getBase_Class().getName() + " => GetRequired on " + umlPort.getName() + ownerStr);
		Type type = umlPort.getType();

		if((type instanceof PrimitiveType) || (type instanceof DataType) || (type instanceof Signal)) {

			Interface derivedInterface = MapUtil.getOrCreateDerivedInterface(p, "_", type, update); //$NON-NLS-1$
			if (!update) {
				return derivedInterface;
			}

			// obtain derived interface for other port kind (Caveat: some rules get the prefix from the
			// name of the port kind attached to port "p" which would produce wrong results.
			Interface derivedInterfacePushProd = PushProducer.getInstance().getRequired(p, update);
			Interface derivedInterfacePullCons = PullConsumer.getInstance().getRequired(p, update);
			if(derivedInterface == null) {
				return null;
			}

			if(!derivedInterface.getGenerals().contains(derivedInterfacePushProd)) {
				derivedInterface.createGeneralization(derivedInterfacePushProd);
			}
			if(!derivedInterface.getGenerals().contains(derivedInterfacePullCons)) {
				derivedInterface.createGeneralization(derivedInterfacePullCons);
			}
			return derivedInterface;
		}
		else {
			return null;
		}
	}
	
	public boolean needsUpdate(Port p) {
		return
			PushProducer.getInstance().needsUpdate(p) ||
			PullConsumer.getInstance().needsUpdate(p);
	}
}
