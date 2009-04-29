/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – initial API and
 * implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * Command that adds an EAnnotation to the EditPart's Node in order to know
 * which styles have been changed by the user (in respect of the default style).
 * The EAttributes stored within the EAnnotation are taken into account when the
 * EditPart's figure is refreshed.
 * 
 * @author gmerin
 * 
 */
public class AnnotateNodeStyleCommand extends
		AbstractCommonTransactionalCommmand {

	// The command's text label
	public static final String COMMAND_LABEL = "Annotate Node Style Changes";

	// The EAnnotations name where the style changes will be stored
	public static final String APPEARANCE_EANNOTATION_NAME = "es.cv.gvcase.mdt.common.gmfextension.appearance";

	// The Node's EditPart that will be modified
	private IGraphicalEditPart editPart;

	// The EAttribute that represents the Node's style being modified
	private EAttribute eAttribute;

	/**
	 * Constructor.
	 * 
	 * @param ep
	 *            The EditPart whose Node is being modified
	 * @param attr
	 *            The Node's attribute that is being changed (the style)
	 * @param domain
	 *            The Editing domain
	 * @param affectedFiles
	 *            List of affected files. It may be null.
	 */
	public AnnotateNodeStyleCommand(IGraphicalEditPart ep, EAttribute attr,
			TransactionalEditingDomain domain, List affectedFiles) {
		this(ep, attr, domain, COMMAND_LABEL, affectedFiles);
	}

	/**
	 * Constructor.
	 * 
	 * @param ep
	 *            The EditPart whose Node is being modified
	 * @param attr
	 *            The Node's attribute that is being changed (the style)
	 * @param domain
	 *            The Editing domain
	 * @param label
	 *            The command's label
	 * @param affectedFiles
	 *            List of affected files. It may be null.
	 */
	public AnnotateNodeStyleCommand(IGraphicalEditPart ep, EAttribute attr,
			TransactionalEditingDomain domain, String commandLabel,
			List affectedFiles) {
		super(domain, commandLabel, affectedFiles);
		setEAttribute(attr);
		setEditPart(ep);
	}

	/**
	 * Execution of the command
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		addChangesToAppearenceEAnnotation(getEAttribute());
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Returns the EAnnotation that stores the changed styles
	 * 
	 * @return EAnnotation
	 */
	protected EAnnotation getAppearenceEAnnotation() {
		EAnnotation eAnn = getEditPart().getPrimaryView().getEAnnotation(
				APPEARANCE_EANNOTATION_NAME);
		return eAnn;
	}

	/**
	 * Creates the EAnnotation that stores the changed styles
	 * 
	 * @return
	 */
	protected EAnnotation createAppearenceEAnnotation() {
		EAnnotation eAnn = EcoreFactory.eINSTANCE.createEAnnotation();
		eAnn.setSource(APPEARANCE_EANNOTATION_NAME);
		getEditPart().getPrimaryView().getEAnnotations().add(eAnn);
		return eAnn;
	}

	/**
	 * Adds the new style change to the EAnnotation that stores the changed
	 * styles
	 * 
	 * @param attribute
	 */
	protected void addChangesToAppearenceEAnnotation(EAttribute attribute) {
		// Get the EAnnotation
		EAnnotation eAnn = getAppearenceEAnnotation();

		// If there is no EAnnotation, create it
		if (eAnn == null) {
			eAnn = createAppearenceEAnnotation();
		}

		// If change is already added, don't continue
		if (eAnn.getReferences().contains(attribute))
			return;

		// Background
		if (NotationPackage.eINSTANCE.getFillStyle_FillColor()
				.equals(attribute)) {
			eAnn.getReferences().add(
					NotationPackage.Literals.FILL_STYLE__FILL_COLOR);
		}

		// Foreground
		if (NotationPackage.eINSTANCE.getLineStyle_LineColor()
				.equals(attribute)) {
			eAnn.getReferences().add(
					NotationPackage.Literals.LINE_STYLE__LINE_COLOR);
		}

		// Font
		if (NotationPackage.eINSTANCE.getFontStyle_FontName().equals(attribute)) {
			eAnn.getReferences().add(
					NotationPackage.Literals.FONT_STYLE__FONT_NAME);
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(
				attribute)) {
			eAnn.getReferences().add(
					NotationPackage.Literals.FONT_STYLE__FONT_COLOR);
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(
				attribute)) {
			eAnn.getReferences().add(
					NotationPackage.Literals.FONT_STYLE__FONT_HEIGHT);
		} else if (NotationPackage.eINSTANCE.getFontStyle_Bold().equals(
				attribute)) {
			eAnn.getReferences().add(NotationPackage.Literals.FONT_STYLE__BOLD);
		} else if (NotationPackage.eINSTANCE.getFontStyle_Italic().equals(
				attribute)) {
			eAnn.getReferences().add(
					NotationPackage.Literals.FONT_STYLE__ITALIC);
		}
	}

	/**
	 * Returns the EditPart being edited by this command
	 * 
	 * @return editPart
	 */
	public IGraphicalEditPart getEditPart() {
		return editPart;
	}

	/**
	 * Returns the Node's EAttribute that is being modified
	 * 
	 * @return EAttribute
	 */
	public EAttribute getEAttribute() {
		return eAttribute;
	}

	/**
	 * Sets a new value for the EAttribute property
	 * 
	 * @param attribute
	 */
	public void setEAttribute(EAttribute attribute) {
		eAttribute = attribute;
	}

	/**
	 * Sets a new value for the EditPart that is being modified
	 * 
	 * @param editPart
	 */
	public void setEditPart(IGraphicalEditPart editPart) {
		this.editPart = editPart;
	}

}
