package org.eclipse.papyrus.infra.nattable.common.provider;


public class CrossData {

	private final Object object1;

	private final Object object2;

	public CrossData(final Object object1, final Object object2) {
		this.object1 = object1;
		this.object2 = object2;
	}

	public Object getObject1() {
		return this.object1;
	}

	public Object getObject2() {
		return this.object2;
	}

}
