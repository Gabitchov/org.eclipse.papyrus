/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.action;

import org.eclipse.uml2.uml.AggregationKind;

/**
 * set the association end shared
 */
public class SetSharedPropertyAction extends SetAggregationPropertyAction {

	/**
	 * Instantiates a new sets the shared property action.
	 */
	public SetSharedPropertyAction() {
		super();
		aggregationKind = AggregationKind.SHARED_LITERAL;
	}
}
