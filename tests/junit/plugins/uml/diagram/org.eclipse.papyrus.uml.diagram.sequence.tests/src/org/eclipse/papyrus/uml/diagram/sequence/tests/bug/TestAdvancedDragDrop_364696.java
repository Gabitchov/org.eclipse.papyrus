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
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.junit.Test;

/**
 * Drag and drop is not well supported for all elements of sequence diagrams. Dnd
 * should be supported for all elements. Moreover, it would be interesting to have
 * an advanced drag and drop support for some elements. For instance, a drag and
 * drop of a ConnectableElement on an Interaction should create a Lifeline and
 * reference the dropped ConnectableElement in the Lifeline "represents" property.
 * A generic solution may be possible.
 */
public class TestAdvancedDragDrop_364696 extends TestTopNode {

	private static final String UML_REPLACEMENT_TEMPLATE = "><nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_zAqbcIP8EeGnt9CMb_JfYQ\" name=\"Person\">" + "<ownedAttribute xmi:id=\"__-RhYIP8EeGnt9CMb_JfYQ\" name=\"company\" isStatic=\"true\" type=\"_6imi4IP8EeGnt9CMb_JfYQ\"/>" + "</nestedClassifier>" + "<nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_6imi4IP8EeGnt9CMb_JfYQ\" name=\"Company\">" + "<ownedAttribute xmi:type=\"uml:Port\" xmi:id=\"_1oQd4IP-EeGnt9CMb_JfYQ\" name=\"port1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EShort\"/>" + "</ownedAttribute>" + "<ownedAttribute xmi:id=\"_CVUmYIP_EeGnt9CMb_JfYQ\" name=\"Property1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EDouble\"/>" + "</ownedAttribute>" + "</nestedClassifier>" + "</packagedElement>" + "<packageImport xmi:id=\"_q19q4YP8EeGnt9CMb_JfYQ\">" + "<importedPackage xmi:type=\"uml:Model\" href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#_0\"/>" + "</packageImport>";

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	protected void projectCreation() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();
		project = root.getProject("ClazzDiagramTestProject");
		file = project.getFile("ClazzDiagramTest.di");
		this.diResourceSet = new DiResourceSet();
		try {
			//at this point, no resources have been created
			if(!project.exists())
				project.create(null);
			if(!project.isOpen())
				project.open(null);

			if(file.exists()) {
				file.delete(true, new NullProgressMonitor());
			}

			if(!file.exists()) {
				file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
				diResourceSet.createsModels(file);
				new CreateUMLModelCommand().createModel((DiResourceSet)this.diResourceSet);
				// diResourceSet.createsModels(file);
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram((DiResourceSet)diResourceSet, null, "DiagramToTest");
				diResourceSet.save(new NullProgressMonitor());

			}
			initUml();

			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.closeAllEditors(true);

			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			page.openEditor(new FileEditorInput(file), desc.getId());
		} catch (Exception e) {
			System.err.println("error " + e);
		}
	}

	protected void initUml() throws CoreException {
		IFile uml = project.getFile("ClazzDiagramTest.uml");
		String content = FileUtil.read(uml.getContents());
		content = content.replaceAll("/>", UML_REPLACEMENT_TEMPLATE);

		uml.setContents(new ByteArrayInputStream(content.getBytes()), false, true, new NullProgressMonitor());
	}

	@Test
	public void testDragDrop() {
		Interaction interaction = (Interaction)getRootSemanticModel();
		{
			Classifier p = interaction.getNestedClassifier("Person");
			Feature feature = p.getFeature("company");

			assertTrue("", getRootEditPart().getChildren().size() == 0);
			dropObject(getRootEditPart(), feature);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 1);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(0) instanceof LifelineEditPart);
			assertTrue(DROP + TEST_THE_EXECUTION, getRepresents(((LifelineEditPart)getRootEditPart().getChildren().get(0))) == feature);
		}
		{
			Classifier p = interaction.getNestedClassifier("Company");
			Feature feature = p.getFeature("Property1");

			dropObject(getRootEditPart(), feature);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 2);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(1) instanceof LifelineEditPart);
			assertTrue(DROP + TEST_THE_EXECUTION, getRepresents(((LifelineEditPart)getRootEditPart().getChildren().get(1))) == feature);
		}

		{
			Classifier p = interaction.getNestedClassifier("Company");
			Feature feature = p.getFeature("port1");

			dropObject(getRootEditPart(), feature);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().size() == 3);
			assertTrue(DROP + TEST_THE_EXECUTION, getRootEditPart().getChildren().get(2) instanceof LifelineEditPart);
			assertTrue(DROP + TEST_THE_EXECUTION, getRepresents(((LifelineEditPart)getRootEditPart().getChildren().get(2))) == feature);
		}
	}

	protected ConnectableElement getRepresents(LifelineEditPart editPart) {
		Lifeline lifeline = (Lifeline)editPart.resolveSemanticElement();
		return lifeline.getRepresents();
	}

	protected void dropObject(GraphicalEditPart parent, Object obj) {
		int childrenSize = parent.getChildren().size();

		DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		ArrayList list = new ArrayList();
		list.add(obj);
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(20, 20));
		Command command = parent.getCommand(dropObjectsRequest);
		assertNotNull(DROP + COMMAND_NULL, command);
		assertTrue(DROP + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(DROP + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
		assertTrue(DROP + TEST_THE_EXECUTION, parent.getChildren().size() == childrenSize + 1);

		getDiagramCommandStack().undo();
		assertTrue(DROP + TEST_THE_UNDO, parent.getChildren().size() == childrenSize);

		getDiagramCommandStack().redo();
		assertTrue(DROP + TEST_THE_REDO, parent.getChildren().size() == childrenSize + 1);
	}
}
