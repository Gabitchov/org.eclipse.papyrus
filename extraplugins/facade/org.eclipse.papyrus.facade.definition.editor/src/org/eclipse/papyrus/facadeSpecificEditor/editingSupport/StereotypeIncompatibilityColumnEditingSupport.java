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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionFactory;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;
import org.eclipse.papyrus.facadeSpecificEditor.FacadeSpecificEditor;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class StereotypeIncompatibilityColumnEditingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public StereotypeIncompatibilityColumnEditingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	/**
	 * Change a compatibility between stereotype application to incompatible in the model
	 * 
	 * @param baseMetaclass
	 * @param combinaison
	 */
	protected void transformCompatibleIntoIncompatible(BaseMetaclass baseMetaclass, Combination combinaison) {
		AddCommand command = new AddCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(command);
		RemoveCommand removeCommand = new RemoveCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(removeCommand);
	}

	/**
	 * Change a compatibility between stereotype application to incompatible in the model
	 * 
	 * @param baseMetaclass
	 * @param combinaison
	 */
	protected void transformAllCompatibleIntoIncompatible(BaseMetaclass baseMetaclass, Combination combinaison) {

		transformCompatibleIntoIncompatible(baseMetaclass, combinaison);
	}

	/**
	 * Change a compatibility between stereotype application to compatible in the model
	 * 
	 * @param baseMetaclass
	 * @param combinaison
	 */
	protected void transformImcompatibleIntoCompatible(BaseMetaclass baseMetaclass, Combination combinaison) {
		RemoveCommand removeCommand = new RemoveCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_IncompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(removeCommand);
		AddCommand addCommand = new AddCommand(editingDomain, baseMetaclass, ExtensiondefinitionPackage.eINSTANCE.getBaseMetaclass_CompatibleStereotypes(), combinaison); //$NON-NLS-1$
		editingDomain.getCommandStack().execute(addCommand);
	}

	/**
	 * Change a compatibility between stereotype application to compatible in the model
	 * 
	 * @param baseMetaclass
	 * @param combinaison
	 */
	protected void transformAllImcompatibleIntoCompatible(BaseMetaclass baseMetaclass, Combination combinaison) {

		transformImcompatibleIntoCompatible(baseMetaclass, combinaison);
	}

	/**
	 * Used to propagate compatibilities and incompatibilities among stereotype applications
	 * 
	 * @param combination
	 * @param iAmNotARequired
	 */
	protected void proceedTheOtherWayCompatibleIntoIncompatible(Combination combination, boolean iAmNotARequired) {

		for(BaseMetaclass meta : ((Combination)combination).getMembers()) {
			// Build fake Combination that contain all the basemetaclass of the combinaison except the basemetaclass we are processing
			Combination fakeCombination = ExtensiondefinitionFactory.eINSTANCE.createCombination();
			for(BaseMetaclass metaFake : ((Combination)combination).getMembers()) {
				if(meta != metaFake) {
					fakeCombination.getMembers().add(metaFake);
				}
			}
			// fake Combination + the general basemetaclass that own this combinaison
			if(iAmNotARequired) {
				BaseMetaclass containerBaseMetaClass = (BaseMetaclass)((Combination)combination).eContainer();
				BaseMetaclass general = containerBaseMetaClass;
				fakeCombination.getMembers().add(general);
			}

			// if (!EditionUtils.containsOnlyRequired(fakeCombination)) {
			// We go through the compatible combinaison of this basemeta and try to find the fake
			Combination combinaison = EditionUtils.getCombinationThatMatch(meta.getCompatibleStereotypes(), fakeCombination);
			if(combinaison != null) {
				transformAllCompatibleIntoIncompatible(meta, combinaison);
			} else {
				org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.StereotypeIncompatibilityColumnEditingSupport_0);
			}
			// }
		}
	}

	/**
	 * Used to propagate compatibilities and incompatibilities among stereotype applications
	 * 
	 * @param combination
	 * @param iAmNotARequired
	 */
	protected void proceedTheOtherWayImcompatibleIntoCompatible(Combination combination, boolean iAmNotARequired) {
		for(BaseMetaclass meta : ((Combination)combination).getMembers()) {
			// Build fake Combination that contain all the basemetaclass of the combinaison except the basemetaclass we are processing
			Combination fakeCombination = ExtensiondefinitionFactory.eINSTANCE.createCombination();
			for(BaseMetaclass metaFake : ((Combination)combination).getMembers()) {
				if(meta != metaFake) {
					fakeCombination.getMembers().add(metaFake);
				}
			}
			// fake Combination + the basemetaclass that own this combinaison
			if(iAmNotARequired) {
				BaseMetaclass containerBaseMetaClass = (BaseMetaclass)((Combination)combination).eContainer();
				//				BaseMetaclass general = findCorrespondingGeneral(containerBaseMetaClass);
				BaseMetaclass general = containerBaseMetaClass;
				fakeCombination.getMembers().add(general);
			}

			// if (!EditionUtils.containsOnlyRequired(fakeCombination)) {
			// We go through the incompatible combinaison of this basemeta and try to find the fake
			Combination combinaison = EditionUtils.getCombinationThatMatch(meta.getIncompatibleStereotypes(), fakeCombination);
			if(combinaison != null) {
				transformAllImcompatibleIntoCompatible(meta, combinaison);
			} else {
				org.eclipse.papyrus.facadeSpecificEditor.FacadeDefinitionEditorActivator.log.info(Messages.StereotypeIncompatibilityColumnEditingSupport_1);
			}
			// }

		}
	}

	/**
	 * Set a combination of stereotype application to incompatible
	 * 
	 * @param baseMetaclass
	 * @param combination
	 * @param bothWays
	 */
	protected void makeItImcompatible(BaseMetaclass baseMetaclass, Combination combination, boolean bothWays) {
		transformAllCompatibleIntoIncompatible(baseMetaclass, combination);
		proceedTheOtherWayCompatibleIntoIncompatible(combination, true);
	}

	/**
	 * Set a combination of stereotype application to compatible
	 * 
	 * @param baseMetaclass
	 * @param combination
	 * @param bothWays
	 */
	protected void makeItCompatible(BaseMetaclass baseMetaclass, Combination combination, boolean bothWays) {
		transformAllImcompatibleIntoCompatible(baseMetaclass, (Combination)combination);
		proceedTheOtherWayImcompatibleIntoCompatible(combination, true);
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
		if(element instanceof Combination) {

			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try {
				dialog.run(false, false, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) {
						monitor.beginTask(Messages.StereotypeIncompatibilityColumnEditingSupport_2, IProgressMonitor.UNKNOWN);

						ISelection selection = FacadeSpecificEditor.getExtensionDefintionTreeViewer().getSelection();
						if(selection instanceof IStructuredSelection) {
							Object first = ((IStructuredSelection)selection).getFirstElement();

							if(first instanceof BaseMetaclass) {
								BaseMetaclass baseMetaclass = (BaseMetaclass)first;

								if((Boolean)value == false) {
									makeItImcompatible(baseMetaclass, (Combination)element, true);
								} else {
									// Make it compatible
									makeItCompatible(baseMetaclass, (Combination)element, true);

								}

							}
						}

						monitor.done();
					}
				});
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			getViewer().refresh();
			FacadeSpecificEditor.getExtensionDefintionTreeViewer().refresh();
		}
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
		if(element instanceof Combination) {
			ISelection selection = FacadeSpecificEditor.getExtensionDefintionTreeViewer().getSelection();
			if(selection instanceof IStructuredSelection) {
				Object first = ((IStructuredSelection)selection).getFirstElement();

				if(first instanceof BaseMetaclass) {
					EList<Combination> incompatibleStereotypes = ((BaseMetaclass)first).getIncompatibleStereotypes();
					if(incompatibleStereotypes.contains(element)) {
						return Boolean.valueOf(false);
					} else {
						return Boolean.valueOf(true);
					}
				}
			}

		}
		return null;
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
		return new CheckboxCellEditor(parent);
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

}
