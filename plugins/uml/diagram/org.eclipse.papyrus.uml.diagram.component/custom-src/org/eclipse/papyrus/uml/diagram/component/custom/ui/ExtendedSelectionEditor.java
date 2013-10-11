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
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.messages.Messages;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
/**
 * Extension of selection editor with a table to display icon of element
 *normally this class must inherits of SelectionEditor but list and table are type that are not compatible, so entire creation of this class was needed
 */

public class ExtendedSelectionEditor extends Composite implements SelectionListener {


		/** the initial selection */
		protected final java.util.List<Object> initialSelection;

		/** The object selector */
		private IElementSelector selector;

		/** The SWT Composite in which the selector is drawn */
		protected Composite selectorSection;

		/** The message section */
		protected Composite messageSection;

		/** The additional button section */
		protected Composite createAdditionalButtonSection;

		/** The up/down buttons section */
		protected Composite rightButtonsSection;

		/** The listViewer for chosen elements */
		protected TableViewer selectedElementsViewer;

		/**
		 * 
		 * @return the table viewer in order to get the element selection
		 */
		public TableViewer getSelectedElementsViewer() {
			return selectedElementsViewer;
		}

		/** The list for chosen elements */
		protected Table selectedElements;

		/** The add action button */
		private Button add;

		/** The remove action button */
		private Button remove;

		/** The add all action button */
		private Button addAll;

		/** The remove all action button */
		private Button removeAll;

		/** the up action button */
		private Button up;

		/** the down action button */
		private Button down;

		/** The label provider for the listViewer of chosen elements */
		private ILabelProvider labelProvider;

		/** The currently chosen elements */
		protected final Collection<Object> currentSelection;

		/** the listener for the additional button */
		private SelectionListener additionalButtonSelectionListener;

		/** the message for the editor */
		private String message;


		/*
		 * This dialog can provide a Button to do some optional action
		 */

		/** Indicates if the dialog provides a button */
		private boolean withAdditionalButton = false;

		/** the label of the button */
		private String additionalButtonLabel = null;

		/** the button */
		private Button additionalButton;

		/** The add/remove/addAll buttons section */
		protected Composite buttonSection;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param parent
		 *        the parent of this composite
		 * @param selector
		 *        the selector
		 * @param labelProvider
		 *        the label provider
		 * @param initialSelection
		 *        the initial selection
		 */
		public ExtendedSelectionEditor(Composite parent, IElementSelector selector, ILabelProvider labelProvider, java.util.List<Object> initialSelection) {
			super(parent, SWT.NONE);
			this.selector = selector;
			this.labelProvider = labelProvider;
			this.initialSelection = new ArrayList<Object>();
			for(Object current : initialSelection) {
				this.initialSelection.add(current);
			}
			currentSelection = initialSelection;
		}

		/**
		 * This methods create this editor
		 */
		public void create() {
			Composite parent = this;
			GridLayout layout = new GridLayout(1, true);
			GridData data = new GridData();
			data.grabExcessHorizontalSpace = true;
			data.grabExcessVerticalSpace = true;
			parent.setLayout(layout);
			createMessageSection(parent);
			createBody(parent);
			createCreateButtonSection(parent);
		}

		/**
		 * This method create the body of the editor :
		 * <ul>
		 * <li>the selector</li>
		 * <li>the list</li>
		 * <li>the buttons Add, AddAll, Remove, RemoveAll, Up, Down</li>
		 * </ul>
		 * 
		 * @param parent
		 *        the parent composite
		 */
		protected void createBody(Composite parent) {

			Composite par = new Composite(parent, SWT.NONE);
			createSelectorSection(par);
			createControlsSection(par);
			createListSection(par);
			createRightButtonsSection(par);
			GridLayout layout = new GridLayout();
			layout.makeColumnsEqualWidth = false;
			layout.numColumns = 4;
			par.setLayout(layout);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			par.setLayoutData(data);

		}

		/**
		 * Creates the Message section
		 * 
		 * @param parent
		 *        the parent of the {@link Composite}
		 */
		protected void createMessageSection(Composite parent) {
			messageSection = new Composite(parent, SWT.NONE);
			Label label = new Label(messageSection, SWT.NONE);
			label.setText(message);
			messageSection.setLayout(new FillLayout(SWT.HORIZONTAL));
		}

		/**
		 * Creates the button section
		 * 
		 * @param parent
		 *        the parent of the {@link Composite}
		 */
		protected void createCreateButtonSection(Composite parent) {
			if(this.withAdditionalButton) {
				buttonSection = new Composite(parent, SWT.NONE);
				additionalButton = new Button(buttonSection, SWT.PUSH);
				if(additionalButtonLabel != null) {
					additionalButton.setText(additionalButtonLabel);
				}
				buttonSection.setLayout(new FillLayout());
				this.additionalButton.addSelectionListener(additionalButtonSelectionListener);
			}
		}

