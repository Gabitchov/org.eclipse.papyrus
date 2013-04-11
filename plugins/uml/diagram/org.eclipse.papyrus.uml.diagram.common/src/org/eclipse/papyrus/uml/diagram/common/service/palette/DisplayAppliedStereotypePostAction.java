/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Post action that manages the display of applied stereotypes.
 */
public class DisplayAppliedStereotypePostAction extends GraphicalPostAction {

	/** list of stereotypes to display with their names */
	protected List<String> stereotypesToDisplay = new ArrayList<String>();

	/** list of stereotypes to display with their qualified names */
	protected List<String> stereotypesQNToDisplay = new ArrayList<String>();

	/** entry proxy "parent" of this action when configuring the action */
	protected IPaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** add icon path */
	protected static final String ICONS_ADD = "/icons/obj16/Add_16x16.gif"; //$NON-NLS-1$

	/** remove icon path */
	protected static final String ICONS_REMOVE = "/icons/delete.gif"; //$NON-NLS-1$

	/** TableViewer that shows the stereotypes to display */
	private TableViewer stereotypesToShowTableViewer;

	/** HashMap of displayable Stereotypes */
	protected HashMap<String, Integer> listOfDisplayableStereotypes = new HashMap<String, Integer>();

	/** Constants for the display options */
	private final int DONT_DISPLAY = 0;

	private final int DISPLAY_SIMPLE_NAME = 1;

	private final int DISPLAY_QUALIFIED_NAME = 2;

	/** The display options */
	private String[] diplayOptions = { "Do not display", "Display the stereotype", "Display qualified name of the stereotype" };

	/**
	 * @{inheritDoc
	 */
	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		if(configurationNode == null) {
			return;
		}
		NodeList childNodes = configurationNode.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			String nodeName = childNodes.item(i).getNodeName();
			if("displayName".equals(nodeName)) {
				Node stereotypeNameNode = childNodes.item(i).getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
				if(stereotypeNameNode != null) {
					stereotypesToDisplay.add(stereotypeNameNode.getNodeValue());
				}
			} else if("displayQualifiedName".equals(nodeName)) {
				Node stereotypeNameNode = childNodes.item(i).getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
				if(stereotypeNameNode != null) {
					stereotypesQNToDisplay.add(stereotypeNameNode.getNodeValue());
				}
			}
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void save(Node parentNode) {
		for(String stereotypeName : listOfDisplayableStereotypes.keySet()) {

			switch(listOfDisplayableStereotypes.get(stereotypeName)) {
			case DISPLAY_SIMPLE_NAME:
				Element displayName = ((Element)parentNode).getOwnerDocument().createElement("displayName");
				displayName.setAttribute(IPapyrusPaletteConstant.NAME, stereotypeName);
				((Element)parentNode).appendChild(displayName);
				break;
			case DISPLAY_QUALIFIED_NAME:
				Element displayQualifiedName = ((Element)parentNode).getOwnerDocument().createElement("displayQualifiedName");
				displayQualifiedName.setAttribute(IPapyrusPaletteConstant.NAME, stereotypeName);
				((Element)parentNode).appendChild(displayQualifiedName);
				break;

			default:
				break;
			}

		}
	}

