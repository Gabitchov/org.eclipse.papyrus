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
package org.eclipse.papyrus.modelexplorer.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.modelexplorer.provider.ReferencingLabelProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IOpenable;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This handler allows to Open Diagrams and Tables
 * 
 * 
 * 
 */
public class OpenHandler extends AbstractModelExplorerHandler implements IExecutableExtension {


	private static final String PARAMETER_DISPLAY_REFERENCES = "org.eclipse.papyrus.modelexplorer.openreferences";

	/** parameters for this action */
	/**
	 * close all open elements
	 */
	public static final String PARAMETER_CLOSE = "close"; //$NON-NLS-1$

	/**
	 * Close only the selected elements
	 */
	public static final String PARAMETER_ALREADY_OPEN = "already_open"; //$NON-NLS-1$


	/** parameter ID */
	protected String parameterID = "open_parameter"; //$NON-NLS-1$

	/** parameter for this handler */
	protected String parameter = null;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IPageMngr pageMngr = getPageManager();
		if(selection instanceof IStructuredSelection && pageMngr != null) {
			String parameter2 = event.getParameter(PARAMETER_DISPLAY_REFERENCES);
			if (parameter2 != null)
			{
				openSelectedElement(selection, pageMngr,Boolean.valueOf(parameter2));
			}
			else
			{
				openSelectedElement(selection, pageMngr);
			}
		}
		return null;
	}
	
	/**
	 * Open the selected page with the specified {@link IPageMngr}
	 * @param selection
	 * @param pageMngr
	 */
	@SuppressWarnings("restriction")
	public static void openSelectedElement(ISelection selection, IPageMngr pageMngr) {
		openSelectedElement(selection, pageMngr,false);
	}

	/**
	 * Open the selected page with the specified {@link IPageMngr}
	 * @param selection
	 * @param pageMngr
	 */
	@SuppressWarnings("restriction")
	public static void openSelectedElement(ISelection selection, IPageMngr pageMngr, boolean revealReferences) {
		IStructuredSelection structured = (IStructuredSelection)selection;
		Iterator<?> iter = structured.iterator();
		EObject first = null ;
		int i = 0 ;
		while(iter.hasNext()) {
			EObject select = getEObjectFromSelection(iter.next());
			if (i == 0) {
				first = select;
			}
			i ++ ;
			if (select != null){					
				/**
				 * Close the diagram if it was already open
				 */
				IOpenable adapter = getAdapter(select, IOpenable.class);
				open(pageMngr, adapter);
			}
		}
		if (revealReferences && i == 1 && first != null && getAdapter(first, IOpenable.class) == null)
		{
			Collection<Setting> usages = PapyrusEcoreUtils.getUsages(first);
			Predicate<Setting> p = new Predicate<Setting>() {

				public boolean apply(Setting arg0) {
					return arg0.getEObject() != null && getOpenableInHierarchy(arg0.getEObject()) != null;
				}
			};
			Function<EStructuralFeature.Setting, IOpenable> f = new Function<EStructuralFeature.Setting, IOpenable>() {

				public IOpenable apply(EStructuralFeature.Setting arg0) {
					return getOpenableInHierarchy(arg0.getEObject());
				}

				
			};
			final ArrayList<IOpenable> list = Lists.newArrayList(Iterables.transform(Iterables.filter(usages, p), f));
			IOpenable selected = null ;
			if (list.isEmpty())
			{
				new NotificationBuilder()
					.setAsynchronous(true)
					.setType(Type.INFO)
					.setDelay(2000)
					.setTemporary(true)
					.setMessage(String.format("The element <%s> is not referenced in any diagram", new ReflectiveItemProvider(new ReflectiveItemProviderAdapterFactory()).getText(first)))
					.run();
			}
			else if (list.size() == 1)
			{
				selected = list.iterator().next();
			}
			else if (list.size() > 1)
			{
				ListDialog dialog = new ListDialog(Display.getDefault().getActiveShell());
				dialog.setContentProvider(new ArrayContentProvider());
				
				dialog.setLabelProvider(new ReferencingLabelProvider());
				dialog.setAddCancelButton(true);
				dialog.setTitle("Element Selection");
				dialog.setMessage("This element is visible in several diagrams\nPlease choose the diagram to display :");
				dialog.setInput(new CustomizableModelContentProvider(Activator.getDefault().getCustomizationManager())
				{

					@Override
					public Object[] getRootElements(Object inputElement) {
						return Lists.newArrayList(Iterables.transform(list, new Function<IOpenable, Object>() {
							public Object apply(IOpenable arg0) {
								return arg0.getPageIdentifier();
							}
						})).toArray();
					}
					
				}.getElements(null));
				if (dialog.open() == ListDialog.OK)
				{
					if (dialog.getResult().length > 0)
					{
						Object o = dialog.getResult()[0];
						EObject e = getAdapter(o, EObject.class);
						if (e != null){
							selected = new IOpenable.Openable(e);
						}
					}
				}
			}
			if (selected != null)
			{
				open(pageMngr, selected);
			}
		}
	}

	/**
	 * Browse the hierarchy of the parameter to return an {@link IOpenable}
	 * @param arg0
	 * @return
	 */
	private static IOpenable getOpenableInHierarchy(EObject arg0) {
		EObject i = arg0.eContainer();
		IOpenable adapter = i != null ? getAdapter(i, IOpenable.class) : null ;
		while (i != null && adapter == null)
		{
			i = i.eContainer();
			if (i != null)
			{
				adapter = getAdapter(i, IOpenable.class);
			}
			else
			{
				adapter = null ;
			}
		}
		return  adapter ;
	}
	
	private static void open(IPageMngr pageMngr, IOpenable adapter) {
		if (adapter != null)
		{
			if(pageMngr.isOpen(adapter.getPageIdentifier())) {
				pageMngr.closePage(adapter.getPageIdentifier());
			}
			pageMngr.openPage(adapter.getPageIdentifier());
		}
	}
	
	public static <T> T getAdapter (Object object, Class<T> toAdapt)
	{
		return NavigatorUtils.getElement(object, toAdapt);
	}
	
	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		IPageMngr pageMngr = getPageManager();
		if(pageMngr != null) {
			IStructuredSelection selection = getSelectedElement();
			Iterator<?> iter = selection.iterator();
			if(selection != null) {
				if(PARAMETER_CLOSE.equals(this.parameter)) {
					while(iter.hasNext()) {
						if(pageMngr.isOpen(iter.next())) {
							return false;
						}
					}
					return true;
				} else if(PARAMETER_ALREADY_OPEN.equals(this.parameter)) {
					while(iter.hasNext()) {
						if(pageMngr.isOpen(iter.next())) {
							return true;
						}
					}
					return false;
				} else if (PARAMETER_DISPLAY_REFERENCES.equals(this.parameter)) {
					while(iter.hasNext()) {
						Object o = iter.next();
						if(getAdapter(o, EObject.class) != null && getAdapter(o,IOpenable.class) == null) {
							return true;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String,
	 *      java.lang.Object)
	 * 
	 * @param config
	 * @param propertyName
	 * @param data
	 * @throws CoreException
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		if(data instanceof Hashtable && this.parameterID != null) {
			this.parameter = (String)((Hashtable)data).get(this.parameterID);
		}
	}

	/**
	 * Returns the selected elements
	 * 
	 * @return
	 *         the selected elements
	 */
	protected IStructuredSelection getSelectedElement() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			return (IStructuredSelection)selection;
		}
		return null;
	}




}
