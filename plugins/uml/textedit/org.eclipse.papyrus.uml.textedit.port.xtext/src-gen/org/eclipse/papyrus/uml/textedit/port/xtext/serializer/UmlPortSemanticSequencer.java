package org.eclipse.papyrus.uml.textedit.port.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.port.xtext.services.UmlPortGrammarAccess;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule;
import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;
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
public class UmlPortSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private UmlPortGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmlPortPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmlPortPackage.BOUND_SPECIFICATION:
				if(context == grammarAccess.getBoundSpecificationRule()) {
					sequence_BoundSpecification(context, (BoundSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.DEFAULT_VALUE_RULE:
				if(context == grammarAccess.getDefaultValueRuleRule()) {
					sequence_DefaultValueRule(context, (DefaultValueRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.MODIFIER_SPECIFICATION:
				if(context == grammarAccess.getModifierSpecificationRule()) {
					sequence_ModifierSpecification(context, (ModifierSpecification) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.MODIFIERS_RULE:
				if(context == grammarAccess.getModifiersRuleRule()) {
					sequence_ModifiersRule(context, (ModifiersRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.MULTIPLICITY_RULE:
				if(context == grammarAccess.getMultiplicityRuleRule()) {
					sequence_MultiplicityRule(context, (MultiplicityRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.PORT_RULE:
				if(context == grammarAccess.getPortRuleRule()) {
					sequence_PortRule(context, (PortRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.REDEFINES_RULE:
				if(context == grammarAccess.getRedefinesRuleRule()) {
					sequence_RedefinesRule(context, (RedefinesRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.SUBSETS_RULE:
				if(context == grammarAccess.getSubsetsRuleRule()) {
					sequence_SubsetsRule(context, (SubsetsRule) semanticObject); 
					return; 
				}
				else break;
			case UmlPortPackage.TYPE_RULE:
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
			if(transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.BOUND_SPECIFICATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.BOUND_SPECIFICATION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBoundSpecificationAccess().getValueUnlimitedLiteralParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     default=STRING
	 */
	protected void sequence_DefaultValueRule(EObject context, DefaultValueRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.DEFAULT_VALUE_RULE__DEFAULT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.DEFAULT_VALUE_RULE__DEFAULT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDefaultValueRuleAccess().getDefaultSTRINGTerminalRuleCall_1_0(), semanticObject.getDefault());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value=ModifierKind | redefines=RedefinesRule | subsets=SubsetsRule)
	 */
	protected void sequence_ModifierSpecification(EObject context, ModifierSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (values+=ModifierSpecification values+=ModifierSpecification*)
	 */
	protected void sequence_ModifiersRule(EObject context, ModifiersRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
	 *     (
	 *         visibility=VisibilityKind 
	 *         isDerived='/'? 
	 *         name=ID 
	 *         isConjugated='~'? 
	 *         type=TypeRule? 
	 *         multiplicity=MultiplicityRule? 
	 *         modifiers=ModifiersRule? 
	 *         default=DefaultValueRule?
	 *     )
	 */
	protected void sequence_PortRule(EObject context, PortRule semanticObject) {
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
	 *     port=[Port|ID]
	 */
	protected void sequence_RedefinesRule(EObject context, RedefinesRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.REDEFINES_RULE__PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.REDEFINES_RULE__PORT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRedefinesRuleAccess().getPortPortIDTerminalRuleCall_1_0_1(), semanticObject.getPort());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     port=[Port|ID]
	 */
	protected void sequence_SubsetsRule(EObject context, SubsetsRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmlPortPackage.Literals.SUBSETS_RULE__PORT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmlPortPackage.Literals.SUBSETS_RULE__PORT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSubsetsRuleAccess().getPortPortIDTerminalRuleCall_1_0_1(), semanticObject.getPort());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (path=QualifiedName? type=[Classifier|ID])
	 */
	protected void sequence_TypeRule(EObject context, TypeRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
