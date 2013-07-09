/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.IPasteInTableCommandProvider;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.papyrus.uml.tools.utils.UMLStringValueConverter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * 
 * This class allows to get the paste command for the FlowPortTable.
 * This paste used the visible columns to execute the paste action.
 * The columns representing direct features AND stereotype properties are used. Ohters visible columns (like self) are ignored.
 * 
 * 
 */
public class PasteInPapyrusTableCommandProvider implements IPasteInTableCommandProvider {

	/**
	 * the error message for the command
	 */
	protected String pasteErrorMessage = null;

	private static final int MIN_ROWS_FOR_PROGRESS_MONITOR = 5;

	private static final String TYPE_FORMAT_ERROR_MESSAGE = "The String {0} is not valid to create a {1}";

	/**
	 * this map associates EClass to their nameResolutionHelper
	 */
	//	final protected Map<EClass, NameResolutionHelper> nameResolutionHelpers = new HashMap<EClass, NameResolutionHelper>();

	/** this map associates profile qualified name, with name resolution helper */
	final protected Map<String, NameResolutionHelper> stereotypesHelper = new HashMap<String, NameResolutionHelper>();

	//	final protected Map<StereotypePropertyElement, Property> stereotypePropertiesMap = new HashMap<StereotypePropertyElement, Property>();
	//FIXME : change the return command to a GMF Command
	public ICommand getPasteFromFromStringCommand(final TransactionalEditingDomain editingDomain, final Table papyrusTable, final IProgressMonitor commandCreationCancelProvider, final ProgressMonitorDialog commandExecutionProgressMonitor, final String clipboardContents, final INattableModelManager tableManager) {
		//FIXME : verify that the context is a Namespace
		final EMFStringValueConverter stringResolvers = new UMLStringValueConverter((Namespace)papyrusTable.getContext(), TableClipboardUtils.MULTI_VALUE_SEPARATOR);

		//initialize the values
		final CompositeCommand cmd = new CompositeCommand("Paste from String Command");
		final Element tableContext = (Element)papyrusTable.getContext();//FIXME : add a test for that in the isEnabled
		final EReference containementfeature = UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();

		//0. we reset the paste error message
		this.pasteErrorMessage = null;

		//1. we clear the map of the NameResolutionHelpers
		//		this.nameResolutionHelpers.clear();
		//		this.stereotypesHelper.clear();

		//		this.stereotypePropertiesMap.clear();
		final Collection<Stereotype> stereotypeToApply = getStereotypesToApply(papyrusTable, tableManager);

		//3. we get the managed features
		//final List<EStructuralFeature> features = getManagedFeatures(iTableWidget);

		//4. we determine if we should add a command to add the pasted elements in the table
		//		final boolean addToTable = FillMode.USER == papyrusTable.getFillMode();

		final boolean addToTable = !tableManager.getRowAxisManager().isDynamic();//FIXME : rows/columns

		//5. get the rows to create
		final String[] rows = TableClipboardUtils.getRows(clipboardContents);

		//6. this list will be used to add the created elements to the table
		final List<ICommand> createCommands = new ArrayList<ICommand>();

		//7. we launch the dialog used for the command creation
		if(commandCreationCancelProvider != null) {
			commandCreationCancelProvider.beginTask("Initialize Paste Action", rows.length + 1);
		}

		//8. we build the command itself
		final boolean useDialog = (commandExecutionProgressMonitor != null) && (rows.length > MIN_ROWS_FOR_PROGRESS_MONITOR);

		//8.1 create the command to open the progress monitor dialog during the command execution
		if(useDialog) {
			final AbstractTransactionalCommand beginMonitor = new AbstractTransactionalCommand(editingDomain, "Launch Progress Monitor Dialog", Collections.emptyList()) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					commandExecutionProgressMonitor.open();
					commandExecutionProgressMonitor.getProgressMonitor().setTaskName("Pasting In Table");
					commandExecutionProgressMonitor.getProgressMonitor().beginTask("Pasting In Table", rows.length);
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.add(beginMonitor);
		}

		//8.2 we iterate on the rows
		for(final String row : rows) {
			if(useDialog) {
				commandCreationCancelProvider.worked(1);
			}
			if((commandCreationCancelProvider != null) && commandCreationCancelProvider.isCanceled()) {
				//the user click on the cancel button
				return null;
			}

			//8.3 we get the string values of the cells
			final String[] cells = TableClipboardUtils.getCells(row);



			//8.4 bis : update the paste execution dialog
			if(useDialog) {
				final ICommand dialogCommand = new AbstractTransactionalCommand(editingDomain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						commandExecutionProgressMonitor.getProgressMonitor().subTask("Pasting : " + row);
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.add(dialogCommand);
			}

			//8.5 we create the element itself
			//FIXME : we ignore the case where an element with the same name and type already exists
			final CreateElementRequest createRequest = new CreateElementRequest(editingDomain, tableContext, getIElementTypeToCreateElement(papyrusTable), containementfeature);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(tableContext);
			final ICommand commandCreation = provider.getEditCommand(createRequest);
			//we add the creation command to the list of the creation command to be able to add the result of these command to the table

			createCommands.add(commandCreation);

			cmd.add(commandCreation);

			//8.6 we apply the required stereotypes on it
			//FIXME
			//			if(stereotypeToApply.size() != 0) {
			//				final ICommand applyStereotypesCmd = new AbstractTransactionalCommand(editingDomain, "Apply Required Stereotype", null) { //$NON-NLS-1$
			//
			//					@Override
			//					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
			//						final Element el = (Element)commandCreation.getCommandResult().getReturnValue();
			//						final PasteWarningStatus rootStatus = new PasteWarningStatus("Problem to apply stereotype", el);
			//						for(final Stereotype ste : stereotypeToApply) {
			//							if(el.getApplicableStereotype(ste.getQualifiedName()) == null) {
			//								final IStatus status = new StereotypeApplicationErrorStatus(NLS.bind("The Stereotype {0} can't be applied", ste.getQualifiedName(), el), el, ste.getQualifiedName());
			//								rootStatus.addChildren(status);
			//							}
			//							if(el.getAppliedStereotype(ste.getQualifiedName()) == null) {
			//								el.applyStereotype(ste);
			//							}
			//						}
			//						if(rootStatus.isMultiStatus()) {
			//							return new CommandResult(rootStatus, rootStatus);
			//						}
			//						return CommandResult.newOKCommandResult();
			//					}
			//				};
			//				cmd.append(new GMFtoEMFCommandWrapper(applyStereotypesCmd));
			//			}

			//8.7 we set these properties values
			final List<Object> columns = tableManager.getColumnElementsList();

			//			for(int i = 0; i < java.lang.Math.min(cells.length, visibleColumns.size()); i++) {

			for(int i = 0; i < columns.size(); i++) {
				final Object column = columns.get(i);
				final String valueAsString = cells[i];
				final AbstractTransactionalCommand setValuesCommand = new AbstractTransactionalCommand(editingDomain, "Set Value Command", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						final EObject createdElement = (EObject)commandCreation.getCommandResult().getReturnValue();
						//FIXME : doit on toujours l'appeler ou peut-on garder les cellManager associés aux columns? 
						//FIXME : attention au cas du SysML CellManager pour flowport atomic avec N/A!
						ICellManager cellManager = CellManagerFactory.INSTANCE.getCellManager(createdElement, column);
						boolean isEditable = CellManagerFactory.INSTANCE.isCellEditable(createdElement, column);
						if(isEditable) {//FIXME add a test for featureisChangeable!
							final ICommand setValueCommand = cellManager.getSetStringValueCommand(editingDomain, papyrusTable, tableContext, createdElement, column, valueAsString, stringResolvers);
							if(setValueCommand != null && setValueCommand.canExecute()) {
								setValueCommand.execute(null, null);
							}
						}
						return null;
					}
				};

				cmd.add(setValuesCommand);
			}

			//8.8 update the command paste dialog
			if(useDialog) {
				final ICommand dialogCommand = new AbstractTransactionalCommand(editingDomain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						commandExecutionProgressMonitor.getProgressMonitor().worked(1);
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.add(dialogCommand);
			}
		}

		//add the created element to the table
		if(addToTable) {
			final AbstractTransactionalCommand addToTableCommand = new AbstractTransactionalCommand(editingDomain, "Add To Table After Paste Command", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					final Collection<Object> objectsToAdd = Collections.EMPTY_LIST;
					for(final ICommand current : createCommands) {
						objectsToAdd.add(current.getCommandResult().getReturnValue());//FIXME : verify that the object are alwaed in the table
					}
					Command cmd = tableManager.getAddRowElementCommand(objectsToAdd);
					cmd.execute();
					return null;
				}
			};
		}

		//close the dialog used during the paste command execution
		if(useDialog) {
			final AbstractTransactionalCommand endMonitor = new AbstractTransactionalCommand(editingDomain, "Close Progress Monitor Dialog", Collections.emptyList()) { //$NON-NLS-1$

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					commandExecutionProgressMonitor.getProgressMonitor().done();
					commandExecutionProgressMonitor.close();
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.add(endMonitor);
		}

		if(!cmd.isEmpty()) {
			if(cmd.canExecute()) {
				return cmd;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	//FIXME : remove this method
	private IElementType getIElementTypeToCreateElement(Table papyrusTable) {
		final String id = "org.eclipse.papyrus.sysml.FlowPort";//FIXME
		return ElementTypeRegistry.getInstance().getType(id);
	}


	/**
	 * 
	 * 
	 * @param pTable
	 *        the PapyrusTable
	 * @param iTableWidget
	 *        the tableWidget
	 * @return
	 *         the list of the stereotypes to apply on the table. This method can contribute to the
	 *         {@link AbstractPasteInTableCommandProvider#pasteErrorMessage}
	 */
	protected Collection<Stereotype> getStereotypesToApply(final Table pTable, final INattableModelManager iTableWidget)/*
																														 * throws
																														 * ErrorInPastePreparationException
																														 */{
		//FIXME
		//		final Collection<String> stereotypeQualifiedName = new ArrayList<String>();
		//		//for(final Column col : getManagedColumns(iTableWidget)) {
		//		for(final Column col : this.visibleColumns) {
		//			if(col instanceof FeatureColumn) {
		//				final ETypedElement feature = ((FeatureColumn)col).getFeature();
		//				if(feature instanceof StereotypePropertyElement) {
		//					StereotypeFacet facet = (StereotypeFacet)feature.eContainer();
		//					stereotypeQualifiedName.add(facet.getStereotypeQualifiedName());
		//				}
		//			}
		//		}
		//
		//
		//		final List<Profile> appliedProfiles = ((Element)pTable.getTable().getContext()).getNearestPackage().getAllAppliedProfiles();
		final Collection<Stereotype> toApply = new HashSet<Stereotype>();
		//		for(final String steQN : stereotypeQualifiedName) {
		//			final String stereotypeName = NamedElementUtil.getNameFromQualifiedName(steQN);
		//			final String profileQN = NamedElementUtil.getParentQualifiedName(steQN);
		//			NameResolutionHelper helper = stereotypesHelper.get(profileQN);
		//			if(helper == null) {
		//				for(final Profile prof : appliedProfiles) {
		//					if(prof.getQualifiedName().equals(profileQN)) {
		//						helper = new NameResolutionHelper(prof, UMLPackage.eINSTANCE.getStereotype());
		//						final List<NamedElement> foundElement = helper.getNamedElements(stereotypeName);
		//						if(foundElement.size() == 1) {
		//							final Stereotype ste = (Stereotype)foundElement.get(0);
		//							toApply.add(ste);
		//						} else {
		//							throw new ErrorInPastePreparationException(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_RequiredStereotypeCantBeFound, stereotypeName));
		//						}
		//						break;
		//					}
		//				}
		//
		//			}
		//		}
		return toApply;
	}
}
