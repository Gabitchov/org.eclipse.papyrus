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
 * @Generated from Model 
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.papyrus.core.utils.FilteredCollectionView;
import org.eclipse.papyrus.core.utils.IFilter;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.sysml.modelexplorer.Activator;
import org.eclipse.papyrus.sysml.modelexplorer.tests.utils.EditorUtils;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.junit.AfterClass;
import org.junit.BeforeClass;


/**
 * Abstract class for Copy/paste
 */
public abstract class AbstractCopyPasteTest {

	/** boolean to indicate if the test is initialized or not */
	private static boolean isInitialized;

	/** main papyrus editor */
	public static IEditorPart editor = null;

	/** id of the papyrus editor */
	public static String editorID = "org.eclipse.papyrus.core.papyrusEditor";

	/** view part: the model explorer */
	protected static IViewPart modelExplorerPart;

	/** generated selectable objects */
		protected static org.eclipse.uml2.uml.Model 	model_EObject;
		protected static org.eclipse.uml2.uml.Class 	b1_EObject;
		protected static org.eclipse.uml2.uml.Property 	pB2_B1_EObject;
		protected static org.eclipse.uml2.uml.Property 	pB1P1_B1_EObject;
		
		protected static org.eclipse.uml2.uml.Class 	b2_EObject;
		
		protected static org.eclipse.uml2.uml.Package 	p1_EObject;
		protected static org.eclipse.uml2.uml.Class 	b2P1_P1_EObject;
		
		protected static org.eclipse.uml2.uml.Class 	b1P1_P1_EObject;
		protected static org.eclipse.uml2.uml.Property 	pB2P1_B1P1_P1_EObject;
		protected static org.eclipse.uml2.uml.Property 	pB1_B1P1_P1_EObject;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	/** end of generated selectable objects */

	/**
	 * Prepare the diagram before testing
	 * 
	 * @throws Exception
	 *         exception thrown in case of problem
	 */
	@BeforeClass
	public static void prepareTest() throws Exception {
		DiagramEditPart diagramEditPart = EditorUtils.getDiagramEditPart();
		EObject root = diagramEditPart.getDiagramView().getElement();

		Assert.assertTrue("Impossible to find main model", root instanceof Model);
		
		/** generated selectable objects */
		 		model_EObject = (org.eclipse.uml2.uml.Model)root;
				b1_EObject = (org.eclipse.uml2.uml.Class)	model_EObject.getPackagedElement("B1"); 
				pB2_B1_EObject = (org.eclipse.uml2.uml.Property)	b1_EObject.getAttribute("pB2", null); 
				pB1P1_B1_EObject = (org.eclipse.uml2.uml.Property)	b1_EObject.getAttribute("pB1P1", null); 
			
				b2_EObject = (org.eclipse.uml2.uml.Class)	model_EObject.getPackagedElement("B2"); 
			
				p1_EObject = (org.eclipse.uml2.uml.Package)	model_EObject.getPackagedElement("P1"); 
				b2P1_P1_EObject = (org.eclipse.uml2.uml.Class)	p1_EObject.getPackagedElement("B2P1"); 
			
				b1P1_P1_EObject = (org.eclipse.uml2.uml.Class)	p1_EObject.getPackagedElement("B1P1"); 
				pB2P1_B1P1_P1_EObject = (org.eclipse.uml2.uml.Property)	b1P1_P1_EObject.getAttribute("pB2P1", null); 
				pB1_B1P1_P1_EObject = (org.eclipse.uml2.uml.Property)	b1P1_P1_EObject.getAttribute("pB1", null); 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		/** end of generated selectable objects */
	}


