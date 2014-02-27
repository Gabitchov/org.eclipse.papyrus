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
package org.eclipse.papyrus.views.modelexplorer.provider;

import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForSelection;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This class provides test called by the plugin.xml in order to know if handlers should be active or not.
 *
 * Sometimes these test can be done directly in the plugin.xml in the activeWhen (with instanceof, adapt, ...),
 * but in this case, Eclipse doesn't refresh correctly the status of the command in the menu Edit or in other menu.
 *
 *
 *
 */
public class PropertyTester extends org.eclipse.core.expressions.PropertyTester {

	/** property to test if the selected elements is an eObject */
	public static final String IS_EOBJECT = "isEObject"; //$NON-NLS-1$

	/** property to test if the current activePart is the ModelExplorer */
	public static final String IS_MODEL_EXPLORER = "isModelExplorer"; //$NON-NLS-1$

	/** indicate if the element can be open in a tab */
	public static final String IS_PAGE = "isPage";//$NON-NLS-1$

	/**
	 *
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 *
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(IS_EOBJECT.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isObject((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		if(IS_MODEL_EXPLORER.equals(property) && receiver instanceof IWorkbenchPart) {
			boolean answer = isModelExplorer((IWorkbenchPart)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		if(IS_PAGE.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isPage((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		return false;
	}

	/**
	 *
	 * @param selection
	 *        the current selection
	 * @return
	 *         <code>true</code> if all selected elements are pages
	 */
	private boolean isPage(IStructuredSelection selection) {
		IPageManager pageManager = getPageManager(selection);
		if(pageManager != null) {
			if(!selection.isEmpty()) {
				Iterator<?> iter = selection.iterator();
				while(iter.hasNext()) {
					EObject current = EMFHelper.getEObject(iter.next());
					if(!isPage(current, pageManager)) {
						return false;
					}
				}

				return true;
			}
		}
		return false;
	}

	protected boolean isPage(EObject element, IPageManager pageManager) {
		if(element == null) {
			return false;
		}

		if(pageManager.allPages().contains(element)) {
			return true;
		}

		Object openable = Platform.getAdapterManager().getAdapter(element, IOpenable.class);
		return openable instanceof IOpenable;
	}

	/**
	 * Returns the page manager
	 *
	 * @return
	 *         the page manager
	 */
	protected IPageManager getPageManager(IStructuredSelection selection) {
		IPageManager pageMngr = null;
		try {
			ServiceUtilsForSelection instance = ServiceUtilsForSelection.getInstance();
			if(instance != null) {
				pageMngr = instance.getIPageManager(selection);
			}
		} catch (NullPointerException npe) {
			//We cannot find the page manager. Just return null.
		} catch (ServiceException e) {
			//We cannot find the page manager. Just return null.
		}
		return pageMngr;
	}

	/**
	 * Tests if the current activePart is the Model Explorer
	 *
	 * @param receiver
	 * @return
	 */
	private boolean isModelExplorer(IWorkbenchPart receiver) {
		return receiver instanceof ModelExplorerPageBookView;
	}

	/**
	 * Tests if all elements in the selection are EObject
	 *
	 * @param selection
	 * @return
	 */
	private boolean isObject(IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				EObject current = EMFHelper.getEObject(iter.next());
				return current != null;
			}
		}
		return false;
	}


}
