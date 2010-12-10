package org.eclipse.papyrus.compare.content;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.PapyrusMatchEngine;


public class ElementContentMatchEngine extends PapyrusMatchEngine {
	
	private final EObject myLeft;
	
	private final EObject myRight;
	
	public ElementContentMatchEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}
	

}
