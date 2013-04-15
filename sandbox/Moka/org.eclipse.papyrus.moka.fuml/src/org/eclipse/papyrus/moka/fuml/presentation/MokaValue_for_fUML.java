package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.MokaValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;

public abstract class MokaValue_for_fUML extends MokaValue implements IPresentation {

	public MokaValue_for_fUML() {
		super(Locus.getDebugTarget());
	}

	//////////////////////////////////
	// Presentation
	//////////////////////////////////
	
	public String getLabel() {
		// Not used
		return "";
	}

	public abstract String getDetails() ;

	public Image getImage() {
		// Not used
		return null ;
	}
	
	//////////////////////////////////
	// Debug
	//////////////////////////////////
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		return new IVariable[]{};
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return false ;
	}
	
}
