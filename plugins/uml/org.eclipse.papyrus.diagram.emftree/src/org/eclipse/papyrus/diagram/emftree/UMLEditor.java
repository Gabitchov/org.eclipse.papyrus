/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.emftree;

import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.views.properties.IPropertySheetPage;

/**
 * This is an example of a EMF UML model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class UMLEditor extends org.eclipse.uml2.uml.editor.presentation.UMLEditor implements IEditingDomainProvider,
		ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker {

	/**
	 * Object shared between all Papyrus plugin.
	 */
	protected BackboneContext editorContext;

	/**
	 * 
	 * Constructor. Create an DiEditor using the {@link ServicesRegistry}.
	 * 
	 * @param servicesRegistry
	 */
	public UMLEditor(ServicesRegistry servicesRegistry) throws ServiceException, BackboneException {
		IEditorContextRegistry contextRegistry;
		contextRegistry = (IEditorContextRegistry) servicesRegistry.getService(IEditorContextRegistry.class);

		// Get the context by its ID
		BackboneContext editorContext = (BackboneContext) contextRegistry
				.getContext(BackboneContext.BACKBONE_CONTEXT_ID);

		initEditor(editorContext);
	}

	/**
	 * This creates a model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLEditor(BackboneContext editorContext) {
		super();

		initEditor(editorContext);

	}

	/**
	 * Init the editor from the specified context.
	 * 
	 * @param editorContext
	 */
	private void initEditor(BackboneContext editorContext) {
		CommandStack commandStack = editorContext.getTransactionalEditingDomain().getCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of
		// the viewer with focus.
		//
		commandStack.addCommandStackListener(new CommandStackListener() {

			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {

					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);

						// Try to select the affected objects.
						//
						Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
						if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
							propertySheetPage.refresh();
						}
					}
				});
			}

		});

		// Create the editing domain with a special command stack.
		//
		// Set the resourceSet wth our own resourceSet.
		// editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new
		// HashMap<Resource, Boolean>());

		ResourceSet resourceSet = editorContext.getResourceSet();
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
		System.out.println(this.getClass().getSimpleName() + ".init()");
		super.init(site, editorInput);
		setPartName("emf tree");
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

		return null;
	}
}