	/**
	 * Initialization of the test
	 * 
	 * @throws Exception
	 *         thrown when initialization has problem
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
		IFile emptyModel_di = testProject.getFile("ModelWithBDD.di");
		IFile emptyModel_no = testProject.getFile("ModelWithBDD.notation");
		IFile emptyModel_uml = testProject.getFile("ModelWithBDD.uml");

		// isInitialized = isInitialized || emptyModel_di.exists();

		if(!isInitialized) {
			isInitialized = true;
			emptyModel_di.create(Activator.getDefault().getBundle().getResource("/model/ModelWithBDD.di").openStream(), true, new NullProgressMonitor());
			emptyModel_no.create(Activator.getDefault().getBundle().getResource("/model/ModelWithBDD.notation").openStream(), true, new NullProgressMonitor());
			emptyModel_uml.create(Activator.getDefault().getBundle().getResource("/model/ModelWithBDD.uml").openStream(), true, new NullProgressMonitor());
		}

		// Open the EmptyModel.di file with Papyrus (assumed to be the default editor for "di" files here).
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		editor = page.openEditor(new FileEditorInput(emptyModel_di), editorID);

		modelExplorerPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ModelExplorerPageBookView.VIEW_ID);
		Assert.assertNotNull("Model explorer is null", modelExplorerPart);
	}

	/**
	 * Close editor
	 * 
	 * @throws Exception
	 *         exception thrown in case of problem
	 */
	@AfterClass
	public static void closePapyrusAndCleanProject() throws Exception {
		// Close the editor without saving content created during tests
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.closeEditor(editor, false);
	}


	/**
	 * Selects and reveal the specified element
	 * 
	 * @param object
	 *        the object to select
	 * @throws Exception
	 *         exception thrown in case element could not be selected
	 */
	public static void selectAndReveal(EObject object) throws Exception {
		selectAndReveal(Arrays.asList(object));
	}

	/**
	 * Selects and reveal the specified list of elements
	 * 
	 * @param newElements
	 *        the list of objects to select
	 * @throws Exception
	 *         exception thrown in case element could not be selected
	 */
	public static void selectAndReveal(List<EObject> newElements) throws Exception {
		// Retrieve model explorer
		ModelExplorerView modelExplorerView = null;

		ModelExplorerPageBookView bookViewPart = (ModelExplorerPageBookView)NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID); //$NON-NLS-0$
		if(bookViewPart != null) {
			modelExplorerView = (ModelExplorerView)((ModelExplorerPageBookView)bookViewPart).getActiveView();
		}

