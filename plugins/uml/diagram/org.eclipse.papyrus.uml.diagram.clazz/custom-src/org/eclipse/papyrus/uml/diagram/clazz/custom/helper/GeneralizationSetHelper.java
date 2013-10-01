/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.GeneralizationSetEditPart;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * The Class GeneralizationSetHelper in charge to manage the creation and the movement of the
 * GeneralizationSet.
 */
public class GeneralizationSetHelper extends ElementHelper {

	protected static final String CHOOSE_A_FOLLOWING_GENERALIZATION_SET_TO_CONNECT = "Choose a following generalizationSet to connect:";

	/**
	 * The listener interface for receiving dialog events. The class that is interested in
	 * processing a dialog event implements this interface, and the object created with that class
	 * is registered with a component using the component's <code>addDialogListener<code> method. When
	 * the dialog event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see DialogEvent
	 */
	private class DialogListener implements Listener {

		/** The abutton ok. */
		private Button abuttonOk;

		/** The acombo. */
		private List acombo;

		/** The ageneralization set. */
		private GeneralizationSet ageneralizationSet = null;

		/** The ageneralization set list. */
		private ArrayList<GeneralizationSet> ageneralizationSetList;

		/**
		 * Instantiates a new dialog listener.
		 * 
		 * @param generalizationSetList
		 *        the generalization set list
		 * @param combo
		 *        the combo
		 * @param buttonOK
		 *        the button ok
		 */
		public DialogListener(ArrayList<GeneralizationSet> generalizationSetList, List combo, Button buttonOK) {
			this.ageneralizationSetList = generalizationSetList;
			this.acombo = combo;
			this.abuttonOk = buttonOK;
		}

		/**
		 * Gets the result.
		 * 
		 * @return the result
		 */
		public GeneralizationSet getResult() {
			return ageneralizationSet;
		}

		/**
		 * {@inheritedDoc}
		 */
		public void handleEvent(Event event) {
			if(event.widget.equals(abuttonOk)) {
				// look for selected button
				int selectedButtonIndex = 0;
				selectedButtonIndex = acombo.getSelectionIndex();
				if(selectedButtonIndex >= 0) {
					ageneralizationSet = ageneralizationSetList.get(selectedButtonIndex);
				}
				((Shell)abuttonOk.getParent()).close();
			}
		}
	}

	protected static final String WOULD_YOU_LIKE_TO_CREATE_A_NEW_GENERALIZATION = "Would you like to create a new Generalization?";

	/** The generalization setto create. */
	private GeneralizationSet generalizationSettoCreate;

	/**
	 * Instantiates a new generalization set helper.
	 * 
	 * @param editDomain
	 *        the edit domain
	 */
	public GeneralizationSetHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	/**
	 * Creates the generalization set.
	 * 
	 * @param source
	 *        the source of the GenralizationSet
	 * @param target
	 *        the target the Target of the Generalization
	 * @param container
	 *        the container of the GeneralizationSet
	 * 
	 * @return the generalization set
	 */
	public GeneralizationSet createGeneralizationSet(Generalization source, Generalization target, org.eclipse.uml2.uml.Package container) {
		final ArrayList<GeneralizationSet> generalizationSetList = new ArrayList<GeneralizationSet>(source.getGeneralizationSets());
		Iterator<GeneralizationSet> iterator = target.getGeneralizationSets().iterator();
		while(iterator.hasNext()) {
			GeneralizationSet currentGeneralizationSet = (GeneralizationSet)iterator.next();
			if(!generalizationSetList.contains(currentGeneralizationSet)) {
				generalizationSetList.add(currentGeneralizationSet);
			}
		}
		if(generalizationSetList.size() > 0) {
			launchDialog(generalizationSetList, getEditingDomain());
		}
		if(generalizationSettoCreate == null) {
			generalizationSettoCreate = UMLFactory.eINSTANCE.createGeneralizationSet();
			generalizationSettoCreate.setName("GeneralizationSet_" + source.getSpecific().getName() + "_" + target.getSpecific().getName());
			container.getPackagedElements().add(generalizationSettoCreate);
		}
		if(!generalizationSettoCreate.getGeneralizations().contains(source)) {
			generalizationSettoCreate.getGeneralizations().add(source);
		}
		if(!generalizationSettoCreate.getGeneralizations().contains(target)) {
			generalizationSettoCreate.getGeneralizations().add(target);
		}
		return generalizationSettoCreate;
	}

