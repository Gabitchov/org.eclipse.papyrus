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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.part.ITextAwareEditPart;
import org.eclipse.papyrus.gmf.diagram.common.parser.IMaskManagedSemanticParser;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.MaskLabelHelper;


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
	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>();

		IParser parser = getHostLabelEditPart().getParser();
		if(parser instanceof IMaskManagedSemanticParser) {
			masks = ((IMaskManagedSemanticParser)parser).getMasks();
		}

		return masks;
	}

	/**
	 * {@inheritDoc}
	 */
	public Collection<String> getCurrentDisplayValue() {
		Collection<String> result = MaskLabelHelper.getMaskValues(getView());
		if(result == null) {
			IParser parser = getHostLabelEditPart().getParser();
			if(parser instanceof IMaskManagedSemanticParser) {
				result = ((IMaskManagedSemanticParser)parser).getDefaultValue(getHost());
			}
		}

		if(result == null) {
			return Collections.emptySet();
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateDisplayValue(Collection<String> maskValues) {
		MaskLabelHelper.setMaskValues(getView(), maskValues);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDefaultDisplayValue() {
		MaskLabelHelper.unsetMaskValues(getView());
	}

	// @unused.
	public void refreshDisplay() {
		// Not implemented.
	}

	/**
	 * Get the host label edit part (has to implement {@link ITextAwareEditPart}).
	 * 
	 * @return the host label edit part.
	 */
	private ITextAwareEditPart getHostLabelEditPart() {
		return (ITextAwareEditPart)getHost();
	}

	private View getView() {
		return (View)getHost().getModel();
	}
}
