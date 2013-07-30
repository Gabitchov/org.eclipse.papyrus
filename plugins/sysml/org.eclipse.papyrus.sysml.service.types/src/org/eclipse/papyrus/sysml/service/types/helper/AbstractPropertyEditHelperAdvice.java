/**
 * 
 */
package org.eclipse.papyrus.sysml.service.types.helper;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.papyrus.sysml.service.types.Activator;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;


/**
 * Abstract edit helper advice for SysML specific Properties: part and reference
 */
public abstract class AbstractPropertyEditHelperAdvice extends AbstractEditHelperAdvice {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDuplicateCommand(DuplicateElementsRequest request) {
		Object targetContainer = request.getParameter("Target_Owner");
		// additional element should be a set of elements that will be duplicated. If this is null, the request will be ignored.
		if(!(targetContainer instanceof EObject)) {
			return super.getBeforeDuplicateCommand(request);
		}
		Property propertyToBeDuplicated = getDuplicatedProperty(request);
		if(propertyToBeDuplicated == null) {
			return super.getBeforeDuplicateCommand(request);
		}

		Property newPart = (Property)request.getAllDuplicatedElementsMap().get(propertyToBeDuplicated);
		if(newPart == null) {
			Activator.log.debug("Trying to create a command for a new sysml property which has not been created yet");
			return super.getBeforeDuplicateCommand(request);
		}

		// check association has not be duplicated yet
		Association originalAssociation = propertyToBeDuplicated.getAssociation();
		Association newAssociation = (Association)request.getAllDuplicatedElementsMap().get(originalAssociation);
		if(newAssociation != null && newAssociation.equals(newPart.getAssociation())) {
			return super.getBeforeDuplicateCommand(request);
		}

		TransactionalEditingDomain editingDomain = getEditingDomain(propertyToBeDuplicated);
		if(editingDomain == null) {
			return super.getBeforeDuplicateCommand(request);
		}

		Package targetPackage = getTargetContainer((EObject)targetContainer, propertyToBeDuplicated, newPart, request.getAllDuplicatedElementsMap());
		return new DuplicatePapyrusAssociationCommand(editingDomain, "Duplicate Association", originalAssociation, request.getAllDuplicatedElementsMap(), targetPackage);
	}

	/**
	 * Returns the duplicate Part or Reference.
	 * @param request the duplicate request for which we try to find the property
	 * @return the found Property
	 */
	protected abstract Property getDuplicatedProperty(DuplicateElementsRequest request);

	/**
	 * Computes the target container for the new association
	 * 
	 * @param targetContainer
	 *        the target container of the association creation request
	 * @param partToBeDuplicated
	 *        the part which was duplicated
	 * @param newPart
	 *        the new part linked to the association
	 * @param allDuplicatedElementsMap
	 *        the map of all duplicated elements
	 * @return the target {@link Package} for the new association or <code>null</code> if no package was found
	 */
	protected Package getTargetContainer(EObject targetContainer, Property partToBeDuplicated, Property newPart, Map allDuplicatedElementsMap) {

		// 1. look if the new part has a nearest package
		// 2. look if the part to be duplicated has a package which has a copy
		// 3. if target container == package => this can be the place where the association could be placed
		// 4. look for the nearest package of the target container

		Package result = newPart.getNearestPackage();
		if(result != null) {
			return result;
		}

		Package originalPackage = partToBeDuplicated.getNearestPackage();
		// look for its equivalent in the list of duplicated objects
		Object o = allDuplicatedElementsMap.get(originalPackage);
		if(o instanceof Package) {
			return (Package)o;
		}

		if(targetContainer instanceof Package) {
			return ((Package)targetContainer);
		}

		if(targetContainer instanceof Element) {
			return ((Element)targetContainer).getNearestPackage();
		}

		return null;
	}

	/**
	 * Get the editing domain from an {@link EObject}
	 * 
	 * @param eObject
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain(EObject eObject) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(editingDomain instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain)editingDomain;
		}
		return null;
	}

	/**
	 * Command to duplicate an association and place it in a new container.
	 */
	public class DuplicatePapyrusAssociationCommand extends DuplicateEObjectsCommand {

		/** association to be duplicated */
		private final Association associationToDuplicate;

		/** target container */
		private final Package targetContainer;


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
		 * @param originalAssociation
		 *        <code>Association</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 * @param targetContainer
		 *        target package
		 */
		public DuplicatePapyrusAssociationCommand(TransactionalEditingDomain editingDomain, String label, Association originalAssociation, Map allDuplicatedObjectsMap, Package targetContainer) {
			super(editingDomain, label, Collections.singletonList(originalAssociation), allDuplicatedObjectsMap, targetContainer);
			this.associationToDuplicate = originalAssociation;
			this.targetContainer = targetContainer;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			// Remove elements whose container is getting copied.
			// ClipboardSupportUtil.getCopyElements(getObjectsToBeDuplicated());

			// Perform the copy and update the references.
			EcoreUtil.Copier copier = new EcoreUtil.Copier();
			copier.putAll(getAllDuplicatedObjectsMap());
			copier.copy(associationToDuplicate);
			copier.copyReferences();

			Association newAssociation = (Association)copier.get(associationToDuplicate);
			if(newAssociation == null) {
				return CommandResult.newErrorCommandResult("Impossible to find the copied association");
			}

			// note: can be executed only if targetcontainer is instanceof package, this means that there is no need to tests for null targetContainer 
			newAssociation.setPackage(targetContainer);
			String associationName = NamedElementHelper.getDefaultNameWithIncrementFromBase("Association", targetContainer.eContents()); //$NON-NLS-1$
			newAssociation.setName(associationName);
			return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
		}

		@Override
		public boolean canExecute() {
			// should add some tests here? no need to test containement feature like previous, Table has no owner...
			return targetContainer instanceof Package;
		}
	}
}
