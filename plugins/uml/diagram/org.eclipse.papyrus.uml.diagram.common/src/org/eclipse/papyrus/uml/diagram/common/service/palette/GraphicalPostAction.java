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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.Profile;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Aspect action that modifies graphical appearance on the edit part newly
 * created
 */
public class GraphicalPostAction extends ModelPostAction {

	/** list of properties to update, identified by their names */
	protected Map<String, Object> propertiesToUpdate;

	/** entry proxy "parent" of this action when configuring the action */
	protected IPaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/**
	 * Constructor.
	 */
	public GraphicalPostAction() {
		propertiesToUpdate = new HashMap<String, Object>();
	}

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
			Node featureNode = childNodes.item(i);
			if(IPapyrusPaletteConstant.FEATURE_NODE_NAME.equals(featureNode.getNodeName())) {
				Node nameNode = childNodes.item(i).getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
				Node valueNode = childNodes.item(i).getAttributes().getNamedItem(IPapyrusPaletteConstant.VALUE);
				if(nameNode != null && valueNode != null) {
					propertiesToUpdate.put(nameNode.getNodeValue(), valueNode.getNodeValue());
				} else {
					Activator.log.error("Impossible to parse the configuration node for graphical post action", null);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(EditPart editPart) {

		final CompositeCommand compositeCommand = new CompositeCommand("Modify Graphic");
		EObject objectToEdit = (View)editPart.getModel();

		for(String featureName : propertiesToUpdate.keySet()) {
			// retrieve feature to set
			EStructuralFeature feature = objectToEdit.eClass().getEStructuralFeature(featureName);
			if(feature == null) {
				Activator.log.error("Impossible to find the feature " + featureName + " for element " + objectToEdit, null);
				return;
			} else {

				SetRequest request = new SetRequest(objectToEdit, feature, getValue(feature, propertiesToUpdate.get(featureName)));
				// request.getExtendedData().put(ApplyStereotypeRequest.NEW_EDIT_PART_NAME,
				// "NEW");
				compositeCommand.compose(new SetValueCommand(request));
			}
		}
		compositeCommand.reduce();

		if(compositeCommand.canExecute()) {
			boolean isActivating = true;
			Map<String, Boolean> options = null;
			// use the viewer to determine if we are still initializing the
			// diagram
			// do not use the DiagramEditPart.isActivating since
			// ConnectionEditPart's
			// parent will not be a diagram edit part
			EditPartViewer viewer = editPart.getViewer();
			if(viewer instanceof DiagramGraphicalViewer) {
				isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
			}

			if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)editPart, false, false)) {
				options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
			}

			AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)editPart).getEditingDomain(), StringStatics.BLANK, options) {

				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

					compositeCommand.execute(monitor, info);

					return Status.OK_STATUS;
				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
		} else {
			Activator.log.error("Impossible to execute graphical post action " + propertiesToUpdate, null);
		}
	}

	/**
	 * @{inheritDoc
	 */
	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;

		Composite composite = new Composite(parent, SWT.BORDER);
		composite.setLayout(new GridLayout(1, false));

		Label label = new Label(composite, SWT.None);
		label.setText("Configuration of graphical post action : ");
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		label.setLayoutData(data);

		return composite;
	}

	/**
	 * @{inheritDoc
	 */
	public void save(Node parentNode) {
		// TODO Auto-generated method stub

	}
}
