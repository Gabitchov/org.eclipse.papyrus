/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.edit.policies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.usecase.command.CreateExtensionPointCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Extend;

/**
 * The custom policy CreateExtensionPointEditPolicy thats create an extension point with extend creation
 */
public class CreateExtensionPointEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.
	 *      CreateConnectionRequest)
	 */
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		Command command = super.getConnectionCompleteCommand(request);
		if(request instanceof CreateConnectionViewRequest) {
			if(getExtendHint().equals(((CreateConnectionViewRequest)request).getConnectionViewDescriptor().getSemanticHint())) {
				if(command != null && command.canExecute()) {
					CompoundCommand compound = new CompoundCommand();
					compound.add(command);
					INodeEditPart targetEP = getConnectionCompleteEditPart(request);
					if(targetEP instanceof AbstractEditPart) {
						IAdaptable adapter = getExtendViewAdapter(request);
						EObject usecase = ViewUtil.resolveSemanticElement((View)getHost().getModel());
						CreateExtensionPointCommand createExtensionPointCommand = new CreateExtensionPointCommand((IHintedType)UMLElementTypes.ExtensionPoint_3007, (AbstractEditPart)targetEP, usecase, adapter, DiagramUtils.getDiagramFrom(getHost()));
						compound.add(createExtensionPointCommand);
						return compound;
					}
				}
			}
		}
		return command;
	}

	/**
	 * Get the adapter to recover the extend element
	 * 
	 * @param request
	 *        the request
	 * @return the extend element
	 */
	private IAdaptable getExtendViewAdapter(final CreateConnectionRequest request) {
		return new IAdaptable() {

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Object getAdapter(Class adapter) {
				if(adapter != null && adapter.isAssignableFrom(Extend.class)) {
					Object view = getViewAdapter().getAdapter(Edge.class);
					if(view instanceof Edge) {
						EObject element = ((Edge)view).getElement();
						if(element instanceof Extend) {
							return element;
						}
					}
				}
				return null;
			}
		};
	}

	/**
	 * Get the semantic hint for an extend element
	 * 
	 * @return semantic hint
	 */
	private static String getExtendHint() {
		IHintedType extend = (IHintedType)UMLElementTypes.Extend_4009;
		return extend.getSemanticHint();
	}
}
