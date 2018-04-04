package cn.adbyte.activiti;

import cn.adbyte.jasperreports.Application;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void TestStartProcess() {

		/*ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService =processEngine.getRepositoryService();
		RuntimeService runtimeService =processEngine.getRuntimeService();
		TaskService taskService =processEngine.getTaskService();

		Map<String, Object> variables = new HashMap<>();
		variables.put("applicantName", "John Doe");
		variables.put("email", "john.doe@activiti.com");
		variables.put("phoneNumber", "123456789");
		runtimeService.startProcessInstanceByKey("myProcess", variables);*/
	}
}
