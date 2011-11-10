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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tabbed.profile.composite;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.tools.utils.ImageUtil;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Image;


/**
 * Composite that displays a label and a text area (ex: modification of the name of an element)
 **/
public class ExprTextComposite extends SimpleTextComposite {

	
	protected static final String COMMAND_LABEL = "Edit ";
	protected static final String NOT_COMMIT = "could not commit changes to the model";

	/**
	 * 
	 * Constructor.
	 *
	 * @param label to display in the property view
	 */
	public ExprTextComposite(String label) {
		super(label);
	}

	/**
	 * {@inheritDoc}
	 */
	public void refresh() {
		if (isValid(text)) {
			text.setText(getTextFromModel(getElement()));
		}
	}

	/**
	 * this method should take the text in the text area and modify the model using this information
	 */
	public String getTextFromModel(Element element) {
		String txt = "";
		if (element instanceof Image) {
			String expr = ImageUtil.getExpression((Image) element);
			if (expr != null) {
				txt += expr;
			}
		}

		return txt;
	}

	/**
	 * This method should restore the value of the text area for the specified element
	 */
	public void setModelFromText(Element element, String newValue) {
		if (element instanceof Image) {
			ImageUtil.setExpression((Image) element, newValue);
		}
	}

	/**
	 * Apply the new value using the
	 */
	public void applyNewValue() {
		final TransactionalEditingDomain domain=	EditorUtils.getTransactionalEditingDomain();
		if (domain!=null && isValid(text)) {
			final Runnable runnable = new Runnable() {

				/**
				 * {@inheritDoc}
				 */
				public void run() {
					setModelFromText(getElement(), text.getText().trim());
				}
			};
			Command emfCommand = new ChangeCommand(domain, runnable, COMMAND_LABEL + label);
			domain.getCommandStack().execute(emfCommand);
			EditorUtils.getMultiDiagramEditor().setFocus();
		} else {
			System.err.println( NOT_COMMIT);
		}
	}
}