		/**
		 * Creates the selector section
		 * 
		 * @param parent
		 *        The composite in which the section is created
		 */
		protected void createSelectorSection(Composite parent) {
			selectorSection = new Composite(parent, SWT.NONE);
			selectorSection.setLayout(new FillLayout());
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.widthHint = 400;

			//		data.exclude = true;
			selectorSection.setLayoutData(data);
			selector.createControls(selectorSection);

		}

		/**
		 * Creates the main controls section (Add, remove, Add all, remove all)
		 * 
		 * @param parent
		 *        The composite in which the section is created
		 */
		protected void createControlsSection(Composite parent) {
			buttonSection = new Composite(parent, SWT.NONE);
			buttonSection.setLayout(new GridLayout(1, true));

			add = new Button(buttonSection, SWT.PUSH);
			add.setImage(Activator.getDefault().getImage("/icons/arrow_right.gif")); //$NON-NLS-1$
			add.addSelectionListener(this);
			add.setToolTipText(Messages.MultipleValueSelectorDialog_AddSelectedElements);

			remove = new Button(buttonSection, SWT.PUSH);
			remove.setImage(Activator.getDefault().getImage("/icons/arrow_left.gif")); //$NON-NLS-1$
			remove.addSelectionListener(this);
			remove.setToolTipText(Messages.MultipleValueEditor_RemoveSelectedElements);

			addAll = new Button(buttonSection, SWT.PUSH);
			addAll.setImage(Activator.getDefault().getImage("/icons/arrow_double.gif")); //$NON-NLS-1$
			addAll.addSelectionListener(this);
			addAll.setToolTipText(Messages.MultipleValueSelectorDialog_AddAllElements);

			removeAll = new Button(buttonSection, SWT.PUSH);
			removeAll.setImage(Activator.getDefault().getImage("/icons/arrow_left_double.gif")); //$NON-NLS-1$
			removeAll.addSelectionListener(this);
			removeAll.setToolTipText(Messages.MultipleValueSelectorDialog_RemoveAllElements);
		}


