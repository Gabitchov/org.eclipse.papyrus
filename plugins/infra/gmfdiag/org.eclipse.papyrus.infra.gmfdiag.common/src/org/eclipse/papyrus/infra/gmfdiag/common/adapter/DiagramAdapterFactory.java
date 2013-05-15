/*****************************************************************************
 * Copyright (c) 2011 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE - tristan.faure@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenableWithContainer;

@SuppressWarnings("rawtypes")
public class DiagramAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == IOpenable.class) {
			if(adaptableObject instanceof Diagram) {
				Diagram diagram = (Diagram)adaptableObject;
				return new IOpenableWithContainer.Openable(adaptableObject, diagram.getElement());
			}
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[]{ IOpenable.class };
	}


}
