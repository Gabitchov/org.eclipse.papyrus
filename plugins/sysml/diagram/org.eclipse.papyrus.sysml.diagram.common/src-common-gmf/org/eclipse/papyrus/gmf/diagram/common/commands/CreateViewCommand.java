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
package org.eclipse.papyrus.gmf.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * A replacement for CreateCommand that avoids that takes into account the incorrect
 * generation of ViewProvider by GMFTooling and modifies SemanticAdapter in call to
 * {@link ViewService#provides(Class, org.eclipse.core.runtime.IAdaptable, View, String, int, boolean, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint)}
 * .
 */
public class CreateViewCommand extends CreateCommand {

	/** Constructor */
	public CreateViewCommand(TransactionalEditingDomain editingDomain, ViewDescriptor viewDescriptor, View containerView) {
		super(editingDomain, viewDescriptor, containerView);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {

		// Warning the element adapter can possibly be null (see: https://bugs.eclipse.org/bugs/show_bug.cgi?id=353129)
		if(viewDescriptor.getElementAdapter() == null) {
			return false;
		}

		// Try to adapt the descriptor ElementAdapter in EObject
		EObject element = (EObject)viewDescriptor.getElementAdapter().getAdapter(EObject.class);
		IElementType elementType = (IElementType)viewDescriptor.getElementAdapter().getAdapter(IElementType.class);

		SemanticElementAdapter semanticAdapter = new SemanticElementAdapter(element, elementType);

		// Use the semanticAdapter instead of view descriptor element adapter to avoid the use of provides(ViewForKind) method
		// from ViewProvider which is incorrectly implemented in GMF Tooling generated editors (other editors may have undesired side-effect on each-other).

		return ViewService.getInstance().provides(viewDescriptor.getViewKind(), semanticAdapter, containerView, viewDescriptor.getSemanticHint(), viewDescriptor.getIndex(), viewDescriptor.isPersisted(), viewDescriptor.getPreferencesHint());
	}



}
