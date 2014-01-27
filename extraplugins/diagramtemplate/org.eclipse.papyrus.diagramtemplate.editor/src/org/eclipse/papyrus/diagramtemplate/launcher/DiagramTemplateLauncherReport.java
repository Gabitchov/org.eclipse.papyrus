/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate.launcher;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.diagramtemplate.launcher.DiagramTemplateLauncher.CreationReportKind;
import org.eclipse.papyrus.diagramtemplate.utils.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.NamedElement;

import com.swtdesigner.ResourceManager;




public class DiagramTemplateLauncherReport {

	class DiagramTemplateLauncherReportLabelProvider implements ILabelProvider {

		/**
		 * {@inheritDoc}
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritDoc}
		 */
		public Image getImage(Object element) {
			if(element instanceof Entry) {
				if(((Entry)element).getValue() == CreationReportKind.SUCCESS) {
					return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/add.gif"); //$NON-NLS-1$ //$NON-NLS-2$
				} else if(((Entry)element).getValue() == CreationReportKind.FAIL) {
					return ResourceManager.getPluginImage("org.eclipse.papyrus.diagramtemplate.editor", "icons/full/obj16/delete.gif"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText(Object element) {
			if(element instanceof Entry) {
				Object key = ((Entry)element).getKey();
				String result = ((EObject)key).eResource().getURIFragment((EObject)key);
				if(key instanceof NamedElement) {
					result = ((NamedElement)key).getQualifiedName() + " (" + result + ")"; //$NON-NLS-1$ //$NON-NLS-2$
				}
				return result;
			}
			return null;
		}

	}

	private static DiagramTemplateLauncherReport instance = null;

	private DiagramTemplateLauncherReport() {
	}

	public static final synchronized DiagramTemplateLauncherReport getInstance() {
		if(instance == null) {
			instance = new DiagramTemplateLauncherReport();
		}

		return instance;
		//		return null;
	}

	public void showReport(HashMap<EObject, CreationReportKind> report) {
		//		ListSelectionDialog dlg = new ListSelectionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite().getShell(), report, new DiagramTemplateLauncherReportContentProvider(), new DiagramTemplateLauncherReportLabelProvider(), "Report");
		//		dlg.open();
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite().getShell(), new DiagramTemplateLauncherReportLabelProvider());
		dlg.setElements(report.entrySet().toArray());
		dlg.setTitle(Messages.DiagramTemplateLauncherReport_6);
		dlg.open();
	}

}
