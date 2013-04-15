package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.ui.presentation.IPresentation;
import org.eclipse.swt.graphics.Image;

public abstract class MokaVariable_for_fUML extends MokaVariable implements IPresentation {

	public MokaVariable_for_fUML() {
		super(Locus.getDebugTarget());
	}

	public String getLabel() {
		// Not used
		return "";
	}

	public String getDetails() {
		// Not used
		return "";
	}

	public abstract Image getImage() ;
	
}
