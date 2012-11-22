/**
 * 
 */
package cto.framework.service.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author PeterTan
 * 
 */
public class TaskExecutor {

	private static ExecutorService executorService;

	private static TaskExecutor taskExecutor;

	private TaskExecutor() {
		executorService = Executors.newCachedThreadPool();
	}

	public static TaskExecutor getInstance() {
		if (taskExecutor == null) {
			taskExecutor = new TaskExecutor();
		}
		return taskExecutor;
	}

	public void executeTask(Task task) throws Exception {
		executorService.execute(task);
	}
}
