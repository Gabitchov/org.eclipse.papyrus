/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 366367 - To be able to change the "CanBePresentedInTheTable" query
 *     Gregoire Dupe (Mia-Software) - Bug 374903 - [Table] ITableWidget.setLoadedFacetSets
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog;

import org.eclipse.papyrus.emf.facet.util.ui.internal.dialog.QuestionDialogFactory;
import org.eclipse.swt.widgets.Shell;

/** A factory to instantiate {@link IQuestionDialog} */
public interface IQuestionDialogFactory {
	static IQuestionDialogFactory INSTANCE = new QuestionDialogFactory();

	/**
	 * Instantiates a question dialog (without opening it)
	 * 
	 * @param parent
	 *            the parent shell for the new dialog
	 * @param title
	 *            the text that appears in the title of the dialog
	 * @param message
	 *            the text that appears in the message area of the dialog
	 * @return the dialog, ready to be {@link IQuestionDialog#open() opened}
	 */
	@Deprecated
	IQuestionDialog createQuestionDialog(Shell parent, String title, String message);
	
	/**
	 * Instantiates a question dialog (without opening it)
	 * 
	 * @param parent
	 *            the parent shell for the new dialog
	 * @param title
	 *            the text that appears in the title of the dialog
	 * @param message
	 *            the text that appears in the message area of the dialog
	 * @return the dialog, ready to be {@link IQuestionDialog#open() opened}
	 * @since 0.2
	 */
	IQuestionDialog createQuestionDialog(Shell parent, String title,
			String message, IDialogCallback<Boolean> callback);
}
