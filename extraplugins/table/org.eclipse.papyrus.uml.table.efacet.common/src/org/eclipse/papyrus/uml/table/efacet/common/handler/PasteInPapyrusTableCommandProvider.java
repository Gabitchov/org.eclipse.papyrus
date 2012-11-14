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
package org.eclipse.papyrus.uml.table.efacet.common.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.table.efacet.common.exceptions.ErrorInPastePreparationException;
import org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractTableTriggerListener;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.FillMode;
import org.eclipse.papyrus.infra.tools.util.BooleanHelper;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profileefacet.utils.StereotypePropertyUtils;
import org.eclipse.papyrus.uml.table.efacet.common.messages.Messages;
import org.eclipse.papyrus.uml.table.efacet.common.status.PasteErrorStatus;
import org.eclipse.papyrus.uml.table.efacet.common.status.StereotypeApplicationErrorStatus;
import org.eclipse.papyrus.uml.table.efacet.common.status.UnresolvedReferenceErrorInPasteStatus;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * 
 * This class allows to get the paste command for the FlowPortTable.
 * This paste used the visible columns to execute the paste action.
 * The columns representing direct features AND stereotype properties are used. Ohters visible columns (like self) are ignored.
 * 
 * 
 */
public class PasteInPapyrusTableCommandProvider extends AbstractPasteInTableCommandProvider {

	/** the string used for UML boolean */
	private static final String UML_BOOLEAN = "Boolean"; //$NON-NLS-1$

	/** the string used for UML integer */
	private static final String UML_INTEGER = "Integer"; //$NON-NLS-1$

	/** the string used for UML string */
	private static final String UML_STRING = "String"; //$NON-NLS-1$

	/** the string used for uml real */
	private static final String UML_REAL = "Real"; //$NON-NLS-1$

	/** the string used for uml unlimited natural */
	private static final String UML_UNLIMITED_NATURAL = "UnlimitedNatural"; //$NON-NLS-1$

	

	private static final int MIN_ROWS_FOR_PROGRESS_MONITOR = 5;

	private static final String TYPE_FORMAT_ERROR_MESSAGE = Messages.PasteInPapyrusTableCommandProvider_0;

	/**
	 * this map associates EClass to their nameResolutionHelper
	 */
	final protected Map<EClass, NameResolutionHelper> nameResolutionHelpers = new HashMap<EClass, NameResolutionHelper>();

	/** this map associates profile qualified name, with name resolution helper */
	final protected Map<String, NameResolutionHelper> stereotypesHelper = new HashMap<String, NameResolutionHelper>();

	final protected Map<StereotypePropertyElement, Property> stereotypePropertiesMap = new HashMap<StereotypePropertyElement, Property>();

