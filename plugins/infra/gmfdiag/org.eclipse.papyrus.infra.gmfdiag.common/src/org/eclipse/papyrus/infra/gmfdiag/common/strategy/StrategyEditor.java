/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Refactor a generic StrategyEditor
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.strategy;

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

// TODO : make drag&dropEditor extends it 
public class StrategyEditor extends MultipleReferenceEditor {

	private static final String STRATEGIES = "Strategies";

	public static final int ACTIVATION_COLUMN = 0;

	public static final int LABEL_COLUMN = 1;

	protected /*final*/ Map<IStrategy, Button> checkboxes;

	
	protected IStrategyManager instance;
	
	public StrategyEditor(Composite parent, int style, IStrategyManager instance2) {
		super(parent, style, true, true, STRATEGIES);
		instance = instance2;
		
		List<IStrategy> values = getStrategyManager().getAllStrategies();

		IStaticContentProvider provider = new StaticContentProvider(values.toArray());
		ColumnViewerToolTipSupport.enableFor(treeViewer, ToolTip.NO_RECREATE);
		setProviders(provider, new StrategyLabelProvider(getStrategyManager()));// FIXME
		setModelObservable(new StrategyObservableList(values));

		TableLayout layout = new TableLayout();

		new TreeColumn(tree, SWT.LEFT);
		layout.addColumnData(new ColumnWeightData(10, 25, false));

		new TreeColumn(tree, SWT.LEFT);
		layout.addColumnData(new ColumnWeightData(100, 250, true));

		tree.setLayout(layout);
		tree.setHeaderVisible(false);

		setToolTipText(STRATEGIES);

		treeViewer.refresh();

		//Adds a checkbox for each PasteStrategy, to toggle it
		checkboxes = new HashMap<IStrategy, Button>();

		for(TreeItem item : tree.getItems()) {
			if(item.getData() instanceof IStrategy) {
				TreeEditor editor = new TreeEditor(tree);
				final Button button = new Button(tree, SWT.CHECK);
				final TreeItem currentItem = item;

				final IStrategy strategy = (IStrategy)currentItem.getData();
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

				button.setSelection(getStrategyManager().isActive(strategy));

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
							if(element instanceof IStrategy) {
								IStrategy strategy = (IStrategy)element;
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


	public IStrategyManager getStrategyManager()	{
		return instance;
	}

	//Returns the new status of the first PasteStrategy in the selection.
	//Returns null if the selection doesn't contain any PasteStrategy
	private Boolean findIsActive(IStructuredSelection selection) {
		Iterator<?> iterator = selection.iterator();
		while(iterator.hasNext()) {
			Object element = iterator.next();
			if(element instanceof IStrategy) {
				boolean isActive = getStrategyManager().isActive((IStrategy)element); //Current status
				return !isActive; //New status (Toggle)
			}
		}
		return null; //No PasteStrategy found in the selection
	}

	protected void updateStrategy(IStrategy strategy, Button button, boolean isActive) {
		getStrategyManager().setActive((IStrategy) strategy, isActive);
		button.setSelection(isActive);
	}

	protected void updateStrategy(IStrategy strategy, Button button) {
		boolean isActive = getStrategyManager().isActive(strategy);
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
			if(selected instanceof IStrategy) {
				getStrategyManager().setActive((IStrategy)selected, activate);
			}
		}
		treeViewer.refresh();
	}

	@Override
	protected void updateControls() {
		//Skip super.updateControls ; this is not configurable. Avoids a widget disposed exception

	}



	/**
	 * Refreshes the widget's contents, based on the PasteStrategyManager's current values
	 */
	public void refresh() {
		for(Map.Entry<IStrategy, Button> entry : checkboxes.entrySet()) {
			boolean isActive = getStrategyManager().isActive(entry.getKey());
			updateStrategy(entry.getKey(), entry.getValue(), isActive);
		}
		treeViewer.refresh();
	}
	
	
	private class StrategyObservableList extends WritableList {

		public StrategyObservableList(List<IStrategy> values) {
			super();
			addAll(values);
		}

		@Override
		public Object move(int oldIndex, int newIndex) {
			Object objectToMove = get(oldIndex);
			Object other = get(newIndex);

			if(objectToMove instanceof IStrategy && other instanceof IStrategy) {
				IStrategy strategyToMove = (IStrategy)objectToMove;
				IStrategy otherStrategy = (IStrategy)other;

				int priority = getStrategyManager().findPriority(otherStrategy);
				int newPriority = (newIndex > oldIndex) ? priority + 1 : priority - 1;

				getStrategyManager().setPriority(strategyToMove, newPriority);
			}

			return super.move(oldIndex, newIndex);
		}

	}	
	
	
}
