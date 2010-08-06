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
package org.eclipse.papyrus.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.diagram.common.service.palette.AssociationEndPostAction.PropertyEndConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * Aspect action that modifies pseudostate on creation
 */
public class PseudostatePostAction extends ModelPostAction {

	/** list of property configurations, identified by their positions in the association end list */
	protected List<PropertyEndConfiguration> configurations;

	/** entry proxy "parent" of this action when configuring the action */
	protected IPaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;


	/** this attribute caches the value of the metaclass linked to the creation entry (performance optimization) */
	protected EClass metaclass = null;


	/** node name for the configuration of the pseudostate */
	protected static final String PSEUDOSTATE_NODE_NAME = "pseudostate";




	/**
	 * Constructor.
	 */
	public PseudostatePostAction() {
		configurations = new ArrayList<PropertyEndConfiguration>();
	}

	/**
	 * @{inheritDoc
	 */
	public Control createConfigurationComposite(Composite parent, IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;

		// retrieve tool metaclass
		if(entryProxy.getEntry() instanceof CombinedTemplateCreationEntry) {
			metaclass = PaletteUtil.getToolMetaclass((CombinedTemplateCreationEntry)entryProxy.getEntry());
		}

		Composite mainComposite = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout(2, true);
		mainComposite.setLayout(layout);

		Label titleLabel = new Label(mainComposite, SWT.NONE);
		titleLabel.setText("Rename pseudostate according to its kind, e.g. entryPointX");
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		titleLabel.setLayoutData(data);
		return mainComposite;
	}



	public String getNewPseudostateName(Pseudostate pseudo) {

		String baseString = pseudo.getKind().getLiteral();
		baseString = baseString.substring(0, 1).toUpperCase() + baseString.substring(1);
		String name = ""; //$NON-NLS-1$

		org.eclipse.uml2.uml.Element umlParent = pseudo.getOwner();

		boolean found = false;
		// i <10000: avoid infinite loops
		for(int i = 0; i < 10001; i++) {
			found = false;
			name = baseString + i;
			Iterator it = umlParent.getOwnedElements().iterator();
			while(it.hasNext() && !found) {
				Object o = it.next();
				if(o instanceof NamedElement) {
					if(name.equals(((NamedElement)o).getName())) {
						found = true;
					}
				}
			}
			if(!found) {
				return name;
			}
		}
		return baseString + "X"; //$NON-NLS-1$
	}


	/**
	 * {@inheritDoc}
	 */
	public void run(EditPart editPart) {

		final CompositeCommand compositeCommand = new CompositeCommand("Modify Pseudostate Name");
		EObject objectToEdit = ((View)editPart.getModel()).getElement();


		// object to edit should be a pseudostate...
		if(objectToEdit instanceof Pseudostate) {

			// retrieve a new name
			String newName = getNewPseudostateName((Pseudostate)objectToEdit);
			// operation to change the name
			EStructuralFeature feature = UMLPackage.eINSTANCE.getNamedElement_Name();
			SetRequest setRequest = new SetRequest((Pseudostate)objectToEdit, feature, newName);
			final SetValueCommand setValueCommand = new SetValueCommand(setRequest);

			if(setValueCommand.canExecute()) {
				boolean isActivating = true;
				Map<String, Boolean> options = null;
				// use the viewer to determine if we are still initializing the diagram
				// do not use the DiagramEditPart.isActivating since ConnectionEditPart's
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

						setValueCommand.execute(monitor, info);

						return Status.OK_STATUS;
					}
				};
				try {
					operation.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					Activator.log.error(e);
				}
			}
		}

	}


	/**
	 * @{inheritDoc
	 */
	public void save(Node parentNode) {
		if(!(parentNode instanceof Element)) {
			Activator.log.error("parent node is not an Element", null);
			return;
		} else {
			Element pseudostateNode = ((Element)parentNode).getOwnerDocument().createElement(PSEUDOSTATE_NODE_NAME);
			((Element)parentNode).appendChild(pseudostateNode);
		}
	}
}