		// Set selection on new element in the model explorer
		if((modelExplorerView != null) && (newElements != null)) {
			List<EObject> semanticElementList = new ArrayList<EObject>();
			semanticElementList.addAll(newElements);
			modelExplorerView.revealSemanticElement(semanticElementList);
		} else {
			throw new Exception("Impossible to find the model explorer required to select: " + newElements);
		}
	}

	/**
	 * Generic implementation of the test
	 * 
	 * @throws Exception
	 *         exception thrown when the test has problems
	 */
	protected void testExecutableCopyPaste(EObject targetContainer, EObject copiedEObject, String  featureName, int expectedNumberOfAddedElements) throws Exception {
		testExecutableCopyPaste(targetContainer, copiedEObject, targetContainer.eClass().getEStructuralFeature(featureName), expectedNumberOfAddedElements);
	}

	/**
	 * Generic implementation of the test
	 * 
	 * @throws Exception
	 *         exception thrown when the test has problems
	 */
	protected void testExecutableCopyPaste(EObject targetContainer, EObject copiedEObject, EStructuralFeature feature, int expectedNumberOfAddedElements) throws Exception {
		// retrieve elements in the model explorer
		selectAndReveal(targetContainer);

		List<EObject> originalValues = new ArrayList<EObject>((List<EObject>)targetContainer.eGet(feature));

		Map<Object, Object> originalModel = new HashMap<Object, Object>();
		initializeTest(originalModel, targetContainer, copiedEObject);

		// try to paste in several places
		// copy Paste b1EObject
		ICommandService commandService = (ICommandService)PlatformUI.getWorkbench().getService(ICommandService.class);
		commandService.refreshElements(IWorkbenchCommandConstants.EDIT_PASTE, null);
		org.eclipse.core.commands.Command pasteCommand = commandService.getCommand(IWorkbenchCommandConstants.EDIT_PASTE);
		Assert.assertNotNull("Impossible to find paste command", pasteCommand);
		Assert.assertTrue("command in not enabled", pasteCommand.isEnabled());
		Assert.assertTrue("command in not defined", pasteCommand.isDefined());

		pasteCommand.executeWithChecks(new ExecutionEvent());

		// check editor state (should be non dirty)
		Assert.assertTrue("Editor should be dirty after paste command execution", isEditorDirty());


		// should retrieve a new Part AND a new association
		List<EObject> newValues = (List<EObject>)targetContainer.eGet(feature);
		// compute delta
		List<EObject> delta = new ArrayList<EObject>();
		for(EObject o : newValues) {
			if(!originalValues.contains(o)) {
				delta.add(o);
			}
		}

		// size = original size +1
		Assert.assertEquals("Wrong number of attributes after paste", expectedNumberOfAddedElements, delta.size());

		// part should be linked to an association 
		postCopyAdditionalChecks(originalModel, newValues, delta);

		// undo
		if(getEditingDomain().getCommandStack().canUndo()) {
			getEditingDomain().getCommandStack().undo();
		} else {
			throw new Exception("Impossible to undo the paste command: " + pasteCommand);
		}
		// check editor state (should be non dirty)
		Assert.assertFalse("Editor should not be dirty after undo", isEditorDirty());
		// check old values equals the actual values
		newValues = (List<EObject>)targetContainer.eGet(feature);
		Assert.assertEquals("Initial and current list feature list should be equivalent", newValues, originalValues);

		// redo
		if(getEditingDomain().getCommandStack().canRedo()) {
			getEditingDomain().getCommandStack().redo();
		} else {
			throw new Exception("Impossible to redo the paste command: " + pasteCommand);
		}
		// check editor state (should be non dirty)
		Assert.assertTrue("Editor should not dirty after redo", isEditorDirty());

		// check as it was the result of the paste command
		newValues = (List<EObject>)targetContainer.eGet(feature);
		delta = new ArrayList<EObject>();
		for(EObject o : newValues) {
			if(!originalValues.contains(o)) {
				delta.add(o);
			}
		}

		// size = original size + delta
		Assert.assertEquals("Wrong number of attributes after paste", expectedNumberOfAddedElements, delta.size());

		// part should be linked to an association 
		postCopyAdditionalChecks(originalModel, newValues, delta);

		// undo again, to restore state
		if(getEditingDomain().getCommandStack().canUndo()) {
			getEditingDomain().getCommandStack().undo();
		} else {
			throw new Exception("Impossible to re-undo the paste command: " + pasteCommand);
		}
		// check editor state (should be non dirty)
		Assert.assertFalse("Editor should not be dirty after undo", isEditorDirty());

	}

	/**
	 * executes additional checks on the new value
	 * 
	 * @param originalModel
	 *        the map containing all values stored before launching the test
	 * @param newValue
	 *        the new value, result of the copy
	 * @param delta
	 * 		  differences between original list and the new one 
	 */
	protected void postCopyAdditionalChecks(Map<?, ?> originalModel, List<EObject> newValues, List<EObject> delta) throws Exception {
		// use the values contained in the map to do additional checks
	}

	protected void initializeTest(Map<Object, Object> additionalChecks, EObject targetContainer, EObject copiedEObject) {
		// nothing to do here
	}

	/**
	 * Returns the current editing domain
	 * 
	 * @return
	 *         the current editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() throws Exception {
		return org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
	}

	/**
	 * Returns <code>true</code> if the current Active editor is dirty.
	 * 
	 * @return <code>true</code> if the current Active editor is dirty
	 * @throws Exception
	 *         exception thrown in case of problem (NPE, etc.)
	 */
	protected boolean isEditorDirty() throws Exception {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().isDirty();
	}
}
