/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign.queries;

import java.util.Collection;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.uml2.uml.Element;


/**
 * AbstractQuery to get the values of the "to" attribute of an Assign
 * @author omelois
 *
 */
public class GetToQuery extends AbstractGetAssignAttributeQuery {

	@Override
	public Collection<Element> getAttribute(Assign assign) {
		return assign.getTo();
	}

}
