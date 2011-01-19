/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.editors;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.editors.creation.ReferenceValueFactory;
import org.eclipse.papyrus.editors.messages.Messages;
import org.eclipse.papyrus.editors.providers.CollectionContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

/**
 * An editor for multivalued fields.
 * 
 * @author Camille Letavernier
 * 
 */
public class MultipleValueEditor extends AbstractListEditor implements SelectionListener, IChangeListener, DisposeListener {

	/**
	 * The viewer displaying the current values from
	 * the model
	 */
	protected ListViewer listViewer;

	/**
	 * The list associated to the viewer
	 */
	protected List list;

	/**
	 * A Composite containing the different control buttons
	 * (Add, remove, ...)
	 */
	protected Composite controlsSection;

	/**
	 * The Add control
	 */
	protected Button add;

	/**
	 * The Remove control
	 */
	protected Button remove;

	/**
	 * The Up control
	 */
	protected Button up;

	/**
	 * The Down control
	 */
	protected Button down;

	/**
	 * The edit control
	 */
	protected Button edit;

	/**
	 * The Dialog displayed when adding new elements
	 */
	protected MultipleValueSelectorDialog dialog;

	/**
	 * The element selector for this editor's dialog
	 */
	protected IElementSelector selector;

	/**
	 * Indicates whether the underlying is ordered
	 */
	protected boolean ordered;

	/**
	 * Indicates whether the underlying contains unique values
	 */
	protected boolean unique;