	public Command getPasteFromFromStringCommand(final PapyrusTable papyrusTable, final IProgressMonitor commandCreationCancelProvider, final ProgressMonitorDialog commandExecutionProgressMonitor, final String clipboardContents, final ITableWidget iTableWidget) throws ErrorInPastePreparationException {
		final CompoundCommand cmd = new CompoundCommand(Messages.PasteInPapyrusTableCommandProvider_1);
		final TransactionalEditingDomain editingDomain = getEditingDomain(papyrusTable);
		final Element tableContext = (Element)papyrusTable.getTable().getContext();

		//0. we reset the paste error message
		this.pasteErrorMessage = null;

		//1. we clear the map of the NameResolutionHelpers
		this.nameResolutionHelpers.clear();
		this.stereotypesHelper.clear();
		this.stereotypePropertiesMap.clear();
		final Collection<Stereotype> stereotypeToApply = getStereotypesToApply(papyrusTable, iTableWidget);

		//3. we get the managed features
		final List<EStructuralFeature> features = getManagedFeatures(iTableWidget);

		//4. we determine if we should add a command to add the pasted elements in the table
		final boolean addToTable = FillMode.USER == papyrusTable.getFillMode();

		//5. get the rows to create
		final String[] rows = getRows(clipboardContents);

		//6. this list will be used to add the created elements to the table
		final List<ICommand> createCommands = new ArrayList<ICommand>();

		//7. we launch the dialog used for the command creation
		if(commandCreationCancelProvider != null) {
			commandCreationCancelProvider.beginTask(Messages.PasteInPapyrusTableCommandProvider_2, rows.length + 1);
		}

		//8. we build the command itself
		final boolean useDialog = (commandExecutionProgressMonitor != null) && (rows.length > MIN_ROWS_FOR_PROGRESS_MONITOR);
		//8.1 create the command to open the progress monitor dialog during the command execution
		if(useDialog) {
			final AbstractTransactionalCommand beginMonitor = new AbstractTransactionalCommand(editingDomain, Messages.PasteInPapyrusTableCommandProvider_3, Collections.emptyList()) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					commandExecutionProgressMonitor.open();
					commandExecutionProgressMonitor.getProgressMonitor().setTaskName(Messages.PasteInPapyrusTableCommandProvider_PastingInTable);
					commandExecutionProgressMonitor.getProgressMonitor().beginTask(Messages.PasteInPapyrusTableCommandProvider_PastingInTable, rows.length);
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.append(new GMFtoEMFCommandWrapper(beginMonitor));
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
			final String[] cells = getCells(row);

			//8.4 we get the containement feature for the created object
			final EReference containementfeature = getContainementFeature(papyrusTable);

			//8.4 bis : update the paste execution dialog
			if(useDialog) {
				final ICommand dialogCommand = new AbstractTransactionalCommand(editingDomain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						commandExecutionProgressMonitor.getProgressMonitor().subTask(Messages.PasteInPapyrusTableCommandProvider_Pasting + row);
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.append(new GMFtoEMFCommandWrapper(dialogCommand));
			}

			//8.5 we create the element itself
			//FIXME : we ignore the case where an element with the same name and type already exists
			final CreateElementRequest createRequest = new CreateElementRequest(editingDomain, tableContext, getIElementTypeToCreateElement(papyrusTable), containementfeature);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(tableContext);
			final ICommand commandCreation = provider.getEditCommand(createRequest);
			createCommands.add(commandCreation);
			cmd.append(new GMFtoEMFCommandWrapper(commandCreation));

			//8.6 we apply the required stereotypes on it
			if(stereotypeToApply.size() != 0) {
				final ICommand applyStereotypesCmd = new AbstractTransactionalCommand(editingDomain, "Apply Required Stereotype", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						final Element el = (Element)commandCreation.getCommandResult().getReturnValue();
						final PasteErrorStatus rootStatus = new PasteErrorStatus(Messages.PasteInPapyrusTableCommandProvider_ProblemToApplyStereotype, el);
						for(final Stereotype ste : stereotypeToApply) {
							if(el.getApplicableStereotype(ste.getQualifiedName()) == null) {
								final IStatus status = new StereotypeApplicationErrorStatus(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_TheStereotypeCantBeApplied, ste.getQualifiedName(), el), el, ste.getQualifiedName());
								rootStatus.addChildren(status);
							}
							if(el.getAppliedStereotype(ste.getQualifiedName()) == null) {
								el.applyStereotype(ste);
							}
						}
						if(rootStatus.isMultiStatus()) {
							return new CommandResult(rootStatus, rootStatus);
						}
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.append(new GMFtoEMFCommandWrapper(applyStereotypesCmd));
			}

			//8.7 we set these properties values
			for(int i = 0; i < cells.length; i++) {
				final EStructuralFeature feature = features.get(i);
				final String valueAsString = cells[i];

				if(valueAsString != null && !"".equals(valueAsString) && !"null".equals(valueAsString)) { //$NON-NLS-1$ //$NON-NLS-2$
					final Object realValue = deduceValueFromString((Namespace)tableContext, feature, valueAsString);

					if(realValue != null) {
						//it is a property of stereotype
						if(feature instanceof StereotypePropertyElement) {
							final String steQN = ((StereotypeFacet)feature.eContainer()).getStereotypeQualifiedName();
							final String propertyQN = ((StereotypePropertyElement)feature).getPropertyQualifiedName();
							final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);

							final String cmdName = NLS.bind("Set value for the property {0} of the stereotype {1}.", new String[]{ propertyName, steQN }); //$NON-NLS-1$
							final ICommand setStereotypePropertyValue = new AbstractTransactionalCommand(editingDomain, cmdName, null) {

								@Override
								protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
									final Element createdElement = (Element)commandCreation.getCommandResult().getReturnValue();
									final PasteErrorStatus rootStatus = new PasteErrorStatus(Messages.PasteInPapyrusTableCommandProvider_ProblemToSetStereotypeValue, createdElement);
									//FIXME : the inheritance is not managed
									final Stereotype stereotype = createdElement.getAppliedStereotype(steQN);
									if(stereotype == null) {
										final IStatus status = new StereotypeApplicationErrorStatus(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_RequiredStereotypeNotApplied, steQN, createdElement), createdElement, steQN);
										rootStatus.addChildren(status);
										return new CommandResult(rootStatus, rootStatus);
									}
									if(realValue instanceof Collection<?>) {
										final Collection<Object> valueToSet = new ArrayList<Object>();
										for(final Object current : (Collection<?>)realValue) {
											if(current instanceof UnresolvedReferenceErrorInPasteStatus) {
												((UnresolvedReferenceErrorInPasteStatus)current).setElement(createdElement);
												rootStatus.addChildren((IStatus)current);
											} else {
												valueToSet.add(current);
											}
										}
										if(!valueToSet.isEmpty()) {
											createdElement.setValue(stereotype, propertyName, valueToSet);
										}
									} else {
										if(realValue instanceof UnresolvedReferenceErrorInPasteStatus) {
											((UnresolvedReferenceErrorInPasteStatus)realValue).setElement(createdElement);
											rootStatus.addChildren((IStatus)realValue);
										} else {
											createdElement.setValue(stereotype, propertyName, realValue);
										}
									}
									if(rootStatus.isMultiStatus()) {
										return new CommandResult(rootStatus, rootStatus);
									}
									return CommandResult.newOKCommandResult();
								}
							};

							cmd.append(new GMFtoEMFCommandWrapper(setStereotypePropertyValue));
						} else {//it is a direct feature
							final String label = NLS.bind("Set the value for the feature {0}.", feature.getName()); //$NON-NLS-1$
							final ICommand setValueCommand = new AbstractTransactionalCommand(editingDomain, label, null) {

								@Override
								protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
									final EObject createdElement = (EObject)commandCreation.getCommandResult().getReturnValue();
									final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(createdElement);
									final PasteErrorStatus rootStatus = new PasteErrorStatus(Messages.PasteInPapyrusTableCommandProvider_ProblemsToSetPropertyValue, createdElement);

									if(realValue instanceof Collection) {
										final Collection<Object> valueToSet = new ArrayList<Object>();
										for(final Object current : (Collection<?>)realValue) {
											if(current instanceof UnresolvedReferenceErrorInPasteStatus) {
												((UnresolvedReferenceErrorInPasteStatus)current).setElement(createdElement);
												rootStatus.addChildren((IStatus)current);
											} else {
												valueToSet.add(current);
											}
										}
										if(!valueToSet.isEmpty()) {
											final SetRequest request = new SetRequest(getEditingDomain(), createdElement, feature, valueToSet);
											final ICommand localSetValueCommand = provider.getEditCommand(request);
											localSetValueCommand.execute(monitor, info);
										}
									} else {
										if(realValue instanceof UnresolvedReferenceErrorInPasteStatus) {
											((UnresolvedReferenceErrorInPasteStatus)realValue).setElement(createdElement);
											rootStatus.addChildren((IStatus)realValue);
										} else {
											final SetRequest request = new SetRequest(getEditingDomain(), createdElement, feature, realValue);
											final ICommand localSetValueCommand = provider.getEditCommand(request);
											localSetValueCommand.execute(monitor, info);
										}
									}
									if(rootStatus.isMultiStatus()) {
										return new CommandResult(rootStatus, rootStatus);
									}
									return CommandResult.newOKCommandResult();
								}
							};
							cmd.append(new GMFtoEMFCommandWrapper(setValueCommand));
						}
					}
				}
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
				cmd.append(new GMFtoEMFCommandWrapper(dialogCommand));
			}

		}

		//add the created element to the table
		if(addToTable) {
			final AbstractTransactionalCommand addToTableCMD = new AbstractTransactionalCommand(editingDomain, "Launch Progress Monitor Dialog", Collections.emptyList()) { //$NON-NLS-1$

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					final List<EObject> toAdd = new ArrayList<EObject>();
					for(final ICommand current : createCommands) {
						final EObject createdElement = (EObject)current.getCommandResult().getReturnValue();
						toAdd.add(createdElement);
					}

					//FIXME : we don't test if the created element are allowed in the table
					//I don't know how to do it easily here!
					if(!toAdd.isEmpty()) {
						final ITableCommandFactory factory = AbstractTableTriggerListener.getTableCmdFactory(getEditingDomain(), papyrusTable.eResource().getResourceSet(), papyrusTable.getTable());
						final CompoundCommand cmd2 = new CompoundCommand("Add pasted FlowPort to the table"); //$NON-NLS-1$
						cmd2.append(factory.createAddRowsCommand(toAdd));
						//not required?
						//cmd2.append(factory.createSetFacetSetsCommand(papyrusTable.getTable().getFacetSets()));
						cmd2.execute();
					}
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.append(new GMFtoEMFCommandWrapper(addToTableCMD));

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
			cmd.append(new GMFtoEMFCommandWrapper(endMonitor));
		}

		if(!cmd.isEmpty()) {
			if(cmd.canExecute()) {
				return cmd;
			}
		}
		return UnexecutableCommand.INSTANCE;
	}


	/**
	 * 
	 * @param iTableWidget
	 *        the table widget
	 * @return
	 *         the list of the managed columns. Managed columns are : <li>direct feature columns</li> <li>StereotypeFacetElement columns</li>
	 */
	protected Collection<Column> getManagedColumns(final ITableWidget iTableWidget) {
		final List<Column> managedColumns = (List<Column>)getVisibleColumns(iTableWidget);
		final ListIterator<Column> iter = managedColumns.listIterator();
		while(iter.hasNext()) {
			final Column current = iter.next();
			if(!(current instanceof FeatureColumn)) {
				iter.remove();
			} else {
				final EStructuralFeature feature = (EStructuralFeature)((FeatureColumn)current).getFeature();
				if(feature instanceof StereotypePropertyElement) {
					//it is OK
				} else if(feature instanceof FacetElement) {
					iter.remove();
				}
			}
		}
		return managedColumns;
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
	protected Collection<Stereotype> getStereotypesToApply(final PapyrusTable pTable, final ITableWidget iTableWidget) throws ErrorInPastePreparationException {
		final Collection<String> stereotypeQualifiedName = new ArrayList<String>();
		//for(final Column col : getManagedColumns(iTableWidget)) {
		for(final Column col : this.managedColumns) {
			if(col instanceof FeatureColumn) {
				final ETypedElement feature = ((FeatureColumn)col).getFeature();
				if(feature instanceof StereotypePropertyElement) {
					StereotypeFacet facet = (StereotypeFacet)feature.eContainer();
					stereotypeQualifiedName.add(facet.getStereotypeQualifiedName());
				}
			}
		}


		final List<Profile> appliedProfiles = ((Element)pTable.getTable().getContext()).getNearestPackage().getAllAppliedProfiles();
		final Collection<Stereotype> toApply = new HashSet<Stereotype>();
		for(final String steQN : stereotypeQualifiedName) {
			final String stereotypeName = NamedElementUtil.getNameFromQualifiedName(steQN);
			final String profileQN = NamedElementUtil.getParentQualifiedName(steQN);
			NameResolutionHelper helper = stereotypesHelper.get(profileQN);
			if(helper == null) {
				for(final Profile prof : appliedProfiles) {
					if(prof.getQualifiedName().equals(profileQN)) {
						helper = new NameResolutionHelper(prof, UMLPackage.eINSTANCE.getStereotype());
						final List<NamedElement> foundElement = helper.getNamedElements(stereotypeName);
						if(foundElement.size() == 1) {
							final Stereotype ste = (Stereotype)foundElement.get(0);
							toApply.add(ste);
						} else {
							throw new ErrorInPastePreparationException(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_RequiredStereotypeCantBeFound, stereotypeName));
						}
						break;
					}
				}

			}
		}
		return toApply;
	}


	//FIXME?  use the UML Type Factory? 
	protected Object deduceBooleanValue(final boolean isMany, final String valueAsString) throws ErrorInPastePreparationException {
		Object returnedValue = null;
		if(isMany) {
			final Collection<Boolean> values = new ArrayList<Boolean>();
			for(final String str : valueAsString.split(MULTI_VALUE_SEPARATOR)) {
				final Boolean value = (Boolean)deduceBooleanValue(false, str);
				if(value != null) {
					values.add(value);
				}
			}
			returnedValue = values;
		} else {
			if(BooleanHelper.isBoolean(valueAsString)) {
				returnedValue = Boolean.valueOf(valueAsString);
			} else {
				throw new ErrorInPastePreparationException(NLS.bind(TYPE_FORMAT_ERROR_MESSAGE, valueAsString, UML_BOOLEAN));
			}
		}
		return returnedValue;
	}


	protected Object deduceDoubleValue(final boolean isMany, final String valueAsString) throws ErrorInPastePreparationException {
		Object returnedValue = null;
		if(isMany) {
			final Collection<Double> values = new ArrayList<Double>();
			for(final String str : valueAsString.split(MULTI_VALUE_SEPARATOR)) {
				final Double value = (Double)deduceDoubleValue(false, str);
				if(value != null) {
					values.add(value);
				}
			}
			returnedValue = values;
		} else {
			try {
				returnedValue = Double.valueOf(valueAsString);
			} catch (final NumberFormatException e) {
				throw new ErrorInPastePreparationException(NLS.bind(TYPE_FORMAT_ERROR_MESSAGE, valueAsString, "Double")); //$NON-NLS-1$
			}
		}
		return returnedValue;
	}


	protected Object deduceEnumerationLiteralValue(final boolean isMany, final String valueAsString, final Enumeration enumeration) throws ErrorInPastePreparationException {
		Object returnedValue = null;
		if(isMany) {
			final Collection<EnumerationLiteral> value = new ArrayList<EnumerationLiteral>();
			for(final String str : valueAsString.split(MULTI_VALUE_SEPARATOR)) {
				final EnumerationLiteral lit = (EnumerationLiteral)deduceEnumerationLiteralValue(false, str, enumeration);
				if(lit != null) {
					value.add(lit);
				}
			}
			returnedValue = value;
		} else {
			final EnumerationLiteral lit = (EnumerationLiteral)enumeration.getMember(valueAsString);
			if(lit == null) {
				throw new ErrorInPastePreparationException(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_TheEnumerationLiteralCantBeFound, valueAsString));
			}
			returnedValue = lit;
		}
		return returnedValue;
	}


	/**
	 * 
	 * @param namespace
	 *        the namespace used to look for the pasted eobejct
	 * @param feature
	 *        the feature concerned by this paste
	 * @param eClass
	 *        the type of the wanted element
	 * @param isMany
	 *        <code>true</code> if the property is multivalued
	 * @param valueAsString
	 *        the pasted string
	 * @return
	 *         <ul>
	 *         <li>if the property is monovalued, we return
	 *         <ul>
	 *         <li>the eobject if we found it</li>
	 *         <li>the pasted string if we ddidn't find it</li>
	 *         </ul>
	 *         </li>
	 *         <li>if the property is multivalued, we return
	 *         <ul>
	 *         <li>a list containing the founded element and string for unresolved element</li>
	 * 
	 *         </ul>
	 * 
	 * @warning : the property ErrorInPasteStatus#element has not been setted in the returned status (because we don't know it here, it have not been
	 *          yet created.
	 */
	protected Object deduceEObjectValue(final Namespace namespace, final EStructuralFeature feature, final EClass eClass, final boolean isMany, final String valueAsString) {
		Object returnedValue = null;
		NameResolutionHelper helper = this.nameResolutionHelpers.get(eClass);
		if(helper == null) {
			helper = new NameResolutionHelper(namespace, eClass);
			this.nameResolutionHelpers.put(eClass, helper);
		}
		if(isMany) {
			final Collection<Object> value = new HashSet<Object>();
			for(final String str : valueAsString.split(MULTI_VALUE_SEPARATOR)) {
				final List<NamedElement> elements = helper.getNamedElements(str);
				if(elements.size() == 1) {
					value.add(elements.get(0));
				} else {
					value.add(new UnresolvedReferenceErrorInPasteStatus(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_TheTextCantBeMappedOnAnExistingElement, valueAsString), null, feature, str));
				}
				returnedValue = value;
			}
		} else {
			final List<NamedElement> elements = helper.getNamedElements(valueAsString);
			if(elements.size() == 1) {
				//it is OK
				returnedValue = elements.get(0);
			} else {
				returnedValue = new UnresolvedReferenceErrorInPasteStatus(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_TheTextCantBeMappedOnAnExistingElement, valueAsString), null, feature, valueAsString);
			}
		}
		return returnedValue;
	}


	protected Object deduceIntValue(final boolean isMany, final String valueAsString) throws ErrorInPastePreparationException {
		Object returnedValue = null;
		if(isMany) {
			final Collection<Integer> values = new ArrayList<Integer>();
			for(final String str : valueAsString.split(MULTI_VALUE_SEPARATOR)) {
				final Integer value = (Integer)deduceIntValue(false, str);
				if(value != null) {
					values.add(value);
				}
			}
			returnedValue = values;
		} else {
			try {
				returnedValue = Integer.valueOf(valueAsString);
			} catch (final NumberFormatException e) {
				throw new ErrorInPastePreparationException(NLS.bind(TYPE_FORMAT_ERROR_MESSAGE, valueAsString, UML_INTEGER));
			}
		}
		return returnedValue;
	}


	protected Object deduceStringValue(final boolean isMany, final String valueAsString) {
		Object returnedValue = null;
		if(isMany) {
			final Collection<String> values = new ArrayList<String>();
			for(final String str : valueAsString.split(MULTI_VALUE_SEPARATOR)) {
				values.add(str);
			}
			returnedValue = values;
		} else {
			returnedValue = valueAsString;
		}
		return returnedValue;
	}


	/**
	 * 
	 * @param tableContext
	 *        the table context
	 * @param feature
	 *        the feature
	 * @param valueAsString
	 *        the pasted string for this feature
	 * @return
	 *         the value for the pasted string or <code>null</code> if not found
	 */
	protected Object deduceValueFromString(final Namespace tableContext, final EStructuralFeature feature, final String valueAsString) throws ErrorInPastePreparationException {
		Object realValue = null;
		final int upperbound = feature.getUpperBound();
		boolean isMany = (upperbound > 1 || upperbound == -1);
		EClassifier featureType = null;
		Type type = null;

		//the feature can't be edited
		if(!feature.isChangeable()) {
			return null;
		}
		//we look for the real property
		if(feature instanceof StereotypePropertyElement) {
			Property realFeature = stereotypePropertiesMap.get(feature);
			if(realFeature == null) {
				realFeature = StereotypePropertyUtils.findRealStereotypeProperty(tableContext, (StereotypePropertyElement)feature);
				if(realFeature != null) {
					stereotypePropertiesMap.put((StereotypePropertyElement)feature, realFeature);
				}
			}

			if(realFeature == null) {
				throw new ErrorInPastePreparationException(NLS.bind(Messages.PasteInPapyrusTableCommandProvider_StereotypePropertyCantBeResolved, ((StereotypePropertyElement)feature).getPropertyQualifiedName()));
			}
			//the real property is read only -> we return null;
			if(realFeature.isReadOnly()) {
				return null;
			}

			//we determine feature type for the real property

			type = realFeature.getType();
			if(type instanceof PrimitiveType) {
				final PrimitiveType pType = (PrimitiveType)type;
				final String name = pType.getName();
				if(UML_BOOLEAN.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEBoolean();
				} else if(UML_INTEGER.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEInt();
				} else if(UML_REAL.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEDouble();
				} else if(UML_STRING.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEString();
				} else if(UML_UNLIMITED_NATURAL.equals(name)) {
					featureType = EcorePackage.eINSTANCE.getEInt();
				} else { //custom PrimitiveType
					featureType = EcorePackage.eINSTANCE.getEString();
				}
			} else if(type instanceof Enumeration) {
				featureType = UMLPackage.eINSTANCE.getEnumeration();
			} else if(type instanceof DataType) {
				featureType = EcorePackage.eINSTANCE.getEString();
			} else {
				featureType = type.eClass();
			}
		} else {
			featureType = feature.getEType();
		}

		if(featureType instanceof EDataType) {
			final String typeName = featureType.getName();
			if("String".equals(typeName) || "EString".equals(typeName)) { //$NON-NLS-1$ //$NON-NLS-2$
				realValue = deduceStringValue(isMany, valueAsString);
			} else if("EBoolean".equals(typeName) || "Boolean".equals(typeName)) { //$NON-NLS-1$ //$NON-NLS-2$
				realValue = deduceBooleanValue(isMany, valueAsString);
			} else if("EInt".equals(typeName) || "Integer".equals(typeName)) { //$NON-NLS-1$ //$NON-NLS-2$
				realValue = deduceIntValue(isMany, valueAsString);
			} else if("EDouble".equals(typeName)) { //$NON-NLS-1$
				realValue = deduceDoubleValue(isMany, valueAsString);
			}
		} else if(featureType instanceof EClass) {
			if("Enumeration".equals(featureType.getName())) { //$NON-NLS-1$
				realValue = deduceEnumerationLiteralValue(isMany, valueAsString, (Enumeration)type);
			} else {
				realValue = deduceEObjectValue(tableContext, feature, (EClass)featureType, isMany, valueAsString);
			}
		}
		return realValue;
	}


	@Override
	public boolean isPasteEnabled(PapyrusTable papyrusTable, String clipboardContents, ITableWidget iTableWidget) {
		this.managedColumns = getManagedColumns(iTableWidget);
		return super.isPasteEnabled(papyrusTable, clipboardContents, iTableWidget);
	}
	
}
