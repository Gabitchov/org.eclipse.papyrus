package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.swt.graphics.Image;

public class MokaVariable_from_FeatureValue extends MokaVariable_for_fUML {
	
	protected FeatureValue featureValue ;
	
	protected IValue value ;

	public MokaVariable_from_FeatureValue(FeatureValue featureValue) {
		super() ;
		this.featureValue = featureValue ;
		this.name = featureValue.feature.getName() ;
	}

	////////////////////////
	// Presentation
	////////////////////////
	
	@Override
	public Image getImage() {
		return FUMLPresentationUtils.getImage(featureValue.feature);
	}

	////////////////////////
	// Debug
	////////////////////////
	
	@Override
	public IValue getValue() throws DebugException {
		if (this.value == null) {
			this.value = new MokaValue_from_FeatureValue(featureValue) ;
		}
		return this.value;
	}
	
}
