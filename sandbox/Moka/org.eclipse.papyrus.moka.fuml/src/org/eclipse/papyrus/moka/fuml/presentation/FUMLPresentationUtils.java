package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.uml2.uml.StructuralFeature;

public class FUMLPresentationUtils {

	public static MokaStackFrame getMokaStackFrame(ActivityNodeActivation activityNodeActivation) {
		return new MokaStackFrame_from_ActivityNodeActivation(activityNodeActivation) ;
	}

	public static MokaStackFrame getMokaStackFrame(ActivityEdgeInstance activityEdgeInstance) {
		return new MokaStackFrame_from_ActivityEdgeInstance(activityEdgeInstance) ;
	}

	public static String getValueString(Value value) {
		if (value == null)
			return "null" ;
		if (value instanceof Object_ || value instanceof Reference) {
			String className = value.getClass().getSimpleName() ;
			String id = "" + value.hashCode() ;
			return className + " (id=" + id + ")" ;
		}
		return value.toString() ;
	}
	
	public static String getValueString(FeatureValue featureValue) {
		StructuralFeature f = featureValue.feature ;
		String valueString = "" ;
		if (isCollection(featureValue)) {
			valueString += f.getType() != null ? f.getType().getName() : "any" ;
			valueString += "[] (size=" + featureValue.values.size();
			valueString += (")") ;
		}
		else {
			Value value = featureValue.values.size() == 1 ? featureValue.values.get(0) : null ;
			return getValueString(value) ;
		}
		return valueString ;
	}
	
	public static boolean isCollection(FeatureValue featureValue) {
		return featureValue.feature.getUpper() == -1 ||
			   featureValue.feature.getUpper() > 1 ||
			   featureValue.values.size() > 1 ;
	}
}
