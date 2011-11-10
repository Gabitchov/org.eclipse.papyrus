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
package org.eclipse.papyrus.infra.table.properties.provider;

import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.table.properties.modelelement.PapyrusTableModelElement;

/**
 * 
 * LabelProvider for the MetamodelView
 * 
 */
public class CustomizationLabelProvider extends LabelProvider {

	/** the table instance*/
	private final TableInstance2 table;

	/** the preference : allows to manage the text displayed to represent the MetamodelView*/
	private final int preference;

	/**
	 * 
	 * Constructor.
	 *
	 * @param table
	 * the table instance
	 * @param pref
	 * the preference
	 */
	public CustomizationLabelProvider(final TableInstance2 table, final int pref) {
		preference = pref;
		this.table = table;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public String getText(final Object element) {
		final MetamodelView metamodelView = (MetamodelView) element;
		if(table.getLocalCustomizations().contains(metamodelView)){
			switch(preference){
			case PapyrusTableModelElement.NO_LOCALS : 
				//it is not possible
				return ""; //$NON-NLS-1$
			case PapyrusTableModelElement.ONLY_ONE_LOCALS : 
				 	return "localCustomizations"; //$NON-NLS-1$
			case PapyrusTableModelElement.ALL_LOCALS : 
				return "localCustomization" + " " + metamodelView.getMetamodelURI(); //$NON-NLS-1$ //$NON-NLS-2$
				default : 
					return metamodelView.getName();
			}
		}else{
			return metamodelView.getName();
		}
	}
}