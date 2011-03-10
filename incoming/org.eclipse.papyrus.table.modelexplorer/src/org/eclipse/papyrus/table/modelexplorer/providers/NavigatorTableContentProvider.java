/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.table.modelexplorer.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance;

/**
 * This class provides a NavigatorContentProvider used to display tables in the Model Explorer
 * 
 * 
 * 
 */
public class NavigatorTableContentProvider extends MoDiscoContentProvider {


	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		ArrayList<Object> result = new ArrayList<Object>();

		/**
		 * We look for diagrams and tables
		 */
		if(parentElement instanceof IAdaptable) {
			EObject eObject = (EObject)((IAdaptable)parentElement).getAdapter(EObject.class);
			if(eObject != null) {
				List<PapyrusTableInstance> tableList = findAllExistingPapyrusTables(eObject);
				Iterator<PapyrusTableInstance> iter = tableList.iterator();
				while(iter.hasNext()) {
					result.add(iter.next());
				}
			}
		}
		return result.toArray();
	}

	/**
	 * @param owner
	 *        the owner of the tables
	 * @return the list of tables contained by the given owner
	 */
	private List<PapyrusTableInstance> findAllExistingPapyrusTables(EObject owner) {
		ArrayList<PapyrusTableInstance> tables = new ArrayList<PapyrusTableInstance>();



		if(pageMngr != null) {

			// Walk on page (Table) references
			for(Object page : pageMngr.allPages()) {
				if(!(page instanceof PapyrusTableInstance)) {
					continue;
				}
				// We have a Table
				PapyrusTableInstance papyrusTable = (PapyrusTableInstance)page;
				if(owner.equals(papyrusTable.getTable().getContext())) {
					tables.add(papyrusTable);
				}

			}
		}
		return tables;
	}


}
