/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.copypaste;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Test class for Copy/paste actions with copied elements that are context of diagrams. Diagrams should be duplicated also.
 */
@Ignore
public class TestCopyPasteElementsWithDiagrams {

	/** is the test initialized already */
	public static boolean isInitialized = false;

	/** main papyrus editor part */
	public static IEditorPart editor = null;

	/** id of the editor */
	public static String editorID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	/** block B1_P1 */
	private static View viewBlockB1_P1;

	private static GraphicalEditPart editPartBlockB1_P1;

	/** block B2_P1 */
	private static View viewBlockB2_P1;

	private static GraphicalEditPart editPartBlockB2_P1;

	/** block B1_P1_P1 */
	private static View viewBlockB1_P1_P1;

	private static GraphicalEditPart editPartBlockB1_P1_P1;

	/** block B2_P1_P1 */
	private static View viewBlockB2_P1_P1;

	private static GraphicalEditPart editPartBlockB2_P1_P1;

	/** block B1_P2 */
	private static View viewBlockB1_P2;

	private static GraphicalEditPart editPartBlockB1_P2;

	/** block B2_P2 */
	private static View viewBlockB2_P2;

	private static GraphicalEditPart editPartBlockB2_P2;

	/** package P1 */
	private static View viewPackageP1;

	private static GraphicalEditPart editPartPackageP1;

	/** package P1_P1 */
	private static View viewPackageP1_P1;

	private static GraphicalEditPart editPartPackageP1_P1;

	/** package P2 */
	private static View viewPackageP2;

	private static GraphicalEditPart editPartPackageP2;

	/** initial list of diagrams */
	private static ArrayList<Diagram> initialDiagrams;

	/** initial number of diagrams */
	private static final int initialNumberOfDiagrams = 4;

	private static final int initialNumberOfDiagramsP4 = 1;
	/** package P4 */
	private static View viewPackageP4_P1;

	private static GraphicalEditPart editPartPackageP4_P1;

	/** block B1_P4 */
	private static View viewBlockB1_P4_P1;

	private static GraphicalEditPart editPartBlockB1_P4_P1;


	/**
	 * Initialization of the test: open Papyrus editor with a given model
	 * 
	 * @throws Exception
	 *         exception thrown if errors
	 */
	@BeforeClass
	public static void openPapyrusWithAnEmptyProject() throws Exception {
		IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
		PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
		// Prepare new project for tests
		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestProject");
		if(!testProject.exists()) {
			testProject.create(new NullProgressMonitor());
		}

		if(!testProject.isOpen()) {
			testProject.open(new NullProgressMonitor());
		}

		// Copy EmptyModel from bundle to the test project
		IFile emptyModel_di = testProject.getFile("ModelWithDiagrams.di");
		IFile emptyModel_no = testProject.getFile("ModelWithDiagrams.notation");
		IFile emptyModel_uml = testProject.getFile("ModelWithDiagrams.uml");
		IFile locaProfile_uml = testProject.getFile("LocalProfile.profile.uml");
		IFile controledModel_di = testProject.getFile("P4.di");
		IFile controledModel_no = testProject.getFile("P4.notation");
		IFile controledModel_uml = testProject.getFile("P4.uml");

		// isInitialized = isInitialized || emptyModel_di.exists();

		if(!isInitialized) {
			isInitialized = true;
			emptyModel_di.create(Activator.getInstance().getBundle().getResource("/model/ModelWithDiagrams.di").openStream(), true, new NullProgressMonitor());
			emptyModel_no.create(Activator.getInstance().getBundle().getResource("/model/ModelWithDiagrams.notation").openStream(), true, new NullProgressMonitor());
			emptyModel_uml.create(Activator.getInstance().getBundle().getResource("/model/ModelWithDiagrams.uml").openStream(), true, new NullProgressMonitor());
			locaProfile_uml.create(Activator.getInstance().getBundle().getResource("/model/LocalProfile.profile.uml").openStream(), true, new NullProgressMonitor());
			controledModel_di.create(Activator.getInstance().getBundle().getResource("/model/P4.di").openStream(), true, new NullProgressMonitor());
			controledModel_no.create(Activator.getInstance().getBundle().getResource("/model/P4.notation").openStream(), true, new NullProgressMonitor());
			controledModel_uml.create(Activator.getInstance().getBundle().getResource("/model/P4.uml").openStream(), true, new NullProgressMonitor());
		}

		// Open the EmptyModel.di file with Papyrus (assumed to be the default editor for "di" files here).
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		editor = page.openEditor(new FileEditorInput(emptyModel_di), editorID);
		page.getActiveEditor().setFocus();
		
		initEditPartsAndViews();
	}

