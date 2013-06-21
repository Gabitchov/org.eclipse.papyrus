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
package org.eclipse.papyrus.sysml.nattable.requirement.tests.tests;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.junit.utils.ModelExplorerUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.sysml.nattable.requirement.tests.Activator;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public class TableCreationInSysMLModelTest {

	private static Class class_;

	private static Class requirement1;

	private static Class requirement2;

	private static Class requirement3;

	private static Class nestedRequirement1;

	private static Class nestedRequirement2;

	private static Class nestedRequirement3;

	private static final String MODEL_PATH = "/resources/sysmlModel"; //$NON-NLS-1$

	private static final String SOURCE_PATH = "/resources/"; //$NON-NLS-1$

	private static final String FILE_ROOT_NAME = "sysmlModel"; //$NON-NLS-1$

	private static final String PROJECT_NAME = "test"; //$NON-NLS-1$

	private static IMultiDiagramEditor papyrusEditor;

	private static final String BUNDLE_ID = Activator.getDefault().getBundle().getSymbolicName();

	protected static Model rootModel;

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
					TableCreationInSysMLModelTest.view = ModelExplorerUtils.openModelExplorerView();
				} catch (PartInitException e) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage()));
				}
				EObject root = ModelExplorerUtils.getRootInModelExplorer(TableCreationInSysMLModelTest.view);
				TableCreationInSysMLModelTest.rootModel = (Model)root;
				class_ = (Class)TableCreationInSysMLModelTest.rootModel.getMember("Class1"); //$NON-NLS-1$
				requirement1 = (Class)TableCreationInSysMLModelTest.rootModel.getMember("Requirement1"); //$NON-NLS-1$
				requirement2 = (Class)TableCreationInSysMLModelTest.rootModel.getMember("Requirement2"); //$NON-NLS-1$
				if(requirement1 != null) {
					nestedRequirement1 = (Class)requirement1.getMember("NestedRequirement1"); //$NON-NLS-1$
					nestedRequirement2 = (Class)requirement1.getMember("NestedRequirement2"); //$NON-NLS-1$
					setStatus(Status.OK_STATUS);

				} else {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), "Requirement1 not found")); //$NON-NLS-1$

				}

			}

		};
		Display.getDefault().syncExec(runnableWithResult);
