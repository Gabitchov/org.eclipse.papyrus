package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

public class MokaVariable_from_ContextObject extends MokaVariable_for_fUML {

	protected Object_ contextObject ;
	
	public MokaVariable_from_ContextObject(Object_ contextObject) {
		super();
		this.name = "context" ;
		this.contextObject = contextObject ;
	}

	//////////////////////////////////
	// Presentation
	//////////////////////////////////

	public Image getImage() {
		// not used for variables
		return FUMLExecutionEngine.getImage(UMLPackage.eINSTANCE.getInstanceSpecification()) ;
	}

	//////////////////////////////////
	// Debug
	//////////////////////////////////
	@Override
	public IValue getValue() throws DebugException {
		return new MokaValue_from_Value(contextObject) ;
	}

}
