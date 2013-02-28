/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration - CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atos.net - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.providers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.internal.navigator.resources.actions.EditActionProvider;


/**
 * An edit action provider to provide Copy/Paste/Delete on sub resources
 * 
 * @author Tristan Faure
 * 
 */
@SuppressWarnings("restriction")
public class SubresourceFileActionProvider extends EditActionProvider {

	@Override
	public void setContext(ActionContext context) {
		// TODO Auto-generated method stub
		List<Object> resources = new LinkedList<Object>();
		if(context.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection contextSelec = (IStructuredSelection)context.getSelection();
			for(Iterator<?> i = contextSelec.iterator(); i.hasNext();) {
				Object o = i.next();
				IResource res = adapt(o, IResource.class);
				if(res != null) {
					resources.add(res);
				}
			}
		}
		if(!resources.isEmpty()) {
			ISelection selec = new StructuredSelection(resources);
			super.setContext(new ActionContext(selec));
		} else {
			super.setContext(context);
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T adapt(Object o, Class<T> aClass) {
		T result = null;
		if(aClass.isInstance(o)) {
			result = (T)o;
		}
		if(o instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)o;
			result = (T)adaptable.getAdapter(aClass);
		}
		if(result == null) {
			result = (T)Platform.getAdapterManager().getAdapter(o, aClass);
		}

		return result;
	}

}
