/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.tests.generic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.uml.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

// DiResourceSet is deprecated but we need it for CreateUMLModelCommand
@SuppressWarnings({ "deprecation" })
public abstract class AbstractPapyrusTestCase {

	protected PapyrusMultiDiagramEditor papyrusEditor;

	protected DiResourceSet diResourceSet;

	protected IProject project;

	protected IFile file;

	protected IWorkbenchPage page;

	protected UmlGmfDiagramEditor diagramEditor = null;

	protected DiagramEditPart diagramEditPart;

	protected boolean operationFailed = false;

	@Before
	public void setUp() throws Exception {
		Runnable closeIntroRunnable = new Runnable() {

			public void run() {
				IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
				PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
			}
		};
		PlatformUI.getWorkbench().getDisplay().syncExec(closeIntroRunnable);

		// add a listener for failed operations
		OperationHistoryFactory.getOperationHistory().addOperationHistoryListener(new IOperationHistoryListener() {

			public void historyNotification(final OperationHistoryEvent event) {
				if(event.getEventType() == OperationHistoryEvent.OPERATION_NOT_OK) {
					AbstractPapyrusTestCase.this.operationFailed = true;
				}
			}
		});

		// disable useless animations (slows down unit tests)
		PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.ENABLE_ANIMATIONS, false);
		// maximize the workbench window
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				maximize();
				// closeAllViewsAndEditors();
			}
		});
		// create a project, model, diagram, and open the diagram in the associated Papyrus editor
		projectCreation();
	}

	/**
	 * Reset the "operation failed" state. Call this before executing each operation for which you want to test whether
	 * if failed with {@link AbstractPapyrusTestCase#assertLastOperationSuccessful()}.
	 */
	protected void resetLastOperationFailedState() {
		this.operationFailed = false;
	}

	/**
	 * Asserts that no Command executed on the {@link IOperationHistory} since the last call to
	 * {@link AbstractPapyrusTestCase#resetLastOperationFailedState resetLastOperationFailedState} returned
	 * {@link OperationHistoryEvent#OPERATION_NOT_OK}.
	 * 
	 */
	protected void assertLastOperationSuccessful() {
		assertFalse("The operation failed. Look at the log, or put a breakpoint on ExecutionException or DefaultOperationHistory#notifyNotOK to find the cause.", this.operationFailed);
	}

	protected View getRootView() {
		return getDiagramEditPart().getDiagramView();
	}

	protected Element getRootSemanticModel() {
		return (Element)getRootView().getElement();
	}

	protected UmlGmfDiagramEditor getDiagramEditor() {
		return this.diagramEditor;
	}

	@After
	public void tearDown() throws Exception {
		this.papyrusEditor.doSave(new NullProgressMonitor());
		// diResourceSet.save( new NullProgressMonitor());
		// diagramEditor.close(true);
		this.papyrusEditor = null;
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				closeAllEditors();
			}
		});
		this.project.delete(true, new NullProgressMonitor());
	}

	protected void closeAllEditors() {
		this.page.closeAllEditors(false);
	}

	protected DiagramEditPart getDiagramEditPart() {
		if(this.diagramEditPart == null) {
			this.diagramEditor = (UmlGmfDiagramEditor)this.papyrusEditor.getActiveEditor();
			this.diagramEditPart = (DiagramEditPart)this.papyrusEditor.getAdapter(DiagramEditPart.class);

			Assert.assertNotNull("Cannot find the diagram editor", diagramEditor);
			Assert.assertNotNull("Cannot find the Diagram edit part", diagramEditPart);
		}
		return this.diagramEditPart;
	}

	protected abstract ICreationCommand getDiagramCommandCreation();

	protected void projectCreation() throws Exception {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root = workspace.getRoot();
		final String timestamp = Long.toString(System.currentTimeMillis());
		this.project = root.getProject("DiagramTestProject_" + timestamp);
		this.file = this.project.getFile("DiagramTest_" + timestamp + ".di"); //$NON-NLS-2$
		this.diResourceSet = new DiResourceSet();
		// at this point, no resources have been created
		if(!this.project.exists()) {
			this.project.create(null);
		}
		if(!this.project.isOpen()) {
			this.project.open(null);
		}

		if(this.file.exists()) {
			this.file.delete(true, new NullProgressMonitor());
		}

		if(!this.file.exists()) {
			this.file.create(new ByteArrayInputStream(new byte[0]), true, new NullProgressMonitor());
			this.diResourceSet.createsModels(this.file);
			new CreateUMLModelCommand().createModel(this.diResourceSet);
			ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
			try {
				registry.add(ModelSet.class, Integer.MAX_VALUE, diResourceSet); //High priority to override all contributions
				registry.startRegistry();
			} catch (ServiceException ex) {
				//Ignore exceptions
			}
			// diResourceSet.createsModels(file);
			final ICreationCommand command = getDiagramCommandCreation();
			command.createDiagram(this.diResourceSet, null, "DiagramToTest");
			this.diResourceSet.save(new NullProgressMonitor());

		}
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				try {
					openPapyrusEditor();
				} catch (final Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

	protected static void maximize() {
		//		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().setMaximized(true);
	}

	protected static void closeAllViewsAndEditors() {
		//		final IWorkbench workbench = PlatformUI.getWorkbench();
		//		for(final IWorkbenchWindow workbenchWindow : workbench.getWorkbenchWindows()) {
		//			final IWorkbenchPage[] pages = workbenchWindow.getPages();
		//			for(final IWorkbenchPage page : pages) {
		//				final IViewReference[] viewReferences = page.getViewReferences();
		//				for(final IViewReference viewReference : viewReferences) {
		//					page.hideView(viewReference);
		//				}
		//				page.closeAllEditors(false);
		//			}
		//		}
	}

	protected void openPapyrusEditor() throws Exception {
		this.page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(this.file.getName());
		final IEditorPart editorPart = this.page.openEditor(new FileEditorInput(this.file), desc.getId());
		assertTrue("The editor must be a " + PapyrusMultiDiagramEditor.class.getSimpleName() + " (Actual type: " + editorPart.getClass().getSimpleName() + ")", editorPart instanceof PapyrusMultiDiagramEditor);
		// maximize the editor
		final IWorkbenchPartReference reference = this.page.getReference(editorPart);
		editorPart.getSite().getPage().toggleZoom(reference);
		this.papyrusEditor = ((PapyrusMultiDiagramEditor)editorPart);
		Assert.assertNotNull(papyrusEditor);
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

	/** Check that the given command is executable. */
	protected static void checkCommand(final Command command) {
		assertNotNull("The command must not be null", command);
		assertTrue("The command must be executable", command.canExecute());
	}

	/** The command stack to use to execute commands on the diagram. */
	protected CommandStack getCommandStack() {
		// not "diagramEditor.getDiagramEditDomain().getDiagramCommandStack()" because it messes up undo contexts
		return this.diagramEditor.getEditingDomain().getCommandStack();
	}

	/** Execute the given command in the diagram editor. */
	protected void execute(final Command command) {
		resetLastOperationFailedState();
		getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
		assertLastOperationSuccessful();
	}

	/** Undo the last command done in the diagram editor. */
	protected void undo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		assertTrue("We should be able to undo", commandStack.canUndo());
		commandStack.undo();
		assertLastOperationSuccessful();
	}

	/** Redo the last command undone in the diagram editor. */
	protected void redo() {
		resetLastOperationFailedState();
		final CommandStack commandStack = getCommandStack();
		assertTrue("We should be able to redo", commandStack.canRedo());
		commandStack.redo();
		assertLastOperationSuccessful();
	}

	/** Call {@link AbstractPapyrusTestCase#execute(Command) execute} on the UI thread. */
	protected void executeOnUIThread(final Command command) {
		execute(command);
		// Display.getDefault().syncExec(new Runnable() {
		//
		// public void run() {
		// execute(command);
		// }
		// });
	}

	/** Call {@link AbstractPapyrusTestCase#undo() undo} on the UI thread. */
	protected void undoOnUIThread() {
		undo();
		// Display.getDefault().syncExec(new Runnable() {
		//
		// public void run() {
		// undo();
		// }
		// });
	}

	/** Call {@link AbstractPapyrusTestCase#redo() redo} on the UI thread. */
	protected void redoOnUIThread() {
		redo();
		// Display.getDefault().syncExec(new Runnable() {
		//
		// public void run() {
		// redo();
		// }
		// });
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

	// protected void sendKey(final Control control, final int key) {
	// if (!control.setFocus()) {
	// throw new RuntimeException("Cannot give focus to the control");
	// }
	//
	// final Display display = Display.getDefault();
	// final Event keyDownEvent = new Event();
	// keyDownEvent.type = SWT.KeyDown;
	// keyDownEvent.keyCode = key;
	// display.post(keyDownEvent);
	// final Event keyUpEvent = new Event();
	// keyUpEvent.type = SWT.KeyUp;
	// keyUpEvent.keyCode = key;
	// display.post(keyUpEvent);
	// }

	protected interface INameProvider<T extends EObject> {

		String getName(T element);
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

	/**
	 * Click the palette tool with the given id on the center of the given EditPart's Figure.
	 * 
	 * @param toolId
	 *        the id of the tool to click
	 * @param target
	 *        what to click
	 */
	protected void clickTool(final String toolId, final GraphicalEditPart target) {
		final Point point = getCenterPoint(target);
		clickTool(toolId, point);
	}

	/**
	 * Click the palette tool with the given id at the given location.
	 * 
	 * @param toolId
	 *        the id of the tool to click
	 * @param point
	 *        where to click
	 */
	protected void clickTool(final String toolId, final Point point) {
		final Tool tool = createTool(toolId);
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				tool.activate();
				internalClickTool(tool, point);
				tool.deactivate();
			}
		});
	}

	protected void clickTwiceWithTool(final String toolId, final GraphicalEditPart firstTarget, final GraphicalEditPart secondTarget) {
		final Point firstPoint = getCenterPoint(firstTarget);
		final Point secondPoint = getCenterPoint(secondTarget);
		clickTwiceWithTool(toolId, firstPoint, secondPoint);
	}

	protected void clickTwiceWithTool(final String toolId, final Point firstPoint, final Point secondPoint) {
		final Tool tool = createTool(toolId);
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				tool.activate();
				internalClickTool(tool, firstPoint);
				internalClickTool(tool, secondPoint);
				tool.deactivate();
			}
		});
	}

	private Tool createTool(final String toolId) {
		final PaletteViewer paletteViewer = ((EditDomain)this.diagramEditor.getDiagramEditDomain()).getPaletteViewer();
		final ToolEntry toolEntry = findToolEntry(toolId, paletteViewer.getPaletteRoot());
		assertNotNull("The tool with id " + toolId + " was not found in the palette", toolEntry); //$NON-NLS-2$
		final Tool tool = toolEntry.createTool();
		assertNotNull("The tool with id " + toolId + " couldn't be created", tool); //$NON-NLS-2$
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				initializeTool(tool);
			}
		});
		return tool;
	}

	protected void initializeTool(final Tool tool) {
		tool.setViewer(this.diagramEditor.getDiagramGraphicalViewer());
		tool.setEditDomain((EditDomain)this.diagramEditor.getDiagramEditDomain());
	}

	/**
	 * Find a tool with the given id in the given palette container.
	 * 
	 * @param toolId
	 *        the id of the tool to return
	 * @param paletteContainer
	 *        the palette root
	 * @return the tool entry, from which a new instance of the tool can be created
	 */
	protected ToolEntry findToolEntry(final String toolId, final PaletteContainer paletteContainer) {
		final List<?> children = paletteContainer.getChildren();
		for(final Object child : children) {
			if(child instanceof PaletteContainer) {
				final PaletteContainer childContainer = (PaletteContainer)child;
				final ToolEntry subresult = findToolEntry(toolId, childContainer);
				if(subresult != null) {
					return subresult;
				}
			} else if(child instanceof ToolEntry) {
				final ToolEntry toolEntry = (ToolEntry)child;
				if(toolId.equals(toolEntry.getId())) {
					return toolEntry;
				}
			}
		}
		return null;
	}

	/**
	 * Emulate a click of the given tool at the given point on the diagram (the tool should be {@link Tool#activate()
	 * activated}.
	 */
	protected void internalClickTool(final Tool tool, final Point point) {
		final Event event = new Event();
		event.x = point.x;
		event.y = point.y;
		event.widget = this.diagramEditor.getDiagramGraphicalViewer().getControl();
		event.button = 1;
		// final MouseEvent mouseEvent = new MouseEvent(null, figure, );
		final MouseEvent mouseEvent = new MouseEvent(event);
		event.type = SWT.MouseMove;
		tool.mouseMove(mouseEvent, this.diagramEditor.getDiagramEditPart().getViewer());
		event.type = SWT.MouseDown;
		tool.mouseDown(mouseEvent, this.diagramEditor.getDiagramEditPart().getViewer());
		event.type = SWT.MouseUp;
		tool.mouseUp(mouseEvent, this.diagramEditor.getDiagramEditPart().getViewer());
	}

	/**
	 * Send an SelectionRequest of type "open" to the given EditPart (this is what happens when the user double-clicks).
	 */
	protected static void sendOpenSelectionRequest(final GraphicalEditPart graphicalEditPart, final Point point) {
		final SelectionRequest openRequest = new SelectionRequest();
		openRequest.setType(RequestConstants.REQ_OPEN);
		openRequest.setLastButtonPressed(0);
		openRequest.setLocation(point);
		graphicalEditPart.performRequest(openRequest);
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

	/**
	 * Find the EditPart corresponding to the given View, or <code>null</code> if it doesn't exist, or is not registered
	 * in the viewer's visual part map.
	 * 
	 * @param view
	 *        the view for which to find a corresponding EditPart
	 * @return the EditPart corresponding to the View
	 */
	protected EditPart findEditPart(final View view) {
		final Object result = this.diagramEditPart.getRoot().getViewer().getVisualPartMap().get(view);
		assertTrue("The EditPart corresponding to the View was not found", result instanceof EditPart);
		return (EditPart)result;
	}

	/** Processes all events waiting in the Display's event loop and then returns. */
	protected static void flushEventLoop() {
		final Display display = Display.getDefault();
		display.syncExec(new Runnable() {

			public void run() {
				try {
					while(display.readAndDispatch()) {
						// nothing
					}
				} catch (Exception ex) {
					//Do not fail the test for invalid runnables
				}
			}
		});
	}

	/**
	 * Move the given EditPart in its parent.
	 * 
	 * @param editPartToMove
	 *        the EditPart to move
	 * @param parentEditPart
	 *        the parent
	 * @param moveDelta
	 *        the offset
	 */
	protected void moveEditPart(final GraphicalEditPart editPartToMove, final GraphicalEditPart parentEditPart, final Point moveDelta) {
		moveEditParts(Collections.singletonList(editPartToMove), parentEditPart, moveDelta);
	}

	/**
	 * Resize the given EditPart in its parent.
	 * 
	 * @param editPartToResize
	 *        the EditPart to resize
	 * @param parentEditPart
	 *        the parent
	 * @param resizeDelta
	 *        the size offset
	 * @param direction
	 *        the direction to resize (cf {@link PositionConstants})
	 */
	protected void resizeEditPart(final GraphicalEditPart editPartToResize, final GraphicalEditPart parentEditPart, final Dimension resizeDelta, final int direction) {
		resizeEditParts(Collections.singletonList(editPartToResize), parentEditPart, resizeDelta, direction);
	}

	/**
	 * Move the given EditParts in their parent.
	 * 
	 * @param editPartsToMove
	 *        the EditParts to move
	 * @param parentEditPart
	 *        the parent
	 * @param moveDelta
	 *        the location offset
	 */
	protected void moveEditParts(final List<? extends GraphicalEditPart> editPartsToMove, final GraphicalEditPart parentEditPart, final Point moveDelta) {
		if(editPartsToMove.size() < 1 || parentEditPart == null || moveDelta == null) {
			throw new IllegalArgumentException();
		}
		final ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest();
		changeBoundsRequest.setType(RequestConstants.REQ_MOVE_CHILDREN);
		// emulate a drag&drop with the mouse over the first EditPart
		changeBoundsRequest.setLocation(computeLocationWithDelta(editPartsToMove.get(0), moveDelta));
		changeBoundsRequest.setMoveDelta(moveDelta);
		changeBoundsRequest.setEditParts(editPartsToMove);
		final Command command = parentEditPart.getCommand(changeBoundsRequest);
		checkCommand(command);
		executeOnUIThread(command);
		flushEventLoop();
	}

	/**
	 * Resize the given EditParts in their parent.
	 * 
	 * @param editPartsToMove
	 *        the EditParts to resize
	 * @param parentEditPart
	 *        the parent
	 * @param resizeDelta
	 *        the size offset
	 * @param direction
	 *        the direction to resize (cf {@link PositionConstants})
	 */
	protected void resizeEditParts(final List<? extends GraphicalEditPart> editPartsToResize, final GraphicalEditPart parentEditPart, final Dimension resizeDelta, final int direction) {
		if(editPartsToResize.size() < 1 || parentEditPart == null || resizeDelta == null) {
			throw new IllegalArgumentException();
		}
		final ChangeBoundsRequest changeBoundsRequest = new ChangeBoundsRequest();
		changeBoundsRequest.setType(RequestConstants.REQ_RESIZE_CHILDREN);
		changeBoundsRequest.setLocation(computeLocationWithDelta(editPartsToResize.get(0), new Point(resizeDelta.width, resizeDelta.height)));
		changeBoundsRequest.setMoveDelta(new Point());
		changeBoundsRequest.setSizeDelta(resizeDelta);
		changeBoundsRequest.setResizeDirection(direction);
		changeBoundsRequest.setEditParts(editPartsToResize);
		final Command command = parentEditPart.getCommand(changeBoundsRequest);
		checkCommand(command);
		executeOnUIThread(command);
		flushEventLoop();
	}

	/**
	 * Compute a Location for the mouse pointer that would occur when dragging the center of the given EditPart by the
	 * given translation vector.
	 * 
	 * @param graphicalEditPart
	 *        the EditPart being dragged
	 * @param moveDelta
	 *        the offset (the translation vector)
	 * @return the target Location
	 */
	private static Point computeLocationWithDelta(final GraphicalEditPart graphicalEditPart, final Point moveDelta) {
		return getAbsoluteBounds(graphicalEditPart).getCenter().translate(moveDelta);
	}

	protected static Rectangle getBounds(final GraphicalEditPart graphicalEditPart) {
		return new Rectangle(graphicalEditPart.getFigure().getBounds());
	}

	/** Return the center of the given EditPart's Figure, in absolute coordinates. */
	protected static Point getCenterPoint(final GraphicalEditPart editPart) {
		final Rectangle bounds = new Rectangle(editPart.getFigure().getBounds());
		editPart.getFigure().getParent().translateToAbsolute(bounds);
		final Point point = new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
		return point;
	}

	protected static Rectangle getAbsoluteBounds(final GraphicalEditPart graphicalEditPart) {
		final Rectangle bounds = getBounds(graphicalEditPart);
		graphicalEditPart.getFigure().getParent().translateToAbsolute(bounds);
		return bounds;
	}

	/**
	 * Check that undo and redo work correctly after moving/resizing an EditPart (the EditPart must have been
	 * moved/resized before calling this method).
	 * 
	 * @param editPart
	 *        an EditPart that was just moved/resized
	 * @param boundsBefore
	 *        the bounds of this EditPart before it was moved/resized
	 */
	protected void testUndoRedoChangeBoundsEditPart(final GraphicalEditPart editPart, final Rectangle boundsBefore) {
		final Rectangle boundsAfter = getBounds(editPart);

		// test undo
		undoOnUIThread();
		flushEventLoop();
		Rectangle bounds = getBounds(editPart);
		assertEquals("The bounds change should be undone", boundsBefore, bounds);

		// test redo
		redoOnUIThread();
		flushEventLoop();
		bounds = getBounds(editPart);
		assertEquals("The bounds change should be redone", boundsAfter, bounds);
	}

	/**
	 * Check the bounds of the given GraphicalEditPart's Figure
	 * 
	 * @param graphicalEditPart
	 *        The EditPart whose Figure's bounds to check
	 * @param expectedPosition
	 *        the expected position (-1 for any of the coordinates means not to check this coordinate)
	 * @param expectedSize
	 *        the expected size (-1 for any of the coordinates means not to check this coordinate)
	 * @param xErrorMargin
	 *        an error margin for the horizontal position
	 * @param yErrorMargin
	 *        an error margin for the vertical position
	 * @param widthErrorMargin
	 *        an error margin for the width
	 * @param heightErrorMargin
	 *        an error margin for the height
	 */
	protected static void assertBounds(final GraphicalEditPart graphicalEditPart, final Point expectedPosition, final Dimension expectedSize, final int xErrorMargin, final int yErrorMargin, final int widthErrorMargin, final int heightErrorMargin) {
		assertBounds(graphicalEditPart, new Rectangle(expectedPosition, expectedSize), xErrorMargin, yErrorMargin, widthErrorMargin, heightErrorMargin);
	}

	/**
	 * Check the bounds of the given GraphicalEditPart's Figure
	 * 
	 * @param graphicalEditPart
	 *        The EditPart whose Figure's bounds to check
	 * @param expectedBounds
	 *        the expected bounds (-1 for any of the coordinates means not to check this coordinate)
	 * @param xErrorMargin
	 *        an error margin for the horizontal position
	 * @param yErrorMargin
	 *        an error margin for the vertical position
	 * @param widthErrorMargin
	 *        an error margin for the width
	 * @param heightErrorMargin
	 *        an error margin for the height
	 */
	protected static void assertBounds(final GraphicalEditPart graphicalEditPart, final Rectangle expectedBounds, final int xErrorMargin, final int yErrorMargin, final int widthErrorMargin, final int heightErrorMargin) {
		// let GMF do its layout so that the bounds are correct
		flushEventLoop();
		final Rectangle bounds = getBounds(graphicalEditPart);
		if(expectedBounds.width != -1) {
			assertTrue("The element should be about " + expectedBounds.width + " pixels wide", Math.abs(bounds.width - expectedBounds.width) <= widthErrorMargin);
		}
		if(expectedBounds.height != -1) {
			assertTrue("The element should be about " + expectedBounds.height + " pixels high", Math.abs(bounds.height - expectedBounds.height) <= heightErrorMargin);
		}
		if(expectedBounds.x != -1) {
			assertTrue("The element should have a horizontal position at about " + expectedBounds.x + " pixels", Math.abs(bounds.x - expectedBounds.x) <= xErrorMargin);
		}
		if(expectedBounds.y != -1) {
			assertTrue("The element should have a vertical position at about " + expectedBounds.y + " pixels", Math.abs(bounds.y - expectedBounds.y) <= yErrorMargin);
		}
	}

	/**
	 * Find the EditPart corresponding to the given View in the given parent EditPart's children.
	 * 
	 * @param parentEditPart
	 *        the EditPart in which the EditPart we are looking for should be found
	 * @param view
	 *        the View corresponding to the searched EditPart
	 * @return the found EditPart
	 */
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

}
