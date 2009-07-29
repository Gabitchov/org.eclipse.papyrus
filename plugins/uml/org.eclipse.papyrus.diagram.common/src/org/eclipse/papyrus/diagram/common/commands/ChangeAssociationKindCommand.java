/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.UMLPackage;

public class ChangeAssociationKindCommand extends SetValueCommand {

	public ChangeAssociationKindCommand(Association association, AggregationKind kind) {
		super(new SetAggregationKindRequest(association, kind));
	}

	public static class SetAggregationKindRequest extends SetRequest {

		// Regarding getTargetEnd() below : consider link from S to T.
		// composition diamond at the side of S (source) represents aggregation = composite
		// for property end t : T that is placed at target end.
		public SetAggregationKindRequest(Association association, AggregationKind kind) {
			super(AssociationEndConvention.getTargetEnd(association), UMLPackage.eINSTANCE.getProperty_Aggregation(),
					kind);
		}
	}

}