		/**
		 * Creates the list displaying the currently selected elements
		 * 
		 * @param parent
		 *        The composite in which the section is created
		 */
		protected void createListSection(Composite parent) {
			Composite listSection = new Composite(parent, SWT.NONE);
			selectedElements = new Table(listSection, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			data.widthHint = 400;
			listSection.setLayout(new FillLayout());
			listSection.setLayoutData(data);

			selectedElementsViewer = new TableViewer(selectedElements);

			selectedElementsViewer.setContentProvider(CollectionContentProvider.instance);

			if(labelProvider != null)
				selectedElementsViewer.setLabelProvider(labelProvider);

			selectedElementsViewer.setInput(currentSelection);
			selector.setSelectedElements(currentSelection.toArray());

		}

		/**
		 * Creates the up/down controls section
		 * 
		 * @param parent
		 *        The composite in which the section is created
		 */
		protected void createRightButtonsSection(Composite parent) {
			rightButtonsSection = new Composite(parent, SWT.NONE);
			rightButtonsSection.setLayout(new GridLayout(1, true));

			up = new Button(rightButtonsSection, SWT.PUSH);
			up.setImage(Activator.getDefault().getImage("/icons/Up_12x12.gif")); //$NON-NLS-1$
			up.addSelectionListener(this);
			up.setToolTipText(Messages.MultipleValueEditor_MoveSelectedElementsUp);

			down = new Button(rightButtonsSection, SWT.PUSH);
			down.setImage(Activator.getDefault().getImage("/icons/Down_12x12.gif")); //$NON-NLS-1$
			down.addSelectionListener(this);
			down.setToolTipText(Messages.MultipleValueEditor_MoveSelectedElementsDown);
		}



		/**
		 * {@inheritDoc} Handles the events on one of the control buttons
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 * 
		 * @param e
		 *        The event that occurred
		 */
		public void widgetSelected(SelectionEvent e) {
			if(e.widget == add) {
				addAction();
			} else if(e.widget == remove) {
				removeAction();
			} else if(e.widget == addAll) {
				addAllAction();
			} else if(e.widget == removeAll) {
				removeAllAction();
			} else if(e.widget == up) {
				upAction();
			} else if(e.widget == down) {
				downAction();
			}
		}

		/**
		 * Handles the "Add" action
		 */
		protected void addAction() {
			Object[] elements = selector.getSelectedElements();
			addElements(elements);
		}

		/**
		 * Handles the "Up" action
		 */
		protected void upAction() {
			IStructuredSelection selection = (IStructuredSelection)selectedElementsViewer.getSelection();

			//We need a list to move objects. LinkedHashSet can't do that
			java.util.List<Object> list = new LinkedList<Object>(currentSelection);
			for(Object o : selection.toArray()) {
				int oldIndex = list.indexOf(o);
				if(oldIndex > 0)
					move(list, oldIndex, oldIndex - 1);
			}

			currentSelection.clear();
			currentSelection.addAll(list);

			IStructuredSelection selectionCopy = new StructuredSelection(selection.toArray());
			selectedElementsViewer.setSelection(selectionCopy);
			selectedElementsViewer.refresh();
		}

		/**
		 * Handles the "Down" action
		 */
		protected void downAction() {
			IStructuredSelection selection = (IStructuredSelection)selectedElementsViewer.getSelection();

			//We need a list to move objects. LinkedHashSet can't do that
			java.util.List<Object> list = new LinkedList<Object>(currentSelection);

			int maxIndex = list.size() - 1;

			Object[] selectionArray = selection.toArray();
			for(int i = selectionArray.length - 1; i >= 0; i--) {
				Object o = selectionArray[i];
				int oldIndex = list.indexOf(o);
				if(oldIndex < maxIndex)
					move(list, oldIndex, oldIndex + 1);
			}

			currentSelection.clear();
			currentSelection.addAll(list);

			IStructuredSelection selectionCopy = new StructuredSelection(selection.toArray());
			selectedElementsViewer.setSelection(selectionCopy);
			selectedElementsViewer.refresh();
		}

		/**
		 * Moves an element from oldIndex to newIndex
		 * 
		 * @param list
		 *        The list in which to move the object
		 * @param oldIndex
		 * @param newIndex
		 */
		protected void move(java.util.List<Object> list, int oldIndex, int newIndex) {
			int size = list.size();

			if(oldIndex < 0 || oldIndex >= size)
				throw new IndexOutOfBoundsException("oldIndex: " + oldIndex + ", size:" + size); //$NON-NLS-1$ //$NON-NLS-2$
			if(newIndex < 0 || newIndex >= size)
				throw new IndexOutOfBoundsException("newIndex: " + newIndex + ", size:" + size); //$NON-NLS-1$ //$NON-NLS-2$
			Object element = list.remove(oldIndex);
			list.add(newIndex, element);
		}

		/**
		 * Handles the "Remove" action
		 */
		protected void removeAction() {
			IStructuredSelection selection = (IStructuredSelection)selectedElementsViewer.getSelection();
			if(selection.isEmpty())
				return;

			for(Object element : selection.toArray()) {
				currentSelection.remove(element);
			}

			selector.setSelectedElements(currentSelection.toArray());
			selectedElementsViewer.setSelection(null);
			selectedElementsViewer.refresh();
		}

		/**
		 * Handles the "Remove all" action
		 */
		protected void removeAllAction() {
			currentSelection.clear();
			selector.setSelectedElements(new Object[0]);
			selectedElementsViewer.setSelection(null);
			selectedElementsViewer.refresh();
		}

		/**
		 * Handles the "Add All" action
		 */
		protected void addAllAction() {
			Object[] elements = selector.getAllElements();
			addElements(elements);
		}

		/**
		 * Adds the specified elements to the currently selected elements (For
		 * "Add" and "Add all" actions)
		 * 
		 * @param elements
		 *        The elements to be added
		 */
		protected void addElements(Object[] elements) {
			if(elements != null) {
				currentSelection.addAll(Arrays.asList(elements));
				selectedElementsViewer.refresh();
			}
		}


		/**
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
		 * 
		 * @param e
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
			//Nothing to do
		}

		/**
		 * 
		 * @param withAdditionalButton
		 * @param messageButton
		 * @param listener
		 */
		public void setAdditionalButton(boolean withAdditionalButton, String messageButton, SelectionListener listener) {
			this.withAdditionalButton = withAdditionalButton;
			this.additionalButtonLabel = messageButton;
			this.additionalButtonSelectionListener = listener;
		}

		/**
		 * Set the message displayed by the Editor
		 * 
		 * @param string
		 *        the message displayed by the editor
		 */
		public void setMessage(String string) {
			this.message = string;
		}

		/**
		 * Returns all selected elements
		 * 
		 * @return
		 *         all selected elements
		 */
		public Collection<?> getSelectedElements() {
			return currentSelection;
		}


		/**
		 * Returns the list of the elements to remove
		 * 
		 * @return
		 *         the list of the elements to remove
		 */
		public java.util.List<Object> getElementToRemove() {
			java.util.List<Object> removedObject = new ArrayList<Object>();
			for(Object current : this.initialSelection) {
				if(!getSelectedElements().contains(current)) {
					removedObject.add(current);
				}
			}
			return removedObject;
		}

		/**
		 * Returns the list of the elements to add
		 * 
		 * @return
		 *         the list of the elements to add
		 */
		public java.util.List<Object> getElementToAdd() {
			java.util.List<Object> addedObject = new ArrayList<Object>();
			for(Object current : getSelectedElements()) {
				if(!this.initialSelection.contains(current)) {
					addedObject.add(current);
				}
			}
			return addedObject;
		}
	}
