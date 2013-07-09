/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.util;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.eclipse.papyrus.infra.tools.Activator;


/**
 * 
 * @author vl222926
 *
 */
public class ClipboardUtils {

	
	private ClipboardUtils() {
		//to prevent instanciationF
	}
	
	/**
	 * 
	 * @return
	 *         the clipboard contents used to build the command
	 */
	public static final String getClipboardContents() {
		// examine system clipboard
		String bufferSystem = null;

		//using AWT
		/*
		 * final DataFlavor[] dataFlavors = Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
		 * for(final DataFlavor dataFlavor : dataFlavors) {
		 * try {
		 * if(dataFlavor.isFlavorTextType() && dataFlavor.isMimeTypeEqual(DataFlavor.stringFlavor)) {
		 * bufferSystem = Toolkit.getDefaultToolkit().getSystemClipboard().getData(dataFlavor).toString();
		 * }
		 * } catch (final Exception e) {
		 * Activator.log.error(e);
		 * }
		 * }
		 */
		java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			try {
				bufferSystem = clipboard.getData(DataFlavor.stringFlavor).toString();
			} catch (UnsupportedFlavorException e) {
				Activator.log.error(e);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
		//using SWT
		//		final Display display = Display.getCurrent();
		//		final Clipboard cb = new Clipboard(display);
		//		//we use the text transfert
		//		final TextTransfer transfer = TextTransfer.getInstance();
		//
		//		final Clipboard cb = new Clipboard(clipboard);
		//		final String contents = (String)cb.getContents(transfer);


		return bufferSystem;
	}
}
