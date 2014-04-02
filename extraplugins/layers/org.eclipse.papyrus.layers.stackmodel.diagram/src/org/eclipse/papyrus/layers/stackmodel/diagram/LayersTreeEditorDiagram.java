/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.diagram;

import java.util.EventObject;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.presentation.LayersEditor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * This is an example of a EMF UML model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class LayersTreeEditorDiagram extends LayersEditor implements IEditingDomainProvider, ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker {

	/**
	 * ServiceRegistry used to retrieve needed services. This registry is provided by the multieditor.
	 */
	protected ServicesRegistry servicesRegistry;

	protected CommandStackListener commandStackListener;

	/**
	 * 
	 * Constructor. Create an DiEditor using the {@link ServicesRegistry}.
	 * 
	 * @param servicesRegistry
	 */
	public LayersTreeEditorDiagram(ServicesRegistry servicesRegistry) throws ServiceException, BackboneException {
		this.servicesRegistry = servicesRegistry;
		initEditor();
	}

	/**
	 * Init the editor from the specified context.
	 * Set the editing domain used by the EMF editor.
	 * 
	 * @param editorContext
	 * @throws ServiceException
	 */
	private void initEditor() throws ServiceException {

		TransactionalEditingDomain papyrusEditingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);
		CommandStack commandStack = papyrusEditingDomain.getCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of
		// the viewer with focus.
		//

		commandStackListener = new CommandStackListener() {

			/**
			 * called when command stack has changed
			 * @see org.eclipse.emf.common.command.CommandStackListener#commandStackChanged(java.util.EventObject)
			 *
			 * @param event
			 */
			public void commandStackChanged(final EventObject event) {
				if(getContainer().isDisposed()) {
					return;
				}
				getContainer().getDisplay().asyncExec(new Runnable() {

					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);

						// Try to select the affected objects.
						//
						Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
						if(mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
						
						for (Iterator<PropertySheetPage> i = propertySheetPages.iterator(); i.hasNext();) {

							PropertySheetPage propertySheetPage = i.next();

							if ((propertySheetPage.getControl() == null)
								|| propertySheetPage.getControl().isDisposed()) {
								
								i.remove();
							} else {
								propertySheetPage.refresh();
							}
						}
					}
				});
			}

		};

		commandStack.addCommandStackListener(commandStackListener);

		// Create the editing domain with a special command stack.
		//
		// Set the resourceSet wth our own resourceSet.
		// editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new
		// HashMap<Resource, Boolean>());

		ResourceSet resourceSet = papyrusEditingDomain.getResourceSet();
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, resourceSet);

		// editingDomain = editorContext.getTransactionalEditingDomain();
		// editingDomain.setResourceToReadOnlyMap(new HashMap<Resource, Boolean>());
	}

	/**
	 * This is the method called to load a resource into the editing domain's resource set based on
	 * the editor's input. Put the existing model into the editingDomain. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void createModel() {
		// model is already created and loaded. Do nothing.
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model file. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
	}

	/**
	 * This also changes the editor's input. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void doSaveAs() {
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
	}

	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		super.init(site, editorInput);
		setPartName("Layers Editor");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IActionBars getActionBars() {
		try {
			return getActionBarContributor().getActionBars();
		} catch (NullPointerException e) {
			// If we are nested, we have not access to ActionBarContributor()
			return null;
		}
	}

	@Override
	public void dispose() {
		//super.dispose(); //FIXME: Fails on a ClassCastException: The ActionBarContributor is not accessible
		try {
			TransactionalEditingDomain papyrusEditingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);
			CommandStack commandStack = papyrusEditingDomain.getCommandStack();
			commandStack.removeCommandStackListener(commandStackListener);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Has we have no actionBarContributor, we can't get the status line. So skip this method.
	 */
	@Override
	public void setStatusLineManager(ISelection selection) {

	}

	/**
	 * Disable the native property sheet page.
	 */
	@Override
	public IPropertySheetPage getPropertySheetPage() {

//		return null;
		return super.getPropertySheetPage();
	}
	
	protected DynamicContextMenu dynamicContextMenu;
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {

		if( dynamicContextMenu == null) {
			dynamicContextMenu = new DynamicContextMenu(this);
		}
		dynamicContextMenu.menuAboutToShow(menuManager);
	}
}