	/**
	 * @{inheritDoc
	 */
	public ICommand getPostCommand(final IAdaptable viewAdapter) {
		final TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();

		return new AbstractTransactionalCommand(editingDomain, "Modify Stereotype Display", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				View view = (View)viewAdapter.getAdapter(View.class);

				// creates the commands to display simple stereotypes name
				for(String stereotypeName : stereotypesToDisplay) {
					String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(view);
					AppliedStereotypeHelper.getAddAppliedStereotypeCommand(editingDomain, view, stereotypeName, presentationKind).execute();
				}

				// creates the commands to display qualified names of stereotypes
				for(String stereotypeName : stereotypesQNToDisplay) {
					AppliedStereotypeHelper.getAddAppliedStereotypeToDisplayWithQNCommand(editingDomain, view, stereotypeName).execute();
				}

				org.eclipse.uml2.uml.Element element = (org.eclipse.uml2.uml.Element)view.getElement();
				for(Stereotype stereo : element.getAppliedStereotypes()) {
					if(!stereotypesQNToDisplay.contains(stereo.getQualifiedName()) && !stereotypesToDisplay.contains(stereo.getQualifiedName())) {
						String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(view);
						AppliedStereotypeHelper.getRemoveAppliedStereotypeCommand(editingDomain, view, stereo.getQualifiedName(), presentationKind).execute();
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;

		// retrieve displayable stereotypes
		if(entryProxy instanceof IPaletteAspectToolEntryProxy) {
			for(IPostAction postAction : ((IPaletteAspectToolEntryProxy)entryProxy).getPostActions()) {
				if(postAction instanceof StereotypePostAction) {
					for(String stereotype : ((StereotypePostAction)postAction).getStereotypesToApply()) {
						if(!listOfDisplayableStereotypes.containsKey(stereotype)) {
							listOfDisplayableStereotypes.put(stereotype, DONT_DISPLAY);
						}
					}
				}
			}
		}

		// Load from config
		for(String stereotypeName : stereotypesToDisplay) {
			if(listOfDisplayableStereotypes.containsKey(stereotypeName)) {
				listOfDisplayableStereotypes.put(stereotypeName, DISPLAY_SIMPLE_NAME);
			}
		}
		for(String stereotypeName : stereotypesQNToDisplay) {
			if(listOfDisplayableStereotypes.containsKey(stereotypeName)) {
				listOfDisplayableStereotypes.put(stereotypeName, DISPLAY_QUALIFIED_NAME);
			}
		}

		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout(1, false));

		Label label = new Label(composite, SWT.None);
		label.setText("Choose applied stereotypes to display : ");
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		label.setLayoutData(data);

		stereotypesToShowTableViewer = new TableViewer(composite, SWT.FULL_SELECTION);
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		stereotypesToShowTableViewer.getControl().setLayoutData(layoutData);
		createColumns(stereotypesToShowTableViewer);
		stereotypesToShowTableViewer.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub

			}

			public void dispose() {
				// TODO Auto-generated method stub

			}

			@SuppressWarnings("unchecked")
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof HashMap<?, ?>) {
					return ((HashMap<String, Integer>)inputElement).keySet().toArray();
				}
				return null;
			}
		});

		stereotypesToShowTableViewer.setLabelProvider(new StereotypeToDisplayLabelProvider());

		stereotypesToShowTableViewer.setInput(listOfDisplayableStereotypes);

		return composite;
	}

	/**
	 * The label provider for the tableviewer : one columns shows the stereotype
	 * name and the other shows the display option
	 */
	class StereotypeToDisplayLabelProvider extends LabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch(columnIndex) {
			case 0:
				return (String)element;
			case 1:
				return diplayOptions[listOfDisplayableStereotypes.get(element)];

			default:
				break;
			}
			return null;
		}
	}

	/**
	 * EditingSupport for the display option : combo editor
	 */
	class StereotypeToDisplayEditingSupport extends EditingSupport {

		private CellEditor editor;

		public StereotypeToDisplayEditingSupport(ColumnViewer viewer) {
			super(viewer);

			editor = new ComboBoxCellEditor(((TableViewer)viewer).getTable(), diplayOptions);
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected Object getValue(Object element) {
			return listOfDisplayableStereotypes.get(element);
		}

		@Override
		protected void setValue(Object element, Object value) {
			listOfDisplayableStereotypes.put((String)element, (Integer)value);
			getViewer().update(element, null);
		}
	}

	/**
	 * Creates appropriate columns : one for the stereotype and one for its
	 * display options
	 * 
	 * @param viewer
	 *        the table to create the columns in
	 */
	protected void createColumns(TableViewer viewer) {

		TableViewerColumn columnStereotype = new TableViewerColumn(viewer, SWT.NONE);
		columnStereotype.getColumn().setText("Stereotype");
		columnStereotype.getColumn().setWidth(300);
		columnStereotype.getColumn().setResizable(true);
		columnStereotype.getColumn().setMoveable(false);

		TableViewerColumn columnDisplay = new TableViewerColumn(viewer, SWT.NONE);
		columnDisplay.getColumn().setText("Display");
		columnDisplay.getColumn().setWidth(300);
		columnDisplay.getColumn().setResizable(true);
		columnDisplay.getColumn().setMoveable(false);
		// enable editing support
		columnDisplay.setEditingSupport(new StereotypeToDisplayEditingSupport(viewer));

		Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
	}

}
