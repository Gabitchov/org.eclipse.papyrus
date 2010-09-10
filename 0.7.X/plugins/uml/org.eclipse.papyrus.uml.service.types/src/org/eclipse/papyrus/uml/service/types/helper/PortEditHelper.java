/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * A UML {@link Port} inherits from {@link Property} but is supposed to have a specific {@link AggregationKind} ("Composite").
 * 
 * This helper initialize {@link AggregationKind} on {@link Port} creation.
 * 
 * </pre>
 */
public class PortEditHelper extends DefaultUMLEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {

		// Set Port Aggregation to Composite on creation
		SetRequest setReq = new SetRequest(req.getElementToConfigure(), UMLPackage.eINSTANCE.getProperty_Aggregation(), AggregationKind.COMPOSITE_LITERAL);
		return new SetValueCommand(setReq);
	}
}
