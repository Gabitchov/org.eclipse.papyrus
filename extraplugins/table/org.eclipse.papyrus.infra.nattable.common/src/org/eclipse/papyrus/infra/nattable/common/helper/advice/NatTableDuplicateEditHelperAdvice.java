/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.helper.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.commands.IPapyrusDuplicateCommandConstants;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.modelresource.PapyrusNattableModel;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;


/**
 * Edit Helper advice to add Table duplication when duplicating
 * 
 * Duplicated and Adapted code from GMFDiagramDuplicatedEditHelperAdvice
 */
public class NatTableDuplicateEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDuplicateCommand(DuplicateElementsRequest request) {
		Object additional = request.getParameter(IPapyrusDuplicateCommandConstants.ADDITIONAL_DUPLICATED_ELEMENTS);
		// additional element should be a set of elements that will be duplicated. If this is null, the request will be ignored.
		if(!(additional instanceof Set<?>)) {
			return super.getBeforeDuplicateCommand(request);
		}

		Set<Object> duplicatedObjects = ((Set<Object>)additional);
		EObject object = getDuplicatedEObject(request);
		if(object == null || object.eResource()==null) {
			return super.getBeforeDuplicateCommand(request);
		}

		// retrieve the Tables linked to the object
		List<Table> tablesToDuplicate = new ArrayList<Table>();

		ResourceSet resourceSet = object.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if(adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}

		// do not proceed for graphical elements, which will have evident relationships to Diagrams (owner, etc.)
		//not required for Table
		//		if(object instanceof View) {
		//			return super.getBeforeDuplicateCommand(request);
		//		}

		// check for the element itself
		Collection<Setting> settings = adapter.getInverseReferences(object, false);
		for(Setting setting : settings) {
			EObject value = setting.getEObject();
			if(value instanceof Table) {
				tablesToDuplicate.add((Table)value);
			}
		}

		// check for sub-elements
		for(Iterator<EObject> it = object.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			settings = adapter.getInverseReferences(child, false);

			for(Setting setting : settings) {
				EObject value = setting.getEObject();
				if(value instanceof Table) {
					tablesToDuplicate.add((Table)value);
				}
			}
		}


		if(!tablesToDuplicate.isEmpty()) {
			CompositeCommand command = null;
			// create the command for all the Tables that have no command ready
			for(Table TableToDuplicate : tablesToDuplicate) {
				if(!duplicatedObjects.contains(TableToDuplicate)) {
					if(command == null) {
						command = new CompositeCommand("", Arrays.asList(new DuplicateTableCommand(request.getEditingDomain(), "Duplicate Table", TableToDuplicate, request.getAllDuplicatedElementsMap()))); //$NON-NLS-1$ //$NON-NLS-2$
					} else {
						command.add(new DuplicateTableCommand(request.getEditingDomain(), "Duplicate Table", TableToDuplicate, request.getAllDuplicatedElementsMap())); //$NON-NLS-1$
					}
					duplicatedObjects.add(TableToDuplicate);
				}
			}

			if(command != null) {
				if(super.getBeforeDuplicateCommand(request) != null) {
					command.add(super.getBeforeDuplicateCommand(request));
					return command.reduce();
				} else {
					return command.reduce();

				}
			}
		}

