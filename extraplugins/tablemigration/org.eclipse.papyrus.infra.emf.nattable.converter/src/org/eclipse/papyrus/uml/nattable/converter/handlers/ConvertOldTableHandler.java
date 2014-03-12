/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.converter.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.common.modelresource.PapyrusNattableModel;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.nattableconfiguration.NattableConfigurationRegistry;
import org.eclipse.papyrus.infra.nattable.utils.TableHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.nattable.converter.Activator;
import org.eclipse.papyrus.uml.nattable.converter.messages.Messages;
import org.eclipse.swt.widgets.Display;

/**
 * This handler allows to convert ONE old PapyrusTableInstance to a new Papyrus table
 * 
 * @author vl222926
 * 
 */
public class ConvertOldTableHandler extends AbstractHandler {

	public static final String OLD_DEFAULT_TABLE_TYPE = "PapyrusDefaultTable"; //$NON-NLS-1$

	public static final String OLD_REQUIREMENT_TABLE = "PapyrusRequirementTable"; //$NON-NLS-1$

	public static final String OLD_ALLOCATION_TABLE = "PapyrusAllocationTable"; //$NON-NLS-1$

	public static final String PAPYRUS_NEW_DEFAULT_TABLE = "PapyrusGenericTable"; //$NON-NLS-1$

	public static final String PAPYRUS_NEW_REQUIREMENT_TABLE = "PapyrusSysMLRequirementTable"; //$NON-NLS-1$

	public static final String PAPYRUS_NEW_ALLOCATION_TABLE = "PapyrusSysMLAllocationTable"; //$NON-NLS-1$

