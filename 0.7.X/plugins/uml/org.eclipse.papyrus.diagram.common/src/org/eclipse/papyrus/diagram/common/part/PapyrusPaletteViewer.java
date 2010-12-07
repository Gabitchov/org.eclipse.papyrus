/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.part;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.gef.ui.palette.customize.PaletteCustomizerDialog;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteCustomizerDialogEx;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteViewerEx;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.swt.widgets.Shell;

/**
 * Extended Palette Viewer, to have a new customize dialog
 */
public class PapyrusPaletteViewer extends PaletteViewerEx {

	/** cached dialog for the customization */
	private PaletteCustomizerDialog customizerDialog = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaletteCustomizerDialog getCustomizerDialog() {
		if(customizerDialog == null) {
			try {
				@SuppressWarnings("unchecked")
				Class<PaletteCustomizerDialog> advancedCustomizerDialogClass = (Class<PaletteCustomizerDialog>)Activator.getDefault().getBundle().loadClass("org.eclipse.papyrus.diagram.common.palette.customization.dialog.PapyrusPaletteCustomizerDialog");
				Constructor<PaletteCustomizerDialog> constructor = advancedCustomizerDialogClass.getConstructor(Shell.class, PaletteCustomizer.class, PaletteRoot.class);
				if(constructor != null) {
					customizerDialog = constructor.newInstance(getControl().getShell(), getCustomizer(), getPaletteRoot());
					if(customizerDialog == null) {
						//be sure it is not null
						customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
					}
				}
			} catch (ClassNotFoundException e) {
				customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
			} catch (IllegalArgumentException e) {
				customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
			} catch (InstantiationException e) {
				customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
			} catch (IllegalAccessException e) {
				customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
			} catch (InvocationTargetException e) {
				customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
			} catch (SecurityException e) {
				customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
			} catch (NoSuchMethodException e) {
				customizerDialog = new PaletteCustomizerDialogEx(getControl().getShell(), getCustomizer(), getPaletteRoot());
			}
		}
		return customizerDialog;
	}
}
