package model;

public abstract class MyThread implements Runnable{

	private Thread thread;
	private boolean isPause;
	private boolean isRunning;

	public MyThread() {
		thread = new Thread(this);
	}

	public void start(){
		thread.start();
		this.isRunning = true;
	}

	@Override
	public void run() {
		while (isRunning) {
			synchronized (this) {
				while (isPause) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (!isRunning) {
					break;
				}
			}
			executeTask();
		}
	}

	public synchronized void stop() {
		this.isRunning = false;
	}
	
	@SuppressWarnings("deprecation")
	public synchronized void resume() {
//		this.isPause = false;
		thread.resume();
//		notify();
	}

	@SuppressWarnings("deprecation")
	public synchronized void pause() {
//		this.isPause = true;
		thread.suspend();
//		notify();
	}
	public boolean isPause() {
		return isPause;
	}
	
	public void join(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	abstract void executeTask();
}