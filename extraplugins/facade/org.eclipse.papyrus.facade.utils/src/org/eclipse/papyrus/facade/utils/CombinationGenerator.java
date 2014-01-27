/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.facade.utils;

import java.math.BigInteger;

public class CombinationGenerator {

	private int[] a;

	private int n;

	private int r;

	private BigInteger numLeft;

	private BigInteger total;

	public CombinationGenerator(int n, int r) {
		if(r > n) {
			throw new IllegalArgumentException();
		}
		if(n < 1) {
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.r = r;
		a = new int[r];
		BigInteger nFact = getFactorial(n);
		BigInteger rFact = getFactorial(r);
		BigInteger nminusrFact = getFactorial(n - r);
		total = nFact.divide(rFact.multiply(nminusrFact));
		reset();
	}

	/**
	 * Reset the generator
	 */
	public void reset() {
		for(int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		numLeft = new BigInteger(total.toString());
	}


	/**
	 * 
	 * @return
	 *         number of combinations not yet generated
	 */
	public BigInteger getNumLeft() {
		return numLeft;
	}

	/**
	 * 
	 * @return true if there are more combinations
	 */
	public boolean hasMore() {
		return numLeft.compareTo(BigInteger.ZERO) == 1;
	}

	/**
	 * 
	 * @return total number of combinations
	 */
	public BigInteger getTotal() {
		return total;
	}


	/**
	 * Compute the factorial of n
	 * 
	 * @param n
	 * @return fact(n)
	 */
	private static BigInteger getFactorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for(int i = n; i > 1; i--) {
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		return fact;
	}

	/**
	 * Generate next combination (algorithm from Rosen)
	 * 
	 * @return next combination from generator
	 */
	public int[] getNext() {

		if(numLeft.equals(total)) {
			numLeft = numLeft.subtract(BigInteger.ONE);
			return a;
		}

		int i = r - 1;
		while(a[i] == n - r + i) {
			i--;
		}
		a[i] = a[i] + 1;
		for(int j = i + 1; j < r; j++) {
			a[j] = a[i] + j - i;
		}

		numLeft = numLeft.subtract(BigInteger.ONE);
		return a;

	}
}
