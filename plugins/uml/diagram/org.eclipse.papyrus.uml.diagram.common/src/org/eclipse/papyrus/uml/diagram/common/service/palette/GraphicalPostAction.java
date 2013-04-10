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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
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
	public ICommand getPostCommand(final IAdaptable viewAdapter) {
		final TransactionalEditingDomain editingDomain = EditorUtils.getTransactionalEditingDomain();

		return new AbstractTransactionalCommand(editingDomain, "Modify Graphic", null) {
			
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				View view = (View)viewAdapter.getAdapter(View.class);
				for(String featureName : propertiesToUpdate.keySet()) {
					// retrieve feature to set
					EStructuralFeature feature = view.eClass().getEStructuralFeature(featureName);
					if(feature == null) {
						Activator.log.error("Impossible to find the feature " + featureName + " for element " + view, null);
					} else {
						view.eSet(feature, getValue(feature, propertiesToUpdate.get(featureName)));
					}
				}
				return CommandResult.newOKCommandResult();
			}
		};
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
