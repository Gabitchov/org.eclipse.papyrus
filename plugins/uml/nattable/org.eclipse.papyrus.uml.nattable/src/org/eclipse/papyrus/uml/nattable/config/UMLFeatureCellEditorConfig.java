/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.config;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDoubleDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.DisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.IComboBoxDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.editor.TextCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.config.EStructuralFeatureEditorConfig;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.uml.nattable.dataprovider.UMLStereotypeSingleEnumerationComboBoxDataProvider;
import org.eclipse.papyrus.uml.nattable.editor.MultiBooleanCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.MultiEnumCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.MultiIntegerCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.MultiRealCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.MultiReferenceCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.MultiStringCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.MultiUnlimitedNaturalCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.SingleReferenceValueCellEditor;
import org.eclipse.papyrus.uml.nattable.editor.StereotypeApplierDialogCellEditorWrapper;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.nattable.validator.RealDataValidator;
import org.eclipse.papyrus.uml.nattable.validator.UnlimitedNaturalDataValidator;
import org.eclipse.papyrus.uml.tools.utils.PrimitivesTypesUtils;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


public class UMLFeatureCellEditorConfig extends EStructuralFeatureEditorConfig {

	/**
	 * the id for this editor configuration
	 */
	public static final String EDITOR_CONFIG_ID = "UML_EDITOR_CONFIG";


	/**
	 * Definition of the id for the UML type
	 */
	public static final int SINGLE_REAL = 100;

	public static final int MULTI_REAL = SINGLE_REAL + 1;

	public static final int SINGLE_UNLIMITED_NATURAL = MULTI_REAL + 1;

	public static final int MULTI_UNLIMITED_NATURAL = SINGLE_UNLIMITED_NATURAL + 1;

	public static final int SINGLE_UML_ENUMERATION = MULTI_UNLIMITED_NATURAL + 1;

	public static final int MULTI_UML_ENUMERATION = SINGLE_UML_ENUMERATION + 1;

	public static final int SINGLE_UML_REFERENCE = MULTI_UML_ENUMERATION + 1;