	/**
	 * Before class: initializes variables for the tests
	 * 
	 * @throws Exception
	 *         exception thrown when there are errors.
	 */
	public static void initEditPartsAndViews() throws Exception {
		DiagramEditPart diagramEditPart = EditorUtils.getDiagramEditPart();
		
		/** package P1 */
		editPartPackageP1 = EditorUtils.getEditPart(diagramEditPart, "P1", null, true, false, false);
		viewPackageP1 = (editPartPackageP1.getModel() instanceof View) ? (View)editPartPackageP1.getModel() : null;
		if(viewPackageP1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartPackageP1.getModel());

		/** package P1_P1 */
		editPartPackageP1_P1 = EditorUtils.getEditPart(diagramEditPart, "P1_P1", null, true, false, false);
		viewPackageP1_P1 = (editPartPackageP1_P1.getModel() instanceof View) ? (View)editPartPackageP1_P1.getModel() : null;
		if(viewPackageP1_P1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartPackageP1_P1.getModel());

		/** package P2 */
		editPartPackageP2 = EditorUtils.getEditPart(diagramEditPart, "P2", null, true, false, false);
		viewPackageP2 = (editPartPackageP2.getModel() instanceof View) ? (View)editPartPackageP2.getModel() : null;
		if(viewPackageP2 == null)
			throw new Exception("Impossible to cast into a view:" + editPartPackageP2.getModel());
		
		/** package P4 */
		editPartPackageP4_P1 = EditorUtils.getEditPart(diagramEditPart, "P4_P1", null, true, false, false);
		viewPackageP4_P1 = (editPartPackageP4_P1.getModel() instanceof View) ? (View)editPartPackageP4_P1.getModel() : null;
		if(viewPackageP4_P1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartPackageP4_P1.getModel());

		/** Block B1_P1 */
		editPartBlockB1_P1 = EditorUtils.getEditPart(diagramEditPart, "B1_P1", SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, true, false, false);
		viewBlockB1_P1 = (editPartBlockB1_P1.getModel() instanceof View) ? (View)editPartBlockB1_P1.getModel() : null;
		if(viewBlockB1_P1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartBlockB1_P1.getModel());
		
		/** Block B2_P1 */
		editPartBlockB2_P1 = EditorUtils.getEditPart(diagramEditPart, "B2_P1", SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, true, false, false);
		viewBlockB2_P1 = (editPartBlockB2_P1.getModel() instanceof View) ? (View)editPartBlockB2_P1.getModel() : null;
		if(viewBlockB2_P1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartBlockB2_P1.getModel());

		/** Block B1_P2 */
		editPartBlockB1_P2 = EditorUtils.getEditPart(diagramEditPart, "B1_P2", SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, true, false, false);
		viewBlockB1_P2 = (editPartBlockB1_P2.getModel() instanceof View) ? (View)editPartBlockB1_P2.getModel() : null;
		if(viewBlockB1_P2 == null)
			throw new Exception("Impossible to cast into a view:" + editPartBlockB1_P2.getModel());

		/** Block B2_P2 */
		editPartBlockB2_P2 = EditorUtils.getEditPart(diagramEditPart, "B2_P2", SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, true, false, false);
		viewBlockB2_P2 = (editPartBlockB2_P2.getModel() instanceof View) ? (View)editPartBlockB2_P2.getModel() : null;
		if(viewBlockB2_P2 == null)
			throw new Exception("Impossible to cast into a view:" + editPartBlockB2_P2.getModel());

		/** Block B1_P1_P1 */
		editPartBlockB1_P1_P1 = EditorUtils.getEditPart(diagramEditPart, "B1_P1_P1", SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, true, false, false);
		viewBlockB1_P1_P1 = (editPartBlockB1_P1_P1.getModel() instanceof View) ? (View)editPartBlockB1_P1_P1.getModel() : null;
		if(viewBlockB1_P1_P1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartBlockB1_P1_P1.getModel());

		/** Block B2_P1_P1 */
		editPartBlockB2_P1_P1 = EditorUtils.getEditPart(diagramEditPart, "B2_P1_P1", SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, true, false, false);
		viewBlockB2_P1_P1 = (editPartBlockB2_P1_P1.getModel() instanceof View) ? (View)editPartBlockB2_P1_P1.getModel() : null;
		if(viewBlockB2_P1_P1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartBlockB2_P1_P1.getModel());

		/** Block B1_P4 */
		editPartBlockB1_P4_P1 = EditorUtils.getEditPart(diagramEditPart, "B1_P4_P1", SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, true, false, false);
		viewBlockB1_P4_P1 = (editPartBlockB1_P4_P1.getModel() instanceof View) ? (View)editPartBlockB1_P4_P1.getModel() : null;
		if(viewBlockB1_P4_P1 == null)
			throw new Exception("Impossible to cast into a view:" + editPartBlockB1_P4_P1.getModel());


		/** diagrams */
		Diagram currentDiagramView = diagramEditPart.getDiagramView();
		Collection<Diagram> diagrams = getDiagrams(currentDiagramView);
		initialDiagrams = new ArrayList<Diagram>(diagrams);
		Assert.assertEquals("There should be " + initialNumberOfDiagrams + " diagrams in the notation model", initialNumberOfDiagrams, initialDiagrams.size());


	}

