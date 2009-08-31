/*
 * 
 */
package org.eclipse.papyrus.diagram.common.parser.custom;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;

public class AddStereotypesNamesFeaturesParser extends AddStereotypesNamesAbstractParser {

	/**
	 * @generated
	 */
	private List features;

	/**
	 * @generated
	 */
	public AddStereotypesNamesFeaturesParser(List features) {
		this.features = features;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		List values = new ArrayList(features.size());
		for (Iterator it = features.iterator(); it.hasNext();) {
			EStructuralFeature feature = (EStructuralFeature) it.next();
			Object value = element.eGet(feature);
			value = getValidValue(feature, value);
			values.add(value);
		}
		return processor.format(values.toArray(new Object[values.size()]), new StringBuffer(), new FieldPosition(0))
				.toString();
	}

	/**
	 * @generated
	 */
	protected IParserEditStatus validateValues(Object[] values) {
		if (values.length != features.size()) {
			return ParserEditStatus.UNEDITABLE_STATUS;
		}
		for (int i = 0; i < values.length; i++) {
			Object value = getValidNewValue((EStructuralFeature) features.get(i), values[i]);
			if (value instanceof InvalidValue) {
				return new ParserEditStatus("FeaturesParser", IParserEditStatus.UNEDITABLE, value.toString());
			}
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	@Override
	public ICommand getParseCommand(IAdaptable adapter, Object[] values) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		for (int i = 0; i < values.length; i++) {
			EStructuralFeature feature = (EStructuralFeature) features.get(i);
			command.compose(getModificationCommand(element, feature, values[i]));
		}
		return command;
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			if (features.contains(feature)) {
				return true;
			}
		}
		return false;
	}

}
