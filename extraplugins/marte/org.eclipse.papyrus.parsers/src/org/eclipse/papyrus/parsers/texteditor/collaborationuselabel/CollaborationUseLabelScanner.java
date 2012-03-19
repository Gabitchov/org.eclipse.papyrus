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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.collaborationuselabel;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.papyrus.parsers.texteditor.WhitespaceDetector;
import org.eclipse.papyrus.parsers.texteditor.completionproposals.VisibilityCompletionProposal;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.PropertyWordDetector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

/**
 * Scanner for the action language.<BR>
 * It implements the interface IALKeywords, which contains the different keywords available in the
 * action language
 * 
 * @author Remi SCHNEKENBURGER
 * @see org.eclipse.jface.text.rules.RuleBasedScanner
 * @see com.cea.actionlanguage.sharedresources.texteditor.IRTActionKeywords
 */
public class CollaborationUseLabelScanner extends RuleBasedScanner implements ICollaborationUseLabelColorConstants {

	/** Color for the default token */
	private Color defaultColor;

	/** Color for keywords */
	// private Color keywordColor;

	/** Color for special chars */
	private Color symbolColor;

	/**
	 * Creates a new rule based scanner.
	 */
	public CollaborationUseLabelScanner() {
		defaultColor = CollaborationUseLabelColorProvider.getDefault().getColor(DEFAULT);
		// keywordColor = CollaborationUseLabelColorProvider.getDefault().getColor(KEYWORD);
		symbolColor = CollaborationUseLabelColorProvider.getDefault().getColor(SYMBOL);

		IToken other = new Token(new TextAttribute(defaultColor));
		// IToken keyword = new Token(new TextAttribute(keywordColor, null, SWT.BOLD));
		IToken symbol = new Token(new TextAttribute(symbolColor, null, SWT.BOLD));

		IRule[] rules = new IRule[2];

		WordRule wordRule = new WordRule(new PropertyWordDetector(), other);
		for(int i = 0; i < VisibilityCompletionProposal.visibilityStrings.length; i++) {
			// wordRule.addWord(getWordWithoutQuotes(visibilityStrings[i]), keyword);
		}

		wordRule.addWord("+", symbol);
		wordRule.addWord("-", symbol);
		wordRule.addWord("#", symbol);
		wordRule.addWord("~", symbol);
		wordRule.addWord("/", symbol);
		wordRule.addWord("+/", symbol);
		wordRule.addWord("-/", symbol);
		wordRule.addWord("#/", symbol);
		wordRule.addWord(":", symbol);

		rules[0] = wordRule;
		rules[1] = new WhitespaceRule(new WhitespaceDetector());

		setRules(rules);
	}

	/**
	 * returns the word for the scanner, without quotes.
	 * 
	 * @param word
	 * 
	 * @return
	 */
	public static String getWordWithoutQuotes(String word) {
		String tmp = "";
		tmp = word.replaceAll("'", "");
		return tmp;
	}
}
