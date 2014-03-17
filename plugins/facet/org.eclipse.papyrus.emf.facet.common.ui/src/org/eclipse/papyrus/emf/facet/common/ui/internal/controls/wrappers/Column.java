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
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeColumn;

/** Provides a unified API over both SWT {@link TreeColumn} and {@link TableColumn} */
public interface Column {
	void setText(String columnText);

	void addControlListener(ControlListener controlListener);

	void addSelectionListener(SelectionListener selectionListener);

	void setWidth(int width);

	int getWidth();

	Item getColumn();
}