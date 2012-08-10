/*****************************************************************************
 * Copyright (c) 2012 Atos.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.widgets;

import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFEnumeratorContentProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.editors.AbstractValueEditor;
import org.eclipse.papyrus.infra.widgets.editors.BooleanCombo;
import org.eclipse.papyrus.infra.widgets.editors.DoubleEditor;
import org.eclipse.papyrus.infra.widgets.editors.EnumCombo;
import org.eclipse.papyrus.infra.widgets.editors.FloatEditor;
import org.eclipse.papyrus.infra.widgets.editors.IntegerEditor;
import org.eclipse.papyrus.infra.widgets.editors.LongEditor;
import org.eclipse.papyrus.infra.widgets.editors.MultipleIntegerEditor;
import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.infra.widgets.editors.MultipleStringEditor;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueEditor;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableList;
import org.eclipse.papyrus.uml.tools.databinding.PapyrusObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.PageBook;


public class EStructuralFeatureEditor implements IValueChangeListener, IListChangeListener {

	protected PageBook pageBook;

	protected Composite currentPage;

	protected int style = 0;

	protected IStaticContentProvider contentProvider;

	protected ILabelProvider labelProvider;

	protected ReferenceValueFactory valueFactory;
	
	protected IChangeListener changeListener;

	public EStructuralFeatureEditor(Composite parent, int style) {
		this.style = style;
		pageBook = new PageBook(parent, style);
		currentPage = createEmptyPage();
		pageBook.showPage(currentPage);
	}
	
	public void setProviders(IStaticContentProvider contentProvider, ILabelProvider labelProvider) {
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
	}
	
	public void setValueFactory(ReferenceValueFactory valueFactory) {
		this.valueFactory = valueFactory;
	}
	
	public void setChangeListener(IChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	protected Composite createEmptyPage() {
		return new Composite(pageBook, style);
	}

	public void setFeatureToEdit(EStructuralFeature feature, EObject element) {
		if(currentPage != null) {
			currentPage.dispose();
		}

		if(feature instanceof EReference) {
			if(feature.isMany()) {
				MultipleReferenceEditor editor = new MultipleReferenceEditor(pageBook, style);
				setMultipleValueEditorProperties(editor, (List<?>)element.eGet(feature), element, feature);

				editor.setProviders(contentProvider, labelProvider);
				editor.setFactory(valueFactory);
				currentPage = editor;
			} else {
				ReferenceDialog editor = new ReferenceDialog(pageBook, style);
				setValueEditorProperties(editor, element, feature);

				editor.setContentProvider(contentProvider);
				editor.setLabelProvider(labelProvider);
				editor.setValueFactory(valueFactory);

				editor.setDirectCreation(((EReference)feature).isContainment());
				currentPage = editor;
			}
		}

		if(feature instanceof EAttribute) {
			EClassifier type = feature.getEType();
			if(type instanceof EEnum) {
				if(feature.isMany()) {
					MultipleReferenceEditor editor = new MultipleReferenceEditor(pageBook, style);
					setMultipleValueEditorProperties(editor, (List<?>)element.eGet(feature), element, feature);

					editor.setProviders(contentProvider, labelProvider);
					editor.setFactory(valueFactory);
					currentPage = editor;
						
				} else {
					EnumCombo editor = new EnumCombo(pageBook, style);
					setValueEditorProperties(editor, element, feature);
					editor.setContentProvider(new EMFEnumeratorContentProvider(feature));
					currentPage = editor;
				}
			} else if(type instanceof EDataType) {
				String instanceClassName = ((EDataType)type).getInstanceClassName();
				if("java.lang.String".equalsIgnoreCase(instanceClassName) || "string".equalsIgnoreCase(instanceClassName)) {
					if(feature.isMany()) {
						MultipleStringEditor editor = new MultipleStringEditor(pageBook, style, true);
						setMultipleValueEditorProperties(editor, (List<?>)element.eGet(feature), element, feature);
						currentPage = editor;
					} else {
						StringEditor editor = new StringEditor(pageBook, style | SWT.MULTI);
						setValueEditorProperties(editor, element, feature);
						currentPage = editor;
					}
				} else if("java.lang.Integer".equalsIgnoreCase(instanceClassName) || "integer".equalsIgnoreCase(instanceClassName) || "int".equalsIgnoreCase(instanceClassName)) {
					if(feature.isMany()) {
						MultipleIntegerEditor editor = new MultipleIntegerEditor(pageBook, style);
						setMultipleValueEditorProperties(editor, (List<?>)element.eGet(feature), element, feature);
						currentPage = editor;
					} else {
						IntegerEditor editor = new IntegerEditor(pageBook, style);
						setValueEditorProperties(editor, element, feature);
						currentPage = editor;
					}
				} else if("java.lang.Boolean".equals(instanceClassName) || "boolean".equalsIgnoreCase(instanceClassName) || "bool".equalsIgnoreCase(instanceClassName)) {
					if(feature.isMany()) {
						// TODO widget not available
					} else {
						BooleanCombo editor = new BooleanCombo(pageBook, style);
						setValueEditorProperties(editor, element, feature);
						currentPage = editor;
					}
				} else if("java.lang.Float".equals(instanceClassName) || "float".equalsIgnoreCase(instanceClassName)) {
					if(feature.isMany()) {
						// TODO widget not available
					} else {
						FloatEditor editor = new FloatEditor(pageBook, style);
						setValueEditorProperties(editor, element, feature);
						currentPage = editor;
					}
				} else if("java.lang.Double".equals(instanceClassName) || "double".equalsIgnoreCase(instanceClassName)) {
					if(feature.isMany()) {
						// TODO widget not available
					} else {
						DoubleEditor editor = new DoubleEditor(pageBook, style);
						setValueEditorProperties(editor, element, feature);
						currentPage = editor;
					}
				}
				else if("java.lang.Long".equals(instanceClassName) || "long".equalsIgnoreCase(instanceClassName)) {
					if(feature.isMany()) {
						// TODO widget not available
					} else {
						LongEditor editor = new LongEditor(pageBook, style);
						setValueEditorProperties(editor, element, feature);
						currentPage = editor;
					}
				}
			}
		}
		
		if (currentPage == null) {
			currentPage = createEmptyPage();
		}

		pageBook.showPage(currentPage);
	}

	protected void setValueEditorProperties(AbstractValueEditor editor, EObject stereotypeApplication, EStructuralFeature feature) {
		editor.setLabel(feature.getName());

		if(feature.isDerived() || !feature.isChangeable()) {
			editor.setReadOnly(true);
		}

		PapyrusObservableValue observable = new PapyrusObservableValue(stereotypeApplication, feature, EMFHelper.resolveEditingDomain(stereotypeApplication));

		editor.setModelObservable(observable);

		observable.addValueChangeListener(this);
	}

	protected void setMultipleValueEditorProperties(MultipleValueEditor editor, List<?> initialList, EObject stereotypeApplication, EStructuralFeature feature) {
		editor.setLabel(feature.getName());
		editor.setUnique(feature.isUnique());
		editor.setOrdered(feature.isOrdered());
		editor.setUpperBound(feature.getUpperBound());
		if (feature instanceof EReference) {
			editor.setDirectCreation(((EReference)feature).isContainment());
		}

		if(feature.isDerived() || !feature.isChangeable()) {
			editor.setReadOnly(true);
		}

		PapyrusObservableList observable = new PapyrusObservableList(initialList, EMFHelper.resolveEditingDomain(stereotypeApplication), stereotypeApplication, feature);

		editor.setModelObservable(observable);
		editor.addCommitListener(observable);

		observable.addListChangeListener(this);
	}

	public void setLayoutData(GridData data) {
		pageBook.setLayoutData(data);
	}

	public void handleValueChange(ValueChangeEvent event) {
		if (changeListener != null) {
			changeListener.handleChange(new ChangeEvent(event.getObservable()));
		}
	}

	public void handleListChange(ListChangeEvent event) {
		if (changeListener != null) {
			changeListener.handleChange(new ChangeEvent(event.getObservable()));
		}
	}
}
