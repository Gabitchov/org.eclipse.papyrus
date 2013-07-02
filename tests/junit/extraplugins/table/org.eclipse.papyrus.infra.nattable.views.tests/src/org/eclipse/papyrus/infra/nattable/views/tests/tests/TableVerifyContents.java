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
import java.util.List;

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
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Model;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public class TableVerifyContents {

	private static final String MODEL_PATH = "/resources/model2"; //$NON-NLS-1$

	private static final String SOURCE_PATH = "/resources/"; //$NON-NLS-1$

	private static final String FILE_ROOT_NAME = "model2"; //$NON-NLS-1$

	private static final String PROJECT_NAME = "test"; //$NON-NLS-1$

	private static IMultiDiagramEditor papyrusEditor;

	private static final String BUNDLE_ID = Activator.getDefault().getBundle().getSymbolicName();

	private static Model rootModel;

	private static Model subModel;

	private static Table table1;

	private static Diagram diagram1;

	private static Diagram diagram2;

	private static ModelExplorerView view;

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
					TableVerifyContents.view = ModelExplorerUtils.openModelExplorerView();
				} catch (PartInitException e) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), e.getMessage()));
				}
				EObject root = ModelExplorerUtils.getRootInModelExplorer(TableVerifyContents.view);
				TableVerifyContents.rootModel = (Model)root;
				subModel = (Model)TableVerifyContents.rootModel.getMember("SubModel1"); //$NON-NLS-1$

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
		Assert.assertNotNull(TableVerifyContents.rootModel);
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
	public void verifyContentsForTable1() throws ServiceException {
		IPageManager pageManager = papyrusEditor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(3, pageManager.allPages().size());
		IEditorPart tableEditor = papyrusEditor.getActiveEditor();
		Assert.assertNull(tableEditor);
		TransactionalEditingDomain editingDomain = papyrusEditor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, table1)));
		tableEditor = papyrusEditor.getActiveEditor();
		Assert.assertTrue(tableEditor instanceof NatTableEditor);
		INattableModelManager manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager);
		Assert.assertEquals(AllTests.VIEWS_TABLE_ID, manager.getTable().getTableConfiguration().getType());

		IAxisManager axisManager = manager.getRowAxisManager();
		final Collection<Object> managedAxis_subSubPackageTable1 = axisManager.getAllManagedAxis();
		Assert.assertEquals(2, managedAxis_subSubPackageTable1.size());
		Assert.assertTrue(managedAxis_subSubPackageTable1.contains(table1));
		Assert.assertTrue(managedAxis_subSubPackageTable1.contains(diagram2));

		Assert.assertEquals(managedAxis_subSubPackageTable1.size(), axisManager.getTableManager().getRowElementsList().size());
		Assert.assertTrue(axisManager.getTableManager().getRowElementsList().contains(table1));
		Assert.assertTrue(axisManager.getTableManager().getRowElementsList().contains(diagram2));
	}

	@AfterClass
	public static void endOfTest() {
		GenericUtils.closeAllEditors();
	}

}
