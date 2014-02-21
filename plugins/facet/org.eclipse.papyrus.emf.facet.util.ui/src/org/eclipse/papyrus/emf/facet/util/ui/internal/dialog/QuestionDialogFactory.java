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
package org.eclipse.papyrus.emf.facet.util.ui.internal.dialog;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IQuestionDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IQuestionDialogFactory;
import org.eclipse.swt.widgets.Shell;

public class QuestionDialogFactory implements IQuestionDialogFactory {

	public IQuestionDialog createQuestionDialog(final Shell parent, final String title, final String message) {
		return new QuestionDialog(parent, title, message, null);
	}

	public IQuestionDialog createQuestionDialog(final Shell parent,
			final String title, final String message,
			final IDialogCallback<Boolean> callback) {
		return new QuestionDialog(parent, title, message, callback);
	}

}