	private static Collection<Diagram> getDiagrams(View view) {
		return EcoreUtil.<Diagram> getObjectsByType(view.eResource().getContents(), NotationPackage.eINSTANCE.getDiagram());
	}
	
	private static Collection<Diagram> getAllDiagramsInAllResourceSet(View view) {
		List<Diagram> diagrams=  new ArrayList<Diagram>();
		for(Resource resource : view.eResource().getResourceSet().getResources()) {
			diagrams.addAll(EcoreUtil.<Diagram> getObjectsByType(resource.getContents(), NotationPackage.eINSTANCE.getDiagram()));
		}
		return diagrams;
	}

	/**
	 * After the test: closes the editor without saving its state
	 * 
	 * @throws Exception
	 *         exception thrown in case of errors
	 */
	@AfterClass
	public static void closePapyrusAndCleanProject() throws Exception {
		// Close the editor without saving content created during tests
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.closeEditor(editor, false);
	}

	/**
	 * Test the copy of a {@link Block} and paste in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPasteSimplePackageWithOneBlockAndOneDiagram() throws Exception {
		int expectedNumberOfDiagramsInNewPackage = 1;
		int expectedNumberOfDiagramsInNewPackageAndChildren = expectedNumberOfDiagramsInNewPackage;
		int expected = initialNumberOfDiagrams + expectedNumberOfDiagramsInNewPackageAndChildren;

		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
		Package sysmlModel = (Package)getDiagramView().getElement();
		System.err.println(sysmlModel.getNestedPackages());
		// copy of P4_P1 into SysML Model.
		// should copy the BDD in P4_P1
		TestUtils.copyEditParts(Arrays.<Object> asList((editPartPackageP4_P1)));
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
		TestUtils.pasteWithModelEditParts(EditorUtils.getDiagramEditPart(), true);

		
		Package newPackage = sysmlModel.getNestedPackage("Copy_Of_P4_P1_1");
		//Assert.assertNotNull("Impossible to get the new Package", newPackage);
		//Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());

		// check the new diagrams..
		Collection<Diagram> newListOfDiagrams = getAllDiagramsInAllResourceSet(getDiagramView());
		Assert.assertEquals("There should be " + expected + " diagrams after paste", expected, newListOfDiagrams.size());
		List<Diagram> newPackageDiagrams = getOwnedDiagrams(newPackage, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package after paste", expectedNumberOfDiagramsInNewPackage, newPackageDiagrams.size());
		List<Diagram> newPackageAndChildrenDiagrams = getOwnedDiagrams(newPackage, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackageAndChildren + " diagrams in Package and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newPackageAndChildrenDiagrams.size());
		checkElements(newPackage, viewPackageP4_P1.getElement(), newPackage, viewPackageP4_P1.getElement());

		// test undo
		EditorUtils.getCommandStack().undo();
		newPackage = sysmlModel.getNestedPackage("Copy_Of_P4");
		Assert.assertNull("New Package was not deleted during undo()", newPackage);
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());

		// test redo
		EditorUtils.getCommandStack().redo();
		newPackage = sysmlModel.getNestedPackage("Copy_Of_P4");
		Assert.assertNotNull("Impossible to get the new Package during redo()", newPackage);
		Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());
		newPackageDiagrams = getOwnedDiagrams(newPackage, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package after paste", expectedNumberOfDiagramsInNewPackage, newPackageDiagrams.size());
		newPackageAndChildrenDiagrams = getOwnedDiagrams(newPackage, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newPackageAndChildrenDiagrams.size());
		checkElements(newPackage, viewPackageP4_P1.getElement(), newPackage, viewPackageP4_P1.getElement());

		// do undo to get back previous state
		EditorUtils.getCommandStack().undo();
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
	}

	/**
	 * Test the copy of a {@link Block} and paste in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPasteSimplePackageWithAllocationAndDiagram() throws Exception {
		int expectedNumberOfDiagramsInNewPackage = 0;
		int expectedNumberOfDiagramsInNewPackageAndChildren = expectedNumberOfDiagramsInNewPackage + 1;
		int expected = initialNumberOfDiagrams + expectedNumberOfDiagramsInNewPackageAndChildren;

		Assert.assertTrue("Editor should not be in dirty state", ! EditorUtils.getDiagramEditor().isDirty());

		// copy of P2 into SysML Model.
		// should copy the IBD in P1_B2
		TestUtils.copyEditParts(Arrays.<Object> asList((editPartPackageP2)));
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
		TestUtils.pasteWithModelEditParts(EditorUtils.getDiagramEditPart(), true);

		// check the sysml model => should have a new copy of p2
		Package sysmlModel = (Package)getDiagramView().getElement();
		Package newPackage = sysmlModel.getNestedPackage("Copy_Of_P2_1");
		Assert.assertNotNull("Impossible to get the new Package", newPackage);
		Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());
		
		// check the new diagrams..
		Collection<Diagram> newListOfDiagrams = getDiagrams(getDiagramView());
		Assert.assertEquals("There should be " + expected + " diagrams after paste", expected, newListOfDiagrams.size());
		List<Diagram> newPackageDiagrams = getOwnedDiagrams(newPackage, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package after paste", expectedNumberOfDiagramsInNewPackage, newPackageDiagrams.size());
		List<Diagram> newPackageAndChildrenDiagrams = getOwnedDiagrams(newPackage, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackageAndChildren + " diagrams in Package and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newPackageAndChildrenDiagrams.size());
		//checkElements(newPackage, viewPackageP2.getElement(), newPackage, viewPackageP2.getElement());

		// test undo
		EditorUtils.getCommandStack().undo();
		newPackage = sysmlModel.getNestedPackage("Copy_Of_P2_1");
		Assert.assertNull("New Package was not deleted during undo()", newPackage);
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());

		// test redo
		EditorUtils.getCommandStack().redo();
		newPackage = sysmlModel.getNestedPackage("Copy_Of_P2_1");
		Assert.assertNotNull("Impossible to get the new Package during redo()", newPackage);
		Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());
		newPackageDiagrams = getOwnedDiagrams(newPackage, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package after paste", expectedNumberOfDiagramsInNewPackage, newPackageDiagrams.size());
		newPackageAndChildrenDiagrams = getOwnedDiagrams(newPackage, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newPackageAndChildrenDiagrams.size());
		//checkElements(newPackage, viewPackageP2.getElement(), newPackage, viewPackageP2.getElement());

		// do undo to get back previous state
		EditorUtils.getCommandStack().undo();
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
	}
	
	/**
	 * Test the copy of a {@link Block} and paste in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPastePackageWithSeveralDiagrams() throws Exception {
		String NEW_P1_NAME = "Copy_Of_P1_1";
		int expectedNumberOfDiagramsInNewPackage = 0;
		int expectedNumberOfDiagramsInNewPackageAndChildren = expectedNumberOfDiagramsInNewPackage + 2;
		int expectedNumberOfDiagrams = initialNumberOfDiagrams + expectedNumberOfDiagramsInNewPackageAndChildren;

		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());

		// copy of P1 into SysML Model.
		TestUtils.copyEditParts(Arrays.<Object> asList((editPartPackageP1)));
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
		TestUtils.pasteWithModelEditParts(EditorUtils.getDiagramEditPart(), true);

		// check the sysml model => should have a new copy of p1
		Package sysmlModel = (Package)getDiagramView().getElement();

		Package newPackage = sysmlModel.getNestedPackage(NEW_P1_NAME);
		Assert.assertNotNull("Impossible to get the new Package", newPackage);
		Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());

		// check the new diagrams..
		Collection<Diagram> newListOfDiagrams = getDiagrams(getDiagramView());
		Assert.assertEquals("There should be " + expectedNumberOfDiagrams + " diagrams after paste", expectedNumberOfDiagrams, newListOfDiagrams.size());
		List<Diagram> newPackageDiagrams = getOwnedDiagrams(newPackage, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package after paste", expectedNumberOfDiagramsInNewPackage, newPackageDiagrams.size());
		List<Diagram> newPackageAndChildrenDiagrams = getOwnedDiagrams(newPackage, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newPackageAndChildrenDiagrams.size());
		//checkElements(newPackage, viewPackageP1.getElement(), newPackage, viewPackageP1.getElement());


		// test undo
		EditorUtils.getCommandStack().undo();
		newPackage = sysmlModel.getNestedPackage(NEW_P1_NAME);
		Assert.assertNull("New Package was not deleted during undo()", newPackage);
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());

		// test redo
		EditorUtils.getCommandStack().redo();
		newPackage = sysmlModel.getNestedPackage(NEW_P1_NAME);
		Assert.assertNotNull("Impossible to get the new Package during redo()", newPackage);
		Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());
		newListOfDiagrams = getDiagrams(getDiagramView());
		Assert.assertEquals("There should be " + expectedNumberOfDiagrams + " diagrams after redo", expectedNumberOfDiagrams, newListOfDiagrams.size());
		newPackageDiagrams = getOwnedDiagrams(newPackage, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package after paste", expectedNumberOfDiagramsInNewPackage, newPackageDiagrams.size());
		newPackageAndChildrenDiagrams = getOwnedDiagrams(newPackage, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Package and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newPackageAndChildrenDiagrams.size());
		//checkElements(newPackage, viewPackageP1.getElement(), newPackage, viewPackageP1.getElement());

		// do undo to get back previous state
		EditorUtils.getCommandStack().undo();
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
	}

	/**
	 * Test the copy of a {@link Block} and paste in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Test
	public void testCopyPasteBlockWithOneDiagram() throws Exception {
		String NEW_BLOCK_NAME = "Copy_Of_B1_1";
		int expectedNumberOfDiagramsInNewPackage = 1;
		int expectedNumberOfDiagramsInNewPackageAndChildren = expectedNumberOfDiagramsInNewPackage + 0;
		int expectedNumberOfDiagrams = initialNumberOfDiagrams + expectedNumberOfDiagramsInNewPackageAndChildren;

		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());

		// copy of P1 into SysML Model.
		TestUtils.copyEditParts(Arrays.<Object> asList((editPartBlockB1_P1)));
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
		TestUtils.pasteWithModelEditParts(EditorUtils.getDiagramEditPart(), true);

		// check the sysml model => should have a new copy of p1
		NamedElement newBlock = ((Package)viewPackageP1.getElement()).getPackagedElement(NEW_BLOCK_NAME);
		Assert.assertNotNull("Impossible to get the new Block", newBlock);
		Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());

		// check the new diagrams..
		Collection<Diagram> newListOfDiagrams = getDiagrams(getDiagramView());
		Assert.assertEquals("There should be " + expectedNumberOfDiagrams + " diagrams after paste", expectedNumberOfDiagrams, newListOfDiagrams.size());
		List<Diagram> newBlockDiagrams = getOwnedDiagrams(newBlock, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Block after paste", expectedNumberOfDiagramsInNewPackage, newBlockDiagrams.size());
		List<Diagram> newBlockAndChildrenDiagrams = getOwnedDiagrams(newBlock, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackageAndChildren + " diagrams in Package and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newBlockAndChildrenDiagrams.size());
		//checkElements(newBlock, viewBlockB1_P1.getElement(), newBlock, viewBlockB1_P1.getElement());

		// test undo
		EditorUtils.getCommandStack().undo();
		newBlock = ((Package)viewPackageP1.getElement()).getPackagedElement(NEW_BLOCK_NAME);
		Assert.assertNull("New Block was not deleted during undo()", newBlock);
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());

		// test redo
		EditorUtils.getCommandStack().redo();
		newBlock = ((Package)viewPackageP1.getElement()).getPackagedElement(NEW_BLOCK_NAME);
		Assert.assertNotNull("Impossible to get the new Block during redo()", newBlock);
		Assert.assertTrue("Editor should be in dirty state", EditorUtils.getDiagramEditor().isDirty());
		newListOfDiagrams = getDiagrams(getDiagramView());
		Assert.assertEquals("There should be " + expectedNumberOfDiagrams + " diagrams after redo", expectedNumberOfDiagrams, newListOfDiagrams.size());
		newBlockDiagrams = getOwnedDiagrams(newBlock, false);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackage + " diagrams in Block after redo", expectedNumberOfDiagramsInNewPackage, newBlockDiagrams.size());
		newBlockAndChildrenDiagrams = getOwnedDiagrams(newBlock, true);
		Assert.assertEquals("There should be " + expectedNumberOfDiagramsInNewPackageAndChildren + " diagrams in Block and children after paste", expectedNumberOfDiagramsInNewPackageAndChildren, newBlockAndChildrenDiagrams.size());
		//checkElements(newBlock, viewBlockB1_P1.getElement(), newBlock, viewBlockB1_P1.getElement());


		// do undo to get back previous state
		EditorUtils.getCommandStack().undo();
		Assert.assertTrue("Editor should not be in dirty state", !EditorUtils.getDiagramEditor().isDirty());
	}

	/**
	 * check the elements given expected numbers
	 * 
	 * @param viewChildren
	 *        list of view elements to check
	 * @param modelChildren
	 *        model elements
	 * @param expectedChildrenViewsSize
	 *        expected size of the view children
	 * @param expectedModelChildrenSize
	 *        expected children for the parent element
	 */
	protected static void checkElements(List<View> viewChildren, Object modelChildren, int expectedChildrenViewsSize, int expectedModelChildrenSize) {
		Assert.assertEquals("There are no as many graphical children as expected", expectedChildrenViewsSize, viewChildren.size());
		if(modelChildren instanceof List) {
			Assert.assertEquals("There are no as many model children as expected", expectedModelChildrenSize, ((List<?>)modelChildren).size());
		}
	}

