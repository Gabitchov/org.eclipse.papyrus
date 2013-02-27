package org.eclipse.papyrus.uml.nattable.celleditor.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.edit.gui.AbstractDialogCellEditor;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum;
import org.eclipse.nebula.widgets.nattable.widget.EditModeEnum;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;


public class MultiReferencesCellEditor extends AbstractDialogCellEditor {

	private Collection<Object> returnedValue;

	private ITableAxisElementProvider manager;

	public MultiReferencesCellEditor(final ITableAxisElementProvider elementProvider) {
		this.manager = elementProvider;
	};

	@Override
	public int open() {
		return ((MultipleValueSelectorDialog)dialog).open();
	}

	@Override
	public Object createDialogInstance() {
		int columnIndex = layerCell.getColumnIndex();
		int rowIndex = layerCell.getRowIndex();
		final Object row = this.manager.getRowElement(rowIndex);
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

		UMLContentProvider p = new UMLContentProvider(el, realFeature, null, el.eResource().getResourceSet());


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
				Object[] result = ((MultipleValueSelectorDialog)dialog).getResult();
				for(Object object : result) {
					newValue.add(object);

				}
				returnedValue = newValue;
				editHandler.commit(newValue, MoveDirectionEnum.NONE);
			}

		};
		((MultipleValueSelectorDialog)dialog).setLabelProvider(new UMLLabelProvider());
		if(value != null && value instanceof Collection) {
			Collection<?> coll = (Collection<?>)value;
			if(!coll.isEmpty()) {
				((MultipleValueSelectorDialog)dialog).setInitialSelections(coll.toArray());
			}
		}
		return dialog;
	}

	@Override
	public Object getDialogInstance() {
		return dialog;
	}

	@Override
	public Object getEditorValue() {
		return returnedValue;
	}

	@Override
	public void setEditorValue(Object value) {
	}

	@Override
	public void close() {
	}

	@Override
	public boolean isClosed() {
		return false;
	}
}
