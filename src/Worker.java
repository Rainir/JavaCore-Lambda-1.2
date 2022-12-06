public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != 33) {
                callback.onDone("Task " + (i + 1) + " is done");
            } else {
                errorCallback.onError("Error, task " + (i + 1) + " is not done");
            }
        }
    }
}