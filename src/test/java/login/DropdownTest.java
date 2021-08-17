package login;

import ProfessionPages.EmployeeSigninHU;
import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DropdownTest extends BaseTests {
    EmployeeSigninHU employeeSigninHU;
    //@Test
    public void testSelectWorkingStatus() throws InterruptedException {
        EmployeeSigninHU employeeSigninHU = homePage.clickMVRegisztracioLink();
        employeeSigninHU.selectWorkingStatus(userData.get("workingStatus"));
        List<String> selectedWorkingStatus = employeeSigninHU.getSelectedWorkingStatus();
        //Assertions.assertEquals(selectedWorkingStatus.size(), 1, "Incorrect number of selections!");
        Assertions.assertTrue(selectedWorkingStatus.contains(userData.get("workingStatus")));


        Thread.sleep(4000);

    }
}