	/**
	 * In change to move anchor of other GeneralizationSet when moving one
	 * 
	 * @param request
	 *        a request ReconnectRequest
	 * @param command
	 *        the command that will move anchor of other Generalization that have the same
	 *        semantic
	 * @param node
	 *        the node
	 * @param targetAnchor
	 *        the target anchor
	 * 
	 * @return the move target
	 */
	public org.eclipse.gef.commands.Command getMoveTarget(ReconnectRequest request, org.eclipse.gef.commands.Command command, INodeEditPart node, ConnectionAnchor targetAnchor) {
		//System.err.println("custom reconnection for GeneralizationSet target");
		org.eclipse.gef.commands.CompoundCommand cc = new org.eclipse.gef.commands.CompoundCommand();
		// look for all Generalization set connected to the source location that reference the same
		// generalizationSet
		ArrayList linkList = new ArrayList();
		linkList.addAll(node.getSourceConnections());
		linkList.addAll(node.getTargetConnections());
		// remove reconnected link
		linkList.remove(request.getConnectionEditPart());
		// get the link that refer the same model element
		GeneralizationSetEditPart edgeToMove = null;
		Iterator iterator = linkList.iterator();
		while(iterator.hasNext()) {
			Object currentObject = iterator.next();
			if(currentObject instanceof GeneralizationSetEditPart) {
				if(((GeneralizationSetEditPart)request.getConnectionEditPart()).resolveSemanticElement().equals(((GeneralizationSetEditPart)currentObject).resolveSemanticElement())) {
					edgeToMove = (GeneralizationSetEditPart)currentObject;
				}
			}
		}
		cc.add(command);
		if(edgeToMove != null) {
			SetConnectionAnchorsCommand scaCommandbis = new SetConnectionAnchorsCommand(getEditingDomain(), StringStatics.BLANK);
			scaCommandbis.setEdgeAdaptor(new EObjectAdapter((View)edgeToMove.getModel()));
			if(node.getSourceConnections().contains(edgeToMove)) {
				scaCommandbis.setNewSourceTerminal(node.mapConnectionAnchorToTerminal(targetAnchor));
			} else {
				scaCommandbis.setNewTargetTerminal(node.mapConnectionAnchorToTerminal(targetAnchor));
			}
			cc.add(new ICommandProxy(scaCommandbis));
		}
		return cc;
	}

