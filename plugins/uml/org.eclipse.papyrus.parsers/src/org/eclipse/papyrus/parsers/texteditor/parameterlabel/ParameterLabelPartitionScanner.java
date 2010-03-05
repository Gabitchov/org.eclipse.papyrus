/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * Scanner that splits document into several parts<BR>
 * Two different rules at this time :
 * <ul>
 * <li>RTACTION_STRING</li>
 * <li>Multi line comment</li>
 * </ul>
 * .
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.rules.RuleBasedPartitionScanner
 */
public class ParameterLabelPartitionScanner extends RuleBasedPartitionScanner {

	/**
	 * 
	 */
	public static final String PARAMETER_MODIFIERS_STRING = "_rt_action_string";

	/**
	 * Creates a partition scanner dedicated to the action language.
	 */
	public ParameterLabelPartitionScanner() {
		IToken tagString = new Token(PARAMETER_MODIFIERS_STRING);
		IPredicateRule[] rules = new IPredicateRule[1];
		rules[0] = new MultiLineRule("{", "}", tagString, (char)0, true);
		setPredicateRules(rules);
	}

}
