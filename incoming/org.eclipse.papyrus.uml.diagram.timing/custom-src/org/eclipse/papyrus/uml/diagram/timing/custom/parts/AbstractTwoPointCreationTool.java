/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parts;

import java.util.Collections;
import java.util.Map;

import org.eclipse.draw2d.Cursors;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.ui.PlatformUI;

/** This tool allows clicking on a first Node then on a second Node to create some kind of element linked to those Nodes */
public abstract class AbstractTwoPointCreationTool extends AspectUnspecifiedTypeCreationTool {

	/** The tool is in this state after clicking on the start element of the duration */
	private static final int STATE_FIRST = 1 << 16;

	/** A request parameter that indicates the first clicked element */
	public final static String FIRST_TARGET = "FIRST_TARGET"; //$NON-NLS-1$

	/** A request parameter that indicates the second clicked element */
	public final static String SECOND_TARGET = "SECOND_TARGET"; //$NON-NLS-1$

	protected EditPart first = null;

	protected EditPart second = null;

	public AbstractTwoPointCreationTool(final IElementType elementType) {
		super(Collections.singletonList(elementType));
		setDefaultCursor(Cursors.CROSS);
		setDisabledCursor(Cursors.NO);
	}

	@Override
	public void activate() {
		super.activate();
		this.first = null;
		this.second = null;
		started();
	}

	@Override
	public void deactivate() {
		super.deactivate();
		setStatusMessage(null);
	}

	@Override
	protected boolean handleButtonDown(final int button) {
		if(button != 1) {
			setState(STATE_INVALID);
			handleInvalidInput();
		}

		final Command command = getCommand();
		final EditPart targetEditPart = getTargetEditPart();

		if(isInState(STATE_INITIAL) && command.canExecute()) {
			this.first = targetEditPart;
			setState(STATE_FIRST);
			// make it possible to double-click so that the first and second elements are the same
			handleMove();
			firstElementSelected();
		} else if(isInState(STATE_FIRST) && command.canExecute()) {
			this.second = targetEditPart;
			eraseTargetFeedback();
			// update the request and command with the second edit part
			setTargetRequest(createTargetRequest());
			setCurrentCommand(getCommand());
			performCreation(button);
			handleFinished();
			setState(STATE_TERMINAL);
		}
		return true;
	}

	@Override
	protected Request createTargetRequest() {
		final CreateAspectUnspecifiedTypeRequest request = new CreateAspectUnspecifiedTypeRequest(getElementTypes(), getPreferencesHint()) {

			@SuppressWarnings("unchecked")
			@Override
			protected void createRequests() {
				final IElementType elementType = (IElementType)getElementTypes().get(0);
				// set the first and second edit parts on the CreateElementRequest that will be received
				// by the create command
				final CreateElementRequest createElementRequest = new CreateElementRequest(elementType);
				createElementRequest.setParameter(FIRST_TARGET, AbstractTwoPointCreationTool.this.first);
				createElementRequest.setParameter(SECOND_TARGET, AbstractTwoPointCreationTool.this.second);

				final ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(new CreateElementRequestAdapter(createElementRequest), Node.class, getGraphicalHint((IHintedType)elementType), getPreferencesHint());
				final Request request = new CreateViewAndElementRequest(viewDescriptor);
				request.setExtendedData(getExtendedData());
				request.setType(getType());
				this.requests.put(elementType, request);
			}
		};
		@SuppressWarnings("unchecked")
		final Map<Object, Object> extendedData = request.getExtendedData();
		extendedData.put(FIRST_TARGET, this.first);
		extendedData.put(SECOND_TARGET, this.second);
		return request;
	}

	@Override
	protected void updateTargetRequest() {
		final CreateRequest createRequest = getCreateRequest();
		createRequest.setSize(null);
		createRequest.setLocation(getLocation());
		createRequest.setSnapToEnabled(false);
	}

	@Override
	protected boolean handleButtonUp(final int button) {
		return false;
	}

	@Override
	protected boolean handleDrag() {
		return false;
	}

	@Override
	protected boolean handleDragStarted() {
		return false;
	}

	@Override
	protected boolean handleDragInProgress() {
		return false;
	}

	@Override
	protected Command getCommand() {
		final Request request = getTargetRequest();
		final EditPart firstTarget;
		final EditPart secondTarget;
		if(isInState(STATE_INITIAL)) {
			firstTarget = getTargetEditPart();
			secondTarget = null;
		} else {
			firstTarget = this.first;
			secondTarget = getTargetEditPart();
		}

		if(!validateFirstTarget(firstTarget)) {
			return UnexecutableCommand.INSTANCE;
		}

		if(isInState(STATE_INITIAL)) {
			// dummy executable command (to accept a creation in progress)
			return new Command() {

				@Override
				public void execute() {
					throw new IllegalStateException("This dummy command must never be executed"); //$NON-NLS-1$
				}
			};
		}

		if(!validateSecondTarget(firstTarget, secondTarget)) {
			return UnexecutableCommand.INSTANCE;
		}
		return getCommand(firstTarget, secondTarget, request);
	}

	/**
	 * Return the creation command that should be executed after clicking the second node.
	 * 
	 * @param firstTarget
	 *        the first node that was clicked
	 * @param secondTarget
	 *        the second node that was clicked
	 * @param request
	 *        the request for which a creation command should be returned
	 * @return the creation command
	 */
	protected abstract Command getCommand(EditPart firstTarget, EditPart secondTarget, Request request);

	/**
	 * Validate the first selection
	 * 
	 * @param firstTarget
	 *        the first selected element
	 * @return whether the first selected element is valid
	 */
	protected abstract boolean validateFirstTarget(final EditPart firstTarget);

	/**
	 * Validate the second selection
	 * 
	 * @param firstTarget
	 *        the first selected element
	 * @param secondTarget
	 *        the second selected element
	 * @return whether the second selected element is valid
	 */
	protected abstract boolean validateSecondTarget(final EditPart firstTarget, final EditPart secondTarget);

	/** Called when the tool is activated */
	protected abstract void started();

	/** Called after the first element was selected */
	protected abstract void firstElementSelected();

	/**
	 * Set a help message in the status bar.
	 * 
	 * @param message
	 *        a message that should help the user using the tool
	 */
	protected static void setStatusMessage(final String message) {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite().getActionBars().getStatusLineManager().setMessage(message);
	}

	/** Does the View for the first EditPart appear before the View for the second EditPart in their container? */
	protected static boolean ordered(final EditPart first, final EditPart second) {
		if(!(first.getModel() instanceof View) || !(second.getModel() instanceof View)) {
			return false;
		}
		final View firstView = (View)first.getModel();
		final View secondView = (View)second.getModel();
		if(firstView.eContainer() != secondView.eContainer()) {
			return false;
		}
		final View compartment = (View)firstView.eContainer();
		final int firstIndex = compartment.getChildren().indexOf(firstView);
		final int secondIndex = compartment.getChildren().indexOf(secondView);
		return firstIndex <= secondIndex;
	}
}