	protected List<PapyrusTableInstance> oldPapyrusTableInstance;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return null
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		boolean destroyOldTable = false;
		boolean replaceOldRequirementTableByNewRequirementTable = false;
		boolean replaceOldSysMLAllocationTableByNewSysMLAllocationTable = false;
		boolean selectionContainsRequirementsTable = false;
		boolean selectionContainsAllocationTable = false;
		boolean selectionContainsCustomTableKind = false;
		boolean convertCustomTabletoGenericTable = false;
		final List<PapyrusTableInstance> oldTables = oldPapyrusTableInstance;
		if(!oldTables.isEmpty()) {
			for(final PapyrusTableInstance oldTable : oldTables) {
				final String type = oldTable.getType();
				if(OLD_REQUIREMENT_TABLE.equals(type)) {
					selectionContainsRequirementsTable = true;
				}
				if(OLD_ALLOCATION_TABLE.equals(type)) {
					selectionContainsAllocationTable = true;
				}
				if(selectionContainsAllocationTable && selectionContainsRequirementsTable) {
					break;
				}
			}

			String dialogTitle = Messages.ConvertOldTableHandler_ConvertOldTableQuestion;
			boolean answer = MessageDialog.openQuestion(Display.getDefault().getActiveShell(), dialogTitle, Messages.ConvertOldTableHandler_AdvicesForUser);
			if(!answer) {
				return null;
			}

			String dialogGlobalMessage = Messages.ConvertOldTableHandler_DialogMessage;
			String dialogAllocationMessage = String.format(dialogGlobalMessage, "Allocation"); //$NON-NLS-1$
			String dialogRequirementMessage = String.format(dialogGlobalMessage, "Requirement"); //$NON-NLS-1$

			if(selectionContainsAllocationTable) {
				MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), dialogTitle, null, dialogAllocationMessage, MessageDialog.QUESTION_WITH_CANCEL, new String[]{ Messages.ConvertOldTableHandler_ConvertToNewAllocationTable, Messages.ConvertOldTableHandler_ConvertToNewUMLGenericTable, Messages.ConvertOldTableHandler_Cancel }, 0);
				switch(dialog.open()) {
				case 0:
					replaceOldSysMLAllocationTableByNewSysMLAllocationTable = true;
					break;
				case 1:
					replaceOldSysMLAllocationTableByNewSysMLAllocationTable = false;
					break;
				case 2:
					return null;
				}
			}
			if(selectionContainsRequirementsTable) {
				MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), dialogTitle, null, dialogRequirementMessage, MessageDialog.QUESTION_WITH_CANCEL, new String[]{ Messages.ConvertOldTableHandler_ConvertToNewRequirementTable, Messages.ConvertOldTableHandler_ConvertToNewUMLGenericTable, Messages.ConvertOldTableHandler_Cancel }, 0);
				switch(dialog.open()) {
				case 0:
					replaceOldRequirementTableByNewRequirementTable = true;
					break;
				case 1:
					replaceOldRequirementTableByNewRequirementTable = false;
					break;
				case 2:
					return null;

				}
			}
			if(selectionContainsCustomTableKind) {
				convertCustomTabletoGenericTable = MessageDialog.openQuestion(Display.getDefault().getActiveShell(), dialogTitle, Messages.ConvertOldTableHandler_QuestionAboutCustomTable);
			}

			destroyOldTable = MessageDialog.openQuestion(Display.getDefault().getActiveShell(), Messages.ConvertOldTableHandler_ConvertOldTableQuestion, Messages.ConvertOldTableHandler_DestroyTheTableAtTheEndQuestion);
			final CompoundCommand convertCommand = new CompoundCommand();
			TransactionalEditingDomain domain = null;
			try {
				domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(oldTables.get(0));
			} catch (ServiceException e1) {
				Activator.log.error("Can't found the editing domain", e1); //$NON-NLS-1$
			}
			for(final PapyrusTableInstance oldTable : oldTables) {
				final String type = oldTable.getType();

				Table newTable = null;
				if(OLD_DEFAULT_TABLE_TYPE.equals(type)) {
					newTable = getCreateUMLGenericTableCommand(oldTable);
				} else if(OLD_REQUIREMENT_TABLE.equals(type)) {
					if(replaceOldRequirementTableByNewRequirementTable) {
						newTable = getCreateSysMLRequirementTableCommand(oldTable);
					} else {
						newTable = getCreateUMLGenericTableCommand(oldTable);
					}
				} else if(OLD_ALLOCATION_TABLE.equals(type)) {
					if(replaceOldSysMLAllocationTableByNewSysMLAllocationTable) {
						newTable = getCreateSysMLAllocationTableCommand(oldTable);
					} else {
						newTable = getCreateUMLGenericTableCommand(oldTable);
					}
				} else if(convertCustomTabletoGenericTable) {
					newTable = getCreateUMLGenericTableCommand(oldTable);
				} else {
					continue;
				}


				final Resource notationResource = ((ModelSet)oldTable.eResource().getResourceSet()).getAssociatedResource(oldTable, PapyrusNattableModel.TABLE_MODEL_FILE_EXTENSION, true);
				final IPageManager manager = getPageManager(oldTable);//to be sure to have the correct page manager, we do it each time.
				convertCommand.append(getAddToResourceCommand(domain, notationResource, newTable));
				Assert.isNotNull(manager);
				convertCommand.append(getAddToPageManagerCommand(domain, manager, newTable));
				Command tmp = getReplaceExistingTableCommand(domain, oldTable, newTable);
				if(tmp != null) {
					convertCommand.append(tmp);
				}

				if(destroyOldTable) {
					convertCommand.append(getDestroyOldTableCommand(domain, oldTable));
				}
			}


			if(!convertCommand.isEmpty()) {
				domain.getCommandStack().execute(convertCommand);
			}

			// clear the selection
			this.oldPapyrusTableInstance.clear();
		}
		return null;
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param oldTable
	 *        an old table
	 * @return
	 *         the command to destroy the old table
	 */
	protected Command getDestroyOldTableCommand(final TransactionalEditingDomain domain, final PapyrusTableInstance oldTable) {
		final IEditCommandRequest request = new DestroyElementRequest(domain, oldTable, false);
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(oldTable);
		return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
	}

	/**
	 * 
	 * @param oldTable
	 *        an old table
	 * @return
	 *         a new UML Generic Table initialized with the same rows as the old table
	 */
	@SuppressWarnings("deprecation")
	protected Table getCreateUMLGenericTableCommand(final PapyrusTableInstance oldTable) {
		URI uri = NattableConfigurationRegistry.INSTANCE.getConfigurationURI(PAPYRUS_NEW_DEFAULT_TABLE);
		ResourceSet resourceSet = oldTable.eResource().getResourceSet();
		TableConfiguration configuration = (TableConfiguration)resourceSet.getResource(uri, true).getContents().get(0);
		Table newTable = getCreateTableFromConfiguration(oldTable, configuration);
		final AxisManagerRepresentation representation = configuration.getRowHeaderAxisConfiguration().getAxisManagers().get(0);
		for(final EObject element : oldTable.getTable().getElements()) {
			EObjectAxis axis = NattableaxisFactory.eINSTANCE.createEObjectAxis();
			axis.setElement(element);
			axis.setManager(representation);
			newTable.getCurrentRowAxisProvider().getAxis().add(axis);
		}
		return newTable;
	}

	/**
	 * 
	 * @param oldTable
	 *        an old table
	 * @return
	 *         a new SysML Requirement table
	 */
	protected Table getCreateSysMLRequirementTableCommand(final PapyrusTableInstance oldTable) {
		URI uri = NattableConfigurationRegistry.INSTANCE.getConfigurationURI(PAPYRUS_NEW_REQUIREMENT_TABLE);
		ResourceSet resourceSet = oldTable.eResource().getResourceSet();
		TableConfiguration configuration = (TableConfiguration)resourceSet.getResource(uri, true).getContents().get(0);
		return getCreateTableFromConfiguration(oldTable, configuration);
	}

	/**
	 * 
	 * @param oldTable
	 *        the old table
	 * @return
	 *         a new SysML Allocation table
	 * 
	 */
	protected Table getCreateSysMLAllocationTableCommand(final PapyrusTableInstance oldTable) {
		URI uri = NattableConfigurationRegistry.INSTANCE.getConfigurationURI(PAPYRUS_NEW_ALLOCATION_TABLE);
		ResourceSet resourceSet = oldTable.eResource().getResourceSet();
		TableConfiguration configuration = (TableConfiguration)resourceSet.getResource(uri, true).getContents().get(0);
		return getCreateTableFromConfiguration(oldTable, configuration);
	}

	/**
	 * 
	 * @param oldTable
	 *        the old table
	 * @param tableConfiguration
	 *        the configuration to use to initialize it
	 * @return
	 *         the new table initialized with its configuration
	 */
	@SuppressWarnings("deprecation")
	protected Table getCreateTableFromConfiguration(final PapyrusTableInstance oldTable, final TableConfiguration tableConfiguration) {
		return TableHelper.createTable(tableConfiguration, oldTable.getTable().getContext(), oldTable.getName() + "(Converted)", oldTable.getTable().getDescription()); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param domain
	 * @param manager
	 * @param newTable
	 * @return
	 *         the command to add the new table to the page manager
	 */
	protected Command getAddToPageManagerCommand(final TransactionalEditingDomain domain, final IPageManager manager, final Table newTable) {
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				manager.addPage(newTable);
			}
		};
	}

	/**
	 * 
	 * @param domain
	 * @param notationResource
	 * @param newTable
	 * @return
	 *         the command to add the new table to the resouce
	 */

	protected Command getAddToResourceCommand(final TransactionalEditingDomain domain, final Resource notationResource, final Table newTable) {
		return new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				notationResource.getContents().add(newTable);
			}
		};
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param oldTable
	 *        the old table
	 * @param newTable
	 *        the newTable
	 * @return
	 *         the command to replace referenced to old table by references to new table
	 */
	protected Command getReplaceExistingTableCommand(final TransactionalEditingDomain domain, final PapyrusTableInstance oldTable, final Table newTable) {
		final CompoundCommand compoundCommand = new CompoundCommand("Replace Old table Command"); //$NON-NLS-1$
		final ECrossReferenceAdapter crossReferenceAdapter = CrossReferenceAdapter.getCrossReferenceAdapter(oldTable);
		Collection<Setting> settings = crossReferenceAdapter.getNonNavigableInverseReferences(oldTable);

		//replace the references to the old table to reference to the new table
		for(final Setting setting : settings) {
			EStructuralFeature feature = setting.getEStructuralFeature();
			if(feature != DiPackage.eINSTANCE.getPageRef_EmfPageIdentifier()) {//we replace all references excepted references in the page manager
				Command cmd = new RecordingCommand(domain) {

					/**
					 * 
					 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
					 * 
					 */
					@Override
					protected void doExecute() {
						EcoreUtil.replace(setting, oldTable, newTable);
					}
				};
				compoundCommand.append(cmd);
			}
		}
		if(compoundCommand.isEmpty()) {
			return null;
		}
		return compoundCommand;
	}


	/**
	 * 
	 * @param eobject
	 *        an eobject
	 * @return
	 *         the page manager
	 */
	protected IPageManager getPageManager(final EObject eobject) {
		IPageManager manager = null;
		try {
			manager = ServiceUtilsForEObject.getInstance().getIPageManager(eobject);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		return manager;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		this.oldPapyrusTableInstance = new ArrayList<PapyrusTableInstance>();
		if(evaluationContext instanceof IEvaluationContext) {
			Object selection = ((IEvaluationContext)evaluationContext).getDefaultVariable();
			if(selection instanceof Collection<?>) {
				List<?> currentSelection = (selection instanceof List<?>) ? (List<?>)selection : new java.util.ArrayList<Object>((Collection<?>)selection);
				if(currentSelection.size() == 1) {
					Object current = currentSelection.get(0);
						EObject eobject= EMFHelper.getEObject(current);
						if(eobject instanceof PapyrusTableInstance) {

							this.oldPapyrusTableInstance.add((PapyrusTableInstance)eobject);
						}
						setBaseEnabled(this.oldPapyrusTableInstance != null && this.oldPapyrusTableInstance.size() == 1);
						return;
					}
			}
		}
		setBaseEnabled(false);
	}
}
