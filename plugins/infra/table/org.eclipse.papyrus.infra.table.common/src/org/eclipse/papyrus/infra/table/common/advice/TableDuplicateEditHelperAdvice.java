/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
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
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.commands.IPapyrusDuplicateCommandConstants;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.table.common.Activator;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;


/**
 * Edit Helper advice to add Table duplication when duplicating
 */
public class TableDuplicateEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDuplicateCommand(DuplicateElementsRequest request) {
		Object additional = request.getParameter(IPapyrusDuplicateCommandConstants.ADDITIONAL_DUPLICATED_ELEMENTS); // Taken from uml.pastemanager

		// additional element should be a set of elements that will be duplicated. If this is null, the request will be ignored.
		if(!(additional instanceof Set<?>)) {
			return super.getBeforeDuplicateCommand(request);
		}

		Set<Object> duplicatedObjects = ((Set<Object>)additional);
		EObject object = getDuplicatedEObject(request);
		if(object == null) {
			return super.getBeforeDuplicateCommand(request);
		}

		// retrieve the tables linked to the object
		List<PapyrusTableInstance> tablesToDuplicate = getRelatedTables(object, true);

		if(!tablesToDuplicate.isEmpty()) {
			CompositeCommand command = null;
			// create the command for all the tables that have no command ready
			for(PapyrusTableInstance tableToDuplicate : tablesToDuplicate) {
				if(!duplicatedObjects.contains(tableToDuplicate)) {
					if(command == null) {
						command = new CompositeCommand("", Arrays.asList(new DuplicatePapyrusTableCommand(request.getEditingDomain(), "Duplicate Table", tableToDuplicate, request.getAllDuplicatedElementsMap())));
					} else {
						command.add(new DuplicatePapyrusTableCommand(request.getEditingDomain(), "Duplicate Table", tableToDuplicate, request.getAllDuplicatedElementsMap()));
					}
					duplicatedObjects.add(tableToDuplicate);
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
	 * Returns the list of "Owned" tables for a given object
	 * 
	 * @param object
	 *        the object for which tables are searched
	 * @param lookInChildren
	 *        <code>true</code> if the search shall be done for contained EObject.
	 * @return the list of tables found or an empty list
	 */
	protected List<PapyrusTableInstance> getRelatedTables(EObject object, boolean lookInChildren) {
		List<PapyrusTableInstance> tables = new ArrayList<PapyrusTableInstance>();
		ResourceSet resourceSet = object.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if(adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}

		// check for the element itself
		Collection<Setting> settings = adapter.getInverseReferences(object, false);
		for(Setting setting : settings) {
			EObject value = setting.getEObject();
			if(value instanceof TableInstance && TableinstancePackage.Literals.TABLE_INSTANCE__CONTEXT == setting.getEStructuralFeature()) {
				// get the papyrus table instance to be duplicated
				Collection<Setting> tableSettings = adapter.getInverseReferences((TableInstance)value, false);
				for(Setting tableSetting : tableSettings) {
					EObject tableValue = tableSetting.getEObject();
					if(tableValue instanceof PapyrusTableInstance && PapyrustableinstancePackage.Literals.PAPYRUS_TABLE_INSTANCE__TABLE == tableSetting.getEStructuralFeature()) {
						// get the papyrus table instance to be duplicated
						tables.add((PapyrusTableInstance)tableValue);
					}
				}
			}
		}

		if(lookInChildren) {
			for(EObject child : object.eContents()) {
				tables.addAll(getRelatedTables(child, lookInChildren));
			}
		}
		return tables;
	}

	/**
	 * Command to duplicate tables. This adds the table to the resource containing the source table.
	 */
	public class DuplicatePapyrusTableCommand extends DuplicateEObjectsCommand {

		/** table to be duplicated */
		private final PapyrusTableInstance papyrusTableInstanceToDuplicate;

		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects.
		 * 
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param table
		 *        <code>PapyrusTableInstance</code> to be duplicated.
		 */
		public DuplicatePapyrusTableCommand(TransactionalEditingDomain editingDomain, String label, PapyrusTableInstance table) {
			super(editingDomain, label, Collections.singletonList(table));
			this.papyrusTableInstanceToDuplicate = table;
		}

		/**
		 * Constructs a new duplicate Table command with the specified label and
		 * list of EObjects.
		 * 
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param table
		 *        <code>PapyrusTableInstance</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 */
		public DuplicatePapyrusTableCommand(TransactionalEditingDomain editingDomain, String label, PapyrusTableInstance table, Map allDuplicatedObjectsMap) {
			super(editingDomain, label, Collections.singletonList(table), allDuplicatedObjectsMap);
			this.papyrusTableInstanceToDuplicate = table;
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
		 * @param table
		 *        <code>PapyrusTableInstance</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 */
		public DuplicatePapyrusTableCommand(TransactionalEditingDomain editingDomain, String label, PapyrusTableInstance table, Map allDuplicatedObjectsMap, EObject targetContainer) {
			super(editingDomain, label, Collections.singletonList(table), allDuplicatedObjectsMap, targetContainer);
			this.papyrusTableInstanceToDuplicate = table;
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
			TableInstance tableInstanceToDuplicate = papyrusTableInstanceToDuplicate.getTable();
			copier.copy(tableInstanceToDuplicate);
			copier.copy(papyrusTableInstanceToDuplicate);
			copier.copyReferences();

			// Add the duplicates to the original's container.
			EObject duplicatePapyrusTableInstance = (EObject)copier.get(papyrusTableInstanceToDuplicate);
			EObject duplicateTableInstance = (EObject)copier.get(tableInstanceToDuplicate);

			Resource targetResource = getDiResourceForTable(duplicateTableInstance, getEditingDomain());
			//	Resource containerResource = papyrusTableInstanceToDuplicate.eResource();
			if(targetResource != null) {
				targetResource.getContents().add(duplicateTableInstance);
				targetResource.getContents().add(duplicatePapyrusTableInstance);
			} else { // no resource found, try to add in resource of the original table
				targetResource = papyrusTableInstanceToDuplicate.eResource();
				if(targetResource != null) {
					Activator.log.warn("It was not possible to find the Resource with the target EObject");
					targetResource.getContents().add(duplicateTableInstance);
					targetResource.getContents().add(duplicatePapyrusTableInstance);
				}
				return CommandResult.newErrorCommandResult("Impossible to find a resource for the new table");
			}
			
			// modify also the di, in order to be able to open the table
			Resource diResource = getDiResourceForTable(duplicateTableInstance, getEditingDomain());
			if(diResource !=null) {
				try {
					IPageManager iPageManager = ServiceUtilsForResource.getInstance().getIPageManager(diResource);
					iPageManager.addPage(duplicatePapyrusTableInstance);
				} catch (ServiceException e) {
					Activator.log.error(e);
					return CommandResult.newErrorCommandResult("Impossible to find a di resource to add the new available page");
				}
			} else {
				return CommandResult.newErrorCommandResult("Impossible to find a di resource to add the new available page");
			}
			// copy also uml profile facet set in case of UML profiles appplied
			return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
		}

		@Override
		public boolean canExecute() {
			// should add some tests here? no need to test containement feature like previous, Table has no owner...
			return true;
		}
	}

	/**
	 * Copier for tables, where only views and internal references are duplicated, not the semantic elements themselves.
	 */
	protected class TableCopier extends EcoreUtil.Copier {

		/** Serial UUID */
		private static final long serialVersionUID = 8544123249170461708L;

		/** semantic objects referenced by the views in the diagram */
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

	/**
	 * Returns the notation resource where to add the new diagram
	 * 
	 * @param eObject
	 *        the semantic object linked to the diagram or the diagram itself.
	 * @param domain
	 *        the editing domain
	 * @return the resource where the diagram should be added or <code>null</code> if no resource was found
	 *         TODO this method should be handled by the resource plugin.
	 */
	public Resource getNotationResourceForTable(EObject eObject, TransactionalEditingDomain domain) {
		EObject semanticObject = eObject;
		if(eObject instanceof PapyrusTableInstance) {
			TableInstance2 tableInstance = ((PapyrusTableInstance)eObject).getTable();
			if(tableInstance != null) {
				semanticObject = tableInstance.getContext();
			}
		} else if(eObject instanceof TableInstance2) {
			semanticObject = ((TableInstance2)eObject).getContext();
		}
		if(semanticObject == null) {
			return null;
		}
		
		Resource containerResource = semanticObject.eResource();
		if(containerResource == null) { 
			return null;
		}
		// retrieve the model set from the container resource
		ResourceSet resourceSet = containerResource.getResourceSet();
		
		if(resourceSet instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)resourceSet;
			Resource destinationResource = modelSet.getAssociatedResource(semanticObject, NotationModel.NOTATION_FILE_EXTENSION, true);
			return destinationResource;
		} else throw new RuntimeException("Resource Set is not a ModelSet or is null");
	}
	

	/**
	 * Returns the di resource where to add the new diagram
	 * 
	 * @param eObject
	 *        the semantic object linked to the diagram or the diagram itself.
	 * @param domain
	 *        the editing domain
	 * @return the resource where the diagram should be added or <code>null</code> if no resource was found
	 */
	public Resource getDiResourceForTable(EObject eObject, TransactionalEditingDomain domain) {
		EObject semanticObject = eObject;
		if(eObject instanceof PapyrusTableInstance) {
			TableInstance2 tableInstance = ((PapyrusTableInstance)eObject).getTable();
			if(tableInstance != null) {
				semanticObject = tableInstance.getContext();
			}
		} else if(eObject instanceof TableInstance2) {
			semanticObject = ((TableInstance2)eObject).getContext();
		}
		if(semanticObject == null) {
			return null;
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
		} else throw new RuntimeException("Resource Set is not a ModelSet or is null");
	}
	
}
