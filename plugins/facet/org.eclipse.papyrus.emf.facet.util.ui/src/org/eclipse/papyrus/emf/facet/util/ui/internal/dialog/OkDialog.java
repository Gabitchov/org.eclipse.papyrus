/** 
 * Copyright (c) Soft-Maint.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Thomas Cicognani (Soft-Maint) - Bug 406565 - Ok Dialog
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.emf.facet.util.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IOkDialog;
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
import org.eclipse.swt.widgets.Text;

public class OkDialog implements IOkDialog {
	private static final int SHELL_WIDTH = 450;
	private static final int SHELL_HEIGHT = 170;
	private static final int BUTTON_WIDTH_HINT = 80;
	private static final int MARGIN_LEFT = 5;
	private static final int MARGIN_TOP = 8;
	private static final int VERTICAL_SPACING = 10;
	private static final int HORIZONT_SPACING = 15;
	private static final int BUTTONS_COMP_COL = 3;

	private final List<Runnable> listeners = new ArrayList<Runnable>();

	private final Shell parentShell;
	private final String title;
	private final String message;
	private final IDialogCallback<Void> callback;
	private Shell shell;
	private final int kind;

	public OkDialog(final Shell parentShell, final int kind,
			final String title, final String message,
			final IDialogCallback<Void> iDialogCallback) {
		this.parentShell = parentShell;
		this.title = title;
		this.message = message;
		this.callback = iDialogCallback;
		this.kind = kind;
		createContents();
	}

	private void createContents() {
		this.shell = new Shell(this.parentShell, SWT.BORDER | SWT.RESIZE
				| SWT.TITLE | SWT.APPLICATION_MODAL);
		this.shell.setSize(OkDialog.SHELL_WIDTH, OkDialog.SHELL_HEIGHT);
		this.shell.setText(this.title);
		final GridLayout shellLayout = new GridLayout(2, false);

		// constants to make checkstyle happy
		shellLayout.marginLeft = OkDialog.MARGIN_LEFT;
		shellLayout.marginTop = OkDialog.MARGIN_TOP;
		shellLayout.verticalSpacing = OkDialog.VERTICAL_SPACING;
		shellLayout.horizontalSpacing = OkDialog.HORIZONT_SPACING;

		this.shell.setLayout(shellLayout);

		final Label image = new Label(this.shell, SWT.NONE);
		image.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		image.setImage(Display.getDefault().getSystemImage(this.kind));

		final Text labelMessage = new Text(this.shell, SWT.WRAP | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.READ_ONLY);
		labelMessage.setText(this.message);
		labelMessage
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Composite buttonsComposite = new Composite(this.shell, SWT.NONE);
		buttonsComposite.setLayout(new GridLayout(OkDialog.BUTTONS_COMP_COL,
				false));
		buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 2, 1));

		final Composite paddingComposite = new Composite(buttonsComposite,
				SWT.NONE);
		final GridData paddCompGridData = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		paddCompGridData.heightHint = 0;
		paddingComposite.setLayoutData(paddCompGridData);

		final Button btnOk = new Button(buttonsComposite, SWT.NONE);
		final GridData button1GridData = new GridData(SWT.LEFT, SWT.BOTTOM,
				false, false, 1, 1);
		button1GridData.widthHint = OkDialog.BUTTON_WIDTH_HINT;
		btnOk.setLayoutData(button1GridData);
		btnOk.setText(Messages.OK);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				commit();
			}
		});
	}

	public void open() {
		this.shell.layout();
		// center the shell on its parent (if not parent shell then it will not
		// be centered)
		if (this.parentShell != null) {
			final Rectangle parentShellBounds = this.parentShell.getBounds();
			final Point shellSize = this.shell.getSize();
			this.shell.setLocation(parentShellBounds.x
					+ (parentShellBounds.width - shellSize.x) / 2,
					parentShellBounds.y
							+ (parentShellBounds.height - shellSize.y) / 2);
		}
		this.shell.open();
	}

	public final void commit() {
		if (this.shell.isDisposed()) {
			throw new UnsupportedOperationException("Dialog is disposed"); //$NON-NLS-1$
		}
		this.shell.dispose();
		notifyListeners();
	}

	private void notifyListeners() {
		if (this.callback != null) {
			this.callback.committed(null);
		}
		for (final Runnable listener : this.listeners) {
			listener.run();
		}
	}

	public void addCloseListener(final Runnable paramRunnable) {
		this.listeners.add(paramRunnable);
	}

	public Shell getShell() {
		return this.shell;
	}

	public boolean isInformation() {
		return this.kind == SWT.ICON_INFORMATION;
	}

	public boolean isWarning() {
		return this.kind == SWT.ICON_WARNING;
	}

	public boolean isError() {
		return this.kind == SWT.ICON_ERROR;
	}

}
