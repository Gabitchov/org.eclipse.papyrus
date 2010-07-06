/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.state.editor.xtext.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;

import org.eclipse.papyrus.state.editor.xtext.services.UmlStateGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class UmlStateParsetreeConstructor extends AbstractParseTreeConstructor {
		
	@Inject
	private UmlStateGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new StateRule_Group(this, this, 0, inst);
			case 1: return new EntryRule_Group(this, this, 1, inst);
			case 2: return new DoRule_Group(this, this, 2, inst);
			case 3: return new ExitRule_Group(this, this, 3, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule StateRule ****************
 *
 * StateRule:
 * 	name=ID (entry=EntryRule? & do=DoRule? & exit=ExitRule?);
 *
 **/

// name=ID (entry=EntryRule? & do=DoRule? & exit=ExitRule?)
protected class StateRule_Group extends GroupToken {
	
	public StateRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getStateRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new StateRule_UnorderedGroup_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getStateRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// name=ID
protected class StateRule_NameAssignment_0 extends AssignmentToken  {
	
	public StateRule_NameAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getStateRuleAccess().getNameAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getStateRuleAccess().getNameIDTerminalRuleCall_0_0();
			return obj;
		}
		return null;
	}

}

// entry=EntryRule? & do=DoRule? & exit=ExitRule?
protected class StateRule_UnorderedGroup_1 extends UnorderedGroupToken {
	
	public StateRule_UnorderedGroup_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public UnorderedGroup getGrammarElement() {
		return grammarAccess.getStateRuleAccess().getUnorderedGroup_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new StateRule_ExitAssignment_1_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new StateRule_DoAssignment_1_1(lastRuleCallOrigin, this, 1, inst);
			case 2: return new StateRule_EntryAssignment_1_0(lastRuleCallOrigin, this, 2, inst);
			case 3: return new StateRule_NameAssignment_0(lastRuleCallOrigin, this, 3, inst);
			default: return null;
		}	
	}

}

// entry=EntryRule?
protected class StateRule_EntryAssignment_1_0 extends AssignmentToken  {
	
	public StateRule_EntryAssignment_1_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getStateRuleAccess().getEntryAssignment_1_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EntryRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("entry",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("entry");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getEntryRuleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getStateRuleAccess().getEntryEntryRuleParserRuleCall_1_0_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new StateRule_NameAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// do=DoRule?
protected class StateRule_DoAssignment_1_1 extends AssignmentToken  {
	
	public StateRule_DoAssignment_1_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getStateRuleAccess().getDoAssignment_1_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("do",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("do");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getDoRuleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getStateRuleAccess().getDoDoRuleParserRuleCall_1_1_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new StateRule_EntryAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new StateRule_NameAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// exit=ExitRule?
protected class StateRule_ExitAssignment_1_2 extends AssignmentToken  {
	
	public StateRule_ExitAssignment_1_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getStateRuleAccess().getExitAssignment_1_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExitRule_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("exit",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("exit");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getExitRuleRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getStateRuleAccess().getExitExitRuleParserRuleCall_1_2_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new StateRule_DoAssignment_1_1(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new StateRule_EntryAssignment_1_0(lastRuleCallOrigin, next, actIndex, consumed);
			case 2: return new StateRule_NameAssignment_0(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}



/************ end Rule StateRule ****************/


/************ begin Rule EntryRule ****************
 *
 * EntryRule:
 * 	"entry" kind=BehaviorKind behaviorName=ID;
 *
 **/

// "entry" kind=BehaviorKind behaviorName=ID
protected class EntryRule_Group extends GroupToken {
	
	public EntryRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getEntryRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EntryRule_BehaviorNameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getEntryRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "entry"
protected class EntryRule_EntryKeyword_0 extends KeywordToken  {
	
	public EntryRule_EntryKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getEntryRuleAccess().getEntryKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// kind=BehaviorKind
protected class EntryRule_KindAssignment_1 extends AssignmentToken  {
	
	public EntryRule_KindAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getEntryRuleAccess().getKindAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EntryRule_EntryKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("kind",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("kind");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getEntryRuleAccess().getKindBehaviorKindEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// behaviorName=ID
protected class EntryRule_BehaviorNameAssignment_2 extends AssignmentToken  {
	
	public EntryRule_BehaviorNameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getEntryRuleAccess().getBehaviorNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new EntryRule_KindAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("behaviorName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("behaviorName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getEntryRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule EntryRule ****************/


/************ begin Rule DoRule ****************
 *
 * DoRule:
 * 	"do" kind=BehaviorKind behaviorName=ID;
 *
 **/

// "do" kind=BehaviorKind behaviorName=ID
protected class DoRule_Group extends GroupToken {
	
	public DoRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getDoRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoRule_BehaviorNameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getDoRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "do"
protected class DoRule_DoKeyword_0 extends KeywordToken  {
	
	public DoRule_DoKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getDoRuleAccess().getDoKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// kind=BehaviorKind
protected class DoRule_KindAssignment_1 extends AssignmentToken  {
	
	public DoRule_KindAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDoRuleAccess().getKindAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoRule_DoKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("kind",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("kind");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getDoRuleAccess().getKindBehaviorKindEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// behaviorName=ID
protected class DoRule_BehaviorNameAssignment_2 extends AssignmentToken  {
	
	public DoRule_BehaviorNameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getDoRuleAccess().getBehaviorNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new DoRule_KindAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("behaviorName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("behaviorName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getDoRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule DoRule ****************/


/************ begin Rule ExitRule ****************
 *
 * ExitRule:
 * 	"exit" kind=BehaviorKind behaviorName=ID;
 *
 **/

// "exit" kind=BehaviorKind behaviorName=ID
protected class ExitRule_Group extends GroupToken {
	
	public ExitRule_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getExitRuleAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExitRule_BehaviorNameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getExitRuleRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "exit"
protected class ExitRule_ExitKeyword_0 extends KeywordToken  {
	
	public ExitRule_ExitKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getExitRuleAccess().getExitKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// kind=BehaviorKind
protected class ExitRule_KindAssignment_1 extends AssignmentToken  {
	
	public ExitRule_KindAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getExitRuleAccess().getKindAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExitRule_ExitKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("kind",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("kind");
		if(enumLitSerializer.isValid(obj.getEObject(), grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0(), value, null)) { 
			type = AssignmentType.ENUM_RULE_CALL;
			element = grammarAccess.getExitRuleAccess().getKindBehaviorKindEnumRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// behaviorName=ID
protected class ExitRule_BehaviorNameAssignment_2 extends AssignmentToken  {
	
	public ExitRule_BehaviorNameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getExitRuleAccess().getBehaviorNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new ExitRule_KindAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("behaviorName",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("behaviorName");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getExitRuleAccess().getBehaviorNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}


/************ end Rule ExitRule ****************/

}
