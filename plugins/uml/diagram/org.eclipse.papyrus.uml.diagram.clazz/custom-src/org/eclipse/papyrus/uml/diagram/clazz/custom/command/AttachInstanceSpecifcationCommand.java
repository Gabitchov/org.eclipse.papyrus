/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.helper.NamedElementHelper;
import org.eclipse.papyrus.uml.diagram.clazz.custom.ui.AssociationSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * this class has in charge to create the semantic instance specification as a link
 * 
 */
public class AttachInstanceSpecifcationCommand extends AbstractCustomCommand {

	protected IAdaptable viewAdapter;

	protected CreateConnectionViewRequest req;

	protected InstanceSpecification source;

	protected InstanceSpecification target;

	protected HashSet<Association> commonAssociations = new HashSet<Association>();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *            the editing domain
	 * @param req
	 *            the request of connection
	 * @param viewAdapter
	 *            the view that has been created
	 * @param viewer
	 *            the viewer
	 */
	public AttachInstanceSpecifcationCommand(TransactionalEditingDomain domain, CreateConnectionViewRequest req, IAdaptable viewAdapter, EditPartViewer viewer) {
		super(domain, "attach instance", null);
		this.viewAdapter = viewAdapter;
		this.viewer = viewer;
		this.req = req;
	}

	@Override
	public boolean canExecute() {
		if (req.getSourceEditPart() == null && req.getTargetEditPart() != null) {
			this.target = (InstanceSpecification) ((View) req.getTargetEditPart().getModel()).getElement();
			// test if is an instanceSpecification
			if ((((View) req.getTargetEditPart().getModel()).getElement() instanceof InstanceSpecification)) {
				InstanceSpecification instance = (InstanceSpecification) (((View) req.getTargetEditPart().getModel()).getElement());
				// Is it associated to a classifier?
				if (instance.getClassifiers().size() > 0) {
					HashSet<Association> assoSource = new HashSet<Association>();
					Iterator<Classifier> iterator = target.getClassifiers().iterator();
					while (iterator.hasNext()) {
						Classifier classifier = (Classifier) iterator.next();
						assoSource.addAll(classifier.getAssociations());
					}
					// how many association it linked?
					if (assoSource.size() > 0) {
						return true;
					}
				}
			}
			return false;
		}
		// source and target != null
		// look for if it exist at least a common association between classifiers referenced between these instances
		if (req.getSourceEditPart() != null && req.getTargetEditPart() != null) {
			if (!(((View) req.getSourceEditPart().getModel()).getElement() instanceof InstanceSpecification)) {
				return false;
			}
			if (!(((View) req.getTargetEditPart().getModel()).getElement() instanceof InstanceSpecification)) {
				return false;
			}
			this.source = (InstanceSpecification) ((View) req.getSourceEditPart().getModel()).getElement();
			this.target = (InstanceSpecification) ((View) req.getTargetEditPart().getModel()).getElement();
			if (source.getClassifiers().size() == 0 || target.getClassifiers().size() == 0) {
				return false;
			}
			HashSet<Association> assoSource = new HashSet<Association>();
			Iterator<Classifier> iterator = source.getClassifiers().iterator();
			while (iterator.hasNext()) {
				Classifier classifier = (Classifier) iterator.next();
				assoSource.addAll(classifier.getAssociations());
			}
			HashSet<Association> assoTarget = new HashSet<Association>();
			iterator = target.getClassifiers().iterator();
			while (iterator.hasNext()) {
				Classifier classifier = (Classifier) iterator.next();
				assoTarget.addAll(classifier.getAssociations());
			}
			assoSource.retainAll(assoTarget);
			commonAssociations = new HashSet<Association>();
			commonAssociations.addAll(assoSource);
			return (commonAssociations.size() > 0);
		}
		return false;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		View view = (View) viewAdapter.getAdapter(View.class);
		AssociationSelectionDialog associationSelectionDialog;
		Association selectedAssociation = null;
		if (source.getClassifiers().size() > 0 && target.getClassifiers().size() > 0) {
			// look for the good association
			associationSelectionDialog = new AssociationSelectionDialog(new Shell(), SWT.NATIVE, commonAssociations);
			associationSelectionDialog.open();
			selectedAssociation = associationSelectionDialog.getSelectedAssociation();
			if (view != null && view.eContainer() != null) {
				View parent = (View) view.eContainer();
				InstanceSpecification instanceSpecification = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInstanceSpecification();
				if (parent.getElement() instanceof Package) {
					((Package) parent.getElement()).getPackagedElements().add(instanceSpecification);
				}
				instanceSpecification.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(instanceSpecification.getOwner(), instanceSpecification.eClass()));
				instanceSpecification.getClassifiers().add(selectedAssociation);
				view.setElement(instanceSpecification);
				// Creation of slots
				Iterator<Property> proIterator = selectedAssociation.getMemberEnds().iterator();
				while (proIterator.hasNext()) {
					Property property = (Property) proIterator.next();
					Slot slot = UMLFactory.eINSTANCE.createSlot();
					slot.setDefiningFeature(property);
					if (source.getClassifiers().contains(property.getOwner())) {
						source.getSlots().add(slot);
						associateValue(target, slot, property.getType());
					} else if (target.getClassifiers().contains(property.getOwner())) {
						target.getSlots().add(slot);
						associateValue(source, slot, property.getType());
					} else {
						instanceSpecification.getSlots().add(slot);
						if (source.getClassifiers().contains(property.getType())) {
							associateValue(source, slot, property.getType());
						} else {
							associateValue(target, slot, property.getType());
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * create an instanceValue for the slot (owner) with the reference to InstanceSpecification and the good type
	 * 
	 * @param instanceSpecification
	 *            that is referenced by the instanceValue
	 * @param owner
	 *            of the instance value
	 * @param type
	 *            of the instanceValue
	 * @return a instanceValue
	 */
	protected InstanceValue associateValue(InstanceSpecification instanceSpecification, Slot owner, Type type) {
		InstanceValue iv = UMLFactory.eINSTANCE.createInstanceValue();
		iv.setName(NamedElementHelper.EINSTANCE.getNewUMLElementName(owner, iv.eClass()));
		iv.setType(type);
		iv.setInstance(target);
		owner.getValues().add(iv);
		return iv;
	}

}
