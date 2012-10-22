/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.debug.Debug;

public class FlowFinalNodeActivation extends ControlNodeActivation {

	public void fire(List<Token> incomingTokens) {
		// Consume all incoming tokens.
		Debug.println("[fire] Flow final node " + this.node.getName() + "...");
		for(int i = 0; i < incomingTokens.size(); i++) {
			Token token = incomingTokens.get(i);
			token.withdraw();
		}
	}
}
