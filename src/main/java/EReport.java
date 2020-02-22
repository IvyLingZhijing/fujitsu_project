import Constants.CONSTANT;
import Entities.Employee;
import Service.IOService;
import Service.SortService;
import Service.impl.IOServiceImpl;
import Service.impl.SortServiceImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class EReport {

    public static void main(String[] args) {

        Path path = Paths.get(System.getProperty("user.dir"), args[0]);

        IOService ioService = new IOServiceImpl();
        Set<Employee> employeeSet = ioService.importEmployeeFile(path.toString());

        SortService sortService = new SortServiceImpl();
        List<Employee> employeeList = sortService.sortById(employeeSet);
        System.out.println("Processing by employee number...");
        ioService.outputEmployees(employeeList);
        System.out.println();

        employeeList = sortService.sortByLastName(employeeSet);
        System.out.println("Processing by last (family) Name...");
        ioService.outputEmployees(employeeList);
    }
}
