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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


/**
 * Current implementation of lifelines representing decompositions does'nt allow
 * their moving (horizontally), resizing and resizing of the lifeline representing
 * the father component. These operations should be allowed.
 */
public class TestDecompositionMove_364812 extends TestTopNode {

	private static final String MOVE = "Move: ";

	private static final String UML_REPLACEMENT_TEMPLATE = "><nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_zAqbcIP8EeGnt9CMb_JfYQ\" name=\"Person\">" + "<ownedAttribute xmi:id=\"__-RhYIP8EeGnt9CMb_JfYQ\" name=\"company\" isStatic=\"true\" type=\"_6imi4IP8EeGnt9CMb_JfYQ\"/>" + "</nestedClassifier>" + "<nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_6imi4IP8EeGnt9CMb_JfYQ\" name=\"Company\">" + "<ownedAttribute xmi:type=\"uml:Port\" xmi:id=\"_1oQd4IP-EeGnt9CMb_JfYQ\" name=\"port1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EShort\"/>" + "</ownedAttribute>" + "<ownedAttribute xmi:id=\"_CVUmYIP_EeGnt9CMb_JfYQ\" name=\"Property1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EDouble\"/>" + "</ownedAttribute>" + "</nestedClassifier>" + "</packagedElement>" + "<packageImport xmi:id=\"_q19q4YP8EeGnt9CMb_JfYQ\">" + "<importedPackage xmi:type=\"uml:Model\" href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#_0\"/>" + "</packageImport>";

	private static final String RESIZE = "Resize: ";

