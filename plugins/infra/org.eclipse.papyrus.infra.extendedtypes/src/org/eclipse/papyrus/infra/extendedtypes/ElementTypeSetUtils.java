/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import java.lang.reflect.Field;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;


/**
 * Utility class to manipulate {@link ExtendedElementTypeSet}.
 */
public class ElementTypeSetUtils {

	/**
	 * Loads
	 * @param extendedElementTypeSet
	 */
	public static void load(ExtendedElementTypeSet extendedElementTypeSet) {
		
	}
	
	/**
	 * Unloads a given {@link ExtendedElementTypeSet}
	 * @param elementTypeSet the element type set to unload
	 */
	public static void unload(ExtendedElementTypeSet elementTypeSet) {
		
	}
	
	public static void resetRegistry() {
		// FIXME save the current listeners, to add them back to the registry
		IClientContext context;
		try {
			context = TypeContext.getContext();
		} catch (ServiceException e1) {
			Activator.log.error(e1);
			return;
		}
		// impossibe to unregister element types...
		// => destroy the singleton instance of the registry...
		try {
			Field declaredField = ElementTypeRegistry.class.getDeclaredField("INSTANCE");
			declaredField.setAccessible(true);
			declaredField.set(null, null);
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// create the registry
		ElementTypeRegistry.getInstance();
	}
	
}