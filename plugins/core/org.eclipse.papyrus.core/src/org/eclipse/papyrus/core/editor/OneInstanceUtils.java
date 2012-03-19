/*****************************************************************************
 * Copyright (c) 2012 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE  tristan.faure@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.EditorManager;


/**
 * Methods to manage one editor 
 * @author Tristan FAURE
 *
 */
@SuppressWarnings("restriction")
public final class OneInstanceUtils {
	
	public static IWorkbenchWindow getWindow () {
		if (PlatformUI.getWorkbench() != null){
			if (PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null){
				return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			}
		}
		return null ;
	}
	
	/**
	 * Determine if Papyrus is already opened
	 * @param reference
	 * @return
	 */
	public static boolean isPapyrusOpen(CoreMultiDiagramEditor reference) {
		return isPapyrusOpen(getWindow(),reference);
	}
	
	/**
	 * Determine if Papyrus is already opened
	 * @param reference
	 * @return
	 */
	public static boolean isPapyrusOpen(IWorkbenchWindow window, CoreMultiDiagramEditor reference) {
		return getAllEdtiorsExceptReference(window,reference).size() > 0 ;
	}
	
	/**
	 * get all the papyrus editors except reference parameter
	 * @param window
	 * @param reference
	 * @return
	 */
	public static Iterable<CoreMultiDiagramEditor> getAllEdtiorsExceptReference (CoreMultiDiagramEditor reference){
		return getAllEdtiorsExceptReference(getWindow(),reference);
	}
	
	/**
	 * get all the papyrus editors except reference parameter
	 * @param window
	 * @param reference
	 * @return
	 */
	public static List<CoreMultiDiagramEditor> getAllEdtiorsExceptReference (IWorkbenchWindow window, CoreMultiDiagramEditor reference){
		List<CoreMultiDiagramEditor> result = new LinkedList<CoreMultiDiagramEditor>();
		if (window != null)	{
			for (IWorkbenchPage p : window.getPages()) {
				for (IEditorReference r : p.getEditorReferences()) {
					IEditorPart editor = r.getEditor(false);
					if (editor != reference && editor instanceof CoreMultiDiagramEditor) {
						result.add((CoreMultiDiagramEditor)editor);
					}
				}
			}
		}
		return result ;
	}
	
	/**
	 * Save all the instances (normally one) of the Papyrus Editors opened
	 * @param window
	 * @param reference
	 * @param list
	 * @return
	 */
	public static boolean saveAllPapyrusOpened (IWorkbenchWindow window, CoreMultiDiagramEditor reference, List<CoreMultiDiagramEditor> list){
		if (list == null) {
			list = getAllEdtiorsExceptReference(window, reference);
		}
		return EditorManager.saveAll(list, true, true, false, window);
	}
	
	/**
	 * return false if the operation is canceled
	 * @param window
	 * @param reference
	 * @return
	 */
	public static boolean closeAllPapyrusOpened (IWorkbenchWindow window, CoreMultiDiagramEditor reference){
		final List<CoreMultiDiagramEditor> parts = getAllEdtiorsExceptReference(window,reference);
		if (saveAllPapyrusOpened(window, reference, parts)) {
			Display.getDefault().asyncExec(new Runnable() {
				
				public void run() {
					for (IEditorPart p : parts){
						p.getEditorSite().getPage().closeEditor(p, false);
					}
				}
			});
			
		}
		else {
			// the user selects cancel to the operation so return false 
			return false ;
		}
		return true ;
	}
	
	/**
	 * return false if the operation is canceled
	 * @param window
	 * @param reference
	 * @return
	 */
	public static boolean closeAllPapyrusOpened (CoreMultiDiagramEditor reference){
		return closeAllPapyrusOpened(getWindow(),reference);
	}
	
}