	public static final int MULTI_UML_REFERENCE = SINGLE_UML_REFERENCE + 1;


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.config.AbstractEMFSingleFeatureSingleEditorConfig#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 *         <code>true</code> id the object is a UML feature or a representation of a property of stereotype
	 */
	@Override
	public boolean handles(Table table, Object axisElement) {
		boolean result = false;
		final String id = AxisUtils.getPropertyId(axisElement);
		if(id != null) {
			result = id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX);
		}
		if(!result) {
			result = super.handles(table, axisElement);
			if(result) {
				final EStructuralFeature feature = (EStructuralFeature)axisElement;
				final EObject featureContainer = feature.eContainer();
				result = UMLPackage.eINSTANCE.eContents().contains(featureContainer);
			}
		}
		return result;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.config.EStructuralFeatureEditorConfig#getICellEditor(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider)
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @return
	 */
	@Override
	public ICellEditor getICellEditor(Table table, Object axisElement, ITableAxisElementProvider elementProvider) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		ICellEditor editor = null;
		switch(editorKind) {
		case SINGLE_REAL:
		case SINGLE_UNLIMITED_NATURAL:
			editor = new TextCellEditor();
			break;
		case SINGLE_UML_REFERENCE:
			//			UMLSingleReferenceComboBoxDataProvider dataProvider = new UMLSingleReferenceComboBoxDataProvider(axisElement, elementProvider);
			//			UMLDialogComboAction action = new UMLDialogComboAction(axisElement, dataProvider);//TODO : try to replace the comboAction by a AbstractCellFileEditor...
			//			ButtonConfiguration conf = new ButtonConfiguration();
			//			//		conf.setImage(Activator.getDefault().getImage("/icons/browse_12x12.gif"));
			//			conf.setText("...");
			//			conf.setAction(action);
			//			conf.setTooltipText("Open a dialog to select the value");
			//			editor = new ComboBoxWithButtonCellEditor(dataProvider, conf);
			editor = new SingleReferenceValueCellEditor(axisElement, elementProvider);
			break;
		case SINGLE_UML_ENUMERATION:
			editor = new ComboBoxCellEditor(getComboDataProvider(table, axisElement, elementProvider));
			break;
		case MULTI_BOOLEAN:
			editor = new MultiBooleanCellEditor(axisElement, elementProvider);
			break;
		case MULTI_UNLIMITED_NATURAL:
			editor = new MultiUnlimitedNaturalCellEditor(axisElement, elementProvider);
			break;
		case MULTI_INTEGER:
			editor = new MultiIntegerCellEditor(axisElement, elementProvider);
			break;
		case MULTI_REAL:
			editor = new MultiRealCellEditor(axisElement, elementProvider);
			break;
		case MULTI_STRING:
			editor = new MultiStringCellEditor(axisElement, elementProvider);
			break;
		case MULTI_UML_REFERENCE:
			editor = new MultiReferenceCellEditor(axisElement, elementProvider);
			break;
		case MULTI_EENUM_TYPE:
			editor = new MultiEnumCellEditor(axisElement, elementProvider);
			break;
		case MULTI_UML_ENUMERATION:
			editor = new MultiEnumCellEditor(axisElement, elementProvider);
			break;
		default:
			editor = super.getICellEditor(table, axisElement, elementProvider);
			break;
		}
		// to apply required stereotype before editing in a dialog (which we can reasonably encapsulate in a command)
		// see bug 426709: [Table 2][Stereotype] Papyrus Table must allows to edit stereotype properties even if the required stereotypes is not yet applied
		//		  https://bugs.eclipse.org/bugs/show_bug.cgi?id=426709
		if(editor instanceof AbstractDialogCellEditor) {
			editor = new StereotypeApplierDialogCellEditorWrapper((AbstractDialogCellEditor)editor, axisElement, elementProvider);
		}
		return editor;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.config.EStructuralFeatureEditorConfig#getComboDataProvider(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider)
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @return
	 *         the combo data provider to use for the combo
	 */
	@Override
	protected IComboBoxDataProvider getComboDataProvider(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider) {
		IComboBoxDataProvider comboDataProvider = null;
		final String id;
		if(axisElement instanceof IdAxis) {
			id = ((IdAxis)axisElement).getElement();
		} else if(axisElement instanceof String) {
			id = (String)axisElement;
		} else {
			id = null;
		}
		if(id != null) {//it is a stereotype property
			comboDataProvider = new UMLStereotypeSingleEnumerationComboBoxDataProvider(axisElement, elementProvider);
		}
		if(comboDataProvider == null) {
			comboDataProvider = super.getComboDataProvider(table, axisElement, elementProvider);
		}
		return comboDataProvider;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.config.AbstractEMFSingleFeatureSingleEditorConfig#getFeatureIdentifier(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 *         the an id to identify the type of the element
	 */
	@Override
	protected int getFeatureIdentifier(Table table, Object axisElement) {
		int editorKind = UNKNOWN_TYPE;
		if(axisElement instanceof IAxis) {
			editorKind = getIAxisFeatureIdentifier(table, (IAxis)axisElement);
		} else if(axisElement instanceof String) {
			String id = (String)axisElement;
			if(id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX)) {
				editorKind = getStereotypeAxisFeatureIdentifier(table, id);
			}
		} else if(axisElement instanceof EStructuralFeature) {
			final EStructuralFeature feature = (EStructuralFeature)axisElement;
			final EClassifier etype = feature.getEType();
			final boolean isMany = feature.isMany();
			if(etype == TypesPackage.eINSTANCE.getString()) {
				if(isMany) {
					editorKind = MULTI_STRING;
				} else {
					editorKind = SINGLE_STRING;
				}
			} else if(etype == TypesPackage.eINSTANCE.getBoolean()) {
				if(isMany) {
					editorKind = MULTI_BOOLEAN;
				} else {
					editorKind = SINGLE_BOOLEAN;
				}
			} else if(etype == TypesPackage.eINSTANCE.getReal()) {
				if(isMany) {
					editorKind = MULTI_REAL;
				} else {
					editorKind = SINGLE_REAL;
				}
			} else if(etype == TypesPackage.eINSTANCE.getUnlimitedNatural()) {
				if(isMany) {
					editorKind = MULTI_UNLIMITED_NATURAL;
				} else {
					editorKind = SINGLE_UNLIMITED_NATURAL;
				}
			} else if(etype == TypesPackage.eINSTANCE.getInteger()) {
				if(isMany) {
					editorKind = MULTI_INTEGER;
				} else {
					editorKind = SINGLE_INTEGER;
				}
			} else if(EMFHelper.isSuperType(UMLPackage.eINSTANCE.getElement(), etype)) {
				if(isMany) {
					editorKind = MULTI_UML_REFERENCE;
				} else {
					editorKind = SINGLE_UML_REFERENCE;
				}
			}
			if(editorKind == UNKNOWN_TYPE) {
				editorKind = super.getFeatureIdentifier(table, axisElement);
			}
		}
		return editorKind;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param axis
	 *        the axis
	 * @return
	 *         the id for the type of stereotype property represented by the axis
	 */
	protected int getIAxisFeatureIdentifier(final Table table, final IAxis axis) {
		int editorKind = -1;
		if(axis instanceof IdAxis) {
			String id = ((IdAxis)axis).getElement();
			if(id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX)) {
				editorKind = getStereotypeAxisFeatureIdentifier(table, id);
			}
		}
		return editorKind;
	}

