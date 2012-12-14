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
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;


public class PapyrusTableUtils {

	private PapyrusTableUtils() {
		//to prevent instanciation
	}

	/**
	 * Gets the all the papyrus table contained in the specified ancestor eObject
	 * 
	 * @param resource
	 * @param eObject
	 * 
	 * @return all the contained papyrusTable
	 * 
	 */
	public static List<PapyrusTable> getPapyrusTable(final Resource resource, final EObject context) {
		final List<PapyrusTable> allPapyrusTables = new LinkedList<PapyrusTable>();
		if(resource != null) {
			for(final EObject obj : resource.getContents()) {
				if(obj instanceof PapyrusTable) {
					final PapyrusTable pTable = (PapyrusTable)obj;
					if(EcoreUtil.isAncestor(context, pTable.getTable().getContext())) {
						allPapyrusTables.add(pTable);
					}
				}
			}
		}
		return allPapyrusTables;
	}
}
