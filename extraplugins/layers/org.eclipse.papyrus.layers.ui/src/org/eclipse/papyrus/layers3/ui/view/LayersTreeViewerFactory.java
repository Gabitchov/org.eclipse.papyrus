/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers3.ui.view;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.layers.stackmodel.layers.provider.custom.CustomLayersItemProviderAdapterFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;


/**
 * A utility class to create LayersTreeViewer suitable to render layers as a tree.
 * 
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class LayersTreeViewerFactory {

	/**
	 * ID used to register the context menu.
	 */
	static final String CONTEXT_MENU_ID = "org.eclipse.papyrus.layers.stackmodel.diagram.ui.contextmenu";

	/**
	 * Create a TreeViewer suitable to render Layers as a Tree.
	 * The content and label providers are set.
	 * The context menu is not set.
	 * 
	 * 
	 * @return
	 */
	static public TreeViewer createLayersTreeViewer(Composite parent, int style) {

		TreeViewer layersExplorerTree = new TreeViewer(parent, style);

		initContentAndLabelProviders(layersExplorerTree);

		return layersExplorerTree;
	}

	/**
	 * Set appropriate Content and Label providers for the LayersTreeViewer.
	 * @param layersExplorerTree
	 */
	protected static void initContentAndLabelProviders(TreeViewer layersExplorerTree) {
		// Set content and label providers
		AdapterFactory adapterFactory = createLayersTreeViewerItemProvidersFactory();
		layersExplorerTree.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		layersExplorerTree.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
	}

	/**
	 * Create an AdapterFactory suitable for the LayersTreeViewer.
	 * @return
	 */
	static public AdapterFactory createLayersTreeViewerItemProvidersFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
//		adapterFactory.addAdapterFactory(new LayersItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new CustomLayersItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new NotationItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well as registering the menu for extension.
	 * 
	 */
	static public void initContextMenuFor(IWorkbenchPartSite site, StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		//			contextMenu.addMenuListener(this);
		Menu menu= contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		//		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		//			getSite().registerContextMenu(CONTEXT_MENU_ID, contextMenu, new UnwrappingSelectionProvider(viewer));
		site.registerContextMenu(CONTEXT_MENU_ID, contextMenu, viewer);

		//			int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		//			Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance(), LocalSelectionTransfer.getTransfer(), FileTransfer.getInstance() };
		//			viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		//			viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}


}
