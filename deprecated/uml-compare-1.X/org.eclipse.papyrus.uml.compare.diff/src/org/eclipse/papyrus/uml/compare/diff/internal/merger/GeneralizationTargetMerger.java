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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.internal.merger;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.PapyrusMergeCommandProvider;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.UpdateReferenceTransactionalMerger;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationTargetChangedExtension;
import org.eclipse.uml2.uml.Generalization;

/**
 * 
 * the merger for {@link GeneralizationTargetChangedExtension
 * 
 */
public class GeneralizationTargetMerger extends UpdateReferenceTransactionalMerger {

	@Override
	public Command getDoApplyInOriginCommand(TransactionalEditingDomain domain) {
		final GeneralizationTargetChangedExtension theDiff = (GeneralizationTargetChangedExtension)this.diff;
		final Generalization generalization = (Generalization)theDiff.getLeftElement();
		final EObject oldEnd = theDiff.getRightTarget();
		final EObject newEnd = theDiff.getLeftTarget();
		final int direction = ReorientRequest.REORIENT_TARGET;
		final ReorientRelationshipRequest request = new ReorientRelationshipRequest(domain, generalization, newEnd, oldEnd, direction);
		return PapyrusMergeCommandProvider.INSTANCE.getCommand(generalization, request);
	}

	@Override
	public Command getDoUndoInTargetCommand(TransactionalEditingDomain domain) {
		final GeneralizationTargetChangedExtension theDiff = (GeneralizationTargetChangedExtension)this.diff;
		final Generalization generalization = (Generalization)theDiff.getRightElement();
		final EObject oldEnd = theDiff.getLeftTarget();
		final EObject newEnd = theDiff.getRightTarget();
		final int direction = ReorientRequest.REORIENT_TARGET;
		final ReorientRelationshipRequest request = new ReorientRelationshipRequest(domain, generalization, newEnd, oldEnd, direction);
		return PapyrusMergeCommandProvider.INSTANCE.getCommand(generalization, request);
	}
}
