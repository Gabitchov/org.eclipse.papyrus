/*****************************************************************************
 * Copyright (c) 2011, 2014 AtoS, CEA, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (AtoS) tristan.faure@atos.net - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 410346
 *  
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
		// FIXME: The reflective provider doesn't use the factory to get item labels. If that was intended, it will not work. This will only provide generic labels
		ComposedAdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		ReflectiveItemProvider provider = new ReflectiveItemProvider(factory);
		try {
			return provider.getText(eobject);
		} finally {
			// We created these, so we must dispose them
			provider.dispose();
			factory.dispose();
		}
	}
}
