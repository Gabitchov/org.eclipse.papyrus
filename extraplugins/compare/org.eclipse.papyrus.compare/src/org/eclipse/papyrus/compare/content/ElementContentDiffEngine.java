package org.eclipse.papyrus.compare.content;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.PapyrusDiffEngine;


public class ElementContentDiffEngine extends PapyrusDiffEngine {
	
	private final EObject myLeft;
	
	private final EObject myRight;
	
	public ElementContentDiffEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}
	
}
