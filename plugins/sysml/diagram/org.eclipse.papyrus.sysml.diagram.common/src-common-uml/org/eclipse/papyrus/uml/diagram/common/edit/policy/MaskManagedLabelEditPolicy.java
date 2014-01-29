/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.edit.policy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.gmf.diagram.common.edit.part.ITextAwareEditPart;
import org.eclipse.papyrus.gmf.diagram.common.parser.IMaskManagedSemanticParser;
import org.eclipse.papyrus.infra.emf.appearance.commands.AddMaskManagedLabelDisplayCommand;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.emf.commands.RemoveEAnnotationCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;


/**
 * <pre>
 * Generic mask manage edit policy for {@link ITextAwareEditPart}, managed masks are assumed to be given by the
 * {@link ITextAwareEditPart} parser (must implement {@link IMaskManagedSemanticParser}).
 * </pre>
 */
public class MaskManagedLabelEditPolicy extends GraphicalEditPolicy implements IMaskManagedLabelEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	public Map<Integer, String> getMasks() {
		Map<Integer, String> masks = new HashMap<Integer, String>();

		IParser parser = getHostLabelEditPart().getParser();
		if(parser instanceof IMaskManagedSemanticParser) {
			masks = ((IMaskManagedSemanticParser)parser).getMasks();
		}

		return masks;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getCurrentDisplayValue() {
		return getHostLabelEditPart().getParserOptions().intValue();
	}

	/**
	 * {@inheritDoc}
	 */
	public int getDefaultDisplayValue() {
		return getHostLabelEditPart().getDefaultParserOptions().intValue();
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateDisplayValue(int newValue) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute(new AddMaskManagedLabelDisplayCommand(editingDomain, (EModelElement)getHost().getModel(), newValue));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDefaultDisplayValue() {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(editingDomain != null) {
			editingDomain.getCommandStack().execute(new RemoveEAnnotationCommand(editingDomain, (EModelElement)getHost().getModel(), VisualInformationPapyrusConstants.CUSTOM_APPEARENCE_ANNOTATION));
		}
	}

	// @unused.
	public String getMaskLabel(int value) {
		// Not implemented.
		return null;
	}

	// @unused.
	public Collection<String> getMaskLabels() {
		// Not implemented.
		return null;
	}

	// @unused.
	public Collection<Integer> getMaskValues() {
		// Not implemented.
		return null;
	}

	// @unused.
	public void refreshDisplay() {
		// Not implemented.
	}

	// @unused.
	public String getPreferencePageID() {
		// Not implemented.
		return null;
	}

	/**
	 * Get the host label edit part (has to implement {@link ITextAwareEditPart}).
	 *
	 * @return the host label edit part.
	 */
	private ITextAwareEditPart getHostLabelEditPart() {
		return (ITextAwareEditPart)getHost();
	}
}
