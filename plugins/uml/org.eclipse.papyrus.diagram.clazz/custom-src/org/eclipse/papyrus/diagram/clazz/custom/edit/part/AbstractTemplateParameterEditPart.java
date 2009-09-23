package org.eclipse.papyrus.diagram.clazz.custom.edit.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.uml2.uml.TemplateParameter;

public class AbstractTemplateParameterEditPart extends CompartmentEditPart {

	protected static final String LISTEN_OWNED_PARAM = "ListenOwnedParam";

	public AbstractTemplateParameterEditPart(EObject model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		super.activate();
		addOwnedParamListeners();
	}

	/**
	 * to listen parameters
	 */
	protected void addOwnedParamListeners() {
		EObject ownedParam = ((TemplateParameter) resolveSemanticElement()).getOwnedParameteredElement();
		if (ownedParam != null) {
			addListenerFilter(LISTEN_OWNED_PARAM, this, ownedParam);
		}
	}

	/**
	 *{@inheritDoc}
	 */

	public void deactivate() {
		removeOwnedParamListeners();
		super.deactivate();
	}

	/**
	 * to stop listening parameters
	 */
	protected void removeOwnedParamListeners() {
		removeListenerFilter(LISTEN_OWNED_PARAM);
	}
}
