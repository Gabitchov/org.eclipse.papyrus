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
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * this is a label helper to display the label of an association end
 * 
 */
public abstract class AbstractAssociationEndEditPart extends LabelEditPart {

	public AbstractAssociationEndEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		super.activate();
		addAssociationEndListeners();
	}

	/**
	 * add association ends listeners
	 */
	protected void addAssociationEndListeners() {
		EObject sourceEnd = ((Association) resolveSemanticElement()).getMemberEnds().get(0);
		EObject targetEnd = ((Association) resolveSemanticElement()).getMemberEnds().get(1);
		addListenerFilter("AssociationEndListenersSource", this, sourceEnd); //$NON-NLS-1$
		addListenerFilter("AssociationEndListenersTarget", this, targetEnd); //$NON-NLS-1$
		addListenerFilter("AssociationEndListenersSourceMultUpper", this, ((Property) sourceEnd).getUpperValue());
		addListenerFilter("AssociationEndListenersTargetMultUpper", this, ((Property) targetEnd).getUpperValue()); //$NON-NLS-1$
		addListenerFilter("AssociationEndListenersSourceMultLower", this, ((Property) sourceEnd).getLowerValue());
		addListenerFilter("AssociationEndListenersTargetMultLower", this, ((Property) targetEnd).getLowerValue()); //$NON-NLS-1$
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void addSemanticListeners() {
		if (getParser() instanceof ISemanticParser) {
			EObject element = ((Association) resolveSemanticElement()).getMemberEnds().get(0);
			List<?> parserElements = ((ISemanticParser) getParser()).getSemanticElementsBeingParsed(element);
			for (int i = 0; i < parserElements.size(); i++) {
				addListenerFilter("SemanticModel" + i, this, (EObject) parserElements.get(i)); //$NON-NLS-1$
			}
		} else {
			super.addSemanticListeners();
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		removeAssociationEndListeners();
		super.deactivate();
	}

	public abstract IParser getParser();

	/**
	 * used to remove listeners
	 */
	protected void removeAssociationEndListeners() {
		removeListenerFilter("AssociationEndListenersSource");
		removeListenerFilter("AssociationEndListenersTarget");
	}
}