	/**
	 * Returns the list of diagrams associated to a given object
	 * 
	 * @param object
	 *        the eobject to check
	 * @return the list of diagrams found
	 */
	protected static List<Diagram> getOwnedDiagrams(EObject object, boolean nestedElementsExplored) {
		List<Diagram> diagrams = new ArrayList<Diagram>();
		if(object.eResource() == null || object.eResource().getResourceSet() == null) {
			return Collections.emptyList();
		}

		ResourceSet resourceSet = object.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if(adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}

		// do not proceed for graphical elements, which will have evident relationships to diagrams (owner, etc.)
		if(object instanceof View) {
			return Collections.emptyList();
		}

		// check for the element itself
		Collection<Setting> settings = adapter.getInverseReferences(object, false);
		for(Setting setting : settings) {
			EObject value = setting.getEObject();
			if(value instanceof Diagram) {
				diagrams.add((Diagram)value);
			}
		}

		if(nestedElementsExplored) {
		// check for sub-elements
			for(Iterator<EObject> it = object.eAllContents(); it.hasNext();) {
				EObject child = it.next();
				settings = adapter.getInverseReferences(child, false);

				for(Setting setting : settings) {
					EObject value = setting.getEObject();
					if(value instanceof Diagram) {
						diagrams.add((Diagram)value);
					}
				}
			}
		}
		return diagrams;
	}

