/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.ids;

import java.util.ArrayList;
import java.util.List;

/**
 * Groups all UML Diagram Editors' IDs.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @deprecated 
 */
public class UMLDiagramEditorIDs {

	/** Model IDs. */
	public static final String ClazzModelID = "MOSKitt UMLClass";

	/** The Constant ActivityModelID. */
	public static final String ActivityModelID = "MOSKitt UMLActivity";

	/** The Constant UseCaseModelID. */
	public static final String UseCaseModelID = "MOSKitt UMLUseCase";

	/** The Constant StateMachineModelID. */
	public static final String StateMachineModelID = "MOSKitt UMLStateMachine";

	/** The Constant SequenceModelID. */
	public static final String SequenceModelID = "MOSKitt UMLSequence";

	/** The Constant ProfileModelID. */
	public static final String ProfileModelID = "MOSKitt UMLProfile";

	/** The all model i ds. */
	private static List<String> allModelIDs = null;

	/**
	 * Gets the all model i ds.
	 * 
	 * @return the all model i ds
	 */
	public static List<String> getAllModelIDs() {
		if (allModelIDs == null) {
			allModelIDs = new ArrayList<String>();
			allModelIDs.add(ClazzModelID);
			allModelIDs.add(ActivityModelID);
			allModelIDs.add(UseCaseModelID);
			allModelIDs.add(StateMachineModelID);
			allModelIDs.add(SequenceModelID);
		}
		return allModelIDs;
	}

}
