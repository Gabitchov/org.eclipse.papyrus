/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.epf.richtext.extension.actions;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.actions.RichTextAction;
import org.eclipse.epf.richtext.extension.RichTextCommand;
import org.eclipse.jface.action.IAction;

/**
 * @author Nguyen Viet Hoa
 * 
 */
public class SetupTestAction extends RichTextAction {

	private String parameter = "";

	/**
	 * Creates a new instance.
	 */
	public SetupTestAction(final IRichText richText) {
		super(richText, IAction.AS_CHECK_BOX);

	}

	/**
	 * Executes the action.
	 * 
	 * @param richText
	 *        a rich text control
	 */
	public void execute(IRichText richText) {
		if(richText != null) {
			richText.executeCommand(RichTextCommand.SETUP_TEST, getParameter());
		}
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
