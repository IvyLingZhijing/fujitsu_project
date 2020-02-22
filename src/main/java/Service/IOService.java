package Service;

import Entities.Employee;

import java.util.List;
import java.util.Set;

public interface IOService {

    Set<Employee> importEmployeeFile(String path);

    void outputEmployees(List<Employee> employees);
}
