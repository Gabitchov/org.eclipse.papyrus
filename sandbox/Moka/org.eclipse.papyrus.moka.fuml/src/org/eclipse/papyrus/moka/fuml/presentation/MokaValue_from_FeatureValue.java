package org.eclipse.papyrus.moka.fuml.presentation;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.papyrus.moka.debug.MokaVariable;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;

public class MokaValue_from_FeatureValue extends MokaValue_for_fUML {

	protected FeatureValue featureValue ;
	
	protected IVariable[] variables ;
	
	public MokaValue_from_FeatureValue(FeatureValue featureValue) {
		super() ;
		this.featureValue = featureValue ;
	}

	////////////////////////
	// Presentation
	////////////////////////
	
	@Override
	public String getDetails() {
		return computeDetails() ;
	}

	////////////////////////
	// Debug
	////////////////////////

	@Override
	public String getValueString() throws DebugException {
		String valueString = null;
		if (FUMLPresentationUtils.isCollection(featureValue)) {
			valueString = FUMLPresentationUtils.getValueString(featureValue) ;
		}
		else {
			valueString = computeDetails() ;
		}
		return valueString ;
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		if (variables == null) {
			if (featureValue.values.isEmpty()) {
				variables = new IVariable[]{} ;
			}
			else {
				variables = new IVariable[featureValue.values.size()] ;
				for (int i = 0 ; i < variables.length ; i++) {
					MokaVariable valueVariable = new MokaVariable_from_Value(featureValue.values.get(i)) ;
					valueVariable.setName("[" + (i + 1) + "]") ;
					variables[i] = valueVariable ;
				}
			}
		}
		return variables ;
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return this.getVariables().length > 0 && FUMLPresentationUtils.isCollection(featureValue);
	}

	protected String computeDetails() {
		String valueString = FUMLPresentationUtils.isCollection(featureValue) ? "{ " : "" ;
		List<Value> values = featureValue.values ;
		boolean first = true ;
		if (values.isEmpty() && !FUMLPresentationUtils.isCollection(featureValue))
			return "null" ;
		for (Value v : values) {
			if (first) {
				valueString += v.toString() ;
				first = false ;
			}
			else {
				valueString += ", " ;
				valueString += v.toString() ;
			}
		}
		valueString += FUMLPresentationUtils.isCollection(featureValue) ? " }" : "";
		return valueString ;
	}
	
}
