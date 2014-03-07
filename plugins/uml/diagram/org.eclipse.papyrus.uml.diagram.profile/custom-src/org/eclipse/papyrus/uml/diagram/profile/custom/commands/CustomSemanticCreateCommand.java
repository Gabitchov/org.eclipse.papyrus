/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/


package org.eclipse.papyrus.uml.diagram.profile.custom.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.profile.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.profile.custom.requests.CustomCreateElementRequestAdapter;
import org.eclipse.papyrus.uml.tools.providers.UMLMetaclassContentProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this command allows to import metaclasses in a profile
 * 
 * @author VL222926
 * 
 */
public class CustomSemanticCreateCommand extends AbstractTransactionalCommand {

	/**
	 * the requestAdapter
	 */
	private CustomCreateElementRequestAdapter customRequestAdapter;

	/**
	 * the added metaclasses
	 */
	private List<Object> addedMetaclasses;

	/**
	 * the profile
	 */
	private Profile profile;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param requestAdapter
	 * @param realSemanticCommand
	 * @param profile
	 */
	public CustomSemanticCreateCommand(TransactionalEditingDomain domain, CustomCreateElementRequestAdapter requestAdapter, Profile profile) {
		super(domain, Messages.CustomSemanticCreateCommand_CreateCustomSemanticCommandForMetaclass, null);
		this.profile = profile;
		this.customRequestAdapter = requestAdapter;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult result = CommandResult.newCancelledCommandResult();
		ReferenceSelector selector = new ReferenceSelector(true);
		selector.setContentProvider(new UMLMetaclassContentProvider(profile));
		LabelProviderService serv = null;
		try {
			serv = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, profile);
		} catch (ServiceException e) {
			Activator.log.error(Messages.CustomSemanticCreateCommand_LabelProviderServiceNotFound, e);
		}
		ILabelProvider labelProvider = serv.getLabelProvider();
		selector.setLabelProvider(labelProvider);

		//		EList<PackageableElement> importedElement = profile.getImportedElements();
		//we don't set initial selection to allows to draw new instance of imported metaclass
		final List<EObject> alreadyImportedElement = new ArrayList<EObject>();
		//		for(final PackageableElement current : importedElement){
		//			if(current instanceof Class && ((Class)current).isMetaclass()){
		//				alreadyImportedElement.add(current);
		//			}
		//		}
		final MultipleValueSelectorDialog dialog = new MultipleValueSelectorDialog(Display.getDefault().getActiveShell(), selector, Messages.CustomSemanticCreateCommand_SelectMetaclass, true, false, -1);
		dialog.setContextElement(profile);
		dialog.setLabelProvider(labelProvider);
		dialog.setInitialElementSelections(alreadyImportedElement);

		if(dialog.open() == IStatus.OK) {
			Object[] selectedMetaclass = dialog.getResult();
			this.addedMetaclasses = Arrays.asList(selectedMetaclass);
			if(!this.addedMetaclasses.isEmpty()) {
				ICommand createElementImportCommand = getImportElementCommand();
				if(createElementImportCommand != null) {
					createElementImportCommand.execute(progressMonitor, info);
				}
				return CommandResult.newOKCommandResult();
			}
		}
		return result;
	}

	/**
	 * 
	 * @return
	 *         the command to create the new ElementImport for each new import metaclass
	 */
	private ICommand getImportElementCommand() {
		CompositeCommand addindCommand = new CompositeCommand("Add ImportElement Command"); //$NON-NLS-1$
		//----Obtain the actual imported metaclasses
		EList<?> metaclassSet = this.profile.getReferencedMetaclasses();

		//we add the new metaclasses
		for(int i = 0; i < this.addedMetaclasses.size(); i++) {
			//we need to import the metaclass
			if(!metaclassSet.contains(this.addedMetaclasses.get(i))) {
				//we create an ElementImport for the new metaclass
				ElementImport ei = UMLFactory.eINSTANCE.createElementImport();
				//we create the class

				ei.setImportedElement((PackageableElement)this.addedMetaclasses.get(i));
				ei.setAlias(((NamedElement)this.addedMetaclasses.get(i)).getName());
				//					addedMetaclasses.add(addedMetaclasses.get(i));
				ElementImport added = ei;

				//we need make the import only if it doesn't exist yet!
				EList<ElementImport> list = this.profile.getElementImports();

				//We search if this metaclass is imported yet
				//ListIterator<ElementImport> iterator = list.listIterator();
				for(int iter = 0; iter < list.size(); iter++) {
					if(list.get(iter) != null) {
						if(list.get(iter).getImportedElement() != null) {
							if(ei.getImportedElement().getQualifiedName().equals(list.get(iter).getImportedElement().getQualifiedName())) {
								added = list.get(iter);//iterator.previous();
								break;
							}
						}
					}
				}

				//we add the metaclass in metaclassReference
				SetRequest setRequest = new SetRequest(this.profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), added);
				org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(this.profile);

				if(provider != null) {
					ICommand editCommand = null;
					editCommand = provider.getEditCommand(setRequest);
					if(editCommand != null) {
						addindCommand.add(editCommand);
					}
				}
			} else {
				//the metaclass is already imported, nothing to do here!
			}
			this.customRequestAdapter.setNewElement((EObject)this.addedMetaclasses.get(i));
		}
		if(!addindCommand.isEmpty()) {
			return addindCommand;
		}
		return null;
	}


}
