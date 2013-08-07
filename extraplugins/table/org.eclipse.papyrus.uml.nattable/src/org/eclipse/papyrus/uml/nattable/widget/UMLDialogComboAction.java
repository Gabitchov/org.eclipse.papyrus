/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.widget;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.celleditor.AbstractComboAction;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.nattable.Activator;
import org.eclipse.papyrus.uml.nattable.dataprovider.UMLSingleReferenceComboBoxDataProvider;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * @author Vincent Lorenzo
 * 
 *         FIXME : maybe we could improve this action using AbstractDialogCellEditor
 */
public class UMLDialogComboAction extends AbstractComboAction {

	/**
	 * the edited element
	 */
	private Object axisElement;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param axisElement
	 *        the axis element
	 * @param dataProvider
	 *        the combo box data provider. it must be a UMLSingleReferenceComboBoxDataProvider
	 */
	public UMLDialogComboAction(final Object axisElement, IComboBoxDataProvider dataProvider) {
		super(dataProvider);
		assert dataProvider instanceof UMLSingleReferenceComboBoxDataProvider;
		this.axisElement = axisElement;
	}

	@Override
	public void run() {
		if(this.dataProvider instanceof UMLSingleReferenceComboBoxDataProvider) {
			final TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getDefault().getActiveShell());
			final Object rowElement = ((UMLSingleReferenceComboBoxDataProvider)this.dataProvider).getEditedEObject(this.columnIndex, this.rowIndex);
			final Object columnElement = ((UMLSingleReferenceComboBoxDataProvider)this.dataProvider).getEditedFeature(this.columnIndex, this.rowIndex);

			EObject realEditedObject = null;
			EStructuralFeature realFeature = null;

			Element editedElement = null;
			Object feature = this.axisElement;
			if(rowElement instanceof Element && columnElement == this.axisElement) {
				editedElement = (Element)rowElement;
			} else if(rowElement == this.axisElement && columnElement instanceof EObject) {
				editedElement = (Element)columnElement;
			}


			Stereotype stereotype = null;
			List<Stereotype> stereotypesWithEditedFeatureAppliedOnElement = null;
			if(feature instanceof EStructuralFeature) {
				realFeature = (EStructuralFeature)feature;
				realEditedObject = editedElement;
			} else {
				String id = AxisUtils.getPropertyId(feature);
				stereotypesWithEditedFeatureAppliedOnElement = UMLTableUtils.getAppliedStereotypesWithThisProperty(editedElement, id);
				stereotype = stereotypesWithEditedFeatureAppliedOnElement.get(0);
				realEditedObject = editedElement.getStereotypeApplication(stereotypesWithEditedFeatureAppliedOnElement.get(0));
				Property prop = UMLTableUtils.getRealStereotypeProperty(editedElement, id);
				realFeature = realEditedObject.eClass().getEStructuralFeature(prop.getName());
			}

			if(stereotypesWithEditedFeatureAppliedOnElement != null && stereotypesWithEditedFeatureAppliedOnElement.size() > 1) {
				//FIXME : not yet managed
				return;
			}
			dialog.setTitle(realFeature.getEType().getName());

			dialog.setLabelProvider(getLabelProvider(editedElement));
			int currentIndex = this.combo.getSelectionIndex();
			List<?> values = this.dataProvider.getValues(this.columnIndex, this.rowIndex);
			Object initialSelection = null;
			if(currentIndex != -1) {
				initialSelection = values.get(currentIndex);
			}
			final ITreeContentProvider provider = new UMLContentProvider(realEditedObject, realFeature, stereotype, editedElement.eResource().getResourceSet());
			dialog.setContentProvider(provider);
			if(initialSelection != null) {
				dialog.setInitialElementSelections(Collections.singletonList(initialSelection));
			}
			int res = dialog.open();
			if(res == Window.OK) {
				final Object[] result = dialog.getResult();
				int index = values.indexOf(result[0]);
				this.combo.select(index);
			}
		}
	}

	/**
	 * 
	 * @param context
	 *        the context used to find the label provider
	 * @return
	 *         the label provider
	 */
	protected ILabelProvider getLabelProvider(final EObject context) {
		ILabelProvider labelProvider = null;
		try {
			ServicesRegistry registry = ServiceUtilsForEObject.getInstance().getServiceRegistry(context);
			LabelProviderService labelproviderService = registry.getService(LabelProviderService.class);
			labelProvider = labelproviderService.getLabelProvider(context);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return labelProvider;
	}
}
