/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *   Andreas Muelder - Initial contribution and API
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.modelexplorer;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.swt.widgets.Composite;

/**
 * Support for direct editors
 */
public class DirectEditorEditingSupport extends EditingSupport {

	public DirectEditorEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(final Object element) {
		ICustomDirectEditorConfiguration configuration = getConfigurationAE(element);
		EObject semanticObject = (EObject) ((IAdaptable) element)
				.getAdapter(EObject.class);
		Composite parent = (Composite) getViewer().getControl();
		return configuration.createCellEditor(parent, semanticObject);
	}

	@Override
	protected boolean canEdit(Object element) {
		return getConfigurationAE(element) != null;
	}

	@Override
	protected Object getValue(Object element) {
		ICustomDirectEditorConfiguration configuration = getConfigurationAE(element);
		Object semanticObject = ((IAdaptable) element)
				.getAdapter(EObject.class);
		return configuration.createParser((EObject) semanticObject)
				.getEditString(new EObjectAdapter((EObject) semanticObject), 0);
	}

	@Override
	protected void setValue(Object element, Object value) {
		ICustomDirectEditorConfiguration configuration = getConfigurationAE(element);
		EObject semanticObject = (EObject) ((IAdaptable) element)
				.getAdapter(EObject.class);
		IParser parser = configuration.createParser(semanticObject);

		ICommand command = parser.getParseCommand(new EObjectAdapter(
				semanticObject), (String) value, 0);
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(semanticObject);
		editingDomain.getCommandStack().execute(
				new GMFtoEMFCommandWrapper(command));
	}

	/**
	 * Obtain direct editor configuration for an element that can be adapted to
	 * an EObject
	 * @param element an adaptable element
	 * @return The direct editor configuration, if it exists.
	 */
	public static ICustomDirectEditorConfiguration getConfigurationAE(Object element) {
		if (element instanceof IAdaptable) {
			EObject semanticObject = (EObject) ((IAdaptable) element)
					.getAdapter(EObject.class);
			return getConfiguration(semanticObject);
		}
		return null;
	}
	
	/**
	 * Obtain direct editor configuration for a semantic element
	 * @param element a sementic element
	 * @return The direct editor configuration, if it exists.
	 */
	public static ICustomDirectEditorConfiguration getConfiguration(EObject semanticElement) {
		
		IPreferenceStore store = Activator.getDefault()
				.getPreferenceStore();
		String semanticClassName = semanticElement.eClass()
				.getInstanceClassName();
		String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT
				+ semanticClassName;
		String languagePreferred = store.getString(key);

		if (languagePreferred != null && !languagePreferred.equals("")) { //$NON-NLS-1$
			IDirectEditorConfiguration configuration = DirectEditorsUtil
					.findEditorConfiguration(languagePreferred,	semanticClassName);
			if (configuration instanceof ICustomDirectEditorConfiguration) {
				return (ICustomDirectEditorConfiguration) configuration;
			}
		}
		return null;
	}
}