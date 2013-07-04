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
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * When the width of a lifeline has been manually modified, it should not be in autosize mode
 * (the size should not be modified when the Lifeline#represent property is set).
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=383723
 * 
 */
public class TestLifelineAutoResize_383723 extends TestTopNode {

	private static final String RESIZE = "Resize: ";

	private static final String CHANGE_REPRESENTS = "Change Represents: ";

	private static final String UML_REPLACEMENT_TEMPLATE = "><nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_zAqbcIP8EeGnt9CMb_JfYQ\" name=\"Person\">" + "<ownedAttribute xmi:id=\"__-RhYIP8EeGnt9CMb_JfYQ\" name=\"company\" isStatic=\"true\" type=\"_6imi4IP8EeGnt9CMb_JfYQ\"/>" + "</nestedClassifier>" + "<nestedClassifier xmi:type=\"uml:Class\" xmi:id=\"_6imi4IP8EeGnt9CMb_JfYQ\" name=\"Company\">" + "<ownedAttribute xmi:type=\"uml:Port\" xmi:id=\"_1oQd4IP-EeGnt9CMb_JfYQ\" name=\"port1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EShort\"/>" + "</ownedAttribute>" + "<ownedAttribute xmi:id=\"_CVUmYIP_EeGnt9CMb_JfYQ\" name=\"Property1\">" + "<type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#EDouble\"/>" + "</ownedAttribute>" + "</nestedClassifier>" + "</packagedElement>" + "<packageImport xmi:id=\"_q19q4YP8EeGnt9CMb_JfYQ\">" + "<importedPackage xmi:type=\"uml:Model\" href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#_0\"/>" + "</packageImport>";

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

	@Test
	public void testManualSize() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), new Dimension(62, 200));
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		RectangleFigure fig = lifeline1.getPrimaryShape().getFigureLifelineNameContainerFigure();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);

		resize(lifeline1, bounds.getLeft(), PositionConstants.WEST, new Dimension(-20, 0)); // manual resize

		Rectangle manualSize = getAbsoluteBounds(lifeline1);
		Interaction interaction = (Interaction)getRootSemanticModel();
		Classifier p = interaction.getNestedClassifier("Person");

		changeRepresents(lifeline1, p.getFeature("company"));
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(lifeline1).equals(manualSize));

		changeRepresents(lifeline1, null);
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(lifeline1).equals(manualSize));
	}

	@Test
	public void testAutoSize() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		Rectangle initBounds = getAbsoluteBounds(lifeline1);

		Interaction interaction = (Interaction)getRootSemanticModel();
		Classifier p = interaction.getNestedClassifier("Person");
		changeRepresents(lifeline1, p.getFeature("company"));
		assertTrue(RESIZE + TEST_THE_EXECUTION, !getAbsoluteBounds(lifeline1).equals(initBounds));

		// the size of the label should be undone if the represented element is  set to null, or when the user uses the "Undo" action.
		getEMFCommandStack().undo();
		assertTrue(RESIZE + TEST_THE_UNDO, getAbsoluteBounds(lifeline1).equals(initBounds));
		getEMFCommandStack().redo();

		changeRepresents(lifeline1, null);
		assertTrue(RESIZE + TEST_THE_EXECUTION, getAbsoluteBounds(lifeline1).equals(initBounds));
	}


	@Test
	public void testPropertyChanged() {
		createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		final LifelineEditPart lifeline1 = (LifelineEditPart)getRootEditPart().getChildren().get(0);
		waitForComplete();

		Rectangle initBounds = getAbsoluteBounds(lifeline1);

		Interaction interaction = (Interaction)getRootSemanticModel();
		Classifier p = interaction.getNestedClassifier("Person");
		final Property feature = (Property)p.getFeature("company");
		changeRepresents(lifeline1, feature);
		assertTrue(RESIZE + TEST_THE_EXECUTION, !getAbsoluteBounds(lifeline1).equals(initBounds));

		// change name
		executeCommandWithoutHistory(getRootEditPart().getEditingDomain(), new DummyCommand() {

			@Override
			public void execute() {
				feature.setName("abc");
			}
		}, true);

		Rectangle bounds = getAbsoluteBounds(lifeline1);
		assertTrue(RESIZE + TEST_THE_EXECUTION, !bounds.equals(initBounds));

		// change type
		executeCommandWithoutHistory(getRootEditPart().getEditingDomain(), new DummyCommand() {

			@Override
			public void execute() {
				feature.getType().setName("xy");
			}
		}, true);
		assertTrue(RESIZE + TEST_THE_EXECUTION, !getAbsoluteBounds(lifeline1).equals(initBounds));
		assertTrue(RESIZE + TEST_THE_EXECUTION, !getAbsoluteBounds(lifeline1).equals(bounds));
	}

	/**
	 * Execute a EMF command without history
	 * 
	 * @param editingDomain
	 *        The editing domain
	 * @param command
	 *        The command
	 * @param flag
	 */
	public static void executeCommandWithoutHistory(EditingDomain editingDomain, org.eclipse.emf.common.command.Command command, boolean flag) {
		TransactionalCommandStackImpl stack = new TransactionalCommandStackImpl();
		stack.setEditingDomain((InternalTransactionalEditingDomain)editingDomain);
		try {
			stack.execute(command, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		}
	}

	static class DummyCommand extends org.eclipse.emf.common.command.AbstractCommand {

		public void execute() {
		}

		public void redo() {
		}

		@Override
		public void undo() {
		}

		@Override
		protected boolean prepare() {
			return true;
		}
	};

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
				ICreationCommand command = getDiagramCommandCreation();
				command.createDiagram(diResourceSet, null, "DiagramToTest");
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
		IFile uml = project.getFile("SequenceDiagramTest.uml");
		String content = FileUtil.read(uml.getContents());
		content = content.replaceAll("/>", UML_REPLACEMENT_TEMPLATE);

		uml.setContents(new ByteArrayInputStream(content.getBytes()), false, true, new NullProgressMonitor());
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
		waitForComplete();
		if(value != null) {
			assertTrue(CHANGE_REPRESENTS + TEST_THE_EXECUTION, lifeline.getRepresents().equals(value));
		}
	}

	private void resize(IGraphicalEditPart op, Point p, int resizeDir, Dimension deltaSize) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(p);
		req.setEditParts(op);
		req.setResizeDirection(resizeDir);
		req.setSizeDelta(deltaSize);
		if(resizeDir == PositionConstants.NORTH || resizeDir == PositionConstants.WEST) {
			req.setMoveDelta(new Point(-deltaSize.width(), -deltaSize.height()));
		}

		Command c = op.getCommand(req);
		manageResizeCommnad(op, deltaSize, c);
	}

	private void manageResizeCommnad(IGraphicalEditPart op, Dimension deltaSize, Command c) {
		assertNotNull(RESIZE + COMMAND_NULL, c);
		assertTrue(RESIZE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, c.canExecute() == true);
		Rectangle before = getAbsoluteBounds(op);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();

		Rectangle after = getAbsoluteBounds(op);
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.width() - before.width() == deltaSize.width());
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.height() - before.height() == deltaSize.height());

		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(op)));

		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_REDO, after.equals(getAbsoluteBounds(op)));
	}

	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
}
