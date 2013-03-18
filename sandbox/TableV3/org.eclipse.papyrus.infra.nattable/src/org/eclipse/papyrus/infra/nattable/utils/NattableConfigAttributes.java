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

import org.eclipse.nebula.widgets.nattable.style.ConfigAttribute;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * This class references the keys registered in the ConfigRegistry of the table to facilitate access to these objects
 * 
 * @author Vincent Lorenzo
 * 
 */
public class NattableConfigAttributes {

	private NattableConfigAttributes() {
		//to prevent instaciantionF
	}

	/**
	 * The config attribute used to register the table model manager
	 * 
	 * <ul>
	 * <li>To store it :
	 * <code> configRegistry.registerConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, YOUR_NATTABLE_MODEL_MANAGER, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);</code>
	 * </li>
	 * <li>To get it : <code></code></li>
	 * </ul>
	 */
	public static final ConfigAttribute<INattableModelManager> NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE = new ConfigAttribute<INattableModelManager>();//FIXME : try to create a new interface to limit the access of the method

	/**
	 * The config attribute used to register the label provider service
	 * 
	 * <ul>
	 * <li>To store it :
	 * <code> configRegistry.registerConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, YOUR_LABEL_PROVER_SERVICE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);</code>
	 * </li>
	 * <li>To get it : <code></code></li>
	 * 		LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
	 * </ul>
	 */
	public static final ConfigAttribute<LabelProviderService> LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE = new ConfigAttribute<LabelProviderService>();

	/**
	 * Id used to register the label provider service
	 */
	public static final String LABEL_PROVIDER_SERVICE_ID = "label_provider_service_id";

	/**
	 * Id used to registrer the table model manager
	 */
	public static final String NATTABLE_MODEL_MANAGER_ID = "nattable_model_manager_id";
}
