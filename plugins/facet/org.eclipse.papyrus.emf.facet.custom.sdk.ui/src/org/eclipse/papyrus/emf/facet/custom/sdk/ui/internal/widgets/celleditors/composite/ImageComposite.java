/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 375388 - Cell editor for IImage
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.widgets.celleditors.composite;

import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.ui.ImageUtils;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/** A composite for displaying an {@link IImage} (read-only for now) */
public class ImageComposite extends AbstractCellEditorComposite<IImage> {

	private final Button compositeButton;
	private final Canvas compositeCanvas;
	private IImage valueImage;

	protected Button getButton() {
		return this.compositeButton;
	}

	public Canvas getCanvas() {
		return this.compositeCanvas;
	}

	public ImageComposite(final Composite parent) {
		super(parent);

		final GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		setLayout(layout);

		this.compositeCanvas = createCanvas(this);
		this.compositeButton = createButton(this);

		// disposes the composite when the user clicks
		final Listener disposeListener = new Listener() {
			public void handleEvent(final Event event) {
				if (event.widget instanceof Control) {
					final Control control = (Control) event.widget;
					if (control.getShell() == getParent().getShell() && event.widget != getButton() && event.widget != getCanvas()) {
						ImageComposite.this.dispose();
						Display.getDefault().removeFilter(SWT.MouseDown, this);
					}
				}
			}
		};
		Display.getDefault().addFilter(SWT.MouseDown, disposeListener);
	}

	protected Canvas createCanvas(final Composite parent) {
		final Canvas canvas = new Canvas(parent, SWT.NONE);
		canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(final PaintEvent e) {
				final Image img = getImage();
				if (img != null && !img.isDisposed()) {
					e.gc.drawImage(img, 0, 0);
				}
			}
		});
		return canvas;
	}

	protected Button createButton(final Composite parent) {
		final Button button = new Button(parent, SWT.PUSH);
		button.setText("+"); //$NON-NLS-1$
		final GridData data = new GridData(SWT.FILL, SWT.FILL, false, true);
		button.setLayoutData(data);

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				openShell();
			}
		});
		return button;
	}

	protected void openShell() {
		final Shell shell = new Shell();
		shell.setText(Messages.ImageComposite_fullImage);
		shell.setLayout(new GridLayout());
		final Canvas shellCanvas = createCanvas(shell);
		final GridData canvasData = new GridData(SWT.FILL, SWT.FILL, true, true);
		final Image img = getImage();
		if (img != null && !img.isDisposed()) {
			canvasData.widthHint = img.getBounds().width;
			canvasData.heightHint = img.getBounds().height;
		}
		shellCanvas.setLayoutData(canvasData);
		shell.pack();
		shell.open();
	}

	protected Image getImage() {
		return ImageUtils.unwrap(this.valueImage);
	}

	public IImage getValue() {
		return this.valueImage;
	}

	public void setValue(final IImage value) {
		this.valueImage = value;
	}
}
