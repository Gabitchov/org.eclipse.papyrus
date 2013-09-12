/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.views.tests.tests;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.OpenDiagramCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.views.tests.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.ModelExplorerUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.PartService;
import org.eclipse.uml2.uml.Model;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public class TableCreationTest2 {

	private static final String MODEL_PATH = "/resources/model2"; //$NON-NLS-1$

	private static final String SOURCE_PATH = "/resources/"; //$NON-NLS-1$

	private static final String FILE_ROOT_NAME = "model2"; //$NON-NLS-1$

	private static final String PROJECT_NAME = "test"; //$NON-NLS-1$

	private static IMultiDiagramEditor papyrusEditor;

	private static final String BUNDLE_ID = Activator.getDefault().getBundle().getSymbolicName();

	protected static Model rootModel;

	protected static Model subModel;

	protected static Table table1;

	protected static Diagram diagram1;

	protected static Diagram diagram2;

	protected static ModelExplorerView view;

	@BeforeClass
	public static void init() {
		try {
			initTests(Activator.getDefault().getBundle(), PROJECT_NAME, MODEL_PATH);
		} catch (CoreException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		} catch (BundleException e) {
			Activator.log.error(e);
		}
	}

	public static void initTests(final Bundle bundle, final String projectName, final String papyrusModelPath) throws CoreException, IOException, BundleException {
		ProjectUtils.removeAllProjectFromTheWorkspace();
		IProject testProject = ProjectUtils.createProject(projectName);
		final IFile file = PapyrusProjectUtils.copyPapyrusModel(testProject, bundle, SOURCE_PATH, FILE_ROOT_NAME);
		RunnableWithResult<?> runnableWithResult = new RunnableWithResult.Impl<Object>() {

			@Override
			public void run() {
				try {
					papyrusEditor = EditorUtils.openPapyrusEditor(file);
				} catch (PartInitException e) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage()));
				}
				try {
					TableCreationTest2.view = ModelExplorerUtils.openModelExplorerView();
				} catch (PartInitException e) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage()));
				}
				EObject root = ModelExplorerUtils.getRootInModelExplorer(TableCreationTest2.view);
				TableCreationTest2.rootModel = (Model)root;
				subModel = (Model)TableCreationTest2.rootModel.getMember("SubModel1"); //$NON-NLS-1$

				PageList pageList = getPageList(rootModel);
				for(final PageRef pageRef : pageList.getAvailablePage()) {
					Object identifier = pageRef.getPageIdentifier();
					if(identifier instanceof Diagram) {
						if("ClassDiagram2".equals(((Diagram)identifier).getName())) {
							diagram2 = (Diagram)identifier;
						} else if("ClassDiagram1".equals(((Diagram)identifier).getName())) {
							diagram1 = (Diagram)identifier;
						}

					} else if(identifier instanceof Table) {
						if("TableOfViews0".equals(((Table)identifier).getName())) {
							table1 = (Table)identifier;
						}
					}

				}
				setStatus(Status.OK_STATUS);
			}

		};
		Display.getDefault().syncExec(runnableWithResult);
		Assert.assertEquals(runnableWithResult.getStatus().getMessage(), IStatus.OK, runnableWithResult.getStatus().getSeverity());
		Assert.assertNotNull(subModel);
		Assert.assertNotNull(diagram1);
		Assert.assertNotNull(diagram2);
		Assert.assertNotNull(table1);
		Assert.assertNotNull(TableCreationTest2.rootModel);
		Assert.assertEquals(subModel, table1.getContext());
		Assert.assertEquals(subModel, diagram2.getElement());
		Assert.assertEquals(rootModel, diagram1.getElement());


	}

	/**
	 * 
	 * @return
	 *         the page list used for this model
	 */
	private static final PageList getPageList(final EObject object) {
		final Resource resource = object.eResource();
		final ModelSet modelSet = (ModelSet)resource.getResourceSet();
		final Resource diResource = modelSet.getAssociatedResource(resource, DiModel.DI_FILE_EXTENSION, false);
		final SashWindowsMngr windowMngr = DiUtils.lookupSashWindowsMngr(diResource);
		final PageList pageList = windowMngr.getPageList();
		assert pageList != null;
		return pageList;
	}



	@Test
	public void createTable2AndDestroyAnOwnedElement() throws ServiceException {
		final Object result1 = ModelExplorerUtils.executeCreateNestedEditorHandlerInModelExplorer(papyrusEditor, TableCreationTest2.view, AllTests.COMMAND_ID, TableCreationTest2.rootModel, BUNDLE_ID);
		DisplayUtils.safeReadAndDispatch();
		Assert.assertTrue(result1 instanceof NatTableEditor);
		final NatTableEditor editor2 = (NatTableEditor)result1;
		editor2.setFocus();
		DisplayUtils.safeReadAndDispatch();
		final NattableModelManager manager2 = (NattableModelManager)editor2.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager2);
		final Table table2 = manager2.getTable();
		Assert.assertEquals(AllTests.VIEWS_TABLE_ID, table2.getTableConfiguration().getType());

		final IAxisManager rowAxisManager = manager2.getRowAxisManager();
		Collection<Object> managedAxis_Table1 = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(4, managedAxis_Table1.size());
		Assert.assertTrue(managedAxis_Table1.contains(table1));
		Assert.assertTrue(managedAxis_Table1.contains(table2));
		Assert.assertTrue(managedAxis_Table1.contains(diagram1));
		Assert.assertTrue(managedAxis_Table1.contains(diagram2));
		Assert.assertEquals(managedAxis_Table1.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(table2));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(table1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(diagram1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(diagram2));


		TransactionalEditingDomain editingDomain = papyrusEditor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		DestroyElementRequest request = new DestroyElementRequest(editingDomain, diagram2, false);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(diagram2);
		ICommand cmd = provider.getEditCommand(request);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));


		DisplayUtils.safeReadAndDispatch();
		//verify the contents of table2
		managedAxis_Table1 = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(3, managedAxis_Table1.size());
		Assert.assertTrue(managedAxis_Table1.contains(table1));
		Assert.assertTrue(managedAxis_Table1.contains(table2));
		Assert.assertTrue(managedAxis_Table1.contains(diagram1));



		Assert.assertEquals(managedAxis_Table1.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(table2));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(table1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(diagram1));


		//verify the contents of table1 (we open it)
		IPageManager pageManager = papyrusEditor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(3, pageManager.allPages().size());
		IEditorPart tableEditor = papyrusEditor.getActiveEditor();
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, table1)));
		DisplayUtils.safeReadAndDispatch();
		tableEditor = papyrusEditor.getActiveEditor();
		Assert.assertTrue(tableEditor instanceof NatTableEditor);
		INattableModelManager manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager);
		Assert.assertEquals(AllTests.VIEWS_TABLE_ID, manager.getTable().getTableConfiguration().getType());

		IAxisManager axisManager = manager.getRowAxisManager();
		final Collection<Object> managedAxis_Table2 = axisManager.getAllManagedAxis();
		Assert.assertEquals(1, managedAxis_Table2.size());
		Assert.assertTrue(managedAxis_Table2.contains(table1));

		Assert.assertEquals(managedAxis_Table2.size(), axisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(axisManager.getTableManager().getRowElementsList().contains(table1));


	}

	@AfterClass
	public static void endOfTest() {
		GenericUtils.closeAllEditors();
	}


}
