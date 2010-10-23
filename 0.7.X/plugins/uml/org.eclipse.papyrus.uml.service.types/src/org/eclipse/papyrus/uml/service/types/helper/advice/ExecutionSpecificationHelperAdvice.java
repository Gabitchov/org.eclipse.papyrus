package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * Helper advice for all {@link ExecutionSpecification} elements.
 */
public class ExecutionSpecificationHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * Add a command to destroy {@link OccurrenceSpecification} referenced by the {@link ExecutionSpecification} 
	 * to delete.
	 * This command is only added if the start - finish referenced {@link OccurrenceSpecification} is not 
	 * referenced by another element.
	 * </pre>
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 *        the request
	 * @return the command to execute before the edit helper work is done
	 */
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		ExecutionSpecification es = (ExecutionSpecification)request.getElementToDestroy();

		// Add start - finish referenced OccurrenceSpecification to the dependents list
		// if they are not used by another element.
		OccurrenceSpecification osStart = es.getStart();
		if((osStart != null) && (PapyrusEcoreUtils.isOnlyUsage(osStart, es))) {
			dependentsToDestroy.add(osStart);
		}

		OccurrenceSpecification osFinish = es.getFinish();
		if((osFinish != null) && (PapyrusEcoreUtils.isOnlyUsage(osFinish, es))) {
			dependentsToDestroy.add(osFinish);
		}

		// Add command to destroy dependents OccurrenceSpecification 
		if(!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}
}
