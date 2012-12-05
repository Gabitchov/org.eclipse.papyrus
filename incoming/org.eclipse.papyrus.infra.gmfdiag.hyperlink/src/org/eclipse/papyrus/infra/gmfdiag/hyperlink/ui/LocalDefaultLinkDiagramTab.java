/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.hyperlink.ui;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.hyperlink.Activator;
import org.eclipse.papyrus.infra.gmfdiag.navigation.CreatedNavigableElement;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigableElement;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigationHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.ui.AbstractHyperLinkTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

/**
 * this is the tab in charge to display the hyperlink diagram created by using heuristic for the property default
 * the code was extract from {@link NavigationCreateDiagramDialog}
 * 
 */
public class LocalDefaultLinkDiagramTab extends AbstractHyperLinkTab {

	private static final String CREATION_ENTRY_KEY = "CREATION_ENTRY";

	private static final String ELEMENT_TYPE_COMBO_KEY = "ELEMENT_TYPE_COMBO";

	private static final String DIAGRAM_TYPE_COMBO_KEY = "DIAGRAM_TYPE_COMBO";

	private static final String DIAGRAM_NAME_TEXT_KEY = "DIAGRAM_NAME_TEXT";

	private static final String[] COLUMN_NAMES = { "Navigation type", "Feature", "Element type", "Diagram type", "Diagram name" };

	private static final int[] COLUMN_WIDTHS = { 80, 120, 120, 200, 120 };

	private Map<NavigableElement, List<CreationCommandDescriptor>> possibleCreations;

	private ICommand command = null;

	private Table table;

	private EObject semanticElement;


	private class NavigableGroupKey {


		public NavigableElement ancestor = null;

		public EStructuralFeature feature = null;

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof NavigableGroupKey) {
				NavigableGroupKey grpKey = (NavigableGroupKey)obj;
				return grpKey.ancestor == ancestor && grpKey.feature == feature;
			}
			return false;
		}
	}

	private Composite defaultHyperlinkComposite;


	/**
	 * @return the composite that contains the table
	 * **/
	public Composite getDefaultHyperlinkComposite() {
		return defaultHyperlinkComposite;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tabFolder
	 *        the parent tabfolder
	 * @param semanticElement
	 *        the element from which diagram can be created
	 */
	@Deprecated
	public LocalDefaultLinkDiagramTab(CTabFolder tabFolder, EObject semanticElement) {
		this.semanticElement = semanticElement;
		//init list of descriptor to fill the table
		initLocalNavigableElement();
		//associate the composite to the tabfolder
		CTabItem tbtmDefaultsHyperlinks = new CTabItem(tabFolder, SWT.NONE);
		tbtmDefaultsHyperlinks.setText("Hyperlink diagram with Heuristic");
		defaultHyperlinkComposite = new Composite(tabFolder, SWT.NONE);
		defaultHyperlinkComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createArea(defaultHyperlinkComposite);
		tbtmDefaultsHyperlinks.setControl(defaultHyperlinkComposite);
	}

	public LocalDefaultLinkDiagramTab() {
		super();
	}

	@Override
	public void init(CTabFolder tabFolder, List<HyperLinkObject> hyperlinkObjects, EObject element) {
		super.init(tabFolder, hyperlinkObjects, element);
		this.semanticElement = element;
		//init list of descriptor to fill the table
		initLocalNavigableElement();
		//associate the composite to the tabfolder
		CTabItem tbtmDefaultsHyperlinks = new CTabItem(tabFolder, SWT.NONE);
		tbtmDefaultsHyperlinks.setText("Hyperlink diagram with Heuristic");
		defaultHyperlinkComposite = new Composite(tabFolder, SWT.NONE);
		defaultHyperlinkComposite.setLayout(new GridLayout(1, false));
		defaultHyperlinkComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		createArea(defaultHyperlinkComposite);
		tbtmDefaultsHyperlinks.setControl(defaultHyperlinkComposite);
	}

	/**
	 * get the command to create diagrams from the selection done into the table
	 * 
	 * @return the command in charge of the creation of the diagrams
	 * **/
	public ICommand getCommand() {
		return command;
	}

	/**
	 * code that is called when the button ok is selected
	 */
	protected void okPressed() {
		ModelSet modelSet;

		try {
			modelSet = ServiceUtilsForEObject.getInstance().getModelSet(semanticElement);
		} catch (ServiceException ex) {
			Activator.log.error(ex);
			return;
		}

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

					compositeCommand.add(NavigationHelper.getLinkCreateAndOpenNavigableDiagramCommand(navElement, desc.getCommand(), diagramNameText.getText(), modelSet));
				}
			} catch (BackboneException e) {
				e.printStackTrace();
			}
		}

		command = compositeCommand;

	}

	/**
	 * construction the ui
	 * 
	 * @param parent
	 *        the composite that contains table.
	 * @return the table contained in the composite
	 */
	protected Control createArea(Composite parent) {

		table = new Table(parent, SWT.BORDER | SWT.V_SCROLL | SWT.CHECK);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		//		table.setBounds(10, 20, 650, 170);

		for(int i = 0; i < COLUMN_NAMES.length; i++) {
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

			// ignore containing feature if we are on the root element
			// because it is a direct diagram creation
			// => the feature has no meaning in this case
			if(!semanticElement.equals(navElement.getElement())) {
				groupKey.feature = navElement.getFeature();
			}

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

			//////FIXME///////
			//tableItem.setText(0, UMLNavigationHelper.getNavigationTypeFromFeature(groupKey.feature)); //Remove this dependency to UML. LabelProviderService?
			tableItem.setText(0, "Unknown");
			//////////////////

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
			elementTypeCombo.select(0);

			TableEditor diagramNameEditor = new TableEditor(table);
			Text text = new Text(table, SWT.NONE);
			text.setText("DefaultName");
			diagramNameEditor.grabHorizontal = true;
			diagramNameEditor.setEditor(text, tableItem, 4);
			tableItem.setData(DIAGRAM_NAME_TEXT_KEY, text);
		}

		parent.pack();
		return table;
	}


	/**
	 * this method is used to construct descriptors of heuristic to construct diagrams.
	 * These descriptors will be displayed in the table.
	 */
	protected void initLocalNavigableElement() {
		List<NavigableElement> navElements = NavigationHelper.getInstance().getAllNavigableElements(semanticElement);
		possibleCreations = new HashMap<NavigableElement, List<CreationCommandDescriptor>>();

		for(NavigableElement navElement : navElements) {
			final EObject element = navElement.getElement();

			List<CreationCommandDescriptor> possibleCommandDescs = new LinkedList<CreationCommandDescriptor>();
			for(final CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				if(desc.getCondition() == null || desc.getCondition().create(element)) {
					possibleCommandDescs.add(desc);
				}
			}
			if(!possibleCommandDescs.isEmpty()) {
				possibleCreations.put(navElement, possibleCommandDescs);
			}
		}
	}

	/**
	 * @return the creation command registry
	 */
	protected static ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
	}

	@Override
	public void setInput(List<HyperLinkObject> hyperLinkObjectList) {
		//nothing to do here?
	}

}
