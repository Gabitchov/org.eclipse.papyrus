/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.preferences;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.papyrus.infra.gmfdiag.dnd.policy.DropStrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy;
import org.eclipse.papyrus.infra.widgets.editors.MultipleReferenceEditor;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;


public class DropStrategyEditor extends MultipleReferenceEditor {

	//	protected Button toggle;

	public static final int ACTIVATION_COLUMN = 0;

	public static final int LABEL_COLUMN = 1;

	private final Map<DropStrategy, Button> checkboxes;

	public DropStrategyEditor(Composite parent, int style) {
		super(parent, style, true, true, "Strategies");

		List<DropStrategy> values = DropStrategyManager.instance.getAllStrategies();

		IStaticContentProvider provider = new StaticContentProvider(values.toArray());
		ColumnViewerToolTipSupport.enableFor(treeViewer, ToolTip.NO_RECREATE);
		setProviders(provider, new DropStrategyLabelProvider());
		setModelObservable(new DropStrategyObservableList(values));

		TableLayout layout = new TableLayout();

		new TreeColumn(tree, SWT.LEFT);
		layout.addColumnData(new ColumnWeightData(10, 25, false));

		new TreeColumn(tree, SWT.LEFT);
		layout.addColumnData(new ColumnWeightData(100, 250, true));

		tree.setLayout(layout);
		tree.setHeaderVisible(false);

		setToolTipText("Strategies");

		treeViewer.refresh();

		//Adds a checkbox for each DropStrategy, to toggle it
		checkboxes = new HashMap<DropStrategy, Button>();

		for(TreeItem item : tree.getItems()) {
			if(item.getData() instanceof DropStrategy) {
				TreeEditor editor = new TreeEditor(tree);
				final Button button = new Button(tree, SWT.CHECK);
				final TreeItem currentItem = item;

				final DropStrategy strategy = (DropStrategy)currentItem.getData();
				button.addSelectionListener(new SelectionListener() {

					public void widgetSelected(SelectionEvent e) {
						updateStrategy(strategy, button);
						treeViewer.refresh();
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						//Nothing
					}

				});

				checkboxes.put(strategy, button);

				button.setSelection(DropStrategyManager.instance.isActive(strategy));

				editor.setEditor(button, item, ACTIVATION_COLUMN);
				editor.horizontalAlignment = SWT.CENTER;
				editor.grabHorizontal = true;
			}
		}

		//Adds a space-key listener to edit a list of selected checkboxes
		tree.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if(e.keyCode == SWT.SPACE) {
					ISelection selection = treeViewer.getSelection();
					if(selection instanceof IStructuredSelection && !selection.isEmpty()) {
						IStructuredSelection structuredSelection = (IStructuredSelection)selection;

						Boolean isActive = findIsActive(structuredSelection);

						Iterator<?> iterator = structuredSelection.iterator();
						while(iterator.hasNext()) {
							Object element = iterator.next();
							if(element instanceof DropStrategy) {
								DropStrategy strategy = (DropStrategy)element;
								Button button = checkboxes.get(strategy);

								updateStrategy(strategy, button, isActive);
							}
						}

						treeViewer.refresh();
					}
				}
			}

			public void keyPressed(KeyEvent e) {
				//Nothing
			}
		});
	}

	//Returns the new status of the first DropStrategy in the selection.
	//Returns null if the selection doesn't contain any DropStrategy
	private Boolean findIsActive(IStructuredSelection selection) {
		Iterator<?> iterator = selection.iterator();
		while(iterator.hasNext()) {
			Object element = iterator.next();
			if(element instanceof DropStrategy) {
				boolean isActive = DropStrategyManager.instance.isActive((DropStrategy)element); //Current status
				return !isActive; //New status (Toggle)
			}
		}
		return null; //No DropStrategy found in the selection
	}

	private void updateStrategy(DropStrategy strategy, Button button, boolean isActive) {
		DropStrategyManager.instance.setActive(strategy, isActive);
		button.setSelection(isActive);
	}

	private void updateStrategy(DropStrategy strategy, Button button) {
		boolean isActive = DropStrategyManager.instance.isActive(strategy);
		updateStrategy(strategy, button, !isActive);
	}

	@Override
	public void createListControls() {
		super.createListControls();
		edit.dispose();
		remove.dispose();
		add.dispose();
		up.dispose();
		down.dispose();

		//		toggle = new Button(controlsSection, SWT.TOGGLE);
		//		toggle.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/Add_12x12.gif"));
		//		toggle.addSelectionListener(this);
		//		toggle.setToolTipText("Toggle the selected strategies");

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				updateControls();
			}
		});
	}

	protected Object[] getSelectedElements() {
		IStructuredSelection selection = (IStructuredSelection)treeViewer.getSelection();
		return selection.toArray();
	}

	@Override
	public void widgetSelected(SelectionEvent event) {
		//		if(event.widget == toggle) {
		//			toggleAction(toggle.getSelection());
		//		} else {
		super.widgetSelected(event);
		//		}
	}

	protected void toggleAction(boolean activate) {
		Object[] selectedElements = getSelectedElements();
		for(Object selected : selectedElements) {
			if(selected instanceof DropStrategy) {
				DropStrategyManager.instance.setActive((DropStrategy)selected, activate);
			}
		}
		treeViewer.refresh();
	}

	@Override
	protected void updateControls() {
		//Skip super.updateControls ; this is not configurable. Avoids a widget disposed exception

		//		boolean activate = false;
		//
		//		Object[] selectedElements = getSelectedElements();
		//		for(Object selected : selectedElements) {
		//			if(selected instanceof DropStrategy) {
		//				if(DropStrategyManager.instance.isActive((DropStrategy)selected)) {
		//					activate = true;
		//					break;
		//				}
		//			}
		//		}

		//		toggle.setSelection(activate);
	}

	private class DropStrategyObservableList extends WritableList {

		public DropStrategyObservableList(List<DropStrategy> values) {
			super();
			addAll(values);
		}

		@Override
		public Object move(int oldIndex, int newIndex) {
			Object objectToMove = get(oldIndex);
			Object other = get(newIndex);

			if(objectToMove instanceof DropStrategy && other instanceof DropStrategy) {
				DropStrategy strategyToMove = (DropStrategy)objectToMove;
				DropStrategy otherStrategy = (DropStrategy)other;

				int priority = DropStrategyManager.instance.findPriority(otherStrategy);
				int newPriority = (newIndex > oldIndex) ? priority + 1 : priority - 1;

				DropStrategyManager.instance.setPriority(strategyToMove, newPriority);
			}

			return super.move(oldIndex, newIndex);
		}
	}

	/**
	 * Refreshes the widget's contents, based on the DropStrategyManager's current values
	 */
	public void refresh() {
		for(Map.Entry<DropStrategy, Button> entry : checkboxes.entrySet()) {
			boolean isActive = DropStrategyManager.instance.isActive(entry.getKey());
			updateStrategy(entry.getKey(), entry.getValue(), isActive);
		}
		treeViewer.refresh();
	}
}
