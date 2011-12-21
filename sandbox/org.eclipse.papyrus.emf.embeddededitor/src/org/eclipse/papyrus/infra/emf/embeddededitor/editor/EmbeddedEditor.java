/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.embeddededitor.editor;

import java.io.IOException;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.emf.embeddededitor.Activator;
import org.eclipse.papyrus.infra.emf.embeddededitor.providers.CustomizableContentProvider;
import org.eclipse.papyrus.infra.emf.embeddededitor.providers.EditingDomainProviderAdapter;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter;
import org.eclipse.papyrus.views.properties.widgets.layout.GridData;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;

/**
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class EmbeddedEditor implements CommandStackListener, IMenuListener {

	protected TreeViewer treeViewer;

	protected ILabelProvider labelProvider;

	protected IStructuredContentProvider contentProvider;

	protected CustomizationManager customizationManager;

	protected Composite container;

	protected Composite parent;

	protected ResourceSet resourceSet;

	protected EditingDomain editingDomain;

	protected AdapterFactory adapterFactory;

	protected ActionBarContributor actionBarContributor;

	protected Adapter editingDomainAdapter;

	public EmbeddedEditor(ResourceSet resourceSet) {
		if(resourceSet == null) {
			throw new IllegalArgumentException("The resourceSet shall not be null"); //$NON-NLS-1$
		}

		CommandStack commandStack = new BasicCommandStack();
		AdapterFactory adapterFactory = createAdapterFactory();
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, resourceSet);
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, resourceSet);
		editingDomain.setResourceToReadOnlyMap(new HashMap<Resource, Boolean>());

		configure(resourceSet, adapterFactory, editingDomain);
	}

	public EmbeddedEditor(ResourceSet resourceSet, AdapterFactory adapterFactory, EditingDomain editingDomain) {
		configure(resourceSet, adapterFactory, editingDomain);
	}

	protected void configure(ResourceSet resourceSet, AdapterFactory adapterFactory, EditingDomain editingDomain) {
		this.resourceSet = resourceSet;
		this.adapterFactory = adapterFactory;
		this.editingDomain = editingDomain;
		editingDomainAdapter = new EditingDomainProviderAdapter(editingDomain);
		resourceSet.eAdapters().add(editingDomainAdapter);
	}

	protected AdapterFactory createAdapterFactory() {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		return adapterFactory;
	}

	public void createWidget(Composite parent) {

		this.parent = parent;

		container = new Composite(parent, SWT.NONE);
		container.setLayout(new PropertiesLayout());

		container.setBackground(new Color(parent.getDisplay(), 255, 255, 255));
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);

		if(!resourceSet.getResources().isEmpty()) {
			final PatternViewerFilter filter = new PatternViewerFilter();

			final StringEditor filterPattern = new StringEditor(container, SWT.NONE, "Filter");
			filterPattern.addCommitListener(new ICommitListener() {

				public void commit(AbstractEditor editor) {
					filter.setPattern((String)filterPattern.getValue());
					treeViewer.refresh();
				}

			});

			Tree tree = new Tree(container, SWT.NONE | SWT.MULTI);
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			treeViewer = new TreeViewer(tree);
			treeViewer.setFilters(new ViewerFilter[]{ filter });
			IStructuredContentProvider contentProvider = getContentProvider();
			getCustomizationManager().installCustomPainter(tree);

			ILabelProvider labelProvider = getLabelProvider();

			editingDomain.getCommandStack().addCommandStackListener(this);

			treeViewer.setContentProvider(contentProvider);
			treeViewer.setLabelProvider(labelProvider);

			treeViewer.setInput(resourceSet);

			actionBarContributor = new ActionBarContributor();
			actionBarContributor.init(editingDomain, treeViewer);

			treeViewer.setSelection(new StructuredSelection(resourceSet.getResources().get(0)), true);

			new AdapterFactoryTreeEditor(treeViewer.getTree(), adapterFactory);

			createContextMenuFor(treeViewer);

			parent.layout();
		}

		updateProblemIndication();
	}

	private void updateProblemIndication() {
		// TODO
	}

	public IStructuredContentProvider getContentProvider() {
		if(contentProvider == null) {
			contentProvider = createContentProvider();
		}
		return contentProvider;
	}

	protected IStructuredContentProvider createContentProvider() {
		//return new AdapterFactoryContentProvider(adapterFactory);
		return new CustomizableContentProvider(getCustomizationManager());
	}

	public CustomizationManager getCustomizationManager() {
		if(customizationManager == null) {
			customizationManager = createCustomizationManager();
		}
		return customizationManager;
	}

	protected CustomizationManager createCustomizationManager() {
		return Activator.getDefault().getCustomizationManager();
	}

	public ILabelProvider getLabelProvider() {
		if(labelProvider == null) {
			labelProvider = createLabelProvider();
		}
		return labelProvider;
	}

	protected ILabelProvider createLabelProvider() {
		//		return new AdapterFactoryLabelProvider(adapterFactory);
		return new CustomizableModelLabelProvider(getCustomizationManager());
	}

	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
		contextMenu.add(new Separator("additions")); //$NON-NLS-1$
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[]{ LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new MoDiscoDropAdapter(editingDomain, viewer));
	}

	public void dispose() {
		resourceSet.eAdapters().remove(editingDomainAdapter);
	}

	public void save() {
		if(!((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded()) {
			return;
		}

		IEditingDomainProvider domainProvider = (IEditingDomainProvider)EcoreUtil.getAdapter(resourceSet.eAdapters(), IEditingDomainProvider.class);
		if(domainProvider == null) {
			return;
		}

		EditingDomain domain = domainProvider.getEditingDomain();
		if(domain == null) {
			return;
		}

		for(Resource resource : resourceSet.getResources()) {
			try {
				if(!EMFHelper.isReadOnly(resource, domain)) {
					resource.save(Collections.EMPTY_MAP);
				}
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}

		((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
	}

	public boolean isSaveNeeded() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}

	public void saveAs(URI saveAsURI) {
		//TODO
	}

	public void commandStackChanged(EventObject event) {
		treeViewer.refresh();
	}

	public void menuAboutToShow(IMenuManager menuManager) {
		actionBarContributor.menuAboutToShow(menuManager);
	}

	public TreeViewer getViewer() {
		return treeViewer;
	}

	public void addCommandStackListener(CommandStackListener listener) {
		editingDomain.getCommandStack().addCommandStackListener(listener);
	}
}
