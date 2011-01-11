/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.dialogs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.navigation.CreatedNavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement.NavigationType;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;


public class NavigationCreateDiagramDialog extends Dialog {

	private class NavigableGroupKey {

		public NavigableElement ancestor = null;

		public EStructuralFeature feature = null;

		public NavigationType navigationType = null;

		public int hashCode() {
			return 0;
		}

		public boolean equals(Object obj) {
			if(obj instanceof NavigableGroupKey) {
				NavigableGroupKey grpKey = (NavigableGroupKey)obj;
				return grpKey.ancestor == ancestor && grpKey.feature == feature;
			}
			return false;
		}


	}

	private static final String CREATION_ENTRY_KEY = "CREATION_ENTRY";

	private static final String ELEMENT_TYPE_COMBO_KEY = "ELEMENT_TYPE_COMBO";

	private static final String DIAGRAM_TYPE_COMBO_KEY = "DIAGRAM_TYPE_COMBO";

	private static final String DIAGRAM_NAME_TEXT_KEY = "DIAGRAM_NAME_TEXT";

	private static final String[] COLUMN_NAMES = { "Navigation type", "Feature", "Element type", "Diagram type", "Diagram name" };

	private static final int[] COLUMN_WIDTHS   = { 100              , 100      , 100           , 200           , 100            };

	private Map<NavigableElement, List<CreationCommandDescriptor>> possibleCreations;

	private ICommand command = null;

	private Table table;

	public NavigationCreateDiagramDialog(Shell parent, Map<NavigableElement, List<CreationCommandDescriptor>> possibleCreations) {
		super(parent);
		this.possibleCreations = possibleCreations;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Select diagram(s) to create");
	}

	public ICommand getCommand() {
		return command;
	}

	public int open() {
		if(possibleCreations == null || possibleCreations.isEmpty()) {
			return Dialog.CANCEL;
		}

		return super.open();
	}



	@Override
	protected void okPressed() {
		DiResourceSet diResourceSet = EditorUtils.getDiResourceSet();

		CompositeCommand compositeCommand = new CompositeCommand("Create diagrams");

		for(TableItem tableItem : table.getItems()) {
			try {
				CCombo elementTypeCombo = (CCombo)tableItem.getData(ELEMENT_TYPE_COMBO_KEY);
				int elementTypeSelectionIndex = elementTypeCombo.getSelectionIndex();
				CCombo diagramTypeCombo = (CCombo)tableItem.getData(DIAGRAM_TYPE_COMBO_KEY);
				int diagramTypeSelectionIndex = diagramTypeCombo.getSelectionIndex();

				if(tableItem.getChecked() && elementTypeSelectionIndex != -1 && diagramTypeSelectionIndex != -1) {
					List<NavigableElement> possibleElements = (List<NavigableElement>)tableItem.getData(CREATION_ENTRY_KEY);
					NavigableElement navElement = possibleElements.get(elementTypeSelectionIndex);

					CreationCommandDescriptor desc = possibleCreations.get(navElement).get(diagramTypeSelectionIndex);

					Text diagramNameText = (Text)tableItem.getData(DIAGRAM_NAME_TEXT_KEY);

					compositeCommand.add(DiagramsUtil.getLinkCreateAndOpenNavigableDiagram(navElement, desc.getCommand(), diagramNameText.getText(), diResourceSet));
				}
			} catch (BackboneException e) {
				e.printStackTrace();
			}
		}

		command = compositeCommand;

		super.okPressed();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		table = new Table(parent, SWT.BORDER | SWT.V_SCROLL | SWT.CHECK);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		for(int i = 0 ; i < COLUMN_NAMES.length ; i++) {
			TableColumn col = new TableColumn(table, SWT.NONE);
			col.setText(COLUMN_NAMES[i]);
			col.setWidth(COLUMN_WIDTHS[i]);
			col.setResizable(true);
		}

		// regroup CreatedNavigableElement which has same ancestor and use the same feature of this ancestor
		Map<NavigableGroupKey, List<NavigableElement>> successorsMap = new HashMap<NavigableGroupKey, List<NavigableElement>>();

		for(Entry<NavigableElement, List<CreationCommandDescriptor>> possibleCreationEntry : possibleCreations.entrySet()) {
			NavigableElement navElement = possibleCreationEntry.getKey();

			NavigableGroupKey groupKey = new NavigableGroupKey();

			groupKey.feature = navElement.getFeature();
			groupKey.navigationType = navElement.getNavigationType();

			if(navElement instanceof CreatedNavigableElement) {
				groupKey.ancestor = ((CreatedNavigableElement)navElement).getPreviousNavigableElement();
			}

			List<NavigableElement> successors = successorsMap.get(groupKey);
			if(successors == null) {
				successors = new LinkedList<NavigableElement>();
				successorsMap.put(groupKey, successors);
			}
			successors.add(navElement);
		}

		// handle group
		for(Entry<NavigableGroupKey, List<NavigableElement>> successorsEntry : successorsMap.entrySet()) {
			NavigableGroupKey groupKey = successorsEntry.getKey();
			List<NavigableElement> successors = successorsEntry.getValue();


			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setChecked(false);
			tableItem.setData(CREATION_ENTRY_KEY, successors);

			tableItem.setText(0, groupKey.navigationType.toString());
			String featureString = "";
			if(groupKey.feature != null) {
				featureString = groupKey.feature.getName();
			}
			tableItem.setText(1, featureString);

			TableEditor diagramTypeEditor = new TableEditor(table);
			final CCombo diagramTypeCombo = new CCombo(table, SWT.NONE);
			diagramTypeEditor.grabHorizontal = true;
			diagramTypeEditor.setEditor(diagramTypeCombo, tableItem, 3);
			tableItem.setData(DIAGRAM_TYPE_COMBO_KEY, diagramTypeCombo);

			TableEditor elementTypeEditor = new TableEditor(table);
			final CCombo elementTypeCombo = new CCombo(table, SWT.NONE);
			for(NavigableElement successor : successors) {
				String typeName = successor.getElement().eClass().getName();
				elementTypeCombo.add(typeName);
				elementTypeCombo.setData(typeName, successor);
			}
			elementTypeCombo.select(0);
			elementTypeEditor.grabHorizontal = true;
			elementTypeEditor.setEditor(elementTypeCombo, tableItem, 2);
			tableItem.setData(ELEMENT_TYPE_COMBO_KEY, elementTypeCombo);
			elementTypeCombo.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					String currentTypeName = ((CCombo)e.widget).getText();

					NavigableElement successor = (NavigableElement)elementTypeCombo.getData(currentTypeName);

					diagramTypeCombo.clearSelection();
					diagramTypeCombo.removeAll();
					for(CreationCommandDescriptor desc : possibleCreations.get(successor)) {
						diagramTypeCombo.add(desc.getLabel());
					}
					diagramTypeCombo.select(0);
				}
			});

			TableEditor diagramNameEditor = new TableEditor(table);
			Text text = new Text(table, SWT.NONE);
			text.setText("DefaultName");
			diagramNameEditor.grabHorizontal = true;
			diagramNameEditor.setEditor(text, tableItem, 4);
			tableItem.setData(DIAGRAM_NAME_TEXT_KEY, text);
		}

		return table;
	}
}
