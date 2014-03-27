/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Factor out workspace storage for pluggable storage providers (CDO)
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.editor;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.customization.properties.editor.preview.Preview;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.papyrus.customization.properties.providers.ContextContentProvider;
import org.eclipse.papyrus.customization.properties.providers.ContextLabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.views.properties.catalog.PropertiesURIHandler;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.widgets.layout.GridData;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A customization editor for Contexts from the Papyrus Property View.
 * The Editor is based on the Ecore reflective editor and the EMF Facet
 * customizable content & label providers
 * 
 * @author Camille Letavernier
 */
public class UIEditor extends EcoreEditor implements ITabbedPropertySheetPageContributor, CommandStackListener {

	private Set<Preview> previews = new HashSet<Preview>();

	private TreeViewer selectionViewer;

	@Override
	public void createPages() {
		// Creates the model from the editor input
		//
		createModel();

		getContainer().setBackground(getContainer().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		getContainer().setBackgroundMode(SWT.INHERIT_DEFAULT);

		Composite gParent = new Composite(getContainer(), SWT.NONE);
		gParent.setLayout(new FillLayout());

		//SashForm parent = new SashForm(gParent, SWT.VERTICAL | SWT.V_SCROLL | SWT.H_SCROLL);
		//parent.setLayout(new FillLayout());

		Composite parent = new Composite(gParent, SWT.NONE);
		parent.setLayout(new PropertiesLayout());

		// Only creates the other pages if there is something that can be edited
		//
		if(!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			// Create a page for the selection tree view.
			//

			final ViewFilter filter = new ViewFilter();

			final StringEditor filterPattern = new StringEditor(parent, SWT.NONE, Messages.UIEditor_FilterViews);
			filterPattern.addCommitListener(new ICommitListener() {

				@Override
				public void commit(AbstractEditor editor) {
					filter.setPattern((String)filterPattern.getValue());
					selectionViewer.refresh();
				}

			});

			Tree tree = new Tree(parent, SWT.BORDER | SWT.MULTI);
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			selectionViewer = new TreeViewer(tree);
			selectionViewer.setFilters(new ViewerFilter[]{ filter });
			setCurrentViewer(selectionViewer);
			ContextContentProvider contentProvider = new ContextContentProvider();
			//contentProvider.getCustomizationManager().installCustomPainter(tree);

			ILabelProvider labelProvider = new ContextLabelProvider();

			editingDomain.getCommandStack().addCommandStackListener(this);

			selectionViewer.setContentProvider(contentProvider);
			selectionViewer.setLabelProvider(labelProvider);

			selectionViewer.setInput(editingDomain.getResourceSet());
			selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);

			new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

			createContextMenuFor(selectionViewer);
			int pageIndex = addPage(gParent);
			setPageText(pageIndex, "Model"); //$NON-NLS-1$

			setActivePage(0);

			//			Preview preview = new Preview(this);
			//			preview.createPartControl(parent);
			//			addPreview(preview);

			parent.layout();
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(new ControlAdapter() {

			boolean guard = false;

			@Override
			public void controlResized(ControlEvent event) {
				if(!guard) {
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});

		updateProblemIndication();

		changePerspective();

		//FIXME ppe:/ conversion
		//This is a hack. The ppe:/ URIs are not correctly converted when the model is saved.
		getEditingDomain().getResourceSet().getURIConverter().getURIHandlers().add(0, new PropertiesURIHandler());
	}

	protected void changePerspective() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if(activePage == null) {
			return;
		}

		IPerspectiveDescriptor descriptor = activePage.getPerspective();

		if(descriptor.getId().equals(Activator.CUSTOMIZATION_PERSPECTIVE_ID)) {
			return;
		}

		boolean openPerspective = false;

		//		if(CustomizationPreferencePage.askForConfirmation()) {
		//			int defaultIndex = CustomizationPreferencePage.openCustomizationPerspective() ? 0 : 1;
		//			System.out.println(getContainer().getShell());
		//			MessageDialog confirmationDialog = new MessageDialog(getContainer().getShell(), Messages.UIEditor_ChangePerspective, null, Messages.UIEditor_ChangePerspectiveMessage, MessageDialog.QUESTION, new String[]{ IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL }, defaultIndex);
		//			confirmationDialog.open();
		//			openPerspective = confirmationDialog.getReturnCode() == 0;
		//		} else {
		//			openPerspective = CustomizationPreferencePage.openCustomizationPerspective();
		//		}

		if(openPerspective) {
			try {
				PlatformUI.getWorkbench().showPerspective(Activator.CUSTOMIZATION_PERSPECTIVE_ID, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
			} catch (WorkbenchException ex) {
				Activator.log.error(ex);
			}
		}
	}

	@Override
	protected void createContextMenuForGen(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
		contextMenu.add(new Separator("additions")); //$NON-NLS-1$
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[]{ LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new MoDiscoDropAdapter(editingDomain, viewer));
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		super.doSave(progressMonitor);
		refreshContext();
	}

	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.create();
		saveAsDialog.setMessage(EcoreEditorPlugin.INSTANCE.getString("_UI_SaveAs_message")); //$NON-NLS-1$
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if(path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if(file != null) {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				Resource currentResource = resourceSet.getResources().get(0);
				String currentExtension = currentResource.getURI().fileExtension();

				URI currentURI = currentResource.getURI();
				URI newURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				String newExtension = newURI.fileExtension();

				if(currentExtension.equals(ECORE_FILE_EXTENSION) && newExtension.equals(EMOF_FILE_EXTENSION) || currentExtension.equals(EMOF_FILE_EXTENSION) && newExtension.equals(ECORE_FILE_EXTENSION)) {
					Resource newResource = resourceSet.createResource(newURI);
					newResource.getContents().addAll(currentResource.getContents());
					resourceSet.getResources().remove(0);
					resourceSet.getResources().move(0, newResource);
				} else {
					//System.out.println("Replace " + currentURI + " by " + newURI);
					currentResource.setURI(newURI);
				}

				IFileEditorInput modelFile = new FileEditorInput(file);
				setInputWithNotify(modelFile);
				setPartName(file.getName());

				Context context = getContext();
				if(context != null) {
					EcoreUtil.resolveAll(context);
					for(Resource resource : currentResource.getResourceSet().getResources()) {
						if(resource != currentResource) {
							if(isRelative(currentURI, resource)) {
								URI newResourceURI = resource.getURI().deresolve(currentURI).resolve(newURI);
								//System.out.println("Replace " + resource.getURI() + " by " + newResourceURI);
								resource.setURI(newResourceURI);
							}
						}
					}
				}

				doSave(getActionBars().getStatusLineManager().getProgressMonitor());
			}
		}
	}

	private boolean isRelative(URI baseURI, Resource resource) {
		URI resourceURI = resource.getURI();
		URI uri = resourceURI.deresolve(baseURI);
		if(uri.isRelative()) {
			if(!(uri.toString().startsWith("..") || uri.toString().startsWith("/"))) { //$NON-NLS-1$ //$NON-NLS-2$
				return true;
			}
		}
		return false;
	}

	protected Context getContext() {
		EObject object = getEditingDomain().getResourceSet().getResources().get(0).getContents().get(0);
		if(object instanceof Context) {
			return (Context)object;
		}
		return null;
	}

	private void refreshContext() {
		Context context = getContext();
		if(context != null) {
			ConfigurationManager.getInstance().refresh(context);
		}
	}

	@Override
	public IPropertySheetPage getPropertySheetPage() {
		if(iPropertySheetPage == null) {
			iPropertySheetPage = new TabbedPropertySheetPage(this);
		}
		return iPropertySheetPage;
	}

	@Override
	public String getContributorId() {
		return "CustomizationPropertyView"; //$NON-NLS-1$
	}

	/**
	 * Registers a Preview to this Editor
	 * 
	 * @param preview
	 */
	public void addPreview(Preview preview) {
		previews.add(preview);
		selectionViewer.addSelectionChangedListener(preview);
		preview.selectionChanged(new SelectionChangedEvent(this, this.currentViewer.getSelection()));
	}

	/**
	 * Unregisters a Preview from this editor
	 * 
	 * @param preview
	 */
	public void removePreview(Preview preview) {
		previews.remove(preview);
		selectionViewer.removeSelectionChangedListener(preview);
	}

	@Override
	public void dispose() {
		for(Preview preview : previews) {
			selectionViewer.removeSelectionChangedListener(preview);
		}
		previews.clear();
		if(iPropertySheetPage != null) {
			iPropertySheetPage.dispose();
		}
		super.dispose();
	}

	/**
	 * The Property sheet page for this editor
	 */
	protected IPropertySheetPage iPropertySheetPage;

	@Override
	public void commandStackChanged(EventObject event) {
		getViewer().refresh();
		for(Preview preview : previews) {
			preview.displayView();
		}
	}

	@Override
	public void createModel() {
		if(getEditorInput() instanceof ResourceEditorInput) {
			// override the editing domain with one that uses the resource's
			// resource set, which already exists

			ResourceSet resourceSet = ((ResourceEditorInput)getEditorInput()).getResource().getResourceSet();

			if(resourceSet != null) {
				editingDomain = new AdapterFactoryEditingDomain(editingDomain.getAdapterFactory(), editingDomain.getCommandStack(), resourceSet);
			}
		}

		super.createModel();
	}

	@Override
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener(new CommandStackListener() {

			@Override
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {

					@Override
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);

						// Try to select the affected objects.
						//
						Command mostRecentCommand = ((CommandStack)event.getSource()).getMostRecentCommand();
						if(mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
						for(Iterator<PropertySheetPage> i = propertySheetPages.iterator(); i.hasNext();) {
							PropertySheetPage propertySheetPage = i.next();
							if(propertySheetPage.getControl().isDisposed()) {
								i.remove();
							} else {
								propertySheetPage.refresh();
							}
						}
					}
				});
			}
		});

		//Replace the parent editing domain with a standard one. We don't want to override the isReadOnly() method.
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
	}
}
