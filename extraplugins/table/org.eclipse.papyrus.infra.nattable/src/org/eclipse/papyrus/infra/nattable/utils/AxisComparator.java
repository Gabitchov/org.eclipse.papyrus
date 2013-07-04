/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.utils;

import java.util.Comparator;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;


/**
 * The comparator used to sort IAxis
 * 
 * @author Vincent Lorenzo
 * 
 */
public class AxisComparator implements Comparator<IAxis> {

	/**
	 * indicates the direction of the sort
	 */
	private boolean alphabeticOrder;

	/**
	 * the config registry is used to find the label provider service
	 */
	private IConfigRegistry configRegistry;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param alphabeticOrder
	 *        indicates the direction of the sort
	 * @param configRegistry
	 *        the config registry used by the table
	 */
	public AxisComparator(boolean alphabticOrder, final IConfigRegistry configRegistry) {
		this.alphabeticOrder = alphabticOrder;
		this.configRegistry = configRegistry;
	}

	/**
	 * Compare 2 {@link IAxis}
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public int compare(IAxis arg0, IAxis arg1) {
		LabelProviderService serv = this.configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		Object element0 = arg0.getElement();
		Object element1 = arg1.getElement();
		final String str1 = getText(serv, element0).replaceAll(AxisUtils.REGEX, "");//we keep only words characters (letters + numbers) + whitespace
		final String str2 = getText(serv, element1).replaceAll(AxisUtils.REGEX, "");
		if(this.alphabeticOrder) {
			return str1.compareToIgnoreCase(str2);
		}
		return str2.compareToIgnoreCase(str1);

	}

	/**
	 * 
	 * @param serv
	 *        the label provider service
	 * @param obj
	 *        the object for which we want the displayed text
	 * @return
	 */
	protected String getText(final LabelProviderService serv, final Object obj) {
		final ILabelProvider provider = serv.getLabelProvider(Constants.HEADER_LABEL_PROVIDER_CONTEXT);
		return provider.getText(new LabelProviderContextElementWrapper(obj, this.configRegistry));
	}
}
