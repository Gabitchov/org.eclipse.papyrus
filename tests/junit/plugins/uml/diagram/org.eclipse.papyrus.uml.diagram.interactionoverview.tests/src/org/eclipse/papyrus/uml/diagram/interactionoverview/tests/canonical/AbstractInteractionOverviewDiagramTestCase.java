/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.tests.canonical;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.util.INotationType;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.papyrus.uml.diagram.interactionoverview.InteractionOverviewDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomActivityEditPartTN;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part.CustomInteractionUseEditPartCN;
import org.eclipse.papyrus.uml.diagram.interactionoverview.tests.IInteractionoverviewDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;

public class AbstractInteractionOverviewDiagramTestCase extends TestChildNode {

	private CustomActivityEditPartTN activityEditPartTN;

	private ActivityActivityContentCompartmentEditPart activityCompartmentEditPart;

	protected boolean operationFailed = false;

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new InteractionOverviewDiagramCreateCommand();
	}

	@Override
	protected String getProjectName() {
		return IInteractionoverviewDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IInteractionoverviewDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Create a view for the given type, plus the associated semantic element unless the given type is a notation-only
	 * type.
	 *
	 * <ul>
	 * <li>if type is an {@link INotationType}, then create a view using a {@link CreateViewRequest}
	 * <li>otherwise, create a view and the corresponding semantic element using a CreateViewAndElementRequest
	 * </ul>
	 *
	 * @param elementType
	 *        the type for which to create a view (and possibly a model element)
	 * @param parentEditPart
	 *        the edit part to which the creation request must be sent
	 * @return the created View
	 */
	protected View createView(final IElementType elementType, final EditPart parentEditPart) {
		return createView(elementType, null, null, parentEditPart);
	}

	/**
	 * Create a view for the given type, plus the associated semantic element unless the given type is a notation-only
	 * type.
	 *
	 * <ul>
	 * <li>if type is an {@link INotationType}, then create a view using a {@link CreateViewRequest}
	 * <li>otherwise, create a view and the corresponding semantic element using a CreateViewAndElementRequest
	 * </ul>
	 *
	 * @param elementType
	 *        the type for which to create a view (and possibly a model element)
	 * @param location
	 *        the position of the new view (may be <code>null</code>)
	 * @param size
	 *        the size of the new view (may be <code>null</code>)
	 * @param parentEditPart
	 *        the edit part to which the creation request must be sent
	 * @return the created View
	 */
	protected View createView(final IElementType elementType, final Point location, final Dimension size, final EditPart parentEditPart) {
		final View[] result = new View[1];
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				final CreateViewRequest createRequest = CreateViewRequestFactory.getCreateShapeRequest(elementType, getDiagramEditPart().getDiagramPreferencesHint());
				if(size != null) {
					createRequest.setSize(size);
				}
				if(location != null) {
					createRequest.setLocation(location);
				}
				final Command command = parentEditPart.getCommand(createRequest);
				checkCommand(command);
				execute(command);

				result[0] = getCreatedViewFromCommand(command);
			}
		});
		return result[0];
	}

	protected static View getCreatedViewFromCommand(final Command command) {
		final List<CreateCommand> createCommands = new ArrayList<CreateCommand>();
		findNestedCreateCommands(command, createCommands);
		assertEquals("There should be one CreateCommand inside the command", 1, createCommands.size());
		final Object returnValue = createCommands.get(0).getCommandResult().getReturnValue();
		if(returnValue instanceof IAdaptable) {
			final IAdaptable adaptableResult = (IAdaptable)returnValue;
			final View view = (View)adaptableResult.getAdapter(View.class);
			if(view != null) {
				return view;
			}
		}
		fail("CreateView command result not found");
		return null;
	}

	private static void findNestedCreateCommands(final Command gefCommand, final List<CreateCommand> createCommands) {
		if(gefCommand instanceof CompoundCommand) {
			final CompoundCommand compoundCommand = (CompoundCommand)gefCommand;
			@SuppressWarnings("unchecked")
			final List<Command> commands = compoundCommand.getCommands();
			for(final Command childCommand : commands) {
				findNestedCreateCommands(childCommand, createCommands);
			}
		} else if(gefCommand instanceof ICommandProxy) {
			final ICommandProxy commandProxy = (ICommandProxy)gefCommand;
			final ICommand iCommand = commandProxy.getICommand();
			findNestedCreateCommands(iCommand, createCommands);
		}
	}

	private static void findNestedCreateCommands(final ICommand gmfCommand, final List<CreateCommand> createCommands) {
		if(gmfCommand instanceof CompositeCommand) {
			final CompositeCommand compositeCommand = (CompositeCommand)gmfCommand;
			final Iterator<?> iterator = compositeCommand.iterator();
			while(iterator.hasNext()) {
				final Object element = iterator.next();
				if(element instanceof ICommand) {
					final ICommand subCommand = (ICommand)element;
					findNestedCreateCommands(subCommand, createCommands);
				} else {
					fail("error");
				}
			}
		} else if(gmfCommand instanceof CreateCommand) {
			createCommands.add((CreateCommand)gmfCommand);
		} else if(gmfCommand instanceof CommandProxy) {
			final CommandProxy commandProxy = (CommandProxy)gmfCommand;
			findNestedCreateCommands(commandProxy.getCommand(), createCommands);
		}
	}

	protected CustomActivityEditPartTN createActivity() {
		return createActivity(new Point(0, 0), new Dimension(800, 400));
	}

	protected CustomActivityEditPartTN createActivity(final Point location, final Dimension dimension) {
		createView(UMLElementTypes.Activity_2001, location, dimension, getDiagramEditPart());
		activityEditPartTN = (CustomActivityEditPartTN)EditPartUtils.findFirstChildEditPartWithId(getDiagramEditPart(), CustomActivityEditPartTN.VISUAL_ID);
		activityCompartmentEditPart = (ActivityActivityContentCompartmentEditPart)EditPartUtils.findFirstChildEditPartWithId(activityEditPartTN, ActivityActivityContentCompartmentEditPart.VISUAL_ID);
		assertNotNull("The interaction EditPart was not found under the diagram EditPart", activityEditPartTN);
		final ActivityActivityContentCompartmentEditPart interactionCompartment = (ActivityActivityContentCompartmentEditPart)EditPartUtils.findFirstChildEditPartWithId(activityEditPartTN, ActivityActivityContentCompartmentEditPart.VISUAL_ID);
		assertNotNull("The interaction compartment was not found", interactionCompartment);
		return activityEditPartTN;
	}

	/** Execute the given command in the diagram editor. */
	@Override
	protected void execute(final Command command) {
		resetLastOperationFailedState();
		getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertLastOperationSuccessful();
	}

	/** Undo the last command done in the diagram editor. */
	@Override
	protected void undo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		assertTrue("We should be able to undo", commandStack.canUndo());
		commandStack.undo();
		assertLastOperationSuccessful();
	}

	/** Redo the last command undone in the diagram editor. */
	@Override
	protected void redo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		assertTrue("We should be able to redo", commandStack.canRedo());
		commandStack.redo();
		assertLastOperationSuccessful();
	}

	/** Call {@link AbstractPapyrusTestCase#execute(Command) execute} on the UI thread. */
	@Override
	protected void executeOnUIThread(final Command command) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				execute(command);
			}
		});
	}

	/** Call {@link AbstractPapyrusTestCase#undo() undo} on the UI thread. */
	@Override
	protected void undoOnUIThread() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				undo();
			}
		});
	}

	/** Call {@link AbstractPapyrusTestCase#redo() redo} on the UI thread. */
	@Override
	protected void redoOnUIThread() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				redo();
			}
		});
	}

	/**
	 * Delete the View associated with the given EditPart, so that it is effectively hidden from the diagram without
	 * removing the corresponding semantic element.
	 */
	protected void hide(final GraphicalEditPart editPart) {
		final Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		final Command command = editPart.getCommand(deleteViewRequest);
		execute(command);
	}

	/**
	 * Reset the "operation failed" state. Call this before executing each operation for which you want to test whether
	 * if failed with {@link AbstractPapyrusTestCase#assertLastOperationSuccessful()}.
	 */
	@Override
	protected void resetLastOperationFailedState() {
		this.operationFailed = false;
	}

	/**
	 * Asserts that no Command executed on the {@link IOperationHistory} since the last call to
	 * {@link AbstractPapyrusTestCase#resetLastOperationFailedState resetLastOperationFailedState} returned
	 * {@link OperationHistoryEvent#OPERATION_NOT_OK}.
	 *
	 */
	@Override
	protected void assertLastOperationSuccessful() {
		assertFalse("The operation failed. Look at the log, or put a breakpoint on ExecutionException or DefaultOperationHistory#notifyNotOK to find the cause.", this.operationFailed);
	}

	/** The command stack to use to execute commands on the diagram. */
	@Override
	protected CommandStack getCommandStack() {
		// not "diagramEditor.getDiagramEditDomain().getDiagramCommandStack()" because it messes up undo contexts
		return this.diagramEditor.getEditingDomain().getCommandStack();
	}

	/** Check that the given command is executable. */
	protected static void checkCommand(final Command command) {
		assertNotNull("The command must not be null", command);
		assertTrue("The command must be executable", command.canExecute());
	}

	/**
	 * This tests the deletion of the View for the given GraphicalEditPart (this checks that the View is removed, but
	 * the semantic model is untouched).
	 */
	protected void testHide(final GraphicalEditPart editPart) {
		final EditPart parent = editPart.getParent();
		final int sizeBefore = parent.getChildren().size();
		final EObject semanticElement = ((View)editPart.getModel()).getElement();
		assertTrue("The semantic element should be in a Model", isInModel(semanticElement));

		executeHideCommand(editPart);
		assertEquals("The parent edit part should now contain one less child", sizeBefore - 1, parent.getChildren().size());
		assertTrue("The semantic element should still be in the Model after deleting the View", isInModel(semanticElement));
		undo();
		assertEquals("The child should be back after the undo", sizeBefore, parent.getChildren().size());
		assertTrue("The semantic element should still be in the Model after undoing the View deletion", isInModel(semanticElement));
		redo();
		assertEquals("The child should be removed after the redo", sizeBefore - 1, parent.getChildren().size());
		assertTrue("The semantic element should still be in the Model after redoing the View deletion", isInModel(semanticElement));
	}

	/**
	 * Return whether the given model element is contained by a UML {@link Model}. This is useful in order to determine
	 * if an element was deleted (removed from the Model).
	 */
	protected static boolean isInModel(final EObject semanticElement) {
		EObject parent = semanticElement.eContainer();
		while(parent != null) {
			if(parent instanceof Model) {
				return true;
			}
			parent = parent.eContainer();
		}
		return false;
	}

	/**
	 * Send the given EditPart a "delete" request (which only deletes the View), and execute the returned command.
	 *
	 * @param editPart
	 *        the EditPart to hide
	 */
	protected void executeHideCommand(final GraphicalEditPart editPart) {
		final GroupRequest deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		deleteViewRequest.setEditParts(editPart);
		final Command command = editPart.getCommand(deleteViewRequest);
		checkCommand(command);
		execute(command);
	}

	/** This tests the destruction of both the model and View for the given GraphicalEditPart. */
	protected void testDelete(final GraphicalEditPart editPart) {
		final EditPart parent = editPart.getParent();
		final int sizeBefore = parent.getChildren().size();
		final EObject semanticElement = ((View)editPart.getModel()).getElement();
		assertTrue("The semantic element should be in a Model", isInModel(semanticElement));

		executeDestroyCommand(editPart);
		assertEquals("The parent edit part should now contain one less child", sizeBefore - 1, parent.getChildren().size());
		assertFalse("The semantic element should not be in the Model any more after deleting it", isInModel(semanticElement));
		undo();
		assertEquals("The child should be back after the undo", sizeBefore, parent.getChildren().size());
		assertTrue("The semantic element should be back in the Model after undoing the deletion", isInModel(semanticElement));
		redo();
		assertEquals("The child should be removed after the redo", sizeBefore - 1, parent.getChildren().size());
		assertFalse("The semantic element should not be in the Model after redoing the deletion", isInModel(semanticElement));
	}

	/**
	 * Send the given EditPart a {@link DestroyElementRequest}, and execute the returned command.
	 *
	 * @param editPart
	 *        the EditPart to destroy
	 */
	protected void executeDestroyCommand(final GraphicalEditPart editPart) {
		final Request destroyElementRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
		final Command command = editPart.getCommand(destroyElementRequest);
		checkCommand(command);
		execute(command);
	}

	/**
	 * @param targetEditPart
	 *        the EditPart on top of which the drop will happen. This will determine the coordinates of the drop.
	 * @param parentEditPart
	 *        the EditPart in which the element will really be added. Often the same EditPart as targetEditPart,
	 *        unless dropping on top of the first EditPart puts the element in another edit part.
	 * @param droppedElement
	 *        the element to drop
	 */
	public void testDrop(final GraphicalEditPart targetEditPart, final GraphicalEditPart parentEditPart, final EObject droppedElement) {
		final int sizeBefore = parentEditPart.getChildren().size();
		final DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
		final ArrayList<EObject> list = new ArrayList<EObject>();
		list.add(droppedElement);
		dropObjectsRequest.setObjects(list);
		dropObjectsRequest.setLocation(new Point(1, 1));
		final Command command = targetEditPart.getCommand(dropObjectsRequest);
		checkCommand(command);
		execute(command);
		assertEquals("The parent edit part should now contain one more child", sizeBefore + 1, parentEditPart.getChildren().size());
		assertTrue("The dropped element should now be in the Model", isInModel(droppedElement));
		undo();
		assertEquals("The editpart should be removed after undo", sizeBefore, parentEditPart.getChildren().size());
		assertTrue("The semantic element should still be in the Model after undoing the drop", isInModel(droppedElement));
		redo();
		assertEquals("The parent edit part should contain one more child after redo", sizeBefore + 1, parentEditPart.getChildren().size());
		assertTrue("The dropped element should be in the Model after redo", isInModel(droppedElement));
	}

	/**
	 * Test setting the name on the given editPart, using a DirectEditRequest. Check that the name is set on the given
	 * named element. Also test undo and redo.
	 */
	protected <T extends EObject> void testSetNameWithDirectEditRequest(final GraphicalEditPart editPart, final T element, final INameProvider<T> nameProvider) {
		// set first name
		final String name1 = "test name 1 " + System.currentTimeMillis();
		setNameWithDirectEditRequest(editPart, name1);
		assertEquals("The element should have the first name", name1, nameProvider.getName(element));
		// set second name
		final String name2 = "test name 2 " + System.currentTimeMillis();
		setNameWithDirectEditRequest(editPart, name2);
		assertEquals("The element should have the second name", name2, nameProvider.getName(element));
		// test undo
		undo();
		assertEquals("The element name should be reset to the first name after undo", name1, nameProvider.getName(element));
		// test redo
		redo();
		assertEquals("The element name should be reset to the second name after redo", name2, nameProvider.getName(element));
	}

	/**
	 * Test setting the name on the given editPart, using a DirectEditRequest. Check that the name is set on the given
	 * named element. Also test undo and redo.
	 */
	protected void testSetNameWithDirectEditRequest(final GraphicalEditPart editPart, final NamedElement namedElement) {
		testSetNameWithDirectEditRequest(editPart, namedElement, new INameProvider<NamedElement>() {

			public String getName(final NamedElement element) {
				return element.getName();
			}
		});
	}

	/**
	 * Set the name of the given GraphicalEditPart (which must be a name edit part) using a DirectEditRequest. This sets
	 * the name in the Text widget that appears as a result of the DirectEditRequest, and then closes the Text widget to
	 * accept the changes.
	 *
	 * @param editPart
	 *        the edit part on which to perform the DirectEditRequest.
	 * @param newName
	 *        the name to set
	 */
	protected void setNameWithDirectEditRequest(final GraphicalEditPart editPart, final String newName) {
		final IFigure nameFigure = editPart.getFigure();
		final Rectangle bounds = nameFigure.getBounds();
		final Point center = bounds.getCenter();
		final DirectEditRequest directEditRequest = new DirectEditRequest();
		directEditRequest.setLocation(center);
		final Text textWidget = performDirectEditRequest(editPart, directEditRequest);
		setText(textWidget, newName);
	}

	protected interface INameProvider<T extends EObject> {

		String getName(T element);
	}

	/**
	 * Performs the given DirectEditRequest on the given EditPart, and returns the Text widget that appears to let the
	 * user edit the label.
	 */
	protected Text performDirectEditRequest(final EditPart editPart, final DirectEditRequest directEditRequest) {
		final Text[] result = new Text[1];
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				// note: both operations need to be performed in the same display runnable
				editPart.performRequest(directEditRequest);
				result[0] = findVisibleTextWidgetOnDiagram();
			}
		});
		assertNotNull("The DirectEditRequest should open a Text field", result[0]);
		return result[0];
	}

	/** Finds a {@link Text} widget inside the diagram control ({@link FigureCanvas}). */
	protected Text findVisibleTextWidgetOnDiagram() {
		final Text[] result = new Text[1];
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				final Composite composite = (Composite)getDiagramEditor().getDiagramGraphicalViewer().getControl();
				result[0] = findVisibleTextWidget(composite);
			}
		});
		return result[0];
	}

	/** Finds a {@link Text} widget inside the given composite, recursively. */
	protected Text findVisibleTextWidget(final Composite composite) {
		final Control[] children = composite.getChildren();
		for(final Control child : children) {
			if(child instanceof Text) {
				final Text text = (Text)child;
				if(text.isVisible()) {
					return text;
				}
			} else if(child instanceof Composite) {
				final Composite childComposite = (Composite)child;
				final Text subresult = findVisibleTextWidget(childComposite);
				if(subresult != null) {
					return subresult;
				}
			}
		}
		return null;
	}

	protected UmlGmfDiagramEditor getDiagramEditor() {
		return this.diagramEditor;
	}

	/** Changes the text of the given Text widget, and then removes the focus from this text in order to commit changes. */
	protected static void setText(final Text textWidget, final String newName) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				textWidget.setText(newName);
				// change the focus in order to accept the text
				textWidget.getShell().setFocus();
			}
		});
	}

	protected EditPart getTopNodeCompartment() {
		return getDefaultActivityCompartment();
	}

	protected UMLNodeEditPart createChildNodeInTopNode(IElementType type) {
		return createChildNode(type, getDefaultActivityEditPart());
	}

	protected UMLNodeEditPart createChildNode(IElementType type, EditPart containerEditPart) {
		final EditPart compartment = getTopNodeCompartment();
		assertNotNull("The compartment must not be null", compartment);
		final View view = createView(type, compartment);
		assertNotNull("The InteractionUse View should be created", view);
		return (CustomInteractionUseEditPartCN)findChildEditPartAssociatedToView(compartment, view);
	}

	protected CustomActivityEditPartTN getDefaultActivityEditPart() {
		return this.activityEditPartTN;
	}

	protected ActivityActivityContentCompartmentEditPart getDefaultActivityCompartment() {
		return this.activityCompartmentEditPart;
	}


	protected static EditPart findChildEditPartAssociatedToView(final EditPart parentEditPart, final View view) {
		EditPart result = null;
		@SuppressWarnings("unchecked")
		final List<EditPart> children = parentEditPart.getChildren();
		for(final EditPart editPart : children) {
			if(view == editPart.getModel()) {
				result = editPart;
			}
		}
		assertNotNull("There should be an EditPart corresponding to the View", result);
		return result;

	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		// TODO Auto-generated method stub
		return null;
	}
}
