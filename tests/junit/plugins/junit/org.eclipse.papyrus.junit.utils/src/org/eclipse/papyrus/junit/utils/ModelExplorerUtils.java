/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.part.IPage;
import org.junit.Assert;

/**
 * Useful methods for the ModelExplorer view
 */
public class ModelExplorerUtils {

	/**
	 * the ID of the ModelExplorerView
	 */
	private static final String ModelExplorerViewId = "org.eclipse.papyrus.views.modelexplorer.modelexplorer"; //$NON-NLS-1$

	private ModelExplorerUtils() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @return
	 *         the opened modelexplorer. Warning, it should be better that Papyrus was opened yet
	 * @throws PartInitException
	 */
	public static ModelExplorerView openModelExplorerView() throws PartInitException {
		IViewPart modelexplorer = null;
		modelexplorer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ModelExplorerViewId);
		final ModelExplorerPageBookView view = (ModelExplorerPageBookView)modelexplorer;
		final IPage currentPage = view.getCurrentPage();
		final ModelExplorerPage page = (ModelExplorerPage)currentPage;
		final IViewPart viewer = page.getViewer();
		Assert.assertNotNull(viewer);
		viewer.setFocus();
		return (ModelExplorerView)viewer;
	}

	/**
	 * 
	 * @param view
	 *        the modelexplorer to manipulate
	 * @param elements
	 *        the elements to select
	 */
	public static void setSelectionInTheModelexplorer(final ModelExplorerView view, List<?> elements) {
		view.revealSemanticElement(elements);
		final List<?> currentSelection = getCurrentSelectionInTheModelExplorer();
		Assert.assertTrue("The current selection is not the wanted selection", elements.containsAll(currentSelection));
		Assert.assertTrue("The current selection is not the wanted selection", currentSelection.containsAll(elements));
	}

	/**
	 * 
	 * @return
	 *         the object selected in the ModelExplorer
	 *         //TODO : should be moved in the ModelExplorer
	 */
	public static List<?> getCurrentSelectionInTheModelExplorer() {
		final IStructuredSelection currentSelection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection(ModelExplorerViewId);
		final List<Object> selection = new ArrayList<Object>();
		final Iterator<?> iter = currentSelection.iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			if(current instanceof IAdaptable) {
				final EObject adaptedObject = (EObject)((IAdaptable)current).getAdapter(EObject.class);
				Assert.assertNotNull(NLS.bind("The object {0} can't be adapted to EObject", current), adaptedObject);
				selection.add(adaptedObject);
			} else {
				selection.add(current);
			}

		}
		return selection;
	}

	/**
	 * 
	 * @param view
	 *        the ModelExplorerView
	 * @return
	 *         the root of the Model
	 *         //TODO : should be moved in the ModelExplorer
	 */
	public static final EObject getRootInModelExplorer(final ModelExplorerView view) {
		view.getCommonViewer().expandToLevel(2);

		// store the root of the model
		final Object[] visibleElement = view.getCommonViewer().getVisibleExpandedElements();
		EObject modelRoot = null;
		if(visibleElement[0] instanceof IAdaptable) {
			modelRoot = (EObject)((IAdaptable)visibleElement[0]).getAdapter(EObject.class);
		}
		Assert.assertNotNull(modelRoot);
		while(modelRoot.eContainer() != null) {
			modelRoot = modelRoot.eContainer();
		}
		return modelRoot;
	}

	/**
	 * 
	 * @param actionContext
	 *        the creation context
	 * @param wantedResult
	 *        the wanted result
	 */
	public static final void testHandlerStatusInModelExplorer(final ModelExplorerView view, final String commandToTest, final EObject actionContext, boolean wantedResult) {
		setSelectionInTheModelexplorer(view, Collections.singletonList(actionContext));
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		Command cmd = commandService.getCommand(commandToTest);
		IHandler handler = cmd.getHandler();
		if(handler instanceof AbstractHandler) {
			((AbstractHandler)handler).setEnabled(commandToTest);
		}
		boolean res = handler.isEnabled();
		Assert.assertEquals(wantedResult, res);
	}

	/**
	 * Execute an editor command creation and returns the current papyrus nested editor (you must verify that it is the correct editor to be sure of
	 * the command execution)
	 * 
	 * @param currentPapyrusEditor
	 *        the current PapyrusEditor
	 * @param view
	 *        the model explorer view
	 * @param commandToExecute
	 *        the command to execute
	 * @param actionContext
	 *        the context used for the commadn (the selected elements)
	 * @param bundelID
	 *        the bundle id
	 * 
	 * @return
	 *         the current papyrus nested editor (you must verify that it is the correct editor to be sure of
	 *         the command execution)
	 */
	public static final Object executeCreateNestedEditorHandlerInModelExplorer(final IMultiDiagramEditor currentPapyrusEditor, final ModelExplorerView view, final String commandToExecute, final EObject actionContext, final String bundelID) {
		setSelectionInTheModelexplorer(view, Collections.singletonList(actionContext));
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		final Command cmd = commandService.getCommand(commandToExecute);
		final IHandler handler = cmd.getHandler();
		if(handler instanceof AbstractHandler) {
			((AbstractHandler)handler).setEnabled(commandToExecute);
		}
		final RunnableWithResult<?> runnableWithResult = new RunnableWithResult.Impl<Object>() {

			public void run() {
				try {
					handler.execute(new ExecutionEvent(cmd, Collections.emptyMap(), null, null));
				} catch (ExecutionException e) {
					setStatus(new Status(IStatus.ERROR, bundelID, e.getMessage()));
				}

				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorPart activeEditor = activePage.getActiveEditor();
				if(currentPapyrusEditor != activeEditor) {
					setStatus(new Status(IStatus.ERROR, bundelID, "The current active editor is not the wanted Papyrus Editor"));
				}

				setResult(currentPapyrusEditor.getActiveEditor());
				setStatus(Status.OK_STATUS);
			}
		};
		Display.getDefault().syncExec(runnableWithResult);
		Assert.assertEquals(runnableWithResult.getStatus().getMessage(), IStatus.OK, runnableWithResult.getStatus().getSeverity());
		Object result = runnableWithResult.getResult();
		Assert.assertNotNull(result);
		return result;
	}
}
