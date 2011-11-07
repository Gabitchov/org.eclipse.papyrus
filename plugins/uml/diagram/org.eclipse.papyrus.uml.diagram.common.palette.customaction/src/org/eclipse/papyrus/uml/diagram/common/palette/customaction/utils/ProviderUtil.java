/*****************************************************************************
 * Copyright (c) 2011 AtoS.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (AtoS) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;

/**
 * Utility methods for provider
 * @author tfaure
 *
 */
public class ProviderUtil {
	
	/**
	 * Return the label of the eobject
	 * @param eobject
	 * @return
	 */
	public static String getLabel (EObject eobject)
	{
		return new ReflectiveItemProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getText(eobject);
	}
}
