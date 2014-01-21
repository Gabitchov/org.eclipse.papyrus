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
package org.eclipse.papyrus.uml.table.common.provider;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.util.TableContentsUtils;


/**
 * 
 * This class is used for additional contents providers
 * 
 */
public abstract class AbstractAdditionalContentsProvider {

	/**
	 * The managed Papyrus Table
	 */
	protected PapyrusTableInstance pTable;

	/**
	 * the contents of the table
	 */
	protected Collection<EObject> tableContents;

	/**
	 * 
	 * the managed Papyrus Table
	 */
	public void setPapyrusTable(final PapyrusTableInstance table) {
		this.pTable = table;
		this.tableContents = TableContentsUtils.getTableContents(table, table.getTable().getContext(), false);
	}

	/**
	 * 
	 * @return
	 *         the available facet set to display additional contents/columns
	 */
	public abstract Collection<FacetSet> getAdditionalFeatures();
}
