/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.common.handlers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.papyrus.infra.table.efacet.common.factory.PapyrusTableEfacetCommandFactory;

/**
 * 
 * This handler allows to move a line down
 * 
 */
public class DownRowHandler extends AbstractMoveRowHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.handlers.AbstractMoveRowHandler#getMoveRowCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getMoveRowCommand() {
		final EObject element = getSelectedRowEObject().get(0);
		for(final Row row : getTable().getRows()) {
			if(row.getElement() == element) {
				return PapyrusTableEfacetCommandFactory.getMoveLineDownCommand(getEditingDomain(), getTable(), row);
			}
		}
		return null;
	}
}