		return super.getBeforeDuplicateCommand(request);
	}

	/**
	 * Returns the EObject to be duplicated
	 * 
	 * @return the EObject to be duplicated
	 */
	protected EObject getDuplicatedEObject(DuplicateElementsRequest request) {
		List<Object> elementsToBeDuplicated = request.getElementsToBeDuplicated();
		if(elementsToBeDuplicated == null || elementsToBeDuplicated.isEmpty()) {
			return null;
		}
		Object elementToBeDuplicated = elementsToBeDuplicated.get(0);
		if(elementToBeDuplicated instanceof EObject) {
			return ((EObject)elementToBeDuplicated);
		}
		return null;
	}

	/**
	 * Command to duplicate Tables. This adds the Table to the resource containing the source Table.
	 */
	public class DuplicateTableCommand extends DuplicateEObjectsCommand {

		/** Table to be duplicated */
		private final Table TableToDuplicate;

		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects.
		 * 
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param Table
		 *        <code>Table</code> to be duplicated.
		 */
		public DuplicateTableCommand(TransactionalEditingDomain editingDomain, String label, Table Table) {
			super(editingDomain, label, Collections.singletonList(Table));
			this.TableToDuplicate = Table;
		}

		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects.
		 * 
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param Table
		 *        <code>Table</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 */
		public DuplicateTableCommand(TransactionalEditingDomain editingDomain, String label, Table Table, Map allDuplicatedObjectsMap) {
			super(editingDomain, label, Collections.singletonList(Table), allDuplicatedObjectsMap);
			this.TableToDuplicate = Table;
		}

		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects. Also sets the list of affected files to be the files,
		 * where the targetContainer is stored. Target container specifies the
		 * eObject into which the duplicated eObjects will be added.
		 * 
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param Table
		 *        <code>Table</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 */
		public DuplicateTableCommand(TransactionalEditingDomain editingDomain, String label, Table Table, Map allDuplicatedObjectsMap, EObject targetContainer) {
			super(editingDomain, label, Collections.singletonList(Table), allDuplicatedObjectsMap, targetContainer);
			this.TableToDuplicate = Table;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			// Remove elements whose container is getting copied.
			// ClipboardSupportUtil.getCopyElements(getObjectsToBeDuplicated());

			// Perform the copy and update the references.
			EcoreUtil.Copier copier = new TableCopier(getAllDuplicatedObjectsMap());
			copier.copy(TableToDuplicate);
			copier.copyReferences();

			EObject duplicateTable = copier.get(TableToDuplicate);
			Resource targetResource = getNotationResourceForTable(((Table)duplicateTable).getContext(), getEditingDomain());
			Resource diTargetResource = getDiResourceForTable(((Table)duplicateTable).getContext(), getEditingDomain());

			if(targetResource != null) {
				targetResource.getContents().add(duplicateTable);

				if(diTargetResource != null) {
					try {
						IPageManager pageManager = ServiceUtilsForResource.getInstance().getIPageManager(diTargetResource);
						pageManager.addPage(duplicateTable);
					} catch (ServiceException e) {
						Activator.log.error(e);
					}
				} else {
					Activator.log.error("It was not possible to find the di resource where to add the Table page", null); //$NON-NLS-1$
				}
			} else {
				Activator.log.warn("It was not possible to find the Resource with the target EObject"); //$NON-NLS-1$
				targetResource = TableToDuplicate.eResource();
				if(targetResource != null) {
					Activator.log.error("It was not possible to find the Resource with the source Table", null); //$NON-NLS-1$
					targetResource.getContents().add(duplicateTable);
					if(diTargetResource != null) {
						try {
							IPageManager pageManager = ServiceUtilsForResource.getInstance().getIPageManager(diTargetResource);
							pageManager.addPage(duplicateTable);
						} catch (ServiceException e) {
							Activator.log.error(e);
						}
					} else {
						Activator.log.error("It was not possible to find the di resource where to add the Table page", null); //$NON-NLS-1$
					}
				}
			}
			return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
		}

		@Override
		public boolean canExecute() {
			// should add some tests here? no need to test containement feature like previous, Table has no owner...
			return true;
		}
	}

	/**
	 * Returns the notation resource where to add the new Table
	 * 
	 * @param eObject
	 *        the semantic object linked to the Table or the Table itself.
	 * @param domain
	 *        the editing domain
	 * @return the resource where the Table should be added or <code>null</code> if no resource was found
	 *         TODO this method should be handled by the resource plugin.
	 */
	public Resource getNotationResourceForTable(EObject eObject, TransactionalEditingDomain domain) {
		Object object = BusinessModelResolver.getInstance().getBusinessModel(eObject);
		EObject semanticObject;
		if(!(object instanceof EObject)) {
			semanticObject = eObject;
		} else {
			semanticObject = (EObject)object;
		}

		Resource containerResource = semanticObject.eResource();
		if(containerResource == null) {
			return null;
		}
		// retrieve the model set from the container resource
		ResourceSet resourceSet = containerResource.getResourceSet();

		if(resourceSet instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)resourceSet;
			Resource destinationResource = modelSet.getAssociatedResource(semanticObject, PapyrusNattableModel.TABLE_MODEL_FILE_EXTENSION, true);
			return destinationResource;
		} else
			throw new RuntimeException("Resource Set is not a ModelSet or is null"); //$NON-NLS-1$
	}


	/**
	 * Returns the di resource where to add the new Table
	 * 
	 * @param eObject
	 *        the semantic object linked to the Table or the Table itself.
	 * @param domain
	 *        the editing domain
	 * @return the resource where the Table should be added or <code>null</code> if no resource was found
	 */
	public Resource getDiResourceForTable(EObject eObject, TransactionalEditingDomain domain) {
		Object object = BusinessModelResolver.getInstance().getBusinessModel(eObject);
		EObject semanticObject;
		if(!(object instanceof EObject)) {
			semanticObject = eObject;
		} else {
			semanticObject = (EObject)object;
		}

		Resource containerResource = semanticObject.eResource();
		if(containerResource == null) {
			return null;
		}
		// retrieve the model set from the container resource
		ResourceSet resourceSet = containerResource.getResourceSet();

		if(resourceSet instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)resourceSet;
			Resource destinationResource = modelSet.getAssociatedResource(semanticObject, DiModel.DI_FILE_EXTENSION, true);
			return destinationResource;
		} else
			throw new RuntimeException("Resource Set is not a ModelSet or is null"); //$NON-NLS-1$
	}

	/**
	 * Copier for Tables, where only views and internal references are duplicated, not the semantic elements themselves.
	 */
	protected class TableCopier extends EcoreUtil.Copier {

		/** Serial UUID */
		private static final long serialVersionUID = -1115934398631109073L;

		/** semantic objects referenced by the views in the Table */
		private Map<EObject, EObject> semanticObjects;

		/**
		 * Creates a new {@link TableCopier}
		 * 
		 * @param semanticObjects
		 *        list of semantic objects already copied, to which new views should be related.
		 */
		public TableCopier(Map<EObject, EObject> semanticObjects) {
			this.semanticObjects = semanticObjects;
		}

		/**
		 * Overrides the get to look in the map of duplicated semantic objects in case the element was not found in this map
		 * 
		 * {@inheritDoc}
		 */
		@Override
		public EObject get(Object arg0) {
			EObject object = super.get(arg0);
			if(object == null) {
				object = semanticObjects.get(arg0);
			}
			return object;
		}
	}
}
