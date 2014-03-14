/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.editor.integration.tests.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.OpenDiagramCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.integration.tests.Activator;
import org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.junit.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.UmlClassDiagramForMultiEditor;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.UmlTimingDiagramForMultiEditor;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests the basic PageManager cases, integrated with the CoreMultiDiagramEditor
 * and a few UML Diagrams/Tables
 *
 * @author Camille Letavernier
 *
 */
public class PageManagerTests extends AbstractEditorIntegrationTest {

	public static final String SOURCE_PATH = "/model/basic/";

	@Test
	public void testModelWithDiagramCreation() throws Exception {
		ModelSet modelSet = new DiResourceSet();
		IProject emptyModelCreationProject = ResourcesPlugin.getWorkspace().getRoot().getProject("diagramModelCreation");
		emptyModelCreationProject.create(new NullProgressMonitor());
		emptyModelCreationProject.open(new NullProgressMonitor());

		final IFile emptyModelDi = emptyModelCreationProject.getFile("diagram_model_creation.di");

		modelSet.createsModels(emptyModelDi);

		IFile emptyModelNotation = emptyModelCreationProject.getFile("diagram_model_creation.notation");
		IFile emptyModelUml = emptyModelCreationProject.getFile("diagram_model_creation.uml");

		ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		try {
			registry.add(ModelSet.class, Integer.MAX_VALUE, modelSet);
			registry.startRegistry();
		} catch (ServiceException ex) {
			//Ignore
		}

		IModelCreationCommand creationCommand = new CreateUMLModelCommand();
		creationCommand.createModel(modelSet);

		//Create the root UML Model
		UmlModel umlModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		Model model = (Model)umlModel.lookupRoot();

		//Creates and opens a Papyrus Class Diagram
		ICreationCommand diagramCreationCommand = new CreateClassDiagramCommand();
		diagramCreationCommand.createDiagram(modelSet, model, "TestDiagram1");

		modelSet.save(new NullProgressMonitor());

		Assert.assertTrue("The DI file has not been created", emptyModelDi.exists());
		Assert.assertTrue("The Notation file has not been created", emptyModelNotation.exists());
		Assert.assertTrue("The UML file has not been created", emptyModelUml.exists());

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					editor = EditorUtils.openPapyrusEditor(emptyModelDi);
				} catch (Exception ex) {
					Activator.log.error(ex);
					Assert.fail(ex.getMessage());
				}
			}
		});

		Assert.assertNotNull("Cannot open the Papyrus editor", editor);
		Assert.assertTrue("The active editor should be a Papyrus Class Diagram editor", editor.getActiveEditor() instanceof UmlClassDiagramForMultiEditor);

		try {
			registry.disposeRegistry();
		} catch (ServiceException ex) {
			//Ignore
		}
	}

	@Test
	public void testEmptyModelCreation() throws Exception {
		final IFile emptyModelDi = createEmptyModel();
		Assert.assertNotNull(emptyModelDi);

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					editor = EditorUtils.openPapyrusEditor(emptyModelDi);
				} catch (Exception ex) {
					Activator.log.error(ex);
					Assert.fail(ex.getMessage());
				}
			}
		});

		Assert.assertNotNull("Cannot open the editor", editor);
		openAndCheckCreatedModel(emptyModelDi);
	}

	private IFile createEmptyModel() throws Exception {
		ModelSet modelSet = new DiResourceSet();
		IProject emptyModelCreationProject = ResourcesPlugin.getWorkspace().getRoot().getProject("emptyModelCreation");
		emptyModelCreationProject.create(new NullProgressMonitor());
		emptyModelCreationProject.open(new NullProgressMonitor());

		final IFile emptyModelDi = emptyModelCreationProject.getFile("empty_model_creation.di");

		modelSet.createsModels(emptyModelDi);

		IModelCreationCommand creationCommand = new CreateUMLModelCommand();
		creationCommand.createModel(modelSet);

		modelSet.save(new NullProgressMonitor());

		IFile emptyModelNotation = emptyModelCreationProject.getFile("empty_model_creation.notation");
		IFile emptyModelUml = emptyModelCreationProject.getFile("empty_model_creation.uml");

		Assert.assertTrue("The DI file has not been created", emptyModelDi.exists());
		Assert.assertTrue("The Notation file has not been created", emptyModelNotation.exists());
		Assert.assertTrue("The UML file has not been created", emptyModelUml.exists());
		return emptyModelDi;
	}

	private void openAndCheckCreatedModel(IFile emptyModelDi) throws Exception {
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertNotNull("Cannot retrieve the PageManager", pageManager);
		Assert.assertTrue(pageManager.allPages().isEmpty());

		ModelSet modelSet = editor.getServicesRegistry().getService(ModelSet.class);
		Assert.assertNotNull("Cannot retrieve the ModelSet", modelSet);

		UmlModel umlModel = (UmlModel)modelSet.getModel(UmlModel.MODEL_ID);
		Assert.assertNotNull("Cannot retrieve the UML Model", umlModel);

		EObject rootEObject = umlModel.lookupRoot();
		Assert.assertTrue("The rootElement is not a model", rootEObject instanceof Model);
	}

	@Test
	public void testOpenEmptyModel() throws Exception {
		initModel("openEmptyModel", "empty_model", getBundle());
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(0, pageManager.allPages().size());
	}

	@Test
	public void testAvailableAndActivePage() throws Exception {
		initModel("availableAndActivePage", "two_diagrams_model", getBundle());
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(2, pageManager.allPages().size());

		Assert.assertTrue(editor.getActiveEditor() instanceof UmlClassDiagramForMultiEditor); //TODO: The PageManager doesn't provide the getActivePage() method

		Resource notationResource = NotationUtils.getNotationModel(editor.getServicesRegistry().getService(ModelSet.class)).getResource();

		Diagram classDiagram = (Diagram)notationResource.getContents().get(0);
		Diagram timingDiagram = (Diagram)notationResource.getContents().get(1);

		TransactionalEditingDomain editingDomain = editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, timingDiagram)));
		Assert.assertTrue(editor.getActiveEditor() instanceof UmlTimingDiagramForMultiEditor);


		// Check type requested by selectPage
		ISashWindowsContainer container = editor.getServicesRegistry().getService(ISashWindowsContainer.class);
		IPage selectedPage = container.getActiveSashWindowsPage();

		//FIXME: Does not work yet. See Bug 401107: [IPageManager] selectPage does not work
		//TODO: There should be a specific test for selectPage, with a basic and a complex model
		pageManager.selectPage(classDiagram);
		Assert.assertTrue("Couldn't change the page selection", editor.getActiveEditor() instanceof UmlClassDiagramForMultiEditor);

		pageManager.selectPage(timingDiagram);
		Assert.assertTrue("Couldn't change the page selection", editor.getActiveEditor() instanceof UmlTimingDiagramForMultiEditor);
	}

	/**
	 * @author vincent lorenzo
	 * @throws Exception
	 */
	@Test
	@Ignore("new papyrus table are not yet in the main build")
	public void testAvailableAndActivePageWithNatTable() throws Exception {
		//		initModel("availableAndActivePage2", "two_tables_model");
		//		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		//		Assert.assertEquals(2, pageManager.allPages().size());
		//		IEditorPart tableEditor = editor.getActiveEditor();
		//		Assert.assertTrue(tableEditor instanceof NatTableEditor); //TODO: The PageManager doesn't provide the getActivePage() method
		//		INattableModelManager manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		//		Assert.assertNotNull(manager);
		//		Assert.assertEquals("PapyrusGenericTable", manager.getTable().getTableConfiguration().getType());
		//
		//		Resource notationResource = NotationUtils.getNotationModel(editor.getServicesRegistry().getService(ModelSet.class)).getResource();
		//
		//		Table genericTable = (Table)notationResource.getContents().get(0);
		//		Table tableOfViews = (Table)notationResource.getContents().get(1);
		//
		//		TransactionalEditingDomain editingDomain = editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		//		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, tableOfViews)));
		//		tableEditor = editor.getActiveEditor();
		//		Assert.assertTrue(tableEditor instanceof NatTableEditor);
		//		manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		//		Assert.assertNotNull(manager);
		//		Assert.assertEquals("PapyrusViewsTable", manager.getTable().getTableConfiguration().getType());
		//
		//		//FIXME: Does not work yet. See Bug 401107: [IPageManager] selectPage does not work
		//		//TODO: There should be a specific test for selectPage, with a basic and a complex model
		//		pageManager.selectPage(genericTable);
		//		tableEditor = editor.getActiveEditor();
		//		Assert.assertTrue(tableEditor instanceof NatTableEditor); //TODO: The PageManager doesn't provide the getActivePage() method
		//		manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		//		Assert.assertNotNull(manager);
		//		Assert.assertEquals("Couldn't change the page selection", "PapyrusGenericTable", manager.getTable().getTableConfiguration().getType());
		//
		//
		//		pageManager.selectPage(tableOfViews);
		//		tableEditor = editor.getActiveEditor();
		//		Assert.assertTrue(tableEditor instanceof NatTableEditor); //TODO: The PageManager doesn't provide the getActivePage() method
		//		manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		//		Assert.assertNotNull(manager);
		//		Assert.assertEquals("Couldn't change the page selection", "PapyrusViewsTable", manager.getTable().getTableConfiguration().getType());
	}

	@Test
	public void testDiagramCreation() throws Exception {
		initModel("diagramCreation", "empty_model", getBundle());
		ICreationCommand diagramCreationCommand = new CreateClassDiagramCommand();
		ModelSet modelSet = editor.getServicesRegistry().getService(ModelSet.class);

		TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();

		CompositeCommand createAndOpenDiagram = new CompositeCommand("Create diagram");
		ICommand creationCommand = diagramCreationCommand.getCreateDiagramCommand(modelSet, null, "DiagramCreationTestDiagram");
		createAndOpenDiagram.add(creationCommand);
		createAndOpenDiagram.add(new OpenDiagramCommand(editingDomain, creationCommand));

		testPageCreation(createAndOpenDiagram, UmlClassDiagramForMultiEditor.class);
	}

	@Test
	public void testDiagramDeletion() throws Exception {
		initModel("diagramDeletion", "simple_class_model", getBundle());
		ModelSet modelSet = getModelSet();
		final Diagram diagram = (Diagram)NotationUtils.getNotationModel(modelSet).getResource().getContents().get(0);
		testPageDeletion(diagram, UmlClassDiagramForMultiEditor.class);
	}

	/**
	 * @author vincent lorenzo
	 * @throws Exception
	 */
	@Test
	@Ignore("new papyrus table are not yet in the main build")
	public void testNatTableDeletion() throws Exception {
		//		initModel("tableDeletion", "simple_uml_generic_table_model");
		//		ModelSet modelSet = getModelSet();
		//		final Table diagram = (Table)NotationUtils.getNotationModel(modelSet).getResource().getContents().get(0);
		//		testPageDeletion(diagram, NatTableEditor.class);
	}

	//Does not work. The table creation produces two executable commands (Create Table Editor and Identity)
	//Only Identity (which does nothing) is undoable. Undoing the table creation does nothing
	//This is an EMF Facet Table bug, which tries to delete columns for an empty table as soon as the table is created
	@Test
	public void testTableCreation() throws Exception {
		initModel("tableCreation", "empty_model", getBundle());

		final ServicesRegistry registry = editor.getServicesRegistry();
		ModelSet modelSet = registry.getService(ModelSet.class);
		TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();

		final EObject tableContext = UmlUtils.getUmlModel(modelSet).getResource().getContents().get(0);


	}


	private void testPageCreation(ICommand creationCommand, Class<?> expectedEditorClass) throws Exception {
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);

		//Check initial state
		Assert.assertTrue(pageManager.allPages().isEmpty());
		Assert.assertNull(editor.getActiveEditor());

		EditingDomain editingDomain = editor.getServicesRegistry().getService(EditingDomain.class);

		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(creationCommand));

		for(int i = 0; i < 3; i++) { //Undo/Redo 3 times
			Assert.assertEquals("The page has not been correctly created", 1, pageManager.allPages().size());
			Assert.assertTrue("The editor has not been correctly opened", expectedEditorClass.isInstance(editor.getActiveEditor()));

			editingDomain.getCommandStack().undo();

			Assert.assertNull("The editor should be closed", editor.getActiveEditor());
			Assert.assertTrue("The page has not been correctly deleted", pageManager.allPages().isEmpty());

			editingDomain.getCommandStack().redo();
		}
	}

	private void testPageDeletion(final EObject page, Class<?> expectedEditorClass) throws Exception {
		final IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);

		//Check initial state
		Assert.assertFalse(pageManager.allPages().isEmpty());
		int initialPagesSize = pageManager.allPages().size();

		Assert.assertTrue(expectedEditorClass.isInstance(editor.getActiveEditor()));

		TransactionalEditingDomain editingDomain = editor.getServicesRegistry().getService(TransactionalEditingDomain.class);

		CompoundCommand command = new CompoundCommand("Delete diagram");

		Command sashRemoveComd = new RecordingCommand(editingDomain, "Remove page") {

			@Override
			protected void doExecute() {
				pageManager.removePage(page);
			}

		};

		command.append(sashRemoveComd);
		command.append(new GMFtoEMFCommandWrapper(new DestroyElementPapyrusCommand(new DestroyElementRequest(page, false))));

		editingDomain.getCommandStack().execute(command);

		for(int i = 0; i < 3; i++) { //Undo/Redo 3 times
			Assert.assertNull("The editor should be closed", editor.getActiveEditor());
			Assert.assertEquals("The page has not been correctly deleted", initialPagesSize - 1, pageManager.allPages().size());

			editingDomain.getCommandStack().undo();

			Assert.assertEquals("The has not been correctly created", initialPagesSize, pageManager.allPages().size());
			Assert.assertTrue("The editor has not been correctly opened", expectedEditorClass.isInstance(editor.getActiveEditor()));

			editingDomain.getCommandStack().redo();
		}
	}

	@Test
	public void testContainedDiagramDeletion() throws Exception {
		initModel("deleteContainedDiagrams", "delete_contained_diagram", getBundle());
		ModelSet modelSet = getModelSet();
		IPageManager pageManager = getPageManager();
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();

		final int initialSize = pageManager.allPages().size();
		Model model = (Model)UmlUtils.getUmlModel(modelSet).getResource().getContents().get(0);

		IElementEditService provider;

		Element firstRootElement = model.getOwnedElements().get(0);
		Element secondRootElement = model.getOwnedElements().get(1);

		{
			DestroyElementRequest destroyFirstElementRequest = new DestroyElementRequest(firstRootElement, false);
			provider = ElementEditServiceUtils.getCommandProvider(firstRootElement);
			ICommand destroyFirstElementCommand = provider.getEditCommand(destroyFirstElementRequest);

			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(destroyFirstElementCommand));
			Assert.assertEquals("The page should have been destroyed", initialSize - 1, pageManager.allPages().size());
			//TODO: Test the opened pages too
		}

		{
			DestroyElementRequest destroySecondElementRequest = new DestroyElementRequest(secondRootElement, false);
			provider = ElementEditServiceUtils.getCommandProvider(secondRootElement);
			ICommand destroySecondElementCommand = provider.getEditCommand(destroySecondElementRequest);

			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(destroySecondElementCommand));
			Assert.assertTrue("All remaining pages should have been destroyed", pageManager.allPages().isEmpty());
		}

		editingDomain.getCommandStack().undo();

		Assert.assertEquals("The deleted pages should have been restored", initialSize - 1, pageManager.allPages().size());

		editingDomain.getCommandStack().undo();

		Assert.assertEquals("All pages should have been restored", initialSize, pageManager.allPages().size());

		editingDomain.getCommandStack().redo();
		editingDomain.getCommandStack().redo();

		Assert.assertTrue("All remaining pages should have been destroyed", pageManager.allPages().isEmpty());
	}

	/**
	 * @author vincent lorenzo
	 * @throws Exception
	 */
	@Test
	public void testContainedNatTableDeletion() throws Exception {
		initModel("deleteContainedNatTable", "delete_contained_table", getBundle());
		ModelSet modelSet = getModelSet();
		IPageManager pageManager = getPageManager();
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();

		final int initialSize = pageManager.allPages().size();
		Model model = (Model)UmlUtils.getUmlModel(modelSet).lookupRoot();

		IElementEditService provider;

		Element firstRootElement = model.getOwnedElements().get(0);
		Element secondRootElement = model.getOwnedElements().get(1);

		{
			DestroyElementRequest destroyFirstElementRequest = new DestroyElementRequest(firstRootElement, false);
			provider = ElementEditServiceUtils.getCommandProvider(firstRootElement);
			ICommand destroyFirstElementCommand = provider.getEditCommand(destroyFirstElementRequest);

			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(destroyFirstElementCommand));
			Assert.assertEquals("The page should have been destroyed", initialSize - 1, pageManager.allPages().size());
			//TODO: Test the opened pages too
		}

		{
			DestroyElementRequest destroySecondElementRequest = new DestroyElementRequest(secondRootElement, false);
			provider = ElementEditServiceUtils.getCommandProvider(secondRootElement);
			ICommand destroySecondElementCommand = provider.getEditCommand(destroySecondElementRequest);

			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(destroySecondElementCommand));
			Assert.assertTrue("All remaining pages should have been destroyed", pageManager.allPages().isEmpty());
		}

		editingDomain.getCommandStack().undo();

		Assert.assertEquals("The deleted pages should have been restored", initialSize - 1, pageManager.allPages().size());

		editingDomain.getCommandStack().undo();

		Assert.assertEquals("All pages should have been restored", initialSize, pageManager.allPages().size());

		editingDomain.getCommandStack().redo();
		editingDomain.getCommandStack().redo();

		Assert.assertTrue("All remaining pages should have been destroyed", pageManager.allPages().isEmpty());
	}

	@Ignore("Unsupported yet")
	@Test
	public void testContainedTableDeletion() throws Exception {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Test
	public void testMultipageEditor() throws Exception {
		initModel("multipageEditor", "complex_multipage_model", getBundle());
	}

	@Test
	public void testOpenModel() throws Exception {
		initModel("openModel", "complex_multipage_model", getBundle());
	}

	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}

}
