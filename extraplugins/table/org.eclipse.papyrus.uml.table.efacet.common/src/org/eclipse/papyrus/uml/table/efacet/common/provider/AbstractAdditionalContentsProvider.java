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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.provider;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.TableContentsUtils;


/**
 * 
 * This class is used for additional contents providers
 * 
 */
public abstract class AbstractAdditionalContentsProvider {

	/**
	 * The managed Papyrus Table
	 */
	protected PapyrusTable pTable;

	/**
	 * the contents of the table
	 */
	protected Collection<EObject> tableContents;

	/**
	 * 
	 * the managed Papyrus Table
	 */
	public void setPapyrusTable(final PapyrusTable table) {
		this.pTable = table;
		this.tableContents = TableContentsUtils.getTableContents(pTable, pTable.getTable().getContext(), false);
	}

	/**
	 * 
	 * @return
	 *         the available facet set to display additional contents/columns
	 */
	public abstract Collection<FacetSet> getAdditionalFeatures();
}
