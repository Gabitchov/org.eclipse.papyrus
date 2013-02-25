package org.eclipse.papyrus.uml.nattable.celleditor.editor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.nebula.widgets.nattable.edit.editor.AbstractCellEditor;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum;
import org.eclipse.nebula.widgets.nattable.widget.EditModeEnum;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
//import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
//import org.eclipse.papyrus.uml.profilefacet.utils.StereotypePropertyUtils;
//import org.eclipse.papyrus.uml.table.widget.celleditors.utils.StereotypePropertyFacetElementUtils;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class MultiReferenceCellEditor extends AbstractCellEditor {

	private MultipleValueSelectorDialog dialog;

	private INattableModelManager manager;

	private Object returnedValue;

	private Composite placeholderComposite;

	public MultiReferenceCellEditor(final INattableModelManager manager) {
		this.manager = manager;
		this.editMode = EditModeEnum.DIALOG;
	}

	@Override
	public Object getEditorValue() {
		placeholderComposite.dispose();//FIXME a vérifier
		return returnedValue;
	}

	@Override
	public void setEditorValue(Object value) {
		this.returnedValue = value;
	}

	@Override
	public Control getEditorControl() {
		return placeholderComposite;
	}

	@Override
	public Control createEditorControl(Composite parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Control activateCell(Composite parent, Object originalCanonicalValue) {
		placeholderComposite = new Composite(parent, SWT.NONE);
		layer = layerCell.getLayer();
		int columnIndex = layerCell.getColumnIndex();
		int rowIndex = layerCell.getRowIndex();
		final Object row = this.manager.getRowElemen(rowIndex);
		final Object column = this.manager.getColumnElement(columnIndex);
		Element el = null;
		EStructuralFeature realFeature = null;
		if(row instanceof EObject) {
			el = (Element)row;
			realFeature = (EStructuralFeature)column;
		} else {
			el = (Element)column;
			realFeature = (EStructuralFeature)row;
		}


		//		final EObject realSource = StereotypePropertyFacetElementUtils.getRealSource(source, feature);
		//		final EStructuralFeature realFeature = StereotypePropertyFacetElementUtils.getRealFeature(source, feature);
		final UMLContentProvider p;
		//		if(feature instanceof StereotypePropertyElement) {
		//			assert source instanceof Element;
		//			final Stereotype ste = StereotypePropertyUtils.getAppliedStereotype((Element)source, (StereotypePropertyElement)feature);
		//			p = new UMLContentProvider(realSource, realFeature, ste, source.eResource().getResourceSet());
		//		} else {
		p = new UMLContentProvider(el, realFeature, null, el.eResource().getResourceSet());
		//		}

		final String title = realFeature.getName();
		final boolean unique = realFeature.isUnique();
		final boolean ordered = realFeature.isOrdered();
		final int upperBound = realFeature.getUpperBound();
		final ReferenceSelector selector = new ReferenceSelector(unique);
		selector.setContentProvider(p);
		selector.setLabelProvider(new UMLLabelProvider());
		final Object value = (Collection<?>)el.eGet(realFeature);

		dialog = new MultipleValueSelectorDialog(Display.getCurrent().getActiveShell(), selector, title, unique, ordered, upperBound) {

			@Override
			protected void okPressed() {
				super.okPressed();
				Collection<Object> newValue = new ArrayList<Object>();
				Object[] result = dialog.getResult();
				for(Object object : result) {
					newValue.add(object);
					
				}
				returnedValue = newValue;
				commit(MoveDirectionEnum.NONE, true);
				//				g
				//				editHandler.commit();
			}

			@Override
			public boolean close() {
				//				placeholderComposite.dispose();
				return super.close();
			}

			@Override
			protected void cancelPressed() {
				super.cancelPressed();
			}
		};
		dialog.setLabelProvider(new UMLLabelProvider());
		if(value != null && value instanceof Collection) {
			Collection<?> coll = (Collection<?>)value;
			if(!coll.isEmpty()) {
				dialog.setInitialSelections(coll.toArray());
			}
		}

		dialog.open();

		return placeholderComposite;
	}



}
