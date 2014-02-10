/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *   Laurent Pichierri (Soft-Maint) - Bug 371204 - Compatibility with Helios
 *******************************************************************************/
package org.eclipse.emf.facet.util.emf.ui.internal.dialogs;

import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.util.emf.core.ModelUtils;
import org.eclipse.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public final class CreateInstanceDialog {

	private CreateInstanceDialog() {
		//
	}

	/**
	 * Open a dialog with a list of metaclasses that are subclasses of the given
	 * {@link EClass}. When the user chooses a metaclass, an instance is created
	 * an returned.
	 * 
	 * @param shell
	 *            the parent shell for the dialog
	 * @param eClass
	 *            the {@link EClass} of the new instance
	 * @param labelProvider
	 *            label provider for the displayed {@link EClass}es.
	 * @return the created instance, or <code>null</code> if the user cancelled
	 */
	public static EObject open(final Shell shell, final EClass eClass,
			final LabelProvider labelProvider) {
		List<EClass> allSubClasses = ModelUtils.allSubClasses(eClass);
		allSubClasses.add(eClass);
		// remove non-instantiable metaclasses
		ListIterator<EClass> listIterator = allSubClasses.listIterator();
		while (listIterator.hasNext()) {
			EClass e = listIterator.next();
			if (e.isAbstract() || e.isInterface()) {
				listIterator.remove();
			}
		}

		ElementListSelectionDialog eClassSelectionDialog = new ElementListSelectionDialog(shell,
				labelProvider);
		eClassSelectionDialog.setTitle(Messages.CreateInstanceDialog_selectNewInstanceEClass);
		eClassSelectionDialog.setElements(allSubClasses.toArray());
		eClassSelectionDialog.open();
		Object selectedElement = eClassSelectionDialog.getFirstResult();
		if (selectedElement instanceof EClass) {
			EClass selectedEClass = (EClass) selectedElement;
			if (!selectedEClass.isInterface() && !selectedEClass.isAbstract()) {
				EObject eObject = selectedEClass.getEPackage().getEFactoryInstance()
						.create(selectedEClass);
				return eObject;
			}
		}
		return null;
	}

}
