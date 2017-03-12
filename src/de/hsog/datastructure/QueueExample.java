package de.hsog.datastructure;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {

		Queue<String> myQueue = new LinkedList<String>();

		// add elements in the queue using offer() - return true/false
		myQueue.offer("Montag");
		myQueue.offer("Dienstag");
		boolean flag = myQueue.offer("Mittwoch");

		System.out.println("Mittwoch erfolgreich eingefügt? " + flag);

		// add more elements using add() - throws IllegalStateException
		try {
			myQueue.add("Donnerstag");
			myQueue.add("Freitag");
			myQueue.add("Wochenende");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		System.out.println("Pick the head of the queue: " + myQueue.peek());

		String head = null;
		try {
			head = myQueue.remove();
			System.out.print("1) Push out " + head + " from the queue ");
			System.out.println("and the new head is now: " + myQueue.element());
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		// remove the head - poll()
		head = myQueue.poll();
		System.out.print("2) Push out " + head + " from the queue ");
		System.out.println("and the new head is now: " + myQueue.peek());

		// find out if the queue contains an object
		System.out.println("Does the queue contain 'Wochenende'? " + myQueue.contains("Wochenende"));
		System.out.println("Does the queue contain 'Montag'? " + myQueue.contains("Montag"));
	}

}
