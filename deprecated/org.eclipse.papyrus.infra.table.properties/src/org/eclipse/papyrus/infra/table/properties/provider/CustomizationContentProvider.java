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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.papyrus.infra.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.table.properties.modelelement.PapyrusTableModelElement;

/**
 * 
 * The content provider for the MetamodelView
 * 
 */
public class CustomizationContentProvider extends SemanticEMFContentProvider {

	/**
	 * the table instance
	 */
	private final TableInstance2 source;

	/**
	 * the preference
	 */
	private final int preference;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param feature
	 *        the feature
	 * @param eObject
	 *        the eobject
	 * @param pref
	 *        the preference : it allows to display to choose how to display the local customization :
	 *        <ul>
	 *        <li>all customization</li>
	 *        <li>one customization</li>
	 *        <li>no customization</li>
	 *        </ul>
	 */
	public CustomizationContentProvider(final EStructuralFeature feature, final EObject eObject, final int pref) {
		super(eObject, feature);
		preference = pref;
		Assert.isTrue(eObject instanceof TableInstance2);
		source = (TableInstance2)eObject;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.providers.EcoreReferenceContentProvider#getElements()
	 * 
	 * @return
	 */
	@Override
	public Object[] getElements() {
		Object[] elements = new Object[0];
		List<MetamodelView> allCustom = new ArrayList<MetamodelView>();
		allCustom.addAll(source.getCustomizations());
		List<MetamodelView> allLocalCustom = new ArrayList<MetamodelView>();
		allLocalCustom.addAll(source.getLocalCustomizations());
		switch(preference) {
		case PapyrusTableModelElement.NO_LOCALS:
			allCustom.removeAll(allLocalCustom);
			elements = allCustom.toArray();
			break;
		case PapyrusTableModelElement.ONLY_ONE_LOCALS:
			allLocalCustom.remove(0);
			allCustom.removeAll(allLocalCustom);
			elements = allCustom.toArray();
			break;
		case PapyrusTableModelElement.ALL_LOCALS:
			elements = allCustom.toArray();
			break;
		default:
			break;
		}
		return elements;
	}

}
