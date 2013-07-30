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
package org.eclipse.papyrus.infra.services.edit.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.Activator;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;

/**
 * Utils class for elements types
 * 
 * @author VL222926
 * 
 */
public class ElementTypeUtils {


	private ElementTypeUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @return
	 *         all existing elements types
	 */
	public static final Collection<IElementType> getAllExistingElementTypes() {
		IClientContext clientContext = null;
		try {
			clientContext = TypeContext.getContext();
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		final IElementType[] types = ElementTypeRegistry.getInstance().getElementTypes(clientContext);
		return Arrays.asList(types);
	}

	/**
	 * @return
	 *         all existing element type id, sorted by alphabetical order
	 */
	public static final Collection<String> getAllExistingElementTypesIds() {
		final Collection<String> ids = new TreeSet<String>();
		for(final IElementType iElementType : getAllExistingElementTypes()) {
			ids.add(iElementType.getId());
		}
		return ids;
	}
}
