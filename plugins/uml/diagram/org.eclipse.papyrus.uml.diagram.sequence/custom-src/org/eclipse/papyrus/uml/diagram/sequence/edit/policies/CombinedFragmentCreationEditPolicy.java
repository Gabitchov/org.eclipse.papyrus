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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Set;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.OperandBoundsComputeHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.InteractionFragment;

/**
 * This creation policy is used to move covered interaction fragments into the interaction operand
 * when creating a new combined fragment.
 * 
 * @author mvelten
 * 
 */
public class CombinedFragmentCreationEditPolicy extends CreationEditPolicy {

	@SuppressWarnings("unchecked")
	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		Command createElementAndViewCmd = super.getCreateElementAndViewCommand(request);
		if(isDerivedCombinedFragment(request.getViewAndElementDescriptor().getSemanticHint())) {
			Rectangle selectionRect = getSelectionRectangle(request);
			Set<InteractionFragment> coveredInteractionFragments = SequenceUtil.getCoveredInteractionFragments(selectionRect, getHost(), null);
			request.getExtendedData().put(SequenceRequestConstant.COVERED_INTERACTIONFRAGMENTS, coveredInteractionFragments);
			// Add updating bounds command for Combined fragment createment
			String hint = request.getViewAndElementDescriptor().getSemanticHint();
			if(OperandBoundsComputeHelper.isDerivedCombinedFragment(hint)) {
				if(createElementAndViewCmd instanceof ICommandProxy) {
					ICommandProxy commandProxy = (ICommandProxy)createElementAndViewCmd;
					ICommand realCmd = commandProxy.getICommand();
					if(realCmd instanceof CompositeCommand) {
						ICommand createUpdateBoundsCmd = OperandBoundsComputeHelper.createUpdateCFAndIOBoundsForCFCreationCommand(this.getHost(), request);
						if(createUpdateBoundsCmd != null)
							((CompositeCommand)realCmd).add(createUpdateBoundsCmd);
					}
				}
			}
		}
		return createElementAndViewCmd;
	}

	@Override
	protected Command getCreateCommand(CreateViewRequest request) {
		Command createViewCmd = super.getCreateCommand(request);
		if(createViewCmd instanceof ICommandProxy) {
			ICommandProxy commandProxy = (ICommandProxy)createViewCmd;
			CompositeCommand compositeCommand = null;
			ICommand realCmd = commandProxy.getICommand();
			if(realCmd instanceof CompositeCommand) {
				compositeCommand = (CompositeCommand)realCmd;
			} else {
				compositeCommand = new CompositeCommand(commandProxy.getLabel());
				compositeCommand.add(realCmd);
				realCmd = compositeCommand;
			}
			for(ViewDescriptor viewDescriptor : request.getViewDescriptors()) {
				String hint = viewDescriptor.getSemanticHint();
				if(isDerivedCombinedFragment(hint)) {
					// Add updating bounds command for Combined fragment createment
					if(OperandBoundsComputeHelper.isDerivedCombinedFragment(hint)) {
						ICommand createUpdateBoundsCmd = OperandBoundsComputeHelper.createUpdateCFAndIOBoundsForCFCreationCommand(this.getHost(), request);
						if(createUpdateBoundsCmd != null)
							((CompositeCommand)realCmd).add(createUpdateBoundsCmd);
					}
				}
			}
			createViewCmd = new ICommandProxy(compositeCommand.reduce());
		}
		return createViewCmd;
	}

	/**
	 * Retrieve the selection rectangle associated with the request.
	 * 
	 * @param request
	 *        the request
	 * @return
	 */
	private Rectangle getSelectionRectangle(CreateViewAndElementRequest request) {
		Rectangle selectionRect = new Rectangle();
		Point location = request.getLocation();
		Dimension size = request.getSize();
		if(location != null) {
			selectionRect.x = location.x;
			selectionRect.y = location.y;
		} else {
			// default values (should not be triggered)
			selectionRect.x = 100;
			selectionRect.y = 100;
		}
		if(size != null) {
			selectionRect.height = size.height;
			selectionRect.width = size.width;
		} else {
			// default values hardcoded...
			selectionRect.height = 61;
			selectionRect.width = 112;
		}
		return selectionRect;
	}

	/**
	 * Check if it is a combined fragment or something similar which needs this policy to move ift in the correct container.
	 * 
	 * @param hint
	 *        the semantic hint
	 * @return
	 */
	private static boolean isDerivedCombinedFragment(String hint) {
		if(((IHintedType)UMLElementTypes.InteractionOperand_3005).getSemanticHint().equals(hint)) {
			return true;
		}
		if(((IHintedType)UMLElementTypes.CombinedFragment_3004).getSemanticHint().equals(hint)) {
			return true;
		}
		if(((IHintedType)UMLElementTypes.ConsiderIgnoreFragment_3007).getSemanticHint().equals(hint)) {
			return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		//Fixed bugs about creating Gates on clientArea of CombinedFragment. Whatever the host is InteractionOperand or Compartment, just use CombinedFragment.
		if(isCreatingGate(request)) {
			return getCombinedFragmentEditPart();
		}
		return super.getTargetEditPart(request);
	}

	private EditPart getCombinedFragmentEditPart() {
		EditPart editPart = getHost();
		while(editPart != null) {
			if(editPart instanceof CombinedFragmentEditPart) {
				return editPart;
			}
			editPart = editPart.getParent();
		}
		return null;
	}

	private boolean isCreatingGate(Request request) {
		if(!(request instanceof CreateRequest)) {
			return false;
		}
		CreateRequest createReq = (CreateRequest)request;
		try {
			Object newObjectType = createReq.getNewObjectType();
			return GateEditPart.GATE_TYPE.equals(newObjectType);
		} catch (Exception e) {
			//There's no CreationFactory set.
			return false;
		}
	}
}
