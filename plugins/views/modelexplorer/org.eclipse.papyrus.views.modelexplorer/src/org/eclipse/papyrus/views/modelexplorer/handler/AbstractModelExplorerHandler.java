/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This provides facilities to get the TransactionEditingDomain and the PageManager from the Model Explorer
 * 
 * 
 * 
 */
public abstract class AbstractModelExplorerHandler extends AbstractHandler {

	/**
	 * Returns the
	 * 
	 * @return
	 *         the current editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		TransactionalEditingDomain editingDomain = null;
		try {
			editingDomain = org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
		} catch (ServiceException e) {
			//we are closing the editor, so the model explorer has nothing to display
			//			e.printStackTrace();
		}
		return editingDomain;
	}

	/**
	 * Returns the page manager
	 * 
	 * @return
	 *         the page manager
	 */
	protected IPageManager getPageManager() {
		IPageManager pageManager = null;
		try {
			pageManager = ServiceUtilsForActionHandlers.getInstance().getIPageManager();
		} catch (ServiceException e) {
			//we are closing the editor, so the model explorer has nothing to display
			//			e.printStackTrace();
		}
		return pageManager;
	}

	/**
	 * Adapt the specified object to the requested type, if possible.
	 * Return null if the object can't be adapted.
	 * 
	 * @param object
	 * @param expectedClassType
	 * @return The adapted object, or null.
	 */
	@SuppressWarnings("unchecked")
	private <T> T adapt(Object object, Class<T> expectedClassType) {

		if(object instanceof IAdaptable) {
			T ele = (T)((IAdaptable)object).getAdapter(expectedClassType);
			if(ele != null) {
				return ele;
			}
			// Try as EObject if the expectedClasType is sub-type of EObject.
			if(EObject.class.isAssignableFrom(expectedClassType)) {
				// to EObject
				EObject eobject = EMFHelper.getEObject(object);

				if(eobject != null && expectedClassType.isInstance(eobject)) {
					return (T)eobject;
				}
			}
		}

		// Try global mechanism
		{
			T ele = (T)Platform.getAdapterManager().getAdapter(object, expectedClassType);
			if(ele != null) {
				return ele;
			}
			// Try as EObject if the expectedClasType is sub-type of EObject.
			if(EObject.class.isAssignableFrom(expectedClassType)) {
				// to EObject
				EObject eobject = (EObject)Platform.getAdapterManager().getAdapter(object, EObject.class);

				if(eobject != null && expectedClassType.isInstance(eobject)) {

					return (T)eobject;
				}
			}
		}
		// Can't be adapted
		return null;

	}

	/**
	 * Filter the list, and only retain objects that can be adapted to the specified type
	 * 
	 * @param objects
	 * @param class1
	 * @return
	 */
	private <T> List<T> getAllElementAdaptedToType(List<Object> list, Class<T> expectedClassType) {

		List<T> res = new ArrayList<T>();

		for(Object cur : list) {

			T adapted = adapt(cur, expectedClassType);
			if(adapted != null) {
				res.add(adapted);
			}
		}
		return res;
	}

	/**
	 * Get all selected element of the specified type.
	 * 
	 * @param expectedType
	 * @return
	 * @throws ExecutionException
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> getCurrentSelectionAdaptedToType(ExecutionEvent event, Class<T> expectedType) throws ExecutionException {

		// Get selection from the workbench
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);

		// Get the selected objects according to the type of the selected
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return getAllElementAdaptedToType(structuredSelection.toList(), expectedType);
		} else if(selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection)selection;
			return getAllElementAdaptedToType(treeSelection.toList(), expectedType);

		}
		return null;
	}
}
