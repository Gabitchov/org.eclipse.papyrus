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
package org.eclipse.papyrus.infra.emf.nattable.celleditor.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultBooleanDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultIntegerDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.editor.CheckBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.editor.TextCellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.ComboBoxPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.painter.CustomCheckBoxPainter;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.celleditor.configs.AbstractCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * The configuration to edit EMF properties
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EStructuralFeatureEditorConfig extends AbstractCellEditorConfiguration {

	/**
	 * the id of the editor config
	 */
	public static final String EDITOR_CONFIG_ID = "EMF_EDITOR";

	/**
	 * the int used to identify the kind of editor
	 */
	public static final int UNKNOWN_TYPE = -1;

	public static final int SINGLE_BOOLEAN = 1;

	public static final int MULTI_BOOLEAN = SINGLE_BOOLEAN + 1;

	public static final int SINGLE_STRING = MULTI_BOOLEAN + 1;

	public static final int MULTI_STRING = SINGLE_STRING + 1;

	public static final int SINGLE_INTEGER = MULTI_STRING + 1;

	public static final int MULTI_INTEGER = SINGLE_INTEGER + 1;

	public static final int SINGLE_EENUM_TYPE = MULTI_INTEGER + 1;

	public static final int MULTI_EENUM_TYPE = SINGLE_EENUM_TYPE + 1;

	public static final int SINGLE_EMF_REFERENCE = MULTI_EENUM_TYPE + 1;

	public static final int MULTI_EMF_REFERENCE = SINGLE_EMF_REFERENCE + 1;


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#getICellEditor(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.ITableAxisElementProvider)
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @return
	 */
	public ICellEditor getICellEditor(Table table, final Object axisElement, final ITableAxisElementProvider elementProvider) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		ICellEditor editor = null;
		switch(editorKind) {
		case SINGLE_STRING:
		case SINGLE_INTEGER:
			editor = new TextCellEditor();
			break;
		case SINGLE_BOOLEAN:
			editor = new CheckBoxCellEditor();
			break;
		case SINGLE_EENUM_TYPE:
			editor = new ComboBoxCellEditor(new IComboBoxDataProvider() {//FIXME add a method to get the dataprovider!


				public List<?> getValues(int columnIndex, int rowIndex) {
					Object el = elementProvider.getColumnElement(columnIndex);
					//					Object el = elementProvider.getColumnElement(columnIndex);
					List<Object> literals = new ArrayList<Object>();
					for(final EEnumLiteral instances : ((EEnum)((EStructuralFeature)axisElement).getEType()).getELiterals()) {
						literals.add(instances.getInstance());
					}
					return literals;
				}
			});
			break;
		default:
		}
		return editor;
	}



	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#getEditorId()
	 * 
	 * @return
	 */
	public String getEditorId() {
		return EDITOR_CONFIG_ID;
	}

	/**
	 * Return the combo data provider. This method is not in the interface, because it can't be generalized to all editors. It is used only by
	 * ComboBox
	 * 
	 * @param table
	 *        the edited table
	 * @param axisElement
	 *        the axis element
	 * @param elementProvider
	 *        the element provider
	 * @return
	 *         the combo data provider
	 */
	protected IComboBoxDataProvider getComboDataProvider(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider) {
		return null;
	}

	/**
	 * @param provider
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.conf#getDisplayConvert(Object, Table, org.eclipse.jface.viewers.ILabelProvider)
	 * 
	 * @return
	 */

	public IDisplayConverter getDisplayConvert(Object axisElement, Table table, final ILabelProvider provider) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		IDisplayConverter displayConverter = null;
		switch(editorKind) {
		case SINGLE_BOOLEAN:
			displayConverter = new DefaultBooleanDisplayConverter();
			break;
		case SINGLE_INTEGER:
			displayConverter = new DefaultIntegerDisplayConverter();
			break;
		case SINGLE_EENUM_TYPE:
			displayConverter = new DisplayConverter() {

				@Override
				public Object displayToCanonicalValue(Object displayValue) {
					return null;
				}

				@Override
				public Object canonicalToDisplayValue(Object canonicalValue) {
					return provider.getText(canonicalValue);
				}
			};
			break;
		default:
		}
		return displayConverter;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#getCellPainter(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 */
	public ICellPainter getCellPainter(Table table, Object axisElement) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		ICellPainter cellPainter = null;
		switch(editorKind) {
		case SINGLE_BOOLEAN:
			cellPainter = new CustomCheckBoxPainter();
			break;
		case SINGLE_EENUM_TYPE:
			cellPainter = new ComboBoxPainter();
			break;
		default:
			cellPainter = new TextPainter();
			break;
		}
		return cellPainter;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#getDisplayMode(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 */
	public String getDisplayMode(Table table, Object axisElement) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		String displayMode = DisplayMode.EDIT;
		switch(editorKind) {
		case SINGLE_BOOLEAN:
			displayMode = DisplayMode.NORMAL;
			break;
		default:
		}
		return displayMode;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.AbstractCellEditorConfiguration#getDataValidator(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	public IDataValidator getDataValidator(Table table, Object axisElement) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		IDataValidator validator = null;
		switch(editorKind) {
		default:
		}
		return validator;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 *         <code>true</code> if axisElement is a {@link EStructuralFeature}
	 */
	public boolean handles(Table table, Object axisElement) {
		return axisElement instanceof EStructuralFeature;
	}

	/**
	 * 
	 * @param table
	 *        the edited table
	 * @param axisElement
	 *        the edited feature
	 * @return
	 *         an integer which identify the type of the feature or {@value #UNKNOWN_TYPE} if we can't found it
	 */
	protected int getFeatureIdentifier(final Table table, final Object axisElement) {
		int editorKind = UNKNOWN_TYPE;
		assert axisElement instanceof EStructuralFeature;
		final EStructuralFeature feature = (EStructuralFeature)axisElement;
		final EClassifier eType = feature.getEType();
		boolean isMany = feature.isMany();
		if(eType instanceof EEnum) {
			if(isMany) {
				editorKind = MULTI_EENUM_TYPE;
			} else {
				editorKind = SINGLE_EENUM_TYPE;
			}
		} else if(eType instanceof EDataType) {

		} else if(EMFHelper.isSuperType(EcorePackage.eINSTANCE.getEObject(), eType)) {
			if(isMany) {
				editorKind = MULTI_EMF_REFERENCE;
			} else {
				editorKind = SINGLE_EMF_REFERENCE;
			}
		}
		return editorKind;
	}
}
