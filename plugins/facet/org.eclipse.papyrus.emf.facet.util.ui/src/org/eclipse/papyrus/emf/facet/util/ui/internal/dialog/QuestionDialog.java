/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 366367 - To be able to change the "CanBePresentedInTheTable" query
 *     Gregoire Dupe (Mia-Software) - Bug 373248 - Clean PMD errors
 *     Gregoire Dupe (Mia-Software) - Bug 374903 - [Table] ITableWidget.setLoadedFacetSets
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.ui.internal.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.emf.facet.util.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IQuestionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * A yes/no dialog, that replicates the JFace MessageDialog#openQuestion, but is designed to be easily testable with JUnit
 * 
 * @since 0.2
 */
public class QuestionDialog implements IQuestionDialog {

	private static final int SHELL_WIDTH = 450;
	private static final int SHELL_HEIGHT = 170;

	private final Shell parentShell;
	private final List<Runnable> listeners = new ArrayList<Runnable>();
	private Boolean result = null;
	private Shell shell;
	private Button btnYes;
	private Button btnNo;
	private final String title;
	private final String message;
	private IDialogCallback<Boolean> callback;

	public QuestionDialog(final Shell parent, final String title,
			final String message, final IDialogCallback<Boolean> callback) {
		this.parentShell = parent;
		this.title = title;
		this.message = message;
		this.callback = callback;
		createContents();
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public final void open() {
		this.shell.layout();
		// center the shell on its parent (if not parent shell then it will not be centered)
		if (this.parentShell != null) {
			final Rectangle parentShellBounds = this.parentShell.getBounds();
			final Point shellSize = this.shell.getSize();
			this.shell.setLocation(
					parentShellBounds.x + (parentShellBounds.width - shellSize.x) / 2,
					parentShellBounds.y + (parentShellBounds.height - shellSize.y) / 2);
		}
		this.shell.open();
	}

	/** Create the contents of the dialog. */
	private void createContents() {
		final int buttonWidthHint = 80;
		this.shell = new Shell(this.parentShell, SWT.BORDER | SWT.RESIZE | SWT.TITLE
				| SWT.APPLICATION_MODAL);
		this.shell.setSize(QuestionDialog.SHELL_WIDTH,
				QuestionDialog.SHELL_HEIGHT);
		this.shell.setText(this.title);
		final GridLayout shellLayout = new GridLayout(2, false);

		// constants to make checkstyle happy
		final int marginLeft = 5;
		final int marginTop = 8;
		final int verticalSpacing = 10;
		final int horizontalSpacing = 15;
		shellLayout.marginLeft = marginLeft;
		shellLayout.marginTop = marginTop;
		shellLayout.verticalSpacing = verticalSpacing;
		shellLayout.horizontalSpacing = horizontalSpacing;

		this.shell.setLayout(shellLayout);

		final Label image = new Label(this.shell, SWT.NONE);
		image.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		image.setImage(Display.getDefault().getSystemImage(SWT.ICON_QUESTION));

		final Label labelMessage = new Label(this.shell, SWT.WRAP);
		labelMessage.setText(this.message);
		labelMessage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Composite buttonsComposite = new Composite(this.shell, SWT.NONE);
		final int buttonsCompositeColumns = 3;
		buttonsComposite.setLayout(new GridLayout(buttonsCompositeColumns, false));
		buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		final Composite paddingComposite = new Composite(buttonsComposite, SWT.NONE);
		final GridData paddingCompositeGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		paddingCompositeGridData.heightHint = 0;
		paddingComposite.setLayoutData(paddingCompositeGridData);

		this.btnYes = new Button(buttonsComposite, SWT.NONE);
		final GridData button1GridData = new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1);
		button1GridData.widthHint = buttonWidthHint;
		this.btnYes.setLayoutData(button1GridData);
		this.btnYes.setText(Messages.QuestionDialog_yes);
		this.btnYes.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				pressYes();
			}
		});

		this.btnNo = new Button(buttonsComposite, SWT.NONE);
		final GridData button2GridData = new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1);
		button2GridData.widthHint = buttonWidthHint;
		this.btnNo.setLayoutData(button2GridData);
		this.btnNo.setText(Messages.QuestionDialog_no);
		this.btnNo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				pressNo();
			}
		});
	}

	public final void pressYes() {
		if (this.shell.isDisposed()) {
			throw new UnsupportedOperationException("Dialog is disposed"); //$NON-NLS-1$
		}
		this.result = Boolean.TRUE;
		this.shell.dispose();
		notifyListeners();
	}

	public final void pressNo() {
		if (this.shell.isDisposed()) {
			throw new UnsupportedOperationException("Dialog is disposed"); //$NON-NLS-1$
		}
		this.result = Boolean.FALSE;
		this.shell.dispose();
		notifyListeners();
	}

	private synchronized void notifyListeners() {
		if (this.callback != null) {
			this.callback.committed(getResult());
		}
		for (final Runnable listener : new ArrayList<Runnable>(this.listeners)) {
			listener.run();
		}
	}

	public synchronized void addCloseListener(final Runnable runnable) {
		this.listeners.add(runnable);
	}

	public final Boolean getResult() {
		return this.result;
	}
	
	public final Shell getShell() {
		return this.shell;
	}
}
