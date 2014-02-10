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
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.SpecializationTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.internal.impl.SpecializationTypeRegistry;


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
	
	
//	public static void unload(String identifier) {
//		// retrieve the extended type set with given identifier and unloads it
//		ExtendedElementTypeSet set = ExtendedElementTypeSetRegistry.getInstance().getExtendedTypeSets().get(identifier);
//		if(set!=null) {
//			unload(set);
//		} 
//	}
	
//	/**
//	 * Unloads a given {@link ExtendedElementTypeSet}
//	 * @param elementTypeSet the element type set to unload
//	 */
//	public static void unload(ExtendedElementTypeSet elementTypeSet) {
//		// retrieve the specializationTypeRegistry to remove all contribution from the given element type set
//		Field declaredField = null;
//		try {
//			declaredField = ElementTypeRegistry.class.getDeclaredField("specializationTypeRegistry");
//		} catch (SecurityException e1) {
//			Activator.log.error(e1);
//			return;
//		} catch (NoSuchFieldException e1) {
//			Activator.log.error(e1);
//			return;
//		}
//		if(declaredField==null) {
//			Activator.log.error("impossible to find specializationTypeRegistry", null);
//			return;
//		}
//		declaredField.setAccessible(true);
//		SpecializationTypeRegistry registry = null;
//		try {
//			registry = (SpecializationTypeRegistry)declaredField.get(ElementTypeRegistry.getInstance());
//		} catch (IllegalArgumentException e) {
//			Activator.log.error(e);
//		} catch (IllegalAccessException e) {
//			Activator.log.error(e);
//		}
//		
//		if(registry == null) {
//			return;
//		}
//		
//		for(ElementTypeConfiguration configuration : elementTypeSet.getElementType()) {
//			if(configuration!=null && configuration.getIdentifier()!=null) {
//				String identifier = configuration.getIdentifier();
//				// retrieve descriptor
//				SpecializationTypeDescriptor descriptor = registry.getSpecializationTypeDescriptor(identifier);
//				if(descriptor!=null) {
//					registry.removeSpecializationType(descriptor);
//				}
//			}
//		}
//		
//		elementTypeSet.eResource().unload();
//		elementTypeSet.eResource().getResourceSet().getResources().remove(elementTypeSet.eResource());
//	}
	
//	public static void resetRegistry() {
//		// FIXME save the current listeners, to add them back to the registry
//		IClientContext context;
//		try {
//			context = TypeContext.getContext();
//		} catch (ServiceException e1) {
//			Activator.log.error(e1);
//			return;
//		}
//		// impossibe to unregister element types...
//		// => destroy the singleton instance of the registry...
//		try {
//			Field declaredField = ElementTypeRegistry.class.getDeclaredField("INSTANCE");
//			declaredField.setAccessible(true);
//			declaredField.set(null, null);
//		} catch (SecurityException e1) {
//			e1.printStackTrace();
//		} catch (NoSuchFieldException e1) {
//			e1.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		
//		// create the registry
//		ElementTypeRegistry.getInstance();
//	}
	
}