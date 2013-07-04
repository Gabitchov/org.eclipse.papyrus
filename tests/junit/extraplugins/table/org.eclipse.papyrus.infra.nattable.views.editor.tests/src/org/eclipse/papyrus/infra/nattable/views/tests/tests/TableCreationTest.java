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
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.PartService;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public class TableCreationTest {

	private static final String MODEL_PATH = "/resources/model"; //$NON-NLS-1$

	private static final String SOURCE_PATH = "/resources/"; //$NON-NLS-1$

	private static final String FILE_ROOT_NAME = "model"; //$NON-NLS-1$

	private static final String PROJECT_NAME = "test"; //$NON-NLS-1$

	private static IMultiDiagramEditor papyrusEditor;

	private static final String BUNDLE_ID = Activator.getDefault().getBundle().getSymbolicName();

	protected static Model rootModel;

	private static Model subModel;

	private static Model subSubModel;

	private static Package subPackage;

	private static Package subSubPackage;

	protected static ModelExplorerView view;

	@BeforeClass
	public static void init() {
		try {
			GenericUtils.closeAllEditors();
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
					TableCreationTest.view = ModelExplorerUtils.openModelExplorerView();
				} catch (PartInitException e) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage()));
				}
				EObject root = ModelExplorerUtils.getRootInModelExplorer(TableCreationTest.view);
				TableCreationTest.rootModel = (Model)root;
				subModel = (Model)TableCreationTest.rootModel.getMember("SubModel"); //$NON-NLS-1$
				subPackage = (Package)TableCreationTest.rootModel.getMember("SubPackage"); //$NON-NLS-1$
				if(subModel != null && subPackage != null) {
					subSubModel = (Model)TableCreationTest.subModel.getMember("SubSubModel"); //$NON-NLS-1$
					subSubPackage = (Package)TableCreationTest.subPackage.getMember("SubSubPackage");

					setStatus(Status.OK_STATUS);

				} else {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), "Requirement1 not found")); //$NON-NLS-1$
				}

			}

		};
		Display.getDefault().syncExec(runnableWithResult);
		Assert.assertEquals(runnableWithResult.getStatus().getMessage(), IStatus.OK, runnableWithResult.getStatus().getSeverity());
		Assert.assertNotNull(subModel);
		Assert.assertNotNull(subPackage);
		Assert.assertNotNull(subSubModel);
		Assert.assertNotNull(subPackage);

		Assert.assertNotNull(TableCreationTest.rootModel);



	}

	@Test
	public void testCreationHandlerStatusOnRootModel() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationTest.view, AllTests.COMMAND_ID, TableCreationTest.rootModel, true);
	}

	@Test
	public void testCreationHandlerStatusOnSubModel() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationTest.view, AllTests.COMMAND_ID, subModel, true);
	}

	@Test
	public void testCreationHandlerStatusOnSubSubModel() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationTest.view, AllTests.COMMAND_ID, subSubModel, true);
	}

	@Test
	public void testCreationHandlerStatusOnSubPackage() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationTest.view, AllTests.COMMAND_ID, subPackage, true);
	}

	@Test
	public void testCreationHandlerStatusOnSubSubPackage() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationTest.view, AllTests.COMMAND_ID, subSubPackage, true);
	}


	@Test
	public void testCreationAndSynchronization() {
		final Object result1 = ModelExplorerUtils.executeCreateNestedEditorHandlerInModelExplorer(papyrusEditor, TableCreationTest.view, AllTests.COMMAND_ID, TableCreationTest.subSubPackage, BUNDLE_ID);
		Assert.assertTrue(result1 instanceof NatTableEditor);
		final NatTableEditor editor1 = (NatTableEditor)result1;
		final NattableModelManager manager1 = (NattableModelManager)editor1.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager1);
		final Table subSubPackageTable1 = manager1.getTable();
		Assert.assertEquals(AllTests.VIEWS_TABLE_ID, subSubPackageTable1.getTableConfiguration().getType());

		final IAxisManager rowAxisManager = manager1.getRowAxisManager();
		final Collection<Object> managedAxis_subSubPackageTable1 = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(1, managedAxis_subSubPackageTable1.size());
		Assert.assertTrue(managedAxis_subSubPackageTable1.contains(subSubPackageTable1));
		Assert.assertEquals(managedAxis_subSubPackageTable1.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(subSubPackageTable1));


		//we create a second table. This one must be added to the content of the first one
		final Object result2 = ModelExplorerUtils.executeCreateNestedEditorHandlerInModelExplorer(papyrusEditor, TableCreationTest.view, AllTests.COMMAND_ID, TableCreationTest.subSubPackage, BUNDLE_ID);

		Assert.assertTrue(result2 instanceof NatTableEditor);
		final NatTableEditor editor2 = (NatTableEditor)result2;
		final NattableModelManager manager2 = (NattableModelManager)editor2.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager2);
		final Table subSubPackageTable2 = manager2.getTable();
		Assert.assertEquals(AllTests.VIEWS_TABLE_ID, subSubPackageTable2.getTableConfiguration().getType());

		//we verify the contents of the second table
		final IAxisManager rowAxisManager2 = manager2.getRowAxisManager();
		Collection<Object> managedAxis2 = rowAxisManager2.getAllManagedAxis();
		Assert.assertEquals(2, managedAxis2.size());
		Assert.assertTrue(managedAxis2.contains(subSubPackageTable1));
		Assert.assertTrue(managedAxis2.contains(subSubPackageTable2));

		while(Display.getDefault().readAndDispatch());

		Assert.assertEquals(managedAxis2.size(), rowAxisManager2.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager2.getTableManager().getRowElementsList().contains(subSubPackageTable1));
		Assert.assertTrue(rowAxisManager2.getTableManager().getRowElementsList().contains(subSubPackageTable2));


		//we verify the contents of the first table
		final Collection<Object> managedAxis_subSubPackageTable1_1 = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(2, managedAxis_subSubPackageTable1_1.size());
		Assert.assertTrue(managedAxis_subSubPackageTable1_1.contains(subSubPackageTable1));
		Assert.assertTrue(managedAxis_subSubPackageTable1_1.contains(subSubPackageTable2));
		Assert.assertEquals(managedAxis_subSubPackageTable1_1.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(subSubPackageTable1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(subSubPackageTable2));


		//-----------------we create a table in subModel. This table must contains only itself and the others table muse not contains it
		final Object result3 = ModelExplorerUtils.executeCreateNestedEditorHandlerInModelExplorer(papyrusEditor, TableCreationTest.view, AllTests.COMMAND_ID, TableCreationTest.subModel, BUNDLE_ID);
		Assert.assertTrue(result3 instanceof NatTableEditor);
		final NatTableEditor editor3 = (NatTableEditor)result3;
		final NattableModelManager manager3 = (NattableModelManager)editor3.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager3);
		final Table subModelTable3 = manager3.getTable();
		Assert.assertEquals(AllTests.VIEWS_TABLE_ID, subModelTable3.getTableConfiguration().getType());
		while(Display.getDefault().readAndDispatch());
		final IAxisManager rowAxisManager3 = manager3.getRowAxisManager();
		final Collection<Object> managedAxis_SubPackageTable3 = rowAxisManager3.getAllManagedAxis();
		Assert.assertEquals(1, managedAxis_SubPackageTable3.size());
		Assert.assertTrue(managedAxis_SubPackageTable3.contains(subModelTable3));
		Assert.assertEquals(managedAxis_SubPackageTable3.size(), rowAxisManager3.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager3.getTableManager().getRowElementsList().contains(subModelTable3));

		//we verify that the other tables don't reference it
		//verify in table 1
		IAxisManager rowAxisManagerTable1 = manager1.getRowAxisManager();
		Collection<Object> managedAxisTable1 = rowAxisManagerTable1.getAllManagedAxis();
		Assert.assertEquals(2, managedAxisTable1.size());
		Assert.assertFalse(managedAxisTable1.contains(subModelTable3));
		Assert.assertEquals(managedAxisTable1.size(), rowAxisManagerTable1.getTableManager().getRowElementsList().size());
		Assert.assertFalse(rowAxisManagerTable1.getTableManager().getRowElementsList().contains(subModelTable3));

		//verify in table 2
		IAxisManager rowAxisManagerTable2 = manager2.getRowAxisManager();
		Collection<Object> managedAxisTable2 = rowAxisManagerTable2.getAllManagedAxis();
		Assert.assertEquals(2, managedAxisTable2.size());
		Assert.assertFalse(managedAxisTable2.contains(subModelTable3));
		Assert.assertEquals(managedAxisTable2.size(), rowAxisManagerTable2.getTableManager().getRowElementsList().size());
		Assert.assertFalse(rowAxisManagerTable2.getTableManager().getRowElementsList().contains(subModelTable3));
	}

	@AfterClass
	public static void endOfTest() {
		GenericUtils.closeAllEditors();
	}


}
