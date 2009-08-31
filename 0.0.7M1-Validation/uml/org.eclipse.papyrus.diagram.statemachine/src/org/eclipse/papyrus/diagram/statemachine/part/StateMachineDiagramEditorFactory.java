/*******************************************************************************
 * Copyright (c) 2009
 * Conselleria de Infraestructuras y Transporte, Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *	  Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 ******************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.part;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;

/**
 * Editor factory for Papyrus MultiEditor.
 * 
 * @author fjcano
 *
 */
public class StateMachineDiagramEditorFactory extends GmfEditorFactory {

	public StateMachineDiagramEditorFactory() {
		super(UMLStateMachineDiagramForMultiEditor.class,
				StateMachineEditPart.MODEL_ID);
	}

}
