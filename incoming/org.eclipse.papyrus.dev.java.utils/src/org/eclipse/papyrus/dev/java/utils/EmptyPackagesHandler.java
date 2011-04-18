/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.dev.java.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * This action allows to empty the selected packages or the package included in a IPackageFragmentRoot (i.e : a Source Folder)
 * 
 * 
 * 
 */
public class EmptyPackagesHandler extends AbstractHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		for(IPackageFragment current : getSelectedElements()) {
			IJavaElement children[] = null;
			try {
				children = current.getChildren();
			} catch (JavaModelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(children != null) {
				for(IJavaElement currentElement : children) {
					if(currentElement instanceof ICompilationUnit) {
						try {
							((ICompilationUnit)currentElement).delete(true, new NullProgressMonitor());
						} catch (JavaModelException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), "Empty Package", null, "All the package are now empty!", MessageDialog.INFORMATION, new String[]{ "OK" }, 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		dialog.open();
		return null;
	}

	/**
	 * Iterate over current selection and build a list of the {@link IGraphicalEditPart} contained in
	 * the selection.
	 * 
	 * @return the currently selected {@link IGraphicalEditPart}
	 */
	protected List<IPackageFragment> getSelectedElements() {
		List<IPackageFragment> packages = new ArrayList<IPackageFragment>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Iterator<?> it = structuredSelection.iterator();
			while(it.hasNext()) {
				Object object = it.next();
				if(object instanceof IPackageFragment) {
					packages.add((IPackageFragment)object);
				} else if(object instanceof IPackageFragmentRoot) {
					try {
						IJavaElement[] children = ((IPackageFragmentRoot)object).getChildren();
						for(IJavaElement current : children) {
							if(current instanceof IPackageFragment) {
								packages.add((IPackageFragment)current);
							}
						}

					} catch (JavaModelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		return packages;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return getSelectedElements().size() != 0;
	}
}
