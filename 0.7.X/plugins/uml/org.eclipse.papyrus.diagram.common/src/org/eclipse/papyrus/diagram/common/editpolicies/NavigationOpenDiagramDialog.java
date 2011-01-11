package org.eclipse.papyrus.diagram.common.editpolicies;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.core.adaptor.gmf.OpenDiagramCommand;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;


public class NavigationOpenDiagramDialog extends Dialog {

	private static final String[] COLUMN_NAMES = { "Navigation type", "Feature", "Element type", "Diagram type", "Diagram name" };

	private static final int[] COLUMN_WIDTHS   = { 100              , 100      , 100           , 200           , 100            };

	private static final String DIAGRAM_KEY = "DIAGRAM_KEY";

	private static final String ELEMENT_KEY = "ELEMENT_KEY";

	private Map<NavigableElement, List<Diagram>> existingNavDiagrams;

	private ICommand command = null;

	private Table table;

	public NavigationOpenDiagramDialog(Shell parent, Map<NavigableElement, List<Diagram>> existingNavDiagrams) {
		super(parent);
		this.existingNavDiagrams = existingNavDiagrams;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Select diagram(s) to open");
	}

	public ICommand getCommand() {
		return command;
	}

	public int open() {
		if(existingNavDiagrams == null || existingNavDiagrams.isEmpty()) {
			return Dialog.CANCEL;
		}
		if(existingNavDiagrams.size() == 1) {
			Entry<NavigableElement, List<Diagram>> entry = existingNavDiagrams.entrySet().iterator().next();
			List<Diagram> diagrams = entry.getValue();
			if(diagrams.size() == 1) {
				DiResourceSet diResourceSet = EditorUtils.getDiResourceSet();
				command = new OpenDiagramCommand(diResourceSet.getAssociatedDiResource(entry.getKey().getElement()), diResourceSet.getTransactionalEditingDomain(), diagrams.get(0));
				return Dialog.OK;
			}
		}

		return super.open();
	}

	@Override
	protected void okPressed() {
		CompositeCommand compositeCommand = new CompositeCommand("Open diagrams");
		DiResourceSet diResourceSet = EditorUtils.getDiResourceSet();

		for(TableItem tableItem : table.getItems()) {
			if(tableItem.getChecked()) {
				Resource diResource = diResourceSet.getAssociatedDiResource((EObject)tableItem.getData(ELEMENT_KEY));
				compositeCommand.add(new OpenDiagramCommand(diResource, diResourceSet.getTransactionalEditingDomain(), (Diagram)tableItem.getData(DIAGRAM_KEY)));
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

		for(Map.Entry<NavigableElement, List<Diagram>> entry : existingNavDiagrams.entrySet()) {
			NavigableElement navElement = entry.getKey();
			for(Diagram diagram : entry.getValue()) {
				TableItem tableItem = new TableItem(table, SWT.NONE);

				tableItem.setChecked(true);
				tableItem.setText(0, navElement.getNavigationType().toString());
				String featureString = "";
				if(navElement.getFeature() != null) {
					featureString = navElement.getFeature().getName();
				}
				tableItem.setText(1, featureString);
				tableItem.setText(2, navElement.getElement().eClass().getName());
				tableItem.setText(3, diagram.getType());
				tableItem.setText(4, diagram.getName());

				tableItem.setData(DIAGRAM_KEY, diagram);
				tableItem.setData(ELEMENT_KEY, navElement.getElement());
			}
		}

		return table;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		createButton(parent, IDialogConstants.OK_ID, "Open in new tab(s)", true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}
}
