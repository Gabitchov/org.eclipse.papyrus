/*****************************************************************************
 * Copyright (c) 2010 CEA
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

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class AbstractNodeTest extends TestTopNode {

	private static final String RESIZE = "Resize: ";

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase#getDiagramCommandCreation()
	 * 
	 * @return
	 */
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode#setUp()
	 * 
	 * @throws Exception
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Runnable runnable = new Runnable() {

			public void run() {
				try {
					//Max shell
					IWorkbench workbench = PlatformUI.getWorkbench();
					workbench.getActiveWorkbenchWindow().getShell().setMaximized(true);
					//close intro
					IIntroManager introManager = workbench.getIntroManager();
					IIntroPart intro = introManager.getIntro();
					if(intro != null) {
						introManager.closeIntro(intro);
					}
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		};
		Display.getDefault().syncExec(runnable);
	}

	protected EditPart createNode(IElementType type, EditPartViewer viewer, Point location, Dimension size) {
		assertNotNull(type);
		assertNotNull(viewer);
		assertNotNull(location);
		CreateViewRequest createReq = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		createReq.setLocation(location);
		createReq.setSize(size);
		EditPart parentEditPart = viewer.findObjectAtExcluding(location, Collections.emptySet(), getTargetingConditional(createReq));
		assertNotNull("Could not create " + type + " at " + location, parentEditPart);
		EditPart targetEditPart = parentEditPart.getTargetEditPart(createReq);
		assertNotNull("Could not create " + type + " at " + location, targetEditPart);
		return createNode(type, targetEditPart, location, size);
	}

	protected EditPart createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		//CREATION
		CreateViewRequest createReq = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		createReq.setLocation(location);
		createReq.setSize(size);
		Command command = parentPart.getCommand(createReq);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);
		waitForComplete();
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
			Object object = parentPart.getViewer().getEditPartRegistry().get(adapter);
			if(object instanceof EditPart) {
				return (EditPart)object;
			}
		}
		return null;
	}

	protected void resize(IGraphicalEditPart editPart, Point location, int resizeDirection, Dimension sizeDelta) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(location);
		req.setEditParts(editPart);
		req.setResizeDirection(resizeDirection);
		req.setSizeDelta(sizeDelta);
		if(resizeDirection == PositionConstants.NORTH || resizeDirection == PositionConstants.WEST) {
			req.setMoveDelta(new Point(-sizeDelta.width(), -sizeDelta.height()));
		}
		Command c = editPart.getCommand(req);
		manageResizeCommnad(editPart, sizeDelta, c);
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

	protected Command createSetCommand(TransactionalEditingDomain editingDomain, EObject eObject, EStructuralFeature feature, Object value) {
		if(editingDomain == null || eObject == null || feature == null) {
			return null;
		}
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eObject);
		SetRequest request = new SetRequest(editingDomain, eObject, feature, value);
		ICommand editCommand = provider.getEditCommand(request);
		if(editCommand == null) {
			return null;
		}
		return new ICommandProxy(editCommand);
	}

	protected void updateValue(TransactionalEditingDomain editingDomain, EObject eObject, EStructuralFeature feature, Object value) {
		Command setCommand = createSetCommand(editingDomain, eObject, feature, value);
		assertNotNull("Update Value: ", setCommand);
		assertTrue("Executable to set value:", setCommand.canExecute());
		getDiagramCommandStack().execute(setCommand);
		waitForComplete();
		assertEquals(value, eObject.eGet(feature));
	}

	protected void changeName(TransactionalEditingDomain editingDomain, NamedElement element, final String newName) {
		Command command = createSetCommand(editingDomain, element, UMLPackage.Literals.NAMED_ELEMENT__NAME, newName);
		assertNotNull(COMMAND_NULL, command);
		assertTrue(command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
	}

	protected EditPart createLink(IElementType elementType, EditPartViewer currentViewer, Point startLocation, Point endLocation) {
		assertNotNull("IElementType is null: ", elementType);
		assertNotNull("EditPartViewer is null: ", currentViewer);
		assertNotNull("Start Location is null: ", startLocation);
		assertNotNull("End Location is null: ", endLocation);
		CreateConnectionViewRequest request = CreateViewRequestFactory.getCreateConnectionRequest(elementType, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		request.setLocation(startLocation);
		request.setType(RequestConstants.REQ_CONNECTION_START);
		EditPart sourceEditPart = currentViewer.findObjectAtExcluding(startLocation, Collections.emptySet(), getTargetingConditional(request));
		request.setTargetEditPart(sourceEditPart);
		request.setSourceEditPart(sourceEditPart);
		sourceEditPart.getCommand(request);
		request.setLocation(endLocation);
		request.setType(RequestConstants.REQ_CONNECTION_END);
		EditPart targetEditPart = currentViewer.findObjectAtExcluding(endLocation, Collections.emptySet(), getTargetingConditional(request));;
		return createLink(elementType, currentViewer, startLocation, sourceEditPart, endLocation, targetEditPart);
	}

	protected EditPart createLink(IElementType elementType, EditPartViewer currentViewer, Point startLocation, EditPart sourceEditPart, Point endLocation, EditPart targetEditPart) {
		assertNotNull("IElementType is null: ", elementType);
		assertNotNull("EditPartViewer is null: ", currentViewer);
		assertNotNull("Start Location is null: ", startLocation);
		assertNotNull("End Location is null: ", endLocation);
		assertNotNull("SourceEditPart is null: ", sourceEditPart);
		assertNotNull("TargetEditPart is null: ", targetEditPart);
		CreateConnectionViewRequest request = CreateViewRequestFactory.getCreateConnectionRequest(elementType, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		assertNotNull("Can not create link with " + elementType, request);
		request.setLocation(startLocation);
		request.setType(RequestConstants.REQ_CONNECTION_START);
		//		sourceEditPart = currentViewer.findObjectAtExcluding(startLocation, Collections.emptySet(), getTargetingConditional(request));
		assertNotNull("Can not find connecting source at " + startLocation, sourceEditPart);
		request.setSourceEditPart(sourceEditPart);
		request.setTargetEditPart(sourceEditPart);
		request.getExtendedData().put(SequenceRequestConstant.SOURCE_MODEL_CONTAINER, SequenceUtil.findInteractionFragmentContainerAt(startLocation, sourceEditPart));
		Command command = null;
		if(UMLElementTypes.GeneralOrdering_4012 == elementType) {
			LifelineEditPart lifelinePart = sourceEditPart instanceof ConnectionEditPart ? SequenceUtil.getParentLifelinePart(((ConnectionEditPart)sourceEditPart).getSource()) : SequenceUtil.getParentLifelinePart(sourceEditPart);
			assertNotNull(lifelinePart);
			Entry<Point, List<OccurrenceSpecification>> eventAndLocation = SequenceUtil.findNearestEvent(request.getLocation(), lifelinePart);
			// find an event near enough to create the constraint or observation
			List<OccurrenceSpecification> events = Collections.emptyList();
			Point location = null;
			if(eventAndLocation != null) {
				location = eventAndLocation.getKey();
				events = eventAndLocation.getValue();
			}
			request.getExtendedData().put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION, events);
			request.getExtendedData().put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION, location);
			if(location != null) {
				request.setLocation(location);
			}
			request.setSourceEditPart(lifelinePart);
			request.setTargetEditPart(lifelinePart);
			command = lifelinePart.getCommand(request);
		} else {
			sourceEditPart.showTargetFeedback(request);
			command = sourceEditPart.getCommand(request);
			sourceEditPart.eraseSourceFeedback(request);
		}
		assertNotNull(COMMAND_NULL, command);
		//connect...
		request.setLocation(endLocation);
		request.setType(RequestConstants.REQ_CONNECTION_END);
		//		targetEditPart = currentViewer.findObjectAtExcluding(endLocation, Collections.emptySet(), getTargetingConditional(request));
		assertNotNull("Can not find connecting end at " + endLocation, targetEditPart);
		request.setTargetEditPart(targetEditPart);
		request.getExtendedData().put(SequenceRequestConstant.TARGET_MODEL_CONTAINER, SequenceUtil.findInteractionFragmentContainerAt(endLocation, targetEditPart));
		if(UMLElementTypes.GeneralOrdering_4012 == elementType) {
			LifelineEditPart lifelinePart = targetEditPart instanceof ConnectionEditPart ? SequenceUtil.getParentLifelinePart(((ConnectionEditPart)targetEditPart).getTarget()) : SequenceUtil.getParentLifelinePart(targetEditPart);
			assertNotNull(lifelinePart);
			Entry<Point, List<OccurrenceSpecification>> eventAndLocation = SequenceUtil.findNearestEvent(request.getLocation(), lifelinePart);
			// find an event near enough to create the constraint or observation
			List<OccurrenceSpecification> events = Collections.emptyList();
			Point location = null;
			if(eventAndLocation != null) {
				location = eventAndLocation.getKey();
				events = eventAndLocation.getValue();
			}
			request.getExtendedData().put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2, events);
			request.getExtendedData().put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2, location);
			if(location != null) {
				request.setLocation(location);
			}
			request.setTargetEditPart(lifelinePart);
			command = lifelinePart.getCommand(request);
		} else {
			targetEditPart.showTargetFeedback(request);
			command = targetEditPart.getCommand(request);
			targetEditPart.eraseSourceFeedback(request);
		}
		assertNotNull(COMMAND_NULL, command);
		assertTrue("Executable of connection command", command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
		//check result
		View view = (View)request.getConnectionViewDescriptor().getAdapter(View.class);
		assertNotNull("view not found", view);
		return (EditPart)currentViewer.getEditPartRegistry().get(view);
	}

	protected EditPartViewer.Conditional getTargetingConditional(final Request req) {
		return new EditPartViewer.Conditional() {

			public boolean evaluate(EditPart editpart) {
				return editpart.getTargetEditPart(req) != null;
			}
		};
	}

	protected void reconnectSource(ConnectionEditPart conn, EditPart newSource, Point newSourceLocation) {
		assertNotNull("reconnect connection", conn);
		assertNotNull("reconnect source", newSource);
		ReconnectRequest request = new ReconnectRequest(RequestConstants.REQ_RECONNECT_SOURCE) {

			@Override
			public boolean isMovingStartAnchor() {
				return true;
			}
		};
		request.setConnectionEditPart(conn);
		request.setTargetEditPart(newSource);
		request.setLocation(newSourceLocation);
		Command command = newSource.getCommand(request);
		assertNotNull("reconnect command", command);
		assertTrue("reconnect command executable", command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
	}

	protected void reconnectTarget(ConnectionEditPart conn, EditPart newTarget, Point newTargetLocation) {
		assertNotNull("reconnect connection", conn);
		assertNotNull("reconnect source", newTarget);
		ReconnectRequest request = new ReconnectRequest(RequestConstants.REQ_RECONNECT_TARGET) {

			@Override
			public boolean isMovingStartAnchor() {
				return false;
			}
		};
		request.setConnectionEditPart(conn);
		request.setTargetEditPart(newTarget);
		request.setLocation(newTargetLocation);
		newTarget.showSourceFeedback(request);
		newTarget.showTargetFeedback(request);
		Command command = newTarget.getCommand(request);
		newTarget.eraseSourceFeedback(request);
		newTarget.eraseTargetFeedback(request);
		assertNotNull("reconnect command", command);
		assertTrue("reconnect command executable", command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
	}
}
