package Service;

import Entities.Employee;

import java.util.List;
import java.util.Set;

public interface SortService {

    List<Employee> sortById(Set<Employee> employees);

    List<Employee> sortByLastName(Set<Employee> employees);
}
