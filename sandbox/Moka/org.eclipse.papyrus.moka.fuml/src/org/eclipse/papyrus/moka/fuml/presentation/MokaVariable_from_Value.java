package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLPackage;

public class MokaVariable_from_Value extends MokaVariable_for_fUML {

	protected Value value ;
	
	public MokaVariable_from_Value(Value value) {
		super();
		this.value = value ;
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
		return new MokaValue_from_Value(value) ;
	}

}