	/**
	 * 
	 * @param table
	 *        the table
	 * @param id
	 *        the id of the edited property of stereotype
	 * @return
	 */
	protected int getStereotypeAxisFeatureIdentifier(final Table table, final String id) {
		int editorKind = -1;
		if(id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX)) {
			final Property prop = UMLTableUtils.getRealStereotypeProperty(table.getContext(), id);
			if(prop != null && prop.getType() != null) {
				boolean isMany = prop.isMultivalued();
				final Type type = prop.getType();
				if(type instanceof DataType) {
					if(type instanceof PrimitiveType) {
						final String name = type.getName();
						if(PrimitivesTypesUtils.UML_BOOLEAN.equals(name)) {
							if(isMany) {
								editorKind = MULTI_BOOLEAN;
							} else {
								editorKind = SINGLE_BOOLEAN;
							}
						} else if(PrimitivesTypesUtils.UML_INTEGER.equals(name)) {
							if(isMany) {
								editorKind = MULTI_INTEGER;
							} else {
								editorKind = SINGLE_INTEGER;
							}
						} else if(PrimitivesTypesUtils.UML_REAL.equals(name)) {
							if(isMany) {
								editorKind = MULTI_REAL;
							} else {
								editorKind = SINGLE_REAL;
							}
						} else if(PrimitivesTypesUtils.UML_STRING.equals(name)) {
							if(isMany) {
								editorKind = MULTI_STRING;
							} else {
								editorKind = SINGLE_STRING;
							}
						} else if(PrimitivesTypesUtils.UML_UNLIMITED_NATURAL.equals(name)) {
							if(isMany) {
								editorKind = MULTI_UNLIMITED_NATURAL;
							} else {
								editorKind = SINGLE_UNLIMITED_NATURAL;
							}
						} else {
							//custom primitive type are managed as string
							if(isMany) {
								editorKind = MULTI_STRING;
							} else {
								editorKind = SINGLE_STRING;
							}
						}
					} else if(type instanceof Enumeration) {
						if(isMany) {
							editorKind = MULTI_UML_ENUMERATION;
						} else {
							editorKind = SINGLE_UML_ENUMERATION;
						}
					} else {//datatype are managed as string
						//currently the datatype are not managed because we are working on it!
						//						if(isMany) {
						//							editorKind = MULTI_STRING;
						//						} else {
						//							editorKind = SINGLE_STRING;
						//						}
					}
				} else if(type instanceof Element) {
					if(isMany) {
						editorKind = MULTI_UML_REFERENCE;
					} else {
						editorKind = SINGLE_UML_REFERENCE;
					}
				}
			}
		}
		return editorKind;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.config.EStructuralFeatureEditorConfig#getCellPainter(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	public ICellPainter getCellPainter(Table table, Object axisElement) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		ICellPainter painter = null;
		switch(editorKind) {
		case SINGLE_REAL:
		case SINGLE_UNLIMITED_NATURAL:
			painter = new TextPainter();
			break;
		default:
			painter = super.getCellPainter(table, axisElement);
			break;
		}
		return painter;
	}

	/**
	 * 
	 * @param table
	 * @param axisElement
	 * @param provider
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.config.EStructuralFeatureEditorConfig#getDisplayConvert(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object, org.eclipse.jface.viewers.ILabelProvider)
	 * 
	 * @return
	 */
	@Override
	public IDisplayConverter getDisplayConvert(Table table, Object axisElement, final ILabelProvider provider) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		IDisplayConverter converter = null;
		switch(editorKind) {
		case SINGLE_REAL:
			converter = new DefaultDoubleDisplayConverter();
			break;
		case SINGLE_UML_REFERENCE:
			converter = new DisplayConverter() {

				@Override
				public Object displayToCanonicalValue(Object displayValue) {
					return null;
				}

				@Override
				public Object canonicalToDisplayValue(Object canonicalValue) {//TODO : we should use the table label provider to do the conversion!
					if(canonicalValue instanceof DynamicEObjectImpl) {
						EStructuralFeature feature = ((DynamicEObjectImpl)canonicalValue).eClass().getEStructuralFeature("base_Class");
						return provider.getText(((DynamicEObjectImpl)canonicalValue).eGet(feature));
					}
					return provider.getText(canonicalValue);
				}
			};
			break;
		case MULTI_UML_REFERENCE:
			converter = new DefaultDisplayConverter() {

				@Override
				public Object displayToCanonicalValue(ILayerCell cell, IConfigRegistry configRegistry, Object displayValue) {
					return displayValue;
				}
			};
			break;
		case SINGLE_UNLIMITED_NATURAL:
			converter = new DefaultDisplayConverter() {

				@Override
				public Object canonicalToDisplayValue(Object sourceValue) {//TODO : we should use the table label provider to do the conversion!
					if(sourceValue.equals(new Integer(-1))) {
						return "*";
					}
					return sourceValue;
				}

				@Override
				public Object displayToCanonicalValue(Object destinationValue) {
					if(destinationValue.equals("*")) {
						return new Integer(-1);
					}
					return new Integer((String)destinationValue);
				}
			};
			break;
		default:
			converter = super.getDisplayConvert(table, axisElement, provider);
			break;
		}
		return converter;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.config.EStructuralFeatureEditorConfig#getDataValidator(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	public IDataValidator getDataValidator(Table table, Object axisElement) {
		int editorKind = getFeatureIdentifier(table, axisElement);
		IDataValidator converter = null;
		switch(editorKind) {
		case SINGLE_REAL:
			converter = new RealDataValidator();
			break;
		case SINGLE_UNLIMITED_NATURAL:
			converter = new UnlimitedNaturalDataValidator();
			break;
		default:
			converter = super.getDataValidator(table, axisElement);
			break;
		}
		return converter;
	}

	@Override
	public String getEditorConfigId() {
		return EDITOR_CONFIG_ID;
	}
}
