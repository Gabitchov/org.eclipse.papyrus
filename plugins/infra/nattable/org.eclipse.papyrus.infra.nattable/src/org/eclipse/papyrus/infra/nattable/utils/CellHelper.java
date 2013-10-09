package org.eclipse.papyrus.infra.nattable.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.ICellAxisWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.IdAxisWrapper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem;
import org.eclipse.papyrus.infra.nattable.paste.IValueSetter;
import org.eclipse.papyrus.infra.nattable.paste.ReferenceValueSetter;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.converter.ConvertedValueContainer;
import org.eclipse.papyrus.infra.tools.converter.StringValueConverterStatus;


public class CellHelper {

	private CellHelper() {
		//to prevent instanciation
	}

	/**
	 * Create the string problems if required
	 * 
	 * @param tableManager
	 * @param columnElement
	 * @param rowElement
	 * @param pastedText
	 * @param valueContainer
	 * @param sharedMap
	 */
	public static final void createStringResolutionProblem(final INattableModelManager tableManager, final Object columnElement, final Object rowElement, final String pastedText, final ConvertedValueContainer<?> valueContainer, final Map<?, ?> sharedMap) {
		final IStatus status = valueContainer.getStatus();
		if(!status.isOK()) {
			if(status.matches(IStatus.ERROR)) {
				@SuppressWarnings("unchecked")
				final List<IValueSetter> references = (List<IValueSetter>)sharedMap.get(Constants.REFERENCES_TO_SET_KEY);
				if(status.matches(IStatus.ERROR)) {
					Cell cell = tableManager.getCell(columnElement, rowElement);

					if(cell == null) {
						//we create the cell
						cell = NattablecellFactory.eINSTANCE.createCell();

						//create the columnWrapper;
						final Object column = AxisUtils.getRepresentedElement(columnElement);
						ICellAxisWrapper columnWrapper = null;
						if(column instanceof String) {
							columnWrapper = NattablecellFactory.eINSTANCE.createIdAxisWrapper();
							((IdAxisWrapper)columnWrapper).setElement((String)column);
						} else if(column instanceof EObject) {
							columnWrapper = NattablecellFactory.eINSTANCE.createEObjectAxisWrapper();
							ReferenceValueSetter structure = new ReferenceValueSetter(columnWrapper, NattablecellPackage.eINSTANCE.getEObjectAxisWrapper_Element(), column);
							references.add(structure);
						}

						final Object row = AxisUtils.getRepresentedElement(rowElement);
						ICellAxisWrapper rowWrapper = null;
						if(row instanceof String) {
							rowWrapper = NattablecellFactory.eINSTANCE.createIdAxisWrapper();
							((IdAxisWrapper)rowWrapper).setElement((String)row);
						} else if(row instanceof EObject) {
							rowWrapper = NattablecellFactory.eINSTANCE.createEObjectAxisWrapper();
							ReferenceValueSetter structure = new ReferenceValueSetter(rowWrapper, NattablecellPackage.eINSTANCE.getEObjectAxisWrapper_Element(), row);
							references.add(structure);
						}

						if(rowWrapper == null || columnWrapper == null) {
							throw new UnsupportedOperationException("Case not managed"); //$NON-NLS-1$
						}
						cell.setColumnWrapper(columnWrapper);
						cell.setRowWrapper(rowWrapper);
						@SuppressWarnings("unchecked")
						final List<Cell> cells = (List<Cell>)sharedMap.get(Constants.CELLS_TO_ADD_KEY);
						cells.add(cell);


					}


					final StringResolutionProblem problem = NattableproblemFactory.eINSTANCE.createStringResolutionProblem();
					problem.setName("Set Value As Text Problem"); //$NON-NLS-1$
					problem.setDescription(status.getMessage());
					problem.setValueAsString(pastedText);

					if(status instanceof StringValueConverterStatus) {
						problem.getUnresolvedString().addAll(((StringValueConverterStatus)status).getUnresolvedString());
					}

					if(cell.eContainer() == null) {
						cell.eSet(NattablecellPackage.eINSTANCE.getCell_Problems(), Collections.singleton(problem));
					} else {
						final ReferenceValueSetter structure = new ReferenceValueSetter(cell, NattablecellPackage.eINSTANCE.getCell_Problems(), problem);
						references.add(structure);
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param domain
	 *        the editing domain
	 * @param tableManager
	 *        the table manager
	 * @param rowElement
	 *        the row element
	 * @param columnElement
	 *        the column element
	 * @param pastedText
	 *        the pasted text
	 * @param valueContainer
	 *        the converted value
	 * @return
	 *         the command to create a String resolution Problem
	 */
	public static final Command getCreateStringResolutionProblemCommand(final TransactionalEditingDomain domain, final INattableModelManager tableManager, final Object columnElement, final Object rowElement, final String pastedText, final ConvertedValueContainer<?> valueContainer) {
		final IStatus status = valueContainer.getStatus();
		if(!status.isOK()) {
			if(status.matches(IStatus.ERROR)) {
				final CompositeCommand command = new CompositeCommand("Create Cell For Error Command"); //$NON-NLS-1$
				Cell cell = tableManager.getCell(columnElement, rowElement);

				if(cell == null) {
					//we create the cell
					final Table table = tableManager.getTable();
					cell = NattablecellFactory.eINSTANCE.createCell();

					SetRequest request = new SetRequest(domain, table, NattablePackage.eINSTANCE.getTable_Cells(), cell);
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(table);
					command.add(provider.getEditCommand(request));

					//create the columnWrapper;
					final Object column = AxisUtils.getRepresentedElement(columnElement);
					ICellAxisWrapper columnWrapper = null;
					if(column instanceof String) {
						columnWrapper = NattablecellFactory.eINSTANCE.createIdAxisWrapper();
						provider = ElementEditServiceUtils.getCommandProvider(columnWrapper);
						request = new SetRequest(domain, columnWrapper, NattablecellPackage.eINSTANCE.getIdAxisWrapper_Element(), column);
						command.add(provider.getEditCommand(request));
					} else if(column instanceof EObject) {
						columnWrapper = NattablecellFactory.eINSTANCE.createEObjectAxisWrapper();
						provider = ElementEditServiceUtils.getCommandProvider(columnWrapper);
						request = new SetRequest(domain, columnWrapper, NattablecellPackage.eINSTANCE.getEObjectAxisWrapper_Element(), column);
						command.add(provider.getEditCommand(request));
					}

					final Object row = AxisUtils.getRepresentedElement(rowElement);
					ICellAxisWrapper rowWrapper = null;
					if(row instanceof String) {
						rowWrapper = NattablecellFactory.eINSTANCE.createIdAxisWrapper();
						provider = ElementEditServiceUtils.getCommandProvider(rowWrapper);
						request = new SetRequest(domain, rowWrapper, NattablecellPackage.eINSTANCE.getIdAxisWrapper_Element(), row);
						command.add(provider.getEditCommand(request));
					} else if(row instanceof EObject) {
						rowWrapper = NattablecellFactory.eINSTANCE.createEObjectAxisWrapper();
						provider = ElementEditServiceUtils.getCommandProvider(rowWrapper);
						request = new SetRequest(domain, rowWrapper, NattablecellPackage.eINSTANCE.getEObjectAxisWrapper_Element(), row);
						command.add(provider.getEditCommand(request));
					}

					if(rowWrapper == null || columnWrapper == null) {
						throw new UnsupportedOperationException("Case not managed"); //$NON-NLS-1$
					}


					provider = ElementEditServiceUtils.getCommandProvider(cell);
					request = new SetRequest(domain, cell, NattablecellPackage.eINSTANCE.getCell_ColumnWrapper(), columnWrapper);
					command.add(provider.getEditCommand(request));
					request = new SetRequest(domain, cell, NattablecellPackage.eINSTANCE.getCell_RowWrapper(), rowWrapper);
					command.add(provider.getEditCommand(request));
				}
				final List<Problem> problems = cell.getProblems();
				StringResolutionProblem problem = null;
				for(final Problem current : problems) {
					if(current instanceof StringResolutionProblem) {
						problem = (StringResolutionProblem)current;
						break;
					}
				}

				//we create a new string problem
				if(problem == null) {
					problem = NattableproblemFactory.eINSTANCE.createStringResolutionProblem();
					problem.setName("Set Value As Text Problem"); //$NON-NLS-1$
					problem.setDescription(status.getMessage());
					problem.setValueAsString(pastedText);

					if(status instanceof StringValueConverterStatus) {
						problem.getUnresolvedString().addAll(((StringValueConverterStatus)status).getUnresolvedString());
						SetRequest setProblemRequest = new SetRequest(domain, cell, NattablecellPackage.eINSTANCE.getCell_Problems(), problem);
						IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cell);
						command.add(provider.getEditCommand(setProblemRequest));
					} else {//we update the string problem
						IElementEditService provider = ElementEditServiceUtils.getCommandProvider(problem);
						SetRequest request = new SetRequest(domain, problem, NattableproblemPackage.eINSTANCE.getStringResolutionProblem_ValueAsString(), pastedText);
						command.add(provider.getEditCommand(request));
						request = new SetRequest(domain, problem, NattableproblemPackage.eINSTANCE.getStringResolutionProblem_UnresolvedString(), ((StringValueConverterStatus)status).getUnresolvedString());
						command.add(provider.getEditCommand(request));
						request = new SetRequest(domain, problem, NattableconfigurationPackage.eINSTANCE.getTableNamedElement_Description(), status.getMessage());
						command.add(provider.getEditCommand(request));
					}
				}

				return new GMFtoEMFCommandWrapper(command);
			}
		}
		return null;
	}

}