	/**
	 * this command is used to overload the reconnect source command in order to move other
	 * GeneralizationSet that have the same semantic
	 * 
	 * @param request
	 *        the request
	 * @param node
	 *        the node
	 * 
	 * @return the reconnect source command
	 */
	public Command getReconnectSourceCommand(ReconnectRequest request, INodeEditPart node) {
		// System.err.println("custom reconnection for GeneralizationSet source");
		// System.err.println("node--> " + node);
		if(node == null)
			return null;
		TransactionalEditingDomain editingDomain = getEditingDomain();
		ConnectionAnchor sourceAnchor = node.getSourceConnectionAnchor(request);
		// System.err.println("sourceAnchor--> " + sourceAnchor.getReferencePoint());
		SetConnectionEndsCommand sceCommand = new SetConnectionEndsCommand(editingDomain, StringStatics.BLANK);
		sceCommand.setEdgeAdaptor(new EObjectAdapter((View)request.getConnectionEditPart().getModel()));
		sceCommand.setNewSourceAdaptor(new EObjectAdapter((View)node.getModel()));
		SetConnectionAnchorsCommand scaCommand = new SetConnectionAnchorsCommand(editingDomain, StringStatics.BLANK);
		scaCommand.setEdgeAdaptor(new EObjectAdapter((View)request.getConnectionEditPart().getModel()));
		scaCommand.setNewSourceTerminal(node.mapConnectionAnchorToTerminal(sourceAnchor));
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.Commands_SetConnectionEndsCommand_Source);
		cc.compose(sceCommand);
		cc.compose(scaCommand);
		// look for all Generalization set connected to the source location that reference the same
		// generalizationSet
		ArrayList linkList = new ArrayList();
		linkList.addAll(node.getSourceConnections());
		linkList.addAll(node.getTargetConnections());
		// remove reconnected link
		linkList.remove(request.getConnectionEditPart());
		// get the link that refer the same model element
		GeneralizationSetEditPart edgeToMove = null;
		Iterator iterator = linkList.iterator();
		while(iterator.hasNext()) {
			Object currentObject = iterator.next();
			if(currentObject instanceof GeneralizationSetEditPart) {
				if(((GeneralizationSetEditPart)request.getConnectionEditPart()).resolveSemanticElement().equals(((GeneralizationSetEditPart)currentObject).resolveSemanticElement())) {
					edgeToMove = (GeneralizationSetEditPart)currentObject;
				}
			}
		}
		if(edgeToMove != null) {
			SetConnectionAnchorsCommand scaCommandbis = new SetConnectionAnchorsCommand(editingDomain, StringStatics.BLANK);
			scaCommandbis.setEdgeAdaptor(new EObjectAdapter((View)edgeToMove.getModel()));
			if(node.getSourceConnections().contains(edgeToMove)) {
				scaCommandbis.setNewSourceTerminal(node.mapConnectionAnchorToTerminal(sourceAnchor));
			} else {
				scaCommandbis.setNewTargetTerminal(node.mapConnectionAnchorToTerminal(sourceAnchor));
			}
			cc.compose(scaCommandbis);
		}
		return new ICommandProxy(cc);
	}

	/**
	 * Launch dialog when a GeneralizationSet is created. I ask to the user if he would like to
	 * create a new semantic or reuse an existed semantic
	 * 
	 * @param generalizationSetList
	 *        the generalization set list
	 * @param editingDomain
	 *        the editing domain
	 */
	private void launchDialog(final ArrayList<GeneralizationSet> generalizationSetList, TransactionalEditingDomain editingDomain) {
		// Thread myThread = new Thread(new Runnable() {
		// public void run() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				Display display = Display.getCurrent();// new Display();
				final Button[] radios = new Button[2];
				final Shell dialog = new Shell(display, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
				dialog.setBackground(ColorConstants.white);
				GridLayout gridLayout = new GridLayout(2, false);
				gridLayout.verticalSpacing = 8;
				dialog.setLayout(gridLayout);
				dialog.setText("GeneralizationSet Selection");
				// Line1: Proposition of a new GeneralizationSet
				Label text = new Label(dialog, SWT.CENTER);
				text.setText(WOULD_YOU_LIKE_TO_CREATE_A_NEW_GENERALIZATION);
				text.setBackground(ColorConstants.white);
				GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
				gridData.horizontalSpan = 1;
				text.setLayoutData(gridData);
				radios[0] = new Button(dialog, SWT.RADIO);
				radios[0].setBackground(ColorConstants.white);
				gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
				gridData.horizontalSpan = 1;
				radios[0].setLayoutData(gridData);
				// Line2:
				text = new Label(dialog, SWT.CENTER);
				text.setBackground(ColorConstants.white);
				text.setText(CHOOSE_A_FOLLOWING_GENERALIZATION_SET_TO_CONNECT);
				gridData = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
				gridData.horizontalSpan = 1;
				text.setLayoutData(gridData);
				radios[1] = new Button(dialog, SWT.RADIO);
				radios[1].setBackground(ColorConstants.white);
				gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
				gridData.horizontalSpan = 1;
				radios[1].setLayoutData(gridData);
				// Line3..X: the combo
				final List list = new List(dialog, SWT.MULTI | SWT.BORDER);
				gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
				gridData.horizontalSpan = 2;
				list.setLayoutData(gridData);
				for(int i = 0; i < generalizationSetList.size(); i++) {
					if(generalizationSetList.get(i).getLabel() != null) {
						list.add(generalizationSetList.get(i).getLabel());
					} else {
						list.add("GeneralizationSet" + i);
					}
				}
				radios[0].addSelectionListener(new SelectionListener() {

					public void widgetDefaultSelected(SelectionEvent e) {
					}

					public void widgetSelected(SelectionEvent e) {
						list.setEnabled(!radios[0].getSelection());
					}
				});
				radios[1].setSelection(true);
				// button
				final org.eclipse.swt.widgets.Button buttonok = new Button(dialog, SWT.PUSH);
				gridData = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
				gridData.horizontalSpan = 1;
				gridData.horizontalAlignment = GridData.END;
				buttonok.setLayoutData(gridData);
				buttonok.setText("  OK  ");
				// button Cancel
				Button cancel = new Button(dialog, SWT.PUSH);
				gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
				gridData.horizontalSpan = 1;
				gridData.horizontalAlignment = GridData.END;
				cancel.setLayoutData(gridData);
				cancel.setText("Cancel");
				// listener of button
				DialogListener listener = new DialogListener(generalizationSetList, list, buttonok);
				buttonok.addListener(SWT.Selection, listener);
				cancel.addListener(SWT.Selection, listener);
				dialog.pack();
				dialog.open();
				while(!dialog.isDisposed()) {
					if(!display.readAndDispatch())
						display.sleep();
				}
				generalizationSettoCreate = listener.getResult();
			}
		});
	}
}
