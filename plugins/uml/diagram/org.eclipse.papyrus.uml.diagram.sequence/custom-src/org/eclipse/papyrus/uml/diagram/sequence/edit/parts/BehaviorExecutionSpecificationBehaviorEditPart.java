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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.VisibilityComponentEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.diagram.sequence.util.BehaviorDisplayHelper;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Add new Label EditPart for display behavior of an
 * BehaviorExecutionSpecification.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class BehaviorExecutionSpecificationBehaviorEditPart extends
		BorderItemLabelEditPart {

	public static final String BEHAVIOR_TYPE = "BehaviorExecutionSpecification_Behavior";
	static {
		registerSnapBackPosition(BEHAVIOR_TYPE, new Point(16, 16));
	}

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public BehaviorExecutionSpecificationBehaviorEditPart(View view) {
		super(view);
	}

	@Override
	protected EObject getParserElement() {
		EObject parserElement = super.getParserElement();
		if (parserElement instanceof BehaviorExecutionSpecification) {
			return ((BehaviorExecutionSpecification) parserElement)
					.getBehavior();
		}
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BorderItemLabelEditPart#createFigurePrim()
	 * 
	 * @return
	 */

	@Override
	protected IFigure createFigurePrim() {
		WrappingLabel label = new WrappingLabel();
		label.setTextWrap(true);
		return label;
	}

	@Override
	protected boolean isEditable() {
		return false;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BorderItemLabelEditPart#createParser()
	 * 
	 * @return
	 */
	@Override
	protected IParser createParser() {
		return new MessageFormatParser(
				new EAttribute[] { UMLPackage.eINSTANCE.getNamedElement_Name() }) {

			@Override
			public String getPrintString(IAdaptable adapter, int flags) {
				String printString = super.getPrintString(adapter, flags);
				EObject obj = (EObject) adapter.getAdapter(EObject.class);
				if (obj instanceof OpaqueBehavior) {
					OpaqueBehavior opaque = (OpaqueBehavior) obj;
					if (opaque.isSetLanguages()) {
						StringBuffer buf = new StringBuffer();
						buf.append("{");
						EList<String> languages = opaque.getLanguages();
						EList<String> bodies = opaque.getBodies();
						for (int i = 0; i < languages.size(); i++) {
							if (i != 0) {
								buf.append(", ");
							}
							buf.append("{");
							buf.append(languages.get(i));
							buf.append("}");
							if (i < bodies.size()) {
								String body = bodies.get(i);
								if (body != null) {
									buf.append(body);
								}
							}
						}
						buf.append("}");
						return new String(buf);
					}
				}
				return printString;
			}
		};
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicy.COMPONENT_ROLE);
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new VisibilityComponentEditPolicy() {
					@Override
					protected Command createDeleteViewCommand(
							GroupRequest deleteRequest) {
						org.eclipse.emf.common.command.Command cmd = BehaviorDisplayHelper
								.getChangeDisplayBehaviorCommand(
										getEditingDomain(), getPrimaryView(),
										false);
						return new EMFtoGEFCommandWrapper(cmd);
					}
				});
	}
}
