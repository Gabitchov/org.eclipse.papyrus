package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.PartDecomposition;


public class PartDecompositionHelperAdvice extends AbstractEditHelperAdvice {

	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		PartDecomposition decomposition = (PartDecomposition)request.getElementToDestroy();
		// destroy the decomposed lifelines
		return request.getDestroyDependentsCommand(decomposition.getCovereds());
	}
}