	private static final String CHANGE_REPRESENTS = "Change Represents: ";

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}
	
	@Override
	protected void projectCreation() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();
		project = root.getProject(getProjectName());
		file = project.getFile(getFileName());
		this.diResourceSet = new DiResourceSet();
		try {
			//at this point, no resources have been created
			if(!project.exists()) {
				project.create(null);
			}
			if(!project.isOpen()) {
				project.open(null);
			}

			if(file.exists()) {
				file.delete(true, new NullProgressMonitor());
			}

			if(!file.exists()) {
				file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
				diResourceSet.createsModels(file);
				new CreateUMLModelCommand().createModel(this.diResourceSet);
				ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
				try {
					registry.add(ModelSet.class, Integer.MAX_VALUE, diResourceSet); //High priority to override all contributions
					registry.startRegistry();
				} catch (ServiceException ex) {
					//Ignore exceptions
				}
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram(diResourceSet, null, "DiagramToTest");
				diResourceSet.save(new NullProgressMonitor());

			}
			initUml();

			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.closeAllEditors(true);

			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			papyrusEditor = (IMultiDiagramEditor)page.openEditor(new FileEditorInput(file), desc.getId());
		} catch (Exception e) {
			System.err.println("error " + e);
		}
	}

	protected void initUml() throws CoreException {
		IFile uml = project.getFile("SequenceDiagramTest.uml");
		String content = FileUtil.read(uml.getContents());
		content = content.replaceAll("/>", UML_REPLACEMENT_TEMPLATE);

		uml.setContents(new ByteArrayInputStream(content.getBytes()), false, true, new NullProgressMonitor());
	}

	@Test
	public void testMoving() {
		LifelineEditPart decomposition = setupDecomposition();
		{ // test move			
			moveLifeline(decomposition, new Point(50, 0));
			moveLifeline(decomposition, new Point(-20, 0));
			// move child
			moveLifeline((LifelineEditPart)decomposition.getChildren().get(1), new Point(10, 0));
			moveLifeline((LifelineEditPart)decomposition.getChildren().get(2), new Point(-10, 0));
		}
	}

	@Test
	public void testResizing() {
		LifelineEditPart decomposition = setupDecomposition();
		// resize decomposition
		{
			resizeEast(decomposition, new Dimension(50, 0));
			resizeEast(decomposition, new Dimension(-20, 0));
			resizeWest(decomposition, new Dimension(30, 0));
			resizeWest(decomposition, new Dimension(-10, 0));
		}

		{ // resize child
			resizeEast((LifelineEditPart)decomposition.getChildren().get(1), new Dimension(20, 0));
			resizeEast((LifelineEditPart)decomposition.getChildren().get(1), new Dimension(-10, 0));

			resizeWest((LifelineEditPart)decomposition.getChildren().get(2), new Dimension(20, 0));
			resizeWest((LifelineEditPart)decomposition.getChildren().get(2), new Dimension(-10, 0));
		}
	}

	private void manageResizeCommnad(IGraphicalEditPart part, Dimension deltaSize, Command c) {
		assertNotNull(RESIZE + COMMAND_NULL, c);
		assertTrue(RESIZE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, c.canExecute() == true);
		Rectangle before = getAbsoluteBounds(part);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(part);
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.width() - before.width() == deltaSize.width());
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.height() - before.height() == deltaSize.height());

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(part)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_REDO, after.equals(getAbsoluteBounds(part)));
	}

	protected void resizeEast(IGraphicalEditPart op, Dimension deltaSize) {
		Point p = getRight(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.EAST);
		req.setSizeDelta(deltaSize);

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	protected void resizeWest(IGraphicalEditPart op, Dimension deltaSize) {
		Point p = getLeft(op);
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(PositionConstants.WEST);
		req.setSizeDelta(deltaSize);
		req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	protected LifelineEditPart setupDecomposition() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(240, 200));

		Interaction interaction = (Interaction)getRootSemanticModel();
		CustomLifelineEditPart lifeline1 = (CustomLifelineEditPart)getRootEditPart().getChildren().get(0);
		Classifier p = interaction.getNestedClassifier("Person");
		changeRepresents(lifeline1, p.getFeature("company"));
		assertTrue(CREATION + INITIALIZATION_TEST, !lifeline1.isInlineMode());
		assertTrue(CREATION + INITIALIZATION_TEST, lifeline1.getChildren().size() == 1);

		waitForComplete();
		PopupUtil.addDialogCloseHandler();
		createNode(UMLElementTypes.Lifeline_3001, lifeline1, new Point(100, 120), new Dimension(62, 200));
		createNode(UMLElementTypes.Lifeline_3001, lifeline1, new Point(200, 120), new Dimension(62, 200));

		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getChildren().size() == 3);
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getChildren().get(1) instanceof LifelineEditPart);
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.getChildren().get(2) instanceof LifelineEditPart);
		assertTrue(CREATION + TEST_THE_EXECUTION, lifeline1.isInlineMode());
		waitForComplete();
		return lifeline1;
	}

	protected void moveLifeline(LifelineEditPart lifelineEP, Point moveDelta) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		req.setResizeDirection(moveDelta.x > 0 ? PositionConstants.EAST : PositionConstants.WEST);
		req.setLocation(getAbsoluteCenter(lifelineEP));
		req.setEditParts(lifelineEP);
		req.setMoveDelta(moveDelta);

		Command command = lifelineEP.getCommand(req);
		assertNotNull(MOVE + COMMAND_NULL, command);
		assertTrue(MOVE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		Rectangle before = getAbsoluteBounds(lifelineEP);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(lifelineEP);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.x() - before.x() == moveDelta.x);
		assertTrue(MOVE + TEST_THE_EXECUTION, after.y() - before.y() == moveDelta.y);

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(MOVE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(lifelineEP)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(MOVE + TEST_THE_REDO, after.equals(getAbsoluteBounds(lifelineEP)));
	}

	protected Point getLeft(IGraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getLeft();
		return p;
	}

	protected Point getRight(IGraphicalEditPart op) {
		IFigure f = op.getFigure();
		Rectangle b = f.getBounds().getCopy();
		f.translateToAbsolute(b);
		Point p = b.getRight();
		return p;
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		waitForComplete();
		PopupUtil.removeDialogCloseHandler();
	}

	protected void changeRepresents(LifelineEditPart p, Object value) {
		Lifeline lifeline = (Lifeline)p.resolveSemanticElement();
		EReference feature = UMLPackage.eINSTANCE.getLifeline_Represents();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(lifeline);
		SetRequest request = new SetRequest(p.getEditingDomain(), lifeline, feature, value);
		ICommand createGMFCommand = provider.getEditCommand(request);
		org.eclipse.emf.common.command.AbstractCommand emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		assertTrue(CHANGE_REPRESENTS + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, emfCommand.canExecute() == true);
		getEMFCommandStack().execute(emfCommand);
		assertTrue(CHANGE_REPRESENTS + TEST_THE_EXECUTION, lifeline.getRepresents().equals(value));
	}

	public void createNode(IElementType type, GraphicalEditPart parent, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parent.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
}
