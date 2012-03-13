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
package org.eclipse.papyrus.modelexplorer.provider;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IOpenable;
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

	/** property to test if the selected element are open in the editor */
	public static final String IS_DIAGRAM = "isDiagram"; //$NON-NLS-1$

	/** property to test if the selected elements is an eObject */
	public static final String IS_EOBJECT = "isEObject"; //$NON-NLS-1$

	/** property to test if the current activePart is the ModelExplorer */
	public static final String IS_MODEL_EXPLORER = "isModelExplorer"; //$NON-NLS-1$
	
	public static final String IS_OPENABLE = "isOpenable";
	

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
		if(IS_DIAGRAM.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isDiagram((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
		if(IS_OPENABLE.equals(property) && receiver instanceof IStructuredSelection) {
			boolean answer = isOpenable((IStructuredSelection)receiver);
			return new Boolean(answer).equals(expectedValue);
		}
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

	private boolean isOpenable(IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				/**
				 * Set to use the IAdaptable mechanism
				 * Used for example for facet elements
				 */
				final Object next = iter.next();
				EObject nextE = null ;
				if (next instanceof EObject)
				{
					nextE = (EObject)next ;
				}
				if (nextE == null && next != null)
				{
					nextE = getAdapter(next, EObject.class);
				}
				if (nextE == null || getAdapter(nextE, IOpenable.class) == null)
				{
					return false ;
				}
			}
			return true;
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
		IPageMngr pageMngr = getPageManager();
		if(pageMngr != null) {
			if(!selection.isEmpty()) {
				Iterator<?> iter = selection.iterator();
				while(iter.hasNext()) {
					Object current = iter.next();
					if(current instanceof IAdaptable) {
						EObject eObject = (EObject)((IAdaptable)current).getAdapter(EObject.class);
						if(!pageMngr.allPages().contains(eObject)) {
							return false;
						}
					} else if(!pageMngr.allPages().contains(current)) {//table of diagram!
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the page manager
	 * 
	 * @return
	 *         the page manager
	 */
	protected IPageMngr getPageManager() {
		IPageMngr pageMngr = null;
		try {
			ServiceUtilsForActionHandlers instance = org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers.getInstance();
			if(instance != null) {
				pageMngr = instance.getIPageMngr();
			}
		} catch (NullPointerException npe) {
			//NPE
		} catch (ServiceException e) {
			//we are closing the editor, so the model explorer has nothing to display
			//			e.printStackTrace();
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
				Object current = iter.next();
				if(!(current instanceof EObject)) {
					if (getAdapter(current, EObject.class) == null){
						return false ;
					}
				}
			}
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Object o, Class<? extends T> toAdapt) {
		T result = null;
		if(o instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)o;
			result = (T)adaptable.getAdapter(toAdapt);
		}
		if(result == null) {
			result = (T)Platform.getAdapterManager().getAdapter(o, toAdapt);
		}
		return result ;
	}

	/**
	 * Tests the selection in order to know if it contains only {@link Diagram}
	 * 
	 * @param selection
	 * @return
	 *         <code>true</code> if the selection is composed by {@link Diagram}
	 * 
	 *         FIXME : we should call the method isDiagram in
	 *         oep.diagram.common#DiagramPropertyTester
	 */
	private boolean isDiagram(IStructuredSelection selection) {
		if(!selection.isEmpty()) {
			Iterator<?> iter = selection.iterator();
			while(iter.hasNext()) {
				/**
				 * Set to use the IAdaptable mechanism
				 * Used for example for facet elements
				 */
				final Object next = iter.next();
				EObject diag = NavigatorUtils.getElement(next, EObject.class);
				if(!(diag instanceof Diagram)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
