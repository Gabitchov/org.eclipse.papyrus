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
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetElement;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.ui.command.ITableCommandFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractTableTriggerListener;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.impl.StereotypePropertyElementImpl;
import org.eclipse.papyrus.uml.tools.utils.NameResolutionHelper;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
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

	private static final int MIN_ROWS_FOR_PROGRESS_MONITOR = 5;

	/**
	 * this map associate EClass to their nameResolutionHelper
	 */
	final protected Map<EClass, NameResolutionHelper> nameResolutionHelpers = new HashMap<EClass, NameResolutionHelper>();

	/**
	 *
	 * @param columns
	 *        a collection of columns
	 * @return
	 *         a collection of the qualified name of the required steretoypes according to the columns passed as parameters
	 */
	protected final Collection<String> getRequiredStereotypeFromColumns(final Collection<Column> columns) {
		final Collection<String> steretoypesQN = new HashSet<String>();
		for(final Column current : columns) {
			if(current instanceof FeatureColumn) {
				final EStructuralFeature feature = (EStructuralFeature)((FeatureColumn)current).getFeature();
				if(feature instanceof StereotypePropertyElementImpl) {
					final StereotypeFacet facet = (StereotypeFacet)feature.eContainer();
					steretoypesQN.add(facet.getStereotypeQualifiedName());
				}
			}
		}
		return steretoypesQN;
	}

	public Command getPasteFromFromStringCommand(final PapyrusTable papyrusTable, final IProgressMonitor commandCreationCancelProvider, final ProgressMonitorDialog commandExecutionProgressMonitor, final String clipboardContents, final ITableWidget iTableWidget) {
		final CompoundCommand cmd = new CompoundCommand("Paste Command In FlowPort Table");
		final TransactionalEditingDomain editingDomain = getEditingDomain(papyrusTable);
		final Element tableContext = (Element)papyrusTable.getTable().getContext();

		//0. we reset the paste error message
		this.pasteErrorMessage = null;

		//1. we clear the map of the NameResolutionHelper
		this.nameResolutionHelpers.clear();
		final Collection<Stereotype> stereotypeToApply = getStereotypesToApply(papyrusTable);
		//2. we create the resolution helper for stereotype
		if(stereotypeToApply.size() != 0) {
			final NameResolutionHelper stereotypeHelper = new NameResolutionHelper(PackageUtil.getRootPackage(tableContext), UMLPackage.eINSTANCE.getStereotype());
			this.nameResolutionHelpers.put(UMLPackage.eINSTANCE.getStereotype(), stereotypeHelper);
		}

		//3. we get the managed features
		final List<EStructuralFeature> features = getManagedFeatures(iTableWidget);

		//4. we determine if we should add a command to add the pasted elements in the table
		final boolean addToTable = FillingMode.USER.equals(papyrusTable.getFillingMode());

		//5. get the rows to create
		final String[] rows = getRows(clipboardContents);

		//6. this list will be used to add the created elements to the table
		final List<ICommand> createCommands = new ArrayList<ICommand>();

		//7. we launch the dialog used for the command creation
		if(commandCreationCancelProvider != null) {
			commandCreationCancelProvider.beginTask("Create Paste Action", rows.length + 1);
		}

		//8. we build the command itself
		final boolean useDialog = (commandExecutionProgressMonitor != null) && (rows.length > MIN_ROWS_FOR_PROGRESS_MONITOR);
		//8.1 create the command to open the progress monitor dialog during the command execution
		if(useDialog) {
			final AbstractTransactionalCommand beginMonitor = new AbstractTransactionalCommand(editingDomain, "Launch Progress Monitor Dialog", Collections.emptyList()) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					commandExecutionProgressMonitor.open();
					commandExecutionProgressMonitor.getProgressMonitor().setTaskName("Pasting in Table");
					commandExecutionProgressMonitor.getProgressMonitor().beginTask("Pasting In Table", rows.length);
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
			final EReference containementfeature = papyrusTable.getPasteElementContainementFeature();

			//8.4 bis : update the paste excecution dialog
			if(useDialog) {
				final ICommand dialogCommand = new AbstractTransactionalCommand(editingDomain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						commandExecutionProgressMonitor.getProgressMonitor().subTask("Pasting " + row);
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.append(new GMFtoEMFCommandWrapper(dialogCommand));
			}

			//8.5 we create the element itself
			//FIXME : we ignore the case where an element with the same name and type already exists
			final CreateElementRequest createRequest = new CreateElementRequest(editingDomain, tableContext, getIHintedTypeToCreateElement(papyrusTable), containementfeature);
			final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(tableContext);
			final ICommand commandCreation = provider.getEditCommand(createRequest);
			createCommands.add(commandCreation);
			cmd.append(new GMFtoEMFCommandWrapper(commandCreation));

			//8.6 we apply the required stereotypes on it
			if(stereotypeToApply.size() != 0) {
				final ICommand applyStereotypesCmd = new AbstractTransactionalCommand(editingDomain, "Apply Required Stereotype", null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						//TODO with service edit?
						final Element el = (Element)commandCreation.getCommandResult().getReturnValue();
						for(final Stereotype ste : stereotypeToApply) {
							el.applyStereotype(ste);
						}
						return CommandResult.newOKCommandResult();
					}
				};
				cmd.append(new GMFtoEMFCommandWrapper(applyStereotypesCmd));
			}

			//8.7 we set these properties values
			for(int i = 0; i < cells.length; i++) {
				final EStructuralFeature feature = features.get(i);
				final int upperbound = feature.getUpperBound();
				final String valueAsString = cells[i];

				if(valueAsString != null && !"".equals(valueAsString) && !"null".equals(valueAsString)) {
					final Object realValue = deduceRealValue((Namespace)tableContext, feature, valueAsString);
					//it is a property of stereotype
					if(feature instanceof StereotypePropertyElementImpl) {
						final String steQN = ((StereotypeFacet)feature.eContainer()).getStereotypeQualifiedName();
						final String propertyName = ((StereotypePropertyElementImpl)feature).getPropertyName();

						final String cmdName = NLS.bind("Set value for the property {0} of the stereotype {1}.", new String[]{ propertyName, steQN });
						final ICommand setStereotypePropertyValue = new AbstractTransactionalCommand(editingDomain, cmdName, null) {//FIXME : remove the null

							@Override
							protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
								final Element createdElement = (Element)commandCreation.getCommandResult().getReturnValue(); //TODO request for stereotype application?
								final Stereotype stereotype = createdElement.getAppliedStereotype(steQN);
								createdElement.setValue(stereotype, propertyName, realValue);
								return CommandResult.newOKCommandResult(createdElement);
							}
						};

						cmd.append(new GMFtoEMFCommandWrapper(setStereotypePropertyValue));
					} else {//it is a direct feature
						final String label = NLS.bind("Set the value for the feature {0}.", feature.getName());
						final ICommand setValueCommand = new AbstractTransactionalCommand(editingDomain, label, null) {

							@Override
							protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
								final EObject createdElement = (EObject)commandCreation.getCommandResult().getReturnValue();
								final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(createdElement);
								final SetRequest request = new SetRequest(getEditingDomain(), createdElement, feature, realValue);
								final ICommand localSetValueCommand = provider.getEditCommand(request);
								localSetValueCommand.execute(monitor, info);
								return null;
							}
						};
						cmd.append(new GMFtoEMFCommandWrapper(setValueCommand));
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
			final AbstractTransactionalCommand addToTableCMD = new AbstractTransactionalCommand(editingDomain, "Launch Progress Monitor Dialog", Collections.emptyList()) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					final List<EObject> toAdd = new ArrayList<EObject>();
					for(final ICommand current : createCommands) {
						final EObject createdElement = (EObject)current.getCommandResult().getReturnValue();
						toAdd.add(createdElement);
					}

					if(!toAdd.isEmpty()) {
						final ITableCommandFactory factory = AbstractTableTriggerListener.getTableCmdFactory(getEditingDomain(), papyrusTable.eResource().getResourceSet(), papyrusTable.getTable());
						final CompoundCommand cmd2 = new CompoundCommand("Add pasted FlowPort to the table");
						cmd2.append(factory.createAddRowsCommand(toAdd));
						cmd2.append(factory.createSetFacetSetsCommand(papyrusTable.getTable().getFacetSets()));
						cmd2.execute();
					}
					return CommandResult.newOKCommandResult();
				}
			};
			cmd.append(new GMFtoEMFCommandWrapper(addToTableCMD));

		}

		//close the dialog used during the paste command execution
		if(useDialog) {
			final AbstractTransactionalCommand endMonitor = new AbstractTransactionalCommand(editingDomain, "Close Progress Monitor Dialog", Collections.emptyList()) {

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

	protected Object deduceRealValue(final Namespace tableContext, final EStructuralFeature feature, final String valueAsString) {
		Object realValue = null;
		final int upperbound = feature.getUpperBound();
		if(upperbound > 1) {
			realValue = new ArrayList<Object>();
		}
		EStructuralFeature featureToUse = null;

		if(feature instanceof StereotypePropertyElementImpl) {
			final String propertyName = ((StereotypePropertyElementImpl)feature).getPropertyName();
			final String steQn = ((StereotypeFacet)feature.eContainer()).getStereotypeQualifiedName();
			final NameResolutionHelper stereotypeHelper = this.nameResolutionHelpers.get(UMLPackage.eINSTANCE.getStereotype());
			final Stereotype ste = (Stereotype)stereotypeHelper.getNamedElements(steQn);
			final Property prop = (Property)ste.getMember(propertyName);//FIXME and the inherited property
			final Type type = prop.getType();

			//TODO
		} else {
			featureToUse = feature;


		}

		final EClassifier featureType = featureToUse.getEType();




		if(featureType instanceof EDataType) {
			final String typeName = featureType.getName();
			if("String".equals(typeName)) {
				realValue = new String(valueAsString);
			}
		} else if(featureType instanceof EClass) {//TODO works only for monovalue
			NameResolutionHelper helper = this.nameResolutionHelpers.get(featureType);
			if(helper == null) {
				helper = new NameResolutionHelper(tableContext, (EClass)featureType);
				this.nameResolutionHelpers.put((EClass)featureType, helper);
			}
			final List<NamedElement> elements = helper.getNamedElements(valueAsString);
			if(elements.size() == 1) {
				//it is OK
				realValue = elements.get(0);
			} else {
				//TODO : create a proxy
			}
		}

		//TODO : and proxy for primitive type? not possible?
		//		if(realValue==null){
		final EObject current = EMFCoreUtil.createProxy(UMLPackage.eINSTANCE.getPort(), null);
//		((InternalEObject)current).eI
//		int i = 0;
//		i++;
		//		}

		return realValue;
	}

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
					//FIXME
					if(feature.getName().equals("self")) {//seulement là pour le temps du développement, on peut ensuite le remplacer par le test suivant!
						iter.remove();
					}
					//iter.remove(); //TODO correct way
				}
			}
		}
		return managedColumns;
	}


	protected List<EStructuralFeature> getManagedFeatures(final ITableWidget iTableWidget) {
		final List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		for(final Column col : getManagedColumns(iTableWidget)) {
			features.add((EStructuralFeature)((FeatureColumn)col).getFeature());
		}
		return features;
	}

	/**
	 *
	 * @param table
	 *        a table represented by a String
	 * @return the rows for this table
	 */
	private String[] getRows(final String table) {
		final String[] rows = table.split("\n"); // TODO ROW_separator
		return rows;
	}

	/**
	 *
	 * @param row
	 *        a row represented by a String
	 * @return the cells for this row
	 */
	private String[] getCells(final String row) {
		return row.split(COLUMN_SEPARATOR);
	}

	/**
	 *
	 * @param clipboardContents
	 * @see org.eclipse.papyrus.infra.table.efacet.common.editor.AbstractTableEditor#isPasteEnabled(java.lang.String)
	 *
	 * @return
	 */
	public boolean isPasteEnabled(final PapyrusTable papyrusTable, final String clipboardContents, final ITableWidget iTableWidget) {
		//TODO : verify that the created element are not forbidden in the table

		// TODO 3. verify the allowed contetnswe verify that the configuration of the table has not be changed
		// since the table creation
		//				final ETypedElement canBePresented = papyrusTable.getTable().getCanBePresentedInTheTable();
		//				if(canBePresented != null && canBePresented != papyrusTable.getTable().getTableConfiguration().getCanBePresentedInTheTable()) {
		//					this.pasteErrorMessage = "The allowed contents of this table has been changed";
		//					return null;
		//				}

		//TODO verify the filling Mode
		if((clipboardContents != null) && !"".equals(clipboardContents)) {
			final String[] rows = getRows(clipboardContents);
			//TODO verify that each managed columns is useful for the pasted element type
			//TODO verify that the steretoypes to apply are available
			//TODO verify that the steretoype required by the columns are available
			//TODo verify that the containement feature is availbale in the table context
			if((rows != null) && (getIHintedTypeToCreateElement(papyrusTable) != null) && (rows.length == getVisibleColumns(iTableWidget).size()) && (rows.length != 0)) {
				return true;
				// final String[] cells = getCells(rows[0]);
				// return cells.length == 5;
			}
		}
		//FIXME
		//		return false;
		return true;
	}


	protected Collection<Stereotype> getStereotypesToApply(final PapyrusTable pTable) {
		final Collection<Stereotype> toApply = new ArrayList<Stereotype>();
		final Map<String, Set<String>> profilesAndSteretoypes = getRequiredProfileQualifiedNameAndSteretoypesNameToApply(pTable);
		final EObject context = pTable.getTable().getContext();
		org.eclipse.uml2.uml.Package pack = null;
		if(context instanceof Element) {
			final Element el = (Element)context;
			pack = el.getNearestPackage();
		}
		for(final String profileQN : profilesAndSteretoypes.keySet()) {
			final Profile prof = pack.getAppliedProfile(profileQN, true);
			for(final String stereotypeName : profilesAndSteretoypes.get(profileQN)) {
				final Stereotype ste = prof.getOwnedStereotype(stereotypeName, false);
				if(ste != null) {
					toApply.add(ste);
				}
			}
		}

		return toApply;
	}

	/**
	 *
	 * @param domain
	 *        the editing domain
	 * @param type
	 *        the type of the object to create
	 * @return
	 *         the containement feature for the object
	 */
	protected EReference deduceContainementFeature(final TransactionalEditingDomain domain, final EObject container, final IHintedType type) {
		//TODO : we need to add this information in the table metamodel
		return UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute();
	}

	/**
	 *
	 * @param pTable
	 *        the papyrus table
	 * @return
	 *         the type of element to create for a paste action
	 */
	protected IElementType getIHintedTypeToCreateElement(final PapyrusTable pTable) {
		String id = pTable.getPastedElementId();
		//FIXME :
		id = "org.eclipse.papyrus.sysml.FlowPort";
		return ElementTypeRegistry.getInstance().getType(id);
	}

	//FIXME : verify the index
	protected Map<String, Set<String>> getRequiredProfileQualifiedNameAndSteretoypesNameToApply(final PapyrusTable pTable) {
		final Map<String, Set<String>> profileStereotypesMap = new HashMap<String, Set<String>>();
		//FIXME
		final String ste = "SysML::PortAndFlows::FlowPort";

		final List<String> steToApply = new ArrayList<String>(/* pTable.getStereotypesToApplyOnPastedElement() */);
		steToApply.add(ste);
		//		for(final String steretoypeQualifiedName :pTable.getStereotypesToApplyOnPastedElement() ) {
		for(final String steretoypeQualifiedName : steToApply) {
			final int index = steretoypeQualifiedName.lastIndexOf("::");
			final String profileQN = steretoypeQualifiedName.substring(0, index);
			final String stereotypeName = steretoypeQualifiedName.substring(index + "::".length(), steretoypeQualifiedName.length());
			Set<String> values = profileStereotypesMap.get(profileQN);
			if(values == null) {
				values = new HashSet<String>();
				values.add(stereotypeName);
				profileStereotypesMap.put(profileQN, values);
			} else {
				values.add(stereotypeName);
			}

		}
		return profileStereotypesMap;
	}

	/**
	 *
	 * @param widget
	 *        the table widget
	 * @return
	 *         the visible columns for the widget
	 */
	private Collection<Column> getVisibleColumns(final ITableWidget widget) {
		return new ArrayList<Column>(widget.getVisibleColumns(false));//FIXME false or true ?
	}
}