	/**
	 * The factory for creating and editing values from
	 * this editor
	 */
	protected ReferenceValueFactory referenceFactory;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which this Editor should be displayed
	 * @param style
	 *        This editor's list style
	 * @param selector
	 *        The element selector for this editor's dialog
	 * @param label
	 *        This editor's label, or null if no label should be displayed
	 * @param ordered
	 *        Specify if the observed collection is ordered. If true, Up and Down controls are displayed.
	 * @param unique
	 *        Specify if the observed collection values are unique.
	 * @param label
	 *        The label for this editor. If null, the label isn't created.
	 */
	public MultipleValueEditor(Composite parent, int style, IElementSelector selector, boolean ordered, boolean unique, String label) {
		super(parent, label);
		Assert.isNotNull(selector, "The Element Selector must be specified for a MultipleValueEditor"); //$NON-NLS-1$

		setLayout(new GridLayout(label == null ? 1 : 2, false));

		controlsSection = new Composite(this, SWT.NONE);
		controlsSection.setLayout(new FillLayout());
		controlsSection.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));

		list = new List(this, style | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		GridData listData = new GridData(SWT.FILL, SWT.FILL, true, true);
		listData.horizontalSpan = 2;
		listData.minimumHeight = 80;
		list.setLayoutData(listData);

		listViewer = new ListViewer(list);
		listViewer.setContentProvider(new CollectionContentProvider());

		createListControls(ordered);

		this.selector = selector;
		dialog = new MultipleValueSelectorDialog(parent.getShell(), selector, label, unique);

		setLabelProvider(new LabelProvider());

		this.ordered = ordered;
		this.unique = unique;
		updateControls();
	}

	private void updateControls() {
		up.setEnabled(ordered);
		down.setEnabled(ordered);
		edit.setEnabled(this.referenceFactory != null && referenceFactory.canEdit());
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which this Editor should be displayed
	 * @param style
	 *        This editor's list style
	 * @param selector
	 *        The element selector for this editor's dialog
	 * @param ordered
	 *        Specify if the observed collection is ordered. If true, Up and Down controls are displayed
	 */
	public MultipleValueEditor(Composite parent, int style, IElementSelector selector, boolean ordered) {
		this(parent, style, selector, ordered, false, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which this Editor should be displayed
	 * @param style
	 *        This editor's list style
	 * @param selector
	 *        The element selector for this editor's dialog
	 */
	public MultipleValueEditor(Composite parent, int style, IElementSelector selector) {
		this(parent, style, selector, false, false, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The Composite in which this Editor should be displayed
	 * @param style
	 *        This editor's list style
	 * @param selector
	 *        The element selector for this editor's dialog
	 * @param label
	 *        The label for this Editor
	 */
	public MultipleValueEditor(Composite parent, int style, IElementSelector selector, String label) {
		this(parent, style, selector, false, false, label);
	}

	/**
	 * Sets the label provider for this editor
	 * 
	 * @param labelProvider
	 *        The label provider for this editor
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		dialog.setLabelProvider(labelProvider);
		listViewer.setLabelProvider(labelProvider);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doBinding() {
		//We don't do a real Databinding in this case
		listViewer.setInput(modelProperty);
		modelProperty.addChangeListener(this);
		getParent().addDisposeListener(this);
	}

	/**
	 * @param ordered
	 */
	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
		this.dialog.setOrdered(ordered);

		updateControls();
	}

	/**
	 * @param unique
	 */
	public void setUnique(boolean unique) {
		this.unique = unique;
		this.dialog.setUnique(unique);

		updateControls();
	}

	/**
	 * Creates the Add/Remove controls,
	 * and the Up/Down controls if the collection is ordered
	 * 
	 * @param ordered
	 */
	protected void createListControls(boolean ordered) {
		up = new Button(controlsSection, SWT.PUSH);
		up.setImage(Activator.getImage("/icons/Up_12x12.gif")); //$NON-NLS-1$
		up.addSelectionListener(this);
		up.setToolTipText(Messages.MultipleValueEditor_MoveSelectedElementsUp);

		down = new Button(controlsSection, SWT.PUSH);
		down.setImage(Activator.getImage("/icons/Down_12x12.gif")); //$NON-NLS-1$
		down.addSelectionListener(this);
		down.setToolTipText(Messages.MultipleValueEditor_MoveSelectedElementsDown);

		add = new Button(controlsSection, SWT.PUSH);
		add.setImage(Activator.getImage("/icons/Add_12x12.gif")); //$NON-NLS-1$
		add.addSelectionListener(this);
		add.setToolTipText(Messages.MultipleValueEditor_AddElements);

		remove = new Button(controlsSection, SWT.PUSH);
		remove.setImage(Activator.getImage("/icons/Delete_12x12.gif")); //$NON-NLS-1$
		remove.addSelectionListener(this);
		remove.setToolTipText(Messages.MultipleValueEditor_RemoveSelectedElements);

		edit = new Button(controlsSection, SWT.PUSH);
		edit.setImage(Activator.getImage("/icons/Edit_12x12.gif")); //$NON-NLS-1$
		edit.addSelectionListener(this);
		edit.setToolTipText(Messages.MultipleValueEditor_EditSelectedValue);
	}

	@Override
	public Object getEditableType() {
		return Collection.class;
	}

	/**
	 * Handle events occuring on controls
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 * 
	 * @param e
	 */
	public void widgetSelected(SelectionEvent e) {
		if(e.widget == null)
			return;

		if(e.widget == add) {
			addAction();
		} else if(e.widget == remove) {
			removeAction();
		} else if(e.widget == up) {
			upAction();
		} else if(e.widget == down) {
			downAction();
		} else if(e.widget == edit) {
			editAction();
		}
	}

	/**
	 * Handle add Action
	 */
	protected void addAction() {
		if(modelProperty != null)
			dialog.setInitialSelections(modelProperty.toArray());
		else
			dialog.setInitialSelections(new Object[0]);

		int returnCode = dialog.open();
		if(returnCode == Window.CANCEL)
			return;

		modelProperty.clear();

		Object[] result = dialog.getResult();
		if(result == null) {
			return;
		}

		java.util.List<Object> resultElements = new LinkedList<Object>();
		for(Object r : result) {
			resultElements.add(r);
		}

		modelProperty.addAll(resultElements);

		commit();
	}

	/**
	 * Handle remove Action
	 */
	protected void removeAction() {
		IStructuredSelection selection = (IStructuredSelection)listViewer.getSelection();
		for(Object value : selection.toArray()) {
			modelProperty.remove(value);
		}
		listViewer.setSelection(null);

		commit();
	}

	/**
	 * Handle up Action
	 */
	protected void upAction() {
		IStructuredSelection selection = (IStructuredSelection)listViewer.getSelection();
		for(Object o : selection.toArray()) {
			int oldIndex = modelProperty.indexOf(o);
			if(oldIndex > 0)
				modelProperty.move(oldIndex, oldIndex - 1);
		}

		IStructuredSelection selectionCopy = new StructuredSelection(selection.toArray());
		listViewer.setSelection(selectionCopy);

		commit();
	}

	/**
	 * Handle down Action
	 */
	protected void downAction() {
		IStructuredSelection selection = (IStructuredSelection)listViewer.getSelection();

		int maxIndex = modelProperty.size() - 1;

		Object[] selectionArray = selection.toArray();
		for(int i = selectionArray.length - 1; i >= 0; i--) {
			Object o = selectionArray[i];
			int oldIndex = modelProperty.indexOf(o);
			if(oldIndex < maxIndex)
				modelProperty.move(oldIndex, oldIndex + 1);
		}

		IStructuredSelection selectionCopy = new StructuredSelection(selection.toArray());
		listViewer.setSelection(selectionCopy);

		commit();
	}

	/**
	 * Handle edit Action
	 */
	protected void editAction() {
		IStructuredSelection selection = (IStructuredSelection)listViewer.getSelection();

		if(selection.size() != 1) {
			return;
		}

		referenceFactory.edit(this, selection.getFirstElement());
	}

	/**
	 * Sets the {@link ReferenceValueFactory} for this editor. The {@link ReferenceValueFactory} is used to create
	 * new instances and edit existing ones.
	 * 
	 * @param factory
	 *        The {@link ReferenceValueFactory} to be used by this editor
	 */
	public void setFactory(ReferenceValueFactory factory) {
		this.referenceFactory = factory;
		dialog.setFactory(factory);
		updateControls();
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	/**
	 * Gets the list viewer associated to this editor
	 * 
	 * @return the list viewer associated to this editor
	 */
	public ListViewer getViewer() {
		return listViewer;
	}

	/**
	 * Refreshes the viewer when a change occurs on the ObservableList
	 * 
	 * @see org.eclipse.core.databinding.observable.IChangeListener#handleChange(org.eclipse.core.databinding.observable.ChangeEvent)
	 * 
	 * @param event
	 */
	public void handleChange(ChangeEvent event) {
		listViewer.refresh(true);
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDisposed(org.eclipse.swt.events.DisposeEvent e) {
		dispose();
		modelProperty.removeChangeListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setReadOnly(boolean readOnly) {
		list.setEnabled(!readOnly);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isReadOnly() {
		return !list.isEnabled();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLabel(String label) {
		if(this.label == null) {
			setLayout(new GridLayout(2, false));
		}
		super.setLabel(label);
	}
}
