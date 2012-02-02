/**
 * <copyright>
 * 
 * Copyright (c) 2008-2010 See4sys and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     See4sys - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.papyrus.emf.compare.transactional.editor;

import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
//import org.eclipse.sphinx.emf.compare.ui.editor.ModelCompareEditor;
import org.eclipse.sphinx.platform.ui.util.SelectionUtil;
import org.eclipse.sphinx.platform.util.ExtendedPlatform;
import org.eclipse.sphinx.platform.util.ReflectUtil;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Action for comparing {@link IFile file}s in the workspace. Overrides Eclipse-defined action behind "Compare With >
 * Each Other" popup menu to make sure that {@link ModelCompareEditor} rather than Eclipse's {@link CompareEditor} is
 * opened when selected {@link IFile file}s are model files.
 * 
 * @see ModelCompareEditor
 */
@SuppressWarnings("restriction")
public class FileCompareAction implements IObjectActionDelegate {

	private BasicCompareAction modelCompareActionDelegate = new BasicCompareAction();
	private IObjectActionDelegate eclipseCompareActionDelegate;

	@SuppressWarnings("unchecked")
	public FileCompareAction() {
		// Ensure backward compatibility with Eclipse 3.4.x and earlier
		try {
			String eclipseCompareActionClassName;
			if (ExtendedPlatform.getFeatureVersionOrdinal() >= 35) {
				eclipseCompareActionClassName = "org.eclipse.team.internal.ui.actions.CompareAction"; //$NON-NLS-1$
			} else {
				eclipseCompareActionClassName = "org.eclipse.compare.internal.CompareAction"; //$NON-NLS-1$
			}
			Class<IObjectActionDelegate> eclipseCompareActionClass = (Class<IObjectActionDelegate>) getClass().getClassLoader().loadClass(
					eclipseCompareActionClassName);
			eclipseCompareActionDelegate = eclipseCompareActionClass.newInstance();
		} catch (Exception ex) {
			// Ignore exception
		}
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		if (eclipseCompareActionDelegate != null) {
			eclipseCompareActionDelegate.setActivePart(action, targetPart);
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// Propagate selection to delegates
		if (eclipseCompareActionDelegate != null) {
			eclipseCompareActionDelegate.selectionChanged(action, selection);
		}
		modelCompareActionDelegate.selectionChanged(SelectionUtil.getStructuredSelection(selection));

		// Update enablement state
		if (action != null) {
			action.setEnabled(isEclipseCompareActionEnabled() | modelCompareActionDelegate.isEnabled());
		}
	}

	public void run(IAction action) {
		if (modelCompareActionDelegate.isEnabled()) {
			modelCompareActionDelegate.run();
		} else if (isEclipseCompareActionEnabled()) {
			eclipseCompareActionDelegate.run(action);
		}
	}

	private boolean isEclipseCompareActionEnabled() {
		try {
			// Retrieve Eclipse compare action enablement state reflectively to be compatible with Eclipse 3.4.x and
			// Eclipse 3.5.x
			if (eclipseCompareActionDelegate != null) {
				return (Boolean) ReflectUtil.invokeMethod(eclipseCompareActionDelegate, "isEnabled"); //$NON-NLS-1$
			}
		} catch (Exception ex) {
			// Ignore exception
		}
		return false;
	}
}
