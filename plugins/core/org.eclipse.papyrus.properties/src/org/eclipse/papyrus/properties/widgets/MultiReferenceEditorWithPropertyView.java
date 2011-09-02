package org.eclipse.papyrus.properties.widgets;

import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.properties.runtime.EmbeddedDisplayEngine;
import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.widgets.editors.AbstractListEditor;
import org.eclipse.papyrus.widgets.editors.MultipleReferenceEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


public class MultiReferenceEditorWithPropertyView extends AbstractListEditor implements ISelectionChangedListener {

	protected MultipleReferenceEditor multiReferenceEditor;

	protected Composite propertiesComposite;

	protected EmbeddedDisplayEngine displayEngine = new EmbeddedDisplayEngine();

	public MultiReferenceEditorWithPropertyView(Composite parent, int style) {
		super(parent, style);
		((GridLayout)getLayout()).numColumns++;

		multiReferenceEditor = new MultipleReferenceEditor(this, style);
		multiReferenceEditor.addSelectionChangedListener(this);
		multiReferenceEditor.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));

		propertiesComposite = new Composite(this, style);
		propertiesComposite.setLayout(new FillLayout());
		propertiesComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Override
	public Object getEditableType() {
		return Object.class;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		multiReferenceEditor.setReadOnly(readOnly);
		propertiesComposite.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return multiReferenceEditor.isReadOnly();
	}

	@Override
	public void setToolTipText(String text) {
		multiReferenceEditor.setToolTipText(text);
	}

	@Override
	public void setLabel(String label) {
		multiReferenceEditor.setLabel(label);
	}

	public void setOrdered(boolean ordered) {
		multiReferenceEditor.setOrdered(ordered);
	}

	public void setUnique(boolean unique) {
		multiReferenceEditor.setUnique(unique);
	}

	@Override
	public void setModelObservable(IObservableList modelObservable) {
		multiReferenceEditor.setModelObservable(modelObservable);
	}

	@Override
	public void dispose() {
		super.dispose();
		multiReferenceEditor.removeSelectionChangedListener(this);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();

		Set<View> views = ConfigurationManager.instance.constraintEngine.getViews(selection);
		displayEngine.display(views, propertiesComposite, selection, SWT.NONE);
	}

	public void setFactory(ReferenceValueFactory valueFactory) {
		multiReferenceEditor.setFactory(valueFactory);
	}

	public void setDirectCreation(boolean directCreation) {
		multiReferenceEditor.setDirectCreation(directCreation);
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		multiReferenceEditor.setLabelProvider(labelProvider);
	}
}
