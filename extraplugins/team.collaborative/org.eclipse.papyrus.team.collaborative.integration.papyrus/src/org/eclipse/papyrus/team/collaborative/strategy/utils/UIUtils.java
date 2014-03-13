/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.strategy.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.gmf.runtime.common.ui.dialogs.SaveAllDirtyEditorsDialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForWorkbenchPage;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.reports.CollabStatus;
import org.eclipse.papyrus.team.collaborative.core.reports.LogHelper;
import org.eclipse.papyrus.team.collaborative.core.utils.CollabFunctionsFactory;
import org.eclipse.papyrus.team.collaborative.core.utils.ModelsUtil;
import org.eclipse.papyrus.team.collaborative.strategy.Activator;
import org.eclipse.papyrus.team.collaborative.strategy.RefreshHelper;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;


/**
 * Utility class for User Interface interactions.
 * 
 * @author adaussy
 */
public class UIUtils {

	/** The resource manager. */
	public static LocalResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());

	/**
	 * Save all dirty editor.
	 * 
	 * @return the {@link IStatus}
	 */
	public static IStatus saveAllDirtyEditor() {
		//Force save
		IEditorPart[] dirtyEditors = SaveAllDirtyEditorsDialog.getDirtyEditors();
		if(dirtyEditors.length > 0) {
			SaveAllDirtyEditorsDialog dialog = new SaveAllDirtyEditorsDialog(Display.getDefault().getActiveShell());
			if(dialog.open() == SaveAllDirtyEditorsDialog.CANCEL) {
				return Status.CANCEL_STATUS;
			} else {
				for(int i = 0; i < dirtyEditors.length; i++) {
					IEditorPart editorI = dirtyEditors[i];
					editorI.doSave(new NullProgressMonitor());
				}
			}
		}
		return Status.OK_STATUS;
	}

	/**
	 * Gets the current resource set.
	 * 
	 * @return the current resource set
	 */
	public static ResourceSet getCurrentResourceSet() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof CoreMultiDiagramEditor) {
			CoreMultiDiagramEditor papyrusEditor = (CoreMultiDiagramEditor)editor;
			return papyrusEditor.getEditingDomain().getResourceSet();
		}
		return null;
	}

	/**
	 * Return all the leaf from the semantic meta model
	 * 
	 * @param uris
	 *        Input set for the search of leaf
	 * @param resourceSet
	 * @return
	 */
	public static Collection<EObject> getLeafSemanticElement(Collection<IExtendedURI> uris, ResourceSet resourceSet) {
		Collection<IExtendedURI> semanticURIS = Collections2.filter(uris, new Predicate<IExtendedURI>() {

			public boolean apply(IExtendedURI arg0) {
				return UmlModel.UML_FILE_EXTENSION.equals(arg0.getUri().fileExtension());
			}
		});
		Collection<Collection<EObject>> eObjects = Collections2.transform(semanticURIS, CollabFunctionsFactory.getExtendedURIToEObjects(resourceSet));
		Set<EObject> semanticElements = new HashSet<EObject>();
		for(Collection<EObject> eos : eObjects) {
			semanticElements.addAll(eos);
		}
		return ModelsUtil.getRoots(semanticElements);
	}

	/**
	 * Gets the first selection from the workbench
	 * 
	 * @return the first selection
	 */
	public static EObject getFirstSelection() {
		Collection<EObject> selection = getSelection();
		if(selection.isEmpty()) {
			return null;
		}
		return selection.iterator().next();
	}

	/**
	 * Gets the selection from the workbench
	 * 
	 * @return the selection
	 */
	public static Collection<EObject> getSelection() {
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();
		if(selection != null) {
			if(selection instanceof IStructuredSelection) {
				List<EObject> result = new ArrayList<EObject>();
				Iterator<?> ite = ((IStructuredSelection)selection).iterator();
				while(ite.hasNext()) {
					Object next = ite.next();
					EObject eObject = EMFHelper.getEObject(next);
					if(eObject != null) {
						result.add(eObject);
					}
				}
				return result;
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Refresh elements in model explorer view.
	 * 
	 * @param uris
	 *        {@link IExtendedURI} to refresh
	 * @param resourceSet
	 *        the resource set
	 */
	public static void refreshModelExplorer(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		for(Collection<EObject> objects : Collections2.transform(uris, CollabFunctionsFactory.getExtendedURIToEObjects(resourceSet))) {
			RefreshHelper.refreshModelExplorer(objects);
		}
	}

	/**
	 * This reload the current editor
	 * WARNING : BE careful after this action the ancient resourceSet will deprecated you may use getCurrentResourceSet() to retrieve the new one.
	 */
	public static void reloadEditor() {
		Display.getCurrent().syncExec(new Runnable() {

			public void run() {
				IWorkbench wb = PlatformUI.getWorkbench();
				IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
				IEditorPart editor = page.getActiveEditor();
				IEditorInput input = editor.getEditorInput();
				page.closeEditor(editor, true);
				try {
					IEditorDescriptor desc = wb.getEditorRegistry().getDefaultEditor(input.getName());
					page.openEditor(input, desc.getId(), false);
				} catch (PartInitException e) {
					LogHelper.getInstance().logError("Error during reloading", Activator.PLUGIN_ID, e);
				}
			}
		});
	}

	/**
	 * Display an error dialog using a status.
	 * 
	 * @param errorStatus
	 *        the error status
	 * @param title
	 *        the title
	 */
	public static void errorDialog(IStatus errorStatus, String title) {
		ErrorDialog dialog = new ErrorDialog(Display.getDefault().getActiveShell(), title, errorStatus.getMessage(), errorStatus, Status.ERROR);
		dialog.open();
		LogHelper.getInstance().logError(errorStatus.getMessage(), Activator.PLUGIN_ID, errorStatus.getException());
	}

	/**
	 * Error dialog.
	 * 
	 * @param throwable
	 *        the throwable
	 * @param title
	 *        the title
	 * @param message
	 *        the message
	 */
	public static void errorDialog(Throwable throwable, String title, String message) {
		errorDialog(CollabStatus.createErrorStatus(message, throwable), title);
	}

	/** The adapter factory. */
	private static ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/**
	 * Try to get a correct label from a Object
	 * Handle: {@link EObject} {@link Resource}.
	 * 
	 * @param object
	 *        the object
	 * @return the label
	 */
	public static String getLabel(Object object) {
		if(object instanceof EObject) {
			EObject eObject = (EObject)object;
			IItemLabelProvider labelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
			return labelProvider.getText(eObject);
		} else if(object instanceof Resource) {
			return "Resouce " + ((Resource)object).getURI();
		}
		return object.toString();
	}

	public static ILabelProvider getModelExplorerLavelProvider() {
		ILabelProvider labelProvider = getLabelProvider(ModelExplorerView.LABEL_PROVIDER_SERVICE_CONTEXT);
		if(labelProvider == null) {
			labelProvider = getLabelProvider();
		}
		return labelProvider;
	}

	public static ILabelProvider getLabelProvider() {
		return getLabelProvider(null);
	}

	public static ILabelProvider getLabelProvider(String context) {

		try {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			ServicesRegistry serviceRegistry = ServiceUtilsForWorkbenchPage.getInstance().getServiceRegistry(activePage);
			LabelProviderService service = serviceRegistry.getService(LabelProviderService.class);
			if(context != null) {
				return service.getLabelProvider(context);
			} else {
				return service.getLabelProvider();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return null;
	}

}