//		try {
//			Platform.getBundle("org.eclipse.papyrus.infra.nattable.common").start(); //$NON-NLS-1$
//			Platform.getBundle("org.eclipse.papyrus.sysml.nattable.requirement").start(); //$NON-NLS-1$
//			Platform.getBundle("org.eclipse.papyrus.sysml.nattable.requirement.config").start(); //$NON-NLS-1$
//		} catch (BundleException e) {
//			throw e;
//		}
		Assert.assertEquals(runnableWithResult.getStatus().getMessage(), IStatus.OK, runnableWithResult.getStatus().getSeverity());
		Assert.assertNotNull(class_);
		Assert.assertNotNull(requirement1);
		Assert.assertNotNull(requirement2);
		Assert.assertNotNull(TableCreationInSysMLModelTest.rootModel);



	}

	@Test
	public void testCreationHandlerStatusOnRootModel() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationInSysMLModelTest.view, AllTests.COMMAND_ID, TableCreationInSysMLModelTest.rootModel, true);
	}

	@Test
	public void testCreationHandlerStatusOnRequirement() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationInSysMLModelTest.view, AllTests.COMMAND_ID, requirement1, true);
	}

	@Test
	public void testCreationHandlerStatusOnClass() {
		ModelExplorerUtils.testHandlerStatusInModelExplorer(TableCreationInSysMLModelTest.view, AllTests.COMMAND_ID, class_, false);
	}

	@Test
	public void testCreationAndDestructionOnRootModel() {
		Object result = ModelExplorerUtils.executeCreateNestedEditorHandlerInModelExplorer(papyrusEditor, TableCreationInSysMLModelTest.view, AllTests.COMMAND_ID, TableCreationInSysMLModelTest.rootModel, BUNDLE_ID);
		Assert.assertTrue(result instanceof NatTableEditor);
		NatTableEditor editor = (NatTableEditor)result;
		NattableModelManager manager = (NattableModelManager)editor.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager);
		Table table = manager.getTable();
		Assert.assertEquals(AllTests.REQUIREMENT_TABLE_ID, table.getTableConfiguration().getType());

		IAxisManager rowAxisManager = manager.getRowAxisManager();
		Collection<Object> managedAxis = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(2, managedAxis.size());
		Assert.assertTrue(managedAxis.contains(requirement1));
		Assert.assertTrue(managedAxis.contains(requirement2));


		Assert.assertEquals(managedAxis.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(requirement1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(requirement2));

		final TransactionalEditingDomain domain = (TransactionalEditingDomain)papyrusEditor.getAdapter(TransactionalEditingDomain.class);
		Assert.assertNotNull(domain);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(TableCreationInSysMLModelTest.rootModel);
		Assert.assertNotNull(provider);
		CreateElementRequest request = new CreateElementRequest(domain, TableCreationInSysMLModelTest.rootModel, SysMLElementTypes.REQUIREMENT);
		final ICommand creationCommand = provider.getEditCommand(request);
		Assert.assertNotNull(creationCommand);
		Assert.assertTrue(creationCommand.canExecute());

		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(creationCommand));
		NamedElement requirement = TableCreationInSysMLModelTest.rootModel.getMember("Requirement3"); //$NON-NLS-1$
		Assert.assertNotNull(requirement);
		requirement3 = (Class)requirement;
		//to refresh the table content
		while(Display.getDefault().readAndDispatch());
		managedAxis = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(3, managedAxis.size());
		Assert.assertTrue(managedAxis.contains(requirement1));
		Assert.assertTrue(managedAxis.contains(requirement2));
		Assert.assertTrue(managedAxis.contains(requirement3));
		Assert.assertEquals(managedAxis.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(requirement1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(requirement2));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(requirement3));

		DestroyElementRequest destroyRequest = new DestroyElementRequest(domain, requirement3, false);
		provider = ElementEditServiceUtils.getCommandProvider(requirement3);
		final ICommand destroyCommand = provider.getEditCommand(destroyRequest);
		Assert.assertNotNull(destroyCommand);
		Assert.assertTrue(destroyCommand.canExecute());

		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(destroyCommand));
		requirement = TableCreationInSysMLModelTest.rootModel.getMember("Requirement3"); //$NON-NLS-1$
		Assert.assertNull(requirement);
		requirement3 = (Class)requirement;
		//to refresh the table content
		while(Display.getDefault().readAndDispatch());
		managedAxis = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(2, managedAxis.size());
		Assert.assertTrue(managedAxis.contains(requirement1));
		Assert.assertTrue(managedAxis.contains(requirement2));

		Assert.assertEquals(managedAxis.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(requirement1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(requirement2));
	}

	@Test
	public void testCreationAndDestructionOnRequirement() {
		Object result = ModelExplorerUtils.executeCreateNestedEditorHandlerInModelExplorer(papyrusEditor, TableCreationInSysMLModelTest.view, AllTests.COMMAND_ID, TableCreationInSysMLModelTest.requirement1, BUNDLE_ID);
		Assert.assertTrue(result instanceof NatTableEditor);
		NatTableEditor editor = (NatTableEditor)result;
		NattableModelManager manager = (NattableModelManager)editor.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager);
		Table table = manager.getTable();
		Assert.assertEquals(AllTests.REQUIREMENT_TABLE_ID, table.getTableConfiguration().getType());

		IAxisManager rowAxisManager = manager.getRowAxisManager();
		Collection<Object> managedAxis = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(2, managedAxis.size());
		Assert.assertTrue(managedAxis.contains(nestedRequirement1));
		Assert.assertTrue(managedAxis.contains(nestedRequirement2));


		Assert.assertEquals(managedAxis.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(nestedRequirement1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(nestedRequirement2));

		final TransactionalEditingDomain domain = (TransactionalEditingDomain)papyrusEditor.getAdapter(TransactionalEditingDomain.class);
		Assert.assertNotNull(domain);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(TableCreationInSysMLModelTest.requirement1);
		Assert.assertNotNull(provider);
		CreateElementRequest request = new CreateElementRequest(domain, TableCreationInSysMLModelTest.requirement1, SysMLElementTypes.REQUIREMENT);
		final ICommand creationCommand = provider.getEditCommand(request);
		Assert.assertNotNull(creationCommand);
		Assert.assertTrue(creationCommand.canExecute());

		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(creationCommand));
		NamedElement requirement = TableCreationInSysMLModelTest.requirement1.getMember("Requirement1"); //$NON-NLS-1$
		Assert.assertNotNull(requirement);
		nestedRequirement3 = (Class)requirement;

		//to refresh the table content
		while(Display.getDefault().readAndDispatch());
		managedAxis = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(3, managedAxis.size());
		Assert.assertTrue(managedAxis.contains(nestedRequirement1));
		Assert.assertTrue(managedAxis.contains(nestedRequirement2));
		Assert.assertTrue(managedAxis.contains(nestedRequirement3));
		Assert.assertEquals(managedAxis.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(nestedRequirement1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(nestedRequirement2));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(nestedRequirement3));

		DestroyElementRequest destroyRequest = new DestroyElementRequest(domain, nestedRequirement3, false);
		provider = ElementEditServiceUtils.getCommandProvider(nestedRequirement3);
		final ICommand destroyCommand = provider.getEditCommand(destroyRequest);
		Assert.assertNotNull(destroyCommand);
		Assert.assertTrue(destroyCommand.canExecute());
		
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(destroyCommand));
		requirement = TableCreationInSysMLModelTest.requirement1.getMember("Requirement1"); //$NON-NLS-1$
		Assert.assertNull(requirement);
		nestedRequirement3 = (Class)requirement;
		
		//to refresh the table content
		while(Display.getDefault().readAndDispatch());

		managedAxis = rowAxisManager.getAllManagedAxis();
		Assert.assertEquals(2, managedAxis.size());
		Assert.assertTrue(managedAxis.contains(nestedRequirement1));
		Assert.assertTrue(managedAxis.contains(nestedRequirement2));

		Assert.assertEquals(managedAxis.size(), rowAxisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(nestedRequirement1));
		Assert.assertTrue(rowAxisManager.getTableManager().getRowElementsList().contains(nestedRequirement2));
	}

}
