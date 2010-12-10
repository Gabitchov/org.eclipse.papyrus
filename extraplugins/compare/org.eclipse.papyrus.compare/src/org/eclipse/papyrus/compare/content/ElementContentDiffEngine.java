package org.eclipse.papyrus.compare.content;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.PapyrusDiffEngine;


public class ElementContentDiffEngine extends PapyrusDiffEngine {

	private final EObject myLeft;

	private final EObject myRight;

	public ElementContentDiffEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}

	@Override
	protected void addInContainerPackage(DiffGroup root, DiffElement operation, EObject targetParent) {
//		if(targetParent == myLeft || targetParent == myRight) {
//			root.getSubDiffElements().add(operation);
//			return;
//		}
		super.addInContainerPackage(root, operation, targetParent);
	}

}
