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
package org.eclipse.papyrus.sysml.modelexplorer.tests.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.additional.AdditionalResourcesModel;
import org.eclipse.papyrus.sysml.modelexplorer.Activator;
import org.eclipse.papyrus.sysml.modelexplorer.tests.utils.EditorUtils;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.matching.IMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.LinkItemMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.ModelElementItemMatchingItem;
import org.eclipse.papyrus.views.modelexplorer.matching.ReferencableMatchingItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.AfterClass;
import org.junit.BeforeClass;



/**
 * Abstract class for Copy/paste
 */
public abstract class AbstractModelExplorerTest {

	/** boolean to indicate if the test is initialized or not */
	private static boolean isInitialized;

	/** main papyrus editor */
	public static IEditorPart editor = null;

	/** id of the papyrus editor */
	public static String editorID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	/** view part: the model explorer */
	protected static IViewPart modelExplorerPart;

	/** generated selectable objects */
	protected static org.eclipse.uml2.uml.Model model_EObject;

	protected static org.eclipse.uml2.uml.Class b1_EObject;

	protected static org.eclipse.uml2.uml.Property pB1P1_B1_EObject;

	protected static org.eclipse.uml2.uml.Property rB2_B1_EObject;

	protected static org.eclipse.uml2.uml.Property pB2_B1_EObject;

	protected static org.eclipse.uml2.uml.Class b2_EObject;

	protected static org.eclipse.uml2.uml.Package p1_EObject;

	protected static org.eclipse.uml2.uml.Class b2P1_P1_EObject;

	protected static org.eclipse.uml2.uml.Class b1P1_P1_EObject;

	protected static org.eclipse.uml2.uml.Property pB1_B1P1_P1_EObject;

	protected static org.eclipse.uml2.uml.Property pB2P1_B1P1_P1_EObject;

	protected static Diagram iBD_B1_Diagram;

	protected static Diagram bDD_Main_Diagram;

	/** end of generated selectable objects */

