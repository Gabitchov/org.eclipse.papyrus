package org.eclipse.papyrus.service.edit.request;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

/**
 * This request should be used instead of the generic
 * GMF move request : it reports target and moved elements
 * as edited elements so that getAffectedFiles works good and report
 * both files when moving from/to a controlled read-only resource for example.
 * 
 * @author mvelten
 *
 */
public class PapyrusMoveRequest extends MoveRequest {

	public PapyrusMoveRequest(EObject targetContainer, EObject elementToMove) {
		super(targetContainer, elementToMove);
	}

	public PapyrusMoveRequest(EObject targetContainer, List elementsToMove) {
		super(targetContainer, elementsToMove);
	}

	public PapyrusMoveRequest(TransactionalEditingDomain editingDomain, EObject targetContainer, EObject elementToMove) {
		super(editingDomain, targetContainer, elementToMove);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getElementsToEdit() {
		ArrayList l = new ArrayList();
		l.addAll(getElementsToMove().keySet());
		l.add(getTargetContainer());
		return l;
	}
}
