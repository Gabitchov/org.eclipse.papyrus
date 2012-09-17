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
 *  Cedric Dumoulin Cedric.Dumoulin@lifl.fr- Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.outline.emftree;

import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.contentoutline.IPapyrusContentOutlinePage;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.outline.emftree.internal.OutlineDragAdapter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * A Content outline based on the one generated from the DI2 metamodel. This ContentOutlinePage can
 * be used by the multi editor page.
 * 
 * @author dumoulin
 * 
 */
public class ContentOutline extends ContentOutlinePage implements IMenuListener, IPapyrusContentOutlinePage {

	/**
	 * This keeps track of the editing domain that is used to track all changes to the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * This is the content outline page's viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TreeViewer contentOutlineViewer;

	private IEditorSite editorSite;

	public ContentOutline() {
		super();
	};

	/**
	 * Constructor.
	 * 
	 * @param editorSite
	 * @param editingDomain
	 * @param adapterFactory
	 */
	public ContentOutline(IEditorSite editorSite, EditingDomain editingDomain, ComposedAdapterFactory adapterFactory) {
		super();
		this.editorSite = editorSite;
		this.editingDomain = editingDomain;
		this.adapterFactory = adapterFactory;
	}

	/**
	 * Constructor.
	 * 
	 * @param editorSite
	 * @param editingDomain
	 * @param adapterFactory
	 */
	public ContentOutline(IEditorSite editorSite, EditingDomain editingDomain) {
		super();
		this.editorSite = editorSite;
		this.editingDomain = editingDomain;
		initAdapterFactory();
	}

	/**
	 * Init the outline. This method is used by the MultiPageEditor to initialize the Outline.
	 * 
	 * @param multiEditor
	 * @param site
	 * @throws BackboneException
	 */
	public void init(IMultiDiagramEditor multiEditor) throws BackboneException {

		// Get the EditorActionBarContributor requested by this particular EMF editor.
		// The EditorActionBarContributor should be registered in extensions under the specified name
		//		String EditorActionBarContributorId = "DiActionBarContributor";
		//		EditorActionBarContributor actionBarContributor = multiEditor.getActionBarContributorRegistry().getActionBarContributor(EditorActionBarContributorId);
		//		IEditorSite site = new MultiPageAdapterSite(multiEditor.getEditorSite(), actionBarContributor);
		this.editorSite = multiEditor.getEditorSite();
		try {
			this.editingDomain = multiEditor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		} catch (ServiceException e) {
			throw new BackboneException("Can't get TransactionalEditingDomain", e);
		}
		initAdapterFactory();

	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);

		// Set up the tree viewer.
		//
		contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		contentOutlineViewer.setInput(editingDomain.getResourceSet());

		// Make sure our popups work.
		//
		createContextMenuFor(contentOutlineViewer);

		if(!editingDomain.getResourceSet().getResources().isEmpty()) {
			// Select the root object in the view.
			//
			contentOutlineViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
		}
		// initDragAndDrop();
	}

	/**
	 * Add drag and drop ability between the outline to the editor.
	 */
	protected void initDragAndDrop() {
		int ops = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		// Enable Drag
		OutlineDragAdapter dragAdapter = new OutlineDragAdapter(contentOutlineViewer);
		contentOutlineViewer.addDragSupport(ops, dragAdapter.getSupportedDragTransfers(), dragAdapter);
	}

	@Override
	public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
		super.makeContributions(menuManager, toolBarManager, statusLineManager);
		// contentOutlineStatusLineManager = statusLineManager;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
		if(getActionBarContributor() != null) {
			getActionBarContributor().shareGlobalActions(this, actionBars);
		}
	}

	private EditingDomainActionBarContributor getActionBarContributor() {
		if(editorSite.getActionBarContributor() instanceof EditingDomainActionBarContributor) {
			return (EditingDomainActionBarContributor)editorSite.getActionBarContributor();
		}
		return null;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well registering the menu
	 * for extension. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getEditorSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[]{ LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));

	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus
	 * with contributions from the Edit menu. <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener)getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	// private EditingDomainActionBarContributor getActionBarContributor() {
	// return (EditingDomainActionBarContributor)getEditorSite().getActionBarContributor();
	// }
	/**
	 * 
	 * @return
	 */
	private IEditorSite getEditorSite() {
		return editorSite;
	}

	/**
	 * 
	 */
	private void initAdapterFactory() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new UMLItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

	}

}
