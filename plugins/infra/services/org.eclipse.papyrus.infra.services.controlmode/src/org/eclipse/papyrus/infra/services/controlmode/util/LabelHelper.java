/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * General label helper
 * @author adaussy
 *
 */
public class LabelHelper {

	protected static ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/**
	 * Return an user understandable label for an {@link EObject}
	 * 
	 * @param eObject
	 * @return
	 */
	public static String getPrettyLabel(EObject eObject) {
		IItemLabelProvider itemLavelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
		if(itemLavelProvider != null) {
			return itemLavelProvider.getText(eObject);
		}
		return "Error in getting correct label";
	}


}
