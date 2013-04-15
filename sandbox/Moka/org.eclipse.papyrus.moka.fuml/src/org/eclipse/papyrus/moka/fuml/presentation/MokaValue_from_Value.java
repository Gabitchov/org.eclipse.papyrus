package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.CompoundValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;

public class MokaValue_from_Value extends MokaValue_for_fUML {

	protected Value value ;
	
	protected IVariable[] variables ;
	
	public MokaValue_from_Value(Value value) {
		super();
		this.value = value ;
	}
	
	//////////////////////////////////
	// Presentation
	//////////////////////////////////

	public String getDetails() {
		return value.toString();
	}
	
	//////////////////////////////////
	// Debug
	//////////////////////////////////
	
	@Override
	public String getValueString() throws DebugException {
		return FUMLPresentationUtils.getValueString(value) ;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if (variables == null) {
			if (! (value instanceof CompoundValue)) {
				variables = new IVariable[]{} ;
			}
			else if (((CompoundValue)value).featureValues.isEmpty()) {
				variables = new IVariable[]{} ;
			}
			else {
				CompoundValue compound = (CompoundValue)value ;
				variables = new IVariable[compound.featureValues.size()] ;
				for (int i = 0 ; i < variables.length ; i++) {
					IVariable featureValueVariable = new MokaVariable_from_FeatureValue(compound.featureValues.get(i)) ;
					variables[i] = featureValueVariable ;
				}
			}
		}
		return variables;
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return getVariables().length > 0;
	}

	
	
}
