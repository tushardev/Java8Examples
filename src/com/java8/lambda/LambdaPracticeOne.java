package com.java8.lambda;

public class LambdaPracticeOne {

	public static void main(String[] args) throws InterruptedException {
		
		/* Without Lambda */
		Runnable runnable = new Runnable () {
			@Override
			public void run() {
				for(int i=0; i<3; i++) {
					System.out.println("Hello Thread " + Thread.currentThread().getName());
					System.out.println("Your priority is: " + Thread.currentThread().getPriority());
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		thread.join();
		
		
		/* With Lambda */
		Runnable runnableLambda = () ->  {
			for(int i=0; i<3; i++) {
			System.out.println("Hello Lambda Thread " + Thread.currentThread().getName());
			System.out.println("Your lambda priority is: " + Thread.currentThread().getPriority());
			}
		};
		
		Thread threadLambda = new Thread(runnableLambda);
		threadLambda.start();
		threadLambda.join();
	
	}
}

/*** Here we have no argument hence empty parentheses in lambda expression.
 * We have multiple lines of code for execution.
 */