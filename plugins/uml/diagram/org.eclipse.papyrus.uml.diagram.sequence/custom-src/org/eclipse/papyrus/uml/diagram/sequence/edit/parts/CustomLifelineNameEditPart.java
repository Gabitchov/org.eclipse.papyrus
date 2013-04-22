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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomLifelineNameEditPart extends LifelineNameEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomLifelineNameEditPart(View view) {
		super(view);
	}

	@Override
	public void setLabel(WrappingLabel figure) {
		figure.setTextWrap(false); // If the width is too small, the text will be displayed in part and suffixed by "..." 
		super.setLabel(figure);
	}

	/**
	 * @Override
	 */
	private void performDirectEdit(char initialCharacter) {
		if(getManager() instanceof TextDirectEditManager) {
			((TextDirectEditManager)getManager()).show(initialCharacter);
		} else {
			performDirectEdit();
		}
	}

	/**
	 * This methods is no more generated to handle the case of editing the name of a lifeline
	 * with a directEdition when its properties represents and decomposedAs are null
	 * 
	 * @Override
	 */
	@Override
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		Lifeline lifeline = (Lifeline)resolveSemanticElement();
		if(lifeline.getRepresents() != null || lifeline.getDecomposedAs() != null) {
			directEditionMode = IDirectEdition.NO_DIRECT_EDITION;
		}
		if(IDirectEdition.UNDEFINED_DIRECT_EDITOR == directEditionMode) {
			directEditionMode = getDirectEditionType();
		}
		switch(directEditionMode) {
		case IDirectEdition.NO_DIRECT_EDITION:
			// no direct edition mode => does nothing
			return;
		case IDirectEdition.EXTENDED_DIRECT_EDITOR:
			updateExtendedEditorConfiguration();
			if(configuration == null || configuration.getLanguage() == null) {
				performDefaultDirectEditorEdit(theRequest);
			} else {
				configuration.preEditAction(resolveSemanticElement());
				final ExtendedDirectEditionDialog dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), resolveSemanticElement(), configuration.getTextToEdit(resolveSemanticElement()), configuration);
				if(Window.OK == dialog.open()) {
					TransactionalEditingDomain domain = getEditingDomain();
					RecordingCommand command = new RecordingCommand(domain, "Edit Label") {

						@Override
						protected void doExecute() {
							configuration.postEditAction(resolveSemanticElement(), dialog.getValue());
						}
					};
					domain.getCommandStack().execute(command);
				}
			}
			break;
		case IDirectEdition.DEFAULT_DIRECT_EDITOR:
			// initialize the direct edit manager
			try {
				getEditingDomain().runExclusive(new Runnable() {

					public void run() {
						if(isActive() && isEditable()) {
							if(theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
								Character initialChar = (Character)theRequest.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
								performDirectEdit(initialChar.charValue());
							} else if((theRequest instanceof DirectEditRequest) && (getEditText().equals(getLabelText()))) {
								DirectEditRequest editRequest = (DirectEditRequest)theRequest;
								performDirectEdit(editRequest.getLocation());
							} else {
								performDirectEdit();
							}
						}
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	/**
	 * @Override
	 */
	@Override
	protected void refreshLabel() {
		EditPolicy maskLabelPolicy = getParent().getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(maskLabelPolicy == null) {
			setLabelTextHelper(getFigure(), getLabelText());
		}
		setLabelIconHelper(getFigure(), getLabelIcon());
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	/**
	 * @Override (update at each lifeline name modification) handle possible change in the name container size
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		if(getParent() instanceof CustomLifelineEditPart) {
			Object feature = event.getFeature();
			Object notifier = event.getNotifier();
			Lifeline lifeline = (Lifeline)this.resolveSemanticElement();
			// handle possible change in the name container size
			// In AutoSize mode, the width should be resized if the content of the text gets changed. see https://bugs.eclipse.org/bugs/show_bug.cgi?id=383723
			if(notifier.equals(lifeline.getRepresents()) || UMLPackage.Literals.NAMED_ELEMENT__NAME.equals(feature) || UMLPackage.Literals.LIFELINE__REPRESENTS.equals(feature) || UMLPackage.Literals.LIFELINE__DECOMPOSED_AS.equals(feature) || UMLPackage.Literals.LIFELINE__SELECTOR.equals(feature) || event.getNotifier() instanceof Bounds) {
				((CustomLifelineEditPart)getParent()).updateLifelinePosition();
			}
			if(notifier instanceof EAnnotation && ((EAnnotation)notifier).getSource().equals(VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION)) {
				((CustomLifelineEditPart)getParent()).updateLifelinePosition();
			}
		}
		super.handleNotificationEvent(event);
	}

	@Override
	protected Image getLabelIcon() {
		return ElementIconUtil.getLabelIcon(this);
	}
}
