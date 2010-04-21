/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.modelexplorer;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * this is an extension of {@link CommonNavigator} to be a model explorer
 */
public class ModelExplorer extends CommonNavigator implements
IEditingDomainProvider {

	private IMultiDiagramEditor editorPart;
	private TransactionalEditingDomain editingDomain;
	private IWorkbenchPage page = null;
	private IPartListener2 partListener;

	/**
	 * The {@link IPropertySheetPage} this model explorer will use.
	 */
	private IPropertySheetPage propertySheetPage = null;

	public void selectReveal(ISelection selection) {
		if (getCommonViewer() != null) {
			getCommonViewer().setSelection(selection, true);
		}
	}

	public ModelExplorer() {
	}

	@Override
	public void init(IViewSite aSite, IMemento aMemento)
	throws PartInitException {
		// TODO Auto-generated method stub
		super.init(aSite, aMemento);
		page = aSite.getPage();


		partListener = new IPartListener2() {

			public void partActivated(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partBroughtToTop(IWorkbenchPartReference partRef) {
			}

			public void partClosed(IWorkbenchPartReference partRef) {
				handlePartDeactivated(partRef);
			}

			public void partDeactivated(IWorkbenchPartReference partRef) {
			}

			public void partHidden(IWorkbenchPartReference partRef) {
			}

			public void partInputChanged(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partOpened(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

			public void partVisible(IWorkbenchPartReference partRef) {
				handlePartActivated(partRef);
			}

		};
		page.addPartListener(partListener);
		activate();
	}

	/**
	 * {@link ResourceSetListener} to listen and react to changes in the
	 * resource set.
	 */
	private final ResourceSetListener resourceSetListener = new ResourceSetListenerImpl() {

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			super.resourceSetChanged(event);
			handleResourceSetChanged(event);
		}
	};

	// a revoir eviter de rafrachier le root
	private void handleResourceSetChanged(ResourceSetChangeEvent event) {
		getCommonViewer().refresh();
	}

	/**
	 * Activate the Model Explorer.
	 */
	private void activate() {
//		Display.getCurrent().syncExec(
//				new Runnable() {
//					public void run(){
//						IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//
//						IWorkbenchPage page = workbenchWindow.getActivePage();
//						if(page == null) {
//							try{
//								Thread.sleep(1000);
//							}
//							catch (InterruptedException e) {
//								System.err.println(e);
//							}
//						}
//					}
//				});




		this.editorPart = EditorUtils.getMultiDiagramEditor();
		this.editingDomain = EditorUtils.getTransactionalEditingDomain();
		if (editingDomain != null) {
			editingDomain.addResourceSetListener(resourceSetListener);
		}
		if(this.getCommonViewer()!=null){
			this.getCommonViewer().refresh();
		}

	}

	/**
	 * Deactivate the Model Explorer.
	 */
	private void deactivate() {
		editorPart = null;
		if (editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
		}
	}

	/**
	 * An {@link IWorkbenchPart} has been deactivated, refresh.
	 * 
	 * @param partRef
	 */
	private void handlePartDeactivated(IWorkbenchPartReference partRef) {
		IWorkbenchPart part = partRef.getPart(false);
		if (editorPart != null && editorPart.equals(part)) {
			deactivate();
		}
	}

	/**
	 * A new {@link IWorkbenchPart} has been activated, refresh.
	 * 
	 * @param partRef
	 */
	private void handlePartActivated(IWorkbenchPartReference partRef) {
		final IWorkbenchPart part = partRef.getPart(false);




		if (part instanceof IEditorPart) {
			activate();
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		deactivate();
		page.removePartListener(partListener);

	}

	/**
	 * Retrieves the {@link IPropertySheetPage} that his Model Explorer uses.
	 * 
	 * @return
	 */
	private IPropertySheetPage getPropertySheetPage() {
		final IMultiDiagramEditor multiDiagramEditor = EditorUtils
		.getMultiDiagramEditor();
		if (multiDiagramEditor != null) {
			if (propertySheetPage == null) {
				if (multiDiagramEditor instanceof ITabbedPropertySheetPageContributor) {
					ITabbedPropertySheetPageContributor contributor = (ITabbedPropertySheetPageContributor) multiDiagramEditor;
					this.propertySheetPage = new TabbedPropertySheetPage(
							contributor);
				}
			}
			return propertySheetPage;
		}
		return null;
	}

	/**
	 * in order to see element if the property view
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (IPropertySheetPage.class.equals(adapter)) {
			return getPropertySheetPage();
		}
		return super.getAdapter(adapter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the EditingDomain used by the properties view
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
}
