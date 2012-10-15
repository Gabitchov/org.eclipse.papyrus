/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * 
 * This factory allows to get an EObject from an EditPart
 * It is useful in the plugin.xml
 * 
 * handler
 * activeWhen
 * with
 * selection
 * iterate
 * adapt to EObject
 * 
 * -> The handler is active when the selection can be adapted to EObject
 * 
 * It is useful for action active on the EditPart in the Diagrams
 * 
 */
public class EditPartAdapterFactory implements IAdapterFactory {


	/**
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 * 
	 * @param adaptableObject
	 * @param adapterType
	 * @return
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adaptableObject instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)adaptableObject).resolveSemanticElement();
		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 * 
	 * @return
	 */
	public Class<?>[] getAdapterList() {
		return new Class[]{ EObject.class };
	}

}
