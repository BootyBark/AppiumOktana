package allure;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;

public class AllureTestListener implements StepLifecycleListener {
    @Override
    public void afterStepStart(final StepResult result) {
        System.out.println("==== Starting step: " + result.getName() + " ====");
    }

    @Override
    public void beforeStepStop(final StepResult result) {
        System.out.println("==== Finishing step: " + result.getName() + " ====");
    }
}
