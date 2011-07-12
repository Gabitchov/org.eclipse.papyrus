/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.palette.customaction.control;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.diagram.common.palette.customaction.providers.Tool;
import org.eclipse.papyrus.diagram.common.palette.customaction.providers.ToolAspectAction;
import org.eclipse.papyrus.diagram.common.palette.customaction.utils.ICallback;
import org.eclipse.papyrus.diagram.common.service.palette.IPaletteEntryProxy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.w3c.dom.Node;

/**
 * The composite for the selection of the wizard tool
 * 
 * @author tfaure
 * 
 */
public class ToolSelectionComposite extends Composite {

	private Label label;
	private ComboViewer viewer;
	private final ICallback<Tool> callBack;

	public ToolSelectionComposite(Composite parent,
			IPaletteEntryProxy entryProxy, int style, ICallback<Tool> call) {
		super(parent, style);
		this.callBack = call;
		GridLayout layout = new GridLayout(1, true);
		this.setLayout(layout);
		viewer = new ComboViewer(this);
		GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		viewer.getCombo().setLayoutData(data);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection structured = (IStructuredSelection) event
							.getSelection();
					Tool firstElement = (Tool) structured
							.getFirstElement();
					if (firstElement != null)
					{
						label.setText(firstElement.getDescription());
						callBack.callBack(firstElement);
					}
				}
			}
		});
		Group group = new Group(this, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout(1, true));
		group.setText("Description");
		GridData data2 = new GridData(SWT.FILL, SWT.FILL, true, true);
		group.setLayoutData(data2);
		label = new Label(group, SWT.NONE);
		label.setText("");
		label.setLayoutData(GridDataFactory.copyData(data));
		viewer.setInput(ToolAspectAction.getFiltered(entryProxy,
				ToolAspectAction.getAllExtensions()));
	}

	public void setSelection(Node configurationNode) {
		Tool wizard = getTool(configurationNode);
		if (wizard != null) {
			viewer.setSelection(new StructuredSelection(wizard));
		}
	}

	public static Tool getTool(Node configurationNode) {
		if (configurationNode == null
				|| configurationNode.getAttributes() == null) {
			return null;
		}
		Node attr = configurationNode.getAttributes().getNamedItem(
				ToolAspectAction.SELECTED_WIZARD);
		if (attr != null) {
			String value = attr.getNodeValue();
			Tool wizard = ToolAspectAction.getExtension(value);
			return wizard ;
		}
		return null ;
	}

	public void setSelection(Tool selection) {
		viewer.setSelection(new StructuredSelection(selection));
	}

}
