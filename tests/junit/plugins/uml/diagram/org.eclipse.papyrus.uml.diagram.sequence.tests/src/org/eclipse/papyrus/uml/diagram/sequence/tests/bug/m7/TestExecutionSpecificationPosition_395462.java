/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.AbstractElementListSelectionDialog;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * Bug:
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=395462
 * 
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestExecutionSpecificationPosition_395462 extends AbstractNodeTest {

	private static final String CHECK_ES_POSITION = "The ExecutionSpecification should be located at the center of Lifeline:";

	private static final String CHECK_LIFELINE_WIDTH_AFTER_RENAMED = "The width should be changed after renamed Lifeline:";

	private static final String CHECK_LIFELINE__RENAMED = "Lifeline Renamed:";

	private static final String CHANGE_REPRESENTS = "Change Represents: ";

	private static final String PREPARE_MODEL = "Prepare Model: ";

	private Class libraryType;

	private Class stringType;

	private Class bookType;

	private Property authorProperty;

	private Property booksProperty;

	@Test
	public void testOnChangeLifelineName() {
		//Make sure the lifeline width is -1 to enable auto-increment.
		LifelineEditPart lifeline = createLifeline("Lifeline", new Point(100, 100), null);
		AbstractExecutionSpecificationEditPart es = createExecutionSpecification(lifeline, new Point(131, 150), null);
		//Old bounds
		Rectangle lifelineBounds = getAbsoluteBounds(lifeline);
		Rectangle esBounds = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, lifelineBounds.getCenter().x == esBounds.getCenter().x);
		//rename
		rename(lifeline, "Rename to Long Name of Lifeline...");
		//New bounds
		Rectangle newLifelineBounds = getAbsoluteBounds(lifeline);
		//Check width after renamed.
		assertTrue(CHECK_LIFELINE_WIDTH_AFTER_RENAMED, lifelineBounds.width < newLifelineBounds.width);
		Rectangle newEsBounds = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, newLifelineBounds.getCenter().x == newEsBounds.getCenter().x);
	}

	/**
	 * @param editPart
	 * @param newName
	 */
	private void rename(LifelineEditPart editPart, final String newName) {
		final Lifeline lifeline = (Lifeline)editPart.resolveSemanticElement();
		getDiagramCommandStack().execute(new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(), "Rename", Collections.singletonList(file)) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				lifeline.setName(newName);
				return CommandResult.newOKCommandResult();
			}
		}));
		waitForComplete();
		assertTrue(CHECK_LIFELINE__RENAMED, newName.equals(lifeline.getName()));
	}

	/**
	 * @param lifeline
	 * @param bounds
	 * @return
	 */
	private AbstractExecutionSpecificationEditPart createExecutionSpecification(LifelineEditPart lifeline, Point location, Dimension size) {
		return (AbstractExecutionSpecificationEditPart)createNode(UMLElementTypes.ActionExecutionSpecification_3006, lifeline, location, size);
	}

	/**
	 * @param name
	 * @param point
	 * @param bounds
	 * @return
	 */
	private LifelineEditPart createLifeline(String name, Point location, Dimension size) {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), location, size);
		if(name != null) {
			rename(lifeline, name);
		}
		return lifeline;
	}

	@Test
	public void testOnResizeLifeline() {
		LifelineEditPart lifeline = createLifeline("Lifeline", new Point(200, 100), null);
		AbstractExecutionSpecificationEditPart es = createExecutionSpecification(lifeline, new Point(231, 150), null);
		//Old bounds
		Rectangle lifelineBounds = getAbsoluteBounds(lifeline);
		Rectangle esBounds = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, lifelineBounds.getCenter().x == esBounds.getCenter().x);
		//resize west
		resize(lifeline, lifelineBounds.getLocation(), PositionConstants.WEST, new Dimension(30, 0));
		Rectangle newLifelineBounds = getAbsoluteBounds(lifeline);
		assertTrue(CHECK_ES_POSITION, lifelineBounds.width + 30 == newLifelineBounds.width);
		Rectangle newEsBounds = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, newLifelineBounds.getCenter().x == newEsBounds.getCenter().x);
		//resize east
		resize(lifeline, lifelineBounds.getLocation(), PositionConstants.EAST, new Dimension(30, 0));
		Rectangle newLifelineBounds2 = getAbsoluteBounds(lifeline);
		assertTrue(CHECK_ES_POSITION, newLifelineBounds.width + 30 == newLifelineBounds2.width);
		Rectangle newEsBounds2 = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, newLifelineBounds2.getCenter().x == newEsBounds2.getCenter().x);
	}

	@Test
	public void testOnPartDecomposition() {
		LifelineEditPart host = createLifeline(null, new Point(200, 100), new Dimension(240, 200));
		final Package model = getPackage();
		getDiagramCommandStack().execute(new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(), "", Collections.singletonList(file)) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				libraryType = model.createOwnedClass("Library", false);
				stringType = model.createOwnedClass("String", false);
				bookType = model.createOwnedClass("Book", false);
				authorProperty = bookType.createOwnedAttribute("author", stringType);
				booksProperty = libraryType.createOwnedAttribute("books", bookType, 0, -1);
				return CommandResult.newOKCommandResult();
			}
		}));
		assertNotNull(PREPARE_MODEL, libraryType);
		assertNotNull(PREPARE_MODEL, stringType);
		assertNotNull(PREPARE_MODEL, bookType);
		assertNotNull(PREPARE_MODEL, authorProperty);
		assertNotNull(PREPARE_MODEL, booksProperty);
		//set represents;
		setRepresents(host, booksProperty);
		assertTrue(host instanceof CustomLifelineEditPart);
		//create PartDecomposition
		Rectangle bounds = getAbsoluteBounds(host);
		LifelineEditPart lifeline = createLifeline(host, new Point(bounds.x + 40, bounds.y + 1), authorProperty);
		assertNotNull(PREPARE_MODEL, lifeline);
		assertTrue(((CustomLifelineEditPart)host).isInlineMode());
		Rectangle b1 = getAbsoluteBounds(lifeline);
		AbstractExecutionSpecificationEditPart es = createExecutionSpecification(lifeline, b1.getCenter(), null);
		assertNotNull(es);
		Rectangle esBounds = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, b1.getCenter().x == esBounds.getCenter().x);
		//resize west
		resize(lifeline, b1.getLocation(), PositionConstants.WEST, new Dimension(30, 0));
		Rectangle newLifelineBounds = getAbsoluteBounds(lifeline);
		assertTrue(CHECK_ES_POSITION, b1.width + 30 == newLifelineBounds.width);
		Rectangle newEsBounds = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, newLifelineBounds.getCenter().x == newEsBounds.getCenter().x);
		//resize east
		resize(lifeline, b1.getLocation(), PositionConstants.EAST, new Dimension(30, 0));
		Rectangle newLifelineBounds2 = getAbsoluteBounds(lifeline);
		assertTrue(CHECK_ES_POSITION, newLifelineBounds.width + 30 == newLifelineBounds2.width);
		Rectangle newEsBounds2 = getAbsoluteBounds(es);
		assertTrue(CHECK_ES_POSITION, newLifelineBounds2.getCenter().x == newEsBounds2.getCenter().x);
	}

	/**
	 * @param lifeline
	 * @param propertyroperty
	 * @return
	 */
	private LifelineEditPart createLifeline(LifelineEditPart lifeline, Point location, final Property property) {
		//CREATION
		IElementType type = UMLElementTypes.Lifeline_3001;
		CreateViewRequest createReq = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		createReq.setLocation(location);
		Command command = lifeline.getCommand(createReq);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		final List<ElementListSelectionDialog> result = new ArrayList<ElementListSelectionDialog>();
		Display.getCurrent().addFilter(SWT.Show, new Listener() {

			public void handleEvent(Event event) {
				if(event.widget instanceof Shell) {
					final Shell shell = (Shell)event.widget;
					Object data = shell.getData();
					if(!(data instanceof ElementListSelectionDialog)) {
						return;
					}
					ElementListSelectionDialog dialog = (ElementListSelectionDialog)data;
					dialog.setInitialSelections(new Object[]{ property });
					dialog.create();
					waitForComplete();
					try {
						Method m1 = AbstractElementListSelectionDialog.class.getDeclaredMethod("setSelection", Object[].class);
						m1.setAccessible(true);
						m1.invoke(dialog, new Object[]{ property });
						waitForComplete();
						Method m2 = AbstractElementListSelectionDialog.class.getDeclaredMethod("handleElementsChanged");
						m2.setAccessible(true);
						m2.invoke(dialog);
					} catch (Exception e) {
					}
					waitForComplete();
					Button okButton = dialog.getOkButton();
					final Event e = new Event();
					e.time = (int)System.currentTimeMillis();
					e.widget = okButton;
					e.display = okButton.getDisplay();
					e.type = SWT.Selection;
					okButton.notifyListeners(SWT.Selection, e);
					dialog.close();
					waitForComplete();
					event.doit = false;
					result.add(dialog);
					shell.getDisplay().syncExec(new Runnable() {

						public void run() {
							shell.dispose();
						}
					});
				}
			}
		});
		getDiagramCommandStack().execute(command);
		waitForComplete();
		//waiting until dialog closed. 
		while(true) {
			if(!result.isEmpty()) {
				result.get(0).close();
				Shell shell = result.get(0).getShell();
				if(shell != null) {
					shell.dispose();
				}
				break;
			}
		}
		//return the created EditPart.
		List<? extends ViewDescriptor> viewDescriptors = createReq.getViewDescriptors();
		for(ViewDescriptor viewDescriptor : viewDescriptors) {
			String semanticHint = viewDescriptor.getSemanticHint();
			if(type instanceof IHintedType) {
				if(!semanticHint.equals(((IHintedType)type).getSemanticHint())) {
					continue;
				}
			}
			Object adapter = viewDescriptor.getAdapter(View.class);
			Object object = lifeline.getViewer().getEditPartRegistry().get(adapter);
			if(object instanceof LifelineEditPart) {
				return (LifelineEditPart)object;
			}
		}
		return null;
	}

	/**
	 * @param lifeline
	 * @param libraryType
	 */
	private void setRepresents(LifelineEditPart editPart, final ConnectableElement represents) {
		Lifeline lifeline = (Lifeline)editPart.resolveSemanticElement();
		EReference feature = UMLPackage.eINSTANCE.getLifeline_Represents();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(lifeline);
		SetRequest request = new SetRequest(editPart.getEditingDomain(), lifeline, feature, represents);
		ICommand createGMFCommand = provider.getEditCommand(request);
		org.eclipse.emf.common.command.AbstractCommand emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		assertTrue(CHANGE_REPRESENTS + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, emfCommand.canExecute() == true);
		getEMFCommandStack().execute(emfCommand);
		waitForComplete();
		if(represents != null) {
			assertTrue(CHANGE_REPRESENTS + TEST_THE_EXECUTION, lifeline.getRepresents().equals(represents));
		}
	}
}