	/**
	 * Checks the new element compared to the previous one...
	 * 
	 * @param newEObject
	 *        the new object (copy)
	 * @param originalEObject
	 *        the original object
	 */
	protected void checkElements(EObject newEObject, EObject originalEObject, EObject copyMainObject, EObject originalMainObject) {
		System.err.println("testing new Object:" + newEObject + " against original: " + originalEObject);
		// check attributes:
		Iterator<EStructuralFeature> it = newEObject.eClass().getEAllStructuralFeatures().iterator();
		while(it.hasNext()) {
			EStructuralFeature feature = it.next();
			Object copyFeatureObject = newEObject.eGet(feature);
			Object originalFeatureObject = originalEObject.eGet(feature);
			boolean isSet = originalEObject.eIsSet(feature);
			if(isSet) {
				Assert.assertEquals(getErrorMessage(newEObject, originalEObject, "Feature should be set because original was set.\nvalue: " + originalFeatureObject, feature), isSet, newEObject.eIsSet(feature));
			} else {
				Assert.assertEquals(getErrorMessage(newEObject, originalEObject, "Feature should not be set because original was not set", feature), isSet, newEObject.eIsSet(feature));
			}
			if(isSet) {
				if(feature.isMany()) {
					// test size of the feature
					List<EObject> copyFeatures = (List<EObject>)copyFeatureObject;
					List<EObject> originalFeatures = (List<EObject>)originalFeatureObject;
					Assert.assertEquals(getErrorMessage(newEObject, originalEObject, "List of References should have the same size", feature), copyFeatures.size(), originalFeatures.size());

					if(feature instanceof EReference) {
						for(int i = 0; i < copyFeatures.size(); i++) {
							EObject copyFeature = copyFeatures.get(i);
							EObject originalFeature = originalFeatures.get(i);
							List<EObject> originalValueContainers = getContainers(originalFeature);
							if(originalValueContainers.contains(originalMainObject)) {
								// the original value was contained in duplicated object => should now be contained by the new container
								List<EObject> copyValueContainers = getContainers(copyFeature);
								Assert.assertTrue(getErrorMessage(newEObject, originalEObject, "Copy element should be contained by the main duplicated object", feature), copyValueContainers.contains(copyMainObject));
								if(((EReference)feature).isContainment()) {
									checkElements(copyFeature, originalFeature, copyMainObject, originalMainObject);
								}
							} else {
								// outside value => copy should be the same as original (problem if not from the same resource...)
								if(copyFeature.eResource().equals(originalFeature.eResource())) {
									Assert.assertTrue(getErrorMessage(newEObject, originalEObject, "Copy element should not have changed", feature), copyFeature.equals(originalFeature));
								}

								// no need to check content here: elements were not duplicated
							}
						}
					}
				} else {
					if(feature instanceof EReference && !((EReference)feature).isDerived()) { // no way to modify derived properties..
						EObject copyFeature = (EObject)copyFeatureObject;
						EObject originalFeature = (EObject)originalFeatureObject;
						// this is a ref. If element was in the duplicated element, then it should be contained by the new container. else, should be a sub element of old container.
						List<EObject> originalValueContainers = getContainers(originalFeature);
						if(originalValueContainers.contains(originalMainObject)) {
							// the original value was contained in duplicated object => should now be contained by the new container
							List<EObject> copyValueContainers = getContainers(copyFeature);
							Assert.assertTrue(getErrorMessage(newEObject, originalEObject, "Copy element should be contained by the main duplicated object", feature), copyValueContainers.contains(copyMainObject));
						} else {
							// outside value => copy should be the same as original
							Assert.assertTrue(getErrorMessage(newEObject, originalEObject, "Copy element should not have changed", feature), copyFeature.equals(originalFeature));
						}

						if(((EReference)feature).isContainment()) {
							checkElements(copyFeature, originalFeature, copyMainObject, originalMainObject);
						}
					}
				}
			}
		}

		// check Stereotype Application for current Object, if UML element
		if(originalEObject instanceof Element) {
			// retrieve the list of stereotypes
			Element originalElement = ((Element)originalEObject);
			List<Stereotype> originalStereotypesList = originalElement.getAppliedStereotypes();
			List<EObject> originalStereotypeApplications = originalElement.getStereotypeApplications();

			Element newElement = ((Element)newEObject);
			List<Stereotype> newStereotypesList = newElement.getAppliedStereotypes();
			List<EObject> newStereotypeApplications = newElement.getStereotypeApplications();

			Assert.assertEquals(getErrorMessage(newEObject, originalEObject, "Original and Copy do not have the same number of applied stereotypes", null), originalStereotypesList.size(), newStereotypesList.size());
			Assert.assertEquals(getErrorMessage(newEObject, originalEObject, "Original and Copy do not have the same number of stereotype Applications", null), originalStereotypeApplications.size(), newStereotypeApplications.size());

		}
	}

	protected static String getErrorMessage(EObject newEObject, EObject originalEObject, String shortErrorMessage, EStructuralFeature feature) {
		String errorMessage = shortErrorMessage;
		errorMessage += "\n- original: ";
		errorMessage += originalEObject;
		errorMessage += "\n- copy: ";
		errorMessage += newEObject;
		errorMessage += "\n- feature: ";
		if(feature instanceof EReference) { // warning, feature can be null
			errorMessage += feature.getName();
			errorMessage += "[EReference]";
		} else if(feature instanceof EAttribute) {
			errorMessage += feature.getName();
			errorMessage += "[EAttribute]";
		}
		return errorMessage;
	}

	private static List<EObject> getContainers(EObject originalFeature) {
		EObject tmp = originalFeature;
		List<EObject> result = new ArrayList<EObject>();
		while(tmp.eContainer() != null) {
			EObject container = tmp.eContainer();
			result.add(container);
			tmp = container;
		}
		return result;


	}

}
