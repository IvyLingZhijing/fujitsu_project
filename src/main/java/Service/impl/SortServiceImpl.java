package Service.impl;

import Entities.Employee;
import Service.SortService;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortServiceImpl implements SortService {

    @Override
    public List<Employee> sortById(Set<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByLastName(Set<Employee> employees) {
        return employees.stream().sorted(Comparator.comparing(Employee::getLastName))
                .collect(Collectors.toList());
    }
}
