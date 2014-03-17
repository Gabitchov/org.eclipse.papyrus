/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 334116 - common tree view with columns
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers;

import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionListener;

/** Implements {@link Column}'s unified API for the SWT {@link org.eclipse.swt.widgets.TableColumn} */
public class TableColumn implements Column {
	private final org.eclipse.swt.widgets.TableColumn column;

	public TableColumn(final org.eclipse.swt.widgets.TableColumn column) {
		this.column = column;
	}

	public void setText(final String columnText) {
		this.column.setText(columnText);
	}

	public void setWidth(final int width) {
		this.column.setWidth(width);

	}

	public void addControlListener(final ControlListener controlListener) {
		this.column.addControlListener(controlListener);
	}

	public void addSelectionListener(final SelectionListener selectionListener) {
		this.column.addSelectionListener(selectionListener);
	}

	public int getWidth() {
		return this.column.getWidth();
	}

	public org.eclipse.swt.widgets.TableColumn getColumn() {
		return this.column;
	}
}