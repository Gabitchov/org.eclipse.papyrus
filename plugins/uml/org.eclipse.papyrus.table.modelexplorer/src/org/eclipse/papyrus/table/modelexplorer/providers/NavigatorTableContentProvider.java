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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.resource.uml.UmlUtils;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.uml2.uml.util.UMLUtil;

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
	public boolean hasChildren(final Object element) {
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
	private List<PapyrusTableInstance> findAllExistingPapyrusTables(final EObject owner) {
		ArrayList<PapyrusTableInstance> tables = new ArrayList<PapyrusTableInstance>();



		if(this.pageMngr != null) {

			// Walk on page (Table) references
			for(Object page : this.pageMngr.allPages()) {
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

	/**
	 * Return the initial values from the input.
	 * Input should be of type {@link UmlModel}.
	 * 
	 * @see org.eclipse.gmt.modisco.infra.browser.uicore.CustomizableModelContentProvider#getRootElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	//TODO : we should use a customization on the model explorer to hide the Stereotype Application
	@Override
	protected EObject[] getRootElements(final ModelSet modelSet) {
		UmlModel umlModel = (UmlUtils.getUmlModel(modelSet));

		if(umlModel == null) {
			return null;
		}

		EList<EObject> contents = umlModel.getResource().getContents();
		ArrayList<EObject> result = new ArrayList<EObject>();
		Iterator<EObject> iterator = contents.iterator();
		while(iterator.hasNext()) {
			EObject eObject = iterator.next();
			//functionality that comes from UML2 plugins
			if(UMLUtil.getStereotype(eObject) == null) {
				result.add(eObject);
			}
		}
		return result.toArray(new EObject[result.size()]);
	}


}
