/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.nattable.celleditor;

import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.edit.EditController;
import org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor;


/**
 * Abstract superclass for all Papyrus Nattable dialog cell editors.
 */
public abstract class AbstractCancelableDialogCellEditor extends AbstractDialogCellEditor {

	private static int exitCode = Window.OK;

	public AbstractCancelableDialogCellEditor() {
		super();
	}

	@Override
	public final int open() {
		int result = doOpen();
		exitCode = result;
		return result;
	}

	protected abstract int doOpen();

	/**
	 * Obtains the exit code of the last dialog that was opened and then resets it to the uninitialized state.
	 * This is a terrible hack around the Nattable API's failure to do anything with or provide any means to
	 * communicate the exit code out of the
	 * {@link EditController#editCell(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell, org.eclipse.swt.widgets.Composite, Object, org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)}
	 * static method.
	 * 
	 * @return the exit code of the last dialog opened by a subclass of this class
	 */
	public static int getAndResetExitCode() {
		int result = exitCode;
		
		exitCode = Window.OK;
		
		return result;
	}
}
