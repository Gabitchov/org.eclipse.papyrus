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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Stereotype;

public class IsPossibleColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public IsPossibleColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	/**
	 * Change IsPossible in the model to impossible
	 * 
	 * @param element
	 */
	protected void transformPossibleIntoImpossible(BaseMetaclass element) {
		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_Possible(), false);
		editingDomain.getCommandStack().execute(command);

	}

	/**
	 * Change IsPossible in the model to possible
	 * 
	 * @param element
	 */
	protected void transformImpossibleIntoPossible(BaseMetaclass element) {

		SetCommand command = new SetCommand(editingDomain, element, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_Possible(), true);
		editingDomain.getCommandStack().execute(command);

	}

	/**
	 * Change IsPossible in the model to impossible and propagate to children and generals
	 * 
	 * @param element
	 */
	protected void transformAllPossibleIntoImpossible(BaseMetaclass element) {
		Facade facade = ((BaseMetaclass)element).getExtensionDefinition().getFacade();
		transformPossibleIntoImpossible((BaseMetaclass)element);

		// All children and generals must be set to Impossible as well
		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((BaseMetaclass)element).getExtensionDefinition().getStereotype());

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getExtension() == ((BaseMetaclass)element).getExtensionDefinition().getExtension()) {
				if(siblings.contains(extensionDefinition.getStereotype())) {
					for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses())
						if(baseMetaclass.getBase() == ((BaseMetaclass)element).getBase()) {
							transformPossibleIntoImpossible(baseMetaclass);
						}
				}
			}
		}
	}

	/**
	 * Change IsPossible in the model to possible and propagate to children and generals
	 * 
	 * @param element
	 */
	protected void transformAllImpossibleIntoPossible(BaseMetaclass element) {
		Facade facade = ((BaseMetaclass)element).getExtensionDefinition().getFacade();
		transformImpossibleIntoPossible((BaseMetaclass)element);

		// All children and generals must be set to Possible as well
		HashSet<Stereotype> siblings = ProfileUtils.getSiblings(((BaseMetaclass)element).getExtensionDefinition().getStereotype());

		for(ExtensionDefinition extensionDefinition : facade.getExtensionDefinitions()) {
			if(extensionDefinition.getExtension() == ((BaseMetaclass)element).getExtensionDefinition().getExtension()) {
				if(siblings.contains(extensionDefinition.getStereotype())) {
					for(BaseMetaclass baseMetaclass : extensionDefinition.getBaseMetaclasses())
						if(baseMetaclass.getBase() == ((BaseMetaclass)element).getBase()) {
							transformImpossibleIntoPossible(baseMetaclass);
						}
				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 * 
	 * @param element
	 * @param value
	 */
	@Override
	protected void setValue(final Object element, final Object value) {
		if(element instanceof BaseMetaclass) {

			if(EditionUtils.hasARequiredCombination((BaseMetaclass)element)) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), Messages.IsPossibleColumnEditingSupport_0, Messages.IsPossibleColumnEditingSupport_1);

			} else {

				ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
				try {
					dialog.run(false, false, new IRunnableWithProgress() {

						public void run(IProgressMonitor monitor) {
							monitor.beginTask(Messages.IsPossibleColumnEditingSupport_2, IProgressMonitor.UNKNOWN);

							if((Boolean)value == true) {
								transformAllImpossibleIntoPossible((BaseMetaclass)element);
							} else {
								transformAllPossibleIntoImpossible((BaseMetaclass)element);

							}

							Facade facade = ((BaseMetaclass)element).getExtensionDefinition().getFacade();

							// Clear incompatibilities that don't exist anymore
							EditionUtils.clearAllStereotypeCombinations(facade, editingDomain);
							// Init new incompatibilities
							EditionUtils.initAllStereotypeCombinations(facade, editingDomain);

							monitor.done();
						}
					});
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				getViewer().refresh();
			}
		}

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		if(element instanceof BaseMetaclass) {
			if(!((BaseMetaclass)element).getExtensionDefinition().getExtension().isRequired()) {
				return new CheckboxCellEditor(parent);
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected Object getValue(Object element) {
		if(element instanceof BaseMetaclass) {
			return Boolean.valueOf(((BaseMetaclass)element).isPossible());
		}
		return null;
	}

}
