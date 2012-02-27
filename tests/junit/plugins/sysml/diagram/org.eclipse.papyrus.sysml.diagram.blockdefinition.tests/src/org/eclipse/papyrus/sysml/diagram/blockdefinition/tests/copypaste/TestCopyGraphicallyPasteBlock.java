/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.createNodeFromPalette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class for Copy/paste actions
 */
public class TestCopyGraphicallyPasteBlock extends AbstractTest {


	/** view to select, copy and paste */
	private static View blockView1;

	/** additional view to select, copy and paste a list of elements */
	private static View blockView2;

	/**
	 * Prepare the diagram before testing
	 * 
	 * @throws Exception
	 *         exception thrown in case of problem
	 */
	@BeforeClass
	public static void prepareBlockForTest() throws Exception {
		try {
			createNodeFromPalette("blockdefinition.tool.block", getDiagramView(), true);
			blockView1 = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID);

			if(blockView1 == null) {
				throw new Exception("Unable to prepare block for test.");
			}

			createNodeFromPalette("blockdefinition.tool.block", getDiagramView(), true);
			blockView2 = (View)getDiagramView().getChildren().get(1);

			if(blockView2 == null) {
				throw new Exception("Unable to prepare block for test.");
			}
		} catch (Exception e) {
			throw new Exception("Unable to prepare block for test.", e);
		}
	}

	/**
	 * Test the copy of a {@link Block} and paste in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCopyPasteBlockInDiagram() throws Exception {
		// initial checks
		EditPart blockEP = EditorUtils.getEditPart(blockView1);
		Object initialBlockViewObject = blockEP.getModel();
		Assert.assertTrue("Element should be a View, but is " + initialBlockViewObject, initialBlockViewObject instanceof View);
		View initialBlockView = (View)initialBlockViewObject;
		EObject modelElement = initialBlockView.getElement();
		Assert.assertTrue("Model Element should be a Class, but is " + modelElement, modelElement instanceof org.eclipse.uml2.uml.Class);
		Class initialBlock = (Class)modelElement; 
		Assert.assertTrue("model element should be stereotyped", initialBlock.getAppliedStereotype("SysML::Blocks::Block") != null);
		List<EObject> initialViews = new ArrayList<EObject>();
		initialViews.addAll(getDiagramView().getChildren());
		Assert.assertEquals("Initial number of views do not fit expectations", 2, initialViews.size());
		List<EObject> initialModelElements = new ArrayList<EObject>();
		initialModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		Assert.assertEquals("Initial number of model elemnts do not fit expectations", 2, initialViews.size());
		
		
		Assert.assertNotNull("Impossible to find edit part", blockEP);
		TestUtils.copyEditParts(Collections.<Object> singletonList((Object)blockEP));

		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		// Now should paste the elements
		TestUtils.pasteEditParts(EditorUtils.getDiagramEditPart(), true);
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 3, 2);

		// get copied element : new element from the collection (compare the 2 collections => before/after, and get the new one)
		List<EObject> postPasteViews = new ArrayList<EObject>();
		postPasteViews.addAll(getDiagramView().getChildren());
		List<EObject> addedViews = new ArrayList<EObject>();
		addedViews.addAll(postPasteViews);
		//remove already existing elements
		addedViews.removeAll(initialViews);
		// check there is only one new
		Assert.assertEquals("Final number of views do not fit expectations", 3, postPasteViews.size());
		Assert.assertEquals("There should be only one element added to the diagram", 1, addedViews.size());
		
		List<EObject> postPasteModelElements = new ArrayList<EObject>();
		postPasteModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		List<EObject> addedModelElements = new ArrayList<EObject>();
		addedModelElements.addAll(postPasteModelElements);
		//remove already existing elements
		addedModelElements.removeAll(initialModelElements);
		// check there is only one new
		Assert.assertEquals("Final number of model elements do not fit expectations", 2, postPasteModelElements.size());
		Assert.assertEquals("There should be no element added to the model", 0, addedModelElements.size());
		

		// test undo
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// test redo
		EditorUtils.getCommandStack().redo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 3, 2);
		Assert.assertEquals("Both collections should be equivalent", postPasteViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", postPasteModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// do undo to get back previous state
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));
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
	 * Test the copy of a {@link Block} and paste in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCopyPasteListOfBlocksInDiagram() throws Exception {
		// initial checks
		EditPart blockEP1 = EditorUtils.getEditPart(blockView1);
		Assert.assertNotNull("Impossible to find edit part", blockEP1);
		EditPart blockEP2 = EditorUtils.getEditPart(blockView2);
		Assert.assertNotNull("Impossible to find edit part", blockEP2);
		Object initialBlockViewObject1 = blockEP1.getModel();
		Object initialBlockViewObject2 = blockEP2.getModel();
		Assert.assertTrue("Element should be a View, but is " + initialBlockViewObject1, initialBlockViewObject1 instanceof View);
		Assert.assertTrue("Element should be a View, but is " + initialBlockViewObject2, initialBlockViewObject2 instanceof View);
		View initialBlockView1 = (View)initialBlockViewObject1;
		View initialBlockView2 = (View)initialBlockViewObject2;
		EObject modelElement1 = initialBlockView1.getElement();
		EObject modelElement2 = initialBlockView2.getElement();
		Assert.assertTrue("Model Element should be a Class, but is " + modelElement1, modelElement1 instanceof org.eclipse.uml2.uml.Class);
		Assert.assertTrue("Model Element should be a Class, but is " + modelElement2, modelElement1 instanceof org.eclipse.uml2.uml.Class);

		Class initialBlock1 = (Class)modelElement1;
		Class initialBlock2 = (Class)modelElement2;
		Assert.assertTrue("model element should be stereotyped", initialBlock1.getAppliedStereotype("SysML::Blocks::Block") != null);
		Assert.assertTrue("model element should be stereotyped", initialBlock2.getAppliedStereotype("SysML::Blocks::Block") != null);
		List<EObject> initialViews = new ArrayList<EObject>();
		initialViews.addAll(getDiagramView().getChildren());
		Assert.assertEquals("Initial number of views do not fit expectations", 2, initialViews.size());
		List<EObject> initialModelElements = new ArrayList<EObject>();
		initialModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		Assert.assertEquals("Initial number of model elemnts do not fit expectations", 2, initialModelElements.size());

		TestUtils.copyEditParts(Arrays.<Object> asList(blockEP1, blockEP2));

		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		// Now should paste the elements
		TestUtils.pasteEditParts(EditorUtils.getDiagramEditPart(), true);
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 4, 2);

		// get copied element : new element from the collection (compare the 2 collections => before/after, and get the new one)
		List<EObject> postPasteViews = new ArrayList<EObject>();
		postPasteViews.addAll(getDiagramView().getChildren());
		List<EObject> addedObjects = new ArrayList<EObject>();
		addedObjects.addAll(postPasteViews);
		//remove already existing elements
		addedObjects.removeAll(initialViews);
		// check there is only one new
		Assert.assertEquals("Final number of views do not fit expectations", 4, postPasteViews.size());
		Assert.assertEquals("There should be only one element added to the diagram", 2, addedObjects.size());

		List<EObject> postPasteModelElements = new ArrayList<EObject>();
		postPasteModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		List<EObject> addedModelElements = new ArrayList<EObject>();
		addedModelElements.addAll(postPasteModelElements);
		//remove already existing elements
		addedModelElements.removeAll(initialModelElements);
		// check there is only one new
		Assert.assertEquals("Final number of model elements do not fit expectations", 2, postPasteModelElements.size());
		Assert.assertEquals("There should be no element added to the model", 0, addedModelElements.size());


		// test undo
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// test redo
		EditorUtils.getCommandStack().redo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 4, 2);
		Assert.assertEquals("Both collections should be equivalent", postPasteViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", postPasteModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// undo to restore previous state
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

	}

	/**
	 * Test the copy of a {@link Block} and paste with model in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCopyPasteWithModelBlockInDiagram() throws Exception {
		// initial checks
		EditPart blockEP = EditorUtils.getEditPart(blockView1);
		Object initialBlockViewObject = blockEP.getModel();
		Assert.assertTrue("Element should be a View, but is " + initialBlockViewObject, initialBlockViewObject instanceof View);
		View initialBlockView = (View)initialBlockViewObject;
		EObject modelElement = initialBlockView.getElement();
		Assert.assertTrue("Model Element should be a Class, but is " + modelElement, modelElement instanceof org.eclipse.uml2.uml.Class);
		Class initialBlock = (Class)modelElement;
		Assert.assertTrue("model element should be stereotyped", initialBlock.getAppliedStereotype("SysML::Blocks::Block") != null);
		List<EObject> initialViews = new ArrayList<EObject>();
		initialViews.addAll(getDiagramView().getChildren());
		Assert.assertEquals("Initial number of views do not fit expectations", 2, initialViews.size());
		List<EObject> initialModelElements = new ArrayList<EObject>();
		initialModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		Assert.assertEquals("Initial number of model elemnts do not fit expectations", 2, initialViews.size());

		Assert.assertNotNull("Impossible to find edit part", blockEP);
		TestUtils.copyEditParts(Collections.<Object> singletonList((Object)blockEP));

		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		// Now should paste the elements
		TestUtils.pasteWithModelEditParts(EditorUtils.getDiagramEditPart(), true);
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 3, 3);

		// get copied element : new element from the collection (compare the 2 collections => before/after, and get the new one)
		List<EObject> postPasteViews = new ArrayList<EObject>();
		postPasteViews.addAll(getDiagramView().getChildren());
		List<EObject> addedViews = new ArrayList<EObject>();
		addedViews.addAll(postPasteViews);
		//remove already existing elements
		addedViews.removeAll(initialViews);
		// check there is only one new
		Assert.assertEquals("Final number of views do not fit expectations", 3, postPasteViews.size());
		Assert.assertEquals("There should be only one element added to the diagram", 1, addedViews.size());

		List<EObject> postPasteModelElements = new ArrayList<EObject>();
		postPasteModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		List<EObject> addedModelElements = new ArrayList<EObject>();
		addedModelElements.addAll(postPasteModelElements);
		//remove already existing elements
		addedModelElements.removeAll(initialModelElements);
		// check there is only one new
		Assert.assertEquals("Final number of model elements do not fit expectations", 3, postPasteModelElements.size());
		Assert.assertEquals("There should be no element added to the model", 1, addedModelElements.size());

		//Retrieve added model element and check name
		EObject addedObject = addedModelElements.get(0);
		Assert.assertTrue("Element should be a class", addedObject instanceof Class);
		Class addedBlock = (Class)addedObject;
		Assert.assertTrue("Model element should be stereotyped", addedBlock.getAppliedStereotype("SysML::Blocks::Block") != null);

		// check name
		String expectedName = "Copy_Of_Block1_1";
		Assert.assertEquals("Name of the element is not " + expectedName, expectedName, addedBlock.getName());

		// test undo
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// test redo
		EditorUtils.getCommandStack().redo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 3, 3);
		Assert.assertEquals("Both collections should be equivalent", postPasteViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", postPasteModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// do undo to get back previous state
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

	}

	/**
	 * Test the copy of a {@link Block} and paste in a {@link Diagram}
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCopyPasteWithModelListOfBlocksInDiagram() throws Exception {
		// initial checks
		EditPart blockEP1 = EditorUtils.getEditPart(blockView1);
		Assert.assertNotNull("Impossible to find edit part", blockEP1);
		EditPart blockEP2 = EditorUtils.getEditPart(blockView2);
		Assert.assertNotNull("Impossible to find edit part", blockEP2);
		Object initialBlockViewObject1 = blockEP1.getModel();
		Object initialBlockViewObject2 = blockEP2.getModel();
		Assert.assertTrue("Element should be a View, but is " + initialBlockViewObject1, initialBlockViewObject1 instanceof View);
		Assert.assertTrue("Element should be a View, but is " + initialBlockViewObject2, initialBlockViewObject2 instanceof View);
		View initialBlockView1 = (View)initialBlockViewObject1;
		View initialBlockView2 = (View)initialBlockViewObject2;
		EObject modelElement1 = initialBlockView1.getElement();
		EObject modelElement2 = initialBlockView2.getElement();
		Assert.assertTrue("Model Element should be a Class, but is " + modelElement1, modelElement1 instanceof org.eclipse.uml2.uml.Class);
		Assert.assertTrue("Model Element should be a Class, but is " + modelElement2, modelElement1 instanceof org.eclipse.uml2.uml.Class);
		setName(modelElement1, "Copy_Of_Block");
		setName(modelElement2, "Copy_Of_Block1");

		Class initialBlock1 = (Class)modelElement1;
		Class initialBlock2 = (Class)modelElement2;
		Assert.assertTrue("model element should be stereotyped", initialBlock1.getAppliedStereotype("SysML::Blocks::Block") != null);
		Assert.assertTrue("model element should be stereotyped", initialBlock2.getAppliedStereotype("SysML::Blocks::Block") != null);
		List<EObject> initialViews = new ArrayList<EObject>();
		initialViews.addAll(getDiagramView().getChildren());
		Assert.assertEquals("Initial number of views do not fit expectations", 2, initialViews.size());
		List<EObject> initialModelElements = new ArrayList<EObject>();
		initialModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		Assert.assertEquals("Initial number of model elemnts do not fit expectations", 2, initialViews.size());

		TestUtils.copyEditParts(Arrays.<Object> asList(blockEP1, blockEP2));

		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		// Now should paste the elements
		TestUtils.pasteWithModelEditParts(EditorUtils.getDiagramEditPart(), true);
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 4, 4);

		// get copied element : new element from the collection (compare the 2 collections => before/after, and get the new one)
		List<EObject> postPasteViews = new ArrayList<EObject>();
		postPasteViews.addAll(getDiagramView().getChildren());
		List<EObject> addedObjects = new ArrayList<EObject>();
		addedObjects.addAll(postPasteViews);
		//remove already existing elements
		addedObjects.removeAll(initialViews);
		// check there is only one new
		Assert.assertEquals("Final number of views do not fit expectations", 4, postPasteViews.size());
		Assert.assertEquals("There should be only one element added to the diagram", 2, addedObjects.size());

		List<EObject> postPasteModelElements = new ArrayList<EObject>();
		postPasteModelElements.addAll((List)getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement()));
		List<EObject> addedModelElements = new ArrayList<EObject>();
		addedModelElements.addAll(postPasteModelElements);
		//remove already existing elements
		addedModelElements.removeAll(initialModelElements);
		// check there is only one new
		Assert.assertEquals("Final number of model elements do not fit expectations", 4, postPasteModelElements.size());
		Assert.assertEquals("There should be no element added to the model", 2, addedModelElements.size());

		//Retrieve added model element and check name
		EObject addedObject1 = addedModelElements.get(0);
		Assert.assertTrue("Element should be a class", addedObject1 instanceof Class);
		Class addedBlock1 = (Class)addedObject1;
		Assert.assertTrue("Model element should be stereotyped", addedBlock1.getAppliedStereotype("SysML::Blocks::Block") != null);

		// check name: not possible, because list are not ordered.
		//String expectedName = "Copy_Of_Block_1"; // Warning: this name already exists...
		//Assert.assertEquals("Name of the element is not " + expectedName, expectedName, addedBlock1.getName());

		//Retrieve added model element and check name
		EObject addedObject2 = addedModelElements.get(1);
		Assert.assertTrue("Element should be a class", addedObject2 instanceof Class);
		Class addedBlock2 = (Class)addedObject2;
		Assert.assertTrue("Model element should be stereotyped", addedBlock2.getAppliedStereotype("SysML::Blocks::Block") != null);

		// check name
		//expectedName = "Copy_Of_Block_1"; // Warning: this name already exists...
		// Assert.assertEquals("Name of the element is not " + expectedName, expectedName, addedBlock2.getName());

		// test undo
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// test redo
		EditorUtils.getCommandStack().redo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 4, 4);
		Assert.assertEquals("Both collections should be equivalent", postPasteViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", postPasteModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

		// undo to restore previous state
		EditorUtils.getCommandStack().undo();
		checkElements(getDiagramView().getChildren(), getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true), 2, 2);
		Assert.assertEquals("Both collections should be equivalent", initialViews, getDiagramView().getChildren());
		Assert.assertEquals("Both collections should be equivalent", initialModelElements, getDiagramView().getElement().eGet(UMLPackage.eINSTANCE.getPackage_PackagedElement(), true));

	}

	/**
	 * Sets the name of a {@link NamedElement}
	 * 
	 * @param eObject
	 *        the named element to rename
	 * @param newName
	 *        the new name to set
	 * @throws Exception
	 *         exception thrown when something bad happens
	 */
	private static void setName(EObject eObject, String newName) throws Exception {
		SetRequest request = new SetRequest(eObject, UMLPackage.eINSTANCE.getNamedElement_Name(), newName);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eObject);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand setNameCommand = provider.getEditCommand(request);
			IStatus status = setNameCommand.execute(null, null);
			Assert.assertTrue("Problem during set name: " + status.getMessage(), status.isOK());
		} else {
			Assert.fail("no provider found");
		}
		Assert.assertEquals("Name expected: " + newName, newName, eObject.eGet(UMLPackage.eINSTANCE.getNamedElement_Name()));

	}

}