	/**
	 * Initialization of the test
	 * 
	 * @throws Exception
	 *         thrown when initialization has problem
	 */
	@BeforeClass
	public static void openPapyrusWithAnEmptyProject() throws Exception {
		// Prepare new project for tests
		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestCopyPasteProject");
		if(!testProject.exists()) {
			testProject.create(new NullProgressMonitor());
		}

		if(!testProject.isOpen()) {
			testProject.open(new NullProgressMonitor());
		}

		// Copy EmptyModel from bundle to the test project
		final IFile emptyModel_di = testProject.getFile("ModelWithBDD.di");
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
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					editor = page.openEditor(new FileEditorInput(emptyModel_di), editorID);

					modelExplorerPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ModelExplorerPageBookView.VIEW_ID);
					modelExplorerPart.setFocus();
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		});

		Assert.assertNotNull("Model explorer is null", modelExplorerPart);

		prepareTest();
	}

	/**
	 * Prepare the diagram before testing
	 * 
	 * @throws Exception
	 *         exception thrown in case of problem
	 */
	public static void prepareTest() throws Exception {
		DiagramEditPart diagramEditPart = EditorUtils.getDiagramEditPart();
		EObject root = diagramEditPart.getDiagramView().getElement();

		Assert.assertTrue("Impossible to find main model", root instanceof Model);

		/** generated selectable objects */
		model_EObject = (org.eclipse.uml2.uml.Model)root;
		b1_EObject = (org.eclipse.uml2.uml.Class)model_EObject.getPackagedElement("B1");
		Assert.assertNotNull("Impossible to find Class B1", b1_EObject);
		pB1P1_B1_EObject = b1_EObject.getAttribute("pB1P1", null);
		Assert.assertNotNull("Impossible to find Property pB1P1", pB1P1_B1_EObject);
		rB2_B1_EObject = b1_EObject.getAttribute("rB2", null);
		Assert.assertNotNull("Impossible to find Property rB2", rB2_B1_EObject);
		pB2_B1_EObject = b1_EObject.getAttribute("pB2", null);
		Assert.assertNotNull("Impossible to find Property pB2", pB2_B1_EObject);

		b2_EObject = (org.eclipse.uml2.uml.Class)model_EObject.getPackagedElement("B2");
		Assert.assertNotNull("Impossible to find Class B2", b2_EObject);

		p1_EObject = (org.eclipse.uml2.uml.Package)model_EObject.getPackagedElement("P1");
		Assert.assertNotNull("Impossible to find Package P1", p1_EObject);
		b2P1_P1_EObject = (org.eclipse.uml2.uml.Class)p1_EObject.getPackagedElement("B2P1");
		Assert.assertNotNull("Impossible to find Class B2P1", b2P1_P1_EObject);

		b1P1_P1_EObject = (org.eclipse.uml2.uml.Class)p1_EObject.getPackagedElement("B1P1");
		Assert.assertNotNull("Impossible to find Class B1P1", b1P1_P1_EObject);
		pB1_B1P1_P1_EObject = b1P1_P1_EObject.getAttribute("pB1", null);
		Assert.assertNotNull("Impossible to find Property pB1", pB1_B1P1_P1_EObject);
		pB2P1_B1P1_P1_EObject = b1P1_P1_EObject.getAttribute("pB2P1", null);
		Assert.assertNotNull("Impossible to find Property pB2P1", pB2P1_B1P1_P1_EObject);





		iBD_B1_Diagram = getDiagram("IBD_B1");
		Assert.assertNotNull("Impossible to find IBD_B1", iBD_B1_Diagram);
		bDD_Main_Diagram = getDiagram("BDD_Main");
		Assert.assertNotNull("Impossible to find BDD_Main", bDD_Main_Diagram);


		/** end of generated selectable objects */
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
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.closeEditor(editor, false);
			}
		});

		editor = null;
		modelExplorerPart = null;
	}


	/**
	 * Selects and reveal the specified element
	 * 
	 * @param object
	 *        the object to select
	 * @throws Exception
	 *         exception thrown in case element could not be selected
	 */
	public static void selectAndReveal(final EObject object) throws Exception {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					selectAndReveal(Arrays.asList(object));
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		});
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

		ModelExplorerPageBookView bookViewPart = (ModelExplorerPageBookView)NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID);
		if(bookViewPart != null) {
			modelExplorerView = (ModelExplorerView)bookViewPart.getActiveView();
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
	 * Returns the current editing domain
	 * 
	 * @return
	 *         the current editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() throws Exception {
		return (TransactionalEditingDomain)editor.getAdapter(TransactionalEditingDomain.class);
	}

	/**
	 * Returns <code>true</code> if the current Active editor is dirty.
	 * 
	 * @return <code>true</code> if the current Active editor is dirty
	 * @throws Exception
	 *         exception thrown in case of problem (NPE, etc.)
	 */
	protected boolean isEditorDirty() throws Exception {
		RunnableWithResult<Boolean> runnable;
		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<Boolean>() {

			public void run() {
				setResult(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().isDirty());
			}
		});

		return runnable.getResult();
	}

	/**
	 * Selects and reveal the specified element
	 * 
	 * @param object
	 *        the object to select
	 * @throws Exception
	 *         exception thrown in case element could not be selected
	 */
	public static void selectAndRevealDiagram(final Diagram object) throws Exception {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					selectAndRevealDiagram(Arrays.asList(object));
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		});
	}

	/**
	 * Selects and reveal the specified list of diagrams
	 * 
	 * @param newElements
	 *        the list of diagrams to select
	 * @throws Exception
	 *         exception thrown in case diagram could not be selected
	 */
	public static void selectAndRevealDiagram(List<Diagram> newDiagrams) throws Exception {
		// Retrieve model explorer
		ModelExplorerView modelExplorerView = null;
		ModelExplorerPageBookView bookViewPart = (ModelExplorerPageBookView)NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID);
		if(bookViewPart != null) {
			modelExplorerView = (ModelExplorerView)bookViewPart.getActiveView();
		}
		// Set selection on new element in the model explorer
		if((modelExplorerView != null) && (newDiagrams != null)) {
			List<Diagram> semanticElementList = new ArrayList<Diagram>();
			semanticElementList.addAll(newDiagrams);
			// reveal 'container' of the diagram
			reveal(semanticElementList, modelExplorerView.getCommonViewer());
		} else {
			throw new Exception("Impossible to find the model explorer required to select: " + newDiagrams);
		}
	}

	/**
	 * Expands the given CommonViewer to reveal the given elements
	 * 
	 * @param elementList
	 *        The elements to reveal
	 * @param commonViewer
	 *        The CommonViewer they are to be revealed in
	 */
	public static void reveal(final Iterable<Diagram> elementList, final CommonViewer commonViewer) {
		ArrayList<IMatchingItem> matchingItemsToSelect = new ArrayList<IMatchingItem>();
		// filter out non EMF objects
		for(Diagram currentEObject : elementList) {
			matchingItemsToSelect.add(new ModelElementItemMatchingItem(currentEObject));
			// the content provider exist?
			if(commonViewer.getContentProvider() != null) {
				// retrieve the ancestors to reveal them
				// and allow the selection of the object
				ArrayList<EObject> parents = new ArrayList<EObject>();
				// retrieve context
				EObject tmp = currentEObject.getElement();
				while(tmp != null) {
					parents.add(tmp);
					tmp = tmp.eContainer();
				}
				List<EObject> reverseParents = new ArrayList<EObject>(parents);
				Collections.reverse(reverseParents);
				// reveal the resource if necessary
				Resource r = null;
				if(!parents.isEmpty()) {
					r = parents.get(parents.size() - 1).eResource();
				} else {
					r = currentEObject.eResource();
				}
				if(r != null) {
					ResourceSet rs = r.getResourceSet();
					if(rs instanceof ModelSet && AdditionalResourcesModel.isAdditionalResource((ModelSet)rs, r.getURI())) {
						commonViewer.expandToLevel(new ReferencableMatchingItem(rs), 1);
						commonViewer.expandToLevel(new ReferencableMatchingItem(r), 1);
					}
				}
				/*
				 * reveal the ancestors tree using expandToLevel on each of them
				 * in the good order. This is a lot faster than going through the whole tree
				 * using getChildren of the ContentProvider since our Viewer uses a Hashtable
				 * to keep track of the revealed elements.
				 * 
				 * However we need to use a dedicated MatchingItem to do the matching,
				 * and a specific comparer in our viewer so than the equals of MatchingItem is
				 * used in priority.
				 * 
				 * Please refer to MatchingItem for more infos.
				 */
				EObject previousParent = null;
				for(EObject parent : reverseParents) {
					if(parent.eContainingFeature() != null && previousParent != null) {
						commonViewer.expandToLevel(new LinkItemMatchingItem(previousParent, parent.eContainmentFeature()), 1);
					}
					commonViewer.expandToLevel(new ModelElementItemMatchingItem(parent), 1);
					previousParent = parent;
				}
				commonViewer.expandToLevel(new LinkItemMatchingItem(currentEObject.eContainer(), currentEObject.eContainmentFeature()), 1);
			}
		}
		commonViewer.setSelection(new StructuredSelection(matchingItemsToSelect), true);
	}

	/**
	 * Returns the diagram with the given name
	 * 
	 * @param name
	 *        the name of the diagram to find
	 * @return the diagram with the given name.
	 * @exception Exception
	 *            exception thrown in case of issue, e.g. diagram was not found
	 */
	protected static Diagram getDiagram(String name) throws Exception {
		Iterator<EObject> it = EditorUtils.getDiagramEditPart().getDiagramView().eResource().getContents().iterator();
		while(it.hasNext()) {
			EObject next = it.next();
			if(next instanceof Diagram) {
				if(name.equals(((Diagram)next).getName())) {
					return (Diagram)next;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves the Model Element Item for the given EObject
	 * 
	 * @param objectToFind
	 *        object represented by the searched item
	 * @return the {@link ModelElementItem} that corresponds to the diagram
	 * @throws Exception
	 *         exception thrown in case of issue
	 */
	protected ModelElementItem findSemanticModelElementItem(EObject objectToFind) throws Exception {
		selectAndReveal(objectToFind);
		IStructuredSelection selection = (IStructuredSelection)modelExplorerPart.getSite().getSelectionProvider().getSelection();
		Assert.assertEquals("one and only one object should be selected", 1, selection.size());
		Object selectedElement = selection.getFirstElement();
		Assert.assertTrue("selection should be a model item element", selectedElement instanceof ModelElementItem);
		Assert.assertTrue("selection should be linked to a EObject", ((ModelElementItem)selectedElement).getEObject() instanceof EObject);
		Assert.assertTrue("selection should be linked to the Object: " + objectToFind, ((ModelElementItem)selectedElement).getEObject().equals(objectToFind));
		return (ModelElementItem)selectedElement;
	}

	/**
	 * Retrieves the Model Element Item for the given Diagram
	 * 
	 * @param diagramToFind
	 *        diagram represented by the searched item
	 * @return the {@link ModelElementItem} that corresponds to the diagram
	 * @throws Exception
	 *         exception thrown in case of issue
	 */
	protected ModelElementItem findSemanticModelElementItem(Diagram diagramToFind) throws Exception {
		selectAndRevealDiagram(diagramToFind);
		IStructuredSelection selection = (IStructuredSelection)modelExplorerPart.getSite().getSelectionProvider().getSelection();
		Assert.assertEquals("one and only one diagram should be selected", 1, selection.size());
		Object selectedElement = selection.getFirstElement();
		Assert.assertTrue("selection should be a model item element", selectedElement instanceof ModelElementItem);
		Assert.assertTrue("selection should be linked to a Diagram", ((ModelElementItem)selectedElement).getEObject() instanceof Diagram);
		Assert.assertTrue("selection should be linked to the Object: " + diagramToFind, ((ModelElementItem)selectedElement).getEObject().equals(diagramToFind));
		return (ModelElementItem)selectedElement;
	}

	protected String printElement(EObject object) {
		if(object instanceof Diagram) {
			return printElement((Diagram)object);
		} else if(object instanceof NamedElement) {
			return printElement((NamedElement)object);
		}
		return EcoreUtil.getID(object);
	}

	protected String printElement(NamedElement element) {
		return element.getName() + " <" + element.eClass().getName() + ">";
	}

	protected String printElement(Diagram diagram) {
		return diagram.getName() + " <" + diagram.getType() + ">";
	}

}
