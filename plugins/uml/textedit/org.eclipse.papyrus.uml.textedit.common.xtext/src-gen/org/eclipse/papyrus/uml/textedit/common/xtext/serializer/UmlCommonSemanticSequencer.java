package org.eclipse.papyrus.uml.textedit.common.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.common.xtext.services.UmlCommonGrammarAccess;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.QualifiedName;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class UmlCommonSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlCommonGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlCommonPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlCommonPackage.BOUND_SPECIFICATION:
				if(context == grammarAccess.getBoundSpecificationRule()) {
					sequence_BoundSpecification(context, (BoundSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlCommonPackage.MULTIPLICITY_RULE:
				if(context == grammarAccess.getMultiplicityRuleRule()) {
					sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject); 
					return; 
				}
				else break;
			case UmlCommonPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case UmlCommonPackage.TYPE_RULE:
				if(context == grammarAccess.getTypeRuleRule()) {
					sequence_TypeRule(context, (TypeRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     value=UnlimitedLiteral
	 */
	protected void sequence_BoundSpecification(EObject context, BoundSpecification semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlCommonPackage.Literals.BOUND_SPECIFICATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlCommonPackage.Literals.BOUND_SPECIFICATION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (bounds+=BoundSpecification bounds+=BoundSpecification?)
	 */
	protected void sequence_MultiplicityRule(EObject context, MultiplicityRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=[Namespace|ID] remaining=QualifiedName?)
	 */
	protected void sequence_QualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path=QualifiedName? type=[Type|ID])
	 */
	protected void sequence_TypeRule(EObject context, TypeRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
