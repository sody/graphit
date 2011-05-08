package com.github.graphit;

/**
 * @author Ivan Khalopik
 * @since 1.0
 */
public class Locker {
	private boolean lock;

	/**
	 * Checks if instance is locked.
	 *
	 * @throws IllegalStateException if instance is locked
	 */
	public void check() {
		if (lock) {
			throw new IllegalStateException("Locked");
		}
	}

	/**
	 * Locks instance to prevent use it again.
	 *
	 * @throws IllegalStateException if instance is locked
	 */
	public void lock() {
		check();
		lock = true;
	}
}
